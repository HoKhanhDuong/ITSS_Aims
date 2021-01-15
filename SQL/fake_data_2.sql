CREATE DATABASE ITSS_DB
USE ITSS_DB
GO

INSERT INTO dbo.Loai
VALUES('Book'),('DVD'),('CD'),('LP')

-- Book
INSERT INTO Media(Ten,IDLoai,GiaTri,GiaCa,image)
VALUES ('Cho toi xin mot ve di tuoi tho', 1, 80000,80000,'img/book/1.jpg'),
       ('Nha gia kim', 1, 69000,69000,'img/book/2.jpg'),
	   ('Co hai con meo ngoi ben cua so', 1, 85000,80000,'img/book/3.jpg'),
       ('Minh la ca viec cua minh la boi', 1, 89000,80000,'img/book/4.jpg'),
       ('Tuoi tre dang gia bao nhieu', 1, 80000,80000,'img/book/5.jpg'),
       ('Khai hoan mon', 1, 120000,80000,'img/book/6.jpg'),
       ('Lam ban voi bau troi', 1, 220000,80000,'img/book/7.jpg'),
       ('Hoang tu be', 1, 75000,80000,'img/book/8.jpg'),
       ('Ngay xua co mot con bo', 1, 70000,80000,'img/book/9.jpg'),
       ('Trai Tre Đac Biet Cua Co Peregrine', 1, 98000,80000,'img/book/10.jpg'),
       ('Giet chet con chim nhai', 1, 108000,80000,'img/book/11.jpg'),
       ('Thien nga den', 1, 269000,80000,'img/book/12.jpg'),
       ('Su im lang cua bay cuu', 1, 90000,80000,'img/book/13.jpg'),
       ('Nguyen ly Peter', 1, 110000,80000,'img/book/14.jpg'),
       ('Bong ma danh vong', 1, 180000,80000,'img/book/15.jpg'),
       ('Den khong hat bong', 1,98000,80000,'img/book/16.jpg'),
       ('Nghe thuat thao tung doi phuong', 1, 120000,80000,'img/book/17.jpg'),
       ('Vo cung tan nhan vo cung yeu thuong', 1, 85000,80000,'img/book/18.jpg'),
       ('Khong gia dinh', 1, 120000,80000,'img/book/19.jpg'),
       ('Bi vo', 1, 75000,80000,'img/book/20.jpg'),
       ('So do', 1, 65000,80000,'img/book/21.jpg')


--- CD

---DVD

----LP

-----------------------------------------------------------------------------------------
INSERT INTO Bia
VALUES ('Hardcover'),
       ('Paperback')

INSERT INTO NgonNgu
VALUES ('Vietnamese'),
       ('English'),
	   ('Japanese')

INSERT INTO TheLoai
VALUES ('Novel',1),
	   ('Short story',1),
       ('Life skills',1),
       ('Economic',	1)


INSERT INTO Book
VALUES (1,2,'NXB Tre','2008-02-02',218,1,1),
       (2,2,'NXB Van Hoc','2008-02-02',228,1,1),
	   (3,2,'NXB Tre','2018-02-03',210,1,1),
	   (4,2,'NXB The Gioi','2016-12-02',192,1,3),
	   (5,2,'NXB Hoi Van Hoc','2014-07-16',198,1,3),
	   (6,2,'NXB Van Hoc','2011-07-22',256,1,2),
	   (7,1,'NXB Tre','2005-11-22',210,1,2),
	   (8,2,'NXB Hoi Van Hoc','2010-09-24',102,1,1),
	   (9,2,'NXB Tre','2017-07-02',212,1,4),
	   (10,2,'NXB Van Hoc','2019-07-06',428,1,4),
	   (11,1,'NXB Tre','2016-02-04',105,1,4),
	   (12,2,'NXB The Gioi','2018-08-02',325,1,1),
	   (13,2,'NXB Hoi Van Hoc','2013-07-14',412,1,2),
	   (14,1,'NXB Kinh Te HCM','2011-02-22',186,1,3),
	   (15,2,'NXB Tre','2015-07-12',120,1,4),
	   (16,2,'NXB Hoi Van hoc','2018-04-01',248,1,2),
	   (17,2,'NXB Tre','2015-07-02',218,1,1),
	   (18,1,'NXB The Gioi','2013-05-02',201,1,4),
	   (19,2,'NXB Dan Tri','2018-04-02',212,1,1),
	   (20,2,'NXB Hoi Van Hoc','2007-02-02',189,1,2),
	   (21,2,'NXB Van Hoc','2018-11-02',189,1,2)	   

INSERT INTO TacGia
VALUES ('Nguyen Nhat Anh'),
       ('Paulo Coelho'),
	   ('Takeshi Furukawa'),
	   ('Rosie Nguyen'),
	   ('Erich Maria Remarque'),
	   (N'Antoine De Saint-Exupéry'),
	   ('Camilo Cruz'),
	   ('Ransom Riggs'),
	   ('Harper Lee'),
	   ('Nassim Nicholas Taleb'),
	   ('Thomas Harris'),
	   ('Laurence J Peter,  Raymond Hull'),
	   ('Harry Reichenbach,  David Freedman'),
	   ('Watanabe Dzunichi'),
	   ('Yoki Kiyota, Minamihaba Shunsuke'),
	   ('Sara'),
	   ('Hector Malot'),
	   ('Nguyen Hong'),
	   ('Vu Trong Phung')

INSERT INTO SangTac(IDMedia,IDTacGia)
VALUES (2,2),(3,1),(4,3),(5,4),(6,5),(7,1),(8,6),(9,7),(10,8),
       (11,9),(12,10),(13,11),(14,12),(15,13),(16,14),(17,15),(18,16),(19,17),(20,18),(21,19)

-------------------------------------DVD------------------------------------
INSERT INTO Media(Ten,IDLoai,GiaTri,GiaCa,image)
VALUES ('Tet van lang ca lang noi phet', 2, 75000,80000,'img/DVD/1.jpg'),
       ('Xuan hinh ken chong', 2, 75000,80000,'img/DVD/2.jpg'),
       ('No an tinh', 2, 75000,80000,'img/DVD/3.jpg'),
       ('Mai yeu', 2, 75000,80000,'img/DVD/4.jpg'),
       ('Loi vu', 2, 75000,80000,'img/DVD/5.jpg'),
	   ('Giot mau oan cuu', 2, 75000,80000,'img/DVD/6.jpg'),
       ('Manh le quan', 2, 75000,80000,'img/DVD/7.jpg'),
       ('Doc sương mu', 2, 75000,80000,'img/DVD/8.jpg'),
       ('Den khuya', 2, 75000,80000,'img/DVD/9.jpg'),
       ('That lam son ky an', 2, 75000,80000,'img/DVD/10.jpg'),
	   ('Tinh yeu set denh', 2, 15000,30000,'img/DVD/11.jpg'),
	   ('Truong hoc am nhac', 2, 20000,35000,'img/DVD/12.jpg'),
	   ('Ho so chet', 2, 25000,45000,'img/DVD/13.jpg'),
	   ('Ke the mang', 2, 35000,70000,'img/DVD/14.jpg'),
	   ('Cuoc chien Thanh Troy', 2, 45000,100000,'img/DVD/15.jpg'),
	   ('Anh chi co minh em', 2, 54000,75000,'img/DVD/16.jpg'),
	   ('Thien menh anh hung', 2, 45000,66000,'img/DVD/17.jpg')

INSERT INTO TheLoai
VALUES ('Phim le',2),
	   ('Phim bo',2);

INSERT INTO LoaiDia
VALUES ('Blu-ray'),
       ('HD-DVD')

INSERT INTO DVD
VALUES (22,5,140,'Phuong Nam Phim', 1, 'Vietnamese'),
		(23,5,120,'Phuong Nam Phim', 1, 'Vietnamese'),
		(24,5,130,'20th Century Fox', 1, 'English'),
		(25,6,135,'Phuong Nam Phim', 1, 'Vietnamese'),
		(26,6,90,'Phuong Nam Phim', 1, 'Vietnamese'),
		(27,5,116,'Phuong Nam Phim', 1, 'English'),
		(28,6,114,'Phuong Nam Phim', 1, 'Vietnamese'),
		(29,5,146,'Phuong Nam Phim', 1, 'Vietnamese'),
		(30,6,134,'Phuong Nam Phim', 1, 'Vietnamese'),
		(31,6,183,'Phuong Nam Phim', 1, 'Vietnamese'),
		(32,6,156,'Phuong Nam Phim', 1, 'Vietnamese'),
		(33,6,141,'Phuong Nam Phim', 2, 'Vietnamese'),
		(34,5,135,'Phuong Nam Phim', 2, 'Vietnamese'),
		(35,5,120,'Phuong Nam Phim', 2, 'Vietnamese'),
		(36,6,140,'Phuong Nam Phim', 2, 'Vietnamese'),
		(37,5,170,'Phuong Nam Phim', 2, 'Vietnamese'),
		(38,6,210,'Phuong Nam Phim', 2, 'Vietnamese')

------------CD----------------------------------------------------------
INSERT INTO Media(Ten,IDLoai,GiaTri,GiaCa,image)
VALUES ('Tha lam hat mua',3, 80000,80000,'img/CD/1.jpg'),
       ('Mai yeu', 3, 75000,80000,'img/CD/2.jpg'),
	   ('Dau chi rieng em', 3, 75000,80000,'img/CD/3.jpg'),
       ('Cafe sang', 3, 75000,80000,'img/CD/ctx1vdtt.jpg'),
       ('Hoang hon thuc giac ', 3, 75000,80000,'img/CD/4.jpg'),
       ('Love song', 3, 75000,80000,'img/CD/5.jpg'),
       ('Nhu chua bat dau', 3, 75000,80000,'img/CD/6.jpg'),
       ('Dem nam mo pho', 3, 75000,80000,'img/CD/7.jpg'),
       ('Linh nghi gi', 3, 75000,80000,'img/CD/8.jpg'),
       ('Ngay xua anh noi', 3, 75000,80000,'img/CD/9.jpg'),
       ('Bien tinh', 3, 75000,80000,'img/CD/10.jpg'),
	   ('Con co be be', 3, 75000,80000,'img/CD/11.jpg')

INSERT INTO TheLoai
VALUES ('Techno',3),
	   ('Pop',3),
       ('Folk',3),
       ('R&B',3),
	   ('Ballad',3),
       ('V-pop',3),
       ('Pre-war',3),
	   ('Lyrical ',3),
	   ('Children Music',3)

INSERT INTO CD
VALUES (39,'Ben thanh Audio & Video',7),
       (40,'Phuong nam phim',8),
	   (41,'Phuong nam phim',9),
	   (42,'Phuong nam phim',10),
	   (43,'Ben Thanh Audio & Video',11),
	   (44,'Diem xua',12),
	   (45,'Viet Tan Studio',13),
	   (46,'Thuy Nga Paris',8),
	   (47,'phono',14),
	   (48,'Thuy Nga CD',15),
	   (49,'Phuong nam phim',12),
	   (50,'Lang van Cd',13)

INSERT INTO TacGia
VALUES ('Thu Phuong'),
       ('My Tam'),
	   ('Ha Anh Tuan'),
	   ('Ho Ngoc Ha'),
	   ('Che Linh'),
	   ('Huong Lan'),
	   ('Phi Nhung'),
	   ('Xuan Mai')
	 

iNSERT INTO BaiHat
VALUES ('Tha lam hat mua bay',20),
       ('Cung em vui dem nay',20),
	   ('Ngay em di',20),
	   ('Con mua lao xao',20),
	   ('Noi mua thu bat dau',20),
	   ('Co phai em mua thu Ha Noi',20),
	   ('Con gai bay gio',20),
	   ('Khi tinh yeu da mat',20),
	   ('Lung linh giot mua',20),
	   ('Dong song lo dang',20),
	   ('Bai ca dem',21),
	   ('Em cua toi',21),
	   ('Hai muoi,',21),
	   ('Yeu dai kho',21),
	   ('Toc nau moi tram',21),
	   ('Tinh mo',21),
	   ('Song',21),
	   ('Anh nhe',21),
	   ('Mai yeu ',21),
	   ('Khuc tinh yeu',21),
	   ('Hay noi voi em',21),
	   ('Bup be khong tinh yeu',21),
	   ('Giac mo tinh yeu',21),
	   ('Khung troi mong mo',21),
	   ('khi xua ta be',21),
	   ('Tinh xot xa thoi',21),
	   ('Thank you',21),
	   ('Chiec nhan co',21),
	   ('Mot lan va mai mai',21),
	   ('Anh sao buon',21),
	   ('Tinh yeu trong lanh',21),
	   ('Hat cho nguoi o lai',21),
	   ('Sac mau cuoc song',22),
	   ('Toi khong thay anh sang nay',22),
	   ('Xinh xinh',22),
	   ('Voi anh',22),
	   ('Luc nao anh cung nghi ve em',22),
	   ('Lam sao noi voi em',22),
	   ('Buoi cafe o ciao cafe',22),
	   ('Vong xoay',22),
	   ('Giac mo muon mau',21),
	   ('Nho',21),
	   ('Roi mai thuc giac',21),
	   ('Giac mo mua thu',21),
	   ('Co phai ta da chia tay',21),
	   ('Danh thuc mua thu',21),
	   ('Em da yeu anh',21),
	   ('Nu hon bat ngo',21),
	   ('Nhip dap dai kho',21),
	   ('Nguoi yeu dau oi',21),
	   ('Em hay ngu di',21),
	   ('Khong con yeu',21),
	   ('Roi anh se quen',21),
	   ('Vi dau',21),
	   ('Cu tuyet',23),
	   ('Cang truong thanh cang co don',23),
	   ('Anh nang trong anh',23),
	   ('Dau hang',23),
	   ('Anh bay gio nhat qua',23),
	   ('Can dong nuoc mat',23),
	   ('Khong the doi thay',23),
	   ('Anh dung quen',23),
	   ('Da sai tu luc dau ',23),
	   ('Roi mot ngay mình noi ve tinh yeu',23),
	   ('Nhu chua bat dau',20),
	   ('Dung hat khi buon',20),
	   ('Tinh huc ngay tho',20),
	   ('Mong cho',20),
	   ('Giua lai mua he',20),
	   ('Giay phut dau tien',20),
	   ('Mua thu',20),
	   ('Den ben anh',20),
	   ('Thuyen giay',20),
	   ('Dah roi ben ho ',20),
	   ('Khuc xuan',20),
	   ('Noi nho mua dong',20),
	   ('Cho toi lai tu dau',20),
	   ('Hoa tim ngay xua',20),
	   ('Que huong tuoi tho toi',20),
	   ('Im lang dem ha noi',20),
	   ('Mua thu',20),
	   ('Dong song sao',20),
	   ('Van hat loi tinh yeu',20),
	   ('Yeu em bang ca trai tim',20),
	   ('Hay den day nguoi',20),
	   ('Dem nam mo pho',20),
	   ('Moi ngay mot niem vui',20),
	   ('Giot le dai trang',24),
	   ('Vong gac dem suong',24),
	   ('Buon trong ki niem',24),
	   ('Noi buon sa mac',24),
	   ('Mot nguoi di',24),
	   ('Ngay vui qua mau',24),
	   ('Thuong tinh nha',24),
	   ('Mua mua di qua',24),
	   ('Doan cuoi tinh yeu',24),
	   ('Dem toc roi',24),
	   ('Tam su doi toi',25),
	   ('Gio xa lam roi',25),
	   ('Phuong buon',25),
	   ('Ngay xia anh noi',25),
	   ('Tim lai nguoi xua',25),
	   ('Tinh ngan doi bo',25),
	   ('Mua qua pho vang',25),
	   ('Hoa tim ngay xua',25),
	   ('Yeu mot minh',25),
	   ('Chuyen do khong em',25),
	   ('Chuyen hop tan',26),
	   ('Nhat ki doi toi',26),
	   ('Bien tuyet',26),
	   ('Thuong ve mien trung',26),
	   ('Dieu ly buon',26),
	   ('Tinh co găp nhau',26),
	   ('Giot le trong dem',26),
	   ('Dat khach que nguoi',26),
	   ('Chuyen hen ho',26),
	   ('Mot con vit',27),
	   ('Con heo dat',27),
	   ('Chau yeu ba',27),
	   ('Bo la tat ca',27),
	   ('Chu ech con',27),
	   ('Chu vit con',27),
	   ('Con ga trong',27),
	   ('Rua mat nhu meo',27),
	   ('Dan ga con',27),
	   ('Di hoc ve',27),
	   ('Chu meo con',27)



INSERT INTO DanhSachBaiHat
VALUES (39,1),(39,2),(39,3),(39,4),(39,5),(39,6),(39,7),(39,8),(39,9),(39,10),
       (40,11),(40,12),(40,13),(40,14),(40,15),(40,16),(40,17),(40,18),(40,19),(40,20),(40,21),
       (41,22),(41,23),(41,41),(41,25),(41,26),(41,27),(41,28),(41,29),(41,30),(41,31),(41,32),  
	   (42,33),(42,34),(42,35), (42,36),(42,37),(42,38),(42,39),(42,40),
	   (43,41),(43,42),(43,43), (43,44),(43,45),(43,46),(43,47),(43,48),(43,49),(43,50),(43,51),(43,52),(43,53),(43,54),
	   (44,55),(44,56),(44,57), (44,58),(44,59),(44,60),(44,61),(44,62),(44,63),(44,64),
	   (45,65),(45,66),(45,67), (45,68),(45,69),(45,70),(45,71),(45,72),(45,73),(45,74),(45,75),
	   (46,76),(46,77),(46,78), (46,79),(46,80),(46,81),(46,82),(46,83),(46,84),(46,85),(46,86),(46,87),
	   (47,88),(47,89),(47,90), (47,91),(47,92),(47,93),(47,94),(47,95),(47,96),(47,97),
	   (48,98),(48,99),(48,100), (48,101),(48,102),(48,103),(48,104),(48,105),(48,106),(48,107),
	   (49,108),(49,109),(49,110), (49,111),(49,112),(49,113),(49,114),(49,115),(49,116),
	   (50,117),(50,118),(50,119), (50,120),(50,121),(50,122),(50,123),(50,124),(50,125),(50,126),(50,127)



---------------------------------------LP----------------------
INSERT INTO Media(Ten,IDLoai,GiaTri,GiaCa,image)
VALUES ('Loi cua giong song', 4, 75000,80000,'img/LP/1.jpg'),
       ('Tuoi da buon', 4, 75000,80000,'img/LP/2.jpg'),
       ('Mot thoi da xa', 4, 75000,80000,'img/LP/3.jpg'),
       ('Mat thu', 4, 75000,80000,'img/LP/4.jpg'),
       ('A Thousand Suns', 4, 75000,80000,'img/LP/5.jpg'),
	   ('Noi gap go tinh yeu', 4, 75000,80000,'img/LP/6.jpg'),
       ('Khuc tinh xua', 4, 75000,80000,'img/LP/7.jpg'),
       ('vinyl ca sĩ Hà Anh Tuấn', 4, 75000,80000,'img/LP/8.jpg'),
       ('Duy Khanh va nhung tuyet tac Vinyl', 4, 75000,80000,'img/LP/9.jpg'),
       ('Le Cat Trong Ly viny', 4, 75000,80000,'img/LP/10.jpg'),
	   ('Mat biec Bang Kieu', 4, 1000000,1200000,'img/LP/11.jpg'),
	   ('Dap vo cay dan Duy Khanh', 4, 900000,1200000,'img/LP/12.jpg'),
	   ('Giot le Sau Che Linh', 4, 950000,1300000,'img/LP/13.jpg'),
	   ('Dia than Hoang Oanh', 4, 700000,800000,'img/LP/14.jpg'),
	   ('Diem xua Khanh Ly', 4, 1000000,1500000,'img/LP/15.jpg'),
	   ('Chuyen cua Lam', 4, 980000,1800000,'img/LP/16.jpg'),
	   ('Khuc tinh xua', 4, 500000,1000000,'img/LP/17.jpg'),
	   ('Tam 9', 4, 1000000,1300000,'img/LP/18.jpg'),
	   ('Co don', 4, 800000,1000000,'img/LP/19.jpg'),
	   ('Chieu mua bien gioi', 4, 980000,1200000,'img/LP/20.jpg'),
	   ('Rieng mot goc troi', 4, 800000,1250000,'img/LP/21.jpg'),
	   ('Mua nua dem', 4, 900000,1530000,'img/LP/22.jpg'),
	   ('FOLKLORE TAYLOR SWIFT', 4, 75000,80000,'img/LP/23.jpg'),
		('POST MALONE', 4, 75000,80000,'img/LP/24.jpg')

INSERT INTO TheLoai
VALUES ('Dia Than Nhac Viet Nam',4),
	   ('Dia Than Nhac Quoc Te',4)

INSERT INTO LD
VALUES(51,'Vinyl Store in Saigon',16),
		(52,'Record Store in Saigon',16),
		(53,'Vinyl Store in Saigon',16),
		(54,'Record Store in Saigon',16),
		(55,'Vinyl Store in Saigon',16),
		(56,'Record Store in Saigon',16),
		(57,'Vinyl Store in Saigon',16),
		(58,'Record Store in Saigon',16),
		(59,'Vinyl Store in Saigon',16),
		(60,'Record Store in Saigon',16),
		(61,'Vinyl Store in Saigon',16),
		(62,'Record Store in Saigon',16),
		(63,'Vinyl Store in Saigon',16),
		(64,'Record Store in Saigon',16),
		(65,'Vinyl Store in Saigon',16),
		(66,'Record Store in Saigon',16),
		(67,'Vinyl Store in Saigon',16),
		(68,'Record Store in Saigon',16),
		(69,'Vinyl Store in Saigon',16),
		(70,'Record Store in Saigon',16),
		(71,'Vinyl Store in Saigon',17),
		(72,'Record Store in Saigon',17),
		(73,'Vinyl Store in Saigon',17),
		(74,'Record Store in Saigon',17)

-------------------------------------USER------------------------------------
INSERT INTO Users(Email, Pass, isAdmin) VALUES('hongthao@gmail.com','12345678',0)