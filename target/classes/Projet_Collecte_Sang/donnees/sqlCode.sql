-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2023 at 04:50 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `collectesang`
--

-- --------------------------------------------------------

--
-- Table structure for table `collecte`
--

CREATE TABLE `collecte` (
  `ID_COLLECTE` int(11) NOT NULL,
  `ID_LIEU` int(11) NOT NULL,
  `TYPE_COLLECTE` varchar(14) DEFAULT NULL,
  `DATE_COLLECTE` varchar(14) DEFAULT NULL,
  `ORGANISATEUR` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `collecte`
--

INSERT INTO `collecte` (`ID_COLLECTE`, `ID_LIEU`, `TYPE_COLLECTE`, `DATE_COLLECTE`, `ORGANISATEUR`) VALUES
(4, 4, 'sang', '12/12/2022', 'croissant'),
(5, 1, 'Plasma', '11/12/2025', 'RMC'),
(9, 2, 'Plasma', '12/11/2023', 'RMC'),
(10, 1, 'Sang', '11/12/2025', 'RMC'),
(15, 1, 'Sang', '25/11/2020', 'Diamon'),
(16, 1, 'Plaque', '02/01/2022', 'Belle Vie'),
(17, 2, 'Plasma', '14/06/2022', 'Clinique Bomon'),
(18, 2, 'Sang', '11/11/2022', 'Sant? pour tous');

-- --------------------------------------------------------

--
-- Table structure for table `don`
--

CREATE TABLE `don` (
  `ID_DON` int(11) NOT NULL,
  `ID_DONNEUR` int(11) NOT NULL,
  `ID_COLLECTE` int(11) NOT NULL,
  `TYPE_DON` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `don`
--

INSERT INTO `don` (`ID_DON`, `ID_DONNEUR`, `ID_COLLECTE`, `TYPE_DON`) VALUES
(4, 1, 15, 'Sang'),
(6, 2, 17, 'Plaque'),
(7, 1, 4, 'Sang');

-- --------------------------------------------------------

--
-- Table structure for table `donneur`
--

CREATE TABLE `donneur` (
  `ID_DONNEUR` int(11) NOT NULL,
  `NUM_ASS_MAL` varchar(14) NOT NULL,
  `NOM` varchar(14) DEFAULT NULL,
  `PRENOM` varchar(14) DEFAULT NULL,
  `DATE_NAISSANCE` varchar(14) DEFAULT NULL,
  `TEL` varchar(14) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ADRESSE` varchar(50) DEFAULT NULL,
  `POIDS` decimal(11,2) DEFAULT NULL,
  `GROUPAGE` varchar(10) DEFAULT NULL,
  `SEXE` enum('M','F') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donneur`
--

INSERT INTO `donneur` (`ID_DONNEUR`, `NUM_ASS_MAL`, `NOM`, `PRENOM`, `DATE_NAISSANCE`, `TEL`, `EMAIL`, `ADRESSE`, `POIDS`, `GROUPAGE`, `SEXE`) VALUES
(1, 'BOUG666666', 'Bouhal', 'Ghiad', '25/11/2022', '514-358-7430', 'bouhal_g@hotmail.com', '3821 barclay', '78.60', 'B-', 'M'),
(2, 'RAFM655555', 'Rafi', 'Monir', '25/11/2022', '514-358-7430', 'rafi_m@hotmail.com', '3821 barclay Montreal', '88.60', 'B-', 'M'),
(3, 'TAVA7777', 'Tavares', 'Antonio', '12/02/1960', '6666', '5555', '5555', '88.50', 'A-', 'M'),
(5, 'Desjardin', 'Pierre', '17/12/1955', 'DESP55121715', '514-327-2780', 'desjardin_p@hotmail.com', '275 rue notre dame', '85.00', 'O+', 'M'),
(6, 'Lacombe', 'Lyne', '01/02/1971', 'LACL71020119', '450-457-3890', 'lacombe_l@yahoo.com', '2855 avenue chomedie', '70.00', 'B-', 'M'),
(7, 'Girard', 'Jean', '15/03/1964', 'GIR64031516', '514-732-2145', 'Girard_j@ygmail.com', '75 boulevrad sherbrook', '92.00', 'B+', 'M'),
(8, 'Belanger', 'Robert', '07/05/1982', 'BELR8205072', '514-123-3453', 'Belanger_r@hotmail.com', '17855 boulvecvard st-laurent', '95.00', 'A+', ''),
(9, 'pic564052521', 'Pichet', 'Suzanne', '12/12/1978', '5143772430', 'pichet_s@hotmail.com', 'llllll', '82.00', 'B-', 'F'),
(10, 'mmmm555555', 'mmmm', 'pppp', '1223333', '555555', 'mmmm', 'mmmmm', '82.00', 'b-', 'M'),
(11, 'pppp', 'ppppp', 'ppppp', '33333', 'ppppp', 'ppppp', 'ppppp', '88.00', 'b', 'M');

-- --------------------------------------------------------

--
-- Table structure for table `lieucollecte`
--

CREATE TABLE `lieucollecte` (
  `ID_LIEU` int(11) NOT NULL,
  `NOM` varchar(20) DEFAULT NULL,
  `ADRESSE` varchar(50) DEFAULT NULL,
  `TYPE_LIEU` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lieucollecte`
--

INSERT INTO `lieucollecte` (`ID_LIEU`, `NOM`, `ADRESSE`, `TYPE_LIEU`) VALUES
(1, 'Aljisr', '3005 chomedy Laval', 'mosque'),
(2, 'rawda', '55222 laurentides', 'centre'),
(4, 'Madani', '5555 laurentides', 'Centre'),
(6, 'Sant? pour tous', '245 st-martin ouest', 'Clinique'),
(7, 'Belle Vie', '1300 Sherbrooke Est', 'Association'),
(8, 'Diamon', '7740 Cote des Neiges', 'Clinique'),
(9, 'Clinique Bomon', '1728 Rue Bomon', 'Clinique');

-- --------------------------------------------------------

--
-- Table structure for table `rdv`
--

CREATE TABLE `rdv` (
  `ID_RDV` int(11) NOT NULL,
  `ID_DONNEUR` int(11) NOT NULL,
  `ID_UTILISATEUR` int(11) NOT NULL,
  `DATE_RDV` varchar(14) DEFAULT NULL,
  `HEURE` varchar(40) DEFAULT NULL,
  `ETAT` enum('Annuler','En attente') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rdv`
--

INSERT INTO `rdv` (`ID_RDV`, `ID_DONNEUR`, `ID_UTILISATEUR`, `DATE_RDV`, `HEURE`, `ETAT`) VALUES
(1, 1, 6, '12/11/2024', '11H35', 'En attente'),
(2, 2, 6, '12/11/2023', '12H30', 'En attente'),
(3, 1, 6, '12/11/2025', '11h40', 'Annuler');

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `NOM` varchar(14) DEFAULT NULL,
  `PRENOM` varchar(14) DEFAULT NULL,
  `TEL` varchar(14) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `USERNAME` varchar(30) DEFAULT NULL,
  `MOTDEPASSE` varchar(20) DEFAULT NULL,
  `NIVEAU` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `NOM`, `PRENOM`, `TEL`, `EMAIL`, `USERNAME`, `MOTDEPASSE`, `NIVEAU`) VALUES
(6, 'adminNiveau1', 'adminNiveau1', '66666', 'adminNiveau1@adminNiveau1.com', 'adminNiveau1', 'adminNiveau1', 1),
(7, 'adminNiveau2', 'adminNiveau2', '4444', 'adminNiveau2@adminNiveau2.com', 'adminNiveau2', 'adminNiveau2', 2),
(9, 'adminNiveau3', 'adminNiveau3', '51455555', 'adminNiveau3@adminNiveau3.com', 'adminNiveau3', 'adminNiveau3', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `collecte`
--
ALTER TABLE `collecte`
  ADD PRIMARY KEY (`ID_COLLECTE`),
  ADD KEY `DON_ID_LIEU` (`ID_LIEU`);

--
-- Indexes for table `don`
--
ALTER TABLE `don`
  ADD PRIMARY KEY (`ID_DON`),
  ADD KEY `DON_ID_DONNEUR` (`ID_DONNEUR`),
  ADD KEY `DON_ID_COLLECTE` (`ID_COLLECTE`);

--
-- Indexes for table `donneur`
--
ALTER TABLE `donneur`
  ADD PRIMARY KEY (`ID_DONNEUR`);

--
-- Indexes for table `lieucollecte`
--
ALTER TABLE `lieucollecte`
  ADD PRIMARY KEY (`ID_LIEU`);

--
-- Indexes for table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`ID_RDV`),
  ADD KEY `RDV_ID_DONNEUR` (`ID_DONNEUR`),
  ADD KEY `RDV_ID_UTILISATEUR` (`ID_UTILISATEUR`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`ID_UTILISATEUR`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `collecte`
--
ALTER TABLE `collecte`
  MODIFY `ID_COLLECTE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `don`
--
ALTER TABLE `don`
  MODIFY `ID_DON` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `donneur`
--
ALTER TABLE `donneur`
  MODIFY `ID_DONNEUR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `lieucollecte`
--
ALTER TABLE `lieucollecte`
  MODIFY `ID_LIEU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `ID_RDV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `ID_UTILISATEUR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `collecte`
--
ALTER TABLE `collecte`
  ADD CONSTRAINT `DON_ID_LIEU` FOREIGN KEY (`ID_LIEU`) REFERENCES `lieucollecte` (`ID_LIEU`);

--
-- Constraints for table `don`
--
ALTER TABLE `don`
  ADD CONSTRAINT `DON_ID_COLLECTE` FOREIGN KEY (`ID_COLLECTE`) REFERENCES `collecte` (`ID_COLLECTE`),
  ADD CONSTRAINT `DON_ID_DONNEUR` FOREIGN KEY (`ID_DONNEUR`) REFERENCES `donneur` (`ID_DONNEUR`);

--
-- Constraints for table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `RDV_ID_DONNEUR` FOREIGN KEY (`ID_DONNEUR`) REFERENCES `donneur` (`ID_DONNEUR`),
  ADD CONSTRAINT `RDV_ID_UTILISATEUR` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID_UTILISATEUR`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
