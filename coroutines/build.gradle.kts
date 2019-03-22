import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
}

group = "no.knowit.stromstad"
version = "0.5"

repositories {
    mavenCentral()
}

val coroutineVersion = "1.1.1"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")

}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}