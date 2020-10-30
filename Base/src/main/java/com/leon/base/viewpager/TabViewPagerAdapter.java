/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: TabViewPagerAdapter
 * Author: shiwenliang
 * Date: 2020/10/12 18:03
 * Description: tab的viewpager适配器
 */
package com.leon.base.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class TabViewPagerAdapter extends FragmentStateAdapter {

    private List<Fragment> fragmentList;

    public TabViewPagerAdapter(List<Fragment> fragmentList, FragmentActivity fm) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList != null && !fragmentList.isEmpty() ? fragmentList.size() : 0;
    }
}