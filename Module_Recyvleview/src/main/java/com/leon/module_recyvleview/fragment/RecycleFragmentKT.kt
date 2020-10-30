/*
* FileName: RecycleFragmentKT
* Author: shiwenliang
* Date: 2020/10/30 16:36
* Description: 
*/
package com.leon.module_recyvleview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.leon.base.basecustomview.BaseCustomViewModel
import com.leon.base.mvvm.model.IBaseModelListener
import com.leon.base.mvvm.model.PagingResult
import com.leon.module_recyvleview.R
import com.leon.module_recyvleview.RecycleFragmentAdapter
import com.leon.module_recyvleview.databinding.FragmentRecycleviewLayoutBinding
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader

class RecycleFragmentKT : Fragment(), IBaseModelListener<ArrayList<BaseCustomViewModel>> {

    lateinit var mAdapter: RecycleFragmentAdapter
    lateinit var model: RecycleFragmentModelKT
    var dataList: ArrayList<BaseCustomViewModel> = ArrayList()
    lateinit var viewDataBinding: FragmentRecycleviewLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycleview_layout, container, false)
        init()
        return viewDataBinding.root;
    }

    override fun onLoadSuccess(data: ArrayList<BaseCustomViewModel>?, vararg pagingResults: PagingResult?) {
        if (data != null && pagingResults.size > 0 && pagingResults[0]?.isFirst ?: true) {
            dataList.clear()
        }
        data?.let { dataList.addAll(it) }
        mAdapter.setDataList(dataList)
    }

    override fun onLoadFailure(message: String?, vararg pagingResults: PagingResult?) {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }

    fun init() {
        viewDataBinding.refreshLayout.setRefreshHeader(ClassicsHeader(this.context))
        viewDataBinding.refreshLayout.setRefreshFooter(ClassicsFooter(this.context))
        viewDataBinding.refreshLayout.setOnRefreshListener() {
            model.refresh()
            it.finishLoadMore()
        }

        viewDataBinding.refreshLayout.setOnLoadMoreListener() {
            model.load()
            it.finishLoadMore()
        }

        mAdapter = RecycleFragmentAdapter(this.context)
        model = RecycleFragmentModelKT();
        model.registListener(this)
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this.context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        viewDataBinding.recyclerview.layoutManager = linearLayoutManager
        viewDataBinding.recyclerview.adapter = mAdapter
        model.refresh()

    }
}