# Taller 3
En este taller desarollaremos una esperimento de framework donde vemos una implemntcaion realizada parecida al funcionamiento de Spark. 
#

# Pre-requisitos
  -Java SE Development Kit 8
  -Java SE Runtime Environment 8
  -Apache Maven.

# Instalación
Copiaremos la aplicación en nuestra maquina local con el siguiente comando
```sh
$ git clone https://github.com/jose-gome/AREP_Taller-4.git
 ```
Ahora compilaremos y empaquetaremos con el siguiente comando
```sh
$ mvn package 
```
Para ejecuta la aplicación:
```sh
$ mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.Spark.SparkForMe"
```
## Funcionamiento de la aplicación
La aplicación inserta en una base de datos atreves de esta página web
![](/Imagenes/insertarDatos.png)
Y para consultar los datos de es atreves de /Datos
![](/Imagenes/Datos.png)
# Generar Javadoc

```sh
$ mvn javadoc:javadoc 
```
# Integracion Continua
[![CircleCI](https://circleci.com/gh/jose-gome/AREP-2020-1-Calculadora-estadistica.svg?style=svg)](https://circleci.com/gh/jose-gome/AREP_Taller-4)

```
```

# Construido con
  - [Maven](https://maven.apache.org/) - Dependency Management
  - [Heroku](https://cli-auth.heroku.com/) plataforma como servicio de computación en la Nube que soporta distintos lenguajes de programación
 
# Autores
  - José Luis Gómez Camacho - Estudiante de la Escuela Colombiana De Ingeniería Julio Garavito
# Licencia
Este proyecto está licenciado bajo la GNU v3.0 - ver el archivo LICENSE.md para más detalles
