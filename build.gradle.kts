plugins {
    kotlin("jvm") version "1.9.22"
    id("jacoco")
    id("net.ltgt.apt") version "0.15"
}

group = "ru.crypto.bot.mikhniuk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
    maven(url = "https://projectlombok.org/edge-releases")
}

dependencies {
    implementation( "org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.1.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.9")
    implementation("com.alibaba:fastjson:2.0.9.graal")
    implementation("ch.qos.logback:logback-classic:1.4.14")
    implementation("org.projectlombok:lombok:1.18.32")
    implementation("commons-lang:commons-lang:2.6")
    implementation("com.warrenstrange:googleauth:1.2.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.17.0")
    implementation("io.github.binance:binance-connector-java:3.2.0")

    compileOnly("org.projectlombok:lombok:edge-releases")
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.powermock:powermock-api-mockito:1.7.4")
    testImplementation("org.powermock:powermock-module-junit4:1.7.4")
    testImplementation("junit:junit:4.13.1")
}

jacoco {
    toolVersion = "0.8.4"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

//tasks.withType(JavaCompile) {
//    options.annotationProcessorPath = configurations.apt
//}

kotlin {
    jvmToolchain(21)
}
