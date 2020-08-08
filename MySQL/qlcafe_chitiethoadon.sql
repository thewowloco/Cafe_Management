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
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `stt` int NOT NULL AUTO_INCREMENT,
  `idMonAn` int NOT NULL,
  `TenMon` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `DonGia` double NOT NULL,
  `SoLuong` int NOT NULL,
  `ThanhTien` double NOT NULL,
  `idHD` char(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`stt`),
  KEY `fk_chitiethoadon_monan_idx` (`idMonAn`),
  KEY `fk_chitiethoadon_hoadon_idx` (`idHD`),
  CONSTRAINT `fk_chitiethoadon_hoadon` FOREIGN KEY (`idHD`) REFERENCES `hoadon` (`idHoaDon`),
  CONSTRAINT `fk_chitiethoadon_monan` FOREIGN KEY (`idMonAn`) REFERENCES `monan` (`IdMonAn`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (1,15,'Hu tieu',20000,4,80000,'200612-120006-9'),(2,4,'Tra sua truyen thong',25000,2,50000,'200612-120006-9'),(3,8,'Pepsi',12000,1,12000,'200612-120006-9'),(4,11,'Sinh to nha dam',39000,1,39000,'200612-120006-9'),(5,32,'Sting dau',12000,3,36000,'200612-155853-20'),(6,8,'Pepsi',12000,2,24000,'200612-155853-20'),(7,24,'Mi xao bo',33000,1,33000,'200612-155853-20'),(8,21,'Bun dau mam tom',20000,1,20000,'200612-155853-20'),(9,16,'Hu tieu bo vien',27000,2,54000,'200612-155853-20'),(10,20,'Bun cha gio',30000,1,30000,'200612-155853-20'),(11,29,'Bun them',5000,2,10000,'200612-155853-20'),(12,3,'Cafe den da',22000,1,22000,'200612-161844-13'),(13,1,'Cafe sua',25000,2,50000,'200612-161844-13'),(14,5,'Tra sua tran chau duong den',35000,1,35000,'200612-161844-13'),(15,7,'Tra sua socola',25000,2,50000,'200612-161844-13'),(16,19,'Bun bo Hue',30000,2,60000,'200612-161844-13'),(17,22,'Com chien trung',30000,1,30000,'200612-161844-13'),(18,24,'Mi xao bo',33000,2,66000,'200612-161844-13'),(19,1,'Cafe sua',25000,1,25000,'200612-162844-16'),(20,2,'Cafe nong',20000,2,40000,'200612-162844-16'),(21,5,'Tra sua tran chau duong den',35000,1,35000,'200612-162844-16'),(22,9,'CocaCola',12000,1,12000,'200612-162844-16'),(23,13,'Tra lipton nong',20000,2,40000,'200612-162844-16'),(24,11,'Sinh to nha dam',39000,3,117000,'200612-162844-16'),(25,1,'Cafe sua',25000,2,50000,'200612-225731-10'),(26,6,'Tra sua matcha',30000,1,30000,'200612-225731-10'),(27,17,'Hu tieu chay',20000,1,20000,'200612-225731-10'),(28,29,'Bun them',5000,1,5000,'200612-225731-10'),(29,9,'CocaCola',12000,2,24000,'200612-225731-10'),(30,1,'Cafe sua',25000,2,50000,'200612-230351-22'),(31,5,'Tra sua tran chau duong den',35000,3,105000,'200612-230351-22'),(32,8,'Pepsi',12000,3,36000,'200612-230351-22'),(33,14,'Tra dao cao sa',33000,1,33000,'200612-230351-22'),(34,18,'Bun reu',20000,2,40000,'200612-230351-22'),(35,18,'Bun reu',20000,3,60000,'200612-230351-22'),(36,24,'Mi xao bo',33000,3,99000,'200612-230351-22'),(37,23,'Mi tom trung',20000,1,20000,'200612-230351-22'),(38,30,'Rau luoc',10000,2,20000,'200612-230351-22'),(39,4,'Tra sua truyen thong',25000,1,25000,'200612-230351-22'),(40,1,'Cafe sua',25000,5,125000,'200612-233905-20'),(41,17,'Hu tieu chay',20000,2,40000,'200612-233905-20'),(42,24,'Mi xao bo',33000,1,33000,'200612-233905-20'),(43,27,'Canh nam dau hu',50000,3,150000,'200612-233905-20'),(44,1,'Cafe sua',25000,3,75000,'200613-142922-13');
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-13 18:08:58
