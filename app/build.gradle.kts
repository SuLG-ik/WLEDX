plugins {
    id(Dependencies.Android.applicationPlugin)
    id(Dependencies.Kotlin.plugin)
    id(Dependencies.Ksp.plugin)
    id(Dependencies.Serialization.plugin)
    id(Dependencies.Kapt.plugin)
    id(Dependencies.Hilt.plugin)
}

android {
    namespace = Config.packageName
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.packageName
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName  = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}
kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(Dependencies.Android.core)
    implementation(Dependencies.Lifecycle.viewmodel)
    implementation(Dependencies.Lifecycle.viewmodelSavedState)
    implementation(Dependencies.Lifecycle.core)
    implementation(Dependencies.Activity.compose)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.toolingPreview)
    implementation(Dependencies.Destinations.core)
    implementation(Dependencies.Destinations.animations)
    implementation(Dependencies.Ktor.core)
    implementation(Dependencies.Ktor.cio)
    implementation(Dependencies.Ktor.contentNegotiation)
    implementation(Dependencies.Ktor.serialization)
    implementation(Dependencies.Ktor.logging)
    ksp(Dependencies.Destinations.compiler)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Hilt.core)
    implementation(Dependencies.Hilt.compose)
    kapt(Dependencies.Hilt.compiler)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(Dependencies.Compose.test)
    debugImplementation(Dependencies.Compose.tooling)
    debugImplementation(Dependencies.Compose.testManifest)
}