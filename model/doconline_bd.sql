SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `doconline` ;
CREATE SCHEMA IF NOT EXISTS `doconline` DEFAULT CHARACTER SET utf8;
USE `doconline` ;


-- -----------------------------------------------------
-- Table `doconline`.`empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doconline`.`empresa` ;

CREATE TABLE IF NOT EXISTS `doconline`.`empresa` (
  `cuit` INT NOT NULL,
  `razon_social` VARCHAR(45) NOT NULL,
  `inicio_actividades` DATE NOT NULL,
  `jefe` VARCHAR(45) NOT NULL,
  `noticia` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`cuit`),
  UNIQUE INDEX `cuit_UNIQUE` (`cuit` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doconline`.`empleado` ;

CREATE TABLE IF NOT EXISTS `doconline`.`empleado` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `empresa_cuit` INT NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC),
  INDEX `fk_empleado_empresa_idx` (`empresa_cuit` ASC),
  CONSTRAINT `fk_empleado_empresa`
    FOREIGN KEY (`empresa_cuit`)
    REFERENCES `doconline`.`empresa` (`cuit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `doconline` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=1;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
