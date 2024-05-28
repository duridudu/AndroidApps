package com.example.ch11_2_recycle

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.ch11_2_recycle.adapter.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    lateinit var viewPagerIdol: ViewPager2
    // fragmentAdapter + tabLayout용
    lateinit var viewPargerFragment : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 프래그먼트 어답터에 프래그먼트들을 넣어준다.
        val fragmentList = listOf(FragmentA(),FragmentB(),FragmentC(),FragmentD())
//        fragmentList.add(FragmentA())
//        fragmentList.add(FragmentB())
//        fragmentList.add(FragmentC())
//        fragmentList.add(FragmentD())
        val fragmentAdapter = FragmentAdapter(this)
        fragmentAdapter.fragments = fragmentList

        // 뷰페이저에 어답터를 붙인다.
        viewPargerFragment = findViewById<ViewPager2>(R.id.viewPager_idol)
        viewPargerFragment.adapter = fragmentAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        // 탭레이아웃 설정
        val tabTitles = listOf("Profile","Search","MyPage","ETC")
       // val tabIcons = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4)
        val iconList = ArrayList<Drawable?>()
        iconList.add(ContextCompat.getDrawable(this, R.drawable.image1))
        iconList.add(ContextCompat.getDrawable(this, R.drawable.image2))
        iconList.add(ContextCompat.getDrawable(this, R.drawable.image3))
        iconList.add(ContextCompat.getDrawable(this, R.drawable.image4))

        // 탭 레이아웃과 뷰페이저 연결해야 탭따라서 움직임
        TabLayoutMediator(tabLayout, viewPargerFragment) {tab, position ->
            tab.text = tabTitles[position]
            tab.icon = iconList[position]
        }.attach()

        // recyclerView 버전 뷰페이저
//        viewPagerIdol = findViewById(R.id.viewPager_idol)
//        viewPagerIdol.adapter = ViewPagerAdapter(getIdolList()) // 어댑터 생성
//        viewPagerIdol.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

    // 관리하는 페이지 수. default = 1
//        viewPagerIdol.offscreenPageLimit = 4
//        // item_view 간의 양 옆 여백을 상쇄할 값
//        val offsetBetweenPages = resources.getDimensionPixelOffset(R.dimen.offsetBetweenPages).toFloat()
//        viewPagerIdol.setPageTransformer { page, position ->
//            val myOffset = position * -(2 * offsetBetweenPages)
//            if (position < -1) {
//                page.translationX = -myOffset
//            } else if (position <= 1) {
//                // Paging 시 Y축 Animation 배경색을 약간 연하게 처리
//                val scaleFactor = 0.8f.coerceAtLeast(1 - abs(position))
//                page.translationX = myOffset
//                page.scaleY = scaleFactor
//                page.alpha = scaleFactor
//            } else {
//                page.alpha = 0f
//                page.translationX = myOffset
//            }
//        }

//        val myDataSet = Datasource().loadAffirmation()
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.adapter = ItemAdapter(this, myDataSet)
//        recyclerView.setHasFixedSize(true)
    }

    // 뷰 페이저에 들어갈 아이템
    private fun getIdolList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.idol1, R.drawable.idol2, R.drawable.idol3)
    }
}