buildscript {
    dependencies {
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    // Firebase
    id("com.google.gms.google-services") version "4.4.2" apply false
    alias(libs.plugins.android.library) apply false
}