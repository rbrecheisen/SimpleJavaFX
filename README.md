# SimpleJavaFX
Template (example) project for JavaFX programs

# Setup

## Linux
- wget https://services.gradle.org/distributions/gradle-8.10-bin.zip -P /tmp
- sudo unzip -d /opt/gradle /tmp/gradle-8.10-bin.zip
- sudo ln -s /opt/gradle/gradle-8.10 /opt/gradle/latest
- .bashrc: export PATH=$PATH:/opt/gradle/latest/bin
- gradle -v

## Mac
- brew install gradle
- gradle -v

## Windows
- Download and install from https://gradle.org/releases/
- Add "bin" to PATH
- gradle -v


# Initialize project
- gradle init --type java-application --dsl kotlin
- Create file app/build.gradle.kts

plugins {
    application
}

repositories {
    mavenCentral()
}

java {
    // Use a modern toolchain (adjust if you need another JDK)
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

val javafxVersion = "23"
val osName = System.getProperty("os.name").lowercase()
val arch = System.getProperty("os.arch").lowercase()
val platform = when {
    osName.contains("win") -> "win"
    osName.contains("mac") && arch.contains("aarch64") -> "mac-aarch64" // Apple Silicon
    osName.contains("mac") -> "mac"                                     // Intel mac
    else -> "linux"
}

dependencies {
    implementation("org.openjfx:javafx-controls:$javafxVersion:$platform")
    implementation("org.openjfx:javafx-fxml:$javafxVersion:$platform")
    // add others as needed, e.g.:
    // implementation("org.openjfx:javafx-graphics:$javafxVersion:$platform")
}

application {
    // Match your package/class
    mainClass.set("com.example.App")
}

- Create App.java file:

package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello, JavaFX with Gradle!");
        Scene scene = new Scene(label, 400, 200);
        stage.setScene(scene);
        stage.setTitle("My First JavaFX App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(); // launches the JavaFX runtime
    }
}

- ./gradlew :app:run