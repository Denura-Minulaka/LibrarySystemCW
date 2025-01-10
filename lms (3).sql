-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Jan 09, 2025 at 08:03 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookID` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `price` varchar(20) NOT NULL,
  `publisherYear` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookID`, `name`, `publisher`, `price`, `publisherYear`) VALUES
('1', 'Software engineering', 'Robert Cencil', '500', '2000'),
('2', 'Database', 'Raghu Ramakrishnan', '1000', '2008'),
('3', 'GUI', 'Susan Flower', '1500', '1999'),
('4', 'Digital logic and computer design', 'Morris Mano', '2600', '2015'),
('5', 'EAD', 'John Hortan', '3000', '2021'),
('6', 'OS', 'Henry Rohith', '1200', '2000');

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `bookID` varchar(10) NOT NULL,
  `studentID` varchar(10) NOT NULL,
  `issueDate` varchar(20) NOT NULL,
  `dueDate` varchar(20) NOT NULL,
  `returnBook` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`bookID`, `studentID`, `issueDate`, `dueDate`, `returnBook`) VALUES
('1', '1', '01-12-2024', '15-12-2024', 'yes'),
('2', '1', '04-12-2024', '26-12-2024', 'yes'),
('2', '3', '17-12-2024', '25-12-2024', 'No'),
('4', '4', '02-12-2024', '23-12-2024', 'yes'),
('4', '4', '01-01-2025', '29-01-2025', 'yes'),
('5', '3', '03-01-2025', '21-01-2025', 'yes'),
('6', '5', '14-01-2025', '23-01-2025', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `fatherName` varchar(100) NOT NULL,
  `courseName` varchar(20) NOT NULL,
  `branchName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `name`, `fatherName`, `courseName`, `branchName`) VALUES
('1', 'Denura', 'Sujith', 'DSE', 'Colombo'),
('2', 'Hasindu', 'Kasun', 'DNE', 'Galle'),
('3', 'Pasindu', 'Kamal', 'DCSD', 'Rajagiriya'),
('4', 'Amal', 'Nuwan', 'HNDSE', 'Kirulapone'),
('5', 'Hiruna', 'Perera', 'DSE', 'Colombo'),
('6', 'Thenuka', 'Liyanage', 'DCSD', 'Colombo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
