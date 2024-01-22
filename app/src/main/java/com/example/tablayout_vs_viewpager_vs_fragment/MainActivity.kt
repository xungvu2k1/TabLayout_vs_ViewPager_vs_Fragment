package com.example.tablayout_vs_viewpager_vs_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.tablayout_vs_viewpager_vs_fragment.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var mTabLayout : TabLayout
    private lateinit var mViewPager : ViewPager
    private lateinit var mBottomNavigationView : BottomNavigationView

    private lateinit var mPagerAdapter: PagerAdapter

    private var backPressTime : Long = 0
    private lateinit var mToast : Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mTabLayout = binding.tabLayout
        mViewPager =  binding.viewPager
        mBottomNavigationView = binding.bottomNav

        mPagerAdapter = PagerAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        mViewPager.adapter = mPagerAdapter

        mTabLayout.setupWithViewPager(mViewPager)

        mBottomNavigationView.setOnNavigationItemSelectedListener{
        item ->
            when (item.itemId){
                R.id.action_home -> {
                    Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_music -> {
                    Toast.makeText(this, "music", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_search -> {
                    Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_collection_bookmark -> {
                    Toast.makeText(this, "bookmarks", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.action_person -> {
                    Toast.makeText(this, "person", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {false}
            }
        }

//        initialize()
//
//        initiallyHideAllFragments()
//
//        setUpBottomNavigation()

    }

    override fun onBackPressed() {
        if (backPressTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
            return
        }
        else {
            mToast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT)
            mToast.show()
        }
        backPressTime = System.currentTimeMillis()
    }

//    private fun setUpBottomNavigation() {
//        binding.bottomNav.setOnItemSelectedListener {
//            item ->
//            when(item.itemId){
//                R.id.navigation_one -> {
//                    showFragment(oneFragment)
//                    showTabLayout()
//                    true
//                }
//                R.id.navigation_two -> {
//                    showFragment(twoFragment)
//                    hideTabLayout()
//                    true
//                }
//                R.id.navigation_three -> {
//                    showFragment(threeFragment)
//                    true
//                }
//                else -> false
//            }
//        }
//    }
//
//    private fun hideTabLayout() {
//        binding.tabLayout.visibility = View.GONE
//    }
//
//    private fun showTabLayout() {
//        binding.tabLayout.visibility = View.VISIBLE
//    }
//
//    private fun showFragment(frag: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .hide(oneFragment)
//            .hide(twoFragment)
//            .hide(threeFragment)
//            .show(frag)
//            .commitNow()
//
//        binding.viewPager.visibility = if(frag == threeFragment) View.GONE else View.VISIBLE
//    }
//
//
//    private fun initiallyHideAllFragments() {
//        supportFragmentManager.beginTransaction()
//            .add(R.id.frameLayout, oneFragment)
//            .hide(oneFragment)
//            .add(R.id.frameLayout, twoFragment)
//            .hide(twoFragment)
//            .add(R.id.frameLayout, threeFragment)
//            .hide(threeFragment)
//            .commitNow()
//    }
//
//
//    private fun initialize() {
//        oneFragment = OneFragment()
//        twoFragment = TwoFragment()
//        threeFragment = ThreeFragment()
//
//        binding.viewPager.offscreenPageLimit= 2
//
////        https://www.youtube.com/watch?v=Ig_qmySOOGM
//    }

}