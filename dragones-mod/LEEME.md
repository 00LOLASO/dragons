# Dragones (Fabric 1.21.1) - Etapa 1

## Que trae esta etapa
- Un dragon verde que camina, aletea y mueve la cola (animacion por codigo).
- Huevo generador en la pestana "Huevos generadores" del creativo.
- Base del proyecto lista para las siguientes etapas.

## Como probarlo (principiante)
1. Instala JDK 21 (Temurin: https://adoptium.net).
2. Instala IntelliJ IDEA Community (gratis).
3. Descomprime este zip, abre IntelliJ -> Open -> elige la carpeta `dragones-mod`.
4. Espera a que termine de importar Gradle (barra abajo a la derecha, la primera vez tarda).
5. Arriba a la derecha elige la configuracion "Minecraft Client" y pulsa el boton verde Run.
6. En el juego: crea un mundo creativo, abre el inventario, busca "Dragon" y usa el huevo.

## Para instalarlo en tu Minecraft normal
1. En IntelliJ abre la pestana Gradle -> Tasks -> build -> build.
2. El archivo `.jar` queda en `build/libs/` (usa el que NO termina en `-sources`).
3. Ponlo en la carpeta `mods` junto con Fabric Loader 1.21.1 y Fabric API.

## Si te sale un error
Copiame el mensaje completo y lo arreglo.
