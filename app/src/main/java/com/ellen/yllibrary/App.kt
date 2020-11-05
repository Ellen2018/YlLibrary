package com.ellen.yllibrary

import android.app.Application
import com.ellen.ylbase.log.YlConsolePrinter
import com.ellen.ylbase.log.YlLogConfig
import com.ellen.ylbase.log.YlLogManager
import com.ellen.ylbase.log.YlViewPrinter
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

            override fun stackTraceDepth(): Int {
                return 5
            }
        },YlConsolePrinter())
    }
}