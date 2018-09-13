package yang.cehome.com.mvvmdemo.viewmodel

import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yang.cehome.com.mvvmdemo.model.data.WeatherInfoData
import yang.cehome.com.mvvmdemo.model.remote.WeatherService

/**
 * @author yangzc
 *	@data 2018/9/12 14:20
 *	@desc WeatherViewModel
 *
 */
class WeatherViewModel(val remote: WeatherService) {
    /******data******/
    val weatherinfo = ObservableField<String>()

    /******binding******/
    fun loadWeather() {
        remote.getWeatherInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: WeatherInfoData? ->
                    weatherinfo.set(t?.let { it.weatherinfo.toString() })
                }, { t: Throwable? ->
                    weatherinfo.set(t?.message ?: "error")
                })
    }
}