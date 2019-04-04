import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.21"
    val springDependencyVersion = "1.0.7.RELEASE"
    application
    java
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    id("io.spring.dependency-management") version springDependencyVersion
}

application {
    group = "ch.antaes.kotlin.training"
    version = "1.0-SNAPSHOT"
    mainClassName = "ch.antaes.kotlin.training.Application"
}

repositories {
    mavenCentral()
}

val micronautVersion: String by project
val logbackVersion: String by project

dependencyManagement {
    imports {
        mavenBom("io.micronaut:micronaut-bom:$micronautVersion")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.swagger.core.v3:swagger-annotations")

    implementation("io.micronaut.configuration:micronaut-hibernate-validator")
    implementation("io.micronaut:micronaut-management")

    kapt("io.micronaut:micronaut-inject-java")
    compileOnly("io.micronaut:micronaut-inject-java")
    kapt("io.micronaut.configuration:micronaut-openapi")

    runtime("ch.qos.logback:logback-classic:$logbackVersion")
    runtime("com.fasterxml.jackson.module:jackson-module-kotlin")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.all {
    when (this) {
        is JavaForkOptions -> {
            jvmArgs("-noverify")
            jvmArgs("-XX:TieredStopAtLevel=1")
            jvmArgs("-Xdebug")
            jvmArgs("-Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n")
        }
    }
}