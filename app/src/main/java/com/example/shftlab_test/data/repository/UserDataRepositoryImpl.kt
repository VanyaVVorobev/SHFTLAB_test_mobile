package com.example.shftlab_test.data.repository

import com.example.shftlab_test.data.mapper.UserDataMapper
import com.example.shftlab_test.data.model.UserDataDB
import com.example.shftlab_test.data.storage.dataBase.UserData.UserDataDAO
import com.example.shftlab_test.domain.model.UserData
import com.example.shftlab_test.domain.repository.UserDataRepository

class UserDataRepositoryImpl(private val dao: UserDataDAO): UserDataRepository {
    override fun get(id: Int): UserData {
        var res = dao.getUserData(id = id)
        if(res == null) res = UserDataDB(0, "", "", "", "")
        return UserDataMapper().mapToExternal(res)
    }

    override fun getMaxId(): Int {
        return dao.getMaxId()
    }

    override fun save(data: UserData) {
        dao.saveUserData(UserDataMapper().mapToInternal(data = data))
    }
}