package com.ellen.yllibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ellen.ylbase.log.*

class MainActivity : AppCompatActivity() {
    var viewPrinter:YlViewPrinter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPrinter = YlViewPrinter(this)
        YlLog.d("呵呵")
        findViewById<Button>(R.id.bt).setOnClickListener {
            printLog()
        }
        viewPrinter?.viewProvider?.showFloatingView()
    }

    private fun printLog() {
        YlLogManager.getInstance().addPrinters(viewPrinter)
        YlLog.log(object : YlLogConfig() {
            override fun includeThread(): Boolean {
                return true
            }
        }, YlLogType.E, "Ellen2020", "陈浪的果")
        YlLog.a("陈浪的果撒大声地啊")
    }
}