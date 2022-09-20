package com.example.shftlab_test.ui.signupActivity

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shftlab_test.domain.model.Account
import com.example.shftlab_test.domain.model.RegistrationData
import com.example.shftlab_test.domain.model.UserData
import com.example.shftlab_test.ui.mainActivity.MainActivity
import com.example.shftlab_test.R
import com.example.shftlab_test.databinding.ActivitySignupBinding
import kotlinx.coroutines.*

class SignupActivity: AppCompatActivity() {
    private val binding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    private lateinit var vm: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vm = ViewModelProvider(this, SignupVMFactory(this))
            .get(SignupViewModel::class.java)

        binding.submitButton.setOnClickListener {
            val registrationData = getRegistrationData()
                GlobalScope.launch {
                vm.validateRegistration(registrationData)
                withContext(Dispatchers.Main) {
                    updateRegistrationFields()
                }
            }
        }

        vm.registrationResult.observe(this) {
            if (it.isValidationSuccess) {
                GlobalScope.launch {
                    vm.getMaxUserId()
                    val registrationData = getRegistrationData()
                    val id = if (vm.maxUserId.value == null) 0 else vm.maxUserId.value!! + 1
                    vm.saveCurrentUserId(id)
                    launch {
                        saveUserData(id, registrationData)
                    }
                    launch {
                        saveAccount(id ,registrationData)
                    }
                }
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun getRegistrationData(): RegistrationData {
        return RegistrationData(
            binding.firstNameEditText.text.toString(),
            binding.lastNameEditText.text.toString(),
            binding.birthDateEditText.text.toString(),
            binding.passwordEditText.text.toString(),
            binding.secondPasswordEditText.text.toString()
        )
    }

    private fun updateRegistrationFields() {
        setError(
            binding.firstNameEditText,
            binding.firstNameTextView,
            vm.registrationResult.value!!.firstNameErrID
        )
        setError(
            binding.lastNameEditText,
            binding.lastNameTextView,
            vm.registrationResult.value!!.lastNameErrID
        )
        setError(
            binding.birthDateEditText,
            binding.birthDateTextView,
            vm.registrationResult.value!!.birthDateErrID
        )
        setError(
            binding.passwordEditText,
            binding.passwordTextView,
            vm.registrationResult.value!!.passwordErrID
        )
        setError(
            binding.secondPasswordEditText,
            binding.secondPasswordTextView,
            vm.registrationResult.value!!.secondPasswordErrID
        )
    }

    private fun setError(editText: EditText, textView: TextView, errID: Int?) {
        if(errID == null) {
            updateEditText(editText, R.drawable.standard_edit_text, editText.paddingBottom)
            updateTextView(textView, "")
        }
        else {
            val err = resources.getText(errID)
            updateEditText(editText, R.drawable.error_edit_text, editText.paddingBottom)
            updateTextView(textView, err.toString())
        }
    }

    private fun updateEditText(editText: EditText, drawableId: Int, padding: Int) {
        editText.setBackgroundResource(drawableId)
        editText.setPadding(padding, padding, padding, padding)
    }

    private fun updateTextView(textView: TextView, text: String) {
        textView.text = text
    }

    private suspend fun saveUserData(id: Int, registrationData: RegistrationData) {
        vm.saveUserData(
            UserData(
                id,
                registrationData.firstName,
                registrationData.lastName,
                registrationData.birthDate,
                registrationData.password,
            )
        )
    }

    private suspend fun saveAccount(id:Int, registrationData: RegistrationData) {
        vm.saveAccount(
            Account(
                id,
                "${registrationData.firstName} ${registrationData.lastName}"
            )
        )
    }
}