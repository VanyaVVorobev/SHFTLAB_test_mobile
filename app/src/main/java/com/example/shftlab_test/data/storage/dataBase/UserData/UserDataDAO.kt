package com.example.shftlab_test.data.storage.dataBase.UserData

import androidx.room.*
import com.example.shftlab_test.data.model.UserDataDB

@Dao
interface UserDataDAO {
    @Insert
    fun saveUserData(data: UserDataDB)

    @Update
    fun updateUserData(data: UserDataDB)

    @Delete
    fun deleteUserData(data: UserDataDB)

    @Query("SELECT * FROM user_data_table WHERE id = (:id)")
    fun getUserData(id: Int): UserDataDB

    @Query("SELECT MAX(id) FROM user_data_table")
    fun getMaxId(): Int
}