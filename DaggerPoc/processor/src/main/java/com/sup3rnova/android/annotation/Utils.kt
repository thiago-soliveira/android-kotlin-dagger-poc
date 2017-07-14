package com.sup3rnova.android.annotation

import javax.lang.model.element.TypeElement
import javax.lang.model.util.Elements

internal object Utils {

    @Throws(ClassPackageNotFoundException::class)
    fun getPackageName(elementUtils: Elements, typeElement: TypeElement): String {
        val pkg = elementUtils.getPackageOf(typeElement)
        if (pkg.isUnnamed) {
            throw ClassPackageNotFoundException(typeElement.simpleName.toString())
        }
        return pkg.qualifiedName.toString()
    }
}
