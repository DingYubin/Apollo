package com.apollo.elegant.annotation.processor;

import com.apollo.elegant.annotation.cls.BindView;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * • init：被注解处理工具调用，并输入 ProcessingEnviroment 参数。ProcessingEnviroment提供很多有用的 工具类，比如Elements、Types、Filer和Messager等。
 * • process：相当于每个处理器的主函数main（），在这里写你的扫描、评估和处理注解的代码，以及生 成Java文件。输入参数RoundEnviroment，可以让你查询出包含特定注解的被注解元素。
 * • getSupportedAnnotationTypes：这是必须指定的方法，指定这个注解处理器是注册给哪个注解的。注 意，它的返回值是一个字符串的集合，包含本处理器想要处理的注解类型的合法全称。
 * • getSupportedSourceVersion：用来指定你使用的 Java 版本，通常这里返回 SourceVersion.latestSupported（）。 在Java 7以后，也可以使用注
 *
 * @author dingyubin
 */


/*
    需要加入注解处理器的依赖，Processor.class是注解处理器的生成文件
    1、auto-service
    2、入插件android-apt
        • 仅仅在编译时期去依赖注解处理器所在的函数库并进行工作，但不会打包到APK中。
        • 为注解处理器生成的代码设置好路径，以便Android Studio能够找到它。
 */
//@AutoService(Processor.class)
public class ClassProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        for (Element element : roundEnv.getElementsAnnotatedWith(BindView.class)){
            if (element.getKind() == ElementKind.FIELD){
                messager.printMessage(Diagnostic.Kind.NOTE, "printMessage: "
                + element.toString());
            }
        }
        return true;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<String>();
        annotations.add(BindView.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
