package com.line.enumbuildprocessor;

import com.google.auto.service.AutoService;
import com.line.processor_annotation.BundleBuild;
import com.line.processor_annotation.JsbundleBuildAnnatation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/**
 * Created by chenliu on 2018/4/22.
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.line.processor_annotation.JsbundleBuildAnnatation")
public class EnumProcessor extends AbstractProcessor{

    private Filer filer;
    private Messager messager;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        filer = processingEnvironment.getFiler();
        messager = processingEnvironment.getMessager();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        Set<? extends Element> elementsAnnotatedWith = roundEnvironment.getElementsAnnotatedWith(JsbundleBuildAnnatation.class);
        for (Element element : elementsAnnotatedWith) {
            messager.printMessage(Diagnostic.Kind.WARNING, element.getSimpleName());
            try {
                Creator.create(filer);
            } catch (Exception e) {
                messager.printMessage(Diagnostic.Kind.OTHER, e.getMessage());
                e.printStackTrace();
            }
        }

        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(BundleBuild.class);
        for (Element element : elements) {
            messager.printMessage(Diagnostic.Kind.WARNING, element.getSimpleName());
            BundleBuild annotation = element.getAnnotation(BundleBuild.class);
            try {
                Creator.createJsBundleEnum(filer, annotation.settingFilePath());
            } catch (Exception e) {
                messager.printMessage(Diagnostic.Kind.OTHER, e.getMessage());
                e.printStackTrace();
            }
        }


        return false;
    }
}
