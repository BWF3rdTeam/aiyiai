package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainArticles;
import com.bwf.aiyiqi.entity.ResponseMainPager;
import com.bwf.aiyiqi.gui.adapter.MainPagerAdapter;
import com.bwf.aiyiqi.gui.adapter.MainRecycleAdapter;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainRecyclePresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainRecycleView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MainFragment extends BaseFragment implements MainRecycleView, MyBaseRecycleAdapter.OnItemClickListener {
    @BindView(R.id.main_recycleview)
    RecyclerView mainRecycleview;
    @BindView(R.id.main_refresh)
    MaterialRefreshLayout mainRefresh;
    private MainRecycleAdapter recycleAdapter;
    private MainPagerAdapter pagerAdapter;
    private MainRecyclePresenterImpl presenter;

    @Override
    protected int getViewResId() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initViews() {

        recycleAdapter = new MainRecycleAdapter(getActivity());
        recycleAdapter.setOnItemClickListener(this);
        recycleAdapter.setPagerAdapter(pagerAdapter);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecycleview.setLayoutManager(manager);
        mainRecycleview.setAdapter(recycleAdapter);
        mainRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadDatas();
            }
        });
    }

    @Override
    protected void initDatas() {
        presenter = new MainRecyclePresenterImpl(this);
        presenter.loadDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onItemClick(View view, int pesition, Object data) {
        ResponseMainArticles.DataBean dataBean = (ResponseMainArticles.DataBean) data;
        int type = dataBean.getType();
        if (type == 1) {
            // TODO: 2016/11/24 跳转文章详情
            Toast.makeText(getActivity(), "跳转文章", Toast.LENGTH_SHORT).show();
            Log.d("MainFragment", dataBean.getId());

        } else if (type == 3) {
            // TODO: 2016/11/24 跳转帖子
            Toast.makeText(getActivity(), "跳转帖子", Toast.LENGTH_SHORT).show();
            Log.d("MainFragment", dataBean.getId());

        }
    }

    @Override
    public void showMainSuccess(String response) {
        mainRefresh.finishRefresh();
        ResponseMainArticles articles = JSON.parseObject(response, ResponseMainArticles.class);
        recycleAdapter.setDatas(articles.getData());
    }

    @Override
    public void showMainFaild(Exception e) {
        mainRefresh.finishRefresh();
        // TODO: 2016/11/24 团聚异常捕获
        Toast.makeText(getActivity(), "数据加载失败", Toast.LENGTH_SHORT).show();
    }
    private List<View> views;
    @Override
    public void showMainPagersSuccess(String response) {
        mainRefresh.finishRefresh();
        ResponseMainPager responseMainPager = JSON.parseObject(response, ResponseMainPager.class);
        int size = responseMainPager.getData().size();
        if (views==null){
            views = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                views.add(inflater.inflate(R.layout.main_autopager, null));
            }
        }
        pagerAdapter = new MainPagerAdapter(getActivity(),views);
        pagerAdapter.setDatas(responseMainPager.getData());
    }

    @Override
    public void showMainPagersFaild(Exception e) {
        mainRefresh.finishRefresh();
        Toast.makeText(getActivity(), "图片加载失败", Toast.LENGTH_SHORT).show();
    }
}
