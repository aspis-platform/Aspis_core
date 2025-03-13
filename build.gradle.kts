import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.0" apply false
	id("io.spring.dependency-management") version "1.1.4" apply false
	kotlin("jvm") version "1.9.20" apply false
	kotlin("plugin.spring") version "1.9.20" apply false
	kotlin("plugin.jpa") version "1.9.20" apply false
}

allprojects {
	group = "team.gram"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "21"
		}
	}

	tasks.withType<JavaCompile> {
		targetCompatibility = "21"
		sourceCompatibility = "21"
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

