-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Erstellungszeit: 24. Jun 2017 um 17:16
-- Server-Version: 10.1.21-MariaDB
-- PHP-Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `IMSE`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `admin`
--

CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cart`
--

CREATE TABLE `cart` (
  `id` int(10) NOT NULL,
  `created` date NOT NULL,
  `customerid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `cart`
--

INSERT INTO `cart` (`id`, `created`, `customerid`) VALUES
(1, '2017-05-29', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `catalog`
--

CREATE TABLE `catalog` (
  `name` varchar(20) NOT NULL,
  `ArticleQuantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `catalog`
--

INSERT INTO `catalog` (`name`, `ArticleQuantity`) VALUES
('Jacke', 10),
('katname99', 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customer`
--

CREATE TABLE `customer` (
  `id` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `country` varchar(30) NOT NULL,
  `isClosed` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `customer`
--

INSERT INTO `customer` (`id`, `email`, `password`, `firstname`, `lastname`, `address`, `city`, `country`, `isClosed`) VALUES
(1, 'ugi@gmail.com', 'admin', 'ugur', 'yuruk', 'lagestrasse', 'vienna', 'Austria', 0),
(2, 'test@mail.com', '123456', 'ugi', 'yuruk', 'lagestrasse', 'wien', 'Österreich', 0),
(3, 'ugur@shopsecret.com', 'admin', 'ugur', 'yuruk', 'sensengasse', 'wien', 'Oesterreich', 0),
(4, 'Dfasdfasdf', '1234', 'And', 'Asdf', 'Adfadfasd', 'sdfd', 'sdff', 0),
(5, 'ugur.yuruk@mail.com', '1234', 'Ugur', 'Yürük', 'Lagestrasse', 'Wien', 'Österreich', 0),
(6, 'Asdfadfadf', '2222', 'Hahaah', 'Asdjfasdf', 'Adfadsf', 'Asdfasdf', 'Adfadf', 0),
(7, 'haji@haji.com', '12345', 'Haji', 'Osman', 'Asdf', 'Asdfasdf', 'sdfadf', 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `lineitem`
--

CREATE TABLE `lineitem` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` float NOT NULL,
  `cartid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `lineitem`
--

INSERT INTO `lineitem` (`id`, `name`, `quantity`, `price`, `cartid`) VALUES
(1, '', 1, 10, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `orderlineitem`
--

CREATE TABLE `orderlineitem` (
  `orderid` int(11) NOT NULL,
  `lineitemid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `orderr`
--

CREATE TABLE `orderr` (
  `id` int(10) NOT NULL,
  `total` float NOT NULL,
  `shipto` varchar(500) NOT NULL,
  `ordered` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `shipped` tinyint(1) NOT NULL,
  `paymentid` int(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `customerid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `orderr`
--

INSERT INTO `orderr` (`id`, `total`, `shipto`, `ordered`, `shipped`, `paymentid`, `status`, `customerid`) VALUES
(1, 100, 'währingerstrasse 90', '2017-05-29 16:12:33', 0, NULL, 'pending', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `details` varchar(500) NOT NULL,
  `total` float NOT NULL,
  `paiddate` date NOT NULL,
  `customerid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `payment`
--

INSERT INTO `payment` (`id`, `details`, `total`, `paiddate`, `customerid`) VALUES
(1, 'payment details Test test test', 199, '2017-05-29', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `product`
--

CREATE TABLE `product` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` float NOT NULL,
  `sex` varchar(10) NOT NULL,
  `supplierid` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `sex`, `supplierid`) VALUES
(2, 'ugi55', 3433, 'man', 1),
(10, 'Olleyyy', 46, 'man', 1),
(11, 'Adidas Jacke', 69.9, 'man', 1),
(12, 'sdfff', 33, 'woman', 1),
(13, 'Product xyzzy', 8999, 'man', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `productcatalog`
--

CREATE TABLE `productcatalog` (
  `catalogname` varchar(50) NOT NULL,
  `productid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `supplier`
--

CREATE TABLE `supplier` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `supplier`
--

INSERT INTO `supplier` (`id`, `name`) VALUES
(1, 'expresser');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indizes für die Tabelle `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customerid` (`customerid`);

--
-- Indizes für die Tabelle `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`name`);

--
-- Indizes für die Tabelle `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `lineitem`
--
ALTER TABLE `lineitem`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cartid` (`cartid`);

--
-- Indizes für die Tabelle `orderlineitem`
--
ALTER TABLE `orderlineitem`
  ADD PRIMARY KEY (`orderid`,`lineitemid`),
  ADD KEY `orderid` (`orderid`),
  ADD KEY `lineitemid` (`lineitemid`);

--
-- Indizes für die Tabelle `orderr`
--
ALTER TABLE `orderr`
  ADD PRIMARY KEY (`id`),
  ADD KEY `paymentid` (`paymentid`),
  ADD KEY `customerid` (`customerid`);

--
-- Indizes für die Tabelle `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customerid` (`customerid`);

--
-- Indizes für die Tabelle `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `supplierid` (`supplierid`);

--
-- Indizes für die Tabelle `productcatalog`
--
ALTER TABLE `productcatalog`
  ADD PRIMARY KEY (`catalogname`,`productid`),
  ADD KEY `productid` (`productid`),
  ADD KEY `catalogname` (`catalogname`);

--
-- Indizes für die Tabelle `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT für Tabelle `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT für Tabelle `lineitem`
--
ALTER TABLE `lineitem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT für Tabelle `orderr`
--
ALTER TABLE `orderr`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT für Tabelle `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT für Tabelle `product`
--
ALTER TABLE `product`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT für Tabelle `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `customerid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `lineitem`
--
ALTER TABLE `lineitem`
  ADD CONSTRAINT `cartid` FOREIGN KEY (`cartid`) REFERENCES `cart` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints der Tabelle `orderlineitem`
--
ALTER TABLE `orderlineitem`
  ADD CONSTRAINT `lineitemid` FOREIGN KEY (`lineitemid`) REFERENCES `lineitem` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderid` FOREIGN KEY (`orderid`) REFERENCES `orderr` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `orderr`
--
ALTER TABLE `orderr`
  ADD CONSTRAINT `customerid4` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `paymentid` FOREIGN KEY (`paymentid`) REFERENCES `payment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `cutomerid5` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `supplier` FOREIGN KEY (`supplierid`) REFERENCES `supplier` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

--
-- Constraints der Tabelle `productcatalog`
--
ALTER TABLE `productcatalog`
  ADD CONSTRAINT `catalogname` FOREIGN KEY (`catalogname`) REFERENCES `catalog` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
