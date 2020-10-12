/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: RecycleViewActivity
 * Author: shiwenliang
 * Date: 2020/9/28 16:40
 * Description: 列表视图
 */
package com.leon.module_recyvleview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.leon.base.viewpager.TabViewPagerAdapter;
import com.leon.module_recyvleview.databinding.ActivityRecycleviewLayoutBinding;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {

    ActivityRecycleviewLayoutBinding dataBinding;
    private ArrayList<Fragment> mFragmentsArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycleview_layout);
        configTabSlideViews();
    }

    private void configTabSlideViews() {
        for (int i = 0; i < 10; i++) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            RecycleFragment fragment = new RecycleFragment();
            fragment.setArguments(bundle);
            mFragmentsArrayList.add(fragment);
            dataBinding.tablayout.addTab(dataBinding.tablayout.newTab(),
                    false);
        }

        dataBinding.tablayout.setupWithViewPager(dataBinding.viewpager,false);
        TabViewPagerAdapter mViewPagerAdapter = new TabViewPagerAdapter(mFragmentsArrayList, getSupportFragmentManager());
        dataBinding.viewpager.setAdapter(mViewPagerAdapter);
        dataBinding.viewpager.setOffscreenPageLimit(3);

        for (int i = 0; i < 10; i++) {
            dataBinding.tablayout.getTabAt(i).setCustomView(makeTabView("tab+" + i));
        }
    }

    @SuppressLint("ResourceAsColor")
    private View makeTabView(String title) {
        @SuppressLint("InflateParams") View tabView = LayoutInflater.from(this).inflate(R.layout.custom_tab_view_layout, null);
        TextView tabTitle = tabView.findViewById(R.id.tab_title);
        tabTitle.setText(title);
        tabTitle.setTextColor(R.color.colorAccent);
        return tabView;
    }
}