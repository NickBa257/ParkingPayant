-- phpMyAdmin SQL Dump
-- version 3.3.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2023 at 05:02 PM
-- Server version: 5.1.49
-- PHP Version: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `parking`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `identifiant` varchar(20) NOT NULL,
  `Mot_de_Passe` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`identifiant`, `Mot_de_Passe`) VALUES
('Administrateur', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `camion`
--

DROP TABLE IF EXISTS `camion`;
CREATE TABLE IF NOT EXISTS `camion` (
  `Proprietaire` varchar(20) DEFAULT NULL,
  `immatriculation` varchar(20) NOT NULL DEFAULT '',
  `Marque` varchar(20) DEFAULT NULL,
  `Couleur` varchar(20) DEFAULT NULL,
  `Date_heure_Entree` varchar(20) DEFAULT NULL,
  `Frais` double DEFAULT NULL,
  `Date_heure_Sortie` varchar(20) DEFAULT NULL,
  `Duree` int(11) NOT NULL,
  PRIMARY KEY (`immatriculation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `camion`
--


-- --------------------------------------------------------

--
-- Table structure for table `connexion`
--

DROP TABLE IF EXISTS `connexion`;
CREATE TABLE IF NOT EXISTS `connexion` (
  `identifiant` varchar(20) DEFAULT NULL,
  `mot_de_passe` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `connexion`
--

INSERT INTO `connexion` (`identifiant`, `mot_de_passe`) VALUES
('Nick', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `moto`
--

DROP TABLE IF EXISTS `moto`;
CREATE TABLE IF NOT EXISTS `moto` (
  `Proprietaire` varchar(20) DEFAULT NULL,
  `immatriculation` varchar(20) NOT NULL DEFAULT '',
  `Marque` varchar(20) DEFAULT NULL,
  `Couleur` varchar(20) DEFAULT NULL,
  `Date_heure_Entree` varchar(20) DEFAULT NULL,
  `Frais` double DEFAULT NULL,
  `Date_heure_Sortie` varchar(20) DEFAULT NULL,
  `Duree` int(11) NOT NULL,
  PRIMARY KEY (`immatriculation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `moto`
--


-- --------------------------------------------------------

--
-- Table structure for table `voiture`
--

DROP TABLE IF EXISTS `voiture`;
CREATE TABLE IF NOT EXISTS `voiture` (
  `Proprietaire` varchar(20) DEFAULT NULL,
  `immatriculation` varchar(20) NOT NULL DEFAULT '',
  `Marque` varchar(20) DEFAULT NULL,
  `Couleur` varchar(20) DEFAULT NULL,
  `Date_heure_Entree` varchar(20) DEFAULT NULL,
  `Frais` double DEFAULT NULL,
  `Date_heure_Sortie` varchar(20) DEFAULT NULL,
  `Duree` int(11) NOT NULL,
  PRIMARY KEY (`immatriculation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voiture`
--

INSERT INTO `voiture` (`Proprietaire`, `immatriculation`, `Marque`, `Couleur`, `Date_heure_Entree`, `Frais`, `Date_heure_Sortie`, `Duree`) VALUES
(NULL, 'EA 5150', 'Toyota AE110', 'Gris', '27/06/2023 15:39', NULL, NULL, 56345),
(NULL, 'LA 1636', 'Allion 1.8', 'Gris', '28/06/2023 00:20', NULL, NULL, 1213),
(NULL, 'KA 4701', 'Nissan Tiida 2011', 'Gris', '28/06/2023 00:20', NULL, NULL, 1231);
