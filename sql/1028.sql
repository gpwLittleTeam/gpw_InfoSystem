-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: gpwinfomanagementsystem
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `code_counciltitle`
--

DROP TABLE IF EXISTS `code_counciltitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_counciltitle` (
  `code` char(2) NOT NULL COMMENT '代码',
  `name` char(10) DEFAULT NULL COMMENT '名称',
  `comments` char(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_counciltitle`
--

LOCK TABLES `code_counciltitle` WRITE;
/*!40000 ALTER TABLE `code_counciltitle` DISABLE KEYS */;
INSERT INTO `code_counciltitle` VALUES ('01','主任委员',NULL),('02','副主任委员',NULL),('03','委员',NULL),('04','test1',NULL),('05','test2',NULL);
/*!40000 ALTER TABLE `code_counciltitle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_degree`
--

DROP TABLE IF EXISTS `code_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_degree` (
  `code` char(3) NOT NULL COMMENT '代码',
  `degree` char(16) NOT NULL COMMENT '学位',
  `comments` char(30) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_degree`
--

LOCK TABLES `code_degree` WRITE;
/*!40000 ALTER TABLE `code_degree` DISABLE KEYS */;
INSERT INTO `code_degree` VALUES ('100','博士',NULL),('101','名誉博士',NULL),('102','副博士',NULL),('300','硕士',NULL),('400','双学士',NULL),('500','学士',NULL);
/*!40000 ALTER TABLE `code_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_education`
--

DROP TABLE IF EXISTS `code_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_education` (
  `code` char(2) NOT NULL COMMENT '代码',
  `education` char(20) NOT NULL COMMENT '文化程度',
  `comments` char(30) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_education`
--

LOCK TABLES `code_education` WRITE;
/*!40000 ALTER TABLE `code_education` DISABLE KEYS */;
INSERT INTO `code_education` VALUES ('01','研究生毕业','null'),('09','研究生肄业',NULL),('11','大学本科毕业',NULL),('17','大学普通班',NULL),('18','相当大学',NULL),('19','大学本科肄业',NULL),('21','大学专科毕业',NULL),('28','相当大专',NULL),('29','大学专科肄业',NULL),('31','中专毕业',NULL),('38','相当中专',NULL),('39','中专肄业',NULL),('41','技校毕业',NULL),('51','高中毕业',NULL);
/*!40000 ALTER TABLE `code_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_engage`
--

DROP TABLE IF EXISTS `code_engage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_engage` (
  `code` char(1) NOT NULL COMMENT '代码',
  `employ` char(10) NOT NULL COMMENT '受聘情况',
  `comments` char(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_engage`
--

LOCK TABLES `code_engage` WRITE;
/*!40000 ALTER TABLE `code_engage` DISABLE KEYS */;
INSERT INTO `code_engage` VALUES ('1','聘任',NULL),('2','不聘任',NULL),('3','待聘',NULL),('4','缓聘',NULL),('9','其他',NULL);
/*!40000 ALTER TABLE `code_engage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_grouptitle`
--

DROP TABLE IF EXISTS `code_grouptitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_grouptitle` (
  `code` char(2) NOT NULL COMMENT '代码',
  `post` char(4) NOT NULL COMMENT '专业组职务',
  `comments` char(50) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_grouptitle`
--

LOCK TABLES `code_grouptitle` WRITE;
/*!40000 ALTER TABLE `code_grouptitle` DISABLE KEYS */;
INSERT INTO `code_grouptitle` VALUES ('01','组长',NULL),('02','组员',NULL);
/*!40000 ALTER TABLE `code_grouptitle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_judge`
--

DROP TABLE IF EXISTS `code_judge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_judge` (
  `code` char(1) NOT NULL COMMENT '代码',
  `judge` char(4) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_judge`
--

LOCK TABLES `code_judge` WRITE;
/*!40000 ALTER TABLE `code_judge` DISABLE KEYS */;
INSERT INTO `code_judge` VALUES ('0','否'),('1','是');
/*!40000 ALTER TABLE `code_judge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_series`
--

DROP TABLE IF EXISTS `code_series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_series` (
  `code` char(2) NOT NULL COMMENT '代码',
  `series` char(50) NOT NULL COMMENT '系列名称',
  `comments` char(50) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_series`
--

LOCK TABLES `code_series` WRITE;
/*!40000 ALTER TABLE `code_series` DISABLE KEYS */;
INSERT INTO `code_series` VALUES ('01','高等学校教师',NULL),('02','中等专业学校教师',NULL),('03','中学教师',NULL),('04','海关人员',NULL);
/*!40000 ALTER TABLE `code_series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_sex`
--

DROP TABLE IF EXISTS `code_sex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_sex` (
  `code` char(2) NOT NULL COMMENT '代码',
  `sex` char(10) DEFAULT NULL COMMENT '性别',
  `comments` char(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_sex`
--

LOCK TABLES `code_sex` WRITE;
/*!40000 ALTER TABLE `code_sex` DISABLE KEYS */;
INSERT INTO `code_sex` VALUES ('1','男',NULL),('2','女',NULL),('3','未知',NULL);
/*!40000 ALTER TABLE `code_sex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_special`
--

DROP TABLE IF EXISTS `code_special`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_special` (
  `code` char(10) NOT NULL COMMENT '代码',
  `specialname` char(100) NOT NULL COMMENT '专业名称',
  `comments` char(50) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_special`
--

LOCK TABLES `code_special` WRITE;
/*!40000 ALTER TABLE `code_special` DISABLE KEYS */;
INSERT INTO `code_special` VALUES ('01','哲学',NULL),('0101','哲学类',NULL),('010101','哲学',NULL),('010102','逻辑学',NULL),('010103','伦理学',NULL),('010104','宗教学',NULL),('010151','应用美学',NULL),('010152','宗教事务管理',NULL),('010199','哲学类其他专业',NULL),('02','经济学',NULL),('0201','经济学类',NULL),('020101','经济学',NULL),('020102','国民经济管理',NULL),('020103','统计学',NULL),('020104','财政学',NULL),('020105','货币银行学',NULL);
/*!40000 ALTER TABLE `code_special` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_title`
--

DROP TABLE IF EXISTS `code_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_title` (
  `code` char(10) NOT NULL COMMENT '代码',
  `titlename` char(30) NOT NULL COMMENT '职称名称',
  `comments` char(30) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_title`
--

LOCK TABLES `code_title` WRITE;
/*!40000 ALTER TABLE `code_title` DISABLE KEYS */;
INSERT INTO `code_title` VALUES ('011','高校教授',NULL),('014','高校助教',NULL),('015','高校计划副教授',NULL),('022','中专高级讲师',NULL),('03','技工学校教师',NULL),('032','技校高级讲师',NULL),('04','中学教师',NULL),('044','中学二级教师',NULL);
/*!40000 ALTER TABLE `code_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_titlegrade`
--

DROP TABLE IF EXISTS `code_titlegrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_titlegrade` (
  `code` char(2) NOT NULL COMMENT '代码',
  `titlegrade` char(10) NOT NULL COMMENT '职称等级',
  `comments` char(30) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_titlegrade`
--

LOCK TABLES `code_titlegrade` WRITE;
/*!40000 ALTER TABLE `code_titlegrade` DISABLE KEYS */;
INSERT INTO `code_titlegrade` VALUES ('0','无',NULL),('1','正高级',NULL),('2','副高级',NULL),('3','中级',NULL),('4','助理级',NULL),('5','员级',NULL),('6','初级',NULL);
/*!40000 ALTER TABLE `code_titlegrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expert_baseinfo`
--

DROP TABLE IF EXISTS `expert_baseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expert_baseinfo` (
  `Expert_id` int(9) NOT NULL AUTO_INCREMENT COMMENT '专家标识',
  `Expert_Field1` varchar(100) NOT NULL COMMENT '专家编号',
  `Expert_Field2` varchar(100) NOT NULL COMMENT '专家姓名',
  `Expert_Field3` varchar(100) NOT NULL COMMENT '专家性别',
  `Expert_Field4` varchar(100) NOT NULL COMMENT '身份证号',
  `Expert_Field5` varchar(100) NOT NULL COMMENT '出生年月',
  `Expert_Field6` varchar(100) DEFAULT NULL COMMENT '最高学历 ',
  `Expert_Field7` varchar(100) DEFAULT NULL COMMENT '所获学位',
  `Expert_Field8` varchar(100) DEFAULT NULL COMMENT '毕肄业时间',
  `Expert_Field9` varchar(100) DEFAULT NULL COMMENT '毕肄业学校',
  `Expert_Field10` varchar(100) DEFAULT NULL COMMENT '所学专业',
  `Expert_Field11` varchar(100) DEFAULT NULL COMMENT '参加工作时间',
  `Expert_Field12` varchar(100) DEFAULT NULL COMMENT '现从事专业',
  `Expert_Field13` varchar(100) DEFAULT NULL COMMENT '现从事专业年限',
  `Expert_Field14` varchar(100) DEFAULT NULL COMMENT '工作单位',
  `Expert_Field15` varchar(100) DEFAULT NULL COMMENT '是否本单位',
  `Expert_Field16` varchar(100) DEFAULT NULL COMMENT '行政职务',
  `Expert_Field17` varchar(100) DEFAULT NULL COMMENT '现有任职资格',
  `Expert_Field18` varchar(100) DEFAULT NULL COMMENT '资格级别',
  `Expert_Field19` varchar(100) DEFAULT NULL COMMENT '任职资格所属系列',
  `Expert_Field20` varchar(100) DEFAULT NULL COMMENT '任职资格取得时间',
  `Expert_Field21` varchar(100) DEFAULT NULL COMMENT '聘任情况',
  `Expert_Field22` varchar(100) DEFAULT NULL COMMENT '曾任高评委名称',
  `Expert_Field23` varchar(100) DEFAULT NULL COMMENT '曾属高评委职务',
  `Expert_Field24` varchar(100) DEFAULT NULL COMMENT '任职时间',
  `Expert_Field25` varchar(100) DEFAULT NULL COMMENT '通信地址',
  `Expert_Field26` varchar(100) DEFAULT NULL COMMENT '手机',
  `Expert_Field27` varchar(100) DEFAULT NULL COMMENT '办公室电话',
  `Expert_Field28` varchar(100) DEFAULT NULL COMMENT '住宅电话',
  `Expert_Field29` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `Expert_Field30` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `Expert_Field31` varchar(100) DEFAULT NULL COMMENT '所属任高评委名称',
  `Expert_Field32` varchar(100) DEFAULT NULL COMMENT '拟任高评委职务',
  `Expert_Field33` varchar(100) DEFAULT NULL COMMENT '所属专业组名称',
  `Expert_Field34` varchar(100) DEFAULT NULL COMMENT '拟任专业组职务\n01组长\n02组员\n03其他',
  `Expert_Field35` varchar(100) DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`Expert_id`),
  UNIQUE KEY `Expert_Field1_UNIQUE` (`Expert_Field1`),
  UNIQUE KEY `Expert_Field4_UNIQUE` (`Expert_Field4`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expert_baseinfo`
--

LOCK TABLES `expert_baseinfo` WRITE;
/*!40000 ALTER TABLE `expert_baseinfo` DISABLE KEYS */;
INSERT INTO `expert_baseinfo` VALUES (20,'01010001','陈昊','1','330227199508115374','1996-08-11','01','101','2005-07-01','浙江工业大学','020101','2005-07-01','020102','10','杭州奥特曼有限公司','1','测试职务','011','1','01','2016-09-23','1','测试高评委1','01','2016-09-23','宁波市鄞州区奥特曼大道2-101','17816872632','0571-88132995','0574-88123452','315100','voicebeer@126.com','0101','01','00007','02','2016-12-15'),(21,'01010002','高天宇','1','330227199512125374','1995-12-12','02','102','2007-01-07','浙江大学','020102','2007-01-07','020101','5','杭州罗马尼亚有限公司','1','测试职务2','012','2','02','2016-07-02','2','测试高评委2','02','2016-07-02','杭州市下城区罗马尼亚大道2-207','17816879937','0571-88205355','0571-88395335','310000','ultraman@qq.com','0101','03','00007','01','2016-12-15'),(22,'01010003','陈天宇','1','330227199602095374','1996-02-10','09','102','2017-01-01','湖州市测试大学','020102','2010-01-10','020102','5','湖州测试有限公司','1','测试职务3','012','3','03','2011-01-02','1','测试高评委3','01','2011-06-06','杭州市测试地址','17816879937','0571-88205355','0571-88395335','315192','voicebeer@126.com','0101','01','00008','02','2016-12-15'),(23,'01010004','俞婧瑶','2','330227199602085374','1996-02-10','17','300','2016-12-08','杭州市测试大学','010101','2017-01-02','010101','3','杭州测试有限公司','0','测试职务2','015','3','02','2010-02-02','1','测试高评委1','01','2015-07-08','宁波市测试地址','17816879937','0571-88205355','0571-88395335','315190','voicebeer@126.com','0101','02','00007','02','2016-12-15'),(24,'01020005','陈威涛','1','330227199602075374','2016-12-31','01','100','2011-05-05','温州市测试大学','010101','2008-08-08','010101','3','温州测试有限公司','0','测试职务3','012','2','02','2007-05-05','1','测试高评委3','02','2016-01-01','温州市测试地址','17816879937','0571-88205355','0571-88395335','315191','voicebeer@126.com','0102','02','00009','02','2016-12-15'),(25,'01020006','陈杨','1','330227199602065374','2016-11-30','01','100','2008-08-08','上海测试大学','010101','2005-07-08','010199','3','上海测试有限公司','0','测试职务4','011','0','03','2010-07-04','2','null','01','2017-01-01','台州市测试地址','17816879937','0571-88205355','0571-88395335','315100','voicebeer@126.com','0102','03','00006','01','2017-01-01'),(26,'01020007','何波','1','330227199602055374','1951-07-13','01','100','2007-06-06','北京测试大学','010199','2009-09-09','010152','2','北京测试有限公司','0','测试职务1','015','1','01','2008-03-01','2','null','02','2016-10-23','上海测试地址','17816879937','0571-88205355','0571-88395335','315100','voicebeer@126.com','0102','01','00001','02','2017-01-02'),(27,'01020008','何天宇','1','330227199602045374','2016-11-30','09','500','2010-10-10','香港测试大学','010152','2014-10-23','010102','1','香港测试有限公司','1','测试职务2','015','2','02','2005-12-30','2','null','02','2016-11-11','北京测试地址','17816879937','0571-88205355','0571-88395335','315100','voicebeer@126.com','0102','03','00009','02','2017-01-27'),(28,'01030009','胡一轮','1','330227199602035374','2014-12-30','09','100','2015-10-28','宁波市测试大学','010102','2011-09-11','010152','8','宁波测试有限公司','1','测试职务1','012','3','03','2004-11-30','2','测试高评委3','02','2013-01-02','温州市测试地址','17816879937','0571-88205355','0571-88395335','315100','voicebeer@126.com','0103','02','00010','02','2017-01-28'),(29,'01030010','李晨阳','2','330227199602025374','2013-07-25','11','500','2008-05-26','台州市测试大学','010152','2012-09-27','010199','4','杭州市测试单位','0','测试职务2','015','3','03','2010-06-23','3','测试高评委1','02','2011-04-22','杭州市测试地址','17816879937','17816879937','0574-88222333','310000','370396850@qq.com','0103','02','00011','01','2011-07-27'),(30,'01030011','陈晨阳','2','330227199602105373','2013-07-26','18','300','2011-07-26','宁波市测试大学','010199','2001-01-22','010199','1','宁波测试有限公司','1','测试职务3','011','2','02','2008-01-08','2','测试高评委3','01','2010-01-02','深圳测试地址','17816879937','0571-88205355','0571-88395335','315100','voicebeer@126.com','0103','01','00010','01','2017-01-05'),(31,'01030012','胡晨阳','2','330227199602015374','2013-08-27','09','300','2005-05-05','中国测试大学','020101','2002-01-22','020101','3','中国测试有限公祠','1','测试职务1','012','1','01','2006-06-06','2','测试高评委2','01','2008-01-02','香港测试地址','17816879937','0571-88205355','0571-88395335','315100','voicebeer@126.com','0103','01','00011','02','2016-12-31'),(32,'01010005','陈昊地','2','330227199602115374','1996-08-11','17','300','2008-10-28','杭州市测试大学','020103','2010-06-27','020104','6','杭州市测试单位','1','组长','01','3','01','2010-08-29','1','浙江工业大学','03','2011-09-28','杭州市测试地址','13857852999','0574-88139226','0574-88222333','310000','370396850@qq.com','0101','03','00008','02','2013-09-29'),(33,'01030013','haidhf','2','','','-1','0','','','-1','','-1','','','-1','','011','6','-1','','-1','0103','-1','','','','','','','','0103','-1','-1','-1',''),(35,'01030014','chenhao','1','330227199602105374','1997-08-11','09','-1','','','-1','','-1','','','-1','','-1','0','-1','','-1','0103','-1','','','','','','','','0103','-1','-1','-1',''),(36,'01020009','张元鸣','1','410901197710281518','1977-03-21','01','100','2016-11-09','日本宇都宫大学','020103','2007-01-30','0101','20','浙江工业大学','1','研究所所长','011','2','01','2017-05-09','1','0103','02','2017-05-16','留和路288号','13732297279','0571-85290535','0571-85290535','310023','zym@zjut.edu.cn','0102','03','-1','02',''),(37,'01020010','王庆喜','1','360111197602030038','1976-02-03','01','100','2005-03-01','杭州市浙江大学','02','2000-07-01','020101','12','浙江工业大学 全球浙商发展研究院','1','无','-1','0','01','2007-09-01','1','0103','02','2007-09-01','杭州市浙江工业大学 全球浙商发展研究院','','','','','','0102','03','-1','01','2017-05-08'),(38,'01020011','朱华','1','360103197411121711','1974-11-12','01','300','2004-06-01','杭州市 浙江工业大学','-1','1996-08-01','-1','20','浙江工业大学信息工程学院','1','专业实验室副主任','-1','0','01','2005-09-01','1','0102','03','2004-06-01','','','','','','','0102','03','-1','02','2017-05-09'),(39,'01020012','李志中','1','412327197907270559','1979-07-27','01','300','2010-06-01','杭州市 浙江工业大学','-1','2010-12-01','-1','7','浙江工业大学信息学院','1','信息学院实验室党支部书记','-1','0','-1','','1','0102','03','2007-09-01','','','','','','','0102','02','1022000001','02','2017-05-09'),(40,'01020013','卢晗锋','1','330724197712240318','1977-12-24','01','100','2010-01-01','杭州市 浙江工业大学','-1','2002-08-01','-1','15','浙江工业大学化学工程学院','1','能源化工系主任 催化反应工程党支部 书记','-1','0','01','2002-08-01','1','0102','02','2002-08-01','','','','','','','0102','03','00001','01','2017-05-09'),(41,'01020014','金诗南','2','330782198612310022','1986-12-31','01','300','2013-01-01','杭州市 浙江工业大学','-1','2008-08-01','-1','11','浙江工业大学信息工程学院','1','信息学院团委书记 ','01','0','01','2013-07-01','1','0102','02','2013-07-01','','','','','','','0102','01','1022000001','01','2017-05-09'),(42,'01020015','蔡铭','1','330123197910220036','1979-10-22','01','100','2011-10-01','香港 香港理工大学','-1','2006-09-01','-1','11','浙江工业大学海洋学院','1','','013','0','01','2012-03-01','1','0102','03','2012-03-01','','','','','','','0102','02','00001','02','2017-05-09'),(43,'01020016','蒋宁','2','410303197702093728','1977-02-16','01','100','2004.06','浙江大学','-1','2004.06','-1','','浙江工业大学','1','','012','0','01','2006.09','1','0103','-1','2004.06','','','','','','','0102','-1','-1','-1',''),(45,'01020017','李海宗','1','110108196310156553','1963-10-3','01','300','1998.02','西北师范大学','-1','1990.07','-1','','浙江工业大学教育科学与技术学院','1','','012','0','-1','2002.05','1','0102','-1','','','','','','','','0102','-1','-1','-1','2017.5.9'),(47,'01020018','王沛','1','370306198104122518','1963-05-12','01','100','2007.09','浙江大学','-1','2007.11','-1','','浙江工业大学理学院','1','','013','0','01','2011.08','1','0102','-1','','','','','','','','0102','-1','-1','-1','2017.5.9'),(48,'01020019','孙建强','1','330106198308155516','1983-08-12','01','100','2012.06','浙江工业大学','-1','2006.07','-1','','浙江工业大学生物与环境工程学院','1','','013','0','-1','2012.09','1','0102','-1','','','','','','','','0102','-1','-1','-1','2017.5.9'),(49,'01020020','陈志卫','1','330722197206166415','1960-07-15','01','100','','浙江工业大学','-1','','-1','','浙江工业大学药学院','1','','-1','0','-1','','-1','0102','-1','','','','','','','','0102','-1','-1','-1',''),(50,'01020021','陈永春','1','33038219820412404','1982-04-09','11','500','2005.06','浙江工业大学','-1','2011.07','-1','','浙江工业大学团委','1','','-1','0','-1','2013.09','-1','0102','-1','','','','','','','','0102','-1','-1','-1','2017.5.9'),(51,'01020022','王宪保','1','210211197710305935','1965-06-30','01','100','','浙江工业大学','-1','','-1','','浙江工业大学信息工程学院','-1','','-1','0','-1','','1','0102','-1','','','','','','','','0102','-1','-1','-1',''),(53,'01020023','渠扬','1','210902198006101011','1950-06-30','01','300','2006.07 ','沈阳体育学院','-1','2006.07','-1','','浙江工业大学体育军训部','1','','013','0','-1','2009.06','1','0102','-1','','','','','','','','0102','-1','-1','-1','2017.5.9'),(54,'01020024','孟祥河','1','230103197401043634','1974-01-04','01','100','2004.06','江南大学','-1','','-1','','浙江工业大学海洋学院','1','','012','0','-1','2006.09','1','0102','-1','','','','','','','','0102','-1','-1','-1','2017.5.9'),(57,'01020025','郑春晔','1','33070219730905121','1973-09-05','01','100','2013-06-15','浙江大学','-1','1995-09-15','-1','','学校办公室','1','','-1','0','-1','','-1','0103','01','2013-05-05','','','','','','','0102','03','-1','01','2017-05-10'),(58,'01020026','刘云峰','1','530102197601183716','1976-01-11','01','100','2004-12-15','浙江大学','-1','2004-10-15','-1','','浙江工业大学机械工程学院','-1','学科秘书','-1','0','-1','','-1','0103','-1','','','','','','','','0102','03','-1','-1','2017-05-10'),(59,'01020027','俞锋','1','330903198111110239','1981-11-11','11','300','2004-07-15','浙江工业大学','-1','2004-03-15','-1','','浙江工业大学法学院','-1','无','-1','1','-1','','-1','0103','03','','','','','','','','0102','03','-1','02','2017-05-10'),(60,'01020028','蒋敏','2','330103197609200727','1976-09-20','01','100','2005-07-15','西安电子科技大学','-1','2005-08-15','-1','','浙江工业大学经贸管理学院','1','','01','0','-1','','-1','0103','-1','','','','','','','','0102','02','-1','-1','2017-05-10'),(61,'01020029','金靖','1','330623198003077776','1980-03-07','11','300','2002-06-15','浙江工业大学','-1','2002-06-15','-1','','浙江工业大学校园建设处','1','工程管理办公室副主任','-1','0','-1','','-1','0103','-1','','','','','','','','0102','03','-1','02','2017-05-10'),(62,'01020030','褚建军','1','332524197504144410','1975-04-14','01','300','2004-06-15','浙江工业大学','-1','','-1','','浙江工业大学成人教育学院','-1','组织员、教工一支部 书记','-1','0','-1','','-1','0103','-1','','','','','','','','0102','03','-1','-1','2017-05-10'),(63,'01020031','陈微微','2','330682198106255221','1981-06-25','01','300','2006-06-15','浙江大学','-1','2006-06-15','-1','','浙江工业大学科学技术研究院','1','','-1','0','-1','','-1','0103','-1','','','','','','','','0102','03','-1','-1','2017-05-10'),(64,'01020032','戚军','2','330205198111302761','1981-11-13','01','100','2009-06-15','浙江大学','-1','2011-03-15','-1','','浙江工业大学信息程院','-1','无','-1','0','-1','','-1','0103','-1','','','','','','','','0102','03','-1','-1','2017-05-10'),(65,'01020033','邵平','1','330825198003253112','1980-03-25','01','100','2007-01-15','合肥工业大学','-1','2007-04-15','-1','','','-1','院长助理','01','0','-1','','-1','0103','-1','','','','','','','','0102','03','-1','-1','2017-05-10'),(66,'01020034','付明磊','1','130203198103060619','1981-03-06','01','100','','浙江工业大学','-1','2010-07-15','-1','','浙江工业大学理学院','1','无','01','0','-1','','-1','0103','-1','','','','','','','','0102','03','-1','-1','2017-05-10'),(67,'01020035','陈伟锋','1','330226198411040013','1984-11-08','01','100','2011-09-01','浙江大学','010102','2011-10-01','010102','7','浙江工业大学信息工程学院','1','无','-1','0','-1','2012-01-01','-1','0103','-1','','','13957196555','','','310004','','0102','03','00006','02','2017-05-15'),(68,'01020036','叶青','1','330622197501210719','1975-01-06','01','100','2009-12-01','浙江大学','020101','2001-07-01','010103','17','浙江工业大学化学工程学院','1','','-1','0','-1','','-1','0102','-1','','','','','','','','0102','02','1022000003','02',''),(69,'01020037','徐骏','2','330103197802241627','1978-02-02','01','300','2006-06-01','浙江大学','010199','2001-07-01','010199','','校机关保卫处','-1','党支部副书记','-1','2','-1','2006-10-01','1','0103','02','','','','','','','','0102','03','-1','01',''),(70,'01020038','胡晓敏','1','420204197905174555','2017-05-16','01','300','2005-06-01','浙江工业大学','010199','2005-09-10','010151','','浙江工业大学之江学院','1','之江学院学生处副处长','013','0','-1','2007-09-10','-1','0103','03','','','','','','','','0102','03','1022000003','02',''),(71,'01020039','李行诺','1','410403198108071016','1981-08-10','01','100','2009-07-10','浙江工业大学','010152','2009-07-10','020101','','','-1','浙江工业大学药学院','-1','0','-1','2009-07-01','-1','0103','02','','','','','','','','0102','03','-1','01',''),(72,'01020040','顾方磊','1','330902198203311410','1982-03-21','11','500','2017-05-08','浙江工业大学','0201','2003-03-01','010152','5','保卫处','-1','无','-1','0','-1','','-1','0103','-1','','','','','','','','0102','01','1022000002','02',''),(73,'01020041','章舜','1','33102219840906001','1984-09-10','11','500','2013-06-01','浙江师范大学','0201','2007-08-01','020102','','艺术学院','1','','-1','0','01','2017-05-01','-1','0103','03','','','','','','','','0102','03','1022000003','02',''),(74,'01020042','蔡伟','1','332528198609180039','1986-09-10','01','300','2011-06-01','浙江工业大学','-1','','010152','4','浙江工业大学','1','研究实习员','-1','0','-1','2011-11-01','1','0103','03','2016-06-15','','','','','','','0102','03','1022000003','02','2017-05-15');
/*!40000 ALTER TABLE `expert_baseinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_dept`
--

DROP TABLE IF EXISTS `group_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_dept` (
  `Group_id` int(11) NOT NULL AUTO_INCREMENT,
  `Group_no` varchar(100) NOT NULL COMMENT '专业组代码',
  `Group_name` varchar(100) NOT NULL COMMENT '专业组名称',
  `Group_jury` varchar(100) NOT NULL COMMENT '所属高评委 外键',
  `Group_date` date NOT NULL COMMENT '建立时间',
  `Group_comm` varchar(80) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`Group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_dept`
--

LOCK TABLES `group_dept` WRITE;
/*!40000 ALTER TABLE `group_dept` DISABLE KEYS */;
INSERT INTO `group_dept` VALUES (1,'00001','化学组','0102','2008-08-08','sdfsdfe'),(6,'00006','物理组','0102','2008-08-08',NULL),(7,'00007','化学组','0101','2007-07-07',NULL),(8,'00008','哲学组','0101','2008-08-08',NULL),(9,'00009','哲学组','0102','2006-06-06',NULL),(10,'00010','物理组','0103','2009-10-10',NULL),(11,'00011','哲学组','0103','2006-01-01',NULL);
/*!40000 ALTER TABLE `group_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_title`
--

DROP TABLE IF EXISTS `history_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history_title` (
  `History_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '历史任职标识',
  `expert_no` char(8) NOT NULL COMMENT '专家编号',
  `expert_name` char(20) NOT NULL COMMENT '专家姓名',
  `expert_jury` char(10) NOT NULL COMMENT '所任高评委',
  `expert_group` char(10) NOT NULL COMMENT '专业组',
  `expert_post` char(6) NOT NULL COMMENT '职务',
  `expert_serveyear` char(10) NOT NULL COMMENT '任职年度',
  PRIMARY KEY (`History_id`),
  UNIQUE KEY `History_id_UNIQUE` (`History_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_title`
--

LOCK TABLES `history_title` WRITE;
/*!40000 ALTER TABLE `history_title` DISABLE KEYS */;
INSERT INTO `history_title` VALUES (8,'01020008','胡宇婷','0102','08009','主任委员','2002'),(16,'01020001','蒋之余','0102','08009','副主任委员','2003'),(98,'01010002','高天宇','0101','00007','组长','2017'),(99,'01010001','陈昊','0101','00007','组员','2017'),(100,'01010002','高天宇','0101','00007','组长','2017'),(101,'01010001','陈昊','0101','00007','组员','2017'),(102,'01010001','陈昊','0101','00007','主任委员','2017'),(103,'01010003','陈天宇','0101','00008','副主任委员','2017'),(104,'01010005','陈昊地','0101','00008','委员','2017'),(105,'01010001','陈昊','0101','00007','主任委员','2017'),(106,'01010004','俞婧瑶','0101','00007','副主任委员','2017'),(107,'01010002','高天宇','0101','00007','委员','2017'),(108,'01020040','顾方磊','0102','1022000002','主任委员','2017'),(109,'01020007','何波','0102','00001','副主任委员','2017'),(110,'01020012','李志中','0102','1022000001','副主任委员','2017'),(111,'01020005','陈威涛','0102','00009','委员','2017'),(112,'01020039','李行诺','0102','-1','委员','2017'),(113,'01020027','俞锋','0102','-1','委员','2017'),(114,'01020042','蔡伟','0102','1022000003','委员','2017'),(115,'01020006','陈杨','0102','00006','委员','2017');
/*!40000 ALTER TABLE `history_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `historytitleview`
--

DROP TABLE IF EXISTS `historytitleview`;
/*!50001 DROP VIEW IF EXISTS `historytitleview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `historytitleview` AS SELECT 
 1 AS `expert_no`,
 1 AS `expert_name`,
 1 AS `expert_jury`,
 1 AS `expert_group`,
 1 AS `expert_post`,
 1 AS `expert_serveyear`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `infolistview`
--

DROP TABLE IF EXISTS `infolistview`;
/*!50001 DROP VIEW IF EXISTS `infolistview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `infolistview` AS SELECT 
 1 AS `Expert_id`,
 1 AS `Expert_Field1`,
 1 AS `Expert_Field2`,
 1 AS `Expert_Field3`,
 1 AS `Expert_Field4`,
 1 AS `Expert_Field5`,
 1 AS `Expert_Field6`,
 1 AS `Expert_Field7`,
 1 AS `Expert_Field8`,
 1 AS `Expert_Field9`,
 1 AS `Expert_Field10`,
 1 AS `Expert_Field11`,
 1 AS `Expert_Field12`,
 1 AS `Expert_Field13`,
 1 AS `Expert_Field14`,
 1 AS `Expert_Field15`,
 1 AS `Expert_Field16`,
 1 AS `Expert_Field17`,
 1 AS `Expert_Field18`,
 1 AS `Expert_Field19`,
 1 AS `Expert_Field20`,
 1 AS `Expert_Field21`,
 1 AS `Expert_Field22`,
 1 AS `Expert_Field23`,
 1 AS `Expert_Field24`,
 1 AS `Expert_Field25`,
 1 AS `Expert_Field26`,
 1 AS `Expert_Field27`,
 1 AS `Expert_Field28`,
 1 AS `Expert_Field29`,
 1 AS `Expert_Field30`,
 1 AS `Expert_Field31`,
 1 AS `Expert_Field32`,
 1 AS `Expert_Field33`,
 1 AS `Expert_Field34`,
 1 AS `Expert_Field35`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `infolistviewinch`
--

DROP TABLE IF EXISTS `infolistviewinch`;
/*!50001 DROP VIEW IF EXISTS `infolistviewinch`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `infolistviewinch` AS SELECT 
 1 AS `专家标识`,
 1 AS `专家编号`,
 1 AS `专家姓名`,
 1 AS `专家性别`,
 1 AS `身份证号`,
 1 AS `出生年月`,
 1 AS `最高学历`,
 1 AS `所获学位`,
 1 AS `毕肄业时间`,
 1 AS `毕肄业学校`,
 1 AS `所学专业`,
 1 AS `参加工作时间`,
 1 AS `现从事专业`,
 1 AS `现从事专业年限`,
 1 AS `工作单位`,
 1 AS `是否本单位`,
 1 AS `行政职务`,
 1 AS `现有任职资格`,
 1 AS `资格级别`,
 1 AS `任职资格所属系列`,
 1 AS `任职资格取得时间`,
 1 AS `聘任情况`,
 1 AS `曾任高评委名称`,
 1 AS `曾属高评委职务`,
 1 AS `任职时间`,
 1 AS `通信地址`,
 1 AS `手机`,
 1 AS `办公室电话`,
 1 AS `住宅电话`,
 1 AS `邮政编码`,
 1 AS `电子邮箱`,
 1 AS `所属任高评委名称`,
 1 AS `拟任高评委职务`,
 1 AS `所属专业组名称`,
 1 AS `拟任专业组职务`,
 1 AS `入库时间`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `jury_dept`
--

DROP TABLE IF EXISTS `jury_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jury_dept` (
  `Jury_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '高评委标识\r',
  `Jury_no` varchar(100) NOT NULL COMMENT '高评委代码 候选键',
  `Jury_name` varchar(100) NOT NULL COMMENT '高评委名称',
  `Jury_type` char(1) NOT NULL COMMENT '类别',
  `Jury_power` char(1) NOT NULL COMMENT '权限',
  `Jury_qualiname` char(100) NOT NULL COMMENT '所评资格名称',
  `Jury_dept` char(50) NOT NULL COMMENT '材料接收单位',
  `Jury_comments` varchar(100) DEFAULT NULL COMMENT '备注',
  `Jury_date` datetime NOT NULL COMMENT '设立时间',
  PRIMARY KEY (`Jury_id`),
  UNIQUE KEY `Jury_name_UNIQUE` (`Jury_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jury_dept`
--

LOCK TABLES `jury_dept` WRITE;
/*!40000 ALTER TABLE `jury_dept` DISABLE KEYS */;
INSERT INTO `jury_dept` VALUES (1,'0101','省高校教师','0','3','教授·副教授·研究员','省教育厅高校科研','普通高校·成人高校','2001-05-09 00:00:00'),(2,'0102','浙江工业大学教师高级职务','0','3','副教授','浙江工业大学人事处',NULL,'2002-05-09 00:00:00'),(3,'0103','浙江大学教师高级职务','1','2','教授','浙江大学人事处','普通高校','2008-08-08 00:00:00');
/*!40000 ALTER TABLE `jury_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jury_idcode`
--

DROP TABLE IF EXISTS `jury_idcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jury_idcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jury_no` varchar(45) DEFAULT NULL,
  `expert_name` varchar(45) DEFAULT NULL,
  `expert_phone` varchar(45) DEFAULT NULL,
  `id_code` int(11) DEFAULT NULL,
  `code_insert_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jury_idcode`
--

LOCK TABLES `jury_idcode` WRITE;
/*!40000 ALTER TABLE `jury_idcode` DISABLE KEYS */;
INSERT INTO `jury_idcode` VALUES (1,'0101','李一','13857898881',9553,'2017-07-08 11:29:53'),(23,'0102','小李','17816873781',8569,'2017-09-17 23:44:52'),(24,'0102','ch','17816879937',1683,'2017-08-28 16:24:22'),(25,'0102','测试0904','17816879937',3094,'2017-09-04 13:36:43');
/*!40000 ALTER TABLE `jury_idcode` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER insert_info
BEFORE INSERT ON jury_idcode
for each row
BEGIN
	set new.id_code=floor(rand()*10000), new.code_insert_time=now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `syscode_stru`
--

DROP TABLE IF EXISTS `syscode_stru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syscode_stru` (
  `Field_id` int(11) NOT NULL,
  `Table_name` varchar(45) DEFAULT NULL,
  `Code_char` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Field_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syscode_stru`
--

LOCK TABLES `syscode_stru` WRITE;
/*!40000 ALTER TABLE `syscode_stru` DISABLE KEYS */;
INSERT INTO `syscode_stru` VALUES (1,'code_counciltitle','2'),(2,'code_degree','3'),(3,'code_education','2'),(4,'code_engage','1'),(5,'code_grouptitle','2'),(6,'code_judge','1'),(7,'code_series','2'),(8,'code_sex','2'),(9,'code_special','10'),(10,'code_title','10'),(11,'code_titlegrade','2');
/*!40000 ALTER TABLE `syscode_stru` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syscode_table`
--

DROP TABLE IF EXISTS `syscode_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syscode_table` (
  `tablename` char(20) CHARACTER SET latin1 NOT NULL COMMENT '表名',
  `tablechname` char(20) NOT NULL COMMENT '中文表名',
  `number` int(11) DEFAULT NULL COMMENT '次序',
  PRIMARY KEY (`tablename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syscode_table`
--

LOCK TABLES `syscode_table` WRITE;
/*!40000 ALTER TABLE `syscode_table` DISABLE KEYS */;
INSERT INTO `syscode_table` VALUES ('code_counciltitle','高评委职务代码表',NULL),('code_degree','学位代码表',NULL),('code_education','学历代码表',NULL),('code_engage','聘任情况代码表',NULL),('code_group','专业组代码表',NULL),('code_grouptitle','专业组职务代码表',NULL),('code_series','系列代码表',NULL),('code_sex','性别代码表',NULL),('code_special','专业代码表',NULL),('code_title','任职资格代码表',NULL),('code_titlegrade','资格级别代码表',NULL);
/*!40000 ALTER TABLE `syscode_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sysdisplay_page`
--

DROP TABLE IF EXISTS `sysdisplay_page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sysdisplay_page` (
  `tablename` char(20) CHARACTER SET latin1 NOT NULL COMMENT '表名',
  `tablechname` char(20) NOT NULL COMMENT '中文表名',
  `displayorder` int(11) NOT NULL COMMENT '显示次序',
  `order` int(11) DEFAULT NULL COMMENT '次序',
  PRIMARY KEY (`tablename`),
  UNIQUE KEY `tablename_UNIQUE` (`tablename`),
  UNIQUE KEY `tablechname_UNIQUE` (`tablechname`),
  UNIQUE KEY `displayorder_UNIQUE` (`displayorder`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sysdisplay_page`
--

LOCK TABLES `sysdisplay_page` WRITE;
/*!40000 ALTER TABLE `sysdisplay_page` DISABLE KEYS */;
INSERT INTO `sysdisplay_page` VALUES ('expert_baseinfo','专家信息表',1,NULL);
/*!40000 ALTER TABLE `sysdisplay_page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systable_stru`
--

DROP TABLE IF EXISTS `systable_stru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systable_stru` (
  `Field_id` int(11) NOT NULL COMMENT '字段标识',
  `Table_name` char(20) NOT NULL COMMENT '表名',
  `Field_name` char(20) NOT NULL COMMENT '字段名',
  `Field_chname` char(20) CHARACTER SET gbk NOT NULL COMMENT '中文字段名',
  `Field_type` char(20) CHARACTER SET latin1 NOT NULL COMMENT '数据类型',
  `Field_width` int(11) NOT NULL COMMENT '字段长度',
  `Field_order` int(11) NOT NULL COMMENT '字段排序',
  `Field_code` char(20) DEFAULT NULL COMMENT '代码表',
  `Field_default` int(11) DEFAULT NULL COMMENT '默认\n1默认\n0非默认',
  `Field_enable` int(11) DEFAULT NULL COMMENT '启用\n1启用\n0不启用',
  `Field_null` char(20) DEFAULT NULL COMMENT '为空\n1允许\n2不允许',
  `Field_remarik` char(20) DEFAULT NULL COMMENT '注释',
  PRIMARY KEY (`Field_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systable_stru`
--

LOCK TABLES `systable_stru` WRITE;
/*!40000 ALTER TABLE `systable_stru` DISABLE KEYS */;
INSERT INTO `systable_stru` VALUES (1,'expert_baseinfo','Expert_Field1','专家编号','text',150,1,NULL,1,1,'required','haha'),(2,'expert_baseinfo','Expert_Field2','专家姓名','text',100,2,NULL,1,1,'required',NULL),(3,'expert_baseinfo','Expert_Field3','性别','select',50,3,'code_sex',1,1,'required',NULL),(4,'expert_baseinfo','Expert_Field4','身份证号','number',200,4,NULL,1,1,'required',NULL),(5,'expert_baseinfo','Expert_Field5','出生年月','date',100,5,NULL,1,1,'required',NULL),(6,'expert_baseinfo','Expert_FIeld6','最高学历','select',200,6,'code_education',0,1,'',NULL),(7,'expert_baseinfo','Expert_Field7','所获学位','select',200,7,'code_degree',0,1,'',NULL),(8,'expert_baseinfo','Expert_Field8','毕肄业时间','date',100,8,NULL,0,NULL,'',NULL),(9,'expert_baseinfo','Expert_Field9','毕肄业学校','text',200,9,NULL,0,NULL,'','标明城市'),(10,'expert_baseinfo','Expert_Field10','所学专业','select',100,10,'code_special',NULL,NULL,'',NULL),(11,'expert_baseinfo','Expert_Field11','参加工作时间','date',100,11,NULL,NULL,NULL,'',NULL),(12,'expert_baseinfo','Expert_Field12','现从事专业','select',100,12,'code_special',NULL,NULL,'',NULL),(13,'expert_baseinfo','Expert_Field13','现从事专业年限','number',50,13,NULL,NULL,NULL,'',NULL),(14,'expert_baseinfo','Expert_Field14','工作单位','text',200,14,NULL,NULL,NULL,'','现工作单位全称'),(15,'expert_baseinfo','Expert_Field15','是否本单位','select',50,15,'code_judge',NULL,NULL,'',NULL),(16,'expert_baseinfo','Expert_Field16','行政职务','text',100,16,NULL,NULL,NULL,'',NULL),(17,'expert_baseinfo','Expert_Field17','现有任职资格','select',100,17,'code_title',NULL,NULL,'',NULL),(18,'expert_baseinfo','Expert_Field18','资格级别','select',100,18,'code_titlegrade',NULL,NULL,'',NULL),(19,'expert_baseinfo','Expert_Field19','任职资格所属系列','select',100,19,'code_series',NULL,NULL,'',NULL),(20,'expert_baseinfo','Expert_Field20','任职资格取得时间','date',100,20,NULL,NULL,NULL,'',NULL),(21,'expert_baseinfo','Expert_Field21','聘任情况','select',50,21,'code_engage',NULL,NULL,'',NULL),(22,'expert_baseinfo','Expert_Field22','曾属高评委名称','dataList',200,22,'jury_dept',NULL,NULL,'',NULL),(23,'expert_baseinfo','Expert_Field23','曾任高评委职务','select',100,23,'code_counciltitle',NULL,NULL,'',NULL),(24,'expert_baseinfo','Expert_Field24','任职时间','date',100,28,NULL,NULL,NULL,'',NULL),(25,'expert_baseinfo','Expert_Field25','通信地址','text',150,31,NULL,NULL,NULL,'','标明城市'),(26,'expert_baseinfo','Expert_Field26','手机','tel',200,33,NULL,NULL,NULL,'',NULL),(27,'expert_baseinfo','Expert_Field27','办公室电话','tel',200,34,NULL,NULL,NULL,'','加上区号'),(28,'expert_baseinfo','Expert_Field28','住宅电话','tel',200,32,NULL,NULL,NULL,'','加上区号'),(29,'expert_baseinfo','Expert_Field29','邮政编码','text',100,29,NULL,NULL,NULL,'',NULL),(30,'expert_baseinfo','Expert_Field30','电子邮箱','email',200,30,NULL,NULL,NULL,'',NULL),(31,'expert_baseinfo','Expert_Field31','所属高评委名称','dataList',200,24,'jury_dept',NULL,NULL,'',NULL),(32,'expert_baseinfo','Expert_Field32','拟任高评委职务','select',100,25,'code_counciltitle',NULL,NULL,'',NULL),(33,'expert_baseinfo','Expert_Field33','所属专业组名称','select',100,26,'group_dept',NULL,NULL,'',NULL),(34,'expert_baseinfo','Expert_Field34','拟任专业组职务','select',50,27,'code_grouptitle',NULL,NULL,'',NULL),(35,'expert_baseinfo','Expert_Field35','入库时间','date',100,35,NULL,NULL,NULL,'',NULL);
/*!40000 ALTER TABLE `systable_stru` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_field`
--

DROP TABLE IF EXISTS `user_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_field` (
  `user_name` varchar(100) NOT NULL,
  `Expert_FIeld1` varchar(45) DEFAULT NULL COMMENT '专家编号',
  `Expert_FIeld2` varchar(45) DEFAULT NULL COMMENT '专家姓名',
  `Expert_FIeld3` varchar(45) DEFAULT NULL COMMENT '性别',
  `Expert_FIeld4` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `Expert_FIeld5` varchar(45) DEFAULT NULL COMMENT '出生年月',
  `Expert_FIeld6` varchar(45) DEFAULT NULL COMMENT '最高学历',
  `Expert_FIeld7` varchar(45) DEFAULT NULL COMMENT '所获学位',
  `Expert_FIeld8` varchar(45) DEFAULT NULL COMMENT '毕肄业时间',
  `Expert_FIeld9` varchar(45) DEFAULT NULL COMMENT '毕肄业学校',
  `Expert_FIeld10` varchar(45) DEFAULT NULL COMMENT '所学专业',
  `Expert_FIeld11` varchar(45) DEFAULT NULL COMMENT '参加工作时间',
  `Expert_FIeld12` varchar(45) DEFAULT NULL COMMENT '现从事专业',
  `Expert_FIeld13` varchar(45) DEFAULT NULL COMMENT '现从事专业年限',
  `Expert_FIeld14` varchar(45) DEFAULT NULL COMMENT '工作单位',
  `Expert_FIeld15` varchar(45) DEFAULT NULL COMMENT '是否本单位',
  `Expert_FIeld16` varchar(45) DEFAULT NULL COMMENT '行政职务',
  `Expert_FIeld17` varchar(45) DEFAULT NULL COMMENT '现有任职资格',
  `Expert_FIeld18` varchar(45) DEFAULT NULL COMMENT '资格级别',
  `Expert_FIeld19` varchar(45) DEFAULT NULL COMMENT '任职资格所属系列',
  `Expert_FIeld20` varchar(45) DEFAULT NULL COMMENT '任职资格取得时间',
  `Expert_FIeld21` varchar(45) DEFAULT NULL COMMENT '聘任情况',
  `Expert_FIeld22` varchar(45) DEFAULT NULL COMMENT '曾属高评委名称',
  `Expert_FIeld23` varchar(45) DEFAULT NULL COMMENT '曾任高评委职务',
  `Expert_FIeld24` varchar(45) DEFAULT NULL COMMENT '所属高评委名称',
  `Expert_FIeld25` varchar(45) DEFAULT NULL COMMENT '拟任高评委职务',
  `Expert_FIeld26` varchar(45) DEFAULT NULL COMMENT '所属专业组名称',
  `Expert_FIeld27` varchar(45) DEFAULT NULL COMMENT '拟任专业组职务',
  `Expert_FIeld28` varchar(45) DEFAULT NULL COMMENT '任职时间',
  `Expert_FIeld29` varchar(45) DEFAULT NULL COMMENT '邮政编码',
  `Expert_FIeld30` varchar(45) DEFAULT NULL COMMENT '电子邮箱',
  `Expert_FIeld31` varchar(45) DEFAULT NULL COMMENT '住宅电话',
  `Expert_FIeld32` varchar(45) DEFAULT NULL COMMENT '通信地址',
  `Expert_FIeld33` varchar(45) DEFAULT NULL COMMENT '手机号码',
  `Expert_FIeld34` varchar(45) DEFAULT NULL COMMENT '办公室电话',
  `Expert_FIeld35` varchar(45) DEFAULT NULL COMMENT '入库时间',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_field`
--

LOCK TABLES `user_field` WRITE;
/*!40000 ALTER TABLE `user_field` DISABLE KEYS */;
INSERT INTO `user_field` VALUES ('a','1','1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'),('admin','1','1','1','0','0','1','0','1','0','0','0','0','0','1','0','0','0','0','0','1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'),('zju','1','1','0','1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','1'),('zjut','1','1','0','0','1','0','0','0','0','0','0','0','0','0','0','0','0','1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'),('zut','1','1','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0');
/*!40000 ALTER TABLE `user_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_login`
--

DROP TABLE IF EXISTS `user_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `user_name` varchar(20) NOT NULL COMMENT '用户名',
  `user_psd` char(100) NOT NULL COMMENT '密码',
  `user_enable` char(20) NOT NULL COMMENT '是否禁用',
  `user_date` date NOT NULL COMMENT '建立时间',
  `user_type` int(11) NOT NULL COMMENT '1高评委账号\n2管理员账号',
  `user_jury` varchar(45) DEFAULT NULL COMMENT '所属高评委 外键',
  `user_dept` varchar(45) NOT NULL COMMENT '联系单位',
  `user_tel` varchar(45) NOT NULL COMMENT '联系电话',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login`
--

LOCK TABLES `user_login` WRITE;
/*!40000 ALTER TABLE `user_login` DISABLE KEYS */;
INSERT INTO `user_login` VALUES (1,'zjut','zjut','0','2008-08-08',1,'0102','浙江工业大学','17816879937'),(2,'zut','zut','1','2017-01-30',1,'0101','杭州市教师协会','17816879938'),(3,'admin','admin','1','2017-02-03',2,NULL,'杭州市教师协会','13857852999'),(4,'zj','zj','1','2015-01-02',2,NULL,'省教育厅','17816879939'),(5,'zat','zat','1','2016-01-01',1,'0103','浙江工商大学','17816873786');
/*!40000 ALTER TABLE `user_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gpwinfomanagementsystem'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `upload_to_jurypsd` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = '+08:00' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `upload_to_jurypsd` ON SCHEDULE EVERY 1 SECOND STARTS '2017-07-07 16:00:00' ON COMPLETION NOT PRESERVE DISABLE DO begin
	update jury_psd set jury_psd = 11;
    
end */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'gpwinfomanagementsystem'
--
/*!50003 DROP FUNCTION IF EXISTS `insertRandomIdcode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `insertRandomIdcode`(no VARCHAR(45), name VARCHAR(45), phone VARCHAR(45)) RETURNS int(11)
BEGIN
	insert into jury_idcode(jury_no, expert_name,expert_phone,id_code,code_insert_time) values (no, name, phone, floor(rand()*10000), now());
    RETURN(select id_code from jury_idcode where jury_no=no and expert_name=name and expert_phone=phone);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `randomIdcode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `randomIdcode`(no VARCHAR(45), name VARCHAR(45), phone VARCHAR(45)) RETURNS int(11)
BEGIN
	update jury_idcode set id_code=floor(rand()*10000), code_insert_time=now() where jury_no=no and expert_name=name and expert_phone=phone;
    RETURN(select id_code from jury_idcode where jury_no=no and expert_name=name and expert_phone=phone);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `updateRandomIdcode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `updateRandomIdcode`(no VARCHAR(45), name VARCHAR(45), phone VARCHAR(45)) RETURNS int(11)
BEGIN
	update jury_idcode set id_code=floor(rand()*10000), code_insert_time=now() where jury_no=no and expert_name=name and expert_phone=phone;
    RETURN(select id_code from jury_idcode where jury_no=no and expert_name=name and expert_phone=phone);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `historytitleview`
--

/*!50001 DROP VIEW IF EXISTS `historytitleview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `historytitleview` AS select distinct `history_title`.`expert_no` AS `expert_no`,`history_title`.`expert_name` AS `expert_name`,`jury_dept`.`Jury_name` AS `expert_jury`,`group_dept`.`Group_name` AS `expert_group`,`history_title`.`expert_post` AS `expert_post`,`history_title`.`expert_serveyear` AS `expert_serveyear` from ((`history_title` left join `jury_dept` on((`history_title`.`expert_jury` = `jury_dept`.`Jury_no`))) left join `group_dept` on((`history_title`.`expert_group` = `group_dept`.`Group_no`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `infolistview`
--

/*!50001 DROP VIEW IF EXISTS `infolistview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `infolistview` AS select distinct `expert_baseinfo`.`Expert_id` AS `Expert_id`,`expert_baseinfo`.`Expert_Field1` AS `Expert_Field1`,`expert_baseinfo`.`Expert_Field2` AS `Expert_Field2`,`code_sex`.`sex` AS `Expert_Field3`,`expert_baseinfo`.`Expert_Field4` AS `Expert_Field4`,`expert_baseinfo`.`Expert_Field5` AS `Expert_Field5`,`code_education`.`education` AS `Expert_Field6`,`code_degree`.`degree` AS `Expert_Field7`,`expert_baseinfo`.`Expert_Field8` AS `Expert_Field8`,`expert_baseinfo`.`Expert_Field9` AS `Expert_Field9`,`cs1`.`specialname` AS `Expert_Field10`,`expert_baseinfo`.`Expert_Field11` AS `Expert_Field11`,`cs2`.`specialname` AS `Expert_Field12`,`expert_baseinfo`.`Expert_Field13` AS `Expert_Field13`,`expert_baseinfo`.`Expert_Field14` AS `Expert_Field14`,`code_judge`.`judge` AS `Expert_Field15`,`expert_baseinfo`.`Expert_Field16` AS `Expert_Field16`,`code_title`.`titlename` AS `Expert_Field17`,`code_titlegrade`.`titlegrade` AS `Expert_Field18`,`code_series`.`series` AS `Expert_Field19`,`expert_baseinfo`.`Expert_Field20` AS `Expert_Field20`,`code_engage`.`employ` AS `Expert_Field21`,`jd1`.`Jury_name` AS `Expert_Field22`,`cc1`.`name` AS `Expert_Field23`,`expert_baseinfo`.`Expert_Field24` AS `Expert_Field24`,`expert_baseinfo`.`Expert_Field25` AS `Expert_Field25`,`expert_baseinfo`.`Expert_Field26` AS `Expert_Field26`,`expert_baseinfo`.`Expert_Field27` AS `Expert_Field27`,`expert_baseinfo`.`Expert_Field28` AS `Expert_Field28`,`expert_baseinfo`.`Expert_Field29` AS `Expert_Field29`,`expert_baseinfo`.`Expert_Field30` AS `Expert_Field30`,`jd2`.`Jury_name` AS `Expert_Field31`,`cc2`.`name` AS `Expert_Field32`,`group_dept`.`Group_name` AS `Expert_Field33`,`code_grouptitle`.`post` AS `Expert_Field34`,`expert_baseinfo`.`Expert_Field35` AS `Expert_Field35` from ((((((((((((((((`expert_baseinfo` left join `code_sex` on((`expert_baseinfo`.`Expert_Field3` = convert(`code_sex`.`code` using utf8)))) left join `code_education` on((`expert_baseinfo`.`Expert_Field6` = convert(`code_education`.`code` using utf8)))) left join `code_degree` on((`expert_baseinfo`.`Expert_Field7` = convert(`code_degree`.`code` using utf8)))) left join `code_special` `cs1` on((`expert_baseinfo`.`Expert_Field10` = convert(`cs1`.`code` using utf8)))) left join `code_special` `cs2` on((`expert_baseinfo`.`Expert_Field12` = convert(`cs2`.`code` using utf8)))) left join `code_judge` on((`expert_baseinfo`.`Expert_Field15` = convert(`code_judge`.`code` using utf8)))) left join `code_title` on((`expert_baseinfo`.`Expert_Field17` = convert(`code_title`.`code` using utf8)))) left join `code_titlegrade` on((convert(`expert_baseinfo`.`Expert_Field18` using utf8) = `code_titlegrade`.`code`))) left join `code_series` on((convert(`expert_baseinfo`.`Expert_Field19` using utf8) = `code_series`.`code`))) left join `code_engage` on((`expert_baseinfo`.`Expert_Field21` = convert(`code_engage`.`code` using utf8)))) left join `jury_dept` `jd1` on((`expert_baseinfo`.`Expert_Field22` = `jd1`.`Jury_no`))) left join `code_counciltitle` `cc1` on((`expert_baseinfo`.`Expert_Field23` = convert(`cc1`.`code` using utf8)))) left join `jury_dept` `jd2` on((`expert_baseinfo`.`Expert_Field31` = convert(`jd2`.`Jury_no` using utf8)))) left join `code_counciltitle` `cc2` on((`expert_baseinfo`.`Expert_Field32` = convert(`cc2`.`code` using utf8)))) left join `group_dept` on((`expert_baseinfo`.`Expert_Field33` = convert(`group_dept`.`Group_no` using utf8)))) left join `code_grouptitle` on((`expert_baseinfo`.`Expert_Field34` = convert(`code_grouptitle`.`code` using utf8)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `infolistviewinch`
--

/*!50001 DROP VIEW IF EXISTS `infolistviewinch`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `infolistviewinch` AS select distinct `expert_baseinfo`.`Expert_id` AS `专家标识`,`expert_baseinfo`.`Expert_Field1` AS `专家编号`,`expert_baseinfo`.`Expert_Field2` AS `专家姓名`,`code_sex`.`sex` AS `专家性别`,`expert_baseinfo`.`Expert_Field4` AS `身份证号`,`expert_baseinfo`.`Expert_Field5` AS `出生年月`,`code_education`.`education` AS `最高学历`,`code_degree`.`degree` AS `所获学位`,`expert_baseinfo`.`Expert_Field8` AS `毕肄业时间`,`expert_baseinfo`.`Expert_Field9` AS `毕肄业学校`,`cs1`.`specialname` AS `所学专业`,`expert_baseinfo`.`Expert_Field11` AS `参加工作时间`,`cs2`.`specialname` AS `现从事专业`,`expert_baseinfo`.`Expert_Field13` AS `现从事专业年限`,`expert_baseinfo`.`Expert_Field14` AS `工作单位`,`code_judge`.`judge` AS `是否本单位`,`expert_baseinfo`.`Expert_Field16` AS `行政职务`,`code_title`.`titlename` AS `现有任职资格`,`code_titlegrade`.`titlegrade` AS `资格级别`,`code_series`.`series` AS `任职资格所属系列`,`expert_baseinfo`.`Expert_Field20` AS `任职资格取得时间`,`code_engage`.`employ` AS `聘任情况`,`jd1`.`Jury_name` AS `曾任高评委名称`,`cc1`.`name` AS `曾属高评委职务`,`expert_baseinfo`.`Expert_Field24` AS `任职时间`,`expert_baseinfo`.`Expert_Field25` AS `通信地址`,`expert_baseinfo`.`Expert_Field26` AS `手机`,`expert_baseinfo`.`Expert_Field27` AS `办公室电话`,`expert_baseinfo`.`Expert_Field28` AS `住宅电话`,`expert_baseinfo`.`Expert_Field29` AS `邮政编码`,`expert_baseinfo`.`Expert_Field30` AS `电子邮箱`,`jd2`.`Jury_name` AS `所属任高评委名称`,`cc2`.`name` AS `拟任高评委职务`,`group_dept`.`Group_name` AS `所属专业组名称`,`code_grouptitle`.`post` AS `拟任专业组职务`,`expert_baseinfo`.`Expert_Field35` AS `入库时间` from ((((((((((((((((`expert_baseinfo` left join `code_sex` on((`expert_baseinfo`.`Expert_Field3` = convert(`code_sex`.`code` using utf8)))) left join `code_education` on((`expert_baseinfo`.`Expert_Field6` = convert(`code_education`.`code` using utf8)))) left join `code_degree` on((`expert_baseinfo`.`Expert_Field7` = convert(`code_degree`.`code` using utf8)))) left join `code_special` `cs1` on((`expert_baseinfo`.`Expert_Field10` = convert(`cs1`.`code` using utf8)))) left join `code_special` `cs2` on((`expert_baseinfo`.`Expert_Field12` = convert(`cs2`.`code` using utf8)))) left join `code_judge` on((`expert_baseinfo`.`Expert_Field15` = convert(`code_judge`.`code` using utf8)))) left join `code_title` on((`expert_baseinfo`.`Expert_Field17` = convert(`code_title`.`code` using utf8)))) left join `code_titlegrade` on((convert(`expert_baseinfo`.`Expert_Field18` using utf8) = `code_titlegrade`.`code`))) left join `code_series` on((convert(`expert_baseinfo`.`Expert_Field19` using utf8) = `code_series`.`code`))) left join `code_engage` on((`expert_baseinfo`.`Expert_Field21` = convert(`code_engage`.`code` using utf8)))) left join `jury_dept` `jd1` on((`expert_baseinfo`.`Expert_Field22` = `jd1`.`Jury_no`))) left join `code_counciltitle` `cc1` on((`expert_baseinfo`.`Expert_Field23` = convert(`cc1`.`code` using utf8)))) left join `jury_dept` `jd2` on((`expert_baseinfo`.`Expert_Field31` = convert(`jd2`.`Jury_no` using utf8)))) left join `code_counciltitle` `cc2` on((`expert_baseinfo`.`Expert_Field32` = convert(`cc2`.`code` using utf8)))) left join `group_dept` on((`expert_baseinfo`.`Expert_Field33` = convert(`group_dept`.`Group_no` using utf8)))) left join `code_grouptitle` on((`expert_baseinfo`.`Expert_Field34` = convert(`code_grouptitle`.`code` using utf8)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-28 17:00:15
