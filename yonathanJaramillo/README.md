# Procesador de Textos

## Descripción
Este proyecto es un sistema de procesamiento de texto que identifica errores específicos en un documento. Utiliza métodos de búsqueda binaria para localizar eficientemente los errores y mostrarlos al usuario.

## Cómo Ejecutar el Programa
Para ejecutar el programa, sigue estos pasos:

1. **Compilar el Código:**
   - Abre una terminal en la raíz del proyecto.
   - Ejecuta `javac -cp src src/Main.java` para compilar los archivos de código fuente.

2. **Ejecutar el Programa:**
   - Desde la misma terminal, ejecuta `java -cp src Main` para iniciar el programa.

3. **Ver Resultados:**
   - Una vez ejecutado el programa, observarás en la terminal los errores identificados en el documento de texto.

## Funcionamiento del Código
- `Main.java`: Contiene el método `main` que orquesta la lectura del archivo de texto, la búsqueda de errores utilizando métodos de la clase `Procesador`, y la presentación de resultados.
- `Procesador.class`: Define los métodos de procesamiento de texto que son llamados por `Main.java`. Asegúrate de que este archivo compilado está disponible en el directorio `src`.
- `LoR.txt`: Archivo de ejemplo que contiene el texto a procesar.

## Documentación
Para más detalles sobre cada clase y método, consulta los archivos HTML en la carpeta `Documentacion` que proporcionan una descripción completa de la API.
