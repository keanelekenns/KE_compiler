@echo off
for %%G in (tests\a4_tests\*.ul) do (
java Compiler %%G
)
for %%G in (tests\a4_tests\*.j) do (
java jasmin.Main -d ulclasses %%G
)
for %%G in (ulclasses\*.class) do (
echo Executing %%~nG:
java %%~nG
echo.
echo =============================
echo.
)