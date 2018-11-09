package yang.cehome.com.mvvmdemo.model.remote

import io.reactivex.Single
import retrofit2.http.GET
import yang.cehome.com.mvvmdemo.model.local.dao.PostEntity

/**
 * @author yangzc
 *	@data 2018/9/11 18:13
 *	@desc PostService
 *
 */
interface PostService {
    //获取天气
//    @GET("/data/sk/101190408.html")
//    fun getWeatherInfo(): Single<WeatherInfo<Weatherinfo>>


    //获取天气
//    @GET("/data/sk/101190408.html")
//    fun getWeatherInfos(): Single<Weatherinfo>


    //获取快递
    @GET("/query?type=yuantong&postid=112323")
    fun getPostInfo(): Single<PostEntity>

}