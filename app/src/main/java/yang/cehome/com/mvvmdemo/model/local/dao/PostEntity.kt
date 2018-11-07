package yang.cehome.com.mvvmdemo.model.local.dao

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author yangzc
 *	@data 2018/11/7 10:23
 *	@desc 创建Post的Entity
 *
 */
@Entity
data class PostEntity(
    val message: String,
    @PrimaryKey
    val nu: String,
    val ischeck: String,
    val condition: String,
    val com: String,
    val status: String,
    val state: String
)