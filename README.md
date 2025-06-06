# Reto Tecnico - Automatización de Pruebas

Este repositorio contiene la solución automatizada para los escenarios definidos en la prueba técnica, utilizando el patrón de diseño Screenplay con Serenity BDD y Cucumber.

## Escenarios Automatizados

Se han automatizado los siguientes escenarios:

1.  Seleccionar dos productos de la categoría "amor" y agregarlos al carrito de compras.
2.  Seleccionar un producto de la categoría "cumpleaños", agregarlo y eliminarlo del carrito de compras.

## Patrón de Diseño

La automatización sigue el patrón de diseño **Screenplay**, organizando el código en:

*   **Actors**: Representan los usuarios que interactúan con la aplicación.
*   **Tasks**: Definen las acciones de alto nivel que realizan los actores.
*   **Questions**: Permiten a los actores interrogar el estado de la interfaz de usuario o del sistema.
*   **UI Elements (Targets)**: Identifican los elementos con los que interactúan los actores.

## Requisitos

*   Java Development Kit (JDK) instalado (versión 8 o superior, se recomienda JDK 11).
*   Apache Maven instalado y configurado en el PATH del sistema.
*   Un navegador web compatible con Selenium (ej. Chrome, Firefox).
*   Conexión a internet para descargar dependencias.

## Ejecución de las Pruebas

Para ejecutar las pruebas automatizadas, navega a la raíz del proyecto en tu terminal y utiliza el siguiente comando de Maven:

```bash
mvn clean verify
```

Este comando compilará el proyecto, ejecutará los escenarios de Cucumber y generará un reporte detallado de Serenity BDD en la carpeta `target/site/serenity`.

## Problema Conocido: Error al Descargar Dependencias/Plugins de Maven

Durante la configuración, se ha identificado un problema recurrente en el entorno donde se desarrolló esta automatización al intentar descargar el plugin `serenity-maven-plugin` (y posiblemente otras dependencias de Serenity) desde el repositorio `s01.oss.sonatype.org`.

El error específico es:

```
Could not find artifact net.serenitybdd.maven.plugins:serenity-maven-plugin:jar:X.Y.Z in central (https://repo.maven.apache.org/maven2)
...
Caused by: org.eclipse.aether.transfer.ArtifactNotFoundException: net.serenitybdd.maven.plugins:serenity-maven-plugin:jar:X.Y.Z was not found in https://repo.maven.apache.org/maven2 during a previous attempt. This failure was cached in the local repository and resolution is not reattempted until the update interval of central has elapsed or updates are forced
```

**Diagnóstico:** Las pruebas de conexión (ping) revelaron que el servidor `s01.oss.sonatype.org` (donde se alojan los artefactos de Serenity) es inaccesible desde el entorno de ejecución actual, mientras que el repositorio central de Maven (`repo.maven.apache.org`) sí es accesible.

**Causa Probable:** Este problema no parece estar relacionado con la configuración del `pom.xml` (el cual incluye los repositorios de Serenity y está actualizado) ni con el Firewall de Windows Defender (se verificó que `java.exe` tiene permisos). La causa más probable es una restricción de red externa, como un firewall a nivel de red, un proxy (incluso si no está configurado manualmente en el sistema operativo), o un sistema de filtrado de contenido que está bloqueando específicamente el acceso a `s01.oss.sonatype.org`.

**Solución Sugerida:** Para resolver este problema, se requiere investigar la configuración de red del entorno de ejecución. Si se encuentra en una red corporativa o educativa, se recomienda contactar al departamento de TI para que revisen las posibles restricciones de acceso a `s01.oss.sonatype.org` y configuren las reglas de firewall o proxy necesarias.

Mientras el problema de conexión persista, la ejecución de `mvn clean verify` probablemente fallará al intentar descargar el plugin o dependencias de Serenity. Una vez resuelto el problema de red, ejecutar `mvn clean verify -U` (para forzar la actualización de la caché local de Maven) debería permitir la descarga exitosa de los artefactos. 