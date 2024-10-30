package com.example.nuclearandroidlab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity

class ActivityC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LogMessage", "ActivityC : onCreate has called : taskId = $taskId")
        setContentView(R.layout.activity_c)

        val button = findViewById<Button>(R.id.button_open_activityA)
        button.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LogMessage", "ActivityC : onRestart has called : taskId = $taskId")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("LogMessage", "ActivityC : onNewIntent has called : taskId = $taskId")
    }
}