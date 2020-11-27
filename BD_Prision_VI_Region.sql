-- CREACION DE LA BASE DE DATOS --

DROP DATABASE IF EXISTS Prision_VI_Región;
CREATE DATABASE Prision_VI_Región;
USE Prision_VI_Región; 

-- CREACION DE TABLAS --




CREATE TABLE Guardia(
    id INT AUTO_INCREMENT,
    rut VARCHAR(12),
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    edad INT(5)
    rango VARCHAR(20),


    PRIMARY KEY(id),
    UNIQUE(rut)
);

CREATE TABLE Turnos(
    tipo VARCHAR(20),
    
);

CREATE TABLE P_sector(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(20),
    seccion VARCHAR(20),

    PRIMARY KEY(id),
    UNIQUE(nombre)
);

CREATE TABLE Celda(
    celda_num INT(5),
    FK_P_sector INT,

    PRIMARY KEY(celda_num),
    FOREIGN KEY(FK_P_sector) REFERENCES P_sector(id)
);

CREATE TABLE Prisionero(
    id INT AUTO_INCREMENT,
    rut VARCHAR(12),
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    edad INT(5),
    FK_celda_num INT(5),

    PRIMARY KEY(id),
    FOREIGN KEY(FK_celda_num) REFERENCES Celda(id),
    UNIQUE(rut)
);



CREATE TABLE Delitos(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion VARCHAR(150),
);


CREATE TABLE Condena(
    FK_prisionero INT,

);