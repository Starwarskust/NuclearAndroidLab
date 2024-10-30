package com.example.nuclearandroidlab

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.nuclearandroidlab.ColorKeys.Companion.BACKGROUND_COLOR_KEY
import com.example.nuclearandroidlab.ColorKeys.Companion.COLOR_BUNDLE

class FragmentBA : Fragment() {
    private var backgroundColor: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("LogMessage", "FragmentBA : onCreateView has called")
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState == null)
            backgroundColor = Color.parseColor("#FFBB86FC")
        else {
            backgroundColor = savedInstanceState.getInt(BACKGROUND_COLOR_KEY)
            view.setBackgroundColor(backgroundColor!!)
        }

        parentFragmentManager.setFragmentResultListener(COLOR_BUNDLE, viewLifecycleOwner) {_, bundle ->
            backgroundColor = bundle.getInt(BACKGROUND_COLOR_KEY)
            view.setBackgroundColor(backgroundColor!!)
        }

        val buttonOpenBB = view.findViewById<Button>(R.id.button_open_fragmentBB)
        buttonOpenBB?.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.container_fragmentBA, FragmentBB())
            transaction.commit()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        backgroundColor?.let { outState.putInt(BACKGROUND_COLOR_KEY, it) }
    }
}