plugins {
    kotlin("jvm") version "1.9.25" apply false
    kotlin("plugin.spring") version "1.9.25" apply false
    id("org.springframework.boot") version "3.3.3" apply false
    id("io.spring.dependency-management") version "1.1.6" apply false
}

//java {
//    toolchain {
//        languageVersion = JavaLanguageVersion.of(17)
//    }
//}

allprojects {
    group = "io.ethan.chatting"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    plugins.withType<JavaPlugin> {
        configure<JavaPluginExtension> {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    dependencies {
        // spring
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.springframework.boot:spring-boot-starter-actuator") // 애플리케이션 모니터링 및 관리를 위한 도구

        // spring cloud
        implementation("org.springframework.cloud:spring-cloud-starter")
        implementation("org.springframework.cloud:spring-cloud-starter-config") // 중앙 집중식 설정을 위한 Config Client
        implementation("org.springframework.cloud:spring-cloud-starter-bootstrap") // Spring Cloud Config를 사용할 때 필요할 수 있는 부트스트랩 지원
        implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

        // test
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
        testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    }

    extra["springCloudVersion"] = "2023.0.0"

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

project(":api-gateway") {
    dependencies {
        implementation("org.springframework.cloud:spring-cloud-starter-gateway")
    }
}