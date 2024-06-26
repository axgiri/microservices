<?php

use App\Http\Controllers\PostController;
use Illuminate\Support\Facades\Route;

Route::get('/blog', [PostController::class, 'index'])->name('posts.index');
Route::get('/blog/create', [PostController::class, 'create'])->name('posts.create');

Route::post('/blog', [PostController::class, 'store'])->name('posts.store');

Route::get('/blog/{post}/edit', [PostController::class, 'edit'])->name('posts.edit');

Route::put('/blog/{post}', [PostController::class, 'update'])->name('posts.update');

Route::delete('/blog/{post}', [PostController::class, 'destroy'])->name('posts.destroy');
