package com.example.shftlab_test.data.repository

import com.example.shftlab_test.data.storage.sharedPrefs.SharedPrefs
import com.example.shftlab_test.data.storage.sharedPrefs.userId.CurrentUserIdSharedPrefs
import com.example.shftlab_test.domain.repository.CurrentUserIdRepository

class CurrentUserIdRepositoryImpl(private val sharedPrefs: SharedPrefs<Int, Int>): CurrentUserIdRepository {
    override fun get(): Int {
        return sharedPrefs.get()
    }

    override fun save(id: Int) {
        sharedPrefs.save(id)
    }
}