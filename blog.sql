# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.14)
# Database: blog
# Generation Time: 2016-09-10 05:17:26 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_attach
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_attach`;

CREATE TABLE `t_attach` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `path` varchar(200) NOT NULL DEFAULT '',
  `size` int(11) DEFAULT NULL,
  `create_time` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_options
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_options`;

CREATE TABLE `t_options` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `key` varchar(20) NOT NULL DEFAULT '',
  `value` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_options` WRITE;
/*!40000 ALTER TABLE `t_options` DISABLE KEYS */;

INSERT INTO `t_options` (`id`, `key`, `value`)
VALUES
	(1,'site_title','王爵的技术博客'),
	(2,'site_subtitle','一个javaer的日常');

/*!40000 ALTER TABLE `t_options` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_post
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_post`;

CREATE TABLE `t_post` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL DEFAULT '',
  `intro` varchar(200) DEFAULT NULL,
  `content` text,
  `create_time` int(11) NOT NULL,
  `status` tinyint(2) DEFAULT NULL COMMENT '1正常 2草稿 3删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_post` WRITE;
/*!40000 ALTER TABLE `t_post` DISABLE KEYS */;

INSERT INTO `t_post` (`id`, `title`, `intro`, `content`, `create_time`, `status`)
VALUES
	(1,'写给java开发的运维笔记',NULL,'\n# 写给java开发的运维笔记\n\n对于Java开发人员，掌握基本的运维技能是必须的，如果你还不熟悉Linux环境，可以看[这个](https://github.com/judasn/Linux-Tutorial)教程。\n\n## 初级篇\n\n1. [在虚拟机里安装centos6](virtual-machine-install-centos6.md)\n2. [初始化操作系统](init-os.md)\n3. [安装jdk环境](install-jdk.md)\n4. [安装tomcat](install-tomcat.md)\n5. [安装mysql及配置](install-mysql.md)\n6. [安装nginx](install-nginx.md)\n7. [安装redis3](install-redis.md)\n\n## 中级篇\n\n1. [配置tomcat为服务](config-tomcat-service.md)\n2. [配置tomcat+nginx反向代理](config-nginx-proxy.md)\n3. [使用jemeter测试tomcat性能](use-jemeter-test-tomcat.md)\n4. [优化tomcat8](optimization-tomcat8.md)\n5. [配置多个tomcat](config-more-tomcat.md)\n6. [优化nginx配置](optimization-nginx.md)\n7. [优化mysql配置](optimization-mysql.md)\n8. [nginx+startssl配置https](nginx-startssl-https.md)',1473482874,1);

/*!40000 ALTER TABLE `t_post` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_post_tag
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_post_tag`;

CREATE TABLE `t_post_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_tag
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL DEFAULT '',
  `pass_word` varchar(64) NOT NULL DEFAULT '',
  `email` varchar(50) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;

INSERT INTO `t_user` (`id`, `user_name`, `pass_word`, `email`, `status`)
VALUES
	(1,'','',NULL,0);

/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
