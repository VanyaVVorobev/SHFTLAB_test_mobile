package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.domain.model.UserData
import com.example.shftlab_test.domain.repository.UserDataRepository

class SaveUserDataUC(private val repository: UserDataRepository) {
    fun execute(data: UserData) {
        repository.save(data)
    }
}