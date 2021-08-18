package com.hemanthddev.pokemon.repository

import com.hemanthddev.pokemon.data.remote.ApiService
import com.hemanthddev.pokemon.data.remote.response.PokemonInfo
import com.hemanthddev.pokemon.data.remote.response.PokemonList
import com.hemanthddev.pokemon.util.Resource


class Repository constructor(val api: ApiService) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val data = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(data = data)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonInfo> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}