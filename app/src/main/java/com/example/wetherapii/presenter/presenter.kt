package com.example.wetherapii.presenter

import android.telecom.Call
import com.example.wetherapii.WeatherApi
import com.example.wetherapii.model.AppModel
import com.example.wetherapii.view.WeatherView

class presenter @Inject constructor(private val api: WeatherApi) {
    lateinit var wetherView: WeatherView

    fun getWeatherDetails(lon: Double, lat: Double, units: String) {
        api.getWeather(lon, lat, units).enqueue(object : retrofit2.Callback<AppModel> {
            override fun onResponse(call: Call<AppModel>, response: Response<AppModel>) {
                response.body()?.let {
                    wetherView.showWeather(it)
                }
            }

            override fun onFailure(call: Call<AppModel>, t: Throwable) {
                wetherView.showWeatherError(t.message.toString())
            }

        })

    }

    fun atachView(view: WeatherView) {
        this.wetherView = view
    }
}