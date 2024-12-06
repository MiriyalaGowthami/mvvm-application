package com.example.mvvmapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.security.auth.Subject

class SubjectsViewModel(application: Application) : AndroidViewModel(application) {

    private val _subjects = MutableLiveData<List<Subject>>()
    val subjects: LiveData<List<Subject>> get() = _subjects

    init {
        // Load subjects (you can fetch this data from a repository or API)
        _subjects.value = listOf(
            Subject("Computer Science", "CS101", "Details about CS"),
            Subject("Mechanical Engineering", "ME201", "Details about Mechanical"),
            Subject("Civil Engineering", "CE301", "Details about Civil"),
            // Add more subjects here
        )
    }
}
