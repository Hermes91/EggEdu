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
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `id` varchar(255) NOT NULL,
  `alta` bit(1) DEFAULT NULL,
  `anio` int DEFAULT NULL,
  `ejemplares` int DEFAULT NULL,
  `ejemplares_prestados` int DEFAULT NULL,
  `ejemplares_restantes` int DEFAULT NULL,
  `isbn` bigint DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `autor_id` varchar(255) DEFAULT NULL,
  `editorial_id` varchar(255) DEFAULT NULL,
  `baja` bit(1) DEFAULT NULL,
  `portada_id` varchar(255) DEFAULT NULL,
  `review` longtext,
  PRIMARY KEY (`id`),
  KEY `FKe1ss87ymon6qj17bhr6jfh0c4` (`autor_id`),
  KEY `FK79q7g2604hcmfdxw6ek3jt4el` (`editorial_id`),
  KEY `FKaut7h3asxa0y2ayyamw5frib9` (`portada_id`),
  CONSTRAINT `FK79q7g2604hcmfdxw6ek3jt4el` FOREIGN KEY (`editorial_id`) REFERENCES `editorial` (`id`),
  CONSTRAINT `FKaut7h3asxa0y2ayyamw5frib9` FOREIGN KEY (`portada_id`) REFERENCES `foto` (`id`),
  CONSTRAINT `FKe1ss87ymon6qj17bhr6jfh0c4` FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES ('04df9ef6-394a-4efd-b2cb-7612f05b2542',_binary '',1843,11,6,5,2146741059480,'El gato negro y otros cuentos','0bf4cf99-f976-4e29-80bf-bc2060954fe9','97953211',NULL,'e17233e2-6fa0-442e-bf19-506b5025f7c4','El gato negro es uno de lo cuentos siniestros más conocidos de Poe,​ así como uno de sus grandes relatos psicológicos. La combinación de ambos elementos, horror y psicología, parece conducir directamente a la expresión terror psicológico, que hoy sabemos inspirada en la singularidad artística de este autor​ y que podría definirse como aquella fórmula literaria que aspira a conjugar en una síntesis superior miedo, enajenación y arte. Dejando de momento aparte los presuntos contenidos autobiográficos y supersticiosos, son tres los temas principales que desarrolló su autor en \"El gato negro\", y los tres se hallan estrechamente relacionados entre sí. En primer lugar, como se indica, la locura, espantosamente presente en otro cuento producido en ese mismo año de 1843, con el cual, por doble motivo, pues, a menudo se vincula a \"El gato negro\"; se trata de \"El corazón delator\". Tanto en uno como en el otro el protagonista se ve aquejado por incontrolables accesos de demencia sádica; en el caso de este último, parece ‘congénita’, mientras que en el de \"El gato negro\" se deriva de una severa adicción. Otro tema común a ambas narraciones es el de la culpa, con un acusado matiz persecutorio, y, muy vinculado a aquel, el de la perverseness (no exactamente la \'perversidad\' en castellano), aspecto de la maldad que en Poe aparece revestido de singulares connotaciones masoquistas; una rara especie de justicia poética. '),('2684d0ac-64d8-4dd8-9492-497e002af943',_binary '',1949,8,5,3,8031950844575,'1984','5a28379f-6616-420e-bee5-3c4428227fe0','8489235',NULL,'4e5ddf50-e200-4eda-a017-5e6d3c2dbc04','1984 de George Orwell es una novela de distopía cuya trama ocurre en Oceanía, un país dominado por un gobierno totalitario que mantiene en constante vigilancia a sus ciudadanos e, incluso, insiste en espiar sus pensamientos para mantener el orden.\r\n\r\nLa novela es una de las obras más icónicas del siglo XX por su denuncia de prácticas establecidas por gobiernos como los de Franco y Stalin, las cuales han sido adoptadas por muchos dictadores a lo largo de la historia.'),('4567d928-0689-4a5d-a311-eab9c4d27e7e',_binary '',1977,11,5,6,7812352625856,'El Resplandor','41a56c41-7f7c-4148-819f-c6cdfb51fe92','8489235',NULL,'9d58117d-0c88-441b-931a-baf255759714','Danny tenía cinco años, y a esa edad pocos niños saben que los espejos invierten las imágenes, y menos aún pueden diferenciar entre realidad y fantasía. Pero Danny tenía pruebas de que sus fantasías relacionadas con el resplandor del espejo acabarían cumpliéndose. Su madre estaba pensando en el divorcio, y su padre, obsesionado con algo muy malo, tan malo como la muerte y el suicidio, necesitaba aceptar la propuesta de cuidar aquel hotel de lujo, con más de cien habitaciones y aislado por la nieve, durante seis meses. Hasta el deshielo iban a estar solos. ¿Solos?'),('5513df75-7f5f-4b62-be66-ab26f6382810',_binary '\0',2016,12,8,4,8063374226851,'Las Chicas','c4da8970-7d5c-4d16-82d9-1509194cd81c','6346234',NULL,'9a8e4035-622d-4b7d-9276-df125cd50432','La adolescencia es un tema literario recurrente. Para abordarlo, Emma Cline ha elegido inspirarse muy libremente en un caso famoso: el de la matanza perpetrada por Charles Manson y su tribu de chicas. Aquí empezamos con una adolescente de 14 años, Evie Boyd, y su amiga Connie. Evie es hija de una pareja separada y vive con su madre. Como toda adolescente, detesta su casa, pasa de su madre y se encuentra a disgusto con el mundo. Un día ve a un grupo de chicas jóvenes de aspecto hippy inconformista que parecen rezumar felicidad y libertad y se queda prendada de ellas, sobre todo de la que parece ser la líder. La novela nos contará cómo se une a ellas y lo que modificará su vida, consecuentemente.\r\n\r\nEmma Cline enfoca el relato desde dos puntos de vista. Utiliza un solo narrador, la propia Evie, pero en dos momentos de su vida: cuando se produjo aquel encuentro con las chicas, en 1969, y en la actualidad, muchos años después del suceso que llenó las páginas de los periódicos de la época, convertida ahora en una mujer de mediana edad que vive para pasar desapercibida en una casa prestada por un matrimonio amigo. La narración oscila entre esos dos tiempos, con mayor dedicación a 1969.'),('7e071dfd-469d-4687-a6ef-d5dfb1d23fab',_binary '',1945,23,9,14,6421361787017,'Rebelión en la granja','5a28379f-6616-420e-bee5-3c4428227fe0','0878596',NULL,'6345bbec-86a4-4365-abdf-a206c88d2ca0','Un rotundo alegato a favor de la libertad y en contra del totalitarismo que se ha convertido en un clásico de la literatura del siglo XX.\r\n\r\nEsta sátira de la Revolución rusa y el triunfo del estalinismo, escrita en 1945, se ha convertido por derechos propio en un hito de la cultura contemporánea y en uno de los libros más mordaces de todos los tiempos. Ante el auge de los animales de la Granja Solariega, pronto detectamos las semillas de totalitarismo en una organización aparentemente ideal; y en nuestros líderes más carismáticos, la sombra de los opresores más crueles.');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-26 11:46:34
