<?php

namespace App\Service;

use App\Models\Post;

class PostService{
    public function getAll(){
        return Post::all();
    }

    public function updatePost($id, $data){
        $post = Post::find($id)->update($data);
        return $post;
    }

    public function storePost($data){
        $imagePath = $data['image']->store(storage_path('app/public'));
        $data['image']= $imagePath;
        Post::create($data);
    }

    public function deletePost(Post $post){
        $post->delete();    
    }

}