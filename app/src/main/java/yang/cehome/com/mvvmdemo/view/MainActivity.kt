package yang.cehome.com.mvvmdemo.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import yang.cehome.com.mvvmdemo.R
import yang.cehome.com.mvvmdemo.databinding.ActivityMainBinding
import yang.cehome.com.mvvmdemo.model.Onclick
import yang.cehome.com.mvvmdemo.viewmodel.OnclikViewModel

/**
 * MVVM 当中的一个V层 将三者联系起来
 */
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mViewMode: OnclikViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        /////model
        val onclick = Onclick("me", 0)
        ///ViewModel
        mViewMode = OnclikViewModel(onclick)
        ///binding
        mBinding.vm = mViewMode
    }
}
