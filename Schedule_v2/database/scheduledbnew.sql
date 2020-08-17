DROP DATABASE IF EXISTS scheduledbnew;
CREATE DATABASE scheduledbnew;
USE scheduledbnew;
--
-- Table structure for table `app_role`
--

DROP TABLE IF EXISTS `app_role`;
CREATE TABLE `app_role` (
  `ROLE_ID` bigint NOT NULL,
  `ROLE_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `APP_ROLE_UK` (`ROLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `app_role`
--

LOCK TABLES `app_role` WRITE;
INSERT INTO `app_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `USER_ID` bigint NOT NULL,
  `USER_NAME` varchar(36) NOT NULL,
  `ENCRYTED_PASSWORD` varchar(128) NOT NULL,
  `ENABLED` bit(1) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `APP_USER_UK` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
INSERT INTO `app_user` VALUES (1,'dbadmin1','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',_binary ''),(2,'dbuser1','$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu',_binary '');
UNLOCK TABLES;

--
-- Table structure for table `classroom_table`
--

DROP TABLE IF EXISTS `classroom_table`;
CREATE TABLE `classroom_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `classroom_number` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `classroom_table`
--

LOCK TABLES `classroom_table` WRITE;
INSERT INTO `classroom_table` VALUES (1,'301'),(2,'302');
UNLOCK TABLES;

--
-- Table structure for table `date_table`
--

DROP TABLE IF EXISTS `date_table`;
CREATE TABLE `date_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_name` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `date_table`
--

LOCK TABLES `date_table` WRITE;
INSERT INTO `date_table` VALUES (84,'2020-05-30');
UNLOCK TABLES;

--
-- Table structure for table `faculty_table`
--

DROP TABLE IF EXISTS `faculty_table`;
CREATE TABLE `faculty_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `faculty_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=147 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `faculty_table`
--

LOCK TABLES `faculty_table` WRITE;
INSERT INTO `faculty_table` VALUES (1,'матфак'),(2,'физтех'),(3,'психфак'),(4,'геофак');
UNLOCK TABLES;

--
-- Table structure for table `group_table`
--

DROP TABLE IF EXISTS `group_table`;
CREATE TABLE `group_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `group_name` varchar(12) DEFAULT NULL,
  `id_specialty` int NOT NULL,
  PRIMARY KEY (`id`,`id_specialty`),
  KEY `id_specialty` (`id_specialty`),
  CONSTRAINT `group_table_ibfk_1` FOREIGN KEY (`id_specialty`) REFERENCES `specialty_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=145 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `group_table`
--

LOCK TABLES `group_table` WRITE;
INSERT INTO `group_table` VALUES (1,'ПМ-1',1),(2,'КБ-1',2),(3,'ПОИТ-1',3),(4,'ПОИТ-2',3),(5,'УИР-1',4),(6,'НПД-1',5),(7,'НПД-2',6),(8,'ПМ-2',7);
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
INSERT INTO `hibernate_sequence` VALUES (151),(151),(151),(151),(151),(151),(151),(151),(151),(151);
UNLOCK TABLES;

--
-- Table structure for table `lesson_time_table`
--

DROP TABLE IF EXISTS `lesson_time_table`;
CREATE TABLE `lesson_time_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lesson_start` time NOT NULL,
  `lesson_end` time NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lesson_start` (`lesson_start`),
  UNIQUE KEY `lesson_end` (`lesson_end`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `lesson_time_table`
--

LOCK TABLES `lesson_time_table` WRITE;
INSERT INTO `lesson_time_table` VALUES (1,'08:30:00','09:50:00'),(2,'10:05:00','11:25:00'),(3,'11:40:00','13:00:00'),(4,'13:15:00','14:35:00'),(5,'15:05:00','16:25:00'),(6,'16:40:00','18:00:00'),(7,'18:15:00','19:35:00'),(8,'19:50:00','21:10:00');
UNLOCK TABLES;

--
-- Table structure for table `lesson_type_table`
--

DROP TABLE IF EXISTS `lesson_type_table`;
CREATE TABLE `lesson_type_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lesson_type` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `lesson_type_table`
--

LOCK TABLES `lesson_type_table` WRITE;
INSERT INTO `lesson_type_table` VALUES (1,'лекция'),(2,'практос'),(3,'лаба'),(4,'семинар');
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `schedule_table`
--

DROP TABLE IF EXISTS `schedule_table`;
CREATE TABLE `schedule_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_teacher` int NOT NULL,
  `id_lesson_type` int NOT NULL,
  `id_classroom` int NOT NULL,
  `id_group` int NOT NULL,
  `id_time` int NOT NULL,
  `id_date` int NOT NULL,
  `id_subject` int NOT NULL,
  PRIMARY KEY (`id`,`id_teacher`,`id_classroom`,`id_lesson_type`,`id_group`),
  KEY `id_teacher` (`id_teacher`),
  KEY `id_classroom` (`id_classroom`),
  KEY `id_lesson_type` (`id_lesson_type`),
  KEY `id_group` (`id_group`),
  KEY `id_date` (`id_date`),
  KEY `id_subject` (`id_subject`),
  KEY `id_time` (`id_time`),
  CONSTRAINT `schedule_table_ibfk_1` FOREIGN KEY (`id_teacher`) REFERENCES `teacher_table` (`id`),
  CONSTRAINT `schedule_table_ibfk_2` FOREIGN KEY (`id_classroom`) REFERENCES `classroom_table` (`id`),
  CONSTRAINT `schedule_table_ibfk_3` FOREIGN KEY (`id_lesson_type`) REFERENCES `lesson_type_table` (`id`),
  CONSTRAINT `schedule_table_ibfk_4` FOREIGN KEY (`id_group`) REFERENCES `group_table` (`id`),
  CONSTRAINT `schedule_table_ibfk_5` FOREIGN KEY (`id_date`) REFERENCES `date_table` (`id`),
  CONSTRAINT `schedule_table_ibfk_6` FOREIGN KEY (`id_subject`) REFERENCES `subject_name_table` (`id`),
  CONSTRAINT `schedule_table_ibfk_7` FOREIGN KEY (`id_time`) REFERENCES `lesson_time_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `specialty_subject`
--

DROP TABLE IF EXISTS `specialty_subject`;
CREATE TABLE `specialty_subject` (
  `id_specialty` int NOT NULL,
  `id_subject` int NOT NULL,
  PRIMARY KEY (`id_specialty`,`id_subject`),
  KEY `id_subject` (`id_subject`),
  CONSTRAINT `specialty_subject_ibfk_1` FOREIGN KEY (`id_specialty`) REFERENCES `specialty_table` (`id`),
  CONSTRAINT `specialty_subject_ibfk_2` FOREIGN KEY (`id_subject`) REFERENCES `subject_name_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `specialty_subject`
--

LOCK TABLES `specialty_subject` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `specialty_table`
--

DROP TABLE IF EXISTS `specialty_table`;
CREATE TABLE `specialty_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `specialty_name` varchar(30) DEFAULT NULL,
  `id_faculty` int NOT NULL,
  PRIMARY KEY (`id`,`id_faculty`),
  KEY `id_faculty` (`id_faculty`),
  CONSTRAINT `specialty_table_ibfk_1` FOREIGN KEY (`id_faculty`) REFERENCES `faculty_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `specialty_table`
--

LOCK TABLES `specialty_table` WRITE;
INSERT INTO `specialty_table` VALUES (1,'Прикладная математика',1),(2,'Комп безоп',1),(3,'Поиты',1),(4,'уиры',1),(5,'педагоги',1),(6,'педагоги',2),(7,'пф',2);
UNLOCK TABLES;

--
-- Table structure for table `subject_name_table`
--

DROP TABLE IF EXISTS `subject_name_table`;
CREATE TABLE `subject_name_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `subject_name_table`
--

LOCK TABLES `subject_name_table` WRITE;
INSERT INTO `subject_name_table` VALUES (1,'Мат Анализ'),(2,'ОАИП'),(3,'Физическая культура'),(4,'Диффуры'),(5,'ГИА'),(6,'Политология'),(7,'История'),(8,'ВМА');
UNLOCK TABLES;

--
-- Table structure for table `teacher_subject_name`
--

DROP TABLE IF EXISTS `teacher_subject_name`;
CREATE TABLE `teacher_subject_name` (
  `id_teacher` int NOT NULL,
  `id_subject` int NOT NULL,
  PRIMARY KEY (`id_teacher`,`id_subject`),
  KEY `id_subject` (`id_subject`),
  CONSTRAINT `teacher_subject_name_ibfk_1` FOREIGN KEY (`id_teacher`) REFERENCES `teacher_table` (`id`),
  CONSTRAINT `teacher_subject_name_ibfk_2` FOREIGN KEY (`id_subject`) REFERENCES `subject_name_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `teacher_subject_name`
--

LOCK TABLES `teacher_subject_name` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `teacher_table`
--

DROP TABLE IF EXISTS `teacher_table`;
CREATE TABLE `teacher_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_table`
--

LOCK TABLES `teacher_table` WRITE;
INSERT INTO `teacher_table` VALUES (1,'Иванов Иван Иванович'),(2,'иии иии иии');
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `ID` bigint NOT NULL,
  `USER_ID` bigint NOT NULL,
  `ROLE_ID` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_ROLE_UK` (`USER_ID`,`ROLE_ID`),
  KEY `USER_ROLE_FK2` (`ROLE_ID`),
  CONSTRAINT `USER_ROLE_FK1` FOREIGN KEY (`USER_ID`) REFERENCES `app_user` (`USER_ID`),
  CONSTRAINT `USER_ROLE_FK2` FOREIGN KEY (`ROLE_ID`) REFERENCES `app_role` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
INSERT INTO `user_role` VALUES (1,1,1),(2,1,2),(3,2,2);
UNLOCK TABLES;