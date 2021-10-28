/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  xavier.verges
 * Created: 28 oct. 2021
 */

CREATE TABLE `autor_xverges` (
`idautor` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(100) NOT NULL,
PRIMARY KEY (`idautor`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;



CREATE TABLE `mensaje_xverges` (
`idmensaje` int(11) NOT NULL AUTO_INCREMENT,
`idautor` int(11) NOT NULL,
`texto` varchar(200) NOT NULL,
PRIMARY KEY (`idmensaje`),
KEY `fk_autor_idx` (`idautor`),
CONSTRAINT `fk_autor` FOREIGN KEY (`idautor`) REFERENCES `autor_xverges` (`idautor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;