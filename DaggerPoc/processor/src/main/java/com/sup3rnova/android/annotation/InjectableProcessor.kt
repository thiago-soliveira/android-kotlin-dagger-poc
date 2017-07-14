package com.sup3rnova.android.annotation

import com.google.auto.service.AutoService
import com.squareup.javapoet.JavaFile
import com.squareup.kotlinpoet.*
import com.sup3rnova.android.core.annotation.Injectable
import java.io.IOException
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Modifier.ABSTRACT
import javax.lang.model.element.Modifier.PUBLIC
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.tools.Diagnostic.Kind.ERROR

@AutoService(Processor::class)
class InjectableProcessor : AbstractProcessor() {

    private lateinit var messager: Messager
    private var ANNOTATION = Injectable::class.java

    @Synchronized override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        messager = processingEnv.messager
    }

    override fun getSupportedAnnotationTypes(): Set<String> {
        return setOf(Injectable::class.java.canonicalName)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(annotations: Set<TypeElement>, roundEnv: RoundEnvironment): Boolean {
        val typeElements =
                roundEnv.getElementsAnnotatedWith(Injectable::class.java)
                        // Filter annotated classes which is defined
                        // with @Target(AnnotationTarget.CLASS)
                        .filterIsInstance<TypeElement>()
                        // Filer annotated classes which is public and is not abstract
                        .filter { isValidClass(it) }
                        .map {
                            buildAnnotatedClass(it)
                        }

        val greeterClass = ClassName("", "Greeter")
        val kotlinFile = KotlinFile.builder("", "HelloWorld")
                .addType(TypeSpec.classBuilder("Greeter")
                        .primaryConstructor(FunSpec.constructorBuilder()
                                .addParameter("name", String::class)
                                .build())
                        .addProperty(PropertySpec.builder("name", String::class)
                                .initializer("name")
                                .build())
                        .addFun(FunSpec.builder("greet")
                                .addStatement("println(%S)", "Hello, \$name")
                                .build())
                        .build())
                .addFun(FunSpec.builder("main")
                        .addParameter("args", String::class, KModifier.VARARG)
                        .addStatement("%T(args[0]).greet()", greeterClass)
                        .build())
                .build()

        kotlinFile.writeTo(System.out)

        //Generate JsonUtil Class using JavaPoet.
//        generateJsonUtilClass(typeElements)

        return true
    }

    private fun isValidClass(annotatedClass: TypeElement): Boolean {

        // if class is not a public class
        if (!annotatedClass.modifiers.contains(PUBLIC)) {
            val message = String.format("Classes annotated with %s must be public.",
                    "@" + ANNOTATION.simpleName)
            println("Classes annotated with %s must be public.")
            messager.printMessage(ERROR, message, annotatedClass)
            return false
        }

        // if the class is a abstract class
        if (annotatedClass.modifiers.contains(ABSTRACT)) {
            val message = String.format("Classes annotated with %s must not be abstract.",
                    "@" + ANNOTATION.simpleName)
            println("Classes annotated with %s must not be abstract.")

            messager.printMessage(ERROR, message, annotatedClass)
            return false
        }

        return true
    }

    private fun buildAnnotatedClass(typeElement: TypeElement): InjectableClass {

        val variableNames = typeElement.enclosedElements
                .filterIsInstance<VariableElement>()
                .map { it.simpleName.toString() }

        return InjectableClass(typeElement, variableNames)
    }

    @Throws(ClassPackageNotFoundException::class, IOException::class)
    private fun generateJsonUtilClass(easyJSONClasses: List<InjectableClass>) {
        if (easyJSONClasses.isEmpty()) {
            return
        }

        for (easyJSONClass in easyJSONClasses) {
            val packageName = Utils.getPackageName(processingEnv.elementUtils,
                    easyJSONClass.typeElement)
            val generatedClass = CodeGenerator.generateClass(easyJSONClass)

            val javaFile = JavaFile.builder(packageName, generatedClass).build()
            javaFile.writeTo(processingEnv.filer)
        }
    }
}

