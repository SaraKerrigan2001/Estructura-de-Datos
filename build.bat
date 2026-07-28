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

REM Verificar que existe el directorio src
if not exist "src\" (
    echo ❌ Error: No se encuentra el directorio 'src'
    echo    Asegúrese de ejecutar este script desde la raíz del proyecto.
    exit /b 1
)

REM Crear directorio bin si no existe
if not exist "bin\" (
    echo Creando directorio 'bin'...
    mkdir bin
)

REM Limpiar compilaciones anteriores
echo Limpiando compilaciones anteriores...
if exist "bin\*.class" (
    del /Q bin\*.class 2>nul
)

echo.
echo ┌─────────────────────────────────────┐
echo │  Compilando archivos Java...        │
echo └─────────────────────────────────────┘
echo.

REM Compilar todos los archivos Java
javac -encoding UTF-8 -d bin src\ClienteModelo.java src\ArreglosGeneral.java src\Dinamico.java src\EstructuraDatos.java src\Estructura.java src\ListaEstructurasDinamicas.java

REM Verificar si la compilación fue exitosa
if %ERRORLEVEL% EQU 0 (
    echo.
    echo ✓ Compilación exitosa
    echo.
    echo ┌─────────────────────────────────────┐
    echo │  Archivos compilados en 'bin\'      │
    echo └─────────────────────────────────────┘
    echo.
    echo Para ejecutar los programas, use:
    echo.
    echo   • Demostración de estructuras estáticas:
    echo     java -cp bin Estructura
    echo.
    echo   • Sistema interactivo de gestión de clientes:
    echo     java -cp bin ListaEstructurasDinamicas
    echo.
) else (
    echo.
    echo ❌ Error en la compilación
    echo    Revise los errores mostrados arriba.
    echo.
    exit /b 1
)

exit /b 0
