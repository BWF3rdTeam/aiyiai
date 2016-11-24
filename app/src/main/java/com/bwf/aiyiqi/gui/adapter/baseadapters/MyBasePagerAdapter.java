package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public abstract class MyBasePagerAdapter<T> extends PagerAdapter{
    protected List<T> datas;
    protected LayoutInflater inflater;
    protected List<View> views;
    public MyBasePagerAdapter(Context context, List<View> views, List<T> datas) {
        this.inflater = LayoutInflater.from(context);
        this.datas = datas;
        this.views = views;
    }
    @Override
    public int getCount() {
        return datas.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
