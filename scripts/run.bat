@echo off

@REM regenerate gradle-wrapper.jar (it's not pushed to Git)
call gradle wrapper

@REM call gradlew.bat :app:run --no-configuration-cache
@REM configuration cache already disabled in gradle.properties
call gradlew.bat :app:run