package com.ellen.ylui.tab.common;

import androidx.annotation.NonNull;
import androidx.annotation.Px;

public interface IYlTab<D> extends IYlTabLayout.OnTabSelectedChangeListener<D> {

    void setYlTabInfo(@NonNull D data);

    /**
     * 动态修改某个Tab的高度大小
     * @param height
     */
    void resetHeight(@Px int height);

}
