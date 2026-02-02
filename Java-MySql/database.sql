DROP DATABASE IF EXISTS architecture_db;

CREATE DATABASE IF NOT EXISTS architecture_db;

use architecture_db;

CREATE TABLE IF NOT EXISTS Persona (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) not null,
    apellido VARCHAR(50) not null,
    edad int(100) not null
);

CREATE TABLE IF NOT EXISTS Empleado (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    persona_id INT NOT NULL,
    horas_de_trabajo INT,
    salario DOUBLE,
    FOREIGN KEY (persona_id) REFERENCES Persona (id) ON DELETE CASCADE
);

INSERT INTO
    Persona (nombre, apellido, edad)
VALUES ('Juan', 'Perez', 32),
    ('Laura', 'Morales', 26),
    ('Andres', 'Rojas', 45),
    ('Sofia', 'Castillo', 29),
    ('Miguel', 'Torres', 38),
    ('Camila', 'Vargas', 24);

INSERT INTO
    Empleado (
        persona_id,
        horas_de_trabajo,
        salario
    )
VALUES (1, 160, 2500000),
    (2, 120, 1800000),
    (4, 160, 3000000),
    (5, 80, 1200000);

SELECT * FROM Persona;

SELECT * FROM Empleado;

SELECT p.nombre, p.apellido, p.edad
FROM Empleado e
    JOIN Persona p ON e.persona_id = p.id;