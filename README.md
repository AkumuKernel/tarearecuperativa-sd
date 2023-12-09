# Tarea Recuperativa Sistemas Distribuidos

Este repositorio contiene los programas hechos por "PeerSim: A Peer-to-Peer Simulator", el cual consiste en las carpetas de peersim-1.0.5 y pastry, lo único que se hizo fue modificar los archivos necesarios para el correcto funcionamiento de este. [Peersim Original](https://peersim.sourceforge.net/) y [Pastry Original](https://peersim.sourceforge.net/code/pastry.tar.gz)

## Requisitos Previos

Para esto debe tener instalado Apache Ant y JDK8. Los puede instalar de las siguientes maneras en distribuciones de linux.

### Ubuntu y Derivados (como Debian):

```sh
sudo apt update
sudo apt install openjdk-8-jdk ant
```

### Red Hat y Derivados (como CentOS):

```sh
sudo yum install java-1.8.0-openjdk ant
```

### Arch y Derivados (como Manjaro):

```sh
sudo pacman -Syu jdk8-openjdk ant
```

### Verificación

Después de la instalación, puedes verificar que JDK y Ant se hayan instalado correctamente utilizando los siguientes comandos:
```sh
java -version
ant -version
```


## Obtención
Para poder tener los contenedores hechos para esta actividad se tiene que hacer el siguiente comando:
```sh
git clone https://github.com/AkumuKernel/tarearecuperativa-sd.git
```
## Acciones previas
Antes de iniciar todo lo primero que se debe hacer es lo siguiente:

Modificar el Makefile de pastry, en caso de que no se haya utilizado la carpeta utilizada, hay que modificar el PEERSIM_DIR, de la siguiente manera:

```makefile
.PHONY: all clean doc compile

PEERSIM_DIR=ruta/a/carpeta/peersim-1.0.5
LIB_JARS=$(wildcard lib/*.jar)

compile:
	mkdir -p classes
	javac -sourcepath src -classpath $(PEERSIM_DIR)/peersim-1.0.5.jar:$(LIB_JARS) -d classes $(wildcard src/peersim/pastry/*.java)

doc:
	mkdir -p doc
	javadoc -Xdoclint:none -sourcepath src -classpath "$(PEERSIM_DIR)/peersim-1.0.5.jar::classes" -d doc peersim.pastry

run:
	java -cp "$(LIB_JARS):$(PEERSIM_DIR)/peersim-1.0.5.jar:$(PEERSIM_DIR)/jep-2.3.0.jar:$(PEERSIM_DIR)/djep-1.0.0.jar:classes" peersim.Simulator example.cfg

all: compile doc run

clean:
	rm -fr classes doc
```

## Instalación Peersim

Dentro de la carpeta peersim-1.0.5 hay que utilizar el siguiente comando:
```sh
ant
```

Y para comprobar que se compiló correctamente se utiliza el siguiente comando:

```sh
java -cp "peersim-1.0.5.jar:jep-2.3.0.jar:djep-1.0.0.jar" peersim.Simulator example/config-example1.txt
```

## Instalación Pastry

Dentro de la carpeta pastry hay que utilizar el siguiente comando, para compilar las fuentes:
```sh
make
```

Dentro de la carpeta pastry hay que utilizar el siguiente comando, para compilar la documentacion:
```sh
make doc
```

Dentro de la carpeta pastry hay que utilizar el siguiente comando, para ejecutar el programa:
```sh
make run
```

Dentro de la carpeta pastry hay que utilizar el siguiente comando, para compilar y ejecutar el programa:
```sh
make all
```

Esto ejecutará el example.cfg dentro de la carpeta de pastry.

## Aviso Legal

El contenido de este repositorio, incluyendo pero no limitado a código fuente, documentación, archivos multimedia y otros recursos, no es de mi autoría, a menos que se indique explícitamente lo contrario. Los créditos y derechos de autor pertenecen a sus respectivos propietarios.

Cualquier contribución que realice en términos de código, informes de problemas (issues), solicitudes de extracción (pull requests) u otras formas de colaboración se considera bajo la comprensión de que usted posee los derechos necesarios o tiene permisos para contribuir con dicho contenido.

Si observa que algún material dentro de este repositorio viola derechos de autor o propiedad intelectual, le agradeceríamos que nos informara de inmediato para abordar la situación.
