package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.domain.repository.CurrentUserIdRepository

class SaveCurrentUserIdUC(private val repository: CurrentUserIdRepository) {
    fun execute(id: Int) {
        return repository.save(id)
    }
}