@echo off
for /f "tokens=*" %%a in (songsById.txt) do call :processline %%a

pause
goto :eof

:processline
CALL downloadOneById.bat %*

goto :eof

:eof