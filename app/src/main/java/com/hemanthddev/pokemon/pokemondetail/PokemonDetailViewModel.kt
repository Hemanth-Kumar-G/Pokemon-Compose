package com.hemanthddev.pokemon.pokemondetail

import androidx.lifecycle.ViewModel
import com.hemanthddev.pokemon.data.remote.response.PokemonInfo
import com.hemanthddev.pokemon.repository.Repository
import com.hemanthddev.pokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonInfo> {
        return repository.getPokemonInfo(pokemonName = pokemonName)
    }
}