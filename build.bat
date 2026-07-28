@echo off
REM ========================================
REM Script de compilación para el proyecto
REM Estructura de Datos
REM ========================================

echo.
echo ╔════════════════════════════════════════╗
echo ║   Compilando Estructura de Datos      ║
echo ╚════════════════════════════════════════╝
echo.

REM Compilar todos los archivos Java
echo Compilando archivos Java...
javac -encoding UTF-8 ClienteModelo.java ArreglosGeneral.java Dinamico.java EstructuraDatos.java Estructura.java ListaEstructurasDinamicas.java

REM Verificar si la compilación fue exitosa
if %ERRORLEVEL% EQU 0 (
    echo.
    echo ✓ Compilación exitosa
    echo.
    echo Para ejecutar los programas, use:
    echo.
    echo   • Demostración de estructuras estáticas:
    echo     java Estructura
    echo.
    echo   • Sistema interactivo de gestión de clientes:
    echo     java ListaEstructurasDinamicas
    echo.
) else (
    echo.
    echo ❌ Error en la compilación
    echo    Revise los errores mostrados arriba.
    echo.
    exit /b 1
)

exit /b 0
