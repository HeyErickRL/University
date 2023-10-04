-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 11, 2023 at 08:09 PM
-- Server version: 11.1.0-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pelimarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `administradores`
--

CREATE TABLE `administradores` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `administradores`
--

INSERT INTO `administradores` (`id`, `correo`, `contrasena`) VALUES
(1, 'erickRL@gmail.com', 'Robles38,');

-- --------------------------------------------------------

--
-- Table structure for table `calificacion`
--

CREATE TABLE `calificacion` (
  `id_calificacion` bigint(20) NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `id_peliculas` bigint(20) DEFAULT NULL,
  `cal` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `calificacion`
--

INSERT INTO `calificacion` (`id_calificacion`, `id_usuario`, `id_peliculas`, `cal`) VALUES
(9, 4, 1003, 'dislike'),
(10, 10, 1004, 'dislike'),
(11, 10, 1016, 'like'),
(13, 14, 1014, 'like'),
(14, 14, 1018, 'like');

-- --------------------------------------------------------

--
-- Table structure for table `carrito`
--

CREATE TABLE `carrito` (
  `id_compra` bigint(20) UNSIGNED NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `id_peliculas` bigint(20) DEFAULT NULL,
  `modalidad` varchar(50) DEFAULT NULL,
  `precio` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `carrito`
--

INSERT INTO `carrito` (`id_compra`, `id_usuario`, `id_peliculas`, `modalidad`, `precio`) VALUES
(109, 10, 1006, 'compra', 10),
(184, 14, 1004, 'compra', 10);

-- --------------------------------------------------------

--
-- Table structure for table `comentario`
--

CREATE TABLE `comentario` (
  `id_comentario` int(11) NOT NULL,
  `comentario` text DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `id_peliculas` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `comentario`
--

INSERT INTO `comentario` (`id_comentario`, `comentario`, `fecha`, `id_usuario`, `id_peliculas`) VALUES
(1, 'buena pelicula, la mejor de todos los tiempos', '2023-06-04', 10, 1003),
(2, 'Es muy lenta pero tiene un final espectacular', '2023-06-04', 4, 1003),
(3, 'Siii!', '2023-06-04', 4, 1003),
(4, 'hola', '2023-06-04', 10, 1003),
(5, 'hola\n', '2023-06-04', 10, 1004),
(6, 'ooooo\n', '2023-06-04', 10, 1004),
(7, 'La mejor pelicula de todos los tiempos', '2023-06-05', 10, 1014),
(8, 'Hola', '2023-06-05', 4, 1014),
(9, 'Una buena pelicula de batman, pero sin llegar a ser la mejor.', '2023-06-06', 10, 1006),
(10, 'la mejor pelicula que he visto en mi vida', '2023-06-08', 14, 1014),
(11, 'Hola', '2023-06-19', 19, 1003),
(12, 'hola', '2023-08-16', 14, 1018);

-- --------------------------------------------------------

--
-- Table structure for table `favoritos`
--

CREATE TABLE `favoritos` (
  `id_favoritos` bigint(20) NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `id_peliculas` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `favoritos`
--

INSERT INTO `favoritos` (`id_favoritos`, `id_usuario`, `id_peliculas`) VALUES
(74, 15, 1018),
(75, 14, 1015),
(76, 14, 1004);

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

CREATE TABLE `genero` (
  `id_genero` bigint(20) NOT NULL,
  `nombre` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `genero`
--

INSERT INTO `genero` (`id_genero`, `nombre`) VALUES
(1, 'Accion'),
(2, 'Comedia'),
(3, 'Terror'),
(4, 'Fantasia');

-- --------------------------------------------------------

--
-- Table structure for table `historial`
--

CREATE TABLE `historial` (
  `id_historial` bigint(20) NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  `total_compra` bigint(20) NOT NULL,
  `fecha_compra` timestamp NOT NULL,
  `id_mp` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `historial`
--

INSERT INTO `historial` (`id_historial`, `id_usuario`, `total_compra`, `fecha_compra`, `id_mp`) VALUES
(17, 10, 15, '2023-06-09 04:46:50', 6),
(18, 10, 15, '2023-06-09 04:52:24', 6),
(19, 10, 15, '2023-06-09 05:00:21', 6),
(20, 10, 15, '2023-06-09 05:01:09', 6),
(21, 10, 15, '2023-06-09 05:05:04', 6),
(22, 10, 15, '2023-06-09 05:12:06', 6),
(23, 10, 15, '2023-06-09 05:17:18', 6),
(24, 10, 15, '2023-06-09 05:20:06', 6),
(25, 10, 15, '2023-06-09 05:25:02', 6),
(26, 10, 15, '2023-06-09 05:25:21', 6),
(27, 10, 15, '2023-06-09 05:27:53', 6),
(28, 10, 15, '2023-06-09 05:28:14', 6),
(29, 10, 15, '2023-06-09 05:30:51', 6),
(30, 10, 15, '2023-06-09 05:33:31', 6),
(31, 14, 15, '2023-06-09 06:10:35', 9),
(32, 14, 15, '2023-06-09 06:13:58', 9),
(33, 14, 20, '2023-06-09 07:37:53', 8),
(34, 14, 15, '2023-06-09 07:38:55', 8),
(35, 14, 10, '2023-06-09 07:41:24', 8),
(36, 14, 10, '2023-06-09 07:42:15', 7),
(37, 14, 10, '2023-06-09 07:47:03', 8),
(38, 14, 10, '2023-06-09 07:52:11', 8),
(39, 14, 5, '2023-06-09 07:53:50', 8),
(40, 14, 20, '2023-06-09 08:01:47', 8),
(41, 14, 10, '2023-06-09 08:05:03', 8),
(42, 14, 10, '2023-06-09 08:08:56', 9),
(43, 14, 10, '2023-06-09 08:11:13', 8),
(44, 14, 10, '2023-06-09 23:41:22', 9),
(45, 14, 10, '2023-06-09 23:42:22', 8),
(46, 14, 10, '2023-06-09 23:51:19', 8),
(47, 14, 10, '2023-06-10 00:03:52', 9),
(48, 14, 10, '2023-06-10 00:08:01', 8),
(49, 14, 10, '2023-06-10 00:31:47', 8),
(50, 14, 10, '2023-06-10 00:32:02', 8),
(51, 14, 10, '2023-06-10 00:33:40', 8),
(52, 14, 10, '2023-06-10 00:38:37', 8),
(53, 14, 10, '2023-06-10 00:44:44', 8),
(54, 14, 5, '2023-06-10 00:47:13', 8),
(55, 14, 10, '2023-06-10 00:52:00', 8),
(56, 14, 10, '2023-06-10 00:54:14', 8),
(57, 14, 10, '2023-06-10 00:55:23', 9),
(58, 14, 10, '2023-06-10 01:18:15', 8),
(59, 14, 10, '2023-06-10 01:34:35', 9),
(60, 14, 10, '2023-06-10 01:47:38', 8),
(61, 14, 15, '2023-06-10 02:04:54', 8),
(62, 14, 15, '2023-06-10 02:32:00', 8),
(63, 14, 10, '2023-06-14 00:55:11', 7),
(64, 14, 10, '2023-06-14 01:01:09', 13),
(65, 14, 30, '2023-06-14 01:17:33', 13),
(66, 8, 20, '2023-06-14 02:28:38', 14),
(67, 15, 10, '2023-06-14 02:54:46', 15),
(68, 14, 20, '2023-06-19 07:54:01', 13),
(69, 19, 40, '2023-06-19 16:51:59', 16),
(70, 19, 50, '2023-06-19 16:53:18', 16),
(71, 14, 15, '2023-07-14 19:35:58', 13),
(72, 14, 20, '2023-07-24 23:46:31', 13),
(73, 14, 10, '2023-07-24 23:55:50', 7),
(74, 14, 10, '2023-07-24 23:56:43', 7),
(75, 14, 10, '2023-07-24 23:57:43', 7),
(76, 14, 10, '2023-07-24 23:57:53', 13),
(77, 14, 10, '2023-07-25 00:58:57', 7),
(78, 14, 30, '2023-07-25 23:54:27', 13),
(79, 14, 10, '2023-07-26 00:04:02', 13);

-- --------------------------------------------------------

--
-- Table structure for table `historial_productos`
--

CREATE TABLE `historial_productos` (
  `id_historial` bigint(20) NOT NULL,
  `id_peliculas` bigint(20) NOT NULL,
  `precio` bigint(20) NOT NULL,
  `id_usuario` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `historial_productos`
--

INSERT INTO `historial_productos` (`id_historial`, `id_peliculas`, `precio`, `id_usuario`) VALUES
(18, 1003, 5, 10),
(18, 1003, 10, 10),
(19, 1003, 5, 10),
(19, 1003, 10, 10),
(20, 1003, 5, 10),
(20, 1003, 10, 10),
(21, 1003, 5, 10),
(21, 1003, 10, 10),
(22, 1003, 5, 10),
(22, 1003, 10, 10),
(24, 1003, 5, 10),
(24, 1003, 10, 10),
(25, 1003, 5, 10),
(25, 1003, 10, 10),
(26, 1003, 5, 10),
(26, 1003, 10, 10),
(27, 1003, 5, 10),
(27, 1003, 10, 10),
(28, 1003, 5, 10),
(28, 1003, 10, 10),
(29, 1003, 5, 10),
(29, 1003, 10, 10),
(30, 1003, 5, 10),
(30, 1003, 10, 10),
(31, 1003, 10, 14),
(31, 1014, 5, 14),
(33, 1004, 10, 14),
(33, 1006, 10, 14),
(34, 1004, 10, 14),
(34, 1016, 5, 14),
(35, 1014, 10, 14),
(36, 1016, 10, 14),
(37, 1015, 10, 14),
(38, 1005, 10, 14),
(39, 1014, 5, 14),
(40, 1007, 10, 14),
(40, 1016, 10, 14),
(41, 1005, 10, 14),
(42, 1004, 10, 14),
(43, 1004, 10, 14),
(44, 1014, 10, 14),
(45, 1005, 10, 14),
(46, 1016, 10, 14),
(47, 1016, 10, 14),
(48, 1014, 10, 14),
(49, 1014, 10, 14),
(51, 1006, 10, 14),
(52, 1007, 10, 14),
(53, 1007, 10, 14),
(54, 1016, 5, 14),
(55, 1006, 10, 14),
(56, 1015, 10, 14),
(57, 1003, 10, 14),
(58, 1003, 10, 14),
(59, 1007, 10, 14),
(60, 1014, 10, 14),
(61, 1015, 5, 14),
(61, 1007, 10, 14),
(62, 1014, 5, 14),
(62, 1007, 10, 14),
(63, 1005, 10, 14),
(64, 1015, 10, 14),
(65, 1016, 10, 14),
(65, 1007, 5, 14),
(65, 1003, 5, 14),
(65, 1014, 10, 14),
(66, 1015, 10, 8),
(66, 1016, 10, 8),
(67, 1018, 10, 15),
(68, 1004, 10, 14),
(68, 1015, 10, 14),
(69, 1003, 10, 19),
(69, 1015, 5, 19),
(69, 1018, 10, 19),
(69, 1006, 10, 19),
(69, 1016, 5, 19),
(70, 1003, 10, 19),
(70, 1014, 10, 19),
(70, 1018, 10, 19),
(70, 1016, 10, 19),
(70, 1007, 10, 19),
(71, 1015, 5, 14),
(71, 1018, 10, 14),
(72, 1005, 10, 14),
(72, 1005, 10, 14),
(73, 1004, 10, 14),
(74, 1004, 10, 14),
(76, 1003, 10, 14),
(77, 1003, 10, 14),
(78, 1004, 10, 14),
(78, 1006, 10, 14),
(78, 1004, 10, 14),
(79, 1005, 10, 14);

-- --------------------------------------------------------

--
-- Table structure for table `peliculas`
--

CREATE TABLE `peliculas` (
  `id_peliculas` bigint(20) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(1000) DEFAULT NULL,
  `precio` bigint(20) DEFAULT NULL,
  `renta` bigint(20) DEFAULT NULL,
  `imagen` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `peliculas`
--

INSERT INTO `peliculas` (`id_peliculas`, `titulo`, `genero`, `fecha`, `descripcion`, `precio`, `renta`, `imagen`) VALUES
(1003, 'Avengers Endgame', 'Accion', '2023-05-15', 'Tras los devastadores sucesos de Avengers: Infinity War, el universo estÃ¡ en ruinas pero de los que quedan, los Avengers se unirÃ¡n una vez mÃ¡s.', 10, 5, 'https://es.web.img2.acsta.net/pictures/19/03/26/17/22/0896830.jpg'),
(1004, 'Spider-Man: Un nuevo universo', 'Accion', '2018-06-22', 'El adolescente Miles Morales es el Spider-Man de su propia realidad y se encontrarÃ¡ con otros como Ã©l de otras dimensiones para combatir una amenaza que acecha a todas las realidades.', 10, 5, 'http://www.cines.com.py/images/dinamico/peliculas/2193/afiche/71520.jpg'),
(1005, 'Deadpool', 'Accion', '2016-02-11', 'Wade Wilson es un mercenario que pasaba su tiempo en la ciudad de Nueva York protegiendo a las adolescentes de los posibles acosadores y asistÃ­a a un bar en el que los ebrios solÃ­an organizar peleas denominadas Pozos de la Muerte.', 10, 5, 'http://3.bp.blogspot.com/-wHrh7oHom3o/VsklVBrXQYI/AAAAAAAAHpo/NyY-5R2DsIo/s1600/deadpolll.jpg'),
(1006, 'The Batman', 'Accion', '2022-03-03', 'En Halloween, el alcalde de Gotham City Don Mitchell Jr. es asesinado por el asesino en serie Riddler (Enigma en EspaÃ±a, Acertijo en HispanoamÃ©rica). El multimillonario Bruce Wayne, que lleva dos aÃ±os operando en Gotham como el justiciero enmascarado Batman, investiga el hecho junto al Departamento de PolicÃ­a de Gotham City (GCPD). El teniente James Gordon descubre que Riddler dejÃ³ un mensaje para Batman, pero el comisario Pete Savage le reprende por permitir que Batman entre en la escena del crimen y le obliga a marcharse. ', 10, 5, 'https://img.aullidos.com/imagenes/caratulas/the-batman-poster-2.jpg'),
(1007, 'Avengers Infinity War', 'Accion', '2018-04-28', 'Un viaje cinematogrÃ¡fico sin precedentes de diez aÃ±os en desarrollo y que abarca todo el Universo CinematogrÃ¡fico de Marvel, ', 10, 4, 'https://cdn.marvel.com/content/1x/avengersinfinitywar_lob_crd_02.jpg'),
(1014, 'Spider-Man: Across the Spider-Verse', 'Accion', '2023-06-01', 'Miles Morales regresa para el proximo capitulo de la saga Spider-Verse, ganadora de un OscarÂ®, una aventura Ã©pica que transportarÃ¡ a Spider-Man, el amigable vecindario de tiempo completo de Brooklyn, a travÃ©s del Multiverso para unir fuerzas con Gwen Stacy y un nuevo equipo de Spider-Man. Personas que se enfrenten a un villano mÃ¡s poderoso que cualquier cosa que hayan conocido.', 10, 5, 'https://cloudfront-us-east-1.images.arcpublishing.com/infobae/UN6NC7QUSNHHTFSRSNR4CB35EY.jpg'),
(1015, 'Spiderman No Way Home', 'Accion', '2021-12-14', 'Por primera vez en la historia cinematogrÃ¡fica de Spider-Man, nuestro amigable hÃ©roe vecino estÃ¡ desenmascarado y ya no puede separar su vida normal de los grandes desafÃ­os de ser un superhÃ©roe. Cuando le pide ayuda al Doctor Strange, lo que estÃ¡ en juego se vuelve aÃºn mÃ¡s peligroso, lo que lo obliga a descubrir lo que realmente significa ser Spider-Manâ€', 10, 5, 'https://www.cinemablind.com/wp-content/uploads/2021/11/Spider-Man-No-Way-Home-Poster-543x805.jpg'),
(1016, 'The Flash', 'Accion', '2023-06-15', 'Los mundos chocan en \"Flash\" cuando Barry utiliza sus superpoderes para viajar en el tiempo y cambiar los acontecimientos del pasado. Barry intenta salvar a su familia, pero sin saberlo altera el futuro y queda atrapado en una realidad en la que el general Zod ha regresado y amenaza con la aniquilaciÃ³n, pero en la que no hay SuperhÃ©roes a los que recurrir. A menos que Barry pueda persuadir a un Batman muy diferente para que salga de su retiro y rescate a un kryptoniano encarcelado... aunque no sea el que estÃ¡ buscando. En Ãºltima instancia, para salvar el mundo en el que se encuentra y regresar al futuro que conoce, la Ãºnica esperanza de Barry es luchar por seguir vivo. Pero Â¿este Ãºltimo sacrificio serÃ¡ suficiente para reiniciar el universo?', 10, 5, 'https://cloudfront-us-east-1.images.arcpublishing.com/infobae/PQE4HKDXRRBWFGZTPOIIETCUQA.jpg'),
(1018, 'Interstellar', 'Ciencia Ficcion', '2014-10-26', 'En 2067, la destrucciÃ³n de las cosechas en la Tierra ha hecho que la agricultura sea cada vez mÃ¡s difÃ­cil y se vea amenazada la supervivencia de la humanidad. Joseph Cooper, viudo, exingeniero y piloto de la NASA, dirige una granja con su suegro Donald, su hijo Tom y su hija Murph, quien cree que su habitaciÃ³n estÃ¡ embrujada por un poltergeist. Cuando aparecen inexplicablemente extraÃ±os patrones de polvo en el suelo de la habitaciÃ³n de Murph, Cooper se da cuenta de que la gravedad estÃ¡ detrÃ¡s de su formaciÃ³n, no un \"fantasma\". Interpreta el patrÃ³n como un conjunto de coordenadas geogrÃ¡ficas formadas en cÃ³digo binario. Cooper y Murph siguen las coordenadas a una instalaciÃ³n secreta de la NASA, donde se encuentran con el exprofesor de Cooper, el doctor Brand.', 10, 4, 'https://idolosolvidados.com/wp-content/uploads/2014/12/Interstellar-366875261-large-768x1139.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` bigint(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `contrasena`, `correo`, `telefono`) VALUES
(10, 'Alan', 'Huerta', '12345678', 'alanhh@gmail.com', 33210),
(14, 'Erick', 'Luna', 'lapulga2', 'erick556u@gmail.com', 3321084692),
(19, 'Maria', 'Santana', '12345', 'rsantana@ceti.mx', 331000000);

-- --------------------------------------------------------

--
-- Table structure for table `usuario_info`
--

CREATE TABLE `usuario_info` (
  `id_usuario` bigint(20) NOT NULL,
  `id_mp` bigint(20) NOT NULL,
  `metodo_pago` varchar(16) NOT NULL,
  `numero_tarjeta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `usuario_info`
--

INSERT INTO `usuario_info` (`id_usuario`, `id_mp`, `metodo_pago`, `numero_tarjeta`) VALUES
(10, 5, 'debito', '1564651231215465'),
(10, 6, 'debito', '4512135484588'),
(14, 7, '', ''),
(14, 8, '7', ''),
(14, 9, '7', ''),
(14, 10, '8', ''),
(14, 11, '7', ''),
(14, 12, '7', ''),
(14, 13, 'debito', '45454613756'),
(8, 14, 'debito', '4546654678912345'),
(15, 15, 'debito', '4497874212131647'),
(19, 16, 'debito', '4546654678912345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `calificacion`
--
ALTER TABLE `calificacion`
  ADD PRIMARY KEY (`id_calificacion`),
  ADD KEY `1-calificacionusuario` (`id_usuario`),
  ADD KEY `2-calificacionpelicula` (`id_peliculas`);

--
-- Indexes for table `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_peliculas` (`id_peliculas`),
  ADD KEY `precio` (`precio`);

--
-- Indexes for table `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id_comentario`),
  ADD KEY `1-comentariousuario` (`id_usuario`),
  ADD KEY `2-comentariopelicula` (`id_peliculas`);

--
-- Indexes for table `favoritos`
--
ALTER TABLE `favoritos`
  ADD PRIMARY KEY (`id_favoritos`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_pelicula` (`id_peliculas`);

--
-- Indexes for table `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_genero`);

--
-- Indexes for table `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`id_historial`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_metodopago` (`id_mp`);

--
-- Indexes for table `historial_productos`
--
ALTER TABLE `historial_productos`
  ADD KEY `1-idhistorialcompra` (`id_historial`);

--
-- Indexes for table `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id_peliculas`),
  ADD KEY `renta` (`renta`),
  ADD KEY `precio` (`precio`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario_info`
--
ALTER TABLE `usuario_info`
  ADD PRIMARY KEY (`id_mp`),
  ADD KEY `1-historialusuario` (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `calificacion`
--
ALTER TABLE `calificacion`
  MODIFY `id_calificacion` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `carrito`
--
ALTER TABLE `carrito`
  MODIFY `id_compra` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=185;

--
-- AUTO_INCREMENT for table `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id_comentario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `favoritos`
--
ALTER TABLE `favoritos`
  MODIFY `id_favoritos` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT for table `genero`
--
ALTER TABLE `genero`
  MODIFY `id_genero` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `historial`
--
ALTER TABLE `historial`
  MODIFY `id_historial` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- AUTO_INCREMENT for table `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id_peliculas` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1019;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `usuario_info`
--
ALTER TABLE `usuario_info`
  MODIFY `id_mp` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `calificacion`
--
ALTER TABLE `calificacion`
  ADD CONSTRAINT `1-calificacionusuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `2-calificacionpelicula` FOREIGN KEY (`id_peliculas`) REFERENCES `peliculas` (`id_peliculas`);

--
-- Constraints for table `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `1-carrito` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `2-pelicula` FOREIGN KEY (`id_peliculas`) REFERENCES `peliculas` (`id_peliculas`);

--
-- Constraints for table `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `1-comentariousuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `2-comentariopelicula` FOREIGN KEY (`id_peliculas`) REFERENCES `peliculas` (`id_peliculas`);

--
-- Constraints for table `favoritos`
--
ALTER TABLE `favoritos`
  ADD CONSTRAINT `1-favoritousuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `2-favoritopelicula` FOREIGN KEY (`id_peliculas`) REFERENCES `peliculas` (`id_peliculas`);

--
-- Constraints for table `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `1-historialuusuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario_info` (`id_usuario`),
  ADD CONSTRAINT `2-historialmetodo` FOREIGN KEY (`id_mp`) REFERENCES `usuario_info` (`id_mp`);

--
-- Constraints for table `historial_productos`
--
ALTER TABLE `historial_productos`
  ADD CONSTRAINT `1-idhistorialcompra` FOREIGN KEY (`id_historial`) REFERENCES `historial` (`id_historial`);

--
-- Constraints for table `usuario_info`
--
ALTER TABLE `usuario_info`
  ADD CONSTRAINT `1-historialusuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
