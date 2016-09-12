/*
SQLyog Ultimate v11.24 (64 bit)
MySQL - 5.5.51 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `t_attach` */

DROP TABLE IF EXISTS `t_attach`;

CREATE TABLE `t_attach` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `path` varchar(200) NOT NULL DEFAULT '',
  `size` int(11) DEFAULT NULL,
  `create_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_attach` */

/*Table structure for table `t_options` */

DROP TABLE IF EXISTS `t_options`;

CREATE TABLE `t_options` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `key` varchar(20) NOT NULL DEFAULT '',
  `value` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_options` */

insert  into `t_options`(`id`,`key`,`value`) values (1,'site_title','王爵的技术博客'),(2,'site_subtitle','一个javaer的日常'),(3,'social_github','biezhi'),(4,'social_weibo','biezhii'),(5,'social_zhihu','biezhi');

/*Table structure for table `t_post` */

DROP TABLE IF EXISTS `t_post`;

CREATE TABLE `t_post` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '',
  `intro` varchar(200) DEFAULT NULL,
  `tags` varchar(200) DEFAULT NULL,
  `content` text,
  `create_time` int(11) NOT NULL,
  `status` tinyint(2) DEFAULT '1' COMMENT '1正常 2草稿 3删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_post` */

insert  into `t_post`(`id`,`title`,`intro`,`tags`,`content`,`create_time`,`status`) values (1,'写给java开发的运维笔记','对于Java开发人员，掌握基本的运维技能是必须的，如果你还不熟悉Linux环境，可以看[这个](https://github.com/judasn/Linux-Tutorial)教程。',NULL,'\n# 写给java开发的运维笔记\n\n对于Java开发人员，掌握基本的运维技能是必须的，如果你还不熟悉Linux环境，可以看[这个](https://github.com/judasn/Linux-Tutorial)教程。\n\n## 初级篇\n\n1. [在虚拟机里安装centos6](virtual-machine-install-centos6.md)\n2. [初始化操作系统](init-os.md)\n3. [安装jdk环境](install-jdk.md)\n4. [安装tomcat](install-tomcat.md)\n5. [安装mysql及配置](install-mysql.md)\n6. [安装nginx](install-nginx.md)\n7. [安装redis3](install-redis.md)\n\n## 中级篇\n\n1. [配置tomcat为服务](config-tomcat-service.md)\n2. [配置tomcat+nginx反向代理](config-nginx-proxy.md)\n3. [使用jemeter测试tomcat性能](use-jemeter-test-tomcat.md)\n4. [优化tomcat8](optimization-tomcat8.md)\n5. [配置多个tomcat](config-more-tomcat.md)\n6. [优化nginx配置](optimization-nginx.md)\n7. [优化mysql配置](optimization-mysql.md)\n8. [nginx+startssl配置https](nginx-startssl-https.md)',1473482874,1),(2,'1asd','','2','5',1473671797,1);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL DEFAULT '',
  `pass_word` varchar(64) NOT NULL DEFAULT '',
  `email` varchar(50) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`user_name`,`pass_word`,`email`,`status`) values (1,'biezhi','916a042f1bde53eba1e49cd59cf4eb75','biezhi.me@gmail.com',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
