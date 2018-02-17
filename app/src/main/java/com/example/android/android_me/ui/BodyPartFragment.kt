package com.example.android.android_me.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.android_me.R
import kotlinx.android.synthetic.main.fragment_body_part.*

class BodyPartFragment: android.support.v4.app.Fragment(){

    var mListOfDrawableResources: IntArray? = null
    var mListIndex: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val primaryView: View = inflater.inflate(R.layout.fragment_body_part, container, false)

        return primaryView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadLastSavedStateIfItExists(savedInstanceState)
        setImage()
        setImageViewClickListener()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if(mListOfDrawableResources!=null) {
            outState.putIntArray(ARGS_DRAWABLE_RESOURCEs, mListOfDrawableResources)
        }
        outState.putInt(ARGS_CURRENT_IMAGE_INDEX, mListIndex)
        super.onSaveInstanceState(outState)
    }


//2nd Layer Functions
    private fun loadLastSavedStateIfItExists(savedInstanceState: Bundle?) {

            if (savedInstanceState != null && savedInstanceState.containsKey(ARGS_DRAWABLE_RESOURCEs)) {
                with(savedInstanceState) {
                    mListOfDrawableResources = getIntArray(ARGS_DRAWABLE_RESOURCEs)
                    mListIndex = getInt(ARGS_CURRENT_IMAGE_INDEX)
                }
            }
    }

    private fun setImageViewClickListener() {
        imageview_bodypart.setOnClickListener {
            if (mListOfDrawableResources != null) {
                if (mListIndex < mListOfDrawableResources!!.size) {
                    mListIndex++
                } else {
                    mListIndex = 0
                }
                setImage()
            }
        }
    }

    fun setImage(){
        if(mListOfDrawableResources!=null){
            imageview_bodypart.setImageResource(mListOfDrawableResources!!.get(mListIndex))
        }
    }


companion object {
    val ARGS_DRAWABLE_RESOURCEs = "drawable_resource)list"
    val ARGS_CURRENT_IMAGE_INDEX = "current_image_index"
}

}