package com.ellen.yllibrary

import android.app.Application
import com.ellen.yibase.log.YlLogConfig
import com.ellen.yibase.log.YlLogManager

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        //日志模块初始化
        YlLogManager.init(object : YlLogConfig(){
            override fun getDefaultTag(): String {
                return "Ellen2020"
            }
            override fun enable(): Boolean {
                return true
            }
        })
    }
}