package com.ellen.ylbase.log;

import androidx.annotation.NonNull;

/**
 * 打印器
 * 1.IDE控制台
 * 2.App日志显示台
 * 3.文本存储
 * 4.自定义
 *
 */
public interface YlLogPrinter {
    void print(@NonNull YlLogConfig config,int level,String tag,@NonNull String printString);
}
