CREATE DATABASE  IF NOT EXISTS `qlcafe` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qlcafe`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qlcafe
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `monan`
--

DROP TABLE IF EXISTS `monan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monan` (
  `IdMonAn` int NOT NULL AUTO_INCREMENT,
  `Ten` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GiaBan` double NOT NULL,
  `TinhTrang` char(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ThoiDiemBan` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `DanhMuc` int NOT NULL,
  `ThongTinThem` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`IdMonAn`),
  KEY `Fk_monan_danhmuc_idx` (`DanhMuc`),
  CONSTRAINT `fk_monan_danhmuc` FOREIGN KEY (`DanhMuc`) REFERENCES `danhmuc` (`idDanhMuc`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monan`
--

LOCK TABLES `monan` WRITE;
/*!40000 ALTER TABLE `monan` DISABLE KEYS */;
INSERT INTO `monan` VALUES (1,'Cafe sua',25000,'Con','Sang, Toi',2,'Co da'),(2,'Cafe nong',20000,'Con','Sang, Toi',2,NULL),(3,'Cafe den da',22000,'Con','Sang, Toi',2,'Co da'),(4,'Tra sua truyen thong',25000,'Con','Trua, Toi',2,'Co da'),(5,'Tra sua tran chau duong den',35000,'Con','Trua, Toi',2,'Co da'),(6,'Tra sua matcha',30000,'Con','Trua, Toi',2,'Co da'),(7,'Tra sua socola',25000,'Con','Trua, Toi',2,'Co da'),(8,'Pepsi',12000,'Con','Sang, Trua, Toi',2,'Co da'),(9,'CocaCola',12000,'Con','Sang, Trua, Toi',2,'Co da'),(10,'Sinh to dau',39000,'Con','Toi',2,NULL),(11,'Sinh to nha dam',39000,'Con','Toi',2,NULL),(12,'Sinh to thap cam',45000,'Con','Toi',2,NULL),(13,'Tra lipton nong',20000,'Con','Sang, Toi',2,NULL),(14,'Tra dao cao sa',33000,'Con','Sang, Toi',2,'Co da'),(15,'Hu tieu',20000,'Con','Sang',1,NULL),(16,'Hu tieu bo vien',27000,'Con','Sang',1,NULL),(17,'Hu tieu chay',20000,'Con','Sang',1,'Mon chay'),(18,'Bun reu',20000,'Con','Sang, Trua',1,NULL),(19,'Bun bo Hue',30000,'Con','Sang, Trua',1,NULL),(20,'Bun cha gio',30000,'Con','Sang, Trua',1,NULL),(21,'Bun dau mam tom',20000,'Con','Sang, Trua, Toi',1,NULL),(22,'Com chien trung',30000,'Con','Sang, Trua, Toi',1,NULL),(23,'Mi tom trung',20000,'Con','Sang, Trua, Toi',1,NULL),(24,'Mi xao bo',33000,'Con','Sang, Trua, Toi',1,NULL),(25,'Rau muong xao',12000,'Con','Sang, Trua',1,'Mon chay'),(26,'Dau hu chien',12000,'Con','Sang, Trua, Toi',1,'Mon chay'),(27,'Canh nam dau hu',50000,'Con','Sang',1,'Mon chay'),(28,'Com them',5000,'Con','Sang, Trua',1,'Mon chay'),(29,'Bun them',5000,'Con','Sang, Trua, Toi',1,'Mon chay'),(30,'Rau luoc',10000,'Het','Sang, Toi',1,'Mon chay'),(31,'Banh mi',20000,'Con','Sang',1,'Mon chay'),(32,'Sting dau',12000,'Con','Sang, Trua, Toi',2,'Co da'),(33,'Com suon',25000,'Con','Sang, Trua',1,'');
/*!40000 ALTER TABLE `monan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-13 18:08:59
