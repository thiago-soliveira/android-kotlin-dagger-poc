package com.sup3rnova.android.annotation

internal class ClassPackageNotFoundException(className: String)
    : Exception("The package of $className class has no name")
