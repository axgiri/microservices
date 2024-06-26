<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateCsrfTokensTable extends Migration {
    public function up() {
        Schema::create('csrf_tokens', function (Blueprint $table) {
            $table->id();
            $table->string('token');
            $table->timestamps();
        });
    }

    public function down() {
        Schema::dropIfExists('csrf_tokens');
    }
}
