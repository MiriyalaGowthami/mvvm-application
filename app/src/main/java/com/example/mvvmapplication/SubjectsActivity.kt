package com.example.mvvmapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapplication.databinding.ActivitySubjectsBinding

class SubjectsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectsBinding
    private lateinit var viewModel: SubjectsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Data Binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_subjects)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(SubjectsViewModel::class.java)

        // Bind ViewModel to layout
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Setup RecyclerView
        val adapter = SubjectsAdapter { subject ->
            // Handle subject click to navigate to details screen
            val intent = Intent(this, SubjectDetailsActivity::class.java)
            intent.putExtra("subject", subject)
            startActivity(intent)
        }
        binding.recyclerViewSubjects.adapter = adapter

        // Observe subjects list
        viewModel.subjects.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
