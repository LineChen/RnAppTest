package com.line.processor_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chenliu on 2018/4/22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface BundleBuild {
    String settingFilePath();
}
