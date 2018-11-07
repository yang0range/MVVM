package yang.cehome.com.mvvmdemo.model.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

/**
 * @author yangzc
 *	@data 2018/11/5 17:40
 *	@desc PostDao
 *
 */
@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetAll(postinfo: List<PostEntity>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserttPost(postinfo: PostEntity)

    @Query("SELECT * FROM postentity")
    fun getPostInfo(): Single<PostEntity>

}