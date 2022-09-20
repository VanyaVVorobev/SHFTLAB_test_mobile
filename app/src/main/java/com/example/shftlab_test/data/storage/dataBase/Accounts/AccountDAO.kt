package com.example.shftlab_test.data.storage.dataBase.Accounts

import androidx.room.*
import com.example.shftlab_test.data.model.AccountDB

@Dao
interface AccountDAO {
    @Insert
    fun saveAccount(account: AccountDB)

    @Update
    fun updateAccount(account: AccountDB)

    @Delete
    fun deleteAccount(account: AccountDB)

    @Query("SELECT * FROM account_table ORDER BY id")
    fun getAll(): Array<AccountDB>

}