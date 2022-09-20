package com.example.shftlab_test.domain.model

data class RegistrationResult(
    var isValidationSuccess: Boolean,
    val firstNameErrID: Int?,
    val lastNameErrID: Int?,
    val birthDateErrID: Int?,
    val passwordErrID: Int?,
    val secondPasswordErrID: Int?
)
