package com.example.shftlab_test.domain.validaror

interface Validator<Data, Answer> {
    fun validate(data: Data): Answer
}