<?php

namespace App\Http\Controllers;

use App\Http\Requests\PostRequest;
use App\Models\Post;
use Illuminate\Support\Facades\Log;

class PostController extends Controller {
    public function index(){
        $posts = Post::all();
        return view('main', compact('posts'));
    }

    public function create(){
        return view('create');
    }

    public function store(){
        $data = request()->validated();
        Log::info($data);
        Post::create($data);
        return redirect()->route('posts.index');
    }

    public function edit(Post $post){
        return view('edit', compact('post'));
    }

    public function update(PostRequest $request){
        Log::info($request->validated());
        $data = $request->validated();
        $request->validated();
        $request->all();

        if ($request->hasFile('image')) {
            $data['image'] = $request->file('image')->store('images', 'public');
        }

        // $post->update($data);

        return redirect()->route('posts.index');
    }

    public function destroy(Post $post){
        $post->delete();
        return redirect()->route('posts.index');
    }
}