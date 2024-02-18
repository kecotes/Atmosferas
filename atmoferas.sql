
-- -----------------------------------------------------
-- Schema db_atmosferas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS db_atmosferas ;

-- -----------------------------------------------------
-- Schema db_atmosferas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS db_atmosferas DEFAULT CHARACTER SET utf8 ;
USE db_atmosferas ;

-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
DROP TABLE IF EXISTS usuario ;

CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(80) NULL,
  email VARCHAR(100) NULL,
  contrasena TEXT NULL,
  tipo_documento VARCHAR(20) NULL,
  documento VARCHAR(40) NULL,
  pais VARCHAR(80) NULL,
  departamento VARCHAR(80),
  ciudad VARCHAR(80) NULL,
  direccion VARCHAR(80),
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY (id_usuario)
  );


-- -----------------------------------------------------
-- Table db_atmosferas.producto_categoria
-- -----------------------------------------------------
DROP TABLE IF EXISTS producto_categoria ;

CREATE TABLE IF NOT EXISTS producto_categoria (
  id_producto_categoria INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NULL,
  PRIMARY KEY (id_producto_categoria)
);


-- -----------------------------------------------------
-- Table db_atmosferas.producto
-- -----------------------------------------------------
DROP TABLE IF EXISTS producto ;

CREATE TABLE IF NOT EXISTS producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  producto_categoria_id INT NOT NULL,
  nombre VARCHAR(80) NULL,
  descripcion TEXT NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL,
  PRIMARY KEY (id_producto),
  INDEX fk_producto_producto_categoria1_idx (producto_categoria_id ASC) VISIBLE,
  CONSTRAINT fk_producto_producto_categoria1
    FOREIGN KEY (producto_categoria_id)
    REFERENCES db_atmosferas.producto_categoria (id_producto_categoria)
);


-- -----------------------------------------------------
-- Table db_atmosferas.proveedor
-- -----------------------------------------------------
DROP TABLE IF EXISTS proveedor ;

CREATE TABLE IF NOT EXISTS proveedor (
  id_proveedor INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(80) NULL,
  descripcion VARCHAR(200) NULL,
  tipo_documento VARCHAR(20) NULL,
  documento VARCHAR(40) NULL,
  ruta_logo TEXT NULL,
  url TEXT NULL,
  PRIMARY KEY (id_proveedor)
);


-- -----------------------------------------------------
-- Table usuario_rol
-- -----------------------------------------------------
DROP TABLE IF EXISTS usuario_rol;

CREATE TABLE IF NOT EXISTS usuario_rol (
	id_usuario_rol INT AUTO_INCREMENT NOT NULL,
    id_usuario INT NOT NULL,
    tipo_rol VARCHAR(90) NOT NULL,
    activo INT NOT NULL DEFAULT(1),
    PRIMARY KEY (id_usuario_rol),
    FOREIGN KEY (id_usuario)  REFERENCES usuario(id_usuario)
);


-- -----------------------------------------------------
-- Table db_atmosferas.usuario_has_producto
-- -----------------------------------------------------
DROP TABLE IF EXISTS usuario_has_producto ;

CREATE TABLE IF NOT EXISTS usuario_has_producto (
  usuario_id INT NOT NULL,
  producto_id INT NOT NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (usuario_id, producto_id),
  INDEX fk_usuario_has_producto_producto1_idx (producto_id ASC) VISIBLE,
  INDEX fk_usuario_has_producto_usuario1_idx (usuario_id ASC) VISIBLE,
  CONSTRAINT fk_usuario_has_producto_usuario1
    FOREIGN KEY (usuario_id)
    REFERENCES usuario (id_usuario),
  CONSTRAINT fk_usuario_has_producto_producto1
    FOREIGN KEY (producto_id)
    REFERENCES producto (id_producto)
);


-- -----------------------------------------------------
-- Table db_atmosferas.producto_imagen
-- -----------------------------------------------------
DROP TABLE IF EXISTS producto_imagen ;

CREATE TABLE IF NOT EXISTS producto_imagen (
  id_producto_imagen INT NOT NULL AUTO_INCREMENT,
  producto_id INT NOT NULL,
  ruta TEXT NULL,
  PRIMARY KEY (id_producto_imagen),
  INDEX fk_producto_imagen_producto1_idx (producto_id ASC) VISIBLE,
  CONSTRAINT fk_producto_imagen_producto1
    FOREIGN KEY (producto_id)
    REFERENCES db_atmosferas.producto (id_producto)
);


-- -----------------------------------------------------
-- Table db_atmosferas.proveedor_has_producto
-- -----------------------------------------------------
DROP TABLE IF EXISTS proveedor_has_producto ;

CREATE TABLE IF NOT EXISTS proveedor_has_producto (
  proveedor_id_proveedor INT NOT NULL,
  producto_id_producto INT NOT NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (proveedor_id_proveedor, producto_id_producto),
  INDEX fk_proveedor_has_producto_producto1_idx (producto_id_producto ASC) VISIBLE,
  INDEX fk_proveedor_has_producto_proveedor1_idx (proveedor_id_proveedor ASC) VISIBLE,
  CONSTRAINT fk_proveedor_has_producto_proveedor1
    FOREIGN KEY (proveedor_id_proveedor)
    REFERENCES db_atmosferas.proveedor (id_proveedor),
  CONSTRAINT fk_proveedor_has_producto_producto1
    FOREIGN KEY (producto_id_producto)
    REFERENCES db_atmosferas.producto (id_producto)
);


-- -----------------------------------------------------
-- Table producto_valor
-- -----------------------------------------------------
DROP TABLE IF EXISTS producto_valor ;

CREATE TABLE IF NOT EXISTS producto_valor (
  id_producto_valor INT NOT NULL AUTO_INCREMENT,
  proveedor_has_producto_proveedor_id INT NOT NULL,
  proveedor_has_producto_producto_id INT NOT NULL,
  descuento INT DEFAULT(0),
  precio_original BIGINT NULL,
  precio_descuento BIGINT NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_producto_valor),
  INDEX fk_producto_valor_proveedor_has_producto1_idx (proveedor_has_producto_proveedor_id ASC, proveedor_has_producto_producto_id ASC) VISIBLE,
  CONSTRAINT fk_producto_valor_proveedor_has_producto1
    FOREIGN KEY (proveedor_has_producto_proveedor_id , proveedor_has_producto_producto_id)
    REFERENCES proveedor_has_producto (proveedor_id_proveedor , producto_id_producto)
);


