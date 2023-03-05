buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.8.2.1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application").version("7.2.2") apply false
    id("com.android.library").version("7.2.2") apply false
    id("org.jetbrains.kotlin.android").version("1.6.21") apply false

}

task<Delete>("delete") {
    delete(rootProject.buildDir)
}
