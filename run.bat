@echo off
REM ========================================
REM Script para ejecutar los programas
REM Estructura de Datos
REM ========================================

setlocal enabledelayedexpansion

:menu
cls
echo.
echo ╔════════════════════════════════════════╗
echo ║   Ejecutar Estructura de Datos        ║
echo ╚════════════════════════════════════════╝
echo.
echo Seleccione el programa a ejecutar:
echo.
echo   1. Demostración de Estructuras Estáticas
echo      (ArreglosGeneral y EstructuraDatos)
echo.
echo   2. Sistema Interactivo de Gestión de Clientes
echo      (Lista Dinámica con menú)
echo.
echo   0. Salir
echo.
set /p opcion="Ingrese su opción: "

if "%opcion%"=="1" goto estructura
if "%opcion%"=="2" goto lista
if "%opcion%"=="0" goto fin
echo.
echo ❌ Opción inválida. Presione cualquier tecla para continuar...
pause >nul
goto menu

:estructura
cls
echo.
echo ╔════════════════════════════════════════╗
echo ║   Ejecutando Estructura.java          ║
echo ╚════════════════════════════════════════╝
echo.
if not exist "bin\Estructura.class" (
    echo ❌ Error: El programa no está compilado.
    echo    Ejecute 'build.bat' primero.
    echo.
    pause
    goto menu
)
java -cp bin Estructura
echo.
echo ───────────────────────────────────────
echo Presione cualquier tecla para volver al menú...
pause >nul
goto menu

:lista
cls
echo.
echo ╔════════════════════════════════════════╗
echo ║   Sistema de Gestión de Clientes      ║
echo ╚════════════════════════════════════════╝
echo.
if not exist "bin\ListaEstructurasDinamicas.class" (
    echo ❌ Error: El programa no está compilado.
    echo    Ejecute 'build.bat' primero.
    echo.
    pause
    goto menu
)
java -cp bin ListaEstructurasDinamicas
echo.
echo ───────────────────────────────────────
echo Presione cualquier tecla para volver al menú...
pause >nul
goto menu

:fin
echo.
echo ¡Hasta pronto!
echo.
exit /b 0
