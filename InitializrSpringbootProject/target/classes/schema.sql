DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS tipo_identificacion;

CREATE TABLE tipo_identificacion(
	id INT GENERATED ALWAYS AS IDENTITY,
	nombre VARCHAR(70) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE persona(
   id INT GENERATED ALWAYS AS IDENTITY,
   nombre VARCHAR(70) NOT NULL,
   apellido VARCHAR(70) NOT NULL,
   direccion VARCHAR(120) NOT NULL,
   email VARCHAR(100),
   nacimiento DATE NOT NULL,
   documento VARCHAR(15),
   id_tipo_identificacion INT NOT NULL,
   telefono VARCHAR(15),
   PRIMARY KEY(id),
   CONSTRAINT fk_persona
      FOREIGN KEY(id_tipo_identificacion) 
	  REFERENCES tipo_identificacion(id)
);


