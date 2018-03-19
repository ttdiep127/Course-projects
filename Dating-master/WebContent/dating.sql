-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2017 at 03:34 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dating`
--

-- --------------------------------------------------------

--
-- Table structure for table `imageofuser`
--

CREATE TABLE `imageofuser` (
  `id_image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_user` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `date_up` date NOT NULL,
  `script` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `info_user`
--

CREATE TABLE `info_user` (
  `id_user` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `weight` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `height` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `birthday` date NOT NULL,
  `sex` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `job` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` text COLLATE utf8_unicode_ci NOT NULL,
  `introduction` text COLLATE utf8_unicode_ci NOT NULL,
  `on_off` int(11) NOT NULL,
  `religion` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `info_user`
--

INSERT INTO `info_user` (`id_user`, `weight`, `height`, `birthday`, `sex`, `address`, `mail`, `job`, `status`, `introduction`, `on_off`, `religion`) VALUES
('user01', '57', '164', '1992-07-18', 'Nam', 'Đà Nẵng', 'haibkt2@gmail.com', 'Sinh viên', 'Luyện tập hăng say - Vận may sẽ đến', 'Chưa cập nhật', 1, 'Không'),
('user02', '60', '170', '2019-11-01', 'Nam', 'Đà Nẵng', '', '', '', '', 1, 'Không'),
('user03', '60', '167', '2004-12-05', 'Nữ', 'Quảng Bình', 'gatay123@gmail.com', 'Học Sinh', 'ahihi đồ ngốc', ':)', 0, 'Không'),
('user04', '57', '156', '1997-12-19', 'Nữ', 'Quảng Nam', 'gata123@gmail.com', 'Học sinh', 'why not me', '', 0, 'Không'),
('user05', 'Chưa cập nhật', 'Chưa cập nhật', '1995-10-15', 'Nữ', 'Đà Nẵng', 'diep@gmail.com', 'Lập Trình Viên', '', '', 1, 'Chưa cập nhật'),
('user06', 'Chưa cập nhật', 'Chưa cập nhật', '1992-08-16', 'Nữ', 'Đà Nẵng', 'nguyen@gmail.com', 'Lập Trình Viên', '', '', 1, 'Chưa cập nhật'),
('user07', 'Chưa cập nhật', 'Chưa cập nhật', '1992-08-16', 'Nữ', 'Đà Nẵng', 'nguyen@gmail.com', 'Lập Trình Viên', '', '', 1, 'Chưa cập nhật'),
('user08', 'Chưa cập nhật', 'Chưa cập nhật', '1992-08-16', 'Nữ', 'Đà Nẵng', 'nguyen@gmail.com', 'Lập Trình Viên', '', '', 1, 'Chưa cập nhật');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `id_mess` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `id_user_send` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_user_receive` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `date` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`id_mess`, `id_user_send`, `id_user_receive`, `content`, `date`, `status`) VALUES
('mess01', 'user01', 'user02', 'Tin nhắn từ user01 tới user02', '2017-12-05 04:29:41', 0),
('mess02', 'user01', 'user02', 'user01 gửi user02', '2017-12-06 04:39:25', 1),
('mess03', 'user02', 'user01', 'user02 gửi tới user01', '2017-12-06 05:21:34', 1),
('mess04', 'user02', 'user01', 'user 02 send to user 01', '2017-12-14 08:42:25', 1),
('mess05', 'user01', 'user02', '1 send to 2', '2017-12-15 11:31:47', 1),
('mess06', 'user02', 'user01', 'tn test', '2017-12-24 20:55:04', 1),
('mess07', 'user02', 'user01', 'demo tin nhắn', '2017-12-26 21:27:12', 1),
('mess08', 'user02', 'user01', 'xin chào', '2017-12-26 22:58:23', 1),
('mess09', 'user02', 'user05', 'konichiwa', '2017-12-26 22:59:20', 1),
('mess10', 'user02', 'user04', 'xin chào', '2017-12-26 22:59:37', 1),
('mess11', 'user02', 'user01', 'hello', '2017-12-26 23:01:11', 1),
('mess12', 'user02', 'user04', 'xin chào', '2017-12-26 23:03:24', 1),
('mess13', 'user02', 'user01', 'xin chào', '2017-12-26 23:04:23', 1),
('mess14', 'user02', 'user01', 'xin chào', '2017-12-26 23:09:26', 1);

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `idNews` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `title` text COLLATE utf8_unicode_ci NOT NULL,
  `trailer` text COLLATE utf8_unicode_ci NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `creat_up` date NOT NULL,
  `author` varchar(44) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `relationship_fr`
--

CREATE TABLE `relationship_fr` (
  `id_user_1` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_user_2` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `action_user` varchar(12) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `relationship_fr`
--

INSERT INTO `relationship_fr` (`id_user_1`, `id_user_2`, `status`, `action_user`) VALUES
('user01', 'user02', 'Bạn Bè', 'user01'),
('user01', 'user03', 'Bạn Bè', 'user01'),
('user02', 'user03', 'Đang chờ', 'user02'),
('user02', 'user04', 'Bạn Bè', 'user02');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `full_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `full_name`, `password`, `type`) VALUES
('user01', 'Thanh Hai', 'hai140494', 'admin'),
('user02', 'Hai Rua', 'hai140494', 'admin'),
('user03', 'Gà Tây', 'gatay123', 'member'),
('user04', 'Gà Ta', 'gata123', 'member'),
('user05', 'Trần', '123', 'member'),
('user06', 'Trần Nguyễn', '123', 'member'),
('user07', 'Trần Nguyễn', '123', 'member'),
('user08', 'Trần Nguyễn', '123', 'member');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `imageofuser`
--
ALTER TABLE `imageofuser`
  ADD PRIMARY KEY (`id_image`);

--
-- Indexes for table `info_user`
--
ALTER TABLE `info_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id_mess`);

--
-- Indexes for table `relationship_fr`
--
ALTER TABLE `relationship_fr`
  ADD UNIQUE KEY `uc_relationship` (`id_user_1`,`id_user_2`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
