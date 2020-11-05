package com.ellen.yibase.log;

/**
 * 堆栈信息日志处理工具类
 */
public class YlStackTraceUtil {

    public static StackTraceElement[] getCropRealStackTrace(StackTraceElement[] target,String ignorePackage, int maxDepth) {
        return cropStackTrace(getRealStackTrace(target,ignorePackage),maxDepth);
    }

    /**
     * 对堆栈信息进行裁剪
     *
     * @param target
     * @param maxDepth
     * @return
     */
    private static StackTraceElement[] cropStackTrace(StackTraceElement[] target, int maxDepth) {
        int realDepth = target.length;
        if (maxDepth > 0) {
            realDepth = Math.min(realDepth, maxDepth);
        }
        StackTraceElement[] realStackTraceElements = new StackTraceElement[realDepth];
        System.arraycopy(target, 0, realStackTraceElements, 0, realDepth);
        return realStackTraceElements;
    }

    /**
     * 过滤掉SDK内部的堆栈信息
     *
     * @param target
     * @param ignorePackage
     * @return
     */
    private static StackTraceElement[] getRealStackTrace(StackTraceElement[] target, String ignorePackage) {
        int ignoreDepth = 0;
        int allDepth = target.length;
        String className;
        for (int i = allDepth - 1; i >= 0; i--) {
            className = target[i].getClassName();
            if (ignorePackage != null && className.startsWith(ignorePackage)) {
                ignoreDepth = i + 1;
                break;
            }
        }
        int realDepth = allDepth - ignoreDepth;
        StackTraceElement[] realStackTraceElements = new StackTraceElement[realDepth];
        System.arraycopy(target, ignoreDepth, realStackTraceElements, 0, realDepth);
        return realStackTraceElements;
    }
}
