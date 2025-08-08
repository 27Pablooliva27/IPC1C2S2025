# Git

## Inicializar un repositorio Git

Un repositorio Git es donde se guarda el historial de versiones de tu proyecto. Para crear uno dentro de una carpeta específica:

1. Abre una terminal y navega hasta la carpeta donde quieres crear el repositorio.<br/>
2. Ejecuta el siguiente comando:

```bash
git init
```

**Qué hace este comando:**

* Crea una carpeta oculta llamada .git dentro de la carpeta actual.<br/>
* Esta carpeta almacena toda la información necesaria para rastrear cambios en el proyecto.

## Ver el estado del repositorio

Este comando te permite inspeccionar el estado actual del repositorio, como archivos modificados, no rastreados, o listos para ser confirmados (staged).

1. Para ver el estado, ejecuta:

```bash
git status
```

**Qué muestra este comando:**

* Archivos que han cambiado desde la última confirmación (commit).<br/>
* Archivos nuevos que no están siendo rastreados.<br/>
* Archivos que están listos para ser confirmados.

**Ejemplo de salida:**

* Archivos no rastreados: Aparecen en rojo.<br/>
* Archivos listos para confirmar: Aparecen en verde.

## Agregar archivos al área de preparación (staging area)

Antes de confirmar los cambios, necesitas agregarlos al área de preparación. Esto indica qué cambios quieres incluir en el próximo commit.

1. Para agregar un archivo específico al área de preparación:

```bash
git add <nombre_archivo>
```

**Ejemplo:** Si tienes un archivo llamado *index.html*, escribe:

```bash
git add index.html
```

2. Para agregar todos los archivos modificados y nuevos al área de preparación:

```bash
git add .
```

**Qué hace este comando:**

* Incluye todos los archivos en el área de preparación.<br/>
* Útil para confirmar múltiples cambios de una sola vez.

## Crear un commit

Un commit es un "punto de control" en el historial de tu proyecto. Guarda los cambios preparados en el área de preparación con un mensaje descriptivo.

1. Para crear un commit, utiliza el siguiente comando:

```bash
git commit -m "Mensaje del commit"
```

**Qué hace este comando:**

* Crea un registro permanente de los cambios en el repositorio.<br/>
* El mensaje entre comillas debe describir claramente los cambios realizados, por ejemplo:

`"Corrige errores en la página de inicio"` o `"Añade funcionalidad de búsqueda"`.

## Configurar el usuario global

Antes de usar Git, es necesario configurar el nombre y correo electrónico que se asociarán a tus commits.

1. Para establecer esta configuración a nivel global (para todos los repositorios en tu computadora):

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu_correo@example.com"
```

**Qué hace este comando:**

* Asocia tu identidad con los commits en todos los repositorios de tu sistema.<br/>
* Este ajuste se guarda en el archivo de configuración global (`~/.gitconfig`).

**Ejemplo:**

```bash
git config --global user.name "Pablo Oliva"
git config --global user.email "pabloolivaa@gmail.com"
```

## Configurar el usuario local

Si necesitas usar un nombre o correo electrónico diferente para un proyecto específico, configura el usuario de forma local:

1. Para establecer esta configuración solo en el repositorio actual:

```bash
git config --local user.name "Tu Nombre Local"
git config --local user.email "tu_correo_local@example.com"
```

**Qué hace este comando:**

* Sobrescribe la configuración global para el repositorio en el que estás trabajando.<br/>
* Este ajuste se guarda en el archivo de configuración local (`.git/config`).

**Ejemplo:**

```bash
git config --local user.name "Ana López"
git config --local user.email "ana.lopez64@example.com"
```

## Ver el nombre configurado

1. Para verificar el nombre configurado actualmente (global o local), usa:

```bash
git config user.name
```

**Qué hace este comando:**

* Muestra el nombre configurado para el usuario en el contexto actual (local si está configurado; global en caso contrario).

## Ver el correo electrónico configurado

* Para verificar el correo electrónico configurado actualmente (global o local), usa:

```bash
git config user.email
```

**Qué hace este comando:**

* Muestra el correo electrónico configurado para el usuario en el contexto actual (local si está configurado; global en caso contrario).

## Ver el historial de commits

1. Para consultar el historial completo de commits realizados en el repositorio, utiliza:

```bash
git log
```

**Qué muestra este comando:**

* Hash (identificador único) de cada commit.<br/>
* Autor del commit.<br/>
* Fecha del commit.<br/>
* Mensaje descriptivo asociado al commit.

**Ejemplo de Salida:**

```sql
commit 1a2b3c4d5e6f7g8h9i0j
Author: Pablo Oliva <pablogt.59@example.com>
Date:   Mon Jan 1 12:34:56 2024 +0000

    Agrega funcionalidad de búsqueda
```

## Ver el historial de commits en una línea

1. Si deseas una vista más compacta, muestra cada commit en una sola línea:

```bash
git log --oneline
```

**Qué muestra este comando:**

* Hash abreviado de cada commit.<br/>
* Mensaje del commit en una línea.

**Ejemplo de salida:**

```bash
1a2b3c4 Agrega funcionalidad de búsqueda
5d6e7f8 Corrige errores en el diseño de la página
```

## Ver las modificaciones de los archivos en los commits

1. Para inspeccionar los cambios realizados en los archivos en cada commit, usa:

```bash
git log -p
```

**Qué muestra este comando:**

* Una lista de commits, seguida de los cambios específicos en los archivos (diferencias línea por línea).

**Cómo salir del modo de visualización:**

```bash
:q
```

## Ver el historial de commits customizado

1. Puedes personalizar la salida del historial con el siguiente comando:

```bash
git log --pretty=format:"%h - %an, %ar : %s"
```

**Qué significa cada parámetro:**

* `%h`: Hash abreviado del commit.<br/>
* `%an`: Nombre del autor.<br/>
* `%ar`: Fecha relativa (por ejemplo, "2 días atrás").<br/>
* `%s`: Mensaje del commit.

**Ejemplo de salida:**

```bash
1a2b3c4 - Juan Lopez, 2 días atrás : Agrega funcionalidad de búsqueda
5d6e7f8 - Ana Lopez, 1 semana atrás : Corrige errores en el diseño de la página
```

## Visualizar los últimos N commits

1. Para mostrar solo los últimos N commits, utiliza:

```bash
git log -n <cantidad>
```

**Ejemplo:** Para mostrar los últimos 3 commits:

```bash
git log -n 3
```

**Qué muestra este comando:**

* Una lista de los últimos N commits, en el formato predeterminado de `git log`.

## Ignorar archivos en el repositorio

1. Para evitar que ciertos archivos o carpetas sean rastreados por Git, crea un archivo llamado `.gitignore` en la raíz del proyecto.

**Ejemplo de contenido de `.gitignore`:**

```bash
# Ignorar archivos temporales
*.log
*.tmp

# Ignorar carpetas específicas
/node_modules/
/build/

# Ignorar archivos específicos
credentials.json
```

**Qué hace esto:**

* Los patrones en .gitignore indican a Git qué archivos o carpetas deben ser ignorados.<br/>
* Una vez configurado, Git no rastreará ni mostrará estos elementos como cambios.

## Descartar los cambios hechos en un archivo

1. Para deshacer los cambios locales en un archivo (sin afectar otros archivos), usa:

```bash
git restore <nombre_archivo>
```

**Ejemplo:**

```bash
git restore index.html
```

**Qué hace este comando:**

* Revierte el archivo a su estado más reciente del último commit.<br/>
* Los cambios descartados no se pueden recuperar.

## Descartar los cambios hechos después de agregar el archivo al área de preparación

1. Si un archivo ya fue agregado con git add pero quieres deshacer esa acción:

```bash
git restore --staged <nombre_archivo>
```

**Ejemplo:**

```bash
git restore --staged script.js
```

**Qué hace este comando:**

* Elimina el archivo del área de preparación, pero conserva los cambios en tu directorio de trabajo.

## Revertir un commit

1. Para revertir los cambios realizados en un commit específico:

```bash
git revert <hash_commit>
```

**Ejemplo:**

```bash
git revert abc123
```

**Qué hace este comando:**

* Crea un nuevo commit que invierte los cambios realizados en el commit especificado.<br/>
* Es útil para corregir errores sin alterar el historial del repositorio.

## Guardar temporalmente los cambios

1. Para guardar los cambios actuales sin comprometerlos en el repositorio:

```bash
git stash
```

**Qué hace este comando:**

* Guarda los cambios no confirmados (en el área de trabajo o en preparación) de manera temporal.<br/>
* El directorio vuelve a estar limpio, como si no hubieras hecho cambios.

## Ver los cambios guardados temporalmente

1. Para listar los elementos guardados con git stash:

```bash
git stash list
```

**Qué muestra este comando:**

* Una lista de las entradas guardadas en el stash, incluyendo un identificador y una descripción breve.

**Ejemplo de salida:**

```bash
stash@{0}: WIP on main: 123abc4 Añade nueva funcionalidad
stash@{1}: WIP on main: corrige errores en el diseño
```

## Recuperar los cambios guardados temporalmente

1. Para recuperar los cambios de un stash específico:

```bash
git stash apply <id>
```

**Ejemplo:**

```bash
git stash apply stash@{0}
```

**Qué hace este comando:**

* Aplica los cambios guardados temporalmente al directorio de trabajo, pero no los elimina del stash.

## Recuperar los cambios y eliminarlos de la lista

1. Para aplicar los cambios guardados y eliminarlos del stash:

```bash
git stash pop
```

**Qué hace este comando:**

* Recupera los cambios más recientes del stash.<br/>
* Los elimina automáticamente de la lista para que no ocupen espacio.

---

## Repositorios remotos
### Crear un repositorio remoto

1. Para crear un repositorio remoto en tu servidor (sin área de trabajo), usa:

```bash
git init --bare
```

**Qué hace este comando:**

* Inicializa un repositorio que actúa como servidor remoto.<br/>
* Un repositorio --bare no tiene un área de trabajo (no se pueden realizar cambios directamente).<br/>
* Se utiliza como almacenamiento central para otros repositorios.

**Ejemplo de uso:**

```bash
cd /ruta/al/servidor
git init --bare proyecto.git
```

### Agregar un repositorio remoto a un repositorio local

1. Para conectar tu repositorio local a un repositorio remoto:

```bash
git remote add <nombre_remoto> <url_remoto>
```

**Ejemplo:**

```bash
git remote add origin https://github.com/usuario/proyecto.git
```

**Qué hace este comando:**

* Asocia un repositorio remoto con el nombre `<nombre_remoto>` (usualmente *origin*).<br/>
* El `<url_remoto>` es la dirección del repositorio remoto (HTTPS, SSH, etc.).

### Listar repositorios remotos

1. Para ver los nombres de los repositorios remotos asociados a tu proyecto:

```bash
git remote
```

2. Para ver los nombres y las URLs de los repositorios remotos:

```bash
git remote -v
```

**Qué muestra:**

* El nombre del repositorio remoto (por ejemplo, origin).<br/>
* Las URLs asociadas para fetch (obtener cambios) y push (enviar cambios).

### Clonar un repositorio remoto

1. Para descargar una copia de un repositorio remoto en tu máquina local:

```bash
git clone <url_repositorio>
```

**Ejemplo:**

```bash
git clone https://github.com/usuario/proyecto.git
```

2. Para clonar y cambiar el nombre de la carpeta del proyecto:

```bash
git clone <url_repositorio> <nombre_carpeta>
```

**Ejemplo:**

```bash
git clone https://github.com/usuario/proyecto.git mi_proyecto
```

### Enviar cambios al repositorio remoto

1. Para enviar tus cambios al repositorio remoto (en una rama específica):

```bash
git push <nombre_remoto> <nombre_rama>
```

**Ejemplo:**

```bash
git push origin main
```

**Qué hace este comando:**

* Envía los commits locales al repositorio remoto.<br/>
* `origin` es el nombre del repositorio remoto.<br/>
* `main` es el nombre de la rama a la que se envían los cambios.

### Renombrar un repositorio remoto

1. Si necesitas cambiar el nombre de un repositorio remoto ya configurado:

```bash
git remote rename <nombre_actual> <nuevo_nombre>
```

**Ejemplo:**

```bash
git remote rename origin servidor_central
```

**Qué hace este comando:**

* Cambia el nombre del repositorio remoto en tu configuración local.

### Recibir cambios del repositorio remoto

1. Para descargar los cambios del repositorio remoto y fusionarlos con tu rama actual:

```bash
git pull <nombre_remoto> <nombre_rama>
```

**Ejemplo:**

```bash
git pull origin main
```

**Qué hace este comando:**

* Combina los cambios del repositorio remoto con tu rama local.<br/>
* Puede generar conflictos si hay cambios incompatibles.

### Subir un repositorio local a GitHub

1. Para vincular un repositorio local con uno remoto en GitHub y subir tus cambios:

```bash
git remote add origin <url_repositorio>
git push -u origin main
```

**Explicación:**

* *`git remote add origin`*: Asocia el repositorio local con el remoto.<br/>
* *`git push -u origin main`*: Envía los cambios de la rama main al repositorio remoto.

**Nota:** Si no has iniciado sesión en GitHub, se te pedirá que ingreses tus credenciales o autentiques mediante un token.

---

## Ramas
### Ver las ramas existentes

1. Para listar las ramas locales en tu repositorio, ejecuta:

```bash
git branch
```

**Qué muestra este comando:**

* Las ramas locales actuales.<br/>
* La rama activa se marcará con un asterisco (*) al lado.

### Crear una nueva rama

1. Para crear una rama sin cambiar a ella de inmediato:

```bash
git branch <nombre_rama>
```

**Ejemplo:**

```bash
git branch <nombre_rama>
```

### Cambiar de rama

1. Para moverte a otra rama existente:

```bash
git checkout <nombre_rama>
```

**Ejemplo:**

```bash
git checkout feature/nueva-funcionalidad
```

**Nota:** Este comando cambiará tu área de trabajo al estado de la rama seleccionada.

### Crear una rama y cambiar a ella inmediatamente

En lugar de usar dos comandos (crear y luego cambiar de rama), puedes hacerlo en un solo paso:

```bash
git checkout -b <nombre_rama>
```

**Ejemplo:**

```bash
git checkout -b feature/Ejemplo2
```

### Fusionar cambios de una rama a otra

Para fusionar el trabajo de una rama (fuente) en tu rama actual (destino):

1. Asegúrate de estar en la rama destino: 

```bash
git merge <nombre_rama_destino>
```

2. Ejecuta el siguiente comando para fusionar:

```bash
git merge <nombre_rama_fuente>
```

**Ejemplo:**

```bash
git checkout main
git merge feature/nueva-funcionalidad
```

**Nota:** Si ocurren conflictos, debes resolverlos manualmente antes de completar el merge.

### Rebase de una rama

El rebase reescribe el historial de commits de una rama sobre otra, manteniendo un historial más lineal:

```bash
git rebase <nombre_rama_base>
```

**Ejemplo:**

```bash
git rebase main
```

**Qué hace este comando:**

* Mueve los commits de tu rama actual al tope de los commits de `main`.<br/>
* Útil para mantener un historial limpio y evitar múltiples ramas divergentes.

### Ver las ramas de forma gráfica

Para visualizar el historial de ramas de manera gráfica directamente en la terminal:

```bash
git log --graph
```

**Opcional:** Añade más detalles al gráfico:

```bash
git log --graph --oneline --all
```

### Resumen práctico de uso de ramas

1. Crear una nueva rama para una funcionalidad:

```bash
git checkout -b feature/nueva-funcionalidad
```

2. Realizar cambios y confirmar los commits en la rama.

3. Fusionar los cambios a main:

```bash
git checkout main
git merge feature/nueva-funcionalidad
```

4. (Opcional) Eliminar la rama si ya no es necesaria:

```bash
git branch -d feature/nueva-funcionalidad
```


## Navegar en entre commits
### Ver un commit específico

1. Para moverte a un commit específico y ver el proyecto en ese estado, utiliza:

```bash
git checkout <hash_commit>
```

**Ejemplo:**

```bash
git checkout a1b2c3d
```

**Nota:**

* Esto coloca tu repositorio en el estado del commit especificado.<br/>
* Entrarás en un "estado detached HEAD", lo que significa que no estarás en una rama activa. Si deseas realizar cambios, considera crear una nueva rama desde ese punto.

## Ver las diferencias entre dos commits

Para comparar los cambios entre dos commits específicos:

```bash
git diff <hash_commit_inicio>..<hash_commit_final>
```

**Ejemplo:**

```bash
git diff a1b2c3d..d4e5f6g
```

## Ver las diferencias entre el código actual y el último commit

1. Si deseas ver los cambios realizados en comparación con el último commit en la rama actual:

```bash
git diff
```

**Qué muestra:**

* Los cambios realizados pero no confirmados (staged y unstaged).<br/>
* Útil para revisar tus modificaciones antes de hacer un commit.

---

## Manejo de Etiquetas
### Crear una etiqueta (tag)

1. Las etiquetas se utilizan para marcar versiones específicas del proyecto. Para crear una etiqueta anotada:

```bash
git tag -a <nombre_tag> -m "Mensaje descriptivo"
```

**Ejemplo:**

```bash
git tag -a v1.0 -m "Primera versión estable"
```

### Listar las etiquetas

Para ver todas las etiquetas creadas:

```bash
git tag
```

### Subir una etiqueta a un repositorio remoto

Para enviar una etiqueta específica al repositorio remoto:

```bash
git push origin <nombre_tag>
```

**Ejemplo:**

```bash
git push origin v1.0
```

### Subir todas las etiquetas al repositorio remoto

Si deseas enviar todas las etiquetas creadas:

```bash
git push --tags
```

### Eliminar una etiqueta localmente

Si necesitas borrar una etiqueta de tu repositorio local:

```bash
git tag -d <nombre_tag>
```

**Ejemplo:**

```bash
git tag -d v1.0
```

### Eliminar una etiqueta en el repositorio remoto

1. Primero, elimina la etiqueta localmente si aún no lo has hecho:

```bash
git tag -d <nombre_tag>
```

2. Luego, elimina la etiqueta en el repositorio remoto:

```bash
git push origin --delete <nombre_tag>
```

**Ejemplo:**

```bash
git push origin --delete v1.0
```

## Ejemplo como lo uso

```bash
git branch <rama1>

git checkout <rama1>

git add .

git commit -m "<Descripción>"

git push --set-upstream origin <rama1>

git checkout develop

git merge --no-ff <rama1>

git commit -m "Merge <rama1> into develop"

git push origin develop
```

## Eliminación de un Commit (En caso de querer borrar registro)

```bash
git reset —hard HEAD~1

git push origin HEAD —force
```