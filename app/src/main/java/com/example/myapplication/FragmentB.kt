package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentB : Fragment(R.layout.fragment_b) {
    interface EventListener {
        fun onGoToAPressed()
    }

    private var listener: EventListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TESTS", "Context is: $context")

        require(context is EventListener) {
            "Activity $context must implement fragment's EventListener"
        }

        listener = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.navigate_to_a_button).setOnClickListener {
            listener?.onGoToAPressed()
        }
    }
}