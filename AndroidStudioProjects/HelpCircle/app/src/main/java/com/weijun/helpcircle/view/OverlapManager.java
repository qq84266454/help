package com.weijun.helpcircle.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class OverlapManager extends RecyclerView.LayoutManager {

    public OverlapManager() {
        //需要他自己计算位置必须设置为true
        setAutoMeasureEnabled(true);
    }


    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        //定义竖直方向的偏移量
        int offsetX = 0;
        for (int i = 0; i < getItemCount(); i++) {
            //这里就是从缓存里面取出
            View view = recycler.getViewForPosition(i);
            //将View加入到RecyclerView中
            addView(view);
            //对子View进行测量
            measureChildWithMargins(view, 0, 0);
            //把宽高拿到，宽高都是包含ItemDecorate的尺寸
            int width = getDecoratedMeasuredWidth(view);
            int height = getDecoratedMeasuredHeight(view);
            //最后，将View布局
            layoutDecorated(view, offsetX, 0, offsetX + width, height);
            //将竖直方向偏移量增大height
            offsetX += width * 0.52;
        }
    }


}