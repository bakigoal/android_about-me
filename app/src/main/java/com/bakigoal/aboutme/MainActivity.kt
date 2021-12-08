package com.bakigoal.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

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

        doneButton.setOnClickListener { updateNickname() }
    }

    private fun updateNickname() {
        val nickname = nicknameEdit.text
        if (nickname.isNotEmpty()) {
            nicknameText.text = nickname
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
        }
    }
}