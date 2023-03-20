package com.example.newsapptest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsapptest.models.Article

@Database(entities = [Article::class], version = 1)
abstract class ArticleDatabase: RoomDatabase(){

    abstract fun getArticleDao(): ArticleDao

//    companion object {
//        @Volatile
//        private var instance: ArticleDatabase? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: createDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun createDatabase(context: Context): ArticleDatabase {
//            return Room.databaseBuilder(
//                context.applicationContext,
//                ArticleDatabase::class.java,
//                "article_database"
//            ).build()
//        }
//    }
}