package com.example.financemanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.financemanager.FragmentsNav.FragmentAccounts
import com.example.financemanager.FragmentsNav.FragmentReports
import com.example.financemanager.FragmentsNav.FragmentSettings
import com.example.financemanager.FragmentsNav.FragmentTransactions
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_nav.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            val fragment = FragmentTransactions()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.simpleName).commit()
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.menu_transactions -> {
                val fragment = FragmentTransactions()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.simpleName).commit()
            }
            R.id.menu_reports -> {
                val fragment = FragmentReports()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.simpleName).commit()
            }
            R.id.menu_accounts -> {
                val fragment = FragmentAccounts()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.simpleName).commit()
            }
            R.id.menu_settings -> {
                val fragment = FragmentSettings()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment, fragment.javaClass.simpleName).commit()
            }
        }
        return true
    }

}
