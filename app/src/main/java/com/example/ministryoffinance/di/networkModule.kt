package com.example.ministryoffinance.di

import com.example.ministryoffinance.data.api.client.KtorClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {

    single<String>(qualifier = named("baseUrl")) {"http://localhost:3000"}

    single { KtorClient().client }

}