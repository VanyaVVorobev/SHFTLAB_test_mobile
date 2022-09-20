package com.example.shftlab_test.data.storage.sharedPrefs.userId

import android.content.Context
import com.example.shftlab_test.data.storage.sharedPrefs.SharedPrefs


private const val CURRENT_USER_ID_SP = "current_user_id_sp"
private const val ID_SP_KEY = "id_sp_key"

class CurrentUserIdSharedPrefs(context: Context): SharedPrefs<Int, Int> {
    private val sharedPreferences = context.getSharedPreferences(CURRENT_USER_ID_SP, Context.MODE_PRIVATE)

    override fun get(): Int {
        return sharedPreferences.getInt(ID_SP_KEY, 0)
    }

    override fun save(data: Int) {
        sharedPreferences.edit()
            .putInt(ID_SP_KEY, data)
            .apply()
    }
}