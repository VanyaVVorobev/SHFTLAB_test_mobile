package com.example.shftlab_test.domain.repository

import com.example.shftlab_test.domain.model.UserData


interface UserDataRepository {
    fun get(id: Int): UserData
    fun getMaxId(): Int
    fun save(data: UserData)
}