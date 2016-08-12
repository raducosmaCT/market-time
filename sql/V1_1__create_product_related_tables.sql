--
-- Structure for `product` table.
--
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT, 
	`name` VARCHAR(30) NOT NULL,
	`description` VARCHAR(1000) NOT NULL,
	`shipping` VARCHAR(10) NOT NULL,
	`shipping_time` VARCHAR(5) DEFAULT NULL, 
	`color` VARCHAR(20) DEFAULT NULL,
	`size` VARCHAR(10) DEFAULT NULL,
	`inventory` INT(11) NOT NULL,
	`price` INT(11) NOT NULL,
	`brand` VARCHAR(30) DEFAULT NULL,
	`presentation_page_url` VARCHAR(50) DEFAULT NULL,
	`upc` VARCHAR(12) DEFAULT NULL,
	`user_id` BIGINT(20) NOT NULL,
	PRIMARY KEY (`id`),
	KEY `product_user_id_idx` (`user_id`),
  	CONSTRAINT `product_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure for `product_tag` table.
--
DROP TABLE IF EXISTS `product_tag`;
CREATE TABLE IF NOT EXISTS `product_tag` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  	`name` VARCHAR(20) NOT NULL,
  	`product_id` BIGINT(20) NOT NULL,
  	PRIMARY KEY (`id`),
	KEY `product_tag_product_id_idx` (`product_id`),
  	CONSTRAINT `product_tag_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure for `product_image` table.
--
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE IF NOT EXISTS `product_image` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(30) NOT NULL,
  	`url` VARCHAR(50) NOT NULL,
  	`product_id` BIGINT(20) NOT NULL,
  	PRIMARY KEY (`id`),
	KEY `product_image_product_id_idx` (`product_id`),
  	CONSTRAINT `product_image_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;