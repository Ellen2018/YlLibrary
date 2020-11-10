package com.ellen.ylbase.log;

/**
 * 线程信息格式化
 */
public class YlThreadFormatter implements YlLLogFormatter<Thread>{

    @Override
    public String format(Thread data) {
        return "Thread:"+data.getName();
    }
}
