package yang.cehome.com.mvvmdemo.model.remote
import io.reactivex.Single
import retrofit2.http.GET
import yang.cehome.com.mvvmdemo.model.data.WeatherInfoData

/**
 * @author yangzc
 *	@data 2018/9/11 18:13
 *	@desc WeatherService
 *
 */
interface WeatherService {
    //获取天气
    @GET("/data/sk/101190408.html")
    fun getWeatherInfo(): Single<WeatherInfoData>

}