# 🧪 Mutation Testing con Pitest en Spring Boot

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JUnit5](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Pitest](https://img.shields.io/badge/Pitest-FFD700?style=for-the-badge&logo=java&logoColor=black)



## 🚀 ¿Qué es Mutation Testing?

El mutation testing es una técnica para evaluar la calidad de tus pruebas unitarias, no la calidad de tu código. Su objetivo no es encontrar errores en el código de producción, sino descubrir debilidades en los tests que ya tienes.

Es como un "test de estrés" para tus pruebas. Imagina que tus tests son un sistema de seguridad. El mutation testing introduce pequeños fallos para ver si tu sistema de seguridad los detecta.

### 🔍 ¿Cómo funciona el Mutation Testing?

El proceso se puede resumir en tres pasos:

1. **Introduce Mutantes**: El mutator (el "mutador") es una herramienta que introduce automáticamente pequeños y sutiles cambios en tu código, llamados mutantes. Un mutante puede ser un cambio como:
   - Cambiar `>` por `>=`
   - Cambiar `&&` por `||`
   - Eliminar una línea de código

2. **Ejecuta las Pruebas**: Se ejecutan todas tus pruebas unitarias contra cada versión mutada de tu código.

3. **Analiza los Resultados**: Los resultados se clasifican así:
   - **Mutante Asesinado (Killed)**: Una de tus pruebas falló al ejecutarse contra el código mutado. Esto es bueno, ya que significa que tus pruebas son lo suficientemente robustas para detectar el fallo.
   - **Mutante Sobreviviente (Survived)**: Todas tus pruebas pasaron incluso con el mutante presente. Esto es malo, ya que significa que tus tests son ineficaces y no logran detectar un fallo.

El objetivo final es tener una alta tasa de mutantes "asesinados". Si un mutante sobrevive, tienes una brecha en tus tests que debes cubrir.

### 🛠️ ¿Para qué sirve Pitest?

Pitest es la herramienta más popular para hacer mutation testing en proyectos Java. Simplifica y automatiza todo el proceso que acabo de describir.

En lugar de que tú tengas que introducir los fallos manualmente y ejecutar los tests, Pitest hace todo el trabajo por ti. Se integra con Maven o Gradle y hace lo siguiente:
- Crea mutantes.
- Ejecuta los tests contra cada mutante de forma optimizada.
- Genera un informe HTML detallado que te muestra el porcentaje de mutantes asesinados (el Mutation Score), así como la ubicación exacta de los mutantes que sobrevivieron, para que sepas dónde necesitas mejorar tus pruebas.

### Visualizando el Reporte

Puedes ver un ejemplo del reporte de mutación generado:

![Mutation Testing Report](docs/images/report.png)

En resumen, el mutation testing es el concepto y la técnica, mientras que Pitest es la herramienta que te permite aplicar esa técnica de manera práctica y profesional en tus proyectos. Es una de las mejores formas de asegurar que tus tests no solo cumplan con la cobertura de código, sino que sean realmente efectivos.


## 📂 Estructura del Proyecto

```
mutation-testing-pitest/
├── .github/
│   └── workflows/
│       └── mutation-test.yml     # Configuración de GitHub Actions para Pitest
├── src/
│   ├── main/
│   │   └── java/com/qualitylabs/api/
│   │       ├── OrderService.java      # Servicio de gestión de pedidos
│   │       ├── ProductService.java    # Servicio de productos
│   │       ├── UserService.java       # Servicio de usuarios
│   │       └── ValidationService.java # Servicio de validaciones
│   └── test/
│       └── java/com/qualitylabs/api/
│           ├── OrderServiceTest.java
│           ├── ProductServiceTest.java
│           ├── UserServiceTest.java
│           └── ValidationServiceTest.java
├── .gitignore
├── pom.xml                         # Configuración de Maven y dependencias
└── README.md                       # Este archivo
```
## 🚦 Cómo Ejecutar las Pruebas de Mutación

### Ejecución Local

Para ejecutar las pruebas de mutación en tu máquina local, usa el siguiente comando de Maven:

```
mvn test org.pitest:pitest-maven:mutationCoverage
```

Este comando hará lo siguiente:
1. Ejecutará tus pruebas unitarias (para asegurarse de que pasen).
2. Lanzará el análisis de mutación de Pitest, que creará los "mutantes" y verificará si tus pruebas son lo suficientemente robustas para detectarlos.

### Visualización de Resultados

Cuando termine, encontrarás el informe completo de Pitest en:
```
target/site/pitest/index.html
```

Abre este archivo en tu navegador para ver:
- Puntuación de mutación general
- Mutantes asesinados vs. sobrevivientes
- Detalles por clase y método
- Sugerencias para mejorar tus pruebas

## 🔄 Integración con GitHub Actions

El proyecto incluye un flujo de trabajo de GitHub Actions que ejecuta automáticamente las pruebas de mutación en cada push a las ramas `main` o `develop`.

Para ver los resultados en GitHub:
1. Ve a la pestaña "Actions" en tu repositorio
2. Selecciona la ejecución más reciente del flujo de trabajo "Mutation Testing"
3. Descarga el informe desde los artefactos o consulta el resumen en la sección de resumen

## 📊 Ejemplo de Servicios y Pruebas

El proyecto incluye varios servicios de ejemplo con sus respectivas pruebas para demostrar diferentes aspectos del mutation testing:

- **ProductService**: Demuestra mutaciones aritméticas y de condiciones
- **UserService**: Muestra validaciones de edad y mensajes de bienvenida
- **OrderService**: Ejemplifica mutaciones en condiciones lógicas
- **ValidationService**: Incluye validaciones de email y contraseña

Cada servicio tiene pruebas unitarias que cubren diferentes escenarios, algunas intencionalmente débiles para demostrar cómo Pitest puede ayudarte a identificar brechas en la cobertura de pruebas.

## 📚 Recursos Adicionales

- [Documentación Oficial de Pitest](https://pitest.org/)
- [Guía de Pitest con Maven](https://maven.apache.org/plugins/maven-surefire-plugin/examples/junit-platform.html)
- [Ejemplos de Mutaciones Comunes](https://pitest.org/quickstart/mutators/)


