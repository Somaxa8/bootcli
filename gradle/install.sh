native-image --no-server --no-fallback -H:+ReportUnsupportedElementsAtRuntime -jar build/libs/bootcli.jar -H:Name=boot -H:Class=com.somacode.bootcli.AppKt
sudo rm -rf /usr/local/bin/boot
sudo mv ./boot /usr/local/bin/