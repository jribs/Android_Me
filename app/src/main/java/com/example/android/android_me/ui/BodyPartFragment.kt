package com.example.android.android_me.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_body_part.*

class BodyPartFragment: android.support.v4.app.Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val primaryView: View = inflater.inflate(R.layout.fragment_body_part, container, false)


        imageview_bodypart.setImageResource(AndroidImageAssets.getHeads().get(0))
        return primaryView
    }
}