package com.example.wetherapii.module

import com.example.wetherapii.WeatherApi

class AppModule {

    fun provideApi(): WeatherApi{
        return Retrofit.Builder().baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(WeatherApi::class.java)
    }

}