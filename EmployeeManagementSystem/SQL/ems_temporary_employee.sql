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
-- Table structure for table `temporary_employee`
--

DROP TABLE IF EXISTS `temporary_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temporary_employee` (
  `No` int NOT NULL AUTO_INCREMENT,
  `EmpId` varchar(20) DEFAULT NULL,
  `Name` varchar(45) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Department` varchar(45) NOT NULL,
  `Position` varchar(45) NOT NULL,
  `Salary` double NOT NULL,
  `Photo` varchar(150) DEFAULT NULL,
  `DateJoined` date NOT NULL DEFAULT (curdate()),
  PRIMARY KEY (`No`),
  UNIQUE KEY `EmpId_UNIQUE` (`EmpId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporary_employee`
--

LOCK TABLES `temporary_employee` WRITE;
/*!40000 ALTER TABLE `temporary_employee` DISABLE KEYS */;
INSERT INTO `temporary_employee` VALUES (5,'T0001','Rihanna','2000-05-03','female','0764531542','Rihanna22@gmail.com','26 Rigma Road Negombo   ','R&D','Sales Representative',62500,'default_f.jpg','2023-10-29'),(6,'T0006','Anil Kumar','1976-06-21','male','9144227845','Joseph123@gmail.com','12/3 Salem road Mumbai','R&D','Marketing Manager',10000,'default_m.jpg','2023-10-29'),(7,'T0007','Suriya Sivakumar','1977-07-23','male','9144223388','SuriyaOffl@gmail.com','45/5 New Road , Chennai ','IT','Operations Manager',99999,'default_m.jpg','2023-10-29'),(8,'T0008','Samantha Akineni','1991-07-20','female','9145427878','Samantha2@gmail.com','12/3 New Store Road Kerala','CS','Marketing Manager',75000,'default_f.jpg','2023-10-29'),(9,'T0009','Kalyani Priyadarshini','1996-01-08','female','9145612378','priyaoffl@gmail.com','35/3 Mountain Road Kerala','MA','Financial Analyst',85000,'default_f.jpg','2023-10-29');
/*!40000 ALTER TABLE `temporary_employee` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `temporary_employee_BEFORE_INSERT` BEFORE INSERT ON `temporary_employee` FOR EACH ROW BEGIN
	declare i int;
    DECLARE abc VARCHAR(10); 
    SELECT MAX(no) INTO i FROM temporary_employee; 
    
    IF i + 1 >= 1000 THEN 
        SET abc = 'T'; SET new.EmpId = CONCAT(abc, (SELECT MAX(No) + 1 FROM temporary_employee)); 
    ELSEIF i + 1 >= 100 THEN 
        SET abc = 'T0'; SET new.EmpId = CONCAT(abc, (SELECT MAX(No) + 1 FROM temporary_employee)); 
    ELSEIF i + 1 >= 10 THEN 
        SET abc = 'T00'; SET new.EmpId = CONCAT(abc, (SELECT MAX(No) + 1 FROM temporary_employee)); 
	ELSEIF i + 1 >= 0 THEN 
        SET abc = 'T000'; SET new.EmpId = CONCAT(abc, (SELECT MAX(No) + 1 FROM temporary_employee)); 
    ELSE 
		SET abc = 'T0001'; SET new.EmpId = abc; 
    END IF; 
    IF NEW.Gender = 'Male' THEN
        SET new.Photo = 'default_m.jpg';
    ELSEIF NEW.Gender = 'Female' THEN
        SET new.Photo = 'default_f.jpg';
	end if;
	insert into leavebalance(Empid) values (New.EmpId);
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

-- Dump completed on 2023-10-30 13:54:14
