package com.ellen.yibase.log;

import android.util.Log;

import androidx.annotation.NonNull;

public class YlConsolePrinter implements YlLogPrinter {

    @Override
    public void print(@NonNull YlLogConfig config, int level, String tag, @NonNull String printString) {
        int len = printString.length();
        int row = len / YlLogConfig.MAX_LENGTH;
        if (row > 0) {
            int index = 0;
            for (int i = 0; i < row; i++) {
                Log.println(level,tag,printString.substring(index,index + YlLogConfig.MAX_LENGTH));
                index += YlLogConfig.MAX_LENGTH;
            }
            //打印剩余的部分
            if(index != len){
                Log.println(level,tag,printString.substring(index,len));
            }
        }else {
            //不足一行
            Log.println(level,tag,printString);
        }
    }

}
