package com.example.wetherapii.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wetherapii.model.AppModel
import com.example.wetherapii.presenter.presenter
import com.example.wetherapii.view.WeatherView

class ResultFragment : Fragment(),WeatherView {

    @Inject
    lateinit var weatherPresenter:presenter

    var lon:Double=0.0
    var lat:Double=0.0
    var units:String=""


    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherPresenter.atachView(this)
        lon= arguments?.getDouble("keyLon")!!
        lat= arguments?.getDouble("keyLat")!!
        units= arguments?.getString("keyUnits").toString()
        weatherPresenter.getWeatherDetails(lon, lat, units)

    }

    override fun showWeather(model:AppModel) {
        with(binding){
            numberMax.text=model.main.temp_max.toString()+"°"
            numberMin.text=model.main.temp_min.toString()+"°"
            degree.text=model.main.temp.toString()+"°"
            cityName.text=model.name
        }

    }

    override fun showWeatherError(massage: String) {
        Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
    }

}