package com.amirdora.hiltdi_sampleapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.amirdora.hiltdi_sampleapp.databinding.ActivityMainBinding
import com.amirdora.hiltdi_sampleapp.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        initVm()

        binding!!.buttonAdd.setOnClickListener {
            val userEntity = UserEntity(name = binding!!.editTextName.text.toString())
            viewModel.insertRecord(userEntity)
        }
    }

    private fun initVm() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.userData.observe(this, { it ->
            var concatenateList = ""
            it.forEach {
                concatenateList = concatenateList + it.name + "\n"
            }
            binding!!.textView.text = concatenateList
        })
    }
}