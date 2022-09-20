package com.example.shftlab_test.ui.accountActivity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.shftlab_test.R
import com.example.shftlab_test.databinding.ActivityAccountsBinding
import com.example.shftlab_test.domain.model.Account
import com.example.shftlab_test.ui.mainActivity.MainActivity
import com.example.shftlab_test.ui.signupActivity.SignupActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AccountActivity: AppCompatActivity() {
    private val binding by lazy { ActivityAccountsBinding.inflate(layoutInflater) }
    private lateinit var vm: AccountViewModel
    private val id = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        vm = ViewModelProvider(this, AccountVMFactory(this))[AccountViewModel::class.java]


        GlobalScope.launch {
            vm.getAccounts()
            val adapter = AccountAdapter(applicationContext, vm.accounts.value!!)
            withContext(Dispatchers.Main) {
                binding.accountsList.adapter = adapter
            }
            binding.accountsList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                GlobalScope.launch(Dispatchers.IO)
                {
                    vm.saveCurrentUserId(position + 1)
                }
                id.value = position + 1
            }
        }

        id.observe(this) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.goToSignupButton.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }
    }
}