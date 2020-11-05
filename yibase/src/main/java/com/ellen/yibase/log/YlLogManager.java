package com.ellen.yibase.log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YlLogManager {
    private YlLogConfig ylLogConfig;
    private static YlLogManager instance;
    private List<YlLogPrinter> ylLogPrinterList = new ArrayList<>();

    private YlLogManager(YlLogConfig ylLogConfig, YlLogPrinter[] printers) {
        this.ylLogConfig = ylLogConfig;
        ylLogPrinterList.addAll(Arrays.asList(printers));
    }

    public static YlLogManager getInstance() {
        return instance;
    }

    public static void init(YlLogConfig config, YlLogPrinter... ylLogPrinters) {
        instance = new YlLogManager(config, ylLogPrinters);
    }

    public YlLogConfig getConfig() {
        return ylLogConfig;
    }

    public List<YlLogPrinter> getPrinters() {
        return ylLogPrinterList;
    }

    public void addPrinters(YlLogPrinter printer) {
        ylLogPrinterList.add(printer);
    }

    public void removePrinters(YlLogPrinter printer) {
        if (ylLogPrinterList != null)
            ylLogPrinterList.remove(printer);
    }
}
