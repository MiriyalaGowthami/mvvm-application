package com.example.mvvmapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapplication.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var viewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        // Bind ViewModel to the layout
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Observer for registration success
        viewModel.isRegistered.observe(this, Observer { isRegistered ->
            if (isRegistered) {
                // If registered successfully, move to login screen
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        })
    }
}
