@echo off
title Sistema Imobiliario
cls

echo ===========================
echo    Carregando o sistema...
echo ===========================
timeout /t 2 >nul

set JAR_FILE=%~dp0Java-POO-Trabalho-JDBC.jar
set JAVA_EXE=%BASE_DIR%runtime\bin\java.exe

if not exist "%JAR_FILE%" (
    echo Arquivo Java-POO-Trabalho-JDBC.jar nao encontrado!
    pause
    exit /b
)



java -jar --enable-native-access=ALL-UNNAMED "%JAR_FILE%"

pause
