package com.bakigoal.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bakigoal.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener { setNickname() }
    }

    private fun setNickname() {
        val nickname = binding.nicknameEdit.text
        if (nickname.isNotEmpty()) {
            binding.nicknameText.text = nickname
            binding.nicknameText.visibility = View.VISIBLE
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            hideKeyboard(binding.doneButton)
        }
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}