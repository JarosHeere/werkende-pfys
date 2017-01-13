-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pfys
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `dta`
--

DROP TABLE IF EXISTS `dta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dta` (
  `date` date NOT NULL,
  `time` varchar(45) NOT NULL,
  `airport` varchar(45) NOT NULL,
  `Unr` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dta`
--

LOCK TABLES `dta` WRITE;
/*!40000 ALTER TABLE `dta` DISABLE KEYS */;
INSERT INTO `dta` VALUES ('1999-09-09','','',100),('2001-12-12','','',100),('1999-09-09','','',100);
/*!40000 ALTER TABLE `dta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `Unr` int(250) NOT NULL,
  `labelnr` varchar(60) DEFAULT NULL,
  `flightnr` varchar(60) DEFAULT NULL,
  `destin` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Unr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `permission` int(11) NOT NULL,
  PRIMARY KEY (`username`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('a','b',3);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugage`
--

DROP TABLE IF EXISTS `lugage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lugage` (
  `Lugagelnr` varchar(45) NOT NULL,
  `Lugagetype` varchar(45) NOT NULL,
  `Lugagebrand` varchar(45) NOT NULL,
  `Lugagecol` varchar(45) NOT NULL,
  `Lugeweight` varchar(45) NOT NULL,
  `Lugagewespef` varchar(45) NOT NULL,
  `Unr` int(250) NOT NULL,
  `Pnr` int(250) NOT NULL,
  `LFDM` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`Lugagelnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugage`
--

LOCK TABLES `lugage` WRITE;
/*!40000 ALTER TABLE `lugage` DISABLE KEYS */;
/*!40000 ALTER TABLE `lugage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persoon`
--

DROP TABLE IF EXISTS `persoon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persoon` (
  `Pnr` int(250) NOT NULL,
  `name` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `zip` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `tel` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`Pnr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persoon`
--

LOCK TABLES `persoon` WRITE;
/*!40000 ALTER TABLE `persoon` DISABLE KEYS */;
INSERT INTO `persoon` VALUES (1,'jaros','heere','amsterdam','1433mc','nederland','859632','jaros.lol'),(2,'a','b','c','d','e','f','g');
/*!40000 ALTER TABLE `persoon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unr`
--

DROP TABLE IF EXISTS `unr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unr` (
  `Unr` int(250) NOT NULL,
  PRIMARY KEY (`Unr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unr`
--

LOCK TABLES `unr` WRITE;
/*!40000 ALTER TABLE `unr` DISABLE KEYS */;
/*!40000 ALTER TABLE `unr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-12 13:39:53
