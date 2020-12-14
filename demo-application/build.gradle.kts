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
    implementation("ch.keepcalm:spring-boot-hello-starter:0.0.1-SNAPSHOT") {
        this.isChanging = false
    }
    implementation("org.springframework.boot:spring-boot-starter:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.72")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.72")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.3.4.RELEASE")
}

group = "ch.keepcalm"
version = "0.0.1-SNAPSHOT"
description = "demo-application"
java.sourceCompatibility = JavaVersion.VERSION_11


tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
