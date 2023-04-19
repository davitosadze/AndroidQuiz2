package com.example.firebaseappbtu1

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPasswordActivity : AppCompatActivity() {
    private val auth = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        init()
    }

    private fun init() {
        if (findViewById<EditText>(R.id.etEmail).text.toString().isNotEmpty()) {
            findViewById<EditText>(R.id.btnReset).setOnClickListener {
                auth.sendPasswordResetEmail(findViewById<EditText>(R.id.etEmail).text.toString())
            }
        }
    }

}