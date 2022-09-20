package com.example.shftlab_test.domain.useCase

import com.example.shftlab_test.domain.model.RegistrationData
import com.example.shftlab_test.domain.model.RegistrationResult
import com.example.shftlab_test.domain.validaror.Validator

class ValidateDataUC(private val validator: Validator<RegistrationData, RegistrationResult>) {
    fun execute(data: RegistrationData): RegistrationResult {
        return validator.validate(data = data)
    }
}