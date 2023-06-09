plugins {
    id(Plugins.application)
    kotlin(Plugins.android)
    // Kapt
    kotlin(Plugins.kapt)
    // Hilt
    id(Plugins.hilt)
    // SafeArgs
    id(Plugins.safeargs)
}

android {
    namespace = "com.example.test"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.test"
        minSdk = 25
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    Dependencies.UIComponents.apply {
        // Core
        implementation(core)

        // AppCompat
        implementation(appcompat)

        // Material Design
        implementation(material)

        // UI Components
        implementation(constraintlayout)
    }

    Dependencies.Hilt.apply {
        //Hilt
        implementation(hilt)
        implementation(legacy)
        implementation(lifecycle)
        kapt(hiltCompiler)
    }

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }

    //Data
    implementation(project(":data"))

    //Domain
    implementation(project(":domain"))

    //Presentation
    implementation(project(":presentation"))
}