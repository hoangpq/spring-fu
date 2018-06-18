plugins {
	id("io.spring.dependency-management")
}

val bootVersion: String by project
val coroutinesVersion: String by project

dependencyManagement {
	imports {
		mavenBom("org.springframework.boot:spring-boot-dependencies:$bootVersion") {
			bomProperty("kotlin.version", "1.2.60-dev-794")
		}
	}
	dependencies {
		dependency("org.springframework.fu:spring-fu:$version")
		dependency("org.springframework.fu.module:spring-fu-dynamic-configuration:$version")
		dependency("org.springframework.fu.module:spring-fu-jackson:$version")
		dependency("org.springframework.fu.module:spring-fu-logging-logback:$version")
		dependency("org.springframework.fu.module:spring-fu-mongodb:$version")
		dependency("org.springframework.fu.module:spring-fu-mongodb-coroutine:$version")
		dependency("org.springframework.fu.module:spring-fu-mustache:$version")
		dependency("org.springframework.fu.module:spring-fu-test:$version")
		dependency("org.springframework.fu.module:spring-fu-webflux:$version")
		dependency("org.springframework.fu.module:spring-fu-webflux-coroutine:$version")
		dependency("org.springframework.fu.module:spring-fu-webflux-netty:$version")
		dependency("org.springframework.fu.module:spring-fu-webflux-tomcat:$version")

		dependency("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
		dependency("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:$coroutinesVersion")
	}
}

publishing {
	publications {
		create(project.name, MavenPublication::class.java) {
			artifactId = "spring-fu-dependencies"
		}
	}
}