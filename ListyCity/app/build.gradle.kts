plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.listycity"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.listycity"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    // Let local unit tests access android resources if needed
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    // Your existing libs
    implementation(libs.appcompat)
    implementation(libs.material)

    // (Optional) JUnit 4 kept if your template references it anywhere
    testImplementation(libs.junit)
    implementation(files("/Users/akhilvishnubhotla/Library/Android/sdk/platforms/android-36/android.jar"))

    // AndroidX test (instrumented)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // ---- JUnit 5 for local unit tests ----
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.0.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.0.1")
}

// Make Gradle run JUnit 5 tests
tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}