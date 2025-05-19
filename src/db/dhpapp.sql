-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2025 at 05:11 PM
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
-- Database: `dhpapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_diagnosis`
--

CREATE TABLE `tbl_diagnosis` (
  `d_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `patient` varchar(255) NOT NULL,
  `diagnosis` varchar(255) NOT NULL,
  `doctor` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_diagnosis`
--

INSERT INTO `tbl_diagnosis` (`d_id`, `u_id`, `patient`, `diagnosis`, `doctor`) VALUES
(1, 44, 'TEST', 'TEST', 'TEST'),
(9, 48, 'kupal', 'test', 'null null');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_log`
--

CREATE TABLE `tbl_log` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `u_type` varchar(50) NOT NULL,
  `log_status` enum('Pending','Active','Inactive','') NOT NULL,
  `logout_time` timestamp NULL DEFAULT NULL,
  `log_description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_log`
--

INSERT INTO `tbl_log` (`log_id`, `u_id`, `u_username`, `login_time`, `u_type`, `log_status`, `logout_time`, `log_description`) VALUES
(169, 44, 'patient', '2025-04-28 23:39:47', 'Success - User Action', 'Active', NULL, 'New user registered: patient'),
(170, 45, 'admin', '2025-04-28 23:41:16', 'Success - User Action', 'Inactive', '2025-04-28 23:50:58', 'New user registered: admin'),
(171, 46, 'doctor', '2025-04-28 23:42:39', 'Success - User Action', 'Active', NULL, 'New user registered: doctor'),
(172, 46, 'doctor', '2025-04-28 23:46:06', 'Success - User Action', 'Active', NULL, 'diagnosed patient: Carlo'),
(173, 46, 'doctor', '2025-04-28 23:47:03', 'Medical Staff', 'Active', NULL, 'User Changed Their Details'),
(174, 45, 'admin', '2025-04-28 23:47:51', 'Admin', 'Inactive', '2025-04-28 23:50:58', 'User Changed Their Details'),
(175, 45, 'admin', '2025-04-28 23:50:00', 'Admin', 'Inactive', '2025-04-28 23:50:58', 'Admin Added a New Account: test'),
(176, 44, 'patient', '2025-04-28 23:52:19', 'Patient', 'Active', NULL, 'User Changed Their Details'),
(177, 45, 'admin', '2025-04-29 00:03:38', 'Admin', 'Inactive', '2025-04-29 00:04:09', 'User Changed Their Details'),
(178, 45, 'admin', '2025-04-29 00:04:05', 'Admin', 'Inactive', '2025-04-29 00:04:09', 'User Changed Their Details'),
(179, 44, 'patient', '2025-04-29 00:04:45', 'Patient', 'Active', NULL, 'User Changed Their Details'),
(180, 44, 'patient', '2025-04-29 00:07:08', 'Patient', 'Active', NULL, 'User Changed Their Details'),
(181, 47, 'testtest', '2025-04-29 00:07:53', 'Patient', 'Active', NULL, 'User Changed Their Details'),
(182, 45, 'admin', '2025-04-29 00:09:00', 'Admin', 'Inactive', '2025-04-29 00:09:10', 'User Changed Their Details'),
(183, 45, 'admin', '2025-04-29 03:42:56', 'Admin', 'Active', NULL, 'Admin Added a New Account: moganee'),
(184, 48, 'moganee', '2025-04-29 06:39:27', 'Success - User Action', 'Active', NULL, 'diagnosed patient: kupal'),
(185, 49, 'test123', '2025-05-19 11:42:22', 'Success - User Action', 'Inactive', '2025-05-19 11:45:06', 'New user registered: test123'),
(186, 49, 'test123', '2025-05-19 11:44:26', 'Patient', 'Inactive', '2025-05-19 11:45:06', 'User Changed Their Details');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_specialty`
--

CREATE TABLE `tbl_specialty` (
  `s_id` int(11) NOT NULL,
  `s_specialty` varchar(255) NOT NULL,
  `u_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_specialty`
--

INSERT INTO `tbl_specialty` (`s_id`, `s_specialty`, `u_id`) VALUES
(5, '', 46),
(6, '', 44);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(255) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `security_question` varchar(255) NOT NULL,
  `security_answer` varchar(255) NOT NULL,
  `u_image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`, `security_question`, `security_answer`, `u_image`) VALUES
(44, 'Carlo', 'Destinado', 'carlo@gmail.com', 'patient', '0mdfhcTmiPpPz6rLm7TDzugR3GK+enovXRN3nDF+bAk=', 'Patient', 'Active', 'What\'s the name of your First pet?', 'QEzde8EJxDL4zCRDtFvP6VmA9RByFcZFI25XeSmsPlI=', 'src/images/pfp1.jpg'),
(45, 'tung tung', 'sahur', 'admin@gmail.com', 'admin', '0mdfhcTmiPpPz6rLm7TDzugR3GK+enovXRN3nDF+bAk=', 'Admin', 'Active', 'What\'s the name of your First pet?', 'DmGbTNNyDgD9OQ1iktpVqGPeqFo0l5W76XZnsz/C98k=', 'src/images/pfp2.jpg'),
(46, 'Doc. Destinado', 'Carlo', 'doctor@gmail.com', 'doctor', '0mdfhcTmiPpPz6rLm7TDzugR3GK+enovXRN3nDF+bAk=', 'Medical Staff', 'Active', 'What\'s the name of your First pet?', 'rQ5BaE426Vp7FxjItL+8w1/G6nUrEtRBJwxJqrei3Co=', 'src/images/savedWallpaper.jpg'),
(47, 'tralalero', 'tralala', 'test@gmail.com', 'testtest', '0mdfhcTmiPpPz6rLm7TDzugR3GK+enovXRN3nDF+bAk=', 'Patient', 'Active', 'What\'s the lastname of your Mother?', 'n4bQgYhMfWWaL+qgxVrQFaO/TxsrC4Is0V1sFbDwCgg=', 'src/images/pfp4.jpg'),
(48, 'kupal', 'koh', 'a@gmail', 'moganee', '0mdfhcTmiPpPz6rLm7TDzugR3GK+enovXRN3nDF+bAk=', 'Patient', 'Active', 'What\'s your favorite Color?', 'kPP3e1CTgrOFy2MeVuAyRj3YCF0KkXkpoqnlJBGV5Nw=', 'moganee_pfp.jpg'),
(49, 'test', 'test', 'teset12345@gmail.com', 'test123', 'C92iRIG60W+6AjhY/YxYvGIt2d/GgBTpdKgoIGc/FQo=', 'Medical Staff', 'Active', 'What\'s the name of your First pet?', '2x1vOk0vlCuRBLOss+i5IR+E8sMfq+AI/OelPSktywA=', 'src/images/34de5788-f0f4-4018-9ce7-e528117042a5.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_diagnosis`
--
ALTER TABLE `tbl_diagnosis`
  ADD PRIMARY KEY (`d_id`),
  ADD UNIQUE KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl_log`
--
ALTER TABLE `tbl_log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_log_user_id` (`u_id`);

--
-- Indexes for table `tbl_specialty`
--
ALTER TABLE `tbl_specialty`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `uid` (`u_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_diagnosis`
--
ALTER TABLE `tbl_diagnosis`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `tbl_log`
--
ALTER TABLE `tbl_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=187;

--
-- AUTO_INCREMENT for table `tbl_specialty`
--
ALTER TABLE `tbl_specialty`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_diagnosis`
--
ALTER TABLE `tbl_diagnosis`
  ADD CONSTRAINT `uidd` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_log`
--
ALTER TABLE `tbl_log`
  ADD CONSTRAINT `fk_log_user_id` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_specialty`
--
ALTER TABLE `tbl_specialty`
  ADD CONSTRAINT `uid` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
