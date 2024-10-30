package com.example.nuclearandroidlab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity

class ActivityA : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LogMessage", "ActivityA : onCreate has called : taskId = $taskId")
        setContentView(R.layout.activity_a)

        val buttonActivity = findViewById<Button>(R.id.button_open_activityB)
        buttonActivity.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        val buttonFragment = findViewById<Button>(R.id.button_open_fragmentB)
        buttonFragment.setOnClickListener {
            val intent = Intent(this, ActivityF::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LogMessage", "ActivityA : onRestart has called : taskId = $taskId")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("LogMessage", "ActivityA : onNewIntent has called : taskId = $taskId")
    }
}