package com.line.enumbuildprocessor;

import com.alibaba.fastjson.JSON;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;

public class Creator {

    public static void create(Filer filer){
        TypeSpec typeSpec = TypeSpec.enumBuilder("Roshambo")
                .addModifiers(Modifier.PUBLIC)
                .addEnumConstant("ROCK", TypeSpec.anonymousClassBuilder("$S", "fist")
                        .build())
                .addEnumConstant("SCISSORS", TypeSpec.anonymousClassBuilder("$S", "peace")
                        .build())
                .addEnumConstant("PAPER", TypeSpec.anonymousClassBuilder("$S", "flat")
                        .build())
                .addField(String.class, "handsign", Modifier.PRIVATE, Modifier.FINAL)
                .addMethod(MethodSpec.constructorBuilder()
                        .addParameter(String.class, "handsign")
                        .addStatement("this.$N = $N", "handsign", "handsign")
                        .build())
                .build();

        JavaFile javaFile = JavaFile.builder("com.line.rnapptest", typeSpec)
                .build();
        try {
            javaFile.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createJsBundleEnum(Filer filer, String jsonFilePath) {
        String json = getFileContent(jsonFilePath);
        if (json.length() > 0) {
            List<BuildSetting> buildSettings = JSON.parseArray(json, BuildSetting.class);
            TypeSpec.Builder enumBuilder = TypeSpec.enumBuilder("JsBundleEnum").addModifiers(Modifier.PUBLIC);
            for (BuildSetting setting : buildSettings) {
                //生成类型
                enumBuilder.addEnumConstant(setting.getBundleName(),
                        TypeSpec.anonymousClassBuilder("$S,$S,$S", setting.getBundleName(),
                                setting.getBundleVersion(), setting.getMinAppVersion()).build());
            }

            enumBuilder.addField(String.class, "bundleName", Modifier.PRIVATE)
                    .addField(String.class, "bundleVersion", Modifier.PRIVATE)
                    .addField(String.class, "minAppVersion", Modifier.PRIVATE);
            enumBuilder.addMethod(MethodSpec.constructorBuilder()
                    .addParameter(String.class, "bundleName")
                    .addParameter(String.class, "bundleVersion")
                    .addParameter(String.class, "minAppVersion")
                    .addStatement("this.$N = $N", "bundleName", "bundleName")
                    .addStatement("this.$N = $N", "bundleVersion", "bundleVersion")
                    .addStatement("this.$N = $N", "minAppVersion", "minAppVersion")
                    .build());
            enumBuilder.addMethod(getGetterMethod("bundleName"))
                    .addMethod(getGetterMethod("bundleVersion"))
                    .addMethod(getGetterMethod("minAppVersion"));

            TypeSpec build = enumBuilder.build();
            JavaFile javaFile = JavaFile.builder("com.line.rnapptest", build)
                    .build();
            try {
                javaFile.writeTo(filer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static MethodSpec getGetterMethod(String fieldName) {
        char[] chars = fieldName.toCharArray();
        if(chars[0] >= 'a' && chars[0] <= 'z'){
            chars[0]-= ('a' - 'A');
        }
        return MethodSpec.methodBuilder("get" + String.valueOf(chars))
                        .addModifiers(Modifier.PUBLIC)
                        .returns(String.class)
                        .addStatement("return this.$N", fieldName)
                        .build();
    }

    private static String getFileContent(String path) {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        if(file.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
                String line;
                while((line = br.readLine()) != null) {
                    sb.append(line).append(System.getProperty("line.separator"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("The file is not exists.");
        }
        return sb.toString();
    }


}
