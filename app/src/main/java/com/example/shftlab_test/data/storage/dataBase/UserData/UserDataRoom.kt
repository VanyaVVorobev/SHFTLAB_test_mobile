package com.example.shftlab_test.data.storage.dataBase.UserData

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shftlab_test.data.model.UserDataDB

@Database(entities = [UserDataDB::class], version = 1, exportSchema = false)
abstract class UserDataRoom: RoomDatabase() {
    abstract fun userDataDAO(): UserDataDAO

    companion object{
        @Volatile
        private var INSTANCE: UserDataRoom? = null

        fun getDataBase(context: Context): UserDataRoom {
            if(INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        UserDataRoom::class.java,
                        "user_data_db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}