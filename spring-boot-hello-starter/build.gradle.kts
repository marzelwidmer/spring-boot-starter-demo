/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    `maven-publish`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.3.4.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.4.10")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.3.4.RELEASE")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.10")
}

group = "ch.keepcalm"
version = "0.0.1-SNAPSHOT"
description = "spring-boot-hello-starter"
java.sourceCompatibility = JavaVersion.VERSION_11

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
