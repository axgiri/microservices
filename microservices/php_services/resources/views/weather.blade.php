<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>weather</title>
</head>
<body>
    <h1>weather in {{ $cityName }}</h1>
    <p>current temperature is  {{ $weatherData['main']['temp'] }} celsius degrees</p>
    <p>weather description is {{ $weatherData['weather'][0]['description'] }}</p>

    <form action="{{ route('weather.show') }}" method="GET">
        @csrf
        <label for="city">enter city</label>
        <input type="text" id="city" name="city" required>
        <button type="submit">submit</button>
    </form>
</body>
</html>
