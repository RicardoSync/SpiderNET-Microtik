/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  ricardo
 * Created: 20 feb 2025
 */

-- Crear la base de datos
CREATE DATABASE spidernet;
USE spidernet;

-- Tabla de usuarios (para iniciar sesión y roles)
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol TINYINT NOT NULL CHECK (rol IN (0,1,2)) -- 0 = Admin, 1 = Técnico, 2 = Cajero
);

-- Tabla de paquetes (Internet o servicios contratados)
CREATE TABLE paquetes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    velocidad VARCHAR(50) NOT NULL, -- Ejemplo: "20 Mbps", "50 Mbps"
    precio DECIMAL(10,2) NOT NULL
);

-- Tabla de clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100),
    direccion TEXT NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_paquete INT,
    ip_cliente VARCHAR(100),
    dia_corte INT,
    estado ENUM('Activo', "Bloqueado", 'Suspendido', 'Cancelado'),
    ap_antena VARCHAR(100),
    serviciosTV VARCHAR(100),
    serviciosPlataformas VARCHAR(100),
    FOREIGN KEY (id_paquete) REFERENCES paquetes(id) ON DELETE SET NULL
);

CREATE TABLE antenasap(
    idantenasAp INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    modelo VARCHAR(100),
    usuario VARCHAR(100),
    password VARCHAR(100),
    ip VARCHAR(100)
);

CREATE TABLE serviciosplataforma(
    idantenasAp INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion VARCHAR(100),
    precio VARCHAR(100)
);

-- Tabla de equipos (Router, ONU, Antenas, etc.)
CREATE TABLE equipos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo ENUM('Router', 'Antena', 'ONU', 'Otro') NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    mac VARCHAR(50),
    serial VARCHAR(50),
    estado ENUM('Rentado', 'Vendido', 'Propio', 'Almacenado') NOT NULL, -- Estado del equipo
    id_cliente INT, -- Cliente al que está asignado (puede ser NULL)
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE SET NULL
);

-- Tabla de pagos (Registro de pagos de los clientes)
CREATE TABLE pagos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    nombre VARCHAR(255),
    monto DECIMAL(10,2) NOT NULL,
    fecha_pago DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodo_pago ENUM('Efectivo', 'Transferencia', 'Tarjeta') NOT NULL,
    cantidad INT NOT NULL,
    cambio INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE CASCADE
);

CREATE TABLE fallas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    tipo_falla ENUM('Sin conexión', 'Intermitencia', 'Baja velocidad', 'Otros') NOT NULL,
    descripcion TEXT NOT NULL,
    estado TINYINT NOT NULL DEFAULT 0 CHECK (estado IN (0,1,2)), -- 0 = Activo, 1 = Revisión, 2 = Solucionado
    fecha_reporte DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_reparacion DATETIME NULL,
    id_tecnico INT NULL, -- Técnico que resolvió la falla
    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE CASCADE,
    FOREIGN KEY (id_tecnico) REFERENCES usuarios(id) ON DELETE SET NULL
);

CREATE TABLE tickets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    categoria ENUM('Soporte técnico', 'Facturación', 'Instalación', 'Otro') NOT NULL,
    descripcion TEXT NOT NULL,
    estado ENUM('Pendiente', 'En proceso', 'Resuelto', 'Cerrado') DEFAULT 'Pendiente',
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_cierre DATETIME NULL,
    id_responsable INT NULL,  -- Usuario (técnico/cajero) que resolvió el problema
    FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON DELETE CASCADE,
    FOREIGN KEY (id_responsable) REFERENCES usuarios(id) ON DELETE SET NULL
);

-- Tabla de microtik
CREATE TABLE credenciales_microtik (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    ip VARCHAR(100),
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100)
);