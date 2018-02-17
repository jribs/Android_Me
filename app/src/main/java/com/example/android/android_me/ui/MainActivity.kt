package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.android.android_me.R


class MainActivity: AppCompatActivity(), MasterListFragment.OnImageClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onImageClicked(position: Int) {
        Toast.makeText(this, "Image at position $position selected", Toast.LENGTH_LONG).show()
    }
}