package com.example.mvvmapplication

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val name = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    fun onLoginClicked() {
        val sharedPreferences = getApplication<Application>().getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        val storedName = sharedPreferences.getString("name", "")
        val storedPassword = sharedPreferences.getString("password", "")

        if (name.value == storedName && password.value == storedPassword) {
            // Login successful
            sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
            _isLoggedIn.value = true
        }
    }
}
