package com.ellen.yibase.log;

public abstract class YlLogConfig {
    /**
     * 最大长度
     */
    static int MAX_LENGTH =  512;

    /**
     * 线程格式化器
     */
    static YlThreadFormatter YL_THREAD_FORMATTER = new YlThreadFormatter();

    /**
     * 堆栈信息格式化器
     */
    static YlStackTraceFormatter YL_STACK_TRACE_FORMATTER = new YlStackTraceFormatter();

    /**
     * YlLog SDK的默认tag
     * @return
     */
    public String getDefaultTag(){
        return "YlTag";
    }

    /**
     * 是否启用YlLog
     * @return
     */
    public boolean enable(){
        return true;
    }

    /**
     * 日志是否包含线程信息
     * @return
     */
    public boolean includeThread(){return false;}

    /**
     * 堆栈信息的深度
     * @return
     */
    public int stackTraceDepth(){
        return 5;
    }

    /**
     * 日志格式化器
     * @return
     */
    public JsonParser injectJsonParser(){
        return null;
    }

    /**
     * 注册打印器
     * @return
     */
    public YlLogPrinter[] printers(){
        return null;
    }

    /**
     * Json序列化
     */
    public interface JsonParser{
        String toJson(Object obj);
    }
}
