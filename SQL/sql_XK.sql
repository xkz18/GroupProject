
-- DROP table `groupproject`.`project`;
-- DROP table `groupproject`.`resource`;
-- DROP table `groupproject`.`project_columns`;
-- DROP table `groupproject`.`resource_details`;


SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema groupproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema groupproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `groupproject` DEFAULT CHARACTER SET utf8 ;
USE `groupproject` ;

-- -----------------------------------------------------
-- Table `groupproject`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `groupproject`.`users` (
 `id` int NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `date_created` DATE NULL,
  `last_updated` DATE NULL,
  `title` VARCHAR(20) NULL,
  `role` VARCHAR(20) NULL,
  `image` VARCHAR(128) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groupproject`.`Project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `groupproject`.`project` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL,
  `date_created` DATE NULL,
  PRIMARY KEY (`project_id`),
  INDEX `user_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `groupproject`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groupproject`.`Project_Columns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `groupproject`.`project_columns` (
  `column_id` INT NOT NULL AUTO_INCREMENT,
  `project_id` INT NOT NULL,
  `column_name` VARCHAR(16) NOT NULL,
  `type` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`column_id`),
  INDEX `project_id_fk_idx` (`project_id` ASC) VISIBLE,
  CONSTRAINT `project_id_fk`
    FOREIGN KEY (`project_id`)
    REFERENCES `groupproject`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groupproject`.`Resource`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `groupproject`.`resource` (
  `resource_id` int NOT NULL AUTO_INCREMENT,
  `date_created` DATE NULL,
  PRIMARY KEY (`resource_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groupproject`.`Project_Resources`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `groupproject`.`project_resources` (
  `record_id` INT NOT NULL AUTO_INCREMENT,
  `project_id` INT NOT NULL,
  `resource_id` INT NOT NULL,
  `time_created` DATE NULL,
  PRIMARY KEY (`record_id`),
  INDEX `ProjectID_idx` (`project_id` ASC) VISIBLE,
  INDEX `ResourceID_idx` (`resource_id` ASC) VISIBLE,
  CONSTRAINT `ProjectID_fk_2`
    FOREIGN KEY (`project_id`)
    REFERENCES `groupproject`.`project` (`project_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ResourceID`
    FOREIGN KEY (`resource_id`)
    REFERENCES `groupproject`.`resource` (`resource_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `groupproject`.`Resource_Details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `groupproject`.`resource_details` (
  `detail_id` INT NOT NULL AUTO_INCREMENT,
  `date_created` DATE NULL,
  `detail_value` VARCHAR(20) NULL,
  `column_id` INT NOT NULL,
  `resource_id` INT NULL,
  
  PRIMARY KEY (`detail_id`),
  INDEX `resource_fk_idx` (`resource_id` ASC) VISIBLE,
  INDEX `column_fk_idx` (`column_id` ASC) VISIBLE,
  CONSTRAINT `resource_fk`
    FOREIGN KEY (`resource_id`)
    REFERENCES `groupproject`.`resource` (`resource_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `column_fk`
    FOREIGN KEY (`column_id`)
    REFERENCES `groupproject`.`project_columns` (`column_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;










