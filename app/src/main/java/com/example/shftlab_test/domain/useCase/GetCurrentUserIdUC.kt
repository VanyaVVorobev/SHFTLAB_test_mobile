package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.domain.repository.CurrentUserIdRepository

class GetCurrentUserIdUC(private val repository: CurrentUserIdRepository) {
    fun execute(): Int {
        return repository.get()
    }
}