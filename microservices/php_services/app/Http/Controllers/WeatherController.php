<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class WeatherController extends Controller{
    public function show(Request $request) {
        $city = $request->input('city', 'Almaty');
        $apiKey = env('API_KEY');
        $response = Http::get('http://api.openweathermap.org/data/2.5/weather', [
            'q' => $city,
            'appid' => $apiKey,
            'units' => 'metric',
        ]);


        $weatherData = $response->json();
        if (isset($weatherData['name'])) {
            $cityName = $weatherData['name'];
        } else {
            $cityName = 'unknown';
        }

        return view('weather', compact('weatherData', 'cityName'));
    }
}