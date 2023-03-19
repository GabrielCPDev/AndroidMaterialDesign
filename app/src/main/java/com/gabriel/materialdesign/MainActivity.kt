package com.gabriel.materialdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.gabriel.materialdesign.databinding.ActivityMainBinding
import com.gabriel.materialdesign.fragments.MainFragmentDirections

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)  }
    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment_content_main) }
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                navegaPara(MainFragmentDirections.actionMainFragmentToButtonsFragment())
            true }
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun navegaPara(direction: NavDirections) {
            navController.navigate(direction)
    }
}