-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-12-2021 a las 06:06:51
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Terror'),
(2, 'Comedia'),
(3, 'Suspenso'),
(4, 'Accion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `descripcion` text NOT NULL,
  `sinopsis` text NOT NULL,
  `rating` int(11) NOT NULL,
  `fechaRegistro` datetime NOT NULL,
  `fechaUpdate` datetime DEFAULT NULL,
  `estado` tinyint(4) NOT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id`, `titulo`, `descripcion`, `sinopsis`, `rating`, `fechaRegistro`, `fechaUpdate`, `estado`, `categoria`) VALUES
(1, 'El conjuro', 'Pelicula de terror basada en hechos reales', 'Una monja bien loka viene a poseer a una niña aka bien loko y ps los warren la exorzian alv para que se vaya', 8, '2021-11-24 09:45:14', '2021-11-24 10:03:25', 1, 1),
(2, 'Red notice', 'Una alerta roja es el más alto nivel de amenaza o alerta en diversos sistemas de información y es a menudo utilizado para indicar un determinado tipo de emergencia. Literalmente este tipo de alerta se refiere a la iluminación de color rojo utilizada para indicar peligro.', 'John Hartley, agente de la Interpol, no tendrá otro remedio que aliarse con el ladrón de arte más célebre de todos los tiempos, Nolan Booth, para capturar a la ladrona de arte más buscada del presente: la seductora y peligrosa Sarah Black.', 9, '2021-11-24 16:47:56', NULL, 1, 4),
(3, 'El conjuro', 'Pelicula de terror basada en hechos reales', 'Una monja bien loka viene a poseer a una niña aka bien loko y ps los warren la exorzian alv para que se vaya', 8, '2021-11-24 09:59:49', NULL, 0, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_foreign_key_categoria` (`categoria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `fk_foreign_key_categoria` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
