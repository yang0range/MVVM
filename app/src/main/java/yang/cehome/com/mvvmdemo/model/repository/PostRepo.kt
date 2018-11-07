package yang.cehome.com.mvvmdemo.model.repository

import yang.cehome.com.mvvmdemo.model.local.dao.PostDao
import yang.cehome.com.mvvmdemo.model.remote.PostService

/**
 * @author yangzc
 *	@data 2018/11/6 11:55
 *	@desc WeatherRepo
 *
 */
class PostRepo  constructor(private val remote: PostService, private val local: PostDao){
    //
   fun getPostInfo() = local.getPostInfo()
           .onErrorResumeNext { remote.getPostInfo().doOnSuccess { local.inserttPost(it) }
           }
}