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
-- Table structure for table `leaverequest`
--

DROP TABLE IF EXISTS `leaverequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaverequest` (
  `No` int NOT NULL AUTO_INCREMENT,
  `ReqId` varchar(20) DEFAULT NULL,
  `EmpId` varchar(20) NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `FromDate` date NOT NULL,
  `Days` int NOT NULL,
  `Status` varchar(45) NOT NULL DEFAULT 'Pending',
  PRIMARY KEY (`No`),
  UNIQUE KEY `ReqId_UNIQUE` (`ReqId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaverequest`
--

LOCK TABLES `leaverequest` WRITE;
/*!40000 ALTER TABLE `leaverequest` DISABLE KEYS */;
INSERT INTO `leaverequest` VALUES (37,'REQ0001','P0022','Sick Leave','Fever','2023-10-29',2,'Approved'),(38,'REQ0038','P0022','Family Get Together','Long time no see','2023-11-02',2,'Approved'),(40,'REQ0039','T0001','Sick Leave','Need 2 days leave Heavy Fever','2023-10-29',2,'Approved'),(41,'REQ0041','P0022','Sick','Fever','2023-10-30',2,'Approved'),(42,'REQ0042','P0022','Trip','Family Trip','2023-11-02',2,'Approved'),(43,'REQ0043','P0022','Sick leave','high fever','2023-10-29',3,'Approved');
/*!40000 ALTER TABLE `leaverequest` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `leaverequest_BEFORE_INSERT` BEFORE INSERT ON `leaverequest` FOR EACH ROW BEGIN

declare i int;
    DECLARE abc VARCHAR(10); 
    SELECT MAX(No) INTO i FROM leaverequest; 
    
    IF i + 1 >= 1000 THEN 
        SET abc = 'REQ'; SET new.ReqId = CONCAT(abc, (SELECT MAX(No) + 1 FROM leaverequest)); 
    ELSEIF i + 1 >= 100 THEN 
        SET abc = 'REQ0'; SET new.ReqId = CONCAT(abc, (SELECT MAX(No) + 1 FROM leaverequest)); 
    ELSEIF i + 1 >= 10 THEN 
        SET abc = 'REQ00'; SET new.ReqId = CONCAT(abc, (SELECT MAX(No) + 1 FROM leaverequest)); 
	ELSEIF i + 1 >= 0 THEN 
        SET abc = 'REQ000'; SET new.ReqId = CONCAT(abc, (SELECT MAX(No) + 1 FROM leaverequest)); 
    ELSE 
		SET abc = 'REQ0001'; SET new.ReqId = abc; 
    END IF; 

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `leaverequest_AFTER_UPDATE` AFTER UPDATE ON `leaverequest` FOR EACH ROW BEGIN
	IF NEW.status = 'Approved' THEN
        UPDATE leavebalance l
        SET LeaveBalance = LeaveBalance-new.Days
        WHERE l.EmpId = NEW.EmpId;
	end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-30 13:54:15
