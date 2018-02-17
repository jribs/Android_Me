package com.example.android.android_me.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_master_list.view.*


class MasterListFragment: Fragment() {

    lateinit var imageClickListener: OnImageClickListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnImageClickListener){
            imageClickListener = context
        } else {
            throw RuntimeException("${context.toString()} must implement the OnImageClickListener interface")
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutView = inflater?.inflate(R.layout.fragment_master_list, container, false)
        if(layoutView!=null) {
            layoutView.gridview_all_parts.adapter = MasterListAdapter(activity, AndroidImageAssets.getAll())
            layoutView.gridview_all_parts.setOnItemClickListener { adapterView, view, position, id ->
                    imageClickListener.onImageClicked(position=position)
            }
            layoutView.button_next.setOnClickListener { imageClickListener.onNextClicked() }
        }
        return layoutView
    }

    interface OnImageClickListener {
        fun onImageClicked(position: Int)
        fun onNextClicked()
    }

}

