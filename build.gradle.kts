plugins {
    java
    `maven-publish`
}

repositories {
    mavenLocal()
    maven("http://repo.maven.apache.org/maven2")
}

dependencies {
    compile("org.eclipse.jgit:org.eclipse.jgit:4.4.1.201607150455-r")

    testImplementation("junit:junit:4.12")
    testImplementation("org.assertj:assertj-core:3.11.1")
}

group = "io.github.java-diff-utils"
description = "java-diff-utils"
version = "4.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

val javadocJar by tasks.registering(Jar::class) {
    classifier = "javadoc"
    from(destinationDir)
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class.java) {
            from(components["java"])
            artifact(javadocJar.get())
        }
    }
}
