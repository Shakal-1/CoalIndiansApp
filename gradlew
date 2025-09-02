#!/usr/bin/env sh
DIRNAME=`dirname "$0"`
java -version >/dev/null 2>&1 || echo "Java not found. GitHub Actions will install Java automatically."
# Try to run gradle wrapper if available
if [ -f "$DIRNAME/gradle/wrapper/gradle-wrapper.jar" ]; then
  exec java -jar "$DIRNAME/gradle/wrapper/gradle-wrapper.jar" "$@"
else
  echo "Gradle wrapper JAR not found. If you run locally, generate wrapper with 'gradle wrapper' or use Android Studio to build."
  # fallback to system gradle
  exec gradle "$@"
fi
