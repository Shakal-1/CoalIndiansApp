@echo off
if exist "%~dp0\gradle\wrapper\gradle-wrapper.jar" (
  java -jar "%~dp0\gradle\wrapper\gradle-wrapper.jar" %*
) else (
  echo Gradle wrapper JAR not found. Please use Android Studio or install Gradle.
  gradle %*
)
