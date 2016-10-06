package com.github.dizzarg.annotation.processor.simple;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("com.github.dizzarg.annotation.processor.simple.Deprecate")
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class DeprecateAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(final Set<? extends TypeElement> annotations,
                           final RoundEnvironment roundEnv) {

        for (final Element element : roundEnv.getRootElements()) {

            if (element instanceof TypeElement) {
                final TypeElement typeElement = (TypeElement) element;

                Deprecate annotation = typeElement.getAnnotation(Deprecate.class);
                if (annotation != null) {
                    String message = String.format("Class '%s' is annotated as @Deprecate: %s",
                            typeElement.getSimpleName(), annotation.message());
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.MANDATORY_WARNING, message);
                } else {
                    for (final Element eclosedElement : typeElement.getEnclosedElements()) {

                        if (eclosedElement instanceof ExecutableElement) {
                            final ExecutableElement executableElement = (ExecutableElement) eclosedElement;
                            annotation = executableElement.getAnnotation(Deprecate.class);
                            if (annotation != null) {
                                String message = String.format("The Class '%s' have deprecated method with name %s: %s",
                                        typeElement.getSimpleName(), executableElement.getSimpleName(), annotation.message());
                                processingEnv.getMessager().printMessage(Diagnostic.Kind.MANDATORY_WARNING, message);
                            }
                        }
                    }
                }


            }
        }
        return true;
    }
}
