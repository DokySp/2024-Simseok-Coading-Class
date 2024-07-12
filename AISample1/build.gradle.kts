import org.jetbrains.kotlin.fir.declarations.builder.buildScript

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    // Firebase
    id("com.google.gms.google-services") version "4.4.2" apply false
    alias(libs.plugins.android.library) apply false
}

// apply(from = "config.gradle.kts")
// TODO: uncomment this line