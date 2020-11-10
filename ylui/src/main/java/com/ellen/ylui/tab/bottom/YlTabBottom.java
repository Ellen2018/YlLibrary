package com.ellen.ylui.tab.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.ellen.ylui.tab.common.IYlTab;

public class YlTabBottom extends RelativeLayout implements IYlTab<YlTabBottomInfo<?>> {

    public YlTabBottom(Context context) {
        super(context);
    }

    public YlTabBottom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public YlTabBottom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setYlTabInfo(@NonNull YlTabBottomInfo<?> data) {

    }

    @Override
    public void resetHeight(int height) {

    }

    @Override
    public void onTabSelectedChange(int index, @NonNull YlTabBottomInfo<?> preInfo, @NonNull YlTabBottomInfo<?> nextInfo) {

    }
}
