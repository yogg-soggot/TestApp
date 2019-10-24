package com.yoggsoggot.testapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(User::class),version = 1)
public abstract class UserRoomDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): UserRoomDatabase {
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "user_database"
                    ).addCallback(UserDataBaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class UserDataBaseCallback(
        private val scope: CoroutineScope
    ):RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {database -> scope.launch {
                populateDatabase(database.userDao())
                }
            }
        }


        suspend fun populateDatabase(userDao: UserDao){
            userDao.deleteAll()
            val user1 = User("Ivanov", "Alexey")
            userDao.insert(user1)
            val user2 = User("Poletkov", "Michail")
            userDao.insert(user2)
            val user3 = User("Machmetov", "Erzhan")
            userDao.insert(user3)
        }
    }

}