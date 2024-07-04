<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>create post</title>
</head>
<body>
    <h1>create a post</h1>
    <form action="{{ route('posts.store') }}" method='post'>
        @csrf
        <label for="title">title</label>
        <input type="text" id="title" name="title" required>
        
        <br><br>

        <label for="content">content</label>
        <textarea id="content" name="content" required></textarea>
        
        <br><br>

        <label for="image">image</label>
        <input type="file" id="image" name="image" required><br><br>

        <button type="submit">create post</button>
    </form>
</body>
</html>
