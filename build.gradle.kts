plugins {
    id("java")
}

group = "dev.tomas"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Project Reactor
    implementation("io.projectreactor:reactor-core:3.5.10")
    // Para test: https://www.baeldung.com/reactive-streams-step-verifier-test-publisher
    // NO lo vamos a usar, pero lo dejo por si acaso
    // testImplementation("io.projectreactor:reactor-test:3.5.10")

    // R2DBC
    implementation("io.r2dbc:r2dbc-h2:1.0.0.RELEASE")
    implementation("io.r2dbc:r2dbc-pool:1.0.0.RELEASE")

    // Lombook para generar código, poner todo esto para que funcione
    implementation("org.projectlombok:lombok:1.18.28")
    testImplementation("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")

    // Logger
    implementation("ch.qos.logback:logback-classic:1.4.11")

    // Para nuestros test
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")

    // Mockito para nuestros test con JUnit 5
    testImplementation("org.mockito:mockito-junit-jupiter:5.5.0")
    testImplementation("org.mockito:mockito-core:5.5.0")
}

tasks.test {
    useJUnitPlatform()
}