package com.line.enumbuildprocessor;

/**
 * Created by chenliu on 2018/4/22.
 */

public class BuildSetting {


    /**
     * bundleName : origin
     * bundleVersion : 2018031501
     * minAppVersion : 3.35.0
     * indexPath : xyjs/index.js
     * message : 历史遗留的js代码
     */

    private String bundleName;
    private String bundleVersion;
    private String minAppVersion;

    public String getBundleName() {
        return bundleName;
    }

    public void setBundleName(String bundleName) {
        this.bundleName = bundleName;
    }

    public String getBundleVersion() {
        return bundleVersion;
    }

    public void setBundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
    }

    public String getMinAppVersion() {
        return minAppVersion;
    }

    public void setMinAppVersion(String minAppVersion) {
        this.minAppVersion = minAppVersion;
    }
}
