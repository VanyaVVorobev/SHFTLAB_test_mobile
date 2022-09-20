package com.example.shftlab_test.domain.validaror.components

import com.example.shftlab_test.R
import com.example.shftlab_test.domain.validaror.Validator

class FirstNameValidator: Validator<String, Int?> {
    override fun validate(data: String): Int? {
        var res: Int? = null
        if (data.isEmpty()) {
            res = R.string.first_name_empty
        }
        return res
    }
}