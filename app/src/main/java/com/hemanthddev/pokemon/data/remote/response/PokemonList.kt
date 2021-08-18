package com.hemanthddev.pokemon.data.remote.response


import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("count")
    var count: Int?,
    @SerializedName("next")
    var next: String?,
    @SerializedName("previous")
    var previous: Any?,
    @SerializedName("results")
    var results: List<Result?>?
)

data class Result(
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?
)
