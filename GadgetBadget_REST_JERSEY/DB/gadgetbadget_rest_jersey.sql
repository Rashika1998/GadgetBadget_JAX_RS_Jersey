-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.29


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema gadgetbadget_rest_jersey
--

CREATE DATABASE IF NOT EXISTS gadgetbadget_rest_jersey;
USE gadgetbadget_rest_jersey;

--
-- Definition of table `cart_tab`
--

DROP TABLE IF EXISTS `cart_tab`;
CREATE TABLE `cart_tab` (
  `cartID` int(11) NOT NULL AUTO_INCREMENT,
  `cartCode` varchar(100) DEFAULT NULL,
  `projectCode` varchar(100) DEFAULT NULL,
  `projectName` varchar(100) DEFAULT NULL,
  `projectQty` decimal(5,0) DEFAULT NULL,
  `projectUnitPrice` decimal(5,2) DEFAULT NULL,
  `customerID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cartID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cart_tab`
--

/*!40000 ALTER TABLE `cart_tab` DISABLE KEYS */;
INSERT INTO `cart_tab` (`cartID`,`cartCode`,`projectCode`,`projectName`,`projectQty`,`projectUnitPrice`,`customerID`) VALUES 
 (1,'c_code_01','p_code_02','React UI','2','220.00','c_id_001');
/*!40000 ALTER TABLE `cart_tab` ENABLE KEYS */;


--
-- Definition of table `employee_tab`
--

DROP TABLE IF EXISTS `employee_tab`;
CREATE TABLE `employee_tab` (
  `empID` int(11) NOT NULL AUTO_INCREMENT,
  `empCode` varchar(100) DEFAULT NULL,
  `empName` varchar(100) DEFAULT NULL,
  `empEmail` varchar(100) DEFAULT NULL,
  `empAge` varchar(100) DEFAULT NULL,
  `empAddress` varchar(100) DEFAULT NULL,
  `empRole` varchar(100) DEFAULT NULL,
  `jobStartedDate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_tab`
--

/*!40000 ALTER TABLE `employee_tab` DISABLE KEYS */;
INSERT INTO `employee_tab` (`empID`,`empCode`,`empName`,`empEmail`,`empAge`,`empAddress`,`empRole`,`jobStartedDate`) VALUES 
 (1,'emp_code_01','Rashika Rathnayaka','rashika@gmail.com','23','Gamphaha','CEO','2021/03/16'),
 (2,'emp_code_03','Rashika ','r11@gmail.com','23','Gamphaha','CFO','2021/03/17');
/*!40000 ALTER TABLE `employee_tab` ENABLE KEYS */;


--
-- Definition of table `order_tab`
--

DROP TABLE IF EXISTS `order_tab`;
CREATE TABLE `order_tab` (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(100) DEFAULT NULL,
  `customerID` varchar(100) DEFAULT NULL,
  `customerEmail` varchar(100) DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `orderTotalAmount` decimal(5,2) DEFAULT NULL,
  `cardNo` varchar(100) DEFAULT NULL,
  `cvvNo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_tab`
--

/*!40000 ALTER TABLE `order_tab` DISABLE KEYS */;
INSERT INTO `order_tab` (`orderID`,`orderCode`,`customerID`,`customerEmail`,`customerName`,`orderTotalAmount`,`cardNo`,`cvvNo`) VALUES 
 (1,'0_code_01','c_id_002','a@gmail.com','Rashika','300.50','100 200 300 400','1232 2334 4556 6756');
/*!40000 ALTER TABLE `order_tab` ENABLE KEYS */;


--
-- Definition of table `project_tab`
--

DROP TABLE IF EXISTS `project_tab`;
CREATE TABLE `project_tab` (
  `projectID` int(11) NOT NULL AUTO_INCREMENT,
  `projectCode` varchar(100) DEFAULT NULL,
  `projectName` varchar(100) DEFAULT NULL,
  `projectDesc` varchar(100) DEFAULT NULL,
  `projectDevBy` varchar(100) DEFAULT NULL,
  `projectPrice` decimal(5,2) DEFAULT NULL,
  `projectCategory` varchar(100) DEFAULT NULL,
  `projectServiceCharge` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`projectID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_tab`
--

/*!40000 ALTER TABLE `project_tab` DISABLE KEYS */;
INSERT INTO `project_tab` (`projectID`,`projectCode`,`projectName`,`projectDesc`,`projectDevBy`,`projectPrice`,`projectCategory`,`projectServiceCharge`) VALUES 
 (3,'p_code_01','Html , Css Design','Bootstrap framework, Mobile friendly','R.M. Rashika Rathnayaka','260.00','HTML UI design','200.00');
/*!40000 ALTER TABLE `project_tab` ENABLE KEYS */;


--
-- Definition of table `researcher_tab`
--

DROP TABLE IF EXISTS `researcher_tab`;
CREATE TABLE `researcher_tab` (
  `resID` int(11) NOT NULL AUTO_INCREMENT,
  `resCode` varchar(100) DEFAULT NULL,
  `resName` varchar(100) DEFAULT NULL,
  `resEmail` varchar(100) DEFAULT NULL,
  `resAge` varchar(100) DEFAULT NULL,
  `resAddress` varchar(100) DEFAULT NULL,
  `resRole` varchar(100) DEFAULT NULL,
  `joinDate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`resID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `researcher_tab`
--

/*!40000 ALTER TABLE `researcher_tab` DISABLE KEYS */;
INSERT INTO `researcher_tab` (`resID`,`resCode`,`resName`,`resEmail`,`resAge`,`resAddress`,`resRole`,`joinDate`) VALUES 
 (1,'r_code_01','Rashika Madhushanka','rm@gmail.com','23','Colombo','Founder','2021/03/16');
/*!40000 ALTER TABLE `researcher_tab` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
