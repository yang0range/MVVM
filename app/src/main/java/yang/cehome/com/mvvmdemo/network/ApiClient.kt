package yang.cehome.com.mvvmdemo.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author yangzc
 *	@data 2018/11/9 14:32
 *	@desc ApiClient 这样就保证了全局只有一个retrofit对象
 *
 */
class ApiClient {
    //这里我们可以控制URL 改变URL为测试/线上环境URL
    private val BASE_URL = "https://api.douban.com/v2/movie/"
    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .client(InternalOkHttpClient.getOkhttpClient())
                .build()
    }


}