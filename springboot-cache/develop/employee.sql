drop table employee;
CREATE TABLE `employee` (
  `id` int(11) AUTO_INCREMENT,
  `lastName` varchar(40),
  `email` varchar(20),
  `gender` varchar(20),
  `d_id` int(2) ,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

