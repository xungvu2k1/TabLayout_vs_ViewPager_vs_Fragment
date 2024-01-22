package com.example.tablayout_vs_viewpager_vs_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.tablayout_vs_viewpager_vs_fragment.adapter.MainViewPagerAdapter
import com.example.tablayout_vs_viewpager_vs_fragment.adapter.MusicViewPagerAdapter
import com.example.tablayout_vs_viewpager_vs_fragment.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var mTabLayout : TabLayout
    private lateinit var mMainViewPager : ViewPager
    private lateinit var mBottomNavigationView : BottomNavigationView

    private lateinit var mMusicViewPagerAdapter: MusicViewPagerAdapter
    private lateinit var mMainViewPagerAdapter : MainViewPagerAdapter
    private var backPressTime : Long = 0
    private lateinit var mToast : Toast
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        mTabLayout = binding.tabLayout
        mMainViewPager =  binding.viewPager
        mBottomNavigationView = binding.bottomNav

        // setup adapter
        mMainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        mMainViewPager.adapter = mMainViewPagerAdapter

        mMainViewPager.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener{
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int,
                ) {

                }

                override fun onPageSelected(position: Int) {
                    when (position){
                        0 -> mBottomNavigationView.menu.findItem(R.id.action_home).isChecked = true
                        1 -> mBottomNavigationView.menu.findItem(R.id.action_search).isChecked = true
                        2 -> mBottomNavigationView.menu.findItem(R.id.action_music).isChecked = true
                        3 -> mBottomNavigationView.menu.findItem(R.id.action_collection_bookmark).isChecked = true
                        4 -> mBottomNavigationView.menu.findItem(R.id.action_person).isChecked = true
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {

                }
            })

//        mMusicViewPagerAdapter = MusicViewPagerAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
//        mViewPager.adapter = mMusicViewPagerAdapter
//
//        mTabLayout.setupWithViewPager(mViewPager)

        mBottomNavigationView.setOnNavigationItemSelectedListener{
        item ->
            when (item.itemId){
                R.id.action_home -> {
                    mMainViewPager.currentItem = 0
                    true
                }
                R.id.action_search -> {
                    mMainViewPager.currentItem = 1
                    true
                }
                R.id.action_music -> {
                    mMainViewPager.currentItem = 2
                    true
                }
                R.id.action_collection_bookmark -> {
                    mMainViewPager.currentItem = 3
                    true
                }
                R.id.action_person -> {
                    mMainViewPager.currentItem = 4
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