INSERT INTO tipo_identificacion(id,nombre) OVERRIDING SYSTEM VALUE VALUES(1,'Cedula'),(2,'Tarjetas de identidad'),(3,'Cedula de Extranjeria');	
INSERT INTO persona(id,nombre,apellido,direccion,email,nacimiento,documento,id_tipo_identificacion,telefono) OVERRIDING SYSTEM VALUE VALUES
(1,'Maria','Consuelo','Carrera 23 # 12 34','mariaconsuelo@gmail.com','01-01-1983','98098078',1,'3103423434'),
(2,'Martha','Rodriguez','Carrera 34 # 18 34','martharodriguez@gmail.com','01-01-1982','98988089',1,'3105767844'),
(3,'Amparo','Cepeda','Carrera 78 # 1 34','amparocepeda@gmail.com','01-01-1987','68768678',1,'3103469076'),
(4,'Fabio','Castillo','Carrera 98 # 10 34','fabiocastillo@gmail.com','01-01-1983','80233556',1,'3103469076');


