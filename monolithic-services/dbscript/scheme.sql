SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';



CREATE SCHEMA IF NOT EXISTS `truyum_v2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

USE `truyum_v2` ;



-- -----------------------------------------------------

-- Table `truyum_v2`.`user`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `truyum_v2`.`user` (

  `us_id` INT NOT NULL ,

  `us_name` VARCHAR(60) NOT NULL ,

  `us_pass` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`us_id`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `truyum_v2`.`role`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `truyum_v2`.`role` (

  `ro_id` INT NOT NULL ,

  `ro_name` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`ro_id`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `truyum_v2`.`user_role`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `truyum_v2`.`user_role` (

  `ur_id` INT NOT NULL ,

  `ur_us_id` INT NOT NULL ,

  `ur_ro_id` INT NOT NULL ,

  PRIMARY KEY (`ur_id`) ,

  INDEX `fk_user_role_user1` (`ur_us_id` ASC) ,

  INDEX `fk_user_role_role1` (`ur_ro_id` ASC) ,

  CONSTRAINT `fk_user_role_user1`

    FOREIGN KEY (`ur_us_id` )

    REFERENCES `truyum_v2`.`user` (`us_id` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_user_role_role1`

    FOREIGN KEY (`ur_ro_id` )

    REFERENCES `truyum_v2`.`role` (`ro_id` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `truyum_v2`.`menu_item`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `truyum_v2`.`menu_item` (

  `me_id` INT NOT NULL ,

  `me_name` VARCHAR(100) NOT NULL ,

  `me_price` FLOAT NOT NULL ,

  `me_active` TINYINT(1) NOT NULL ,

  `me_date_of_launch` DATE NOT NULL ,

  `me_category` VARCHAR(45) NOT NULL ,

  `me_free_delivery` TINYINT(1) NOT NULL ,

  `me_url` VARCHAR(200) NOT NULL ,

  PRIMARY KEY (`me_id`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `truyum_v2`.`cart`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `truyum_v2`.`cart` (

  `ct_id` INT NOT NULL ,

  `ct_us_id` INT NOT NULL ,

  `ct_pr_id` INT NOT NULL ,

  PRIMARY KEY (`ct_id`) ,

  INDEX `fk_cart_user` (`ct_us_id` ASC) ,

  INDEX `fk_cart_menu_item1` (`ct_pr_id` ASC) ,

  CONSTRAINT `fk_cart_user`

    FOREIGN KEY (`ct_us_id` )

    REFERENCES `truyum_v2`.`user` (`us_id` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_cart_menu_item1`

    FOREIGN KEY (`ct_pr_id` )

    REFERENCES `truyum_v2`.`menu_item` (`me_id` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;







SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


START TRANSACTION;
USE `truyum_v2`;




INSERT INTO truyum_v2.menu_item (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (1,'Sandwich',99.00,1,'2017/03/15','Main Course',1,'https://images.unsplash.com/photo-1528735602780-2552fd46c7af');

INSERT INTO truyum_v2.menu_item (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (2,'Burger',129.00,1,'2017/12/23','Main Course',0,'https://images.unsplash.com/photo-1547584370-2cc98b8b8dc8');

INSERT INTO truyum_v2.menu_item (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (3,'Pizza',149.00,1,'2017/08/21','Main Course',0,'https://images.unsplash.com/photo-1513104890138-7c749659a591');

INSERT INTO truyum_v2.menu_item (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (4,'French Fries',57.00,0,'2017/07/02','Starters',1,'https://images.unsplash.com/photo-1480076732613-644bee94d3c9');

INSERT INTO truyum_v2.menu_item (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (5,'Chocolate Brownie',32.00,1,'2022/11/02','Dessert',1,'https://images.unsplash.com/photo-1564355768016-1c9f9dc1b381');


INSERT INTO `truyum_v2`.`role` (`ro_id`, `ro_name`) VALUES (1, 'USER');

INSERT INTO `truyum_v2`.`role` (`ro_id`, `ro_name`) VALUES (2, 'ADMIN');


INSERT INTO `truyum_v2`.`user` (`us_id`, `us_name`, `us_password`) VALUES (1, 'user', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');

INSERT INTO `truyum_v2`.`user` (`us_id`, `us_name`, `us_password`) VALUES (2, 'admin', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');


INSERT INTO `truyum_v2`.`user_role` (`ur_id`, `ur_us_id`, `ur_ro_id`) VALUES (1, 1, 1);

INSERT INTO `truyum_v2`.`user_role` (`ur_id`, `ur_us_id`, `ur_ro_id`) VALUES (2, 2, 2);


INSERT INTO `truyum_v2`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES (1, 1, 1);

COMMIT;
