-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2022 a las 03:46:05
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pokemon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenadores`
--

CREATE TABLE `entrenadores` (
  `idEntrenador` int(3) NOT NULL,
  `nombreEntrenador` varchar(30) NOT NULL,
  `dinero` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `entrenadores`
--

INSERT INTO `entrenadores` (`idEntrenador`, `nombreEntrenador`, `dinero`) VALUES
(1, 'Poseidon', 50),
(2, 'Malenia', 20),
(3, 'Miquella', 40),
(4, 'Ranni', 10),
(5, 'Marika', 50),
(6, 'Radagon', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `idMovimiento` int(3) NOT NULL,
  `nombreHabilidad` varchar(30) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `parametroEspecifico` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `movimientos`
--

INSERT INTO `movimientos` (`idMovimiento`, `nombreHabilidad`, `tipo`, `parametroEspecifico`) VALUES
(1, 'Filo ardiente', '2', '40'),
(2, 'Filo espiritual', '3', '40'),
(3, 'Colmillo de la victoria', '8', '60'),
(4, 'Flor de hielo', '3', '30'),
(5, 'Senda de escarcha', '3', '80'),
(6, 'Marobashi', '4', '40'),
(7, 'Jardin acueo', '4', '60'),
(8, 'Presagio maligno', '6', '30'),
(9, 'Verdad onirica', '6', '80'),
(10, 'Quebrantatormentas', '6', '80'),
(11, 'Fulgor de nobleza', '0', '40'),
(12, 'Devastaestrellas', '8', '40'),
(13, 'Ciclon de viento', '5', '30'),
(14, 'Azote del mal', '5', '60'),
(15, 'Espiritu exorcizador', '3', '20'),
(16, 'Colmillo relampago', '6', '20'),
(17, 'Pyronado', '2', '80'),
(18, 'Marea tectonica', '8', '30'),
(19, 'Olas furiosas', '4', '20'),
(20, 'Obliteracion', '4', '80'),
(21, 'Ascenso Draco', '5', '80'),
(22, 'Viento afilado', '5', '50'),
(23, 'Hiperrayo', '0', '120'),
(24, 'Ventisca boreal', '3', '70'),
(25, 'Tormenta inferno', '2', '70'),
(26, 'Zarpa sedosa', '7', '60'),
(27, 'Tierra sismica', '8', '80'),
(28, 'Lluevehojas', '1', '90'),
(29, 'Tsunami subacuatico', '4', '100'),
(30, 'Onda venenosa', '7', '50'),
(31, 'Remolino azotador', '5', '0'),
(32, 'Riada torrencial', '4', '1'),
(33, 'Onda Trueno', '6', '2'),
(34, 'Frio glaciar', '3', '3'),
(35, 'Tornado arrasador', '5', '0'),
(36, 'Bostezo somnoliento', '0', '2'),
(37, 'Vacio onirico', '0', '3'),
(38, 'Arena rocosa', '8', '3'),
(39, 'Helada glacial', '3', '2'),
(40, 'Invierno antartico', '3', '3'),
(41, 'Fuego fatuo', '2', '0'),
(42, 'Llamas abrasadoras', '2', '0'),
(43, 'Electrocarga', '6', '0'),
(44, 'Voltaje extremo', '6', '0'),
(45, 'Toxicarga', '7', '0'),
(46, 'Concentracion foco', '0', '2'),
(47, 'Danza espada', '0', '3'),
(48, 'Control escarcha', '3', '2'),
(49, 'Brisa plena', '5', '3'),
(50, 'Nitrocarga radiante', '2', '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokedex`
--

CREATE TABLE `pokedex` (
  `idEspecie` int(3) NOT NULL,
  `nombreEspecie` varchar(30) NOT NULL,
  `tipo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pokedex`
--

INSERT INTO `pokedex` (`idEspecie`, `nombreEspecie`, `tipo`) VALUES
(1, 'Bennett', 2),
(2, 'Chongyun', 3),
(3, 'Gorou', 8),
(4, 'Kazuha', 5),
(5, 'Ayaka', 3),
(6, 'Ayato', 4),
(7, 'Raiden', 6),
(8, 'Eula', 0),
(9, 'Beidou', 6),
(10, 'Ninguang', 8),
(11, 'Shenhe', 3),
(12, 'Xiao', 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
