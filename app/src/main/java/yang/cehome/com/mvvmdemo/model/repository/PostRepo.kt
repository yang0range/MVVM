package yang.cehome.com.mvvmdemo.model.repository

import yang.cehome.com.mvvmdemo.model.local.dao.PostDao
import yang.cehome.com.mvvmdemo.model.remote.PostService

/**
 * @author yangzc
 *	@data 2018/11/6 11:55
 *	@desc PostRepo
 *
 */
class PostRepo  constructor(private val remote: PostService, private val local: PostDao){
    //首先查看本地数据库是否有数据
   fun getPostInfo() = local.getPostInfo()
           .onErrorResumeNext {
               //本地数据库不存在，会抛出会抛出EmptyResultSetException
               //转而进行获取网络数据，成功后保存在数据库
               remote.getPostInfo().doOnSuccess { local.inserttPost(it) }
           }
}