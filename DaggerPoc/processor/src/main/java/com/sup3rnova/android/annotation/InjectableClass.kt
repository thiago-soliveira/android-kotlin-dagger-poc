package com.sup3rnova.android.annotation

import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeMirror


internal class InjectableClass(val typeElement: TypeElement, val variableNames: List<String>) {

    val type: TypeMirror
        get() = typeElement.asType()

}