-- CREACION DE LA BASE DE DATOS --

DROP DATABASE IF EXISTS Prision_VI_Región;
CREATE DATABASE Prision_VI_Región;
USE Prision_VI_Región; 

-- CREACION DE TABLAS --


CREATE TABLE Turnos(
    id INT AUTO_INCREMENT,
    tipo VARCHAR(20),
    hora_inicio DATETIME,
    hora_fin DATETIME,

    PRIMARY KEY(id)
);

CREATE TABLE S_horario(
    id INT AUTO_INCREMENT,
    tipo VARCHAR(20),
    inicio_horario TIME,
    fin_horario TIME,

    PRIMARY KEY(id),
    UNIQUE(tipo)
);

CREATE TABLE P_sector(
    id INT AUTO_INCREMENT,
    seccion VARCHAR(20),

    PRIMARY KEY(id),
    UNIQUE(seccion)
);

CREATE TABLE Celda(
    celda_num INT,
    cantidad_actual INT(2),
    FK_p_sector INT,    

    PRIMARY KEY(celda_num),
    FOREIGN KEY(FK_P_sector) REFERENCES P_sector(id)
);

CREATE TABLE Guardia(
    rut VARCHAR(12),
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    edad INT(5),
    rango VARCHAR(20),
    contraseña VARCHAR(50),
    FK_p_sector INT(5),


    PRIMARY KEY(rut),
    FOREIGN KEY(FK_P_sector) REFERENCES P_sector(id)
);

CREATE TABLE Condena(
    id INT AUTO_INCREMENT,
    rut VARCHAR(12), -- Se comprobara con rut de la tabla prisionero. -- 
    P_años INT(15),
    descripcion VARCHAR(200),
    
    PRIMARY KEY(id)
);

CREATE TABLE Delitos(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion VARCHAR(500),
    años VARCHAR(20),

    PRIMARY KEY(id)
);

CREATE TABLE delit_conden(
    id INT AUTO_INCREMENT,
    FK_condena INT,
    FK_delitos INT,

    PRIMARY KEY(id),
    FOREIGN KEY(FK_condena) REFERENCES Condena(id),
    FOREIGN KEY(FK_delitos) REFERENCES Delitos(id)
);

CREATE TABLE turno_guardia(
    id INT AUTO_INCREMENT,
    FK_guardia VARCHAR(12),
    FK_turno INT,

    PRIMARY KEY(id),
    FOREIGN KEY(FK_guardia) REFERENCES Guardia(rut),
    FOREIGN KEY(FK_turno) REFERENCES Turnos(id)
);

CREATE TABLE Prisionero(
    id INT AUTO_INCREMENT,
    rut VARCHAR(12), -- Se comprobara con rut de la tabla Condena. -- 
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    edad INT(5),
    FK_celda_num INT,

    PRIMARY KEY(id),
    FOREIGN KEY(FK_celda_num) REFERENCES Celda(celda_num),
    UNIQUE(rut)
);

CREATE TABLE horario_sector(
    id INT AUTO_INCREMENT,
    FK_S_horario INT,
    FK_P_sector INT,

    PRIMARY KEY(id),
    FOREIGN KEY(FK_S_horario) REFERENCES S_horario(id),
    FOREIGN KEY(FK_P_sector) REFERENCES P_sector(id)
);

-- INGRESO DE DATOS EN LAS TABLAS --

-- INSERTS EN TABLA "P_sector" --

INSERT INTO P_sector VALUES(NULL,"A");
INSERT INTO P_sector VALUES(NULL,"B");
INSERT INTO P_sector VALUES(NULL,"C");
INSERT INTO P_sector VALUES(NULL,"D");

-- INSERT EN TABLA "Delitos" --

INSERT INTO Delitos VALUES(NULL,"Homicidio Común",
"El que matare a otro será castigado, como reo de homicidio, con la pena de prisión de diez a quince años.
Los hechos serán castigados con la pena superior en grado en los siguientes casos:
a) cuando concurra en su comisión alguna de las circunstancias del apartado 1 del artículo 140, o
b) cuando los hechos sean además constitutivos de un delito de atentado del artículo 550.","10 a 15 años de prision.");

INSERT INTO Delitos VALUES(NULL,"Homicidio Encomendado",
"Será castigado con la pena de prisión de quince a veinticinco años, como reo de asesinato, 
el que matare a otro concurriendo alguna de las circunstancias siguientes:
- Con alevosía.
- Por precio, recompensa o promesa.
- Con ensañamiento, aumentando deliberada e inhumanamente el dolor del ofendido.
- Para facilitar la comisión de otro delito o para evitar que se descubra.
Cuando en un asesinato concurran más de una de las circunstancias previstas en el apartado anterior, 
se impondrá la pena en su mitad superior.","15 a 28 años de prision.");

INSERT INTO Delitos VALUES(NULL,"Homocidio a Menores,Discapacitados,etc.",
"El asesinato será castigado con pena de prisión permanente revisable cuando concurra alguna
 de las siguientes circunstancias:
- Que la víctima sea menor de dieciséis años de edad, o se trate de una persona especialmente vulnerable 
por razón de su edad, enfermedad o discapacidad.
- Que el hecho fuera subsiguiente a un delito contra la libertad sexual que el autor hubiera cometido sobre la víctima.
- Que el delito se hubiera cometido por quien perteneciere a un grupo u organización criminal.","Prisión permanente revisable.");

INSERT INTO Delitos VALUES(NULL,"Homicidio Multiple",
"Al reo de asesinato que hubiera sido condenado por la muerte de más de dos personas se le impondrá una pena de prisión permanente revisable. 
En este caso, será de aplicación lo dispuesto en la letra b) del apartado 1 del artículo 78 bis y en la letra 
b) del apartado 2 del mismo artículo.","Prisión permanente revisable.");

INSERT INTO Delitos VALUES(NULL,"Insitación al Suicidio",
"El que induzca al suicidio de otro será castigado con la pena de prisión de cuatro a ocho años.","4 a 8 años de prisión.");

INSERT INTO Delitos VALUES(NULL,"Asistir en Suicidio",
"Se impondrá la pena de prisión de dos a cinco años al que coopere con actos necesarios al suicidio de una persona."
,"2 a 5 años de prisión.");

INSERT INTO Delitos VALUES(NULL,"Completar Suicido de Terceros",
"Será castigado con la pena de prisión de seis a diez años si la cooperación 
llegara hasta el punto de ejecutar la muerte.","6 a 10 años de prisión.");

INSERT INTO Delitos VALUES(NULL,"Aborto a Terceros sin consentimiento",
"El que produzca el aborto de una mujer, sin su consentimiento, será castigado con la pena de prisión de cuatro a ocho años.","4 a 8 años de prisión.");

INSERT INTO Delitos VALUES(NULL,"Aborto a Terceros consentido",
"El que produzca el aborto de una mujer, con su consentimiento, fuera de los casos permitidos por la ley será castigado 
con la pena de prisión de uno a tres años e inhabilitación especial para ejercer cualquier profesión sanitaria, 
o para prestar servicios de toda índole en clínicas, establecimientos o consultorios ginecológicos, públicos o privados, 
por tiempo de uno a seis años.","1 a 3 años de prisión e inhabilitación para profesión.");

INSERT INTO Delitos VALUES(NULL,"","","");

INSERT INTO Delitos VALUES(NULL,"","","");

INSERT INTO Delitos VALUES(NULL,"","","");

INSERT INTO Delitos VALUES(NULL,"","","");

INSERT INTO Delitos VALUES(NULL,"","","");

INSERT INTO Delitos VALUES(NULL,"","","");

INSERT INTO Delitos VALUES(NULL,"","","");

INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");
INSERT INTO Delitos VALUES(NULL,"","","");

--INSERT EN TABLA "Celda" -- 

--INSERT EN TABLA "Guardia" -- 

INSERT INTO Guardia VALUES("21007790-1","Andres Bastan Ivan","Núñez Torres",18,"Superior","PN69ilike",1);