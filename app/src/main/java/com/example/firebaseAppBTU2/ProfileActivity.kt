package com.example.firebaseAppBTU2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val email = findViewById<TextView>(R.id.Email);
        val signOutButton = findViewById<Button>(R.id.SignOutbutton)


        val user = Firebase.auth.currentUser;
        if(user != null){
            user?.let {
                email.text = "Your Email: " + (it.email);
            }
        }

        signOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut();
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}