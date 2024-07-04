<?php

use App\Http\Controllers\PostResourceController;
use App\Http\Controllers\WeatherController;
use Illuminate\Support\Facades\Route;

Route::get('/weather', [WeatherController::class, 'show']);
Route::resource('posts', PostResourceController::class)->except(['index','edit'])->names([
    'update' => 'posts.update'
]);