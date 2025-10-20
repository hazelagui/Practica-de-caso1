-- --- Sección de administración (solo para pruebas) ---
DROP DATABASE IF EXISTS practica;
DROP USER IF EXISTS usuario_practica;

-- Crear la base de datos de prueba
CREATE DATABASE practica
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

-- Crear usuario de prueba
CREATE USER 'usuario_practica'@'%' IDENTIFIED BY 'la_Clave';

-- Otorgar permisos completos sobre la base de prueba
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'%';
FLUSH PRIVILEGES;

-- Usar la base de datos de prueba
USE practica;

-- --- Sección de creación de la tabla ---
CREATE TABLE arbol (
    id_arbol INT NOT NULL AUTO_INCREMENT,
    nombre_comun VARCHAR(50) NOT NULL,
    tipo_flor VARCHAR(50),
    dureza_madera INT,
    altura_promedio DECIMAL(5,2),
    ruta_imagen VARCHAR(1024),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_arbol),
    UNIQUE (nombre_comun)
) ENGINE=InnoDB;

-- --- Inserción de datos de ejemplo ---
INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura_promedio, ruta_imagen) VALUES
('Roble', 'Flor pequeña blanca', 8, 25.50, 'https://example.com/imagenes/roble.jpg'),
('Cedro', 'Flor aromática', 7, 30.00, 'https://example.com/imagenes/cedro.jpg'),
('Pino', 'Flor insignificante', 6, 35.20, 'https://example.com/imagenes/pino.jpg');
