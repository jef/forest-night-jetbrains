plugins {
    id("java")
    id("org.jetbrains.intellij") version "0.4.21"
}

version = file("version.txt").readText()
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
    token(System.getenv("JETBRAINS_TOKEN"))
}
