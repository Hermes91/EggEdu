CREATE DATABASE  IF NOT EXISTS `libreria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `libreria`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: libreria
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` varchar(255) NOT NULL,
  `alta` datetime DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `baja` datetime DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('005b54e9-ff38-4b82-a98d-37082e65f187','2022-01-03 13:40:36','genessu',NULL,'$2a$10$aCa/XE5irGuSuQM5I5HJCe2prqOew6dZR373vRZriwlbNpc.H4cjy','mi@rar','suio','USUARIO'),('25a1093d-0ad5-423c-8283-12ea8ef22aae','2022-01-06 16:59:29','tunga','2022-01-06 18:45:09','$2a$10$kfGSBrbtmgUNoUvd0Exq5.7sSSrXHDxokgujNtPVDCQfnofwbJhwO','espe@l','muga','USUARIO'),('427300ff-56c2-4064-a14a-ea486521f8f0','2022-01-04 19:13:40','Man',NULL,'$2a$10$LFwyRF2u4VbbKwsC7IZKuuWsPpLhNcoq12A.dfSxsNp3TeGZ9LdsS','Mega@Mania','Mega','USUARIO'),('8f086904-deda-4401-a5f7-9c9c0d80f79e','2022-01-06 13:57:26','Min',NULL,'$2a$10$dcMr8j1Q9elyj5iTPV1cLedTlMmpG/ss6rFGTRuMywXn/UQG.e.b.','ad@min','Ad','ADMIN'),('989c0546-19db-46f8-b23d-850ca2758be1','2022-01-03 18:52:31','bardo',NULL,'$2a$10$PRqGvDAd.oUOgwqal1cwSuuahpY9/oOhfcPS42KaDTVN0Y3MxP7gS','frf@li','duarthe','USUARIO'),('9bb71059-4320-481b-9d74-80ede543a67a','2022-01-05 16:48:41','Roja','2022-01-06 18:45:03','$2a$10$3QN.i.ISLQObAgSmFiKQnu2KhhlJ.gbTjGzIQCuS6ziZg8Xa82hr6','red@death','Muerte','USUARIO');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-26 11:46:33
