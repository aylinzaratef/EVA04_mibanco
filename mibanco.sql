-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mibanco
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `rut` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL,
  `ejecutivoFK` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`rut`),
  KEY `ejecutivoFK` (`ejecutivoFK`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`ejecutivoFK`) REFERENCES `ejecutivo` (`rut`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('c-1','Pablo','Rojas','202cb962ac59075b964b07152d234b70','e-1'),('c-2','Maria','Poblete','202cb962ac59075b964b07152d234b70','e-1');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `numerocta` int NOT NULL,
  `saldo` int DEFAULT NULL,
  `clavetransaccion` varchar(100) DEFAULT NULL,
  `saldolineacredito` int DEFAULT NULL,
  `saldolineacreditousado` int DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `clienteFK` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numerocta`),
  KEY `clienteFK` (`clienteFK`),
  CONSTRAINT `cuenta_ibfk_1` FOREIGN KEY (`clienteFK`) REFERENCES `cliente` (`rut`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT INTO `cuenta` VALUES (111111,110000,'202cb962ac59075b964b07152d234b70',350000,50000,1,'c-1'),(222222,140000,'202cb962ac59075b964b07152d234b70',400000,0,1,'c-2');
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejecutivo`
--

DROP TABLE IF EXISTS `ejecutivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejecutivo` (
  `rut` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejecutivo`
--

LOCK TABLES `ejecutivo` WRITE;
/*!40000 ALTER TABLE `ejecutivo` DISABLE KEYS */;
INSERT INTO `ejecutivo` VALUES ('e-1','Tomas','Reyes','202cb962ac59075b964b07152d234b70');
/*!40000 ALTER TABLE `ejecutivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensaje` (
  `idmensaje` int NOT NULL AUTO_INCREMENT,
  `asunto` varchar(20) DEFAULT NULL,
  `contenido` varchar(200) DEFAULT NULL,
  `respuesta` varchar(200) DEFAULT NULL,
  `clienteFK` varchar(20) DEFAULT NULL,
  `ejecutivoFK` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idmensaje`),
  KEY `clienteFK` (`clienteFK`),
  KEY `ejecutivoFK` (`ejecutivoFK`),
  CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`clienteFK`) REFERENCES `cliente` (`rut`) ON DELETE SET NULL,
  CONSTRAINT `mensaje_ibfk_2` FOREIGN KEY (`ejecutivoFK`) REFERENCES `ejecutivo` (`rut`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `idmovimiento` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `cuentaFK` int DEFAULT NULL,
  PRIMARY KEY (`idmovimiento`),
  KEY `cuentaFK` (`cuentaFK`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`cuentaFK`) REFERENCES `cuenta` (`numerocta`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,'2018-12-12','deposito por 100000',111111),(2,'2018-12-10','deposito por 100000',222222),(3,'2021-07-21','deposito por 50000',111111),(4,'2021-07-21','recibio un deposito de 50000',222222),(5,'2021-07-21','deposito por 100000',111111),(6,'2021-07-21','recibio un deposito de 100000',222222),(7,'2021-07-22','depósito por 100000',222222),(8,'2021-07-22','recibió un depósito de 100000',111111),(9,'2021-07-22','depósito por 55000',222222),(10,'2021-07-22','recibió un depósito de 55000',111111),(11,'2021-07-22','depósito por 45000',111111),(12,'2021-07-22','recibió un depósito de 45000',222222);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-22 17:45:11
