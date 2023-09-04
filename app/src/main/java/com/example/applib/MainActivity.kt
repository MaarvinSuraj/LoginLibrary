package com.example.applib

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginfunctionalities.LoginManager

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnEnter: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnEnter = findViewById(R.id.btnEnter)

        btnEnter.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            val loginManager = LoginManager()

            if (loginManager.login(username, password)) {
                // Redirect to the next activity
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                // Display a wrong password message
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}