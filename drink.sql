

--
-- Database: `qlcafe`

-- Table structure for table `ban`
create database drink;
use drink;
CREATE TABLE `ban` (
  `MaBan` int NOT NULL,
  `TenBan` varchar(55)  NOT NULL,
  `TrangThai` varchar(50) NOT NULL
) ;



INSERT INTO `ban` (`MaBan`, `TenBan`, `TrangThai`) VALUES
(1, 'Bàn 1', 'Đã đặt trước'),
(2, 'Bàn 2', 'Đang phục vụ'),
(3, 'Bàn 3', 'Trống'),
(4, 'Bàn 4', 'Đã đặt trước'),
(5, 'Bàn 5', 'Trống'),
(6, 'Bàn 6', 'Trống'),
(7, 'Bàn 7', 'Trống'),
(8, 'Bàn 8', 'Đang phục vụ'),
(9, 'Bàn 9', 'Trống'),
(10, 'Bàn 10', 'Đang phục vụ'),
(11, 'Bàn 11', 'Đã đặt trước'),
(13, 'Bàn 12', 'Trống'),
(14, 'Bàn 13', 'Đang phục vụ'),
(15, 'Bàn 14', 'Trống'),
(16, 'Bàn 15', 'Trống'),
(17, 'Bàn 16', 'Đang phục vụ'),
(18, 'Bàn 17', 'Trống'),
(19, 'Bàn 18', 'Trống'),
(25, 'Bàn 19', 'Đã đặt trước'),
(31, 'Bàn 20', 'Trống');

-- --------------------------------------------------------

--
-- Table structure for table `chitiethd`
--

CREATE TABLE `chitiethd` (
  `MaChiTietHD` int NOT NULL,
  `MaHoaDon` int NOT NULL,
  `MaMon` int NOT NULL,
  `SoLuong` int NOT NULL,
  `Gia` int NOT NULL
) ;

--
-- Dumping data for table `chitiethd`
--

INSERT INTO `chitiethd` (`MaChiTietHD`, `MaHoaDon`, `MaMon`, `SoLuong`, `Gia`) VALUES

(363, 192, 9, 1, 50000),
(375, 202, 32, 2, 60000),
(376, 203, 13, 1, 20000),
(380, 204, 40, 1, 20000),
(381, 205, 13, 1, 20000);

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHoaDon` int NOT NULL,
  `MaBan` int NOT NULL,
  `GioDen` datetime NOT NULL,
  `TongTien` int DEFAULT NULL,
  `TrangThai` int NOT NULL
) ;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`MaHoaDon`, `MaBan`, `GioDen`, `TongTien`, `TrangThai`) VALUES
(192, 17, '2021-03-18 09:28:05', NULL, 0),
(202, 8, '2021-04-06 11:17:57', NULL, 0),
(203, 2, '2021-04-06 11:18:04', NULL, 0),
(204, 10, '2021-04-06 11:18:12', NULL, 0),
(205, 14, '2021-04-06 11:18:37', NULL, 0);


-- --------------------------------------------------------

--
-- Table structure for table `nhommon`
--

CREATE TABLE `nhommon` (
  `MaLoai` int NOT NULL,
  `TenLoai` varchar(55)  NOT NULL,
  `MauSac` varchar(50) NOT NULL
) ;

--
-- Dumping data for table `nhommon`
--

INSERT INTO `nhommon` (`MaLoai`, `TenLoai`, `MauSac`) VALUES
(1, 'Cà phê', '#ac3939'),
(2, 'Nước đóng chai', '#66b3ff'),
(3, 'Nước-Lon', '#9900ff'),
(4, 'Lipton-Trà', '#ffcc00'),
(5, 'Sinh tố', '#40ff00'),
(6, 'Thứ khác', '#e68a00'),
(14, 'Đồ ăn nhanh', '#009966');

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int NOT NULL,
  `username` varchar(30)  NOT NULL,
  `password` varchar(30)  NOT NULL,
  `lv` int NOT NULL
) ;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `username`, `password`, `lv`) VALUES
(6, 'hoangquan', 'a', 1),
(7, 'nhanvien', '1', 2),
(10, 'nhanvien2', '1', 2),
(11, 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `thucdon`
--

CREATE TABLE `thucdon` (
  `MaMon` int NOT NULL,
  `TenMon` varchar(55)  NOT NULL,
  `MaLoai` int NOT NULL,
  `DonGia` int NOT NULL,
  `DVT` varchar(55) COLLATE utf8_unicode_ci NOT NULL
);

--
-- Dumping data for table `thucdon`
--

INSERT INTO `thucdon` (`MaMon`, `TenMon`, `MaLoai`, `DonGia`, `DVT`) VALUES
(7, 'Nâu đá', 1, 25000, 'Ly'),
(8, 'Nâu nóng', 1, 25000, 'Ly'),
(9, 'Cafe Sữa', 1, 50000, 'Ly'),
(10, 'Lọc đá vắt chanh', 2, 40000, 'Chậu'),
(11, 'Nâu lắc', 1, 69000, 'Ly'),
(12, 'Trà Xanh ', 2, 25000, 'Chai'),
(13, 'Trà C2', 2, 20000, 'Chai'),
(14, 'Chanh muối', 2, 20000, 'Chai'),
(15, 'Coca Cola', 3, 25000, 'Lon'),
(16, 'RedBull', 3, 25000, 'Lon'),
(17, 'Pepsi', 3, 20000, 'Lon'),
(18, 'Trà Gừng', 4, 25000, 'Ly'),
(19, 'Trà Dilmah', 4, 25000, 'Ly'),
(20, 'Trà chanh', 4, 15000, 'Ly'),
(21, 'Trà My', 4, 200000, 'Bát'),
(22, 'Sinh tố Xoài', 5, 30000, 'Ly'),
(23, 'Sinh tố bơ', 5, 35000, 'Ly'),
(24, 'Sinh tố Dưa Hấu', 5, 30000, 'Ly'),
(25, 'Sinh tố Mãng Cầu', 5, 35000, 'Ly'),
(26, 'Sinh tố chanh leo', 5, 30000, 'Ly'),
(27, 'Sinh tố dưa chuột', 5, 35000, 'Ly'),
(28, 'kẹo cao su', 6, 1000, 'cái'),
(29, 'Hướng Dương', 6, 15000, 'Đĩa'),
(30, 'Khoai chiên', 6, 15000, 'Miếng'),
(31, 'Vina', 6, 30000, 'Bao'),
(32, '555', 6, 60000, 'Bao'),
(33, 'Thăng Long', 6, 20000, 'Bao'),
(34, 'Cao cao nóng', 1, 25000, 'Ly'),
(35, 'Ca cao nguội', 1, 25000, 'Ly'),
(36, 'Đen đá', 1, 25000, 'Ly'),
(37, 'Đen nóng ', 1, 25000, 'Ly'),
(38, 'Bia Ken', 3, 25000, 'Lon'),
(40, 'Bia Sài Gòn', 3, 20000, 'Lon'),
(41, 'Bia Hà Nội', 3, 20000, 'Lon'),
(44, 'Bia Kenn', 3, 25000, 'Lon'),
(45, 'Bia Ken', 3, 25000, 'Lon');


--
-- Indexes for dumped tables
--

--
-- Indexes for table `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`);

--
-- Indexes for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MaChiTietHD`),
  ADD KEY `MaHoaDon` (`MaHoaDon`),
  ADD KEY `MaMon` (`MaMon`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Indexes for table `nhommon`
--
ALTER TABLE `nhommon`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `thucdon`
--
ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`MaMon`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ban`
--
ALTER TABLE `ban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT for table `chitiethd`
--
ALTER TABLE `chitiethd`
  MODIFY `MaChiTietHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=383;
--
-- AUTO_INCREMENT for table `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=207;
--
-- AUTO_INCREMENT for table `nhommon`
--
ALTER TABLE `nhommon`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`),
  ADD CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`MaMon`) REFERENCES `thucdon` (`MaMon`);

--
-- Constraints for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`);

--
-- Constraints for table `thucdon`
--
ALTER TABLE `thucdon`
  ADD CONSTRAINT `thucdon_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `nhommon` (`MaLoai`);

