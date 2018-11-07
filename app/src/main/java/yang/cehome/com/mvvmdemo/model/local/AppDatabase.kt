package yang.cehome.com.mvvmdemo.model.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import yang.cehome.com.mvvmdemo.model.local.dao.PostDao
import yang.cehome.com.mvvmdemo.model.local.dao.PostEntity

/**
 * @author yangzc
 *	@data 2018/11/5 18:21
 *	@desc 包含所有Entity以及操作它们的 DAO
 *
 */
@Database(entities = arrayOf(PostEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun PostDao(): PostDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "app.db")
                        .build()
    }
}
