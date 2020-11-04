package com.ellen.yllibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ellen.yibase.log.YlLog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        YlLog.e("呵呵")
    }
}