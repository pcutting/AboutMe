package com.nevie.aboutme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nevie.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationBar.setOnNavigationItemSelectedListener {
            handleBottomNavigation(
                it.itemId
            )
        }
        binding.bottomNavigationBar.selectedItemId = R.id.menu_programming
    }

    private fun handleBottomNavigation(
        menuItemId: Int
    ): Boolean = when(menuItemId) {
        R.id.menu_bio -> {
            swapFragments(BioFragment())
            true
        }
        R.id.menu_family -> {
            swapFragments(FamilyFragment())
            true
        }
        R.id.menu_hobbies -> {
            swapFragments(HobbyFragment())
            true
        }
        R.id.menu_programming -> {
            swapFragments(ProgrammingFragment())
            true
        }
        else -> false
    }

    private fun swapFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

