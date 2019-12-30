// Top-level build file
// These configuration options are common to all sub-projects/modules

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}
