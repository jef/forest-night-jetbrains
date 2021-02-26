plugins {
    id("java")
    id("org.jetbrains.intellij") version "0.4.21"
    id("org.kordamp.gradle.markdown") version "2.2.0"
}

version = file("version.txt").readText().trim()
group = "com.github.jef"

repositories {
    mavenCentral()
}

intellij {
    version = "LATEST-EAP-SNAPSHOT"
    updateSinceUntilBuild = false
}

tasks.register<Copy>("copyMarkdown") {
    from(file("README.md"), file("CHANGELOG.md"))
    into(file("$buildDir/markdown"))
}

tasks.markdownToHtml {
  sourceDir = file("$buildDir/markdown")
  outputDir = file("$buildDir/html")
}

tasks.patchPluginXml {
    sinceBuild("203")

    val changelogPath = "$buildDir/html/CHANGELOG.html"
    val readmePath = "$buildDir/html/README.html"

    if (file(changelogPath).exists()) {
        changeNotes(file(changelogPath).readText())
    }

    if (file(readmePath).exists()) {
        pluginDescription(file(readmePath).readText())
    }
}

tasks.buildPlugin {
    dependsOn("copyMarkdown", "markdownToHtml")
}

tasks.publishPlugin {
    token(System.getenv("JETBRAINS_TOKEN"))
}
