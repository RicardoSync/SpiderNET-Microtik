; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "SpiderNET"
#define MyAppVersion "1.5"
#define MyAppPublisher "Software Escobedo"
#define MyAppURL "https://github.com/ricardosync"
#define MyAppExeName "SpiderNET.exe"
#define MyAppAssocName MyAppName + " File"
#define MyAppAssocExt ".myp"
#define MyAppAssocKey StringChange(MyAppAssocName, " ", "") + MyAppAssocExt

[Setup]
; NOTE: The value of AppId uniquely identifies this application. Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{76EE2D0F-4698-483F-879D-D273AF9420B4}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={autopf}\{#MyAppName}
UninstallDisplayIcon={app}\{#MyAppExeName}
ChangesAssociations=yes
DisableProgramGroupPage=yes
LicenseFile=C:\Users\cisco\Desktop\Minuza\licencia.txt
; Uncomment the following line to run in non administrative install mode (install for current user only).
;PrivilegesRequired=lowest
OutputDir=C:\Users\cisco\Desktop\Minuza\Compilacion 7
OutputBaseFilename=SpiderNET
SetupIconFile=C:\Users\cisco\Desktop\Minuza\arana.ico
Password=zerocuatro04/2025
Encryption=yes
SolidCompression=yes
WizardStyle=modern

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Users\cisco\Desktop\Minuza\Java exe\v2.0.0.2\{#MyAppExeName}"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\cisco\Desktop\Minuza\jdk-23_windows-x64_bin.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Users\cisco\Desktop\Minuza\mysql-8.0.41-winx64\*"; DestDir: "C:\mysql"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Registry]
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocExt}\OpenWithProgids"; ValueType: string; ValueName: "{#MyAppAssocKey}"; ValueData: ""; Flags: uninsdeletevalue
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocKey}"; ValueType: string; ValueName: ""; ValueData: "{#MyAppAssocName}"; Flags: uninsdeletekey
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocKey}\DefaultIcon"; ValueType: string; ValueName: ""; ValueData: "{app}\{#MyAppExeName},0"
Root: HKA; Subkey: "Software\Classes\{#MyAppAssocKey}\shell\open\command"; ValueType: string; ValueName: ""; ValueData: """{app}\{#MyAppExeName}"" ""%1"""

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]

[Run]
Filename: "{app}\jdk-23_windows-x64_bin.exe"; Parameters: "/s"; Flags: waituntilterminated

; 1️⃣ Eliminar datos antiguos si existen
Filename: "{cmd}"; Parameters: "/C rmdir /S /Q {app}\mysql\data"; Flags: runhidden

; 2️⃣ Inicializar MySQL sin contraseña
;Filename: "{app}\mysql\bin\mysqld.exe"; Parameters: "--initialize-insecure --basedir={app}\mysql --datadir={app}\mysql\data"; Flags: waituntilterminated
Filename: "C:\mysql\bin\mysqld.exe"; Parameters: "--initialize-insecure --basedir=C:\mysql --datadir=C:\mysql\data"; Flags: waituntilterminated


; 3️⃣ Instalar MySQL como un servicio de Windows  
;Filename: "{app}\mysql\bin\mysqld.exe"; Parameters: "--install MySQL"; Flags: waituntilterminated
Filename: "C:\mysql\bin\mysqld.exe"; Parameters: "--install MySQL"; Flags: waituntilterminated

; 4️⃣ Iniciar el servicio de MySQL
Filename: "{sys}\sc.exe"; Parameters: "start MySQL"; Flags: waituntilterminated

; 5️⃣ Configurar usuario y contraseña
;Filename: "{app}\mysql\bin\mysql.exe"; Parameters: "--user=root --skip-password -e ""ALTER USER 'root'@'localhost' IDENTIFIED BY 'spidernet';"""; Flags: waituntilterminated
Filename: "C:\mysql\bin\mysql.exe"; Parameters: "--user=root --skip-password -e ""ALTER USER 'root'@'localhost' IDENTIFIED BY 'spidernet';"""; Flags: waituntilterminated

; 5️⃣ Crear la base de datos 'spidernet' si no existe
Filename: "C:\MySQL\bin\mysql.exe"; Parameters: "-u root -pspidernet -e ""CREATE DATABASE IF NOT EXISTS spidernet;"""; Flags: waituntilterminated

;Cargar la base de datos
;Filename: "C:\mysql\bin\mysql.exe"; Parameters: "-u root -pspidernet spidernet < C:\mysql\spidernet.sql"; Flags: waituntilterminated
Filename: "{cmd}"; Parameters: "/C C:\mysql\bin\mysql.exe -u root -pspidernet spidernet < C:\mysql\spidernet.sql"; Flags: waituntilterminated


Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

