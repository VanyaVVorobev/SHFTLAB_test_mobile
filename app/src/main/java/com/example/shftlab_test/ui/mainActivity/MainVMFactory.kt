package com.example.shftlab_test.ui.mainActivity

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shftlab_test.data.repository.CurrentUserIdRepositoryImpl
import com.example.shftlab_test.data.repository.UserDataRepositoryImpl
import com.example.shftlab_test.data.storage.dataBase.UserData.UserDataRoom
import com.example.shftlab_test.data.storage.sharedPrefs.userId.CurrentUserIdSharedPrefs
import com.example.shftlab_test.domain.useCase.GetCurrentUserIdUC
import com.example.shftlab_test.domain.useCase.GetUserDataUC
import com.example.shftlab_test.domain.useCase.SaveCurrentUserIdUC


class MainVMFactory(context: Context): ViewModelProvider.Factory {

    private val userDataDao by lazy { UserDataRoom.getDataBase(context).userDataDAO() }
    private val userDataRepositoryImpl by lazy { UserDataRepositoryImpl(userDataDao) }

    private val getUserDataUC by lazy { GetUserDataUC(userDataRepositoryImpl) }

    private val currentUserIdSharedPrefs by lazy { CurrentUserIdSharedPrefs(context) }
    private val currentUserIdRepositoryImpl by lazy { CurrentUserIdRepositoryImpl(currentUserIdSharedPrefs) }
    private val getCurrentUserIdUC by lazy { GetCurrentUserIdUC(currentUserIdRepositoryImpl) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserDataUC = getUserDataUC,
            getCurrentUserIdUC = getCurrentUserIdUC
        ) as T
    }
}