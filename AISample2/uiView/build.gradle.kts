import org.jetbrains.kotlin.utils.addToStdlib.safeAs

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    // Firebase
    id("com.google.gms.google-services")

    id("androidx.navigation.safeargs")
}

android {
    namespace = "space.doky.simseok.sample2.uiview"
    compileSdk = 34

    defaultConfig {
        applicationId = "space.doky.simseok.sample2.uiview"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        dataBinding = true
        mlModelBinding = true
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Import the BoM for the Firebase platform
    implementation(platform(libs.firebase.bom.v3312))

    // Add the dependency for the Realtime Database library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation(libs.google.firebase.database.ktx)


    // Navigation library
    implementation(libs.androidx.navigation.fragment.ktx.v242)
    implementation(libs.androidx.navigation.ui.ktx.v242)

    // CameraX core library
    implementation(libs.androidx.camera.core)

    // CameraX Camera2 extensions
    implementation(libs.androidx.camera.camera2)

    // CameraX Lifecycle library
    implementation(libs.androidx.camera.lifecycle)

    // CameraX View class
    implementation(libs.androidx.camera.view)

    //WindowManager
    implementation(libs.androidx.window)

    implementation(libs.tensorflow.lite.task.vision)
    // Import the GPU delegate plugin Library for GPU inference
    implementation(libs.tensorflow.lite.gpu.delegate.plugin)
    implementation(libs.tensorflow.lite.gpu)

//    implementation(libs.tensorflow.lite.support)
    implementation(libs.tensorflow.lite.metadata)
}