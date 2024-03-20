package com.hardik.cleanarchitecture.data.repository

import com.hardik.cleanarchitecture.data.remote.CoinPaprikaApi
import com.hardik.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.hardik.cleanarchitecture.data.remote.dto.CoinDto
import com.hardik.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
       return coinPaprikaApi.getCoinById(coinId)
    }
}