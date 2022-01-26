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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `id` varchar(255) NOT NULL,
  `alta` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `foto_id` varchar(255) DEFAULT NULL,
  `bio` longtext,
  PRIMARY KEY (`id`),
  KEY `FKlwd2qu1uvhqb1wj1rk59ahquc` (`foto_id`),
  CONSTRAINT `FKlwd2qu1uvhqb1wj1rk59ahquc` FOREIGN KEY (`foto_id`) REFERENCES `foto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES ('0bf4cf99-f976-4e29-80bf-bc2060954fe9',_binary '','Edgar Allan Poe','eb688ecc-cde2-465b-b4bb-54047b244fdc','Edgar Allan Poe (Boston, Estados Unidos, 19 de enero de 1809-Baltimore, Estados Unidos, 7 de octubre de 1849) fue un escritor, poeta, crítico y periodista romántico estadounidense, generalmente reconocido como uno de los maestros universales del relato corto, del cual fue uno de los primeros practicantes en su país. Fue renovador de la novela gótica, recordado especialmente por sus cuentos de terror.\r\nConsiderado el inventor del relato detectivesco, contribuyó asimismo con varias obras al género emergente de la ciencia ficción.​ Por otra parte, fue el primer escritor estadounidense de renombre que intentó hacer de la escritura su modus vivendi, lo que tuvo para él lamentables consecuencias.'),('3',_binary '','Anonimo',NULL,NULL),('41a56c41-7f7c-4148-819f-c6cdfb51fe92',_binary '','Stephen King','b3761b47-7216-41be-a910-6d708afe77d4','Stephen Edwin King (Portland, Maine; 21 de septiembre de 1947), más conocido como Stephen King y ocasionalmente por su pseudónimo Richard Bachman, es un escritor estadounidense de novelas de terror, ficción sobrenatural, misterio, ciencia ficción y literatura fantástica. Sus libros han vendido más de 350 millones de ejemplares​ y en su mayoría han sido adaptados al cine y a la televisión. Ha publicado 61 novelas (siete de ellas, bajo el pseudónimo Richard Bachman) y siete libros de no ficción. Ha escrito, además, alrededor de doscientos relatos y novelas cortas, la mayoría de los cuales han sido recogidos en once colecciones.'),('5a28379f-6616-420e-bee5-3c4428227fe0',_binary '','George Orwell','88c0e646-973b-49b4-96a2-7450027f6ce5','Eric Arthur Blair (Motihari, Raj Británico, 25 de junio de 1903-Londres, Reino Unido, 21 de enero de 1950),​ más conocido por su seudónimo de George Orwell, fue un novelista, periodista, ensayista y crítico británico nacido en la India, conocido mundialmente por su novelas distópicas Rebelión en la granja (1945) y 1984 (1949).\r\n\r\nSu obra lleva la marca de las experiencias autobiográficas vividas por el autor en tres etapas de su vida: su posición en contra del imperialismo británico que lo llevó al compromiso como representante de las fuerzas del orden colonial en Birmania durante su juventud; a favor del socialismo democrático, después de haber observado y sufrido las condiciones de vida de las clases sociales de los trabajadores de Londres y París; y en contra de los totalitarismos nazi y estalinista tras su participación en la guerra civil española.'),('adf0a610-31c1-4b0f-a52e-6afcd79e03bf',_binary '','Mariana Enríquez','f54f8447-5c53-4d52-8fa3-fd9d8a21050e','bdbsd'),('c4da8970-7d5c-4d16-82d9-1509194cd81c',_binary '','Emma Cline','3429e165-22ce-433a-b126-2f21ecd86e6b','Emma Cline (Sonoma County, California, 1989) es una escritora y novelista estadounidense. Publicó en 2016 su primera novela, Las Chicas (The Girls), que está ambientada en la secta de Charles Manson. También, fue nominada por sus relatos a diversos premios literarios como el John Leonard Award por el National Book Critics Circle y el Center for Fiction\'s First Novel Prize. Finalmente fue galardonada con el Plimpton Prize en 2014, premio entregado por la revista The Paris Review, por el relato Marion.');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
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
