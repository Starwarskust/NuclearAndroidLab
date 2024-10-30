package com.example.nuclearandroidlab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity

class ActivityB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LogMessage", "ActivityB : onCreate has called : taskId = $taskId")
        setContentView(R.layout.activity_b)

        val button = findViewById<Button>(R.id.button_open_activityC)
        button.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LogMessage", "ActivityB : onRestart has called : taskId = $taskId")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("LogMessage", "ActivityB : onNewIntent has called : taskId = $taskId")
    }
}