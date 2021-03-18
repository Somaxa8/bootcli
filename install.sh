#!/usr/bin/env sh

# sdk default java 20.3.0.r8-grl
bash -x gradlew build
native-image -jar build/libs/app.jar
mv app ~/.sdkman/candidates/java/20.3.1.2.r8-grl/bin/
bootcli