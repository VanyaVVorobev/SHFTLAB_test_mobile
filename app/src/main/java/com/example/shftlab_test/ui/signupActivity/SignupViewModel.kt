package com.example.shftlab_test.ui.signupActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shftlab_test.domain.model.Account
import com.example.shftlab_test.domain.model.RegistrationData
import com.example.shftlab_test.domain.model.RegistrationResult
import com.example.shftlab_test.domain.model.UserData
import com.example.shftlab_test.domain.useCase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class SignupViewModel(
    private val getMaxUserIdUC: GetMaxUserIdUC,
    private val saveUserDataUC: SaveUserDataUC,
    private val saveAccountUC: SaveAccountUC,
    private val validateDataUC: ValidateDataUC,
    private val saveCurrentUserIdUC: SaveCurrentUserIdUC
): ViewModel() {

    private val maxUserIdLive = MutableLiveData<Int>()
    val maxUserId: LiveData<Int> = maxUserIdLive

    private val registrationResultLive = MutableLiveData<RegistrationResult>()
    val registrationResult: LiveData<RegistrationResult> = registrationResultLive

    override fun onCleared() {
        super.onCleared()
    }

    suspend fun getMaxUserId() {
        val res: Int
        withContext(Dispatchers.IO) {
            res = getMaxUserIdUC.execute()
        }
        withContext(Dispatchers.Main) {
            maxUserIdLive.value = res
        }
    }

    suspend fun saveAccount(account: Account) {
        withContext(Dispatchers.IO) {
            saveAccountUC.execute(account)
        }
    }

    suspend fun saveUserData(data: UserData) {
        withContext(Dispatchers.IO) {
            saveUserDataUC.execute(data)
        }
    }

    suspend fun validateRegistration(data: RegistrationData) {
        val res: RegistrationResult
        withContext(Dispatchers.IO) {
            res = validateDataUC.execute(data)
        }
        withContext(Dispatchers.Main) {
            registrationResultLive.value = res
        }
    }

    suspend fun saveCurrentUserId(id: Int) {
        withContext(Dispatchers.IO){
            saveCurrentUserIdUC.execute(id)
        }
    }
}