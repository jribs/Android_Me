package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_master_list.view.*


class MasterListFragment: Fragment() {

    lateinit var gridView: GridView
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layoutView = inflater?.inflate(R.layout.fragment_master_list, container, false)
        if(layoutView!=null) {
            layoutView.gridview_all_parts.adapter = MasterListAdapter(activity, AndroidImageAssets.getAll())
            //gridView = layoutView.findViewById(R.id.gridview_all_parts)
        }
        return layoutView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        //If this is removed, code runs
//        gridView.numColumns = 3
//        gridView.adapter = MasterListAdapter(activity, AndroidImageAssets.getAll())

        super.onActivityCreated(savedInstanceState)
    }
}

