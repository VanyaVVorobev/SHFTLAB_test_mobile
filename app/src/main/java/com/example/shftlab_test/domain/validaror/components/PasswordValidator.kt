package com.example.shftlab_test.domain.validaror.components

import com.example.shftlab_test.R
import com.example.shftlab_test.domain.validaror.Validator

class PasswordValidator: Validator<String, Int?> {
    override fun validate(data: String): Int? {
        var res: Int? = null
        if (!isCorrectPassword(data)) {
            res = R.string.password_incorrect
        }
        if (data.length < 8) {
            res = R.string.password_is_short
        }
        return res
    }

    private fun isCorrectPassword(password: String): Boolean {
        var res = true
        if (!password.contains(Regex("""[A-Z]"""))) {
            res = false
        }
        if (!password.contains(Regex("""[a-z]"""))) {
            res = false
        }
        if (!password.contains(Regex("""[0-9]"""))) {
            res = false
        }
        return res
    }
}