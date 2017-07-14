package com.sup3rnova.android.annotation

import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec

internal object CodeGenerator {

    private val CLASS_NAME_PREFIX = "EasyJson"

    fun generateClass(easyJSONClass: InjectableClass): TypeSpec? {

//        val className = easyJSONClass.type.toString().split(".").last()
//
//        val builder = TypeSpec.classBuilder(CLASS_NAME_PREFIX + className)
//                .addModifiers(PUBLIC, FINAL)
//        builder.addMethod(generateAsJSONMethod(easyJSONClass))
        return null
    }

    /**
     * @return a asJSON() method for an easyJSONClass.
     */
    private fun generateAsJSONMethod(easyJSONClass: InjectableClass): MethodSpec? {

//        val JSONObject = ClassName.get("org.json", "JSONObject")
//        val JSONException = ClassName.get("org.json", "JSONException")
//
//        val paramName = easyJSONClass.type.toString().split(".").last().toLowerCase()
//        val methodBuilder = MethodSpec.methodBuilder("asJSON")
//                .addModifiers(PUBLIC, STATIC)
//                .addParameter(TypeName.get(easyJSONClass.type), paramName)
//                .addStatement("\$T jsonObject = new \$T()", JSONObject, JSONObject)
//                .returns(JSONObject)
//
//        if (easyJSONClass.variableNames.isNotEmpty()) {
//            methodBuilder.addCode("try {\n")
//        }
//
//        for (variableName in easyJSONClass.variableNames) {
//            methodBuilder.addStatement(String.format("  jsonObject.put(\"%s\", $paramName.%s)",
//                    variableName, variableName))
//
//        }
//        if (easyJSONClass.variableNames.isNotEmpty()) {
//            methodBuilder.addCode("} catch (\$T e) {\n" +
//                    "   e.printStackTrace();\n" +
//                    "}\n", JSONException)
//        }
//
//        methodBuilder.addStatement("return jsonObject")

//        return methodBuilder.build()

        return null
    }

}
