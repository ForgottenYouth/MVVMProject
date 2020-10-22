/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: RecycleViewActivity
 * Author: shiwenliang
 * Date: 2020/9/28 16:40
 * Description: 列表视图
 */
package com.leon.module_recyvleview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.leon.base.viewpager.TabViewPagerAdapter
import com.leon.module_recyvleview.databinding.ActivityRecycleviewLayoutBinding
import java.util.*

class RecycleViewActivity : AppCompatActivity() {
    var dataBinding: ActivityRecycleviewLayoutBinding? = null
    private val mFragmentsArrayList = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycleview_layout)
        configTabSlideViews()
    }

    private fun configTabSlideViews() {
        for (i in 0..9) {
            val bundle = Bundle()
            bundle.putInt("index", i)
            val fragment = RecycleFragment()
            fragment.arguments = bundle
            mFragmentsArrayList.add(fragment)
            dataBinding!!.tablayout.addTab(dataBinding!!.tablayout.newTab(),
                    false)
        }
        dataBinding!!.tablayout.setupWithViewPager(dataBinding!!.viewpager, false)
        val mViewPagerAdapter = TabViewPagerAdapter(mFragmentsArrayList, supportFragmentManager)
        dataBinding!!.viewpager.adapter = mViewPagerAdapter
        dataBinding!!.viewpager.offscreenPageLimit = 3
        for (i in 0..9) {
            dataBinding!!.tablayout.getTabAt(i)!!.customView = makeTabView("tab+$i")
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun makeTabView(title: String): View {
        @SuppressLint("InflateParams") val tabView = LayoutInflater.from(this).inflate(R.layout.custom_tab_view_layout, null)
        val tabTitle = tabView.findViewById<TextView>(R.id.tab_title)
        tabTitle.text = title
        tabTitle.setTextColor(R.color.colorAccent)
        return tabView
    }
}