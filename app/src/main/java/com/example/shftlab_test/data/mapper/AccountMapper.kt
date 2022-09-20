package com.example.shftlab_test.data.mapper

import com.example.shftlab_test.data.model.AccountDB
import com.example.shftlab_test.domain.model.Account

class AccountMapper : Mapper<AccountDB, Account> {
    override fun mapToInternal(data: Account): AccountDB {
        return AccountDB(
            id = data._id,
            name = data.name
        )
    }

    override fun mapToExternal(data: AccountDB): Account {
        return Account(
            _id = data.id,
            name = data.name
        )
    }
}