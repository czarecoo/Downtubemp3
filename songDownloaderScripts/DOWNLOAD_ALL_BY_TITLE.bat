@echo off
for /f "tokens=*" %%a in (songsByTitle.txt) do call :processline %%a

pause
goto :eof

:processline
CALL downloadOneByTitle.bat %*

goto :eof

:eof