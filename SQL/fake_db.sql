USE ITSS
GO
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
INSERT INTO Media
VALUES ('Tha lam hat mua',3, 80000,80000,'img/CD/1.jpg'),
       ('Mai yeu', 3, 75000,80000,'img/CD/2.jpg'),
	   ('Dau chi rieng em', 3, 75000,80000,'img/CD/3.jpg'),
       ('Cafe sang', 3, 75000,80000,'img/CD/4.jpg'),
       ('Hoang hon thuc giac ', 3, 75000,80000,'img/CD/4.jpg'),
       ('Love song', 3, 75000,80000,'img/CD/5.jpg'),
       ('Nhu chua bat dau', 3, 75000,80000,'img/CD/6.jpg'),
       ('Dem nam mo pho', 3, 75000,80000,'img/CD/7.jpg'),
       ('Linh nghi gi', 3, 75000,80000,'img/CD/8.jpg'),
       ('Ngay xua anh noi', 3, 75000,80000,'img/CD/9.jpg'),
       ('Bien tinh', 3, 75000,80000,'img/CD/10.jpg'),
	   ('Con co be be', 3, 75000,80000,'img/CD/11.jpg')
---DVD
INSERT INTO Media
VALUES ('Tet van lang ca lang noi phet', 2, 75000,80000,'img/DVD/1.jpg'),
       ('Xuan hinh ken chong', 2, 75000,80000,'img/DVD/2.jpg'),
       ('No an tinh', 2, 75000,80000,'img/DVD/3.jpg'),
       ('Mai yeu', 2, 75000,80000,'img/DVD/4.jpg'),
       ('Loi vu', 2, 75000,80000,'img/DVD/5.jpg'),
	   ('Giot mau oan cuu', 2, 75000,80000,'img/DVD/6.jpg'),
       ('Manh le quan', 2, 75000,80000,'img/DVD/7.jpg'),
       ('Doc sương mu', 2, 75000,80000,'img/DVD/8.jpg'),
       ('Den khuya', 2, 75000,80000,'img/DVD/9.jpg'),
       ('That lam son ky an', 2, 75000,80000,'img/DVD/10.jpg')
----LP
INSERT INTO Media
VALUES ('Loi cua giong song', 4, 75000,80000,'img/LP/1.jpg'),
       ('Tuoi da buon', 4, 75000,80000,'img/LP/2.jpg'),
       ('Mot thoi da xa', 4, 75000,80000,'img/LP/3.jpg'),
       ('Mat thu', 4, 75000,80000,'img/LP/4.jpg'),
       ('A Thousand Suns', 4, 75000,80000,'img/LP/5.jpg'),
	   ('Noi gap go tinh yeu', 4, 75000,80000,'img/LP/6.jpg'),
       ('Khuc tinh xua', 4, 75000,80000,'img/LP/7.jpg'),
       ('vinyl ca sĩ Hà Anh Tuấn', 4, 75000,80000,'img/LP/8.jpg'),
       ('Duy Khanh va nhung tuyet tac Vinyl', 4, 75000,80000,'img/LP/9.jpg'),
       ('Le Cat Trong Ly viny', 4, 75000,80000,'img/LP/10.jpg')


-- Loai dia
INSERT INTO LoaiDia
VALUES('Blu-ray'),
		('HD-DVD');


-- insert bang physical
INSERT INTO Physical(IDMedia, Barcode, SoLuong, MoTa, NgayNhapKho, Size, KhoiLuong)
VALUES
       (3, '893460200109', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (23, '893460200127', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (24, '893460200137', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (25, '893460200147', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (26, '893460200157', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (27, '893460200167', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (28, '893460200177', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (29, '893460200187', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (30, '893460200197', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (44, '893460260107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (45, '893460270107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (46, '893460280107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (52, '893462200107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (53, '893463200107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (54, '893464200107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (55, '893465200107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2),
       (56, '893466200107', 1000, 'Hang moi nhap', '2021-01-12', '120*120*120', 1.2)








       