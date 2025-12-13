/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50744
Source Host           : localhost:3306
Source Database       : dbaulax

Target Server Type    : MYSQL
Target Server Version : 50744
File Encoding         : 65001

Date: 2025-12-13 16:35:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for clases
-- ----------------------------
DROP TABLE IF EXISTS `clases`;
CREATE TABLE `clases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` text COLLATE utf8mb4_unicode_ci,
  `idUsuario` int(11) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fkUsuario` (`idUsuario`) USING BTREE,
  CONSTRAINT `fkUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of clases
-- ----------------------------
INSERT INTO `clases` VALUES ('5', 'Clase1', '<p>CCCCC</p>', '9', '2025-12-13 16:04:11', '1');
INSERT INTO `clases` VALUES ('6', 'Clase2', '<p>CCCCC</p>', '9', '2025-12-13 16:04:22', '1');
INSERT INTO `clases` VALUES ('7', 'Clase3', '<p>ASD</p>', '9', '2025-12-13 16:04:31', '1');
INSERT INTO `clases` VALUES ('8', 'Clase 4', '<p>asdsadsad</p>', '1', '2025-12-13 16:25:59', '1');

-- ----------------------------
-- Table structure for claseusuarios
-- ----------------------------
DROP TABLE IF EXISTS `claseusuarios`;
CREATE TABLE `claseusuarios` (
  `idClase` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idClase`,`idUsuario`) USING BTREE,
  KEY `fkUsuarioU` (`idUsuario`) USING BTREE,
  CONSTRAINT `fkClaseU` FOREIGN KEY (`idClase`) REFERENCES `clases` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fkUsuarioU` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of claseusuarios
-- ----------------------------
INSERT INTO `claseusuarios` VALUES ('5', '1');
INSERT INTO `claseusuarios` VALUES ('7', '1');

-- ----------------------------
-- Table structure for documentos
-- ----------------------------
DROP TABLE IF EXISTS `documentos`;
CREATE TABLE `documentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idClase` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `documento` mediumblob,
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
  `nombre` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
  `nombre` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
  `descripcion` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
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
  `nombre` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidop` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellidom` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `estatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fkRol` (`idRol`) USING BTREE,
  CONSTRAINT `fkRol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO `usuarios` VALUES ('1', '1', 'Jose Carlos', 'Alvarado', 'Gutierrez', 'jcarlosagutierrezipn@gmail.com', '$2a$10$ZfxykG0DVnrjLoMR6J7d3O7eJgOjPYeBOMiBpkh81BFzpKpRe52C6', '1');
INSERT INTO `usuarios` VALUES ('2', '2', 'Daniel', 'Rangel', 'Hernandez', 'dany123@gmail.com', '$2a$10$YBmxALhb9FsxmEHXyaaOoeb01eAmkN4tjKVvcAzTNM7Bndg/QViQ.', '1');
INSERT INTO `usuarios` VALUES ('3', '3', 'Josue Israel', 'Gonzalez', 'Baez', 'j@gmail.com', '$2a$10$xMx.TqbLMzScuW3FORAw3e4UqdRJG8hz9bvueIHcto92UQgh5LC3i', '1');
INSERT INTO `usuarios` VALUES ('4', '3', 'asd', 'asd', 'asd', 'asd@gmail.com', '$2a$10$kNpt7dJIXCdx8x1.wGH7MO1eGaORjxFa9sW8n1HklBrGBeYvJbkwK', '1');
INSERT INTO `usuarios` VALUES ('5', '1', 'dffd', 'dfdffd', 'dffd', 'f@gmail.com', '$2a$10$vSHUMS31C5P4IRZwkeEl9e65kT6XseXWMiD5Awz/vJsttzRF419Dq', '1');
INSERT INTO `usuarios` VALUES ('6', '3', 'Victor Emmanuel', 'Jimenez', 'Ramirez', 'vikator@gmail.com', '$2a$10$P1D2M46zxOvEPB/wmwJD0OGXoZtolLKKN29YY2CAHwKob17IaZSzu', '1');
INSERT INTO `usuarios` VALUES ('7', '3', 'Karina', 'Pozos', 'Cabrera', 'elquesea@gmail.com', '$2a$10$2SqPtAab1FU90/Ygo6tCzO0o0KPp3irqMvGgbdoTuCdCUxzA4G8Fy', '1');
INSERT INTO `usuarios` VALUES ('9', '1', 'Growling Machine', 'XXX', 'BEAST', 'growl@gmail.com', '$2a$10$gJGdFunFibyZFRaZUd4FKuu8fvuzycqfPkYTWz7zOu0itJ2Y7QNpm', '1');
INSERT INTO `usuarios` VALUES ('10', '1', 'Yahir', 'Avendaño', 'Mena', 'yahir@gmail.com', '$2a$10$/29KzRvNSedTSyHaJT83Nei0Xxz.h4dOHlEXgk5dXikmtigiz.89.', '1');
INSERT INTO `usuarios` VALUES ('11', '2', 'Marha Rosa', 'Cordero', 'Lopez', 'mcorderol@ipn.mx', '$2a$10$475mxE1EptupyBo0gv/SbOP88Nnmw.0xZW2K.X7dGFSfNN3pHhyf.', '1');
INSERT INTO `usuarios` VALUES ('12', '1', 'Dolores', 'Gutierrez', 'Dominguez', 'lolys@gmail.com', '$2a$10$aLja9Wt3b1EwiGzNkvNqpOR/No78mVVdJC2nvydY6Cnl9zgmbuxWu', '1');
