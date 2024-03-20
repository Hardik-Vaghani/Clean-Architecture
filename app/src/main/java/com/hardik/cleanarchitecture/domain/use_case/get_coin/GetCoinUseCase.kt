package com.hardik.cleanarchitecture.domain.use_case.get_coin

import com.hardik.cleanarchitecture.common.Resource
import com.hardik.cleanarchitecture.data.remote.dto.toCoin
import com.hardik.cleanarchitecture.data.remote.dto.toCoinDetail
import com.hardik.cleanarchitecture.domain.model.Coin
import com.hardik.cleanarchitecture.domain.model.CoinDetail
import com.hardik.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository : CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()// data CoinDetailDto to CoinDetail transfer here
            emit(Resource.Success<CoinDetail>(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}