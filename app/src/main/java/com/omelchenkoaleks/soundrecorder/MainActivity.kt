package com.omelchenkoaleks.soundrecorder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.omelchenkoaleks.soundrecorder.databinding.ActivityMainBinding
import com.omelchenkoaleks.soundrecorder.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mToolbar: Toolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        mToolbar = mBinding.toolbar
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)
        title = getString(R.string.app_name)

        NavigationUI.setupWithNavController(bottom_navigation, navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}