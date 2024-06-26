<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Post;

class PostController extends Controller {
    public function index(){
        $posts = Post::all();
        return view('main', compact('posts'));
    }

    public function create(){
        return view('create');
    }

    public function store(){
        $data = request()->validate([
            'title'=>'string',
            'content'=>'string',
            'image'=>'string',
        ]);
        
        Post::create($data);
        return redirect()->route('posts.index');
    }

    public function edit(Post $post){
        return view('edit', compact('post'));
    }

    public function update(Request $request, Post $post){
        $data = $request->validate([
            'title' => 'required|string',
            'content' => 'required|string',
            'image' => 'file|image',
        ]);

        if ($request->hasFile('image')) {
            $data['image'] = $request->file('image')->store('images', 'public');
        } else {
            unset($data['image']);
        }

        $post->update($data);

        return redirect()->route('posts.index');
    }

    public function destroy(Post $post){
        $post->delete();
        return redirect()->route('posts.index');
    }
}
