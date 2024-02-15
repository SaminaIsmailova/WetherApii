package com.example.wetherapii.view

import com.example.wetherapii.model.AppModel

interface WeatherView {
    fun showWeather(appModel: AppModel)
    fun showWeatherError(massage:String)
}