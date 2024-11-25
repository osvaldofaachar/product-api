-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 25, 2024 at 10:02 AM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `product-api`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE IF NOT EXISTS `categorias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9qte5svl2i6n82lpdyyheoi1h` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `categorias`
--

INSERT INTO `categorias` (`id`, `nome`) VALUES
(2, 'Eletrodomésticos'),
(1, 'Eletrônicos'),
(5, 'Esportes'),
(3, 'Livros'),
(4, 'Roupas');

-- --------------------------------------------------------

--
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
CREATE TABLE IF NOT EXISTS `fornecedores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contato` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK63n2okh7dpmg7pjlwgdmfog70` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `fornecedores`
--

INSERT INTO `fornecedores` (`id`, `contato`, `nome`) VALUES
(1, 'fornecedora@empresa.com', 'Fornecedor Alexandre'),
(2, 'fornecedorb@empresa.com', 'Fornecedor B'),
(3, 'fornecedorc@empresa.com', 'Fornecedor C'),
(4, 'fornecedord@empresa.com', 'Fornecedor D'),
(5, 'fornecedore@empresa.com', 'Fornecedor E'),
(8, 'fornecedore@empresa.com', 'Fornecedor WWE777');

-- --------------------------------------------------------

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
CREATE TABLE IF NOT EXISTS `produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `estoque` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `preco` double NOT NULL,
  `categoria_id` bigint NOT NULL,
  `fornecedor_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8rqw0ljwdaom34jr2t46bjtrn` (`categoria_id`),
  KEY `FKje6bg3cu81l0e4nfprc0c7wwc` (`fornecedor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `produtos`
--

INSERT INTO `produtos` (`id`, `estoque`, `nome`, `preco`, `categoria_id`, `fornecedor_id`) VALUES
(1, 10, 'Produto 1', 100, 1, 1),
(2, 10, 'Produto 2', 100, 1, 1),
(3, 10, 'Produto 3', 100, 1, 1),
(4, 10, 'Game 4', 100, 1, 1),
(5, 110, 'Produto 5', 100, 2, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `produtos`
--
ALTER TABLE `produtos`
  ADD CONSTRAINT `FK8rqw0ljwdaom34jr2t46bjtrn` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id`),
  ADD CONSTRAINT `FKje6bg3cu81l0e4nfprc0c7wwc` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
