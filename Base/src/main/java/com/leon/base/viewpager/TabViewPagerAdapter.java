/*
 * Copyright (C), 2015-2020, 物联云仓科技有限公司
 * FileName: TabViewPagerAdapter
 * Author: shiwenliang
 * Date: 2020/10/12 18:03
 * Description: tab的viewpager适配器
 */
package com.leon.base.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TabViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public TabViewPagerAdapter(List<Fragment> fragmentList, FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragmentList = fragmentList;
    }

    @Override
    public int getCount() {
        return fragmentList != null && !fragmentList.isEmpty() ? fragmentList.size() : 0;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}