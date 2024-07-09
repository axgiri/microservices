<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class PostRequest extends FormRequest {
    public function authorize(): bool {
        return true;
    }
    
    public function rules(): array {
        return [
            'id' => 'sometimes',
            'title' => 'required|string',
            'content' => 'required|string',
            'image' => 'file|image',
        ];
    }
}