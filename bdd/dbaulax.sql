/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3366
Source Database       : dbaulax

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2025-12-09 19:56:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clases
-- ----------------------------
DROP TABLE IF EXISTS `clases`;
CREATE TABLE `clases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fkUsuario` (`idUsuario`) USING BTREE,
  CONSTRAINT `fkUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of clases
-- ----------------------------
INSERT INTO `clases` VALUES ('1', 'Curso nuevo', 'Descripcion de prueba', null, '2025-12-09 18:11:13', null);
INSERT INTO `clases` VALUES ('2', 'Curso de prueba 2', 'Curso 2', null, '2025-12-09 18:17:22', null);
INSERT INTO `clases` VALUES ('3', 'Clase con estilos', '<p style=\"text-align: center;\">asd</p>\r\n<p style=\"text-align: left;\">asd</p>\r\n<p style=\"text-align: left;\">asd</p>\r\n<p style=\"text-align: left;\"><strong>asd</strong></p>', null, '2025-12-09 19:14:20', null);
INSERT INTO `clases` VALUES ('4', 'Clase 3', '<p style=\"text-align: center;\">asdadsa</p>\r\n<p style=\"text-align: left;\">asdadsada</p>\r\n<p style=\"text-align: right;\">sdadsadasd</p>\r\n<ul>\r\n<li style=\"text-align: left;\">sdad</li>\r\n<li style=\"text-align: left;\">asdsa</li>\r\n<li style=\"text-align: left;\">sadad</li>\r\n<li style=\"text-align: left;\">sdada</li>\r\n</ul>\r\n<p style=\"text-align: center;\"><strong>sdadsadd</strong></p>', '3', '2025-12-09 19:36:48', null);

-- ----------------------------
-- Table structure for claseusuarios
-- ----------------------------
DROP TABLE IF EXISTS `claseusuarios`;
CREATE TABLE `claseusuarios` (
  `idClase` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idClase`,`idUsuario`) USING BTREE,
  KEY `fkUsuarioU` (`idUsuario`) USING BTREE,
  CONSTRAINT `fkClaseU` FOREIGN KEY (`idClase`) REFERENCES `clases` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkUsuarioU` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of claseusuarios
-- ----------------------------

-- ----------------------------
-- Table structure for documentos
-- ----------------------------
DROP TABLE IF EXISTS `documentos`;
CREATE TABLE `documentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idClase` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `documento` mediumblob DEFAULT NULL,
  `idEstatus` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fkClaseD` (`idClase`) USING BTREE,
  KEY `fkUsuarioD` (`idUsuario`) USING BTREE,
  KEY `fkEstatusD` (`idEstatus`) USING BTREE,
  CONSTRAINT `fkClaseD` FOREIGN KEY (`idClase`) REFERENCES `clases` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkEstatusD` FOREIGN KEY (`idEstatus`) REFERENCES `estatus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkUsuarioD` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of documentos
-- ----------------------------

-- ----------------------------
-- Table structure for estatus
-- ----------------------------
DROP TABLE IF EXISTS `estatus`;
CREATE TABLE `estatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of estatus
-- ----------------------------

-- ----------------------------
-- Table structure for flujoestatus
-- ----------------------------
DROP TABLE IF EXISTS `flujoestatus`;
CREATE TABLE `flujoestatus` (
  `id` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idClase` int(11) DEFAULT NULL,
  `idDocumento` int(11) DEFAULT NULL,
  `idEstatus` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fkUsuarioF` (`idUsuario`) USING BTREE,
  KEY `fkClaseF` (`idClase`) USING BTREE,
  KEY `fkDocumentoF` (`idDocumento`) USING BTREE,
  KEY `fkEstatusF` (`idEstatus`) USING BTREE,
  CONSTRAINT `fkClaseF` FOREIGN KEY (`idClase`) REFERENCES `clases` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkDocumentoF` FOREIGN KEY (`idDocumento`) REFERENCES `documentos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkEstatusF` FOREIGN KEY (`idEstatus`) REFERENCES `estatus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkUsuarioF` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of flujoestatus
-- ----------------------------

-- ----------------------------
-- Table structure for publicaciones
-- ----------------------------
DROP TABLE IF EXISTS `publicaciones`;
CREATE TABLE `publicaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idClase` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fkClaseP` (`idClase`) USING BTREE,
  KEY `fkUsuarioP` (`idUsuario`) USING BTREE,
  CONSTRAINT `fkClaseP` FOREIGN KEY (`idClase`) REFERENCES `clases` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkUsuarioP` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of publicaciones
-- ----------------------------

-- ----------------------------
-- Table structure for rol
-- ----------------------------
DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of rol
-- ----------------------------
INSERT INTO `rol` VALUES ('1', 'Administrador', '1');
INSERT INTO `rol` VALUES ('2', 'Tutor', '1');
INSERT INTO `rol` VALUES ('3', 'Alumno', '1');

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idRol` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellidop` varchar(255) DEFAULT NULL,
  `apellidom` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fkRol` (`idRol`) USING BTREE,
  CONSTRAINT `fkRol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('1', '1', 'Jose Carlos', 'Alvarado', 'Gutierrez', 'jcarlosagutierrezipn@gmail.com', '$2a$10$ZfxykG0DVnrjLoMR6J7d3O7eJgOjPYeBOMiBpkh81BFzpKpRe52C6', '1');
INSERT INTO `usuarios` VALUES ('2', '2', 'Daniel', 'Rangel', 'Hernandez', 'dany123@gmail.com', '$2a$10$YBmxALhb9FsxmEHXyaaOoeb01eAmkN4tjKVvcAzTNM7Bndg/QViQ.', '1');
INSERT INTO `usuarios` VALUES ('3', '3', 'Josue Israel', 'Gonzalez', 'Baez', 'j@gmail.com', '$2a$10$xMx.TqbLMzScuW3FORAw3e4UqdRJG8hz9bvueIHcto92UQgh5LC3i', '1');
INSERT INTO `usuarios` VALUES ('4', '3', 'asd', 'asd', 'asd', 'asd@gmail.com', '$2a$10$kNpt7dJIXCdx8x1.wGH7MO1eGaORjxFa9sW8n1HklBrGBeYvJbkwK', '1');
