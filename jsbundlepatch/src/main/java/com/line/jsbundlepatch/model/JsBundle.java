package com.line.jsbundlepatch.model;

/**
 * Created by chenliu on 2018/4/16.
 */

public class JsBundle {
    /**
     * eg:m2.android.jsbundle_2018031802
     */
    private String bundleName;
    private String bundleVersion;
    private String minAppVersion;
    private String downloadUrl;


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

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
