package com.ellen.ylui.tab.common;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

public interface IYlTabLayout<Tab extends ViewGroup,D> {
    Tab findTab(@NonNull D data);
    void addTabSelectedChangeListener(OnTabSelectedChangeListener<D> listener);
    void defaultSelected(@NonNull D defaultInfo);
    void inflateInfo(@NonNull List<D> infoList);

    interface OnTabSelectedChangeListener<D>{
        void onTabSelectedChange(int index,@NonNull D preInfo,@NonNull D nextInfo);
    }

}
