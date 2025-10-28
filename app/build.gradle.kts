plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("org.beryx.jlink") version "2.25.0"
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("org.example.App")
}

javafx {
    version = "21.0.5"
    modules = listOf("javafx.controls")
}

jlink {
    imageName.set("SimpleJavaFX")
    launcher {
        name = "SimpleJavaFX"
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.App"
    }
}

tasks.register<Exec>("jlinkApp") {
    commandLine(
        "jlink",
        "--output", "build/runtime",
        "--add-modules", "java.base,javafx.controls,javafx.fxml",
        "--strip-debug",
        "--no-header-files",
        "--no-man-pages",
        "--compress", "2"
    )
}

tasks.register<Copy>("packageApp") {
    dependsOn("build", "jlinkApp")
    from("build/libs") {
        include("*.jar")
    }
    into("build/runtime/app")
}

tasks.register("createLaunchers") {
    dependsOn("packageApp")
    doLast {
        val winLauncher = file("build/runtime/bin/runApp.bat")
        val shLauncher = file("build/runtime/bin/runApp.sh")
        winLauncher.writeText("@echo off\n\"%~dp0java.exe\" -jar \"%~dp0..\\app\\app.jar\"\n")
        shLauncher.writeText("#!/usr/bin/env bash\n\"$(dirname \"$0\")/java\" -jar \"$(dirname \"$0\")/../app/app.jar\"\n")
        shLauncher.setExecutable(true)
    }
}