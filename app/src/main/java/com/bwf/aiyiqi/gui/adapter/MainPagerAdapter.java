package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBasePagerAdapter;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainPagerAdapter extends MyBasePagerAdapter {

    public MainPagerAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        return null;
    }
}
