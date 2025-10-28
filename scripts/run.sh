#!/bin/bash

gradle wrapper

# ./gradlew :app:run --no-configuration-cache
# configuration cache already disabled in gradle.properties
./gradlew :app:run