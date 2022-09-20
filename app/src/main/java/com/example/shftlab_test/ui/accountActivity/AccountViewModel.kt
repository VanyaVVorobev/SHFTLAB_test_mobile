package com.example.shftlab_test.ui.accountActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shftlab_test.domain.model.Account
import com.example.shftlab_test.domain.useCase.GetAccountsUC
import com.example.shftlab_test.domain.useCase.SaveCurrentUserIdUC
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AccountViewModel(
    private val getAccountsUC: GetAccountsUC,
    private val saveCurrentUserIdUC: SaveCurrentUserIdUC
): ViewModel() {

    private val accountsLive = MutableLiveData<Array<Account>>()
    val accounts: LiveData<Array<Account>> = accountsLive

    override fun onCleared() {
        super.onCleared()
    }

    suspend fun getAccounts() {
        val res: Array<Account>
        withContext(Dispatchers.IO) {
            res = getAccountsUC.execute()
        }
        withContext(Dispatchers.Main) {
            accountsLive.value = res
        }
    }

    suspend fun saveCurrentUserId(id: Int) {
        withContext(Dispatchers.IO){
            saveCurrentUserIdUC.execute(id)
        }
    }
}