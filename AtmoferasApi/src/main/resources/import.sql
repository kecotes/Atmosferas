INSERT INTO usuario_rol (tipo_rol, activo) VALUES
("SuperAdmin", 0),
("Admin", 1),
("Empleado", 1),
("Usuario", 1);

INSERT INTO usuario(id_usuario_rol, nombre, apellido, email, contrasena, tipo_documento, documento, pais, departamento, ciudad, direccion, created_at, updated_at) VALUES
(2, "Kevin", "Cotes", "kecotes@sena.edu.co", "123456", "CC", "1118854324", "Colombia", "La Guajira", "Maicao", "Calle 10 # 22-28", "2024-02-19", "2024-02-19"),
(3, "Juan Miguel", "Velasquez", "jaunca@soysena.edu.co", "123456", "CC", "100305712", "Colombia", "La Guajira", "Maicao", "El Boscan", "2024-02-19", "2024-02-19"),
(4, "Maria", "Monterrosa", "mariamonterrosa@misena.edu.co", "123456", "CC", "947066312", "Colombia", "La Guajira", "Maicao", "Taligua", "2024-02-19", "2024-02-19");
