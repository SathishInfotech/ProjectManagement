/*
SQLyog Trial v12.2.4 (32 bit)
MySQL - 5.7.13-log : Database - authorizerdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`authorizerdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `authorizerdb`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

insert  into `activity`(`activity_id`,`activity_name`) values 
(1,'Controller Coding'),
(2,'DB Part Coding');

/*Table structure for table `phase_sub_phase_mapper` */

DROP TABLE IF EXISTS `phase_sub_phase_mapper`;

CREATE TABLE `phase_sub_phase_mapper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `phase_id` int(11) NOT NULL,
  `sub_phase_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `phase_id` (`phase_id`),
  KEY `sub_phase_id` (`sub_phase_id`),
  CONSTRAINT `phase_sub_phase_mapper_ibfk_1` FOREIGN KEY (`phase_id`) REFERENCES `phases` (`phase_id`),
  CONSTRAINT `phase_sub_phase_mapper_ibfk_2` FOREIGN KEY (`sub_phase_id`) REFERENCES `sub_phases` (`sub_phase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `phase_sub_phase_mapper` */

insert  into `phase_sub_phase_mapper`(`id`,`phase_id`,`sub_phase_id`) values 
(1,3,1),
(2,3,2),
(3,3,3);

/*Table structure for table `phases` */

DROP TABLE IF EXISTS `phases`;

CREATE TABLE `phases` (
  `phase_id` int(11) NOT NULL AUTO_INCREMENT,
  `phase_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`phase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `phases` */

insert  into `phases`(`phase_id`,`phase_name`) values 
(1,'Requirement'),
(2,'Design'),
(3,'Development'),
(4,'Testing');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(250) NOT NULL,
  `project_desc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`project_id`,`project_name`,`project_desc`) values 
(1,'Citi Project','Project A'),
(2,'KY Project','Project B'),
(3,'ProjectC','Project C');

/*Table structure for table `project_users` */

DROP TABLE IF EXISTS `project_users`;

CREATE TABLE `project_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `project_users_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `project_users_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `project_users` */

insert  into `project_users`(`id`,`project_id`,`user_id`) values 
(1,1,2),
(2,2,3),
(3,2,4),
(4,3,5);

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`id`,`role`) values 
(1,'MANAGER'),
(2,'TECH_LEAD'),
(3,'SENIOR_DEVELOPER'),
(4,'DEVELOPER');

/*Table structure for table `sub_phases` */

DROP TABLE IF EXISTS `sub_phases`;

CREATE TABLE `sub_phases` (
  `sub_phase_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_phase_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`sub_phase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sub_phases` */

insert  into `sub_phases`(`sub_phase_id`,`sub_phase_name`) values 
(1,'Coding'),
(2,'UnitTesting'),
(3,'Code Review'),
(4,'Document Preparation'),
(5,'Code Rework');

/*Table structure for table `task_activity_mapper` */

DROP TABLE IF EXISTS `task_activity_mapper`;

CREATE TABLE `task_activity_mapper` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `task_id` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `estimate` decimal(2,0) DEFAULT NULL,
  `phase_sub_phase_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `task_activity_mapper.activity_id_idx` (`activity_id`),
  KEY `task_activity_mapper.phase_id_idx` (`phase_sub_phase_id`),
  KEY `task_activity_mapper.sub_phase_id_idx` (`task_id`),
  CONSTRAINT `task_activity_mapper.activity_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `task_activity_mapper.task_id` FOREIGN KEY (`task_id`) REFERENCES `tasks` (`task_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `task_activity_mapper_ibfk_1` FOREIGN KEY (`phase_sub_phase_id`) REFERENCES `phase_sub_phase_mapper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `task_activity_mapper` */

insert  into `task_activity_mapper`(`id`,`task_id`,`activity_id`,`estimate`,`phase_sub_phase_id`) values 
(1,1,1,'80',1),
(2,1,2,'60',2);

/*Table structure for table `task_activity_schedule` */

DROP TABLE IF EXISTS `task_activity_schedule`;

CREATE TABLE `task_activity_schedule` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `task_activity_id` int(11) unsigned NOT NULL,
  `phase_sub_phase_id` int(11) unsigned NOT NULL,
  `sequence` int(11) NOT NULL,
  `planned_start_date` datetime NOT NULL,
  `planned_end_date` datetime NOT NULL,
  `actual_start_date` datetime NOT NULL,
  `actual_end_date` datetime DEFAULT NULL,
  `task_activity_status` varchar(1) NOT NULL,
  `poc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `task_activity_id` (`task_activity_id`),
  KEY `phase_sub_phase_id` (`phase_sub_phase_id`),
  CONSTRAINT `task_activity_schedule_ibfk_1` FOREIGN KEY (`task_activity_id`) REFERENCES `task_activity_mapper` (`id`),
  CONSTRAINT `task_activity_schedule_ibfk_2` FOREIGN KEY (`phase_sub_phase_id`) REFERENCES `phase_sub_phase_mapper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `task_activity_schedule` */

insert  into `task_activity_schedule`(`id`,`task_activity_id`,`phase_sub_phase_id`,`sequence`,`planned_start_date`,`planned_end_date`,`actual_start_date`,`actual_end_date`,`task_activity_status`,`poc`) values 
(1,1,1,1,'2016-07-01 22:22:07','2016-08-31 22:22:25','2016-07-01 22:23:11','2016-07-13 22:24:13','P',NULL),
(2,2,2,2,'2016-07-04 22:24:40','2016-07-13 22:24:46','2016-07-05 22:24:52','2016-07-14 22:24:58','C',NULL);

/*Table structure for table `tasks` */

DROP TABLE IF EXISTS `tasks`;

CREATE TABLE `tasks` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(45) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tasks` */

insert  into `tasks`(`task_id`,`task_name`,`user_id`) values 
(1,'Review Case',3),
(2,'Create Case',3),
(3,'Generate Letter',2),
(4,'Send Letter',2);

/*Table structure for table `time_tracker` */

DROP TABLE IF EXISTS `time_tracker`;

CREATE TABLE `time_tracker` (
  `timesheet_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `time_date` datetime NOT NULL,
  `task_activity_id` int(11) unsigned NOT NULL,
  `phase_sub_phase_id` int(11) unsigned NOT NULL,
  `hours_spent` decimal(2,0) NOT NULL,
  `id` int(11) NOT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`timesheet_id`),
  KEY `time_tracker.id_idx` (`id`),
  KEY `time_tracker.activity_id_idx` (`task_activity_id`),
  KEY `time_tracker.sub_phase_id_idx` (`phase_sub_phase_id`),
  CONSTRAINT `time_tracker_ibfk_1` FOREIGN KEY (`task_activity_id`) REFERENCES `task_activity_mapper` (`id`),
  CONSTRAINT `time_tracker_ibfk_2` FOREIGN KEY (`phase_sub_phase_id`) REFERENCES `phase_sub_phase_mapper` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `time_tracker` */

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `role_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `user_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `user_roles` */

insert  into `user_roles`(`id`,`user_id`,`role_id`) values 
(1,1,1),
(2,2,2),
(3,3,2),
(4,4,2),
(5,5,2);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(3) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`password`,`enabled`) values 
(1,'Mohamed.Ismail@lntinfotech.com','$2a$10$EduspOO97f5xMCOuVTaagu.aNlFzv52fkMbW4T7JLvQ/YLxFGrOnK',1),
(2,'akalya@gmail.com','$2a$10$EduspOO97f5xMCOuVTaagu.aNlFzv52fkMbW4T7JLvQ/YLxFGrOnK',1),
(3,'sathish@gmail.com','$2a$10$EduspOO97f5xMCOuVTaagu.aNlFzv52fkMbW4T7JLvQ/YLxFGrOnK',1),
(4,'bala@gmail.com','$2a$10$EduspOO97f5xMCOuVTaagu.aNlFzv52fkMbW4T7JLvQ/YLxFGrOnK',1),
(5,'kumar@gmail.com','$2a$10$EduspOO97f5xMCOuVTaagu.aNlFzv52fkMbW4T7JLvQ/YLxFGrOnK',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
