package com.example.shftlab_test.domain.validaror.components

import com.example.shftlab_test.R
import com.example.shftlab_test.domain.validaror.Validator

class LastNameValidator: Validator<String, Int?> {
    override fun validate(data: String): Int? {
        var res: Int? = null
        if (data.isEmpty()) {
            res = R.string.last_name_empty
        }
        return res
    }
}