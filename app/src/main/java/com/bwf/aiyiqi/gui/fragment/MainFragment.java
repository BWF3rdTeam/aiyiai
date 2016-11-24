package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainArticles;
import com.bwf.aiyiqi.gui.adapter.MainRecycleAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainRecyclePresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainRecycleView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MainFragment extends BaseFragment implements MainRecycleView,MainRecycleAdapter.OnItemClickListener{
    @BindView(R.id.main_recycleview)
    RecyclerView mainRecycleview;
    private MainRecycleAdapter adapter;
    private MainRecyclePresenterImpl presenter;
    @Override
    protected int getViewResId() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initViews() {
        adapter=new MainRecycleAdapter(getActivity());
        adapter.setOnItemClickListener(this);
        mainRecycleview.setAdapter(adapter);
    }

    @Override
    protected void initDatas() {
        presenter=new MainRecyclePresenterImpl(this);
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
        ResponseMainArticles.DataBean dataBean= (ResponseMainArticles.DataBean) data;
//        ResponseMainArticles responseMainArticles= (ResponseMainArticles) data;
        int type=dataBean.getType();
        if (type==1){
            // TODO: 2016/11/24 跳转文章详情
            Log.d("MainFragment", dataBean.getId());

        }else if(type==3){
            // TODO: 2016/11/24 跳转帖子
            Log.d("MainFragment", dataBean.getId());

        }
    }

    @Override
    public void showMainSuccess(String response) {
        Toast.makeText(getActivity(), "haha", Toast.LENGTH_SHORT).show();
        ResponseMainArticles articles= JSON.parseObject(response,ResponseMainArticles.class);
        adapter.addDatas(articles.getData());
    }

    @Override
    public void showMainFaild(Exception e) {
        // TODO: 2016/11/24 团聚异常捕获
        Toast.makeText(getActivity(), "xixi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMainPagersSuccess(String response) {

    }

    @Override
    public void showMainPagersFaild(Exception e) {

    }
}
