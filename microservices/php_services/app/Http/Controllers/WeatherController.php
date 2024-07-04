<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class WeatherController extends Controller{
    public function show(Request $request) {
        $city = $request->input('city', 'Almaty');
        $response = Http::get(config('services.weather.api'), [
            'q' => $city,
            'appid' => config('services.weather.api_key'),
            'units' => 'metric',
        ]);

        $weatherData = $response->json();

        return response()->json([
            'city' => $weatherData['name'] ?? 'unknown',
            'temperature' => $weatherData['main']['temp'] ?? 'unknown',
            'description' => $weatherData['weather'][0]['description'] ?? 'unknown',
        ]);
    }
}