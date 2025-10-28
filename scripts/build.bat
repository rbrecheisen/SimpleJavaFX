@echo off

rmdir /s /q app\build
call gradlew.bat createLaunchers