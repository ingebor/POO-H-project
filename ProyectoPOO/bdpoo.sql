-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.21-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para bdpoo
CREATE DATABASE IF NOT EXISTS `bdpoo` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdpoo`;

-- Volcando estructura para tabla bdpoo.enfermedades
CREATE TABLE IF NOT EXISTS `enfermedades` (
  `Nombre` varchar(50) NOT NULL,
  `DolorCabeza` varchar(50) DEFAULT NULL,
  `DolorEstomago` varchar(50) DEFAULT NULL,
  `Vomito` varchar(50) DEFAULT NULL,
  `Diarrea` varchar(50) DEFAULT NULL,
  `Estornudo` varchar(50) DEFAULT NULL,
  `Tos` varchar(50) DEFAULT NULL,
  `DolorGeneral` varchar(50) DEFAULT NULL,
  `FaltaEnergia` varchar(50) DEFAULT NULL,
  `NotasAdicionales` mediumtext,
  `Medicina` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla bdpoo.medicinas
CREATE TABLE IF NOT EXISTS `medicinas` (
  `Nombre` varchar(50) NOT NULL,
  `Precio` double DEFAULT NULL,
  `Ingestion` varchar(50) DEFAULT NULL,
  `Tipo` varchar(50) DEFAULT NULL,
  `Dosis` varchar(50) DEFAULT NULL,
  `NotasAdicionales` mediumtext,
  `Enfermedad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla bdpoo.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `NombreUsuario` varchar(50) NOT NULL,
  `Contrasenia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`NombreUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
