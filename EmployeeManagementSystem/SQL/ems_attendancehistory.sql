-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: ems
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `attendancehistory`
--

DROP TABLE IF EXISTS `attendancehistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendancehistory` (
  `EmpId` varchar(20) NOT NULL,
  `Date` date NOT NULL DEFAULT (curdate()),
  `Status` varchar(20) NOT NULL,
  PRIMARY KEY (`EmpId`,`Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendancehistory`
--

LOCK TABLES `attendancehistory` WRITE;
/*!40000 ALTER TABLE `attendancehistory` DISABLE KEYS */;
INSERT INTO `attendancehistory` VALUES ('P0001','2023-10-26','Present'),('P0001','2023-10-27','Present'),('P0001','2023-10-28','Present'),('P0001','2023-10-29','Not Present'),('P0002','2023-10-18','Not Present'),('P0002','2023-10-19','Present'),('P0002','2023-10-22','Present'),('P0002','2023-10-23','Present'),('P0002','2023-10-25','Not Present'),('P0002','2023-10-26','Present'),('P0002','2023-10-28','Present'),('P0003','2023-10-18','Not Present'),('P0003','2023-10-19','Present'),('P0003','2023-10-22','Not Present'),('P0003','2023-10-23','Not Present'),('P0003','2023-10-25','Present'),('P0003','2023-10-26','Present'),('P0003','2023-10-28','Not Present'),('P0004','2023-10-25','Not Present'),('P0004','2023-10-26','Present'),('P0004','2023-10-28','Not Present'),('P0005','2023-10-26','Present'),('P0006','2023-10-26','Not Present'),('P0007','2023-10-26','Not Present'),('P0008','2023-10-26','Not Present'),('P0009','2023-10-26','Not Present'),('P0010','2023-10-26','Not Present'),('P0022','2023-10-26','Not Present'),('P0022','2023-10-27','Not Present'),('P0022','2023-10-28','Present'),('P0022','2023-10-29','Present'),('P0023','2023-10-28','Present'),('P0023','2023-10-29','Not Present'),('P0024','2023-10-25','Present'),('P0024','2023-10-28','Present'),('P0024','2023-10-29','Present'),('P0025','2023-10-29','Not Present'),('T0001','2023-10-25','Present'),('T0001','2023-10-26','Not Present'),('T0001','2023-10-28','Present'),('T0001','2023-10-29','Present'),('T0002','2023-10-25','Present'),('T0002','2023-10-26','Not Present'),('T0002','2023-10-28','Not Present'),('T0003','2023-10-25','Not Present'),('T0003','2023-10-26','Not Present'),('T0003','2023-10-28','Present'),('T0006','2023-10-29','Present'),('T0007','2023-10-29','Present'),('T0008','2023-10-29','Present'),('T0009','2023-10-29','Present');
/*!40000 ALTER TABLE `attendancehistory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-30 13:54:13
