package com.example.firebaseAppBTU2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPassword : AppCompatActivity() {

    private lateinit var etPassword: EditText
    private lateinit var btnResetPassword: Button
    private lateinit var btn: Button

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        etPassword = findViewById(R.id.EmailAddress)
        btnResetPassword = findViewById(R.id.ResetButton)
        btn = findViewById(R.id.button3)

        auth = FirebaseAuth.getInstance()

        btnResetPassword.setOnClickListener {
            val sPassword = etPassword.text.toString()
            if (sPassword.isEmpty() || sPassword.contains(" ")){
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show()
            } else {
                auth.sendPasswordResetEmail(sPassword)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Check your email", Toast.LENGTH_SHORT).show()
                    }

                    .addOnFailureListener {
                        Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                    }
            }
        }

        btn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}