plugins {
    java
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    id("org.springframework.experimental.aot") version "0.12.1"
}

group = "net.lagerwey"
version = "0.0.1-SNAPSHOT"

val dockerHubUsername: String by project
val dockerHubPassword: String by project

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    maven { url = uri("https://repo.spring.io/release") }
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.named<org.springframework.boot.gradle.tasks.bundling.BootBuildImage>("bootBuildImage") {
    imageName = "jlagerweij/rssfeedreader:${project.version}"
    builder = "paketobuildpacks/builder:tiny"
    environment = mapOf("BP_NATIVE_IMAGE" to "true")
    isPublish = true
    docker {
        publishRegistry {
            username = dockerHubUsername
            password = dockerHubPassword
        }
    }
}
