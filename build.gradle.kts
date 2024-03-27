plugins {
    kotlin("jvm") version "1.9.22"
    id("jacoco")
}

group = "ru.huobi.bot.mikhniuk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.1.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.9")
    implementation("com.alibaba:fastjson:2.0.9.graal")
    implementation("ch.qos.logback:logback-classic:1.4.14")
    testImplementation("org.powermock:powermock-api-mockito:1.7.4")
    testImplementation("org.powermock:powermock-module-junit4:1.7.4")
    testImplementation("junit:junit:4.13.1")
    implementation("org.projectlombok:lombok:1.18.8")
    implementation("commons-lang:commons-lang:2.6")
    implementation("com.warrenstrange:googleauth:1.2.0")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

jacoco {
    toolVersion = "0.8.4"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

kotlin {
    jvmToolchain(21)
}
