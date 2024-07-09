<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit</title>
</head>
<body>
    <h1>edit</h1>
    <form action="{{ route('posts.update', [$post->id]) }}" method="post" enctype="multipart/form-data">
        @csrf
        @method('PUT')
        <input type="text" name="title" value="{{ $post->title }}">
        <br><br>
        <textarea name="content">{{ $post->content }}</textarea>
        <br><br> 
        <input type="file" name="image">
        <br><br>
        <button type="submit">update</button>
    </form>
</body>
</html>