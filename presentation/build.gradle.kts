plugins {
    id(Plugins.library)
    kotlin(Plugins.android)
    // Kapt
    kotlin(Plugins.kapt)
    // Hilt
    id(Plugins.hilt)
    // SafeArgs
    id(Plugins.safeargs)
}

android {
    namespace = "com.example.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 25
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    // ViewBinding
    buildFeatures.viewBinding = true
}

dependencies {
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
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
    // Fragment
    implementation(Dependencies.Fragment.fragment)

    //Hilt
    Dependencies.Hilt.apply {
        implementation(hilt)
        implementation(legacy)
        implementation(lifecycle)
        kapt(hiltCompiler)
    }
    Dependencies.Retrofit.apply {
        // Retrofit
        implementation(retrofit2)
        implementation(gson)
    }

    // Navigation
    Dependencies.Navigation.apply {
        implementation(navigation)
        implementation(navigationUI)
    }
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }

    // ViewBindingPropertyDelegate
    implementation(Dependencies.Viewbinding.viewbinding)

    //Recycler
    implementation ("androidx.recyclerview:recyclerview:1.3.0")
    implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")

    //Domain
    implementation(project(":domain"))
}