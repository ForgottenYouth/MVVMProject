/*
* FileName: RecycleFragmentModelKT
* Author: shiwenliang
* Date: 2020/10/30 17:12
* Description: 
*/
package com.leon.module_recyvleview.fragment

import com.leon.base.basecustomview.BaseCustomViewModel
import com.leon.base.mvvm.model.BaseMVVMModel
import com.leon.common.customrecycleitem.noimg.NoImageItemViewModel
import com.leon.common.customrecycleitem.singleimg.SingleImageItemViewModel

class RecycleFragmentModelKT : BaseMVVMModel<ArrayList<BaseCustomViewModel>>(true, 0) {
    override fun load() {
        var dataList: ArrayList<BaseCustomViewModel> = ArrayList();
        for (i in 1..10) {
            when (i % 3) {
                0 -> {
                    var bean: NoImageItemViewModel = NoImageItemViewModel()
                    bean.title = "女孩救小乞丐一命，八年后女孩大婚，乞丐开着满街豪车参加婚礼"
                    bean.jumpUrl = "www.baidu.com"
                    bean.source = "四川观察"
                    dataList.add(bean)
                }
                1 -> {

                    var bean: SingleImageItemViewModel = SingleImageItemViewModel()
                    bean.title = "中区军用码头今移交香港驻军，林郑月娥：具有重要宪制意义，对驻军致以崇高敬意"
                    bean.jumpUrl = "www.baidu.com"
                    bean.source = "腾讯新闻"
                    bean.picUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601268635860&di=adf866b5d0f72afb0dfe4b5985bcd39e&imgtype=0&src=http%3A%2F%2Fimages.ali213.net%2Fpicfile%2Fpic%2F2013%2F05%2F31%2F927_5082_1327989697_20130531110853980.jpg"
                    dataList.add(bean)
                }
                else -> {

                }
            }
        }
        notifyResponseData(dataList)
    }

}