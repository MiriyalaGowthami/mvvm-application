package com.example.mvvmapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RegistrationViewModel(application: Application) : AndroidViewModel(application) {

    // LiveData for fields
    val name = MutableLiveData<String>()
    val rollNo = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()
    val gender = MutableLiveData<String>()
    val isTermsChecked = MutableLiveData<Boolean>()

    // LiveData to observe registration success
    private val _isRegistered = MutableLiveData<Boolean>()
    val isRegistered: LiveData<Boolean> get() = _isRegistered

    fun onRegisterClicked() {
        // Validate inputs
        if (name.value.isNullOrEmpty() || rollNo.value.isNullOrEmpty() || password.value.isNullOrEmpty() ||
            confirmPassword.value.isNullOrEmpty() || gender.value.isNullOrEmpty() || isTermsChecked.value == false) {
            return
        }
        if (password.value != confirmPassword.value) {
            return // Handle password mismatch
        }

        // Save user details in SharedPreferences
        val sharedPreferences = getApplication<Application>().getSharedPreferences("UserPref", Context.MODE_PRIVATE)
        sharedPreferences.edit()
            .putString("name", name.value)
            .putString("rollNo", rollNo.value)
            .putString("password", password.value)
            .putBoolean("isLoggedIn", true)
            .apply()

        // Notify registration success
        _isRegistered.value = true
    }
}
