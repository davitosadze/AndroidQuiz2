package com.example.firebaseappbtu1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        findViewById<Button>(R.id.loginButton).setOnClickListener {
            if (findViewById<EditText>(R.id.loginEmailEditText).text.toString().isNotBlank()
                && findViewById<EditText>(R.id.loginPasswordEditText).text.toString().isNotBlank()
            ) {
                auth.signInWithEmailAndPassword(
                    findViewById<EditText>(R.id.loginEmailEditText).text.toString(),
                    findViewById<EditText>(R.id.loginPasswordEditText).text.toString()
                ).addOnCompleteListener {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
            }
        }

        findViewById<Button>(R.id.forgotPasswordButton).setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        findViewById<Button>(R.id.notRegisteredButton).setOnClickListener {
            finish()
        }
    }
}