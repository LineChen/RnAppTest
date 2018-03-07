package com.line.rnapptest.base;

/**
 * Created by chenliu on 2018/3/6.
 */

public class ReactSupport {

    static ReactSupport instance = new ReactSupport();

    private String moduleName;

    public static ReactSupport getInstance() {
        return instance;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
