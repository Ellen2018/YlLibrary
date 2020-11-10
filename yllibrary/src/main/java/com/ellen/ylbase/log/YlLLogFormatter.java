package com.ellen.ylbase.log;

/**
 * 日志格式化
 */
public interface YlLLogFormatter<T> {
    String format(T data);
}
