/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets

// This activity will display a custom Android image composed of three body parts: head, body, and legs
class AndroidMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)
        if(savedInstanceState==null) {
            createBodyPartFragments()
        }
    }

//2nd layer
    private fun createBodyPartFragments() {
        generateHeadFragment()
        generateBodyFragment()
        generateLegFragment()
    }


//3rd layer
    private fun generateHeadFragment() {
        val headFragment = BodyPartFragment()
        headFragment.mListOfDrawableResources = AndroidImageAssets.getHeads().toIntArray()
        val b = intent.hasExtra(getString(R.string.args_legs))
        headFragment.mListIndex = intent.getIntExtra(getString(R.string.args_head),0)
        supportFragmentManager.beginTransaction()
                .add(R.id.head_container, headFragment)
                .commit()
    }

    private fun generateBodyFragment(){
        val bodyFragment = BodyPartFragment()
        bodyFragment.mListOfDrawableResources = AndroidImageAssets.getBodies().toIntArray()
        bodyFragment.mListIndex = intent.getIntExtra(getString(R.string.args_body),0)
        supportFragmentManager.beginTransaction()
                .add(R.id.body_container, bodyFragment)
                .commit()
    }

    private fun generateLegFragment(){
        val legFragment = BodyPartFragment()
        legFragment.mListOfDrawableResources = AndroidImageAssets.getLegs().toIntArray()
        legFragment.mListIndex = intent.getIntExtra(getString(R.string.args_legs),0)
        supportFragmentManager.beginTransaction()
                .add(R.id.leg_container, legFragment)
                .commit()
    }

}
