-- update isBlock
ALTER TABLE USERS ADD isBlock Bit
ALTER TABLE DonHang ADD total float


CREATE DATABASE ITSS
GO

 USE ITSS
 GO
-- product
CREATE TABLE Loai(
	IDLoai INT IDENTITY(1,1) PRIMARY KEY,
	TenLoai VARCHAR(30)
)

 CREATE TABLE Media(
	IDMedia INT IDENTITY(1,1) PRIMARY KEY,
	Ten VARCHAR(50),
	IDLoai INT,
	GiaTri INT,
	GiaCa INT ,
	FOREIGN KEY (IDLoai) REFERENCES Loai(IDLoai)
)

CREATE TABLE TheLoai(
	IDTheLoai INT IDENTITY(1,1) PRIMARY KEY,
	Ten VARCHAR(50),
	IDLoai INT,
	FOREIGN KEY (IDLoai) REFERENCES Loai(IDLoai)
)

CREATE TABLE NgonNgu(
	IDNN INT IDENTITY(1,1) PRIMARY KEY,
	Ten VARCHAR(30)
)

CREATE TABLE TacGia(
	IDTacGia INT IDENTITY(1,1) PRIMARY KEY,
	Ten VARCHAR(100)
)

CREATE TABLE SangTac(
	IDTacGia INT,
	IDMedia INT,
	PRIMARY KEY (IDTacGia, IDMedia),
	FOREIGN KEY (IDTacGia) REFERENCES TacGia(IDTacGia),
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia)
)

CREATE TABLE Bia(
	IDBia INT IDENTITY(1,1) PRIMARY KEY,
	LoaiBia VARCHAR(30)
)
CREATE TABLE Book(
	IDMedia INT PRIMARY KEY,
	IDBia INT,
	NhaXB VARCHAR(100),
	NgayXB DATE,
	SoTrang INT,
	IDNN INT,
	IDTheLoai INT,
	FOREIGN KEY (IDBia) REFERENCES Bia(IDBia),
	FOREIGN KEY (IDNN) REFERENCES NgonNgu(IDNN),
	FOREIGN KEY (IDTheLoai) REFERENCES TheLoai(IDTheLoai)
)

CREATE TABLE DVD(
	IDMedia INT PRIMARY KEY,
	IDTheLoai INT,
	ThoiLuong FLOAT(2),
	Studio VARCHAR(50),
	IDNN INT,
	PhuDe VARCHAR(50),
	FOREIGN KEY (IDTheLoai) REFERENCES TheLoai(IDTheLoai),
	FOREIGN KEY (IDNN) REFERENCES NgonNgu(IDNN),
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia)
)

CREATE TABLE LoaiDia(
	IDDia INT IDENTITY(1,1) PRIMARY KEY,
	LoaiDia VARCHAR(30)
)

CREATE TABLE BaiHat(
	IDBaiHat INT IDENTITY(1,1) PRIMARY KEY,
	Ten VARCHAR(50),
	IDTacGia INT,
	FOREIGN KEY (IDTacGia) REFERENCES TacGia(IDTacGia)
)

CREATE TABLE DanhSachBaiHat(
	IDMedia INT,
	IDBaiHat INT,
	PRIMARY KEY (IDMedia, IDBaiHat),
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia),
	FOREIGN KEY (IDBaiHat) REFERENCES BaiHat(IDBaiHat)
)

CREATE TABLE CD (
	IDMedia INT PRIMARY KEY,
	HangGhiAm VARCHAR(200),
	IDTheLoai INT,
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia),
	FOREIGN KEY (IDTheLoai) REFERENCES TheLoai(IDTheLoai)
)

CREATE TABLE LD(
	IDMedia INT PRIMARY KEY,
	HangGhiAm VARCHAR(200),
	IDTheLoai INT,
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia),
	FOREIGN KEY (IDTheLoai) REFERENCES TheLoai(IDTheLoai)
)

CREATE TABLE Physical(
	IDMedia INT PRIMARY KEY,
	Barcode INT,
	SoLuong INT,
	MoTa VARCHAR(225),
	NgayNhapKho DATE,
	Size VARCHAR(10),
	KhoiLuong FLOAT(2),
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia)
)

-- users

CREATE TABLE Users(
	IDUser INT IDENTITY PRIMARY KEY,
	Email VARCHAR(30),
	Pass VARCHAR(30),
	isAdmin BIT
)


CREATE TABLE Actions(
	IDAction INT IDENTITY PRIMARY KEY,
	Ten VARCHAR(50)
)

CREATE TABLE History(
	IDHistory INT IDENTITY PRIMARY KEY,
	IDMedia INT,
	IDUser INT,
	IDAction INT,
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia),
	FOREIGN KEY (IDUser) REFERENCES Users(IDUser),
	FOREIGN KEY (IDAction) REFERENCES Actions(IDAction)
)



CREATE TABLE Cart(
	IDMedia INT,
	IDUser INT,
	SoLuong INT,
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia),
	FOREIGN KEY (IDUser) REFERENCES Users(IDUser)
)

CREATE TABLE DiaChi(
	IDAddress INT IDENTITY PRIMARY KEY,
	IDUser INT,
	Phone VARCHAR(11),
	Name VARCHAR(50),
	Diachi VARCHAR(225),
	FOREIGN KEY (IDUser) REFERENCES Users(IDUser)
)

CREATE TABLE DonHang(
	IDDonHang INT IDENTITY PRIMARY KEY,
	IDUser INT,
	IDAddress INT,
	TrangThai VARCHAR(30),
	GhiChu VARCHAR(225),
	FOREIGN KEY (IDUser) REFERENCES Users(IDUser),
	FOREIGN KEY (IDAddress) REFERENCES DiaChi(IDAddress)
)

ALTER TABLE DonHang
ALTER COLUMN TrangThai NVARCHAR(50);
ALTER TABLE DonHang
ADD CONSTRAINT df_TrangThai DEFAULT(N'Chờ') FOR TrangThai;

ALTER TABLE DonHang
ALTER COLUMN GhiChu NVARCHAR(225) not null ;


CREATE TABLE ThongTinDonHang(
	IDDonHang INT,
	IDMedia INT,
	SoLuong INT,
	Gia INT,
	FOREIGN KEY (IDDonHang) REFERENCES DonHang(IDDonHang),
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia) ON DELETE NO ACTION
)


CREATE TABLE LichSuThanhToan(
	ID INT IDENTITY PRIMARY KEY,
	IDDonHang INT,
	NoiDung VARCHAR(225),
	FOREIGN KEY (IDDonHang) REFERENCES DonHang(IDDonHang)
)

CREATE TABLE Sale(
	IDSale INT IDENTITY PRIMARY KEY,
	StartTime DATE,
	EndTime DATE,
	Title VARCHAR(225),
	Sale INT
)

CREATE TABLE MediaSale (
	IDSale INT,
	IDMedia INT,
	FOREIGN KEY (IDSale) REFERENCES Sale(IDSale),
	FOREIGN KEY (IDMedia) REFERENCES Media(IDMedia)
)

INSERT INTO Users(Email, Pass, isAdmin) VALUES('admin@gmail.com','12345678',1)

ALTER TABLE Media ADD image VARCHAR(225)

-- update vao ngay 22/12/2020
ALTER TABLE Media ADD ngay_nhap DATE

-- update vao ngay 23/12/2020;
ALTER TABLE Media
ALTER COLUMN ngay_nhap VARCHAR(50)

-- update Physical ngay 25/12/2020
ALTER TABLE Physical
ALTER COLUMN Barcode VARCHAR(100)
ALTER TABLE Physical
ALTER COLUMN KhoiLuong FLOAT(10)

ALTER TABLE Physical
ALTER COLUMN Size VARCHAR(100)
-- them truong cardnumber for users
ALTER TABLE Users ADD CardNumber VARCHAR(50)
ALTER TABLE Users ADD isBlock BIT

ALTER TABLE Users ADD CONSTRAINT df_isBlock DEFAULT(0) FOR isBlock;

-- update 02/01/2021
ALTER TABLE History ADD date_action DATE

-- fake data for table actions
INSERT INTO Actions (Ten)
VALUES ('Them'),('Sua'), ('Xoa')

-- Thay đổi kiểu của Name, Diachi
ALTER TABLE DiaChi
ALTER COLUMN Name NVARCHAR(50) NOT NULL;
ALTER TABLE DiaChi
ALTER COLUMN Diachi NVARCHAR(225) NOT NULL;

-- them truong vao DiaChi
ALTER TABLE DiaChi
ADD isMain BIT

-- update ngày 02-01-2021
ALTER TABLE SangTac
ADD CONSTRAINT fk_media
foreign key (IDMedia)
REFERENCES Media
ON DELETE CASCADE

ALTER TABLE Physical
ADD CONSTRAINT fk_media_physical
FOREIGN KEY (IDMedia)
REFERENCES Media
ON DELETE CASCADE

-- xoa
ALTER TABLE History
drop constraint fk_media_history


-- Them truong de co the xoa
alter table Media add deleted BIT default 0

update Media 
set deleted = 0
where IDMedia > 0


alter table DanhSachBaiHat
    add constraint fk_dsbh_media
foreign key (IDMedia)
references Media
on DELETE cascade

alter table ThongTinDonHang
add constraint fk_TTDH_Media
foreign key (IDMedia)
references Media
on delete cascade

alter table CD
add constraint fk_cd_media
foreign key (IDMedia)
references Media
on delete cascade

alter table DVD
add constraint fk_dvd_media
foreign key (IDMedia)
references Media
on delete cascade

alter table LD
add constraint fk_lp_media
foreign key (IDMedia)
references Media
on delete cascade

alter table TheLoai
add constraint fk_tl_loai
foreign key (IDLoai)
references Loai
on delete cascade

alter table History
add constraint fk_his_media_1D
foreign key (IDMedia)
references Media
on DELETE CASCADE

alter TABLE BaiHat
add constraint fk_tacgia_baihat
foreign key (IDTacGia)
references TacGia
on delete cascade

-- Them truong de co the xoa trong DanhSachBaiHat
alter table DanhSachBaiHat add deleted BIT DEFAULT 0

-- Xoa date trong history sau do them lai
alter table History
drop column date_action

alter table History
add date_action VARCHAR(50)

-- update table dvd
alter table DVD
add IDDia INT

alter table DVD
add constraint fk_dvd_dia
foreign key (IDDia)
references LoaiDia
on DELETE NO ACTION





-- xoa
ALTER TABLE History
drop constraint fk_History_IDMedia


-- update sale table
ALTER TABLE Sale 
DROP COLUMN Sale

ALTER TABLE MediaSale
ADD sale float