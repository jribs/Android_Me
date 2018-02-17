package com.example.android.android_me.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.android_me.R


class MainActivity: AppCompatActivity(), MasterListFragment.OnImageClickListener{


    private var selectedHead: Int? = null
    private var selectedBody: Int? = null
    private var selectedLegs: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onImageClicked(position: Int) {
        saveSelections(position)
    }

    override fun onNextClicked() {
        startAndroidMeActivity()
    }

//2nd Layer Functions
    private fun saveSelections(position: Int){
        when(parseBodyPartSelectionType(position)){
            HEAD -> selectedHead=position
            BODY -> selectedBody =position-12
            LEGS -> selectedLegs=position-24
        }
    }

    fun startAndroidMeActivity(){
        val intentToStartAndroidMe = Intent(this, AndroidMeActivity::class.java)
        intentToStartAndroidMe.putExtras(bundleForAndroidMe())
        startActivity(intentToStartAndroidMe)
    }

//3rd Layer Functions

    private fun parseBodyPartSelectionType(position: Int): Int{
        when((position.toFloat()+1F)/12F){
            in 0f..1f -> return HEAD
            in  1f..2f -> return BODY
            in 2f..3f -> return LEGS
            else -> return 1000
        }
    }

    private fun bundleForAndroidMe():Bundle{
        val args = Bundle()
        args.putInt(getString(R.string.args_head), selectedHead?:0)
        args.putInt(getString(R.string.args_body), selectedBody?:0)
        args.putInt(getString(R.string.args_legs), selectedLegs?:0)
        return args
    }


    companion object {
        private val HEAD = 556
        private val BODY = 558
        private val LEGS = 560
    }


}