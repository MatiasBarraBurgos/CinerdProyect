-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-11-2023 a las 23:58:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinerdproyect`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `pelicula` varchar(40) NOT NULL,
  `horario` varchar(40) NOT NULL,
  `sala` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Peliculas reservadas';

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`pelicula`, `horario`, `sala`) VALUES
('[value-1]', '[value-2]', '[value-3]'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 1 (Napoleon)', '15:00 ', '3D'),
('Pelicula 1 (Napoleon)', '21:00 ', '2D'),
('Pelicula 6 (Whish)', '17:20 ', '3D'),
('Pelicula 4  (Noche de paz)', '13:00 ', '3DXD'),
('Pelicula 4  (Noche de paz)', '16:00 ', '2D'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 4  (Noche de paz)', '16:00 ', '3D'),
('Pelicula 6 (Whish)', '12:40 ', '3DXD'),
('Pelicula 5  (Teddy)', '16:30 ', '3D'),
('Pelicula 3 (Aquaman)', '17:00 ', '2D'),
('Pelicula 5  (Teddy)', '16:30 ', '2D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3DXD'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 1 (Napoleon)', '15:00 ', '2D'),
('Pelicula 1 (Napoleon)', '18:00 ', '2D'),
('Pelicula 3 (Aquaman)', '17:00 ', '3D'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '13:00 ', '2D'),
('Pelicula 6 (Whish)', '12:40 ', '2D'),
('Pelicula 1 (Napoleon)', '21:00 ', '3D'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 1 (Napoleon)', '21:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 3 (Aquaman)', '17:00 ', '2D'),
('Pelicula 2 (Wonka)', '13:00 ', '3DXD'),
('Pelicula 6 (Whish)', '14:00 ', '2D'),
('Pelicula 1 (Napoleon)', '21:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 6 (Whish)', '12:40 ', '3DXD'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 1 (Napoleon)', '18:00 ', '2D'),
('Pelicula 3 (Aquaman)', '14:00 ', '3D'),
('Pelicula 1 (Napoleon)', '15:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 3 (Aquaman)', '17:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 1 (Napoleon)', '15:00 ', '2D'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 3 (Aquaman)', '19:00 ', '3D'),
('Pelicula 6 (Whish)', '12:40 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 6 (Whish)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '3DXD'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 1 (Napoleon)', '21:00 ', '3DXD'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 6 (Whish)', '14:00 ', '3D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3DXD'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 4  (Noche de paz)', '13:00 ', '3DXD'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 3 (Aquaman)', '17:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '21:00 ', '3DXD'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 6 (Whish)', '14:00 ', '3D'),
('Pelicula 1 (Napoleon)', '21:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 1 (Napoleon)', '21:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3DXD'),
('Pelicula 6 (Whish)', '12:40 ', '3D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '15:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3DXD'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 1 (Napoleon)', '15:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 6 (Whish)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '21:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '21:00 ', '2D'),
('Pelicula 3 (Aquaman)', '19:00 ', '2D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3D'),
('Pelicula 3 (Aquaman)', '14:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '15:00 ', '2D'),
('Pelicula 1 (Napoleon)', '21:00 ', '3D'),
('Pelicula 1 (Napoleon)', '15:00 ', '3DXD'),
('Pelicula 3 (Aquaman)', '17:00 ', '3DXD'),
('Pelicula 2 (Wonka)', '13:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 1 (Napoleon)', '21:00 ', '2D'),
('Pelicula 3 (Aquaman)', '14:00 ', '2D'),
('Pelicula 3 (Aquaman)', '14:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '15:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 3 (Aquaman)', '17:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '15:00 ', '2D'),
('Pelicula 1 (Napoleon)', '21:00 ', '2D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '18:00 ', '3DXD'),
('Pelicula 1 (Napoleon)', '15:00 ', '3D'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 3 (Aquaman)', '19:00 ', '3D'),
('Pelicula 6 (Whish)', '17:20 ', '3DXD'),
('Pelicula 1 (Napoleon)', '21:00 ', '2D'),
('Pelicula 1 (Napoleon)', '15:00 ', '3DXD'),
('Pelicula 2 (Wonka)', '13:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '2D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3DXD'),
('Pelicula 6 (Whish)', '14:00 ', '2D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 6 (Whish)', '14:00 ', '3D'),
('Pelicula 1 (Napoleon)', '18:00 ', '3D'),
('Pelicula 2 (Wonka)', '11:00 ', '3D'),
('Pelicula 1 (Napoleon)', '15:00 ', '2D'),
('Napoleon', '18:00 ', '2D'),
('Aquaman 2', '17:00 ', '3DXD'),
('Aquaman 2', '17:00 ', '3D'),
('Aquaman 2', '19:00 ', '3D'),
('Napoleon', '21:00 ', '3D'),
('Napoleon', '18:00 ', '3D'),
('Napoleon', '21:00 ', '2D'),
('Wonka', '13:00 ', '3DXD'),
('Wonka', '11:00 ', '3D'),
('Noche de paz', '16:00 ', '3DXD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `correoelectronico` varchar(40) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `tipousuario` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID`, `nombre`, `apellido`, `correoelectronico`, `pass`, `tipousuario`) VALUES
(9, 'Matías', 'Barra', 'matias.barra@userena.cl', '246', 'Cliente'),
(10, 'Matias', 'Barra', 'Matias@hotmail.com', '12345', 'Cliente'),
(11, 'matias', 'Barra', 'barra@hotmail.com', '246', 'Cliente'),
(12, 'Valentina', 'Barra', 'vale2005@gmail.com', '123456', 'Cliente'),
(13, 'Gonzalo', 'Honores', 'ghonores@userena.cl', 'qwerty', 'Cliente'),
(14, 'dfifrlfie', 'dwduewfyr', 'dhweduwf', 'dhehfewuofi', 'Cliente'),
(15, 'Matias', 'Barra', 'mati@userena.cl', '369', 'Cliente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
