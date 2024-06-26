<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Posts</title>
</head>
<body>
    @csrf
    <h1>all posts</h1>
    @foreach ($posts as $post)
        <div>
            <h2>{{ $post->title }}</h2>
            <p>{{ $post->content }}</p>
            <img src="{{ asset('storage/' . $post->image) }}" alt="">
            <form action="{{ route('posts.destroy', $post) }}" method="POST">
                @csrf
                @method('DELETE')
                <button type="submit">delete</button>
            </form>
            <a href="{{ route('posts.edit', $post) }}">edit</a>
        </div>
    @endforeach
    <h1>create post</h1>
    <a href="{{ route('posts.create') }}">create post</a>
</body>
</html>
