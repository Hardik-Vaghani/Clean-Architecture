package com.hardik.cleanarchitecture.presentation.coin_detail

import com.hardik.cleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
