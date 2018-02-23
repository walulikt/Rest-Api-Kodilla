call runcrud.bat
timeout 30

start http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Can't open http://localhost:8080/crud/v1/task/getTasks
echo.
echo There were errors
goto end

:end
echo.
echo This is the end of showtasks.bat