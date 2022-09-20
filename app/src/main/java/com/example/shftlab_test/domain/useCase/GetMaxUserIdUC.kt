package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.data.repository.UserDataRepositoryImpl

class GetMaxUserIdUC(private val repository: UserDataRepositoryImpl) {
    fun execute(): Int {
        return repository.getMaxId()
    }
}