package com.maxab.task.feature.currencies.domain.usecase

import com.maxab.task.core.arch.BaseUseCase
import com.maxab.task.core.network.Resource
import com.maxab.task.feature.currencies.data.entity.GetCurrenciesParam
import com.maxab.task.feature.currencies.domain.repo.CurrencyRepository
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(val currencyRepository: CurrencyRepository) :
    BaseUseCase<GetCurrenciesParam, Resource<List<>>> {
    override fun execute(input: String): GetCurrenciesParam {
        TODO("Not yet implemented")
    }
}