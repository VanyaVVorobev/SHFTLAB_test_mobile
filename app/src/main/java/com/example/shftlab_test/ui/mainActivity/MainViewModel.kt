package com.example.shftlab_test.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shftlab_test.domain.model.UserData
import com.example.shftlab_test.domain.useCase.GetCurrentUserIdUC
import com.example.shftlab_test.domain.useCase.GetUserDataUC
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getUserDataUC: GetUserDataUC,
    private val getCurrentUserIdUC: GetCurrentUserIdUC
    ): ViewModel() {

    private var userDataLive = MutableLiveData<UserData>()
    val userData: LiveData<UserData> = userDataLive

    private var currentUserIdLive = MutableLiveData<Int>()
    val currentUserId: LiveData<Int> = currentUserIdLive

    override fun onCleared() {
        super.onCleared()
    }

    suspend fun getUserData(id: Int){
        val res: UserData
        withContext(Dispatchers.IO) {
            res = getUserDataUC.execute(id)
        }
        withContext(Dispatchers.Main) {
            userDataLive.value = res
        }
    }

    suspend fun getCurrentUserId() {
        val res: Int
        withContext(Dispatchers.IO) {
            res = getCurrentUserIdUC.execute()
        }
        withContext(Dispatchers.Main) {
            currentUserIdLive.value = res
        }
    }

}