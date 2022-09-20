package com.example.shftlab_test.ui.accountActivity

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shftlab_test.data.repository.AccountRepositoryImpl
import com.example.shftlab_test.data.repository.CurrentUserIdRepositoryImpl
import com.example.shftlab_test.data.storage.dataBase.Accounts.AccountRoom
import com.example.shftlab_test.data.storage.sharedPrefs.userId.CurrentUserIdSharedPrefs
import com.example.shftlab_test.domain.useCase.GetAccountsUC
import com.example.shftlab_test.domain.useCase.SaveCurrentUserIdUC

class AccountVMFactory(context: Context): ViewModelProvider.Factory {

    private val accountDao by lazy { AccountRoom.getDataBase(context).accountDao() }
    private val accountRepository by lazy { AccountRepositoryImpl(accountDao) }
    private val getAccountsUC by lazy { GetAccountsUC(accountRepository) }

    private val currentUserIdSharedPrefs by lazy { CurrentUserIdSharedPrefs(context) }
    private val currentUserIdRepositoryImpl by lazy { CurrentUserIdRepositoryImpl(currentUserIdSharedPrefs) }
    private val saveCurrentUserIdUC by lazy { SaveCurrentUserIdUC(currentUserIdRepositoryImpl) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AccountViewModel(
            getAccountsUC = getAccountsUC,
            saveCurrentUserIdUC = saveCurrentUserIdUC
        ) as T
    }
}