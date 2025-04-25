
@echo off
set FX="C:\Users\ricardo\Downloads\Windows11\libMIcrotik\javafx-sdk-24.0.1\lib"
java --module-path %%FX%% --add-modules javafx.controls,javafx.fxml -Dprism.order=sw -jar SpiderNET.jar
pause
