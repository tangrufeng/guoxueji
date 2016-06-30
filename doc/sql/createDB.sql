
CREATE DATABASE `soundsystem` DEFAULT CHARACTER SET utf8;
use soundsystem;

CREATE TABLE `ad_base` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `laster_update_time` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `priority` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `audio` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `duration` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `catagory_course_relation` (
  `categoryId` int(20) NOT NULL AUTO_INCREMENT,
  `courseId` int(20) NOT NULL,
  UNIQUE KEY `sound_categoryId_sourseId` (`categoryId`,`courseId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `course` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  ` content` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `status` smallint(6) DEFAULT '0',
  `describe` varchar(1000) DEFAULT NULL,
  `soure` varchar(255) DEFAULT NULL,
  `times` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `course_catalog` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `logo_path` varchar(255) DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `device` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `device_number` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `laster_update_timme` datetime DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  ` area` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `device_task` (
  `device_id` int(20) NOT NULL,
  `timed_id` int(20) NOT NULL,
  `status` smallint(6) DEFAULT NULL,
  `time_content` varchar(255) DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  UNIQUE KEY `sound_deviceId_tsak` (`device_id`,`timed_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `share` (
  `shareId` int(20) NOT NULL,
  `contentId` int(20) NOT NULL,
  `share_time` datetime DEFAULT NULL,
  `type` smallint(6) DEFAULT NULL,
  UNIQUE KEY `sound_shareId_contentId` (`shareId`,`contentId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `laster_update_time` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_audio_relation` (
  `userid` int(20) NOT NULL AUTO_INCREMENT,
  `audioId` int(20) NOT NULL,
  `favorite` smallint(6) NOT NULL,
  `favorite_time` datetime DEFAULT NULL,
  `status` smallint(6) NOT NULL,
  UNIQUE KEY `sound_userId_audioId` (`userid`,`audioId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_course_relation` (
  `id` int(20) NOT NULL,
  `course_id` int(20) DEFAULT NULL,
  `browsing_times` int(20) DEFAULT NULL,
  `last_play_time` datetime NOT NULL,
  `favorite` smallint(6) NOT NULL,
  `favorite_time` datetime DEFAULT NULL,
  UNIQUE KEY `sound_userId_couserId` (`id`,`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_device_relation` (
  `userId` int(20) NOT NULL,
  `deviceId` int(20) NOT NULL,
  `status` smallint(6) NOT NULL,
  `binding_time` datetime DEFAULT NULL,
  UNIQUE KEY `sound_userId_deviceId` (`userId`,`deviceId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `telephone` varchar(50) DEFAULT NULL,
  `status` smallint(6) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `soundsystem`.`user_device_relation` 
ADD COLUMN `birth_month` DATE NULL AFTER `binding_time`;

