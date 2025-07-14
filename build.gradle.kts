plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinter)
    id("maven-publish")
}

group = "com.tap.hlc"
version = "1.1.0"

kotlin {
    jvm()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    linuxX64()

    sourceSets {
        commonMain {
            dependencies {
                api(libs.okio.core)
                api(libs.kotlinx.datetime)
                api(libs.result)
                api(libs.uuid)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
                implementation(libs.okio.fakefilesystem)
            }
        }
    }
}