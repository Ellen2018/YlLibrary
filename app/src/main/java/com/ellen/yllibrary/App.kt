package com.ellen.yllibrary

import android.app.Application
import com.ellen.yibase.log.YlConsolePrinter
import com.ellen.yibase.log.YlLogConfig
import com.ellen.yibase.log.YlLogManager
import com.google.gson.Gson

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        //日志模块初始化
        YlLogManager.init(object : YlLogConfig(){

            override fun injectJsonParser(): JsonParser {
                return JsonParser { obj -> Gson().toJson(obj) }
            }

            override fun getDefaultTag(): String {
                return "Ellen2020"
            }
            override fun enable(): Boolean {
                return true
            }
        },YlConsolePrinter())
    }
}