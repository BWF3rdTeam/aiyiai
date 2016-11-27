package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by 11645 on 2016/11/27.
 */

public class WzyBuildingGridView  extends GridView{
    public WzyBuildingGridView(Context context) {
        super(context);
    }

    public WzyBuildingGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WzyBuildingGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
