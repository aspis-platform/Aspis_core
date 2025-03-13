plugins {
    kotlin("jvm")
}

apply(plugin = "org.springframework.boot")
apply(plugin = "io.spring.dependency-management")
apply(plugin = "org.jetbrains.kotlin.plugin.spring")

dependencies {
    implementation(project(":application-presentation"))
    implementation(project(":application-core"))
    implementation(project(":application-persistence"))

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("mysql:mysql-connector-java:8.0.33")
}

tasks.named<Task>("compileKotlin") {
    dependsOn("processResources")
}

tasks.named<Task>("compileJava") {
    dependsOn("compileKotlin")
}

tasks.named<Task>("classes") {
    dependsOn("compileJava")
}