package com.hardik.cleanarchitecture.presentation.coin_list

import com.hardik.cleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
