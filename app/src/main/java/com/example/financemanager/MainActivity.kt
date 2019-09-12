package com.example.financemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.financemanager.fragmentsNav.*
import com.iammert.library.readablebottombar.ReadableBottomBar

class MainActivity : AppCompatActivity(), ReadableBottomBar.ItemSelectListener {

    private val fragmentTransactions: Fragment = FragmentTransactions()
    private val fragmentReports: Fragment = FragmentReports()
    private val fragmentAccounts: Fragment = FragmentAccounts()
    private val fragmentSettings: Fragment = FragmentSettings()
    private var bottomNavBar : ReadableBottomBar? = null
    private var indexCurrentTabBottomNavBar: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavBar = findViewById(R.id.bottomBar)
        bottomNavBar!!.setOnItemSelectListener(this)

        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentTransactions, fragmentTransactions.javaClass.simpleName).commit()
    }

    override fun onItemSelected(index: Int) {
        val currentFragment: Fragment? = getFragment(indexCurrentTabBottomNavBar)
        val newFragment: Fragment? = getFragment(index)
        indexCurrentTabBottomNavBar = index

        val transaction = supportFragmentManager.beginTransaction()
        if (newFragment!!.isAdded) transaction.hide(currentFragment!!).show(newFragment)
        else transaction.hide(currentFragment!!).add(R.id.fragment_container, newFragment, newFragment.javaClass.simpleName)
        transaction.commit()
    }

    private fun getFragment(index: Int): Fragment? {
        when (index) {
            0 -> return fragmentTransactions
            1 -> return fragmentReports
            2 -> return fragmentAccounts
            3 -> return fragmentSettings
        }
        return null
    }

}