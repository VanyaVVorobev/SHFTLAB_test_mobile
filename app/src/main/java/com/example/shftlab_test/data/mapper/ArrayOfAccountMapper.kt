package com.example.shftlab_test.data.mapper

import com.example.shftlab_test.data.model.AccountDB
import com.example.shftlab_test.domain.model.Account

class ArrayOfAccountMapper : Mapper<Array<AccountDB>, Array<Account>> {
    override fun mapToInternal(data: Array<Account>): Array<AccountDB> {
        val res = Array(data.size) { AccountDB(0, "") }
        val mapper = AccountMapper()
        for(i in data.indices) {
            res[i] = mapper.mapToInternal(data[i])
        }
        return res
    }

    override fun mapToExternal(data: Array<AccountDB>): Array<Account> {
        val res = Array(data.size) { Account(0, "") }
        val mapper = AccountMapper()
        for(i in data.indices) {
            res[i] = mapper.mapToExternal(data[i])
        }
        return res
    }

}