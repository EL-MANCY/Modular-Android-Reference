package com.elmancy.feature.jsonplaceholderService.di

import com.elmancy.feature.jsonplaceholderService.BuildConfig
import com.elmancy.feature.jsonplaceholderService.data.api.JsonPlaceholderService
import com.elmancy.network.data.retrofit.RetrofitNetworkClient
import com.elmancy.network.domain.NetworkClient
import com.elmancy.network.domain.NetworkConfig
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.elmancy.feature.jsonplaceholder")
class JsonPlaceholderModule {

    @Single
    fun provideNetworkConfig(): NetworkConfig {
        return NetworkConfig(
            baseUrl = "https://jsonplaceholder.typicode.com/",
            debug = BuildConfig.DEBUG
        )
    }

    @Single
    fun provideNetworkClient(config: NetworkConfig): NetworkClient {
        return RetrofitNetworkClient(config)
    }

    @Single
    fun provideService(retrofitNetworkClient: RetrofitNetworkClient): JsonPlaceholderService {
        return retrofitNetworkClient.createService(JsonPlaceholderService::class.java)
    }
}
