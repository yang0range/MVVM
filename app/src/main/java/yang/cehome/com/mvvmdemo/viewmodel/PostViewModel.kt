package yang.cehome.com.mvvmdemo.viewmodel

import android.databinding.ObservableField
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yang.cehome.com.mvvmdemo.model.local.dao.PostEntity
import yang.cehome.com.mvvmdemo.model.repository.PostRepo

/**
 * @author yangzc
 *	@data 2018/11/7 10:26
 *	@desc  PostViewModel
 *
 */
class PostViewModel(private val repo: PostRepo) {
    /******data******/
    val postinfo = ObservableField<String>()

    /******binding******/
    fun loadpost() {
        repo.getPostInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: PostEntity? ->
                    postinfo.set(t?.let { it.toString() })
                }, { t: Throwable? ->
                    postinfo.set(t?.message ?: "error")
                })
    }
}