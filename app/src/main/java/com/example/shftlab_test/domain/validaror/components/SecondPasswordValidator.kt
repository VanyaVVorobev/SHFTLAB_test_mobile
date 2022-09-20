package com.example.shftlab_test.domain.validaror.components

import com.example.shftlab_test.R
import com.example.shftlab_test.domain.validaror.Validator

class SecondPasswordValidator: Validator<Pair<String, String>, Int?> {
    override fun validate(data: Pair<String, String>): Int? {
        var res: Int? = null
        if (data.first != data.second) {
            res = R.string.second_password_incorrect
        }
        if (data.second.isEmpty()) {
            res = R.string.second_password_empty
        }
        return res
    }
}