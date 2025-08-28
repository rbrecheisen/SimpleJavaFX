// plugins {
//     application
// }

// repositories {
//     mavenCentral()
// }

// java {
//     toolchain.languageVersion.set(JavaLanguageVersion.of(21))
// }

// val javafxVersion = "23"
// val osName = System.getProperty("os.name").lowercase()
// val arch = System.getProperty("os.arch").lowercase()
// val platform = when {
//     osName.contains("win") -> "win"
//     osName.contains("mac") && arch.contains("aarch64") -> "mac-aarch64" // Apple Silicon
//     osName.contains("mac") -> "mac"                                     // Intel mac
//     else -> "linux"
// }

// dependencies {
//     // IMPORTANT: include each JavaFX module you use, WITH the platform classifier
//     implementation("org.openjfx:javafx-base:$javafxVersion:$platform")
//     implementation("org.openjfx:javafx-graphics:$javafxVersion:$platform")
//     implementation("org.openjfx:javafx-controls:$javafxVersion:$platform")
//     implementation("org.openjfx:javafx-fxml:$javafxVersion:$platform") // if you use FXML
// }

// application {
//     mainClass.set("org.example.App")
//     // Helpful when running modular JavaFX, harmless otherwise:
//     applicationDefaultJvmArgs = listOf("--add-modules=javafx.controls,javafx.fxml")
// }

plugins {
  id 'application'
  id 'org.openjfx.javafxplugin' version '0.1.0'
}

repositories {
    mavenCentral()
}

javafx {
    version = "21"
    modules = [ 'javafx.controls' ]
}

mainClassName = 'HelloFX'