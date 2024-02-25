INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("SuperAdmin", 0);
INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("Admin", 1);
INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("Empleado", 1);
INSERT INTO usuario_rol (tipo_rol, activo) VALUES ("Usuario", 1);


INSERT INTO usuario(id_usuario_rol, nombre, apellido, correo, contrasena, tipo_documento, documento, fecha_nacimiento, country, departamento, ciudad, direccion, created_at, update_at) VALUES (2, "Kevin", "Cotes", "kecotes@sena.edu.co", "123456", "CC", "1118854324", "2000-02-19", "Colombia", "La Guajira", "Maicao", "Calle 10 # 22-28", "2024-02-19", "2024-02-19");
INSERT INTO usuario(id_usuario_rol, nombre, apellido, correo, contrasena, tipo_documento, documento, fecha_nacimiento, country,  departamento, ciudad, direccion, created_at, update_at) VALUES (3, "Juan Miguel", "Velasquez", "jaunca@soysena.edu.co", "123456", "CC", "100305712", "1992-12-22", "Colombia", "La Guajira", "Maicao", "El Boscan", "2024-02-19", "2024-02-19");
INSERT INTO usuario(id_usuario_rol, nombre, apellido, correo, contrasena, tipo_documento, documento, fecha_nacimiento, country, departamento, ciudad, direccion, created_at, update_at) VALUES (4, "Maria", "Monterrosa", "mariamonterrosa@misena.edu.co", "123456", "CC", "947066312", "1998-08-09", "Colombia", "La Guajira", "Maicao", "Taligua", "2024-02-19", "2024-02-19");

INSERT INTO producto (nombre, descripcion, precio, imagen, created_at, updated_at) VALUES("Sika Transparente-10 Repelente Agua Incoloro Para Fachadas 3kg", "El Sika Transparente 10 es un líquido incoloro con base en siliconas, que protege las fachadas y culatas de las edifi caciones contra la penetración del agua lluvia.", 131900, "https://homecenterco.scene7.com/is/image/SodimacCO/00428?fmt=webp&fit=fit,1&wid=420&hei=420", "2024-02-19", "2024-02-19");
INSERT INTO producto (nombre, descripcion, precio, imagen, created_at, updated_at) VALUES("Tubo rectangular 76 x 38 x 0.8mm x 6m cerrajeria", "Tubo rectangular 76 x 38 x 0.8mm x 6m cerrajeria | Multimarca | Construcción", 44900, "https://homecenterco.scene7.com/is/image/SodimacCO/136224?fmt=webp&fit=fit,1&wid=420&hei=420", "2024-02-19", "2024-02-19");
INSERT INTO producto (nombre, descripcion, precio, imagen, created_at, updated_at) VALUES("Cemento Argos Gris 50kg", "Por su versatilidad, el Cemento Gris es el gran aliado de construcciones pequeñas y reparaciones. Un producto de alta calidad y variedad de usos para el logro de resultados duraderos y seguros.", 31990, "https://homecenterco.scene7.com/is/image/SodimacCO/13846?fmt=webp&fit=fit,1&wid=420&hei=420", "2024-02-19", "2024-02-19");
INSERT INTO producto (nombre, descripcion, precio, imagen, created_at, updated_at) VALUES("Pulidora 4 1/2Pulgadas 1100W 10500Rpm", "Pulidora de 4-1/2 con 720w de potencia ideal para el corte de metal y concreto gracias a su motor de 11000 rpm nos permite pulir materiales muy duros.", 641900, "https://homecenterco.scene7.com/is/image/SodimacCO/300605?fmt=webp&fit=fit,1&wid=420&hei=420", "2024-02-19", "2024-02-09");
INSERT INTO producto (nombre, descripcion, precio, imagen, created_at, updated_at) VALUES("Pulidora Black And Deker 4 2100W 10500Rpm", "Pulidora de 4-1/2 con 720w de potencia ideal para el corte de metal y concreto gracias a su motor de 11000 rpm nos permite pulir materiales muy duros.", 51900, "https://homecenterco.scene7.com/is/image/SodimacCO/300605?fmt=webp&fit=fit,1&wid=420&hei=420", "2021-02-03", "2021-02-01");

INSERT INTO usuario_has_producto (id_usuario, id_producto, created_at) VALUES (3, 1, "2024-02-19");
INSERT INTO usuario_has_producto (id_usuario, id_producto, created_at) VALUES (3, 3, "2024-02-19");
INSERT INTO usuario_has_producto (id_usuario, id_producto, created_at) VALUES (3, 4, "2024-02-19");
INSERT INTO usuario_has_producto (id_usuario, id_producto, created_at) VALUES (2, 4, "2024-02-19");
INSERT INTO usuario_has_producto (id_usuario, id_producto, created_at) VALUES (1, 2, "2024-02-19");
