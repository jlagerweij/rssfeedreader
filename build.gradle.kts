import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    id("org.springframework.experimental.aot") version "0.12.1"
}

group = "net.lagerwey"
version = "0.0.1-SNAPSHOT"

val DOCKER_HUB_USERNAME: String? by project
val DOCKER_HUB_PASSWORD: String? by project

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    maven { url = uri("https://repo.spring.io/release") }
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<BootBuildImage> {
    imageName = "jlagerweij/rssfeedreader:${project.version}"
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true")
    docker {
        publishRegistry {
            username = DOCKER_HUB_USERNAME
            password = DOCKER_HUB_PASSWORD
        }
    }
}
