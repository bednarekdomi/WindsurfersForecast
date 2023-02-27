plugins {
	id("java")
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.WeatherService"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("mysql:mysql-connector-java:8.0.32")
	implementation("com.googlecode.json-simple:json-simple:1.1.1")
	implementation("com.mashape.unirest:unirest-java:1.4.9")
	implementation("org.springframework.boot:spring-boot-starter-webflux:2.7.8")


}

tasks.withType<Test> {
	useJUnitPlatform()
}
