package yang.cehome.com.mvvmdemo.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import yang.cehome.com.mvvmdemo.R
import yang.cehome.com.mvvmdemo.databinding.ActivityMainBinding
import yang.cehome.com.mvvmdemo.model.data.Onclick
import yang.cehome.com.mvvmdemo.model.remote.WeatherService
import yang.cehome.com.mvvmdemo.viewmodel.OnclikViewModel
import yang.cehome.com.mvvmdemo.viewmodel.WeatherViewModel




/**
 * MVVM 当中的一个V层 将三者联系起来
 */
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewMode: OnclikViewModel
    private lateinit var mViewMode2: WeatherViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /////model
        val onclick = Onclick("me", 0)
        ///ViewModel
        mViewMode = OnclikViewModel(onclick)
        ///binding

        val client = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        val remote = Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(WeatherService::class.java)


        mViewMode2 = WeatherViewModel(remote)
        mBinding.vm = mViewMode
        mBinding.remote = mViewMode2
    }
}
