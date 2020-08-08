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
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `MaNhanVien` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GioiTinh` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `QueQuan` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NgaySinh` date NOT NULL,
  `NgayVaoLam` date NOT NULL,
  `BoPhanTrucThuoc_id` int NOT NULL,
  PRIMARY KEY (`MaNhanVien`),
  KEY `fk_nhanvien_bophantructhuoc_idx` (`BoPhanTrucThuoc_id`),
  CONSTRAINT `fk_nhanvien_bophantructhuoc` FOREIGN KEY (`BoPhanTrucThuoc_id`) REFERENCES `bophantructhuoc` (`MaBoPhan`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Donald Trump','Nam','USA','1990-12-12','2014-12-11',4),(2,'Wibu','Nam','Japan','2000-12-12','2019-12-11',5),(3,'Cao Ba Giang','Nam','Dong Nai','1997-03-03','2019-05-04',4),(4,'Do Vo Anh Khoa','Nam','TP.HCM','1996-05-02','2018-05-06',2),(5,'Vo Dinh Huy','Nam','Dak Lak','1993-12-04','2018-06-07',5),(6,'Bui Xuan Hieu','Nu','Dong Nai','1998-09-12','2019-12-01',5),(7,'Truong Hao Quy','Nam','TP.HCM','1990-04-05','2018-07-08',1),(8,'Tran Thanh Bao Dang','Nu','Soc Trang','1999-03-12','2020-01-05',5),(9,'Dinh Ngoc An','Nam','Binh Dinh','1996-05-25','2019-01-07',3),(10,'Huy Vo','Nam','Dak Lak','1998-05-15','2017-03-04',5),(11,'Giang Cao','Nu','Dong Nai','2000-07-07','2020-02-06',3),(12,'Hieu Bui','Nam','An Giang','2001-01-01','2017-04-05',1),(13,'Hao Quy','Nam','Ha Noi','1999-05-02','2018-08-07',4),(14,'Ngoc Hieu','Nu','Bac Ninh','2000-07-06','2019-09-15',2),(15,'Tran Thanh Thao','Nu','An Giang','1990-02-07','2018-08-06',3),(16,'Nguyen Anh Vinh','Nam','Tay Ninh','1996-09-18','2018-12-11',2),(17,'Tran Van Anh','Nu','Phu Yen','1999-08-07','2018-10-11',4),(18,'Le Thi Thanh Thu','Nu','Nghe An','1997-06-05','2016-05-01',2),(19,'Tran Thanh Bao','Nam','Ha Noi','1998-08-14','2018-09-13',2),(20,'Le Thanh Hang','Nu','Quang Ngai','2000-02-23','2020-01-02',2),(21,'Tran Van Thanh','Nam','Quang Ngai','1991-04-01','2014-06-29',3),(22,'Son Tung','Nam','Khanh Hoa','1998-05-01','2018-06-23',4),(23,'Le Trung Hieu','Nam','Bac Ninh','2000-07-08','2019-08-27',3),(24,'Nguyen Nhu Yen','Nu','Soc Trang','1995-10-04','2018-06-02',2),(25,'Le Thi Thu Uyen','Nu','An Giang','1996-05-06','2020-05-23',1),(26,'Le Van Thanh','Nam','TP.HCM','1992-07-26','2017-09-10',3),(27,'Tran Duc Nhan','Nam','Ha Noi','1999-06-11','2018-05-03',2),(28,'Tran Van Tuyet','Nu','Phu Yen','1993-06-25','2015-07-17',4),(29,'Le Hong Hanh','Nu','Nghe An','1999-11-23','2018-11-25',1),(30,'Tran Le Bao','Nam','Ha Noi','1998-12-24','2018-11-25',4),(33,'Barack Obama','Nam','USA','1970-12-13','2020-06-07',2),(35,'Napoleon','Nam','France','1769-08-15','2020-06-07',1),(36,'Luu Bi','Nam','China','0123-01-15','2020-06-07',4),(37,'Quan Vu','Nam','China','0123-01-01','2020-06-07',5),(38,'Ly Tieu Long','Nam','China','1930-01-01','2020-06-07',2),(39,'Ton Ngo Khong','Nam','Dak Lak','1997-06-15','2020-06-08',5),(41,'Hoang Chau Cach Cach','Nu','China','1234-01-01','2020-06-13',1);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
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
