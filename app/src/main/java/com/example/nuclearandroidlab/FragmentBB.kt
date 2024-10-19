package com.example.nuclearandroidlab

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.nuclearandroidlab.ActivityA.Companion.BACKGROUND_COLOR
import com.example.nuclearandroidlab.ActivityA.Companion.COLOR_BUNDLE
import kotlin.random.Random

class FragmentBB : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSendColor = view.findViewById<Button>(R.id.button_send_color)
        buttonSendColor.setOnClickListener {
            val rnd = Random.Default
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            val colorBundle = Bundle()
            colorBundle.putInt(BACKGROUND_COLOR, color)
            parentFragmentManager.setFragmentResult(COLOR_BUNDLE, colorBundle)

            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.container_fragment, FragmentBA())
                transaction.commit()
            }

        }
    }
}