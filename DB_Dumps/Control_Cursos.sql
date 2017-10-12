CREATE DATABASE  IF NOT EXISTS `CONTROL_CURSOS` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `CONTROL_CURSOS`;
-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: CONTROL_CURSOS
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ASIGNACION`
--

DROP TABLE IF EXISTS `ASIGNACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ASIGNACION` (
  `Carnet_Estudiante` varchar(10) NOT NULL,
  `Codigo_Curso` varchar(8) NOT NULL,
  `Fecha` date NOT NULL,
  `Aprobado` tinyint(1) DEFAULT NULL,
  `Semestre` tinyint(1) NOT NULL,
  `Año` int(11) NOT NULL,
  PRIMARY KEY (`Carnet_Estudiante`,`Codigo_Curso`,`Semestre`,`Año`),
  KEY `FK_CURSO_IN_CODIGO_CURSO` (`Codigo_Curso`),
  CONSTRAINT `FK_CURSO_IN_CODIGO_CURSO` FOREIGN KEY (`Codigo_Curso`) REFERENCES `CURSO` (`Codigo`),
  CONSTRAINT `FK_ESTUDIANTE_IN_CARNET_ESTUDIANTE` FOREIGN KEY (`Carnet_Estudiante`) REFERENCES `ESTUDIANTE` (`Carnet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ASIGNACION`
--

LOCK TABLES `ASIGNACION` WRITE;
/*!40000 ALTER TABLE `ASIGNACION` DISABLE KEYS */;
INSERT INTO `ASIGNACION` VALUES ('200356322','001','2016-02-02',1,1,2016),('200356322','011','2016-02-02',0,1,2016),('200356322','011','2016-08-02',1,2,2016),('200356322','104','2016-02-02',1,1,2016),('200356322','114','2016-02-22',1,1,2016),('200413171','001','2016-02-02',0,1,2016),('200413171','001','2016-07-02',1,2,2016),('200413171','012','2016-02-02',1,1,2016),('200413171','211','2016-02-02',1,1,2016),('200514959','011','2016-01-30',1,1,2016),('200514959','104','2016-01-30',0,1,2016),('200514959','104','2016-09-30',0,2,2016),('200514959','106','2016-01-30',0,1,2016),('200514959','106','2016-09-30',1,2,2016),('200514959','201','2016-01-30',1,1,2016);
/*!40000 ALTER TABLE `ASIGNACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CURSO`
--

DROP TABLE IF EXISTS `CURSO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CURSO` (
  `Codigo` varchar(8) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Creditos` int(11) NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CURSO`
--

LOCK TABLES `CURSO` WRITE;
/*!40000 ALTER TABLE `CURSO` DISABLE KEYS */;
INSERT INTO `CURSO` VALUES ('001','Matematica Basica 1',10),('002','Matematica Basica 2',5),('011','Matematica Intermedia 1',10),('012','Matematica Aplicada 2',5),('104','Fisica Basica',3),('106','Fisica 1',5),('114','Lenguajes Formales y de Programación',3),('116','Matematica para computación 1',5),('201','Quimica',3),('211','Logica',3);
/*!40000 ALTER TABLE `CURSO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESTUDIANTE`
--

DROP TABLE IF EXISTS `ESTUDIANTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESTUDIANTE` (
  `Carnet` varchar(10) NOT NULL,
  `Nombre` varchar(25) NOT NULL,
  `Apellidos` varchar(25) NOT NULL,
  `Fecha_Nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`Carnet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESTUDIANTE`
--

LOCK TABLES `ESTUDIANTE` WRITE;
/*!40000 ALTER TABLE `ESTUDIANTE` DISABLE KEYS */;
INSERT INTO `ESTUDIANTE` VALUES ('200356321','Juan','Perez','1999-07-20'),('200356322','Juana','Mendez','1998-07-20'),('200413171','Pedro','Gonzalez','2000-05-28'),('200413172','Anibal','Lorenzo','1999-05-28'),('200514958','Fernanda','Recinos','2003-08-03'),('200514959','Byron','Catalan','2002-08-03'),('200615762','Maria','Fernandez','2002-10-02'),('200615763','MariaJose','Pedrera','2001-10-02'),('200954782','Julio','Ruiz','2000-12-12'),('200954784','Oscar','Soriano','1999-12-12'),('201024587','Daniela','Guevara','2004-05-07'),('201024588','Fernando','Guevara','2003-05-07');
/*!40000 ALTER TABLE `ESTUDIANTE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-11 20:16:22
