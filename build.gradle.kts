plugins {
	java
	id("org.springframework.boot") version "3.3.3"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "org.unicore"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation ("org.postgresql:postgresql:42.7.2")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
//	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.3")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

buildscript {
	repositories {
		gradlePluginPortal()
		mavenCentral()
	}
}