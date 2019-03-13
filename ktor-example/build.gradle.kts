import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "Example"
version = "1.0-SNAPSHOT"

val ktorVersion = "1.1.1"
val logbackVersion = "1.2.3"
val junitVersion = "5.3.1"
val kotlinVersion = "1.3.20"

plugins {
    application
    kotlin("jvm") version "1.3.20"
    id("com.diffplug.gradle.spotless") version "3.18.0"
}

repositories {
    mavenCentral()
    jcenter()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
    mainClassName = "io.ktor.server.netty.EngineMain"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(group = "io.ktor", name = "ktor-server-netty", version = ktorVersion)
    implementation(group = "ch.qos.logback", name = "logback-classic", version = logbackVersion)
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = junitVersion)
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = junitVersion)
}
