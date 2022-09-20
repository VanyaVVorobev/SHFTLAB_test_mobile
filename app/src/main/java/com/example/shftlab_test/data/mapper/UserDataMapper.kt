package com.example.shftlab_test.data.mapper

import com.example.shftlab_test.data.mapper.Mapper
import com.example.shftlab_test.data.model.UserDataDB
import com.example.shftlab_test.domain.model.UserData

class UserDataMapper: Mapper<UserDataDB, UserData> {
    override fun mapToInternal(data: UserData): UserDataDB {
        return UserDataDB(
            id = data._id,
            firstName = data.firstName,
            lastName = data.lastName,
            birthDate = data.birthDate,
            password = data.password
        )
    }

    override fun mapToExternal(data: UserDataDB): UserData {
        return UserData(
            _id = data.id,
            firstName = data.firstName,
            lastName = data.lastName,
            birthDate = data.birthDate,
            password = data.password
        )
    }
}