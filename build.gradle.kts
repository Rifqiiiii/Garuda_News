// build.gradle.kts (Project Level)
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Pastikan versi ini ada dan diperbarui sesuai kebutuhan
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0") // Sesuaikan dengan versi terbaru
        classpath("com.google.gms:google-services:4.4.1") // Plugin Google Services
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false // Android Gradle Plugin versi terbaru
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false // Plugin Kotlin terbaru
}

