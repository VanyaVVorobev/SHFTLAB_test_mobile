package com.example.shftlab_test.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "account_table",
)
data class AccountDB(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String
)
