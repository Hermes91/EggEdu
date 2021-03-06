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
INSERT INTO `libro` VALUES ('04df9ef6-394a-4efd-b2cb-7612f05b2542',_binary '',1843,11,6,5,2146741059480,'El gato negro y otros cuentos','0bf4cf99-f976-4e29-80bf-bc2060954fe9','97953211',NULL,'e17233e2-6fa0-442e-bf19-506b5025f7c4','El gato negro es uno de lo cuentos siniestros m??s conocidos de Poe,??? as?? como uno de sus grandes relatos psicol??gicos. La combinaci??n de ambos elementos, horror y psicolog??a, parece conducir directamente a la expresi??n terror psicol??gico, que hoy sabemos inspirada en la singularidad art??stica de este autor??? y que podr??a definirse como aquella f??rmula literaria que aspira a conjugar en una s??ntesis superior miedo, enajenaci??n y arte. Dejando de momento aparte los presuntos contenidos autobiogr??ficos y supersticiosos, son tres los temas principales que desarroll?? su autor en \"El gato negro\", y los tres se hallan estrechamente relacionados entre s??. En primer lugar, como se indica, la locura, espantosamente presente en otro cuento producido en ese mismo a??o de 1843, con el cual, por doble motivo, pues, a menudo se vincula a \"El gato negro\"; se trata de \"El coraz??n delator\". Tanto en uno como en el otro el protagonista se ve aquejado por incontrolables accesos de demencia s??dica; en el caso de este ??ltimo, parece ???cong??nita???, mientras que en el de \"El gato negro\" se deriva de una severa adicci??n. Otro tema com??n a ambas narraciones es el de la culpa, con un acusado matiz persecutorio, y, muy vinculado a aquel, el de la perverseness (no exactamente la \'perversidad\' en castellano), aspecto de la maldad que en Poe aparece revestido de singulares connotaciones masoquistas; una rara especie de justicia po??tica. '),('2684d0ac-64d8-4dd8-9492-497e002af943',_binary '',1949,8,5,3,8031950844575,'1984','5a28379f-6616-420e-bee5-3c4428227fe0','8489235',NULL,'4e5ddf50-e200-4eda-a017-5e6d3c2dbc04','1984 de George Orwell es una novela de distop??a cuya trama ocurre en Ocean??a, un pa??s dominado por un gobierno totalitario que mantiene en constante vigilancia a sus ciudadanos e, incluso, insiste en espiar sus pensamientos para mantener el orden.\r\n\r\nLa novela es una de las obras m??s ic??nicas del siglo XX por su denuncia de pr??cticas establecidas por gobiernos como los de Franco y Stalin, las cuales han sido adoptadas por muchos dictadores a lo largo de la historia.'),('4567d928-0689-4a5d-a311-eab9c4d27e7e',_binary '',1977,11,5,6,7812352625856,'El Resplandor','41a56c41-7f7c-4148-819f-c6cdfb51fe92','8489235',NULL,'9d58117d-0c88-441b-931a-baf255759714','Danny ten??a cinco a??os, y a esa edad pocos ni??os saben que los espejos invierten las im??genes, y menos a??n pueden diferenciar entre realidad y fantas??a. Pero Danny ten??a pruebas de que sus fantas??as relacionadas con el resplandor del espejo acabar??an cumpli??ndose. Su madre estaba pensando en el divorcio, y su padre, obsesionado con algo muy malo, tan malo como la muerte y el suicidio, necesitaba aceptar la propuesta de cuidar aquel hotel de lujo, con m??s de cien habitaciones y aislado por la nieve, durante seis meses. Hasta el deshielo iban a estar solos. ??Solos?'),('5513df75-7f5f-4b62-be66-ab26f6382810',_binary '\0',2016,12,8,4,8063374226851,'Las Chicas','c4da8970-7d5c-4d16-82d9-1509194cd81c','6346234',NULL,'9a8e4035-622d-4b7d-9276-df125cd50432','La adolescencia es un tema literario recurrente. Para abordarlo, Emma Cline ha elegido inspirarse muy libremente en un caso famoso: el de la matanza perpetrada por Charles Manson y su tribu de chicas. Aqu?? empezamos con una adolescente de 14 a??os, Evie Boyd, y su amiga Connie. Evie es hija de una pareja separada y vive con su madre. Como toda adolescente, detesta su casa, pasa de su madre y se encuentra a disgusto con el mundo. Un d??a ve a un grupo de chicas j??venes de aspecto hippy inconformista que parecen rezumar felicidad y libertad y se queda prendada de ellas, sobre todo de la que parece ser la l??der. La novela nos contar?? c??mo se une a ellas y lo que modificar?? su vida, consecuentemente.\r\n\r\nEmma Cline enfoca el relato desde dos puntos de vista. Utiliza un solo narrador, la propia Evie, pero en dos momentos de su vida: cuando se produjo aquel encuentro con las chicas, en 1969, y en la actualidad, muchos a??os despu??s del suceso que llen?? las p??ginas de los peri??dicos de la ??poca, convertida ahora en una mujer de mediana edad que vive para pasar desapercibida en una casa prestada por un matrimonio amigo. La narraci??n oscila entre esos dos tiempos, con mayor dedicaci??n a 1969.'),('7e071dfd-469d-4687-a6ef-d5dfb1d23fab',_binary '',1945,23,9,14,6421361787017,'Rebeli??n en la granja','5a28379f-6616-420e-bee5-3c4428227fe0','0878596',NULL,'6345bbec-86a4-4365-abdf-a206c88d2ca0','Un rotundo alegato a favor de la libertad y en contra del totalitarismo que se ha convertido en un cl??sico de la literatura del siglo XX.\r\n\r\nEsta s??tira de la Revoluci??n rusa y el triunfo del estalinismo, escrita en 1945, se ha convertido por derechos propio en un hito de la cultura contempor??nea y en uno de los libros m??s mordaces de todos los tiempos. Ante el auge de los animales de la Granja Solariega, pronto detectamos las semillas de totalitarismo en una organizaci??n aparentemente ideal; y en nuestros l??deres m??s carism??ticos, la sombra de los opresores m??s crueles.');
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
