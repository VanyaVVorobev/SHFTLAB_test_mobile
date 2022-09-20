package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.domain.model.Account
import com.example.shftlab_test.domain.repository.AccountRepository

class GetAccountsUC(private val repository: AccountRepository) {
    fun execute(): Array<Account> {
        return repository.get()
    }
}