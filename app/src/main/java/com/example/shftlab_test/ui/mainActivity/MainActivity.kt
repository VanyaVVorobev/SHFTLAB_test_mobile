package com.example.shftlab_test.ui.mainActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shftlab_test.R
import com.example.shftlab_test.databinding.ActivityMainBinding
import com.example.shftlab_test.ui.accountActivity.AccountActivity
import com.example.shftlab_test.ui.signupActivity.SignupActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vm = ViewModelProvider(this, MainVMFactory(this))[MainViewModel::class.java]

        GlobalScope.launch {
            vm.getCurrentUserId()
            vm.getUserData(vm.currentUserId.value!!)
        }

        binding.helloButton.setOnClickListener {
            var poem = resources.getText(R.string.poem)
            val regex = resources.getText(R.string.poem_name_regex)
            poem = Regex("""$regex""").replace(poem,
                "${vm.userData.value!!.firstName} ${vm.userData.value!!.lastName}")
            binding.greetingTextView.text = poem
        }

        binding.signoutButton.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
            finish()
        }
    }
}