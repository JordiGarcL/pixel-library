plugins {
    id("com.android.library")
    `maven-publish`
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.2")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.03"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.1.0")
}

tasks.register<Jar>("sourcesJar") {
    from(android.sourceSets["main"].java.srcDirs)
    archiveClassifier.set("sources")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.jordigarcial.watabou"
            artifactId = "pixel-library"
            version = android.defaultConfig.versionName

            artifact("$buildDir/outputs/aar/library-release.aar")
            artifact(tasks["sourcesJar"])
        }
    }

    repositories {
        maven {
            url = uri(extra["github_repo_url"].toString())
            credentials {
                username = extra["github_username"].toString()
                password = extra["github_token"].toString()
            }
        }
    }
}
