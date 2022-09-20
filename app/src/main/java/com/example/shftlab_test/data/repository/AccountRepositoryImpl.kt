package com.example.shftlab_test.data.repository

import com.example.shftlab_test.data.mapper.AccountMapper
import com.example.shftlab_test.data.mapper.ArrayOfAccountMapper
import com.example.shftlab_test.data.storage.dataBase.Accounts.AccountDAO
import com.example.shftlab_test.domain.model.Account
import com.example.shftlab_test.domain.repository.AccountRepository

class AccountRepositoryImpl(private val dao: AccountDAO): AccountRepository {
    override fun get(): Array<Account> {
        return ArrayOfAccountMapper().mapToExternal(dao.getAll())
    }

    override fun save(data: Account) {
        dao.saveAccount(AccountMapper().mapToInternal(data))
    }
}