package com.example.nuclearandroidlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.nuclearandroidlab.ActivityA.Companion.BACKGROUND_COLOR
import com.example.nuclearandroidlab.ActivityA.Companion.COLOR_BUNDLE

class FragmentBA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ba, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener(COLOR_BUNDLE, viewLifecycleOwner) {_, bundle ->
            val backgroundColor = bundle.getInt(BACKGROUND_COLOR)
            view.setBackgroundColor(backgroundColor)
        }

        val buttonOpenBB = view.findViewById<Button>(R.id.button_open_fragmentBB)
        buttonOpenBB?.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.container_fragment, FragmentBB())
            transaction.commit()
        }
    }
}