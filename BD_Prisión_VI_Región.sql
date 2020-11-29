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
    nombre VARCHAR(20),
    seccion VARCHAR(20),

    PRIMARY KEY(id),
    UNIQUE(nombre)
);

CREATE TABLE Guardia(
    rut VARCHAR(12),
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    edad INT(5),
    rango VARCHAR(20),
    FK_p_sector INT(5),


    PRIMARY KEY(rut),
    FOREIGN KEY(FK_P_sector) REFERENCES P_sector(id)
);

CREATE TABLE Condena(
    id INT AUTO_INCREMENT,
    rut VARCHAR(12), -- Se comprobara con rut de la tabla prisionero. -- 
    descripcion VARCHAR(200),
    
    PRIMARY KEY(id)
);

CREATE TABLE Delitos(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion VARCHAR(150),

    PRIMARY KEY(id)
);

CREATE TABLE Celda(
    celda_num INT,
    FK_p_sector INT,

    PRIMARY KEY(celda_num),
    FOREIGN KEY(FK_P_sector) REFERENCES P_sector(id)
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

-- INSERTS DE DATOS EN TABLA --

