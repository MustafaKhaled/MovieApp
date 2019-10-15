package com.movieapp.kotlin.di


import com.movieapp.kotlin.BuildConfig
import com.movieapp.kotlin.data.remote.ApiServices
import com.movieapp.kotlin.data.repo.GetAllMoviesRepoImpl
import com.movieapp.kotlin.domain.repo.GetAllMoviesRepo
import com.movieapp.kotlin.domain.usecases.business.GetAllMoviesUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    single { createOkHttpClientInstancee() }
    single { createRetrofitClientInstance(get(), BuildConfig.BASE_URL) }
    single { createApiServiceInstance(get())}
    single { createGetAllMoviesRepoInstance(get()) }
    single { createGetAllMoviesUseCase(get()) }

}

fun createOkHttpClientInstancee(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofitClientInstance(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

    fun createApiServiceInstance(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)

    }

    fun createGetAllMoviesRepoInstance(apiServices: ApiServices): GetAllMoviesRepo {
        return GetAllMoviesRepoImpl(apiServices)
    }

    fun createGetAllMoviesUseCase(getAllMoviesRepo: GetAllMoviesRepo): GetAllMoviesUseCase {
        return GetAllMoviesUseCase(getAllMoviesRepo)
    }
