package com.example.shftlab_test.domain.validaror

import com.example.shftlab_test.domain.model.RegistrationData
import com.example.shftlab_test.domain.model.RegistrationResult

class RegistrationValidator(
    private val firstNameValidator: Validator<String, Int?>,
    private val lastNameValidator: Validator<String, Int?>,
    private val birthDateValidator: Validator<String, Int?>,
    private val passwordValidator: Validator<String, Int?>,
    private val secondPasswordValidator: Validator<Pair<String, String>, Int?>
): Validator<RegistrationData, RegistrationResult> {

    override fun validate(data: RegistrationData): RegistrationResult {
        val ans = RegistrationResult(
            isValidationSuccess = false,
            firstNameErrID = firstNameValidator.validate(data.firstName),
            lastNameErrID = lastNameValidator.validate(data.firstName),
            birthDateErrID = birthDateValidator.validate(data.birthDate),
            passwordErrID = passwordValidator.validate(data.password),
            secondPasswordErrID = secondPasswordValidator.validate(Pair(data.password, data.secondPassword))
        )

        ans.isValidationSuccess = ans.firstNameErrID == null &&
            ans.lastNameErrID == null &&
            ans.birthDateErrID == null &&
            ans.passwordErrID == null &&
            ans.secondPasswordErrID == null

        return ans
    }
}