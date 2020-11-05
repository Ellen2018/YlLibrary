package com.ellen.yibase.log;

/**
 * 日志格式化
 */
public interface YlLLogFormatter<T> {
    String format(T data);
}
