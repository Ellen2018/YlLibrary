package com.ellen.yibase.log;

public class YlLogManager {
    private YlLogConfig ylLogConfig;
    private static YlLogManager instance;

    private YlLogManager(YlLogConfig ylLogConfig){
        this.ylLogConfig = ylLogConfig;
    }

    public static YlLogManager getInstance(){
        return instance;
    }

    public static void init(YlLogConfig config){
        instance = new YlLogManager(config);
    }

    public YlLogConfig getConfig() {
        return ylLogConfig;
    }
}
