package com.example.shftlab_test.domain.repository

interface CurrentUserIdRepository {
    fun get(): Int
    fun save(id: Int)
}