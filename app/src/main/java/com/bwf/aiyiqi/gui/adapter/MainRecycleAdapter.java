package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainArticles;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.bwf.aiyiqi.widget.PagerDotIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainRecycleAdapter extends MyBaseRecycleAdapter implements View.OnClickListener {
    private final int HEADER = 0;
    private final int FOOTER = 2;
    private final int CONTENT = 1;



    public MainRecycleAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getFooterCount() {
        return 0;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < getHeaderCount()) return HEADER;
        if (position >= getItemCount() - getFooterCount()) return FOOTER;
        else return CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            View view = inflater.inflate(R.layout.subview_recycle_header, null);
            return new HeaderViewHolder(view);
        }
        if (viewType == CONTENT) {
            View view = inflater.inflate(R.layout.subview_recycle_article, null);
            return new BaseHolder(view);
        } else {
            View view = inflater.inflate(R.layout.subview_recycle_footer, null);
            return new HeaderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (position < getHeaderCount()) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            PagerDotIndicator dotIndicator=new PagerDotIndicator(getContext(),headerViewHolder.mainAutoviewpagerLinear, headerViewHolder.mainAutoviewpager);
            dotIndicator.setDotNums(getItemCount()-getFooterCount()-getHeaderCount());
            headerViewHolder.mainAutoviewpager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ResponseMainArticles.DataBean.ForumBean forumBean = (ResponseMainArticles.DataBean.ForumBean) getItem(position);
                    forumBean.getFid();
                }
            });
            headerViewHolder.mainRecycleviewCtv1.setOnClickListener(this);
            headerViewHolder.mainRecycleviewCtv2.setOnClickListener(this);
            headerViewHolder.mainRecycleviewCtv3.setOnClickListener(this);
            headerViewHolder.mainRecycleviewCtv4.setOnClickListener(this);
            headerViewHolder.mainRecycleviewCtv5.setOnClickListener(this);
            headerViewHolder.mainRecycleviewCtv6.setOnClickListener(this);
            headerViewHolder.mainRecycleviewCtv7.setOnClickListener(this);
            headerViewHolder.mainRecycleviewCtv8.setOnClickListener(this);
        } else if (position >= getItemCount() - getFooterCount()) {
// TODO: 2016/11/24 设置脚的点击跳转
            FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            footerViewHolder.mainFooterTextview.setOnClickListener(this);
        }
//        else {
//// TODO: 2016/11/24 设置内容的点击跳转
//
//        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_recycleview_ctv1:
                break;
            case R.id.main_recycleview_ctv2:
                break;
            case R.id.main_recycleview_ctv3:
                break;
            case R.id.main_recycleview_ctv4:
                break;
            case R.id.main_recycleview_ctv5:
                break;
            case R.id.main_recycleview_ctv6:
                break;
            case R.id.main_recycleview_ctv7:
                break;
            case R.id.main_recycleview_ctv8:
                break;
            case R.id.main_footer_textview:
                break;
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_autoviewpager)
        ViewPager mainAutoviewpager;
        @BindView(R.id.main_recycleview_ctv1)
        CheckedTextView mainRecycleviewCtv1;
        @BindView(R.id.main_recycleview_ctv2)
        CheckedTextView mainRecycleviewCtv2;
        @BindView(R.id.main_recycleview_ctv3)
        CheckedTextView mainRecycleviewCtv3;
        @BindView(R.id.main_recycleview_ctv4)
        CheckedTextView mainRecycleviewCtv4;
        @BindView(R.id.main_recycleview_ctv5)
        CheckedTextView mainRecycleviewCtv5;
        @BindView(R.id.main_recycleview_ctv6)
        CheckedTextView mainRecycleviewCtv6;
        @BindView(R.id.main_recycleview_ctv7)
        CheckedTextView mainRecycleviewCtv7;
        @BindView(R.id.main_recycleview_ctv8)
        CheckedTextView mainRecycleviewCtv8;
        @BindView(R.id.main_autoviewpager_linear)
        LinearLayout mainAutoviewpagerLinear;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_footer_textview)
        TextView mainFooterTextview;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
