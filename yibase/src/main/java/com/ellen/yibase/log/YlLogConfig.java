package com.ellen.yibase.log;

public abstract class YlLogConfig {

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
}
