package com.example.shftlab_test.data.storage.dataBase.Accounts

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shftlab_test.data.model.AccountDB

@Database(entities = [AccountDB::class], version = 1, exportSchema = false)
abstract class AccountRoom: RoomDatabase() {
    abstract fun accountDao(): AccountDAO

    companion object{
        @Volatile
        private var INSTANCE: AccountRoom? = null

        fun getDataBase(context: Context): AccountRoom {
            if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AccountRoom::class.java,
                        "account_db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}