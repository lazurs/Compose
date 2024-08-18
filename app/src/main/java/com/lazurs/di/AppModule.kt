package com.lazurs.di

import com.lazurs.data.api.ApiService
import com.lazurs.data.datasource.ArticleListDataSource
import com.lazurs.data.datasource.ArticleListDataSourceImp
import com.lazurs.base.Constants
import com.lazurs.ui.repository.WanAndroidRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Author: lazurs
 * Date: 2024-08-15
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    fun providerBaseUrl(): String {
        return Constants.BASE_URL
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val httpClient = OkHttpClient().newBuilder()
        httpClient.addInterceptor(logInterceptor)
        return httpClient.build()
    }


    @Provides
    @Singleton
    fun provideConvertFactor(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        converter: Converter.Factory,
        baseUrl: String
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(client).addConverterFactory(converter)
            .build()
    }

    @Provides
    @Singleton
    fun providerApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerArticleDataSource(
        apiService: ApiService
    ): ArticleListDataSource {
        return ArticleListDataSourceImp(apiService)
    }

    @Provides
    @Singleton
    fun providerArticleRepo(dataSource: ArticleListDataSource): WanAndroidRepository {
        return WanAndroidRepository(dataSource)
    }
}