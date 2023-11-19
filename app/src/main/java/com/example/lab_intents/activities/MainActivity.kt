package com.example.lab_intents.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.lab_intents.R
import com.example.lab_intents.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var textViewResult: TextView
    private lateinit var btnExplicitIntent: Button
    private lateinit var btnImpicitIntent: Button
    private lateinit var btnOpenGallery: Button

    private lateinit var viewModel : MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        btnExplicitIntent = findViewById(R.id.btnExplicitActivity)
        btnImpicitIntent = findViewById(R.id.btnImplicitActivity)
        btnOpenGallery = findViewById(R.id.btnOpenGallery)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java];

        var bundle : Bundle? = intent.extras;
        val choice: String? = bundle?.getString("userChoice") ?: "None";
//        viewModel.setUserChoice(choice.toString() ?: "None")

        btnExplicitIntent.setOnClickListener{
            val intent: Intent = Intent(this, ExplicitActivity::class.java);
            startActivity(intent);
        }

        textViewResult.text = choice;

        btnOpenGallery.setOnClickListener {
            val intent = Intent();
            intent.setAction(android.content.Intent.ACTION_VIEW);
            intent.setType("image/*");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        btnImpicitIntent.setOnClickListener {
            val intent: Intent = Intent("mk.ukim.finki.mpip.IMPLICIT_ACTION");
            if(intent.resolveActivity(packageManager) != null){
                startActivity(intent);
            }
        }



    }




}