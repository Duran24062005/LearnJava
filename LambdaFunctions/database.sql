DROP DATABASE IF EXISTS architecture_db;

CREATE DATABASE IF NOT EXISTS architecture_db;

use architecture_db;

CREATE TABLE IF NOT EXISTS Persona (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) not null,
    apellido VARCHAR(50) not null,
    edad int(100) not null,
);

CREATE TABLE IF NOT EXISTS Empleado (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    persona_id INT NOT NULL,
    FOREIGN KEY (persona_id) REFERENCES Persona (id) ON DELETE CASCADE
);

INSERT INTO
    Persona (nombre, apellido, edad)
VALUES ('Carlos', 'Ramirez', 30),
    ('Ana', 'Gomez', 25),
    ('Luis', 'Martinez', 40),
    ('Maria', 'Lopez', 28),
    ('Pedro', 'Fernandez', 35);

INSERT INTO Empleado (persona_id) VALUES (1), (2), (4);

SELECT * FROM Persona;

SELECT * FROM Empleado;

SELECT p.nombre, p.apellido, p.edad
FROM Empleado e
    JOIN Persona p ON e.persona_id = p.id;