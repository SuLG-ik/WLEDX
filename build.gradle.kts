// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependencies.Android.applicationPlugin) version Dependencies.Android.agpVersion apply false
    id(Dependencies.Android.libraryPlugin) version Dependencies.Android.agpVersion apply false
    id(Dependencies.Kotlin.plugin) version Dependencies.Kotlin.version apply false
    id(Dependencies.Ksp.plugin) version Dependencies.Ksp.version apply false
    id(Dependencies.Serialization.plugin) version Dependencies.Kotlin.version apply false
    id(Dependencies.Kapt.plugin) version Dependencies.Kotlin.version apply false
    id(Dependencies.Hilt.plugin) version Dependencies.Hilt.version apply false
}