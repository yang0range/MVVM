package yang.cehome.com.mvvmdemo

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * @author yangzc
 *	@data 2018/11/2 11:59
 *	@desc
 *
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

    }

}