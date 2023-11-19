package com.example.lab_intents.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.lab_intents.R

class ExplicitActivity : AppCompatActivity() {
    private lateinit var txtUserChoice : TextView
    private lateinit var btnSubmit : Button
    private lateinit var btnGoBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit2)

        txtUserChoice = findViewById(R.id.editText);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnGoBack = findViewById(R.id.btnGoBack);

        btnSubmit.setOnClickListener{
            val intent : Intent = Intent(this, MainActivity::class.java).let { i ->
                i.putExtra("userChoice", txtUserChoice.text.toString());
            }
            startActivity(intent);
        }

        btnGoBack.setOnClickListener{
            onBackPressed();
        }

    }
}