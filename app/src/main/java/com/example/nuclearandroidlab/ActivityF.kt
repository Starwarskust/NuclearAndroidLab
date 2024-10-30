package com.example.nuclearandroidlab

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ActivityF : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LogMessage", "ActivityF : onCreate has called : taskId = $taskId")
        setContentView(R.layout.activity_f)

        if (savedInstanceState == null) {
            val transaction = this.supportFragmentManager.beginTransaction()
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                transaction.add(R.id.container_fragmentBA, FragmentBA())
            } else {
                transaction.add(R.id.container_fragmentBA, FragmentBA())
                transaction.add(R.id.container_fragmentBB, FragmentBB())
            }
            transaction.commit()
        } else {
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                val transaction = this.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container_fragmentBB, FragmentBB())
                transaction.commit()
            }
        }
    }
}