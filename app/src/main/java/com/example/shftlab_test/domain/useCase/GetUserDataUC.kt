package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.domain.model.UserData
import com.example.shftlab_test.domain.repository.UserDataRepository

class GetUserDataUC(private val repository: UserDataRepository) {
    fun execute(id: Int): UserData {
        return repository.get(id = id)
    }
}