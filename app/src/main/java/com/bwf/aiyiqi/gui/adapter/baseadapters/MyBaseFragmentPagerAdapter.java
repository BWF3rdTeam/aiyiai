package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

<<<<<<< HEAD:app/src/main/java/com/bwf/aiyiqi/gui/adapter/baseadapters/MyBaseFragmentPagerAdapter.java
public abstract class MyBaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    public MyBaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
=======
public abstract class MyBasePagerAdapter<T> extends PagerAdapter {
    protected List<T> datas;
    protected LayoutInflater inflater;
    protected List<View> views;
    public MyBasePagerAdapter(Context context,List<View> views,List<T> datas) {
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
>>>>>>> a4579adeb9622b9d7471a508916f545f3ea4a27d:app/src/main/java/com/bwf/aiyiqi/gui/adapter/baseadapters/MyBasePagerAdapter.java
    }
}
