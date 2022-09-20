package com.example.shftlab_test.domain.validaror.components

import com.example.shftlab_test.R
import com.example.shftlab_test.domain.validaror.Validator


class BirthDateValidator: Validator<String, Int?> {
    override fun validate(data: String): Int? {
        var res: Int? = null
        if (!isCorrectDate(data)) {
            res = R.string.date_of_birth_incorrect
        }
        if (data.isEmpty()) {
            res = R.string.date_of_birth_empty
        }
        return res
    }

    private fun isCorrectDate(date: String): Boolean {
        var res = true
        if (!date.matches(Regex("""[0-3][0-9][\\|/:.](0[0-9]|1[012])[\\|/:.](19[0-9]{2}|20([01][0-9]|2[012]))"""))) {
            res = false
        }
        return res
    }
}