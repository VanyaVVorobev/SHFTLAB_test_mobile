package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.domain.model.Account
import com.example.shftlab_test.domain.repository.AccountRepository

class SaveAccountUC(private val repository: AccountRepository) {
    fun execute(data: Account) {
        repository.save(data)
    }
}