package com.bakigoal.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var doneButton: Button
    private lateinit var nicknameText: TextView
    private lateinit var nicknameEdit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButton = findViewById(R.id.done_button)
        nicknameText = findViewById(R.id.nickname_text)
        nicknameEdit = findViewById(R.id.nickname_edit)

        doneButton.setOnClickListener { setNickname() }
    }

    private fun setNickname() {
        val nickname = nicknameEdit.text
        if (nickname.isNotEmpty()) {
            nicknameText.text = nickname
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            hideKeyboard(doneButton)
        }
    }

    private fun hideKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}