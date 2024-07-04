<?php

use App\Http\Controllers\PostController;
use App\Http\Controllers\PostResourceController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\WeatherController;

Route::get("/", function () {
    return view("welcome");
});

Route::resource('posts', PostResourceController::class)->only(['index', 'edit']);

// Route::get('/blog', [PostController::class, 'index'])->name('posts.index');
// Route::get('/blog/create', [PostController::class, 'create'])->name('posts.create');

// Route::post('/blog', [PostController::class, 'store'])->name('posts.store');

// Route::get('/blog/{post}/edit', [PostController::class, 'edit'])->name('posts.edit');

// Route::put('/blog/{post}', [PostController::class, 'update'])->name('posts.update');

// Route::delete('/blog/{post}', [PostController::class, 'destroy'])->name('posts.destroy');

// Route::get('/weather', [WeatherController::class, 'show']);//->name('weather.show');