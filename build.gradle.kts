plugins {
    id("java")
    id("org.jetbrains.intellij") version "0.4.21"
}

version = "1.0.0"
group = "com.github.jef"

repositories {
    mavenCentral()
}

intellij {
    version = "LATEST-EAP-SNAPSHOT"
}

tasks.patchPluginXml {
    sinceBuild("191")
}

tasks.publishPlugin {
    username(System.getenv("JETBRAINS_USERNAME"))
    token(System.getenv("JETBRAINS_TOKEN"))
}
