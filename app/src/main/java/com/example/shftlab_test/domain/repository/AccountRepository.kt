package com.example.shftlab_test.domain.repository

import com.example.shftlab_test.domain.model.Account

interface AccountRepository {
    fun get(): Array<Account>
    fun save(data: Account)
}