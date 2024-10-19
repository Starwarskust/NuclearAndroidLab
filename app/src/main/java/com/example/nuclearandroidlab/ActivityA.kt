package com.example.nuclearandroidlab

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LogMessage", "ActivityA: onCreate has called")

        setContentView(R.layout.activity_a)

        val buttonActivity = findViewById<Button>(R.id.button_open_activityB)
        buttonActivity.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        val buttonFragment = findViewById<Button>(R.id.button_open_fragmentB)
        buttonFragment.setOnClickListener {
            val transaction = this.supportFragmentManager.beginTransaction()
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                transaction.add(R.id.container_fragment, FragmentBA())
            } else {
                transaction.add(R.id.container_fragmentBA, FragmentBA())
                transaction.add(R.id.container_fragmentBB, FragmentBB())
            }
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LogMessage", "ActivityA: onRestart has called")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("LogMessage", "ActivityA: onNewIntent has called")
    }

    companion object {
        const val COLOR_BUNDLE = "COLOR_BUNDLE"
        const val BACKGROUND_COLOR = "BACKGROUND_COLOR"
    }
}