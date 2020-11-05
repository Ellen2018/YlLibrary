package com.ellen.yibase.log;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * Tips:
 * 1.模拟控制台
 * 2.File输出(可支持上传服务器)
 * 3.打印堆栈信息
 */
public class YlLog {

    public static void v(Object... contents) {
        log(YlLogType.V, contents);
    }

    public static void vt(String tag, Object... contents) {
        log(YlLogType.V, tag, contents);
    }

    public static void d(Object... contents) {
        log(YlLogType.D, contents);
    }

    public static void dt(String tag, Object... contents) {
        log(YlLogType.D, tag, contents);
    }

    public static void i(Object... contents) {
        log(YlLogType.I, contents);
    }

    public static void it(String tag, Object... contents) {
        log(YlLogType.I, tag, contents);
    }

    public static void w(Object... contents) {
        log(YlLogType.W, contents);
    }

    public static void wt(String tag, Object... contents) {
        log(YlLogType.W, tag, contents);
    }

    public static void e(Object... contents) {
        log(YlLogType.E, contents);
    }

    public static void et(String tag, Object... contents) {
        log(YlLogType.E, tag, contents);
    }

    public static void a(Object... contents) {
        log(YlLogType.A, contents);
    }

    public static void at(String tag, Object... contents) {
        log(YlLogType.A, tag, contents);
    }

    public static void log(@YlLogType.TYPE int type, Object... contents) {
        log(type, YlLogManager.getInstance().getConfig().getDefaultTag(), contents);
    }

    public static void log(@YlLogType.TYPE int type, @NonNull String tag, Object... contents) {
        log(YlLogManager.getInstance().getConfig(), type, tag, contents);
    }

    public static void log(@NonNull YlLogConfig config, @YlLogType.TYPE int type, @NonNull String tag, Object... contents) {
        if (!config.enable()) return;
        StringBuilder body = new StringBuilder();
        if (config.includeThread()) {
            //打印线程信息
            String threadInfo = YlLogConfig.YL_THREAD_FORMATTER.format(Thread.currentThread());
            body.append(threadInfo).append("\n");
        }
        if (config.stackTraceDepth() > 0) {
            //打印堆栈信息
            String stackTraceInfo = YlLogConfig.YL_STACK_TRACE_FORMATTER.format(new Throwable().getStackTrace());
            body.append(stackTraceInfo).append("\n");
        }
        body.append(parseBody(contents,config));
        List<YlLogPrinter> printers = config.printers() != null ?
                Arrays.asList(config.printers())
                : YlLogManager.getInstance().getPrinters();

        if (printers == null) {
            return;
        }
        //调用打印器进行打印
        for(YlLogPrinter printer : printers){
            printer.print(config,type,tag,body.toString());
        }
    }

    /**
     * 将Object[]映射为String
     *
     * @param contents
     * @return
     */
    private static String parseBody(@NonNull Object[] contents,YlLogConfig config) {
        if(config.injectJsonParser() != null){
            return config.injectJsonParser().toJson(contents);
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : contents) {
            sb.append(obj.toString()).append(";");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
