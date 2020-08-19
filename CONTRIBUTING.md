# Contributing

Everyone is welcome to create issues and pull requests! Please try your best to be descriptive and thorough.

## Prerequisites

- JetBrains IntelliJ
- Java 8+

## Building

The following Gradle tasks help build the plugin:

```sh
./gradlew buildPlugin   # Bundles the project as a distribution.
./gradlew runIde        # Runs Intellij IDEA with installed plugin.
./gradlew verifyPlugin  # Validates completeness and contents of plugin.xml descriptors as well as plugin’s archive structure.
```
