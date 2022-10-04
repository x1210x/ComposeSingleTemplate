plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    val buildProp = file(rootProject.file("build.properties"))
    compileSdk = Versions.getProperty(buildProp, "compileSdk").toInt()

    defaultConfig {
        applicationId = Versions.getProperty(buildProp, "applicationId")
        minSdk = Versions.getProperty(buildProp, "minSdk").toInt()
        targetSdk = Versions.getProperty(buildProp, "targetSdk").toInt()
        versionCode = Versions.getProperty(buildProp, "versionCode").toInt()
        versionName = Versions.getProperty(buildProp, "versionName")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "baseUrl", "\"${Versions.getProperty(buildProp, "baseUrl")}\"")
    }
    signingConfigs {
        getByName("debug") {
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storeFile = file(rootProject.file("debug.keystore"))
            storePassword = "android"
        }
        create("release") {

        }
    }
    buildTypes {
        getByName("debug") {

        }
        getByName("release") {
            isMinifyEnabled = false
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
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))
    androidTestApi(platform(project(":depconstraints")))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}")

    // accompanist
    implementation(Libs.ACCOMPANIST_SYSTEM_UI_CONTROLLER)
    implementation(Libs.ACCOMPANIST_APPCOMPAT_THEME)
    implementation(Libs.ACCOMPANIST_PAGER)
    implementation(Libs.ACCOMPANIST_PAGER_INDICATOR)
    implementation(Libs.ACCOMPANIST_PERMISSIONS)
    implementation(Libs.ACCOMPANIST_PLACEHOLDER_MATERIAL)
    implementation(Libs.ACCOMPANIST_PLACEHOLDER)
    implementation(Libs.ACCOMPANIST_FLOW_LAYOUT)
    implementation(Libs.ACCOMPANIST_NAVIGATION_ANIMATION)
    implementation(Libs.ACCOMPANIST_NAVIGATION_MATERIAL)
    implementation(Libs.ACCOMPANIST_DRAWABLE_PAINTER)
    implementation(Libs.ACCOMPANIST_SWIPE_TO_REFRESH)

    // Compose
    implementation(Libs.COMPOSE_UI)
    implementation(Libs.COMPOSE_MATERIAL)
    implementation(Libs.COMPOSE_MATERIAL3)
    implementation(Libs.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Libs.ACTIVITY_COMPOSE)
    implementation(Libs.NAVIGATION_COMPOSE)
    implementation(Libs.LIFECYCLE_VIEW_MODEL_COMPOSE)
    implementation(Libs.CONSTRAINT_LAYOUT_COMPOSE)
    debugImplementation(Libs.COMPOSE_UI_TOOLING)

    // Android Architecture Components
    implementation(Libs.LIFECYCLE_RUNTIME_KTX)

    // Retrofit
    implementation(Libs.RETROFIT)
    implementation(Libs.RETROFIT_GSON_CONVERTER)
    implementation(Libs.OKHTTP_LOGGING_INTERCEPTOR)

    // Coil
    implementation(Libs.COIL)
    implementation(Libs.COIL_COMPOSE)

    // Timber
    implementation(Libs.TIMBER)

    // Hilt
    implementation(Libs.HILT_ANDROID)
    kapt(Libs.HILT_COMPILER)
    implementation(Libs.HILT_NAVIGATION)
}