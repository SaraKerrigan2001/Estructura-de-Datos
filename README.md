# Estructura-de-Datos

Proyecto de estructuras de datos en Java con implementaciones de arreglos estáticos y listas dinámicas.

## 📋 Descripción

Este proyecto demuestra el uso de diferentes estructuras de datos en Java, incluyendo:
- **Arreglos estáticos**: Implementaciones con tamaño fijo
- **Listas dinámicas**: Implementaciones con ArrayList
- **Modelo de datos**: Clase Cliente con validaciones
- **Operaciones CRUD**: Crear, leer, actualizar y eliminar

## 📁 Estructura del Proyecto

```
Estructuradatos/
├── src/                          # Código fuente
│   ├── ArreglosGeneral.java
│   ├── ClienteModelo.java
│   ├── Dinamico.java
│   ├── Estructura.java
│   ├── EstructuraDatos.java
│   └── ListaEstructurasDinamicas.java
├── bin/                          # Archivos compilados (generado)
├── build.bat                     # Script de compilación
├── run.bat                       # Script de ejecución con menú
├── .gitignore
└── README.md
```

## 🚀 Características

### ArreglosGeneral y EstructuraDatos
- Arreglos estáticos con capacidad fija
- Validación de datos de entrada
- Manejo de valores null
- Búsqueda de elementos
- Control de capacidad (lleno/vacío)

### ClienteModelo
- Encapsulación completa con getters/setters
- Validaciones en constructor y setters
- Métodos equals, hashCode y toString
- Comparación por cédula única

### Dinamico (Lista Dinámica)
- Gestión dinámica de clientes con ArrayList
- Búsqueda por cédula y nombre
- Operaciones CRUD completas
- Validación de duplicados

### ListaEstructurasDinamicas (Sistema Interactivo)
- Menú interactivo completo
- Agregar, listar, buscar, eliminar y actualizar clientes
- Validaciones de entrada
- Confirmaciones para operaciones críticas
- Estadísticas del sistema

## 🛠️ Requisitos

- **Java JDK 8 o superior**
- Windows (scripts .bat incluidos)
- `javac` y `java` en el PATH del sistema

## 📦 Compilación

### Opción 1: Usar script de compilación
```bash
build.bat
```

### Opción 2: Compilación manual
```bash
javac -encoding UTF-8 -d bin src\ClienteModelo.java src\ArreglosGeneral.java src\Dinamico.java src\EstructuraDatos.java src\Estructura.java src\ListaEstructurasDinamicas.java
```

## ▶️ Ejecución

### Opción 1: Menú interactivo (recomendado)
```bash
run.bat
```

### Opción 2: Ejecutar programas directamente

**Demostración de estructuras estáticas:**
```bash
java -cp bin Estructura
```

**Sistema de gestión de clientes:**
```bash
java -cp bin ListaEstructurasDinamicas
```

## 📚 Ejemplos de Uso

### Demostración de Estructuras Estáticas
Este programa muestra:
- Creación de arreglos con capacidad fija
- Agregar elementos hasta llenar el arreglo
- Búsqueda de elementos
- Validaciones automáticas

### Sistema de Gestión de Clientes
Menú interactivo que permite:
1. **Agregar cliente**: Solicita nombre y cédula
2. **Listar clientes**: Muestra todos los clientes registrados
3. **Buscar por cédula**: Búsqueda exacta por cédula
4. **Buscar por nombre**: Búsqueda parcial por nombre
5. **Eliminar cliente**: Con confirmación
6. **Actualizar datos**: Modificar nombre o cédula
7. **Estadísticas**: Total de clientes y estado

## ✨ Mejoras Implementadas

- ✅ Nomenclatura siguiendo convenciones de Java (PascalCase, camelCase)
- ✅ Encapsulación completa con atributos privados
- ✅ Validaciones exhaustivas de datos de entrada
- ✅ Manejo de excepciones (IllegalArgumentException, IndexOutOfBoundsException)
- ✅ Documentación JavaDoc completa en todas las clases
- ✅ Métodos adicionales (buscar, eliminar, actualizar, estadísticas)
- ✅ Interfaz de usuario mejorada con formato visual
- ✅ Scripts de compilación y ejecución automatizados
- ✅ Estructura organizada con carpetas src/ y bin/

## 🔧 Convenciones de Código

El proyecto sigue las convenciones estándar de Java:
- **Clases**: PascalCase (`ClienteModelo`, `ArreglosGeneral`)
- **Métodos y variables**: camelCase (`agregarCliente`, `listaClientes`)
- **Constantes**: UPPER_SNAKE_CASE (`CAPACIDAD_DEFAULT`)

## 📝 Notas

- Los archivos se compilan con codificación UTF-8 para soportar caracteres especiales
- El directorio `bin/` se crea automáticamente durante la compilación
- Los archivos fuente están organizados en la carpeta `src/`
- Se recomienda usar el script `build.bat` antes de ejecutar por primera vez
- Todos los métodos públicos están documentados con JavaDoc

## 👥 Autor

Proyecto desarrollado como ejemplo de estructuras de datos en Java.

## 📄 Licencia

Este proyecto es de código abierto y está disponible para fines educativos.