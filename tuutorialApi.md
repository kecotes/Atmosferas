#Tutorial de crear api SpringBoot

1. Ingresar a start.spring.io
2. Seleccinar Maven, Java, Escribir su group, El artifact es el nombre del proyect y una descripción
3. Seleccionar dependencias Spring web, Lombook, Spring data jpa, MysqlDriver, Spring boot DevTools
4. Genenerar.

#### crear baner

1. Buscar en google springboot banner
2. En src/main/resources/ creamos banner.txt y pegamos el banner
3. Levantar app, ahora falta configurar la bd...

#### Configurar base de datos
 1. Ingresamos a /resources/applications.properties

`##Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/db_atmosferas
spring.datasource.username=root
spring.datasource.password=taraidb

#### Configuración de la base de datos

`##Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/db_atmosferas
spring.datasource.username=root
spring.datasource.password=taraidb

#Configuración de Hibernate
#Dialecto que utilizará para conectarse
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
#Para generar las tablas automaticamente utilizando las entidades
#Cuando levantemos la app va a crear las tablas y cuando la detengamos eliminará las tablas
spring.jpa.hibernate.ddl-auto=create
#Con estas sentencias mostramos en consola los resultados de las consultas de la base de datos
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true`

#### Crearemos las entidades

1. Creamos el package entities
2. Creamos la clases correspondientes a nuestro proyecto
3. Escribimos las propiedades de nuestras entidades y usamos lombook 
