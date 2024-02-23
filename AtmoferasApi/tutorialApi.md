# Tutorial de crear api SpringBoot

1. Ingresar a start.spring.io
2. Seleccinar Maven, Java, Escribir su group, El artifact es el nombre del proyect y una descripción
3. Seleccionar dependencias Spring web, Lombook, Spring data jpa, MysqlDriver, Spring boot DevTools
4. Genenerar.

### crear baner

1. Buscar en google springboot banner
2. En src/main/resources/ creamos banner.txt y pegamos el banner
3. Levantar app, ahora falta configurar la bd...

### Configurar base de datos

 1. Ingresamos a /resources/applications.properties

``` 
##Configuración de la base de datos
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
spring.jpa.properties.hibernate.format_sql=true
``` 
2. Project Structure > Modules > Dependencies > + 

### Crearemos las entidades

1. Creamos el package entities
2. Creamos la clases correspondientes a nuestro proyecto
3. Escribimos las propiedades de nuestras entidades y usamos lombook 

### Creamos la relación de uno a muchos

1. Nos ubicamos en la entidad que tiene el uno y definimos una lista de la entidad que tiene el muchos
2. Dentro de la entidad que tiene el muchos creamos el atributo
3. Ejecutamos nuestro programa

### Creamos la inserción de datos automaticos insert.sql

### Creamos los repositorios
Repositorio es el que permite guardar leer editar buscar por medio de los metodos de CrudRepository ya son estos metodos
los que hacen directamente las consultas a la bd

1. Creamos el parquete repository
2. Creamos una clase Repository para cada entidad

### Creamos la capa de persistencia
Utilizaremos el patron de diseño *data access object (DAO)* para acceder a nuestros datos de forma segura

1. Creamos el paquete persistence
2. Creamos los metodos del crud para cada entidad create find list dentro del archivo IEntityDAO
3. Creamos el paquete impl
4. Luego vamos a implementar los metodos de las interfaces anteriores en una carpeta impl/ EntityDAOImpl
5. A la clase implementaradora la extendemos de la interfaz y el IDE nos ayudara a escribir todos los metodos de la inferfaz

### Configuramos una consulta personalizada en el Repository
En el repositorio podemos crear nuestro metodo personalizado, podemos hacerlo utilizando la **notación query** y usando **query methods**
En el repositorio User está claro el ejemplo

### Creamos nuestros Service

1. Creamos el paquete service/IUserRolService
2. Los mismos metodos de mi persistencia DAO los copio en el los service 

Se copian los mismos metodos ya que estamos elaborando una arquictectura desacoplada, la capa de persistencia solo se encarga de conectarse con la base de datos.
La capa de servicio solo se encarga de toda la logíca de negocio. Esto es excenlente ya que permite que el proyecto crezca a futuro

3. Creamos el paquete impl
4. Creamos las implementaciones UserRolServiceImpl y UserServiceImpl
5. Intellij nos creará las implementaciones automaticamente
6. Implementamos los metodos

### Creamos los controladores

1. Paquete controllers
2. Añadimos las clases al paquete - EntityController
3. Añadimos las anotaciones RestController y ResquestMapping que permite que la clase sea asociada a una ruta

> En la capa de servicios cuando implementamos un metodo es donde se ubica la logica, por ejemplo en vez de traer un solo id, tambien
> queremos que ese id sea calculado con otro numero o se genere un codigo cualquiera, cuando querramos cualquier logica va en la capa Servcios
> Los servicios se encargan de toda la logíca y luego estos servicios invocan a la capa de persistencia encargada de las operaciones con bases de datos


Para poder usar el metodo que busca un usuario por id solo es inyectar el service pero el metodo no puede devolver la entidad
por lo que se utiliza un patron de diseño considerado como una buena practica llamado **Data Object Transfer (DTO)**


4. Dentro del DTO copiamos practicamente los mismos atributos de la entidad quitando las anotaciones lombook
Basicamente ese objecto nuevo DTO es el que nuestro controller va a retornar, y así no retornamos una Entity