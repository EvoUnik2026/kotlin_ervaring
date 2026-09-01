plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.courseflow"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    // Kotest Runner & Assertions
    testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
    testImplementation("io.kotest:kotest-assertions-core:5.9.1")

    // MockK
    testImplementation("io.mockk:mockk:1.13.12")
}

tasks.withType<Test> {
    useJUnitPlatform()
}