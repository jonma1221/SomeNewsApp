package com.somenewsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.somenewsapp.ui.FragmentSearchNews

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpFragment(R.id.fragment_container, FragmentSearchNews.newInstance())
    }

    fun setUpFragment(resId: Int, f: Fragment){
        val fm = supportFragmentManager
        fm.beginTransaction()
            .add(resId, f)
            .addToBackStack(null)
            .commit()
    }
}
