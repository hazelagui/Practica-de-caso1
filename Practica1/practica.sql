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

-- --- Sección de creación de las tablas ---

-- Tabla estado (mencionada en la práctica)
CREATE TABLE estado (
    id_estado INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255),
    activo BOOLEAN DEFAULT TRUE,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_estado),
    UNIQUE (nombre)
) ENGINE=InnoDB;

-- Tabla arbol (principal de la práctica)
CREATE TABLE arbol (
    id_arbol INT NOT NULL AUTO_INCREMENT,
    nombre_comun VARCHAR(50) NOT NULL,
    tipo_flor VARCHAR(50),
    dureza_madera INT,
    altura_promedio DECIMAL(5,2),
    ruta_imagen VARCHAR(1024),
    id_estado INT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id_arbol),
    UNIQUE (nombre_comun),
    FOREIGN KEY (id_estado) REFERENCES estado(id_estado)
) ENGINE=InnoDB;

-- --- Inserción de datos de ejemplo ---

-- Estados de ejemplo
INSERT INTO estado (nombre, descripcion, activo) VALUES
('Disponible', 'Árbol disponible para venta', TRUE),
('Agotado', 'Árbol temporalmente agotado', TRUE),
('En crecimiento', 'Árbol en proceso de crecimiento', TRUE),
('Reservado', 'Árbol reservado por cliente', TRUE);

-- Árboles de ejemplo con imágenes reales
INSERT INTO arbol (nombre_comun, tipo_flor, dureza_madera, altura_promedio, ruta_imagen, id_estado) VALUES
('Roble', 'Flor pequeña blanca', 8, 25.50, 'https://images.unsplash.com/photo-1542273917363-3b1817f69a2d?w=400', 1),
('Cedro', 'Flor aromática', 7, 30.00, 'https://images.unsplash.com/photo-1511497584788-876760111969?w=400', 1),
('Pino', 'Flor insignificante', 6, 35.20, 'https://images.unsplash.com/photo-1542273917363-3b1817f69a2d?w=400', 2),
('Eucalipto', 'Flor blanca aromática', 7, 40.00, 'https://images.unsplash.com/photo-1441974231531-c6227db76b6e?w=400', 3);