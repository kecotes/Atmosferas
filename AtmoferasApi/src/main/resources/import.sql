INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("SuperAdmin", 0);
INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("Admin", 1);
INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("Empleado", 1);
INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("Usuario", 1);


INSERT INTO usuario(id_usuario_rol, nombre, apellido, correo, contrasena, tipo_documento, documento, fecha_nacimiento, country, departamento, ciudad, direccion, created_at, update_at) VALUES (2, "Kevin", "Cotes", "kecotes@sena.edu.co", "123456", "CC", "1118854324", "2000-02-19", "Colombia", "La Guajira", "Maicao", "Calle 10 # 22-28", "2024-02-19", "2024-02-19");
INSERT INTO usuario(id_usuario_rol, nombre, apellido, correo, contrasena, tipo_documento, documento, fecha_nacimiento, country,  departamento, ciudad, direccion, created_at, update_at) VALUES (3, "Juan Miguel", "Velasquez", "jaunca@soysena.edu.co", "123456", "CC", "100305712", "1992-12-22", "Colombia", "La Guajira", "Maicao", "El Boscan", "2024-02-19", "2024-02-19");
INSERT INTO usuario(id_usuario_rol, nombre, apellido, correo, contrasena, tipo_documento, documento, fecha_nacimiento, country, departamento, ciudad, direccion, created_at, update_at) VALUES (4, "Maria", "Monterrosa", "mariamonterrosa@misena.edu.co", "123456", "CC", "947066312", "1998-08-09", "Colombia", "La Guajira", "Maicao", "Taligua", "2024-02-19", "2024-02-19");
