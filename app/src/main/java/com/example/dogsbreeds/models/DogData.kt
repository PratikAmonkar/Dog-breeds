package com.example.dogsbreeds.models

data class DogImage(
    val id: String,
    val url: String,
    val breeds: List<DogBreed>,
    val width: Int,
    val height: Int
)

data class DogBreed(
    val weight: Weight,
    val height: Height,
    val id: Int,
    val name: String,
    val country_code: String? = null, // Make it nullable if it's optional
    val bred_for: String? = null,     // Make it nullable if it's optional
    val breed_group: String? = null,  // Make it nullable if it's optional
    val life_span: String,
    val temperament: String,
    val origin: String? = null,        // Make it nullable if it's optional
    val description: String? = null,   // Make it nullable if it's optional
    val reference_image_id: String
)

data class Weight(
    val imperial: String,
    val metric: String
)

data class Height(
    val imperial: String,
    val metric: String
)
