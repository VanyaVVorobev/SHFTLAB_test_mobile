package com.example.shftlab_test.ui.signupActivity

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shftlab_test.data.repository.AccountRepositoryImpl
import com.example.shftlab_test.data.repository.CurrentUserIdRepositoryImpl
import com.example.shftlab_test.data.repository.UserDataRepositoryImpl
import com.example.shftlab_test.data.storage.dataBase.Accounts.AccountRoom
import com.example.shftlab_test.data.storage.dataBase.UserData.UserDataRoom
import com.example.shftlab_test.data.storage.sharedPrefs.userId.CurrentUserIdSharedPrefs
import com.example.shftlab_test.domain.useCase.*
import com.example.shftlab_test.domain.validaror.RegistrationValidatorFactory


class SignupVMFactory(context: Context): ViewModelProvider.Factory {
    private val accountDao by lazy { AccountRoom.getDataBase(context).accountDao() }
    private val accountRepositoryImpl by lazy { AccountRepositoryImpl(accountDao) }

    private val userDataDao by lazy { UserDataRoom.getDataBase(context).userDataDAO() }
    private val userDataRepositoryImpl by lazy { UserDataRepositoryImpl(userDataDao) }

    private val getMaxUserIdUC by lazy { GetMaxUserIdUC(userDataRepositoryImpl) }
    private val saveAccountUC by lazy { SaveAccountUC(accountRepositoryImpl) }
    private val saveUserDataUC by lazy { SaveUserDataUC(userDataRepositoryImpl) }
    private val validateDataUC by lazy { ValidateDataUC(RegistrationValidatorFactory().create()) }

    private val currentUserIdSharedPrefs by lazy { CurrentUserIdSharedPrefs(context) }
    private val currentUserIdRepositoryImpl by lazy { CurrentUserIdRepositoryImpl(currentUserIdSharedPrefs) }
    private val saveCurrentUserIdUC by lazy { SaveCurrentUserIdUC(currentUserIdRepositoryImpl) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignupViewModel(
            getMaxUserIdUC = getMaxUserIdUC,
            saveAccountUC = saveAccountUC,
            saveUserDataUC = saveUserDataUC,
            validateDataUC = validateDataUC,
            saveCurrentUserIdUC = saveCurrentUserIdUC
        ) as T
    }

}