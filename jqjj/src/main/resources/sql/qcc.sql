/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.27 : Database - qcc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qcc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `qcc`;

/*Table structure for table `enicinfo` */

DROP TABLE IF EXISTS `enicinfo`;

CREATE TABLE `enicinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyno` varchar(50) DEFAULT NULL COMMENT '内部KeyNo',
  `name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `no` varchar(50) DEFAULT NULL COMMENT '注册号',
  `belongorg` varchar(50) DEFAULT NULL COMMENT '登记机关',
  `opername` varchar(50) DEFAULT NULL COMMENT '法人名',
  `startdate` datetime DEFAULT NULL COMMENT '成立日期',
  `enddate` date DEFAULT NULL COMMENT '吊销日期',
  `status` varchar(50) DEFAULT NULL COMMENT '企业状态',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `updateddate` datetime DEFAULT NULL COMMENT '更新日期',
  `creditcode` varchar(30) DEFAULT NULL COMMENT '社会统一信用代码',
  `registcapi` varchar(30) DEFAULT NULL COMMENT '注册资本',
  `econkind` varchar(50) DEFAULT NULL COMMENT '企业类型',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `scope` varchar(1000) DEFAULT NULL COMMENT '经营范围',
  `termstart` datetime DEFAULT NULL COMMENT '营业开始日期',
  `teamend` datetime DEFAULT NULL COMMENT '营业结束日期',
  `checkdate` datetime DEFAULT NULL COMMENT '发照日期',
  `orgno` varchar(30) DEFAULT NULL COMMENT '组织机构代码',
  `isonstock` int(11) DEFAULT NULL COMMENT '是否上市',
  `stocknumber` varchar(30) DEFAULT NULL COMMENT '上市公司代码',
  `stocktype` varchar(20) DEFAULT NULL COMMENT '上市类型',
  `other` longtext COMMENT '其他信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `no` (`no`),
  UNIQUE KEY `creditcode` (`creditcode`)
) ENGINE=InnoDB AUTO_INCREMENT=15000021 DEFAULT CHARSET=utf8;

/* Procedure structure for procedure `t1` */

/*!50003 DROP PROCEDURE IF EXISTS  `t1` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `t1`()
begin
declare i int default 0;
while(i<15000000) do
insert into ENICINFO values(null,'345'+i,'dwh'+i,'567'+i,"朝阳区","无",now(),now(),'wu',
		'北京市',now(),'345366'+i,'wu','wu','wu','wu',now(),now(),now(),
		'wu',0,'wu','wu','{"ChangeRecords":[{"ProjectName":"投资人(股权)变更","BeforeContent":"","ChangeDate":"2003-05-28T00:00:00+08:00","AfterContent":"股东名称：胡喜玲出资额：20万元；,股东名称：逯云飞出资额：20万元；"},{"ProjectName":"经营期限(营业期限)变更","BeforeContent":"2003-05-28","ChangeDate":"2003-05-28T00:00:00+08:00","AfterContent":"2003-05-27"},{"ProjectName":"董事备案","BeforeContent":"胡喜玲,董事长","ChangeDate":"2003-05-28T00:00:00+08:00","AfterContent":"胡喜玲,执行董事,经理；逯云飞,监事"},{"ProjectName":"名称变更","BeforeContent":"公主岭市客运交电有限责任公司","ChangeDate":"2003-05-28T00:00:00+08:00","AfterContent":"有限公司"},{"ProjectName":"经营范围变更","BeforeContent":"家用电器","ChangeDate":"2003-05-28T00:00:00+08:00","AfterContent":"家用电器、摩托车、自行车零售***"}],"Employees":[{"Name":"胡喜玲","Job":"执行董事，总经理"},{"Name":"逯云飞","Job":"监事"}],"OriginalName":[{"Name":"公主岭市客运交电有限责任公司","ChangeDate":"2003-05-28T00:00:00"}],"Partners":[{"RealCapi":"20 万元","StockName":"胡喜玲","ShouldCapi":"20 万元","StockPercent":"50.0%","StockType":"自然人股东"},{"RealCapi":"20 万元","StockName":"逯云飞","ShouldCapi":"20 万元","StockPercent":"50.0%","StockType":"自然人股东"}],"Branches":[],"ContactInfo":{}}');
set i=i+1;
if mod(i,1000)=0 then commit;
end if;
end while;
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
