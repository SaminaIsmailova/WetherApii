package com.example.wetherapii

import com.example.wetherapii.model.AppModel

interface WeatherApi {

    @GET("data/2.5/weather")
    fun getWeather(
        @Query("lon") lon:Double,
        @Query("lat")lat:Double,
        @Query("units") name:String,
        @Query("appid") key:String="a6724a258918d9e10ad2c5cc3fb8194e"
    ):Call<AppModel>
}