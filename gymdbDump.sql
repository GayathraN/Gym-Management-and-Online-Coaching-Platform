-- MySQL dump 10.13  Distrib 9.1.0, for Win64 (x86_64)
--
-- Host: localhost    Database: gymdb
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_number` int NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'kekirawa',717319700,'eranga','Male','1234','erangaA');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assigned_workout`
--

DROP TABLE IF EXISTS `assigned_workout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assigned_workout` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `booking_id` bigint DEFAULT NULL,
  `description` tinytext,
  `reps` int NOT NULL,
  `sets` int NOT NULL,
  `video_link` varchar(255) DEFAULT NULL,
  `workout_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assigned_workout`
--

LOCK TABLES `assigned_workout` WRITE;
/*!40000 ALTER TABLE `assigned_workout` DISABLE KEYS */;
INSERT INTO `assigned_workout` VALUES (1,1,'-',10,5,'https://www.shutterstock.com/shutterstock/videos/1100873253/preview/stock-footage-dumbbell-chest-press-incline-bench-fitness-exercise-workout-animation-male-muscle-highlight.webm','Incline Bench Press'),(2,1,'-',5,2,'https://www.shutterstock.com/shutterstock/videos/1100873253/preview/stock-footage-dumbbell-chest-press-incline-bench-fitness-exercise-workout-animation-male-muscle-highlight.webm','Incline Bench Press'),(3,1,'-',5,2,'https://www.shutterstock.com/shutterstock/videos/1100873235/preview/stock-footage-push-ups-bodyweight-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at-k.webm','Push-ups'),(4,1,'-',10,5,'https://www.shutterstock.com/shutterstock/videos/1100873253/preview/stock-footage-dumbbell-chest-press-incline-bench-fitness-exercise-workout-animation-male-muscle-highlight.webm','Incline Bench Press'),(5,1,'-',5,2,'https://www.shutterstock.com/shutterstock/videos/1100873235/preview/stock-footage-push-ups-bodyweight-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at-k.webm','Push-ups'),(6,1,'-',0,0,'https://www.shutterstock.com/shutterstock/videos/1104342945/preview/stock-footage-pull-up-normal-grip-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at-k.webm','Pull-ups'),(7,1,'-',0,0,' ','T-Bar Row'),(8,1,'-',10,5,'https://www.shutterstock.com/shutterstock/videos/1098699603/preview/stock-footage-crunch-frog-on-floor-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at-k.webm ','Crunches'),(9,2,'-',7,8,'https://www.shutterstock.com/shutterstock/videos/1100873213/preview/stock-footage-dumbbell-reverse-wrist-curl-fitness-exercise-workout-animation-male-muscle-highlight-demonstration.webm','Reverse Wrist Curls'),(10,1,'-',40,6,'https://www.shutterstock.com/shutterstock/videos/1104342987/preview/stock-footage-dumbbells-single-arm-row-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at.webm','Single-arm Dumbbell Row'),(11,1,'-',1,1,'https://www.shutterstock.com/shutterstock/videos/1104342987/preview/stock-footage-dumbbells-single-arm-row-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at.webm','Single-arm Dumbbell Row'),(12,3,'-',0,0,'https://www.shutterstock.com/shutterstock/videos/1098223947/preview/stock-footage-barbell-lying-close-grip-press-fitness-exercise-workout-animation-male-muscle-highlight.webm','Bench Press'),(13,3,'-',0,0,'https://www.shutterstock.com/shutterstock/videos/1100873197/preview/stock-footage-wrist-curl-dumbbell-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at-k.webm','Wrist Curls (Dumbbell)'),(14,3,'-',0,0,'https://www.shutterstock.com/shutterstock/videos/1100526295/preview/stock-footage-arnold-press-dumbbell-fitness-exercise-workout-animation-male-muscle-highlight-demonstration-at-k.webm','Arnold Press'),(15,3,'-',10,5,'https://www.shutterstock.com/shutterstock/videos/1098223947/preview/stock-footage-barbell-lying-close-grip-press-fitness-exercise-workout-animation-male-muscle-highlight.webm','Bench Press'),(16,3,'-',10,5,'https://www.shutterstock.com/shutterstock/videos/1098223947/preview/stock-footage-barbell-lying-close-grip-press-fitness-exercise-workout-animation-male-muscle-highlight.webm','Bench Press'),(17,3,'-',40,1,'https://www.shutterstock.com/shutterstock/videos/1100873091/preview/stock-footage-chest-fly-high-to-low-resistance-band-fitness-exercise-workout-animation-male-muscle-highlight.webm','Chest Fly');
/*!40000 ALTER TABLE `assigned_workout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coach`
--

DROP TABLE IF EXISTS `coach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coach` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `experience_history` varchar(255) DEFAULT NULL,
  `experience_years` int NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coach`
--

LOCK TABLES `coach` WRITE;
/*!40000 ALTER TABLE `coach` DISABLE KEYS */;
INSERT INTO `coach` VALUES (1,'kekirawa','0717319700','top',1,'eranga','Male','1234','erangaC');
/*!40000 ALTER TABLE `coach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_category`
--

DROP TABLE IF EXISTS `meal_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meal_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_category`
--

LOCK TABLES `meal_category` WRITE;
/*!40000 ALTER TABLE `meal_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_item`
--

DROP TABLE IF EXISTS `meal_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meal_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `meal_category_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt24arlurou0n1nrq0u3smft1p` (`meal_category_id`),
  CONSTRAINT `FKt24arlurou0n1nrq0u3smft1p` FOREIGN KEY (`meal_category_id`) REFERENCES `meal_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_item`
--

LOCK TABLES `meal_item` WRITE;
/*!40000 ALTER TABLE `meal_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_plan`
--

DROP TABLE IF EXISTS `meal_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meal_plan` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `member_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKmvx2l9o26h7x5273xhipwexwe` (`member_id`),
  CONSTRAINT `FK8vx0aein5j32j98038vcvj922` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_plan`
--

LOCK TABLES `meal_plan` WRITE;
/*!40000 ALTER TABLE `meal_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meal_plan_item`
--

DROP TABLE IF EXISTS `meal_plan_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meal_plan_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` varchar(255) DEFAULT NULL,
  `meal_type` enum('MEAL_1','MEAL_2','MEAL_3','MEAL_4','MEAL_5') NOT NULL,
  `meal_item_id` bigint NOT NULL,
  `meal_plan_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa691t4v1e62kbqmm80kla3ypr` (`meal_item_id`),
  KEY `FKt2arpsgr6ohdk5a772a4qwl7` (`meal_plan_id`),
  CONSTRAINT `FKa691t4v1e62kbqmm80kla3ypr` FOREIGN KEY (`meal_item_id`) REFERENCES `meal_item` (`id`),
  CONSTRAINT `FKt2arpsgr6ohdk5a772a4qwl7` FOREIGN KEY (`meal_plan_id`) REFERENCES `meal_plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meal_plan_item`
--

LOCK TABLES `meal_plan_item` WRITE;
/*!40000 ALTER TABLE `meal_plan_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `meal_plan_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `emergency_contact` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `medical_conditions` varchar(255) DEFAULT NULL,
  `member_id` varchar(255) DEFAULT NULL,
  `membership_type` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'kekirawa','0717319700',NULL,'0252265062','eranga','Male','No,asitha.eranga18@gmail.com','112','Basic','1234','eranga');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `attendance` bit(1) NOT NULL,
  `is_available` bit(1) NOT NULL,
  `reservation_number` int NOT NULL,
  `schedule_date` date DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `coach_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4tco8fkqhs5jesb5jn56n7vd3` (`coach_id`),
  CONSTRAINT `FK4tco8fkqhs5jesb5jn56n7vd3` FOREIGN KEY (`coach_id`) REFERENCES `coach` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,_binary '\0',_binary '\0',3,'2024-10-29','eranga',1),(2,_binary '\0',_binary '\0',10,'2024-11-19','eranga',1),(3,_binary '\0',_binary '\0',5,'2024-12-02','eranga',1);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-30 21:29:25
