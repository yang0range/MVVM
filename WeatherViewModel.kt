package yang.cehome.com.mvvmdemo.viewmodel

/**
 * @author yangzc
 *	@data 2018/9/12 14:20
 *	@desc WeatherViewModel
 *
 */
//@Deprecated
//class WeatherViewModel(private val repo: PostRepo) {
//    /******data******/
//    val weatherinfo = ObservableField<String>()
//
//    /******binding******/
//    fun loadWeather() {
//        repo.getWeatherInfo()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ t: WeatherInfo? ->
//                    weatherinfo.set(t?.let { it.toString() })
//                }, { t: Throwable? ->
//                    weatherinfo.set(t?.message ?: "error")
//                })
//    }
//}