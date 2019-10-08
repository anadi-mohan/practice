@echo off
:A
Cls
echo run...
set /p n=Name of the file:
javac %n%
Pause
java %n%
Pause
goto A