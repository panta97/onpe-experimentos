-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbonpe
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbonpe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbonpe` DEFAULT CHARACTER SET utf8 ;
USE `dbonpe` ;

-- -----------------------------------------------------
-- Table `dbonpe`.`partidopolitico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbonpe`.`partidopolitico` (
  `id_partidopolitico` INT NOT NULL AUTO_INCREMENT,
  `nombre_partidopolitico` VARCHAR(45) NOT NULL,
  `estado_partidopolitico` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_partidopolitico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbonpe`.`distrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbonpe`.`distrito` (
  `id_distrito` INT NOT NULL AUTO_INCREMENT,
  `nombre_distrito` VARCHAR(45) NOT NULL,
  `estado_distrito` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_distrito`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbonpe`.`candidato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbonpe`.`candidato` (
  `id_candidato` INT NOT NULL AUTO_INCREMENT,
  `id_partidopolitico` INT NOT NULL,
  `id_distrito` INT NOT NULL,
  `nombre_candidato` VARCHAR(45) NOT NULL,
  `apellido_candidato` VARCHAR(45) NOT NULL,
  `estado_candidato` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_candidato`),
  INDEX `fk_Candidato_PartidoPolitico_idx` (`id_partidopolitico` ASC),
  INDEX `fk_Candidato_Distrito1_idx` (`id_distrito` ASC),
  CONSTRAINT `fk_Candidato_PartidoPolitico`
    FOREIGN KEY (`id_partidopolitico`)
    REFERENCES `dbonpe`.`partidopolitico` (`id_partidopolitico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Candidato_Distrito1`
    FOREIGN KEY (`id_distrito`)
    REFERENCES `dbonpe`.`distrito` (`id_distrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbonpe`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbonpe`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(45) NOT NULL,
  `apellido_usuario` VARCHAR(45) NOT NULL,
  `codigo_usuario` VARCHAR(45) NOT NULL,
  `password_usuario` VARCHAR(200) NOT NULL,
  `rol_usuario` VARCHAR(45) NOT NULL,
  `estado_usuario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
