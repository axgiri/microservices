<?php

namespace App\Http\Controllers;

use App\Http\Requests\PostRequest;
use App\Models\Post;
use App\Service\PostService;

class PostResourceController extends Controller {
    
    public function __construct(PostService $postService){
        $this->postService = $postService; 
    }
    protected $postService;
    public function index(){
        // $posts = Post::all();
        $posts = $this -> postService->getAll();
        return view('main', compact('posts'));
    }

    public function create(){
        return view('create');
    }

    public function store(PostRequest $request){
        $data = $request->validated();
        // Post::create($data);
        $data['image'] = $request->file('image');
        $this -> postService->storePost($data);
        return redirect()->route('posts.index');
    }

    public function show(string $id)
    {
        //
    }

    public function edit(Post $post){
        return view('edit', compact('post'));
    }

    public function update(PostRequest $request, $id) {
        $data = $request->validated();
        $this->postService->updatePost($id, $data);
        return redirect()->route('posts.index');
    }

    public function destroy(Post $post){
        $post->delete();
        return redirect()->route('posts.index');
    }
}