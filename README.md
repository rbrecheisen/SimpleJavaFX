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
- ./gradlew :app:run