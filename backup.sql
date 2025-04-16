-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: spidernet_web
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `antenasap`
--

DROP TABLE IF EXISTS `antenasap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `antenasap` (
  `idantenasAp` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `modelo` varchar(100) DEFAULT NULL,
  `usuario` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idantenasAp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `antenasap`
--

LOCK TABLES `antenasap` WRITE;
/*!40000 ALTER TABLE `antenasap` DISABLE KEYS */;
/*!40000 ALTER TABLE `antenasap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `direccion` text,
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_paquete` int DEFAULT NULL,
  `ip_cliente` varchar(100) DEFAULT NULL,
  `dia_corte` int DEFAULT NULL,
  `estado` enum('Activo','Bloqueado','Suspendido','Cancelado') DEFAULT NULL,
  `ap_antena` varchar(100) DEFAULT NULL,
  `serviciosTV` varchar(100) DEFAULT NULL,
  `serviciosPlataformas` varchar(100) DEFAULT NULL,
  `id_antena_ap` int DEFAULT NULL,
  `id_servicio_plataforma` int DEFAULT NULL,
  `id_microtik` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_servicio_plataforma` (`id_servicio_plataforma`),
  KEY `id_paquete` (`id_microtik`),
  KEY `clientes_antenasap` (`id_antena_ap`),
  KEY `clientes_paquetes_idx` (`id_paquete`),
  CONSTRAINT `clientes_credenciales` FOREIGN KEY (`id_microtik`) REFERENCES `credenciales_microtik` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `clientes_ibfk_2` FOREIGN KEY (`id_antena_ap`) REFERENCES `antenasap` (`idantenasAp`) ON DELETE SET NULL,
  CONSTRAINT `clientes_ibfk_3` FOREIGN KEY (`id_servicio_plataforma`) REFERENCES `serviciosplataforma` (`idPlataformas`) ON DELETE SET NULL,
  CONSTRAINT `clientes_paquetes` FOREIGN KEY (`id_paquete`) REFERENCES `paquetes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=824 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (821,'DESKTOP-137A3ES','','','','2025-04-16 03:21:18',9,'40.40.40.254',14,'Activo',NULL,'',NULL,NULL,NULL,17),(822,'Ricardo Escobedo','','','','2025-04-16 03:26:51',9,'40.40.40.250',15,'Activo',NULL,'',NULL,NULL,NULL,17),(823,'android-517e009a7cab8372','','','','2025-04-14 05:28:26',9,'40.40.40.246',20,'Activo',NULL,'',NULL,NULL,NULL,17);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cortes_caja`
--

DROP TABLE IF EXISTS `cortes_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cortes_caja` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `total_ingresos` decimal(10,2) NOT NULL,
  `total_egresos` decimal(10,2) NOT NULL,
  `balance` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cortes_caja`
--

LOCK TABLES `cortes_caja` WRITE;
/*!40000 ALTER TABLE `cortes_caja` DISABLE KEYS */;
/*!40000 ALTER TABLE `cortes_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credenciales_microtik`
--

DROP TABLE IF EXISTS `credenciales_microtik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credenciales_microtik` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `port` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credenciales_microtik`
--

LOCK TABLES `credenciales_microtik` WRITE;
/*!40000 ALTER TABLE `credenciales_microtik` DISABLE KEYS */;
INSERT INTO `credenciales_microtik` VALUES (17,'HAP-Life','40.40.40.1','admin','admin',NULL);
/*!40000 ALTER TABLE `credenciales_microtik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datosempresa`
--

DROP TABLE IF EXISTS `datosempresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datosempresa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombreWisp` varchar(100) DEFAULT NULL,
  `cp` varchar(30) DEFAULT NULL,
  `telefono` varchar(100) DEFAULT NULL,
  `rfc` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datosempresa`
--

LOCK TABLES `datosempresa` WRITE;
/*!40000 ALTER TABLE `datosempresa` DISABLE KEYS */;
INSERT INTO `datosempresa` VALUES (4,'AdmiNET','98815','4981442266','N/A','Joaquin Amaro #12');
/*!40000 ALTER TABLE `datosempresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egresos`
--

DROP TABLE IF EXISTS `egresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egresos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha_egreso` datetime DEFAULT CURRENT_TIMESTAMP,
  `metodo_pago` enum('Efectivo','Transferencia','Tarjeta') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresos`
--

LOCK TABLES `egresos` WRITE;
/*!40000 ALTER TABLE `egresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `egresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `tipo` enum('Router','Antena','ONU','Otro') NOT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `modelo` varchar(50) DEFAULT NULL,
  `mac` varchar(50) DEFAULT NULL,
  `serial` varchar(50) DEFAULT NULL,
  `estado` enum('Rentado','Vendido','Propio','Almacenado') NOT NULL,
  `id_cliente` int DEFAULT NULL,
  `fecha_registro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `equipos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fallas`
--

DROP TABLE IF EXISTS `fallas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fallas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `tipo_falla` enum('Sin conexión','Intermitencia','Baja velocidad','Otros') NOT NULL,
  `descripcion` text NOT NULL,
  `estado` tinyint NOT NULL DEFAULT '0',
  `fecha_reporte` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_reparacion` datetime DEFAULT NULL,
  `id_tecnico` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_tecnico` (`id_tecnico`),
  CONSTRAINT `fallas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fallas_ibfk_2` FOREIGN KEY (`id_tecnico`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL,
  CONSTRAINT `fallas_chk_1` CHECK ((`estado` in (0,1,2)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fallas`
--

LOCK TABLES `fallas` WRITE;
/*!40000 ALTER TABLE `fallas` DISABLE KEYS */;
/*!40000 ALTER TABLE `fallas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalaciones`
--

DROP TABLE IF EXISTS `instalaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instalaciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) NOT NULL,
  `tipo_instalacion` enum('Residencial','Empresarial','Otro') NOT NULL,
  `id_usuario` int DEFAULT NULL,
  `estado` enum('Pendiente','En Proceso','Completada','Cancelada') DEFAULT 'Pendiente',
  `creado_en` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `actualizado_en` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalaciones`
--

LOCK TABLES `instalaciones` WRITE;
/*!40000 ALTER TABLE `instalaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `instalaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha_pago` datetime DEFAULT CURRENT_TIMESTAMP,
  `metodo_pago` enum('Efectivo','Transferencia','Tarjeta') NOT NULL,
  `cantidad` int NOT NULL,
  `cambio` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `pagos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
INSERT INTO `pagos` VALUES (27,822,'Ricardo Escobedo',250.00,'2025-04-16 03:44:18','Efectivo',300,0),(28,822,'Ricardo Escobedo',250.00,'2025-04-16 03:48:41','Efectivo',300,0),(29,822,'Ricardo Escobedo',250.00,'2025-04-16 03:50:38','Efectivo',300,0),(30,822,'Ricardo Escobedo',250.00,'2025-04-16 03:50:47','Efectivo',300,0),(31,822,'Ricardo Escobedo',250.00,'2025-05-14 03:51:23','Efectivo',300,0),(32,822,'Ricardo Escobedo',250.00,'2025-05-14 04:00:21','Efectivo',300,0),(33,822,'Ricardo Escobedo',250.00,'2025-04-14 05:22:33','Efectivo',300,0),(34,822,'Ricardo Escobedo',250.00,'2025-04-14 05:22:47','Efectivo',300,0);
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paquetes`
--

DROP TABLE IF EXISTS `paquetes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paquetes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `velocidad` varchar(50) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paquetes`
--

LOCK TABLES `paquetes` WRITE;
/*!40000 ALTER TABLE `paquetes` DISABLE KEYS */;
INSERT INTO `paquetes` VALUES (9,'Basico','10M/10M',250.00);
/*!40000 ALTER TABLE `paquetes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pppoe_ususarios`
--

DROP TABLE IF EXISTS `pppoe_ususarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pppoe_ususarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `id_profile` int DEFAULT NULL,
  `id_mikrotik` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pppoe_user a mikrotik_idx` (`id_mikrotik`),
  KEY `pppoe_user a profile_idx` (`id_profile`),
  CONSTRAINT `pppoe_user a mikrotik` FOREIGN KEY (`id_mikrotik`) REFERENCES `credenciales_microtik` (`id`),
  CONSTRAINT `pppoe_user a profile` FOREIGN KEY (`id_profile`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pppoe_ususarios`
--

LOCK TABLES `pppoe_ususarios` WRITE;
/*!40000 ALTER TABLE `pppoe_ususarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `pppoe_ususarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `local_address` varchar(45) NOT NULL,
  `remote_address` varchar(45) NOT NULL,
  `address_list` varchar(45) DEFAULT NULL,
  `max_limit` varchar(45) DEFAULT NULL,
  `id_mikrotik` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `profile a mikrotik_idx` (`id_mikrotik`),
  CONSTRAINT `profile a mikrotik` FOREIGN KEY (`id_mikrotik`) REFERENCES `credenciales_microtik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `queue_parent`
--

DROP TABLE IF EXISTS `queue_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `queue_parent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `subred` varchar(45) DEFAULT NULL,
  `max_limit` varchar(45) DEFAULT NULL,
  `id_mikrotik` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `queue_mikrorik` (`id_mikrotik`),
  CONSTRAINT `queue_mikrorik` FOREIGN KEY (`id_mikrotik`) REFERENCES `credenciales_microtik` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `queue_parent`
--

LOCK TABLES `queue_parent` WRITE;
/*!40000 ALTER TABLE `queue_parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `queue_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serviciosplataforma`
--

DROP TABLE IF EXISTS `serviciosplataforma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serviciosplataforma` (
  `idPlataformas` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPlataformas`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serviciosplataforma`
--

LOCK TABLES `serviciosplataforma` WRITE;
/*!40000 ALTER TABLE `serviciosplataforma` DISABLE KEYS */;
/*!40000 ALTER TABLE `serviciosplataforma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `categoria` enum('Soporte técnico','Facturación','Instalación','Otro') NOT NULL,
  `descripcion` text NOT NULL,
  `estado` enum('Pendiente','En proceso','Resuelto','Cerrado') DEFAULT 'Pendiente',
  `fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_cierre` datetime DEFAULT NULL,
  `id_responsable` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_responsable` (`id_responsable`),
  CONSTRAINT `tickets_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `tickets_ibfk_2` FOREIGN KEY (`id_responsable`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  CONSTRAINT `usuarios_chk_1` CHECK ((`rol` in (0,1,2)))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (7,'admin','admin','admin',0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-16  0:36:26
