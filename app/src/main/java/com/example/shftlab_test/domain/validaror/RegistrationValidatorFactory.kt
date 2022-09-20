package com.example.shftlab_test.domain.validaror

import com.example.shftlab_test.domain.validaror.components.*

class RegistrationValidatorFactory {
    fun create(): RegistrationValidator {
        return RegistrationValidator(
            FirstNameValidator(),
            LastNameValidator(),
            BirthDateValidator(),
            PasswordValidator(),
            SecondPasswordValidator()
        )
    }
}