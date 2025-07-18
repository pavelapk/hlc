plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.maven.publish)
}

group = "com.tap"
version = "1.2.0"

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

publishing {
    repositories {
        maven {
            name = "githubPackages"
            url = uri("https://maven.pkg.github.com/pavelapk/hlc")
            credentials(PasswordCredentials::class)
        }
    }
}


mavenPublishing {

    coordinates(
        groupId = group.toString(),
        artifactId = "hlc",
        version = version.toString(),
    )
}
