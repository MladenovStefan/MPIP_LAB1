package com.example.lab_intents.activities

import android.content.Intent
import android.content.pm.ResolveInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lab_intents.R

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val filterIntent = Intent(Intent.ACTION_MAIN, null)
        filterIntent.addCategory(Intent.CATEGORY_LAUNCHER)

        val activitiesList: List<ResolveInfo> = packageManager.queryIntentActivities(filterIntent, 0)

        val textView: TextView = findViewById(R.id.listView)

        val activityNames = StringBuilder()
        for (info in activitiesList) {
            activityNames.append(info.activityInfo.name).append("\n")
        }

        textView.text = activityNames.toString()
    }
}