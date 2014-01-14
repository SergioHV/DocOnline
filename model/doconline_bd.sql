SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `doconline` ;
CREATE SCHEMA IF NOT EXISTS `doconline` DEFAULT CHARACTER SET utf8 ;
USE `isftwebappfinal` ;

-- -----------------------------------------------------
-- Table `doconline`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doconline`.`empleado` ;

CREATE  TABLE IF NOT EXISTS `doconline`.`empleado` (
  `Nombre` VARCHAR(45) NULL DEFAULT NULL ,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL ,
  `Dni` VARCHAR(45) NULL DEFAULT NULL ,
  `Email` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`dni`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;