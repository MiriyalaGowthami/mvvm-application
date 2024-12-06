package com.example.mvvmapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

class SubjectDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_subject_details)

        // Get the subject from intent extras
        val subject = intent.getSerializableExtra("subject") as Subject

        // Bind subject to the layout
        binding.subject = subject
    }
}
