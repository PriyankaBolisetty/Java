CREATE SCHEMA `ordersdb`;

-- Creating User to accsess ordersdb database
CREATE USER 'orderDbUser'@'localhost' IDENTIFIED BY 'orderDbPswd';

GRANT ALL PRIVILEGES ON ordersdb.* TO 'orderDbUser'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'orderDbUser'@'localhost';


-- Creating required tables
CREATE TABLE `Customer` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `phoneno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Order` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Order_Customerid_idx` (`customer_id`),
  CONSTRAINT `FK_Order_Customerid` FOREIGN KEY (`customer_id`) REFERENCES `Customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Product` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `OrderItem` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  KEY `FK_OrderItem_ProductId_idx` (`product_id`),
  KEY `FK_OrderItem_OrderId_idx` (`order_id`),
  CONSTRAINT `FK_OrderItem_OrderId` FOREIGN KEY (`order_id`) REFERENCES `Order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_OrderItem_ProductId` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
