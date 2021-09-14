CREATE DATABASE  IF NOT EXISTS `myapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `myapp`;
-- MariaDB dump 10.19  Distrib 10.5.9-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: myapp
-- ------------------------------------------------------
-- Server version	10.5.9-MariaDB

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_Id` varchar(100) NOT NULL,
  `product_Name` varchar(100) NOT NULL,
  `product_Price` decimal(9,1) NOT NULL,
  `product_Cost` decimal(9,1) NOT NULL,
  `product_unit` char(50) NOT NULL,
  `createDate` date DEFAULT current_timestamp(),
  `modifiedDate` date DEFAULT current_timestamp(),
  `product_Image` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`product_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('1','san phẩm 1',150000.0,45000.0,'chai','2021-09-12','2021-09-08','Imager_products\\lotrinh1.jpg'),('ma001','sản phẩm demo001 update update',5000.0,1000.0,'cái','2021-05-29','2021-05-29','Imager_products\\lotrinh1.jpg'),('ma002','sản phẩm demo002',15000.0,5000.0,'cái','2021-05-29','2021-06-26','Imager_products\\lotrinh1.jpg'),('ma004','demo0004',12000.0,1000.0,'cai','2021-05-29','2021-06-26','Imager_products\\lotrinh1.jpg'),('san pham 1','abc',25000.0,12000.0,'cai','2021-09-14','2021-09-14',''),('sanphammoi','san pham moi new ',10000.0,15000.0,'cai','2021-06-03','2021-06-18','');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-14 22:28:45
