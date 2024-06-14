create database assignment_sof3021_ph41964
go
use assignment_sof3021_ph41964

go
CREATE TABLE Color (
    id int IDENTITY PRIMARY KEY,
    code varchar(20),
    name nvarchar(30),
    status bit
)

go
CREATE TABLE Size (
    id int IDENTITY PRIMARY KEY,
    code varchar(20),
    name nvarchar(30),
    status bit
)

go
CREATE TABLE Customer (
    id int IDENTITY PRIMARY KEY,
    code varchar(20),
    name nvarchar(50),
    phoneNumber varchar(12),
    status bit
)

go
CREATE TABLE Employee (
    id int IDENTITY PRIMARY KEY,
    code varchar(20),
    name nvarchar(50),
    username varchar(30),
    password varchar(20),
	role bit,
    status bit
)

go
CREATE TABLE Product (
    id int IDENTITY PRIMARY KEY,
    code varchar(30),
    name nvarchar(50),
    price bigint,
    status bit
)

go
CREATE TABLE Images (
    id int IDENTITY PRIMARY KEY,
    idProduct int,
    url nvarchar(255),
    status bit,
	FOREIGN KEY (idProduct) REFERENCES Product(id) 
)

go
CREATE TABLE ProductDetail (
    id int IDENTITY PRIMARY KEY,
    code varchar(50),
    idSize int,
    idColor int,
    idProduct int,
    quantity int,
    status bit,
    FOREIGN KEY (idSize) REFERENCES Size(id),
    FOREIGN KEY (idColor) REFERENCES Color(id),
    FOREIGN KEY (idProduct) REFERENCES Product(id)
)

go
CREATE TABLE Bill (
    id int IDENTITY PRIMARY KEY,
    idEmployee int,
    idCustomer int,
    purchaseDate date,
    status bit,
    FOREIGN KEY (idEmployee) REFERENCES Employee(id),
    FOREIGN KEY (idCustomer) REFERENCES Customer(id),
)

go
CREATE TABLE BillDetail (
    id int IDENTITY PRIMARY KEY,
    idBill int,
    idProductDetail int,
    quantity int,
    status bit,
    FOREIGN KEY (idBill) REFERENCES Bill(id),
    FOREIGN KEY (idProductDetail) REFERENCES ProductDetail(id)
)



INSERT INTO Color (code, name, status) VALUES 
('RED', N'Đỏ', 1),
('BLUE', N'Xanh dương', 1),
('GREEN', N'Xanh lá cây', 1),
('YELLOW', N'Vàng', 1),
('WHITE', N'Trắng', 1),
('BLACK', N'Đen', 1),
('PURPLE', N'Tím', 1),
('ORANGE', N'Cam', 1),
('PINK', N'Hồng', 1),
('BROWN', N'Nâu', 1);

INSERT INTO Size (code, name, status) VALUES 
('S', N'Nhỏ', 1),
('M', N'Trung bình', 1),
('L', N'Lớn', 1),
('XL', N'Rất lớn', 1),
('XS', N'Rất nhỏ', 1),
('XXL', N'Cực lớn', 1),
('FREE', N'Freesize', 1);

INSERT INTO Customer (code, name, phoneNumber, status) VALUES 
('C001', N'Nguyễn Văn A', '0123456789', 1),
('C002', N'Trần Thị B', '0987654321', 1),
('C003', N'Lê Văn C', '0369874123', 1),
('C004', N'Phạm Văn G', '0123456780', 1),
('C005', N'Lê Thị H', '0987654322', 1),
('C006', N'Nguyễn Văn I', '0369874125', 1);

INSERT INTO Employee (code, name, username, password, role, status) VALUES 
('E001', N'Trần Minh Thái', 'thaichan', 'Tranthai1', 1, 1),
('E002', N'Trần Văn E', 'admin', 'admin', 1, 1),
('E003', N'Lê Thị F', 'user', 'user', 0, 1),
('E004', N'Trần Thị K', 'employee4', 'password4', 0, 1),
('E005', N'Lê Văn L', 'employee5', 'password5', 1, 0),
('E006', N'Nguyễn Thị M', 'employee6', 'password6', 0, 1);

INSERT INTO Product (code, name, price, status) VALUES 
('P001', N'Áo polo nam dài tay', 150000, 1),
('P002', N'Áo polo nam thể thao', 250000, 1),
('P003', N'Áo thun dài tay', 350000, 1),
('P004', N'Quần dài nam kaki', 300000, 1),
('P005', N'Quần jean nam', 200000, 1),
('P006', N'Set đôn chề siêu ngầu', 18000000, 1);

INSERT INTO Images (idProduct, url, status) VALUES 
(1, 'ao_polo_nam_dai_tay1.png', 1),
(1, 'ao_polo_nam_dai_tay2.png', 1),
(1, 'ao_polo_nam_dai_tay3.png', 1),
(2, 'ao_polo_nam_the_thao.png', 1),
(2, 'ao_polo_nam_the_thao2.png', 1),
(2, 'ao_polo_nam_the_thao3.png', 1),
(2, 'ao_polo_nam_the_thao4.png', 1),
(3, 'ao_thun_dai_tay_vendo.png', 1),
(4, 'quan_dai_nam_kaki.png', 1),
(5, 'quan_jean_nam.png', 1),
(6, 'don_che.png', 1);

INSERT INTO ProductDetail (code, idSize, idColor, idProduct, quantity, status) VALUES 
('PD001', 1, 1, 1, 100, 1),
('PD002', 2, 2, 2, 120, 1),
('PD003', 3, 3, 3, 80, 1),
('PD004', 4, 1, 4, 90, 1),
('PD005', 5, 2, 5, 110, 1),
('PD006', 6, 3, 6, 70, 1);

INSERT INTO Bill (idEmployee, idCustomer, purchaseDate, status) VALUES 
(1, 1, '2024/1/24', 1),
(2, 2, '2024/2/13', 1),
(3, 3, '2024/3/11', 1),
(4, 4, '2024/4/4', 1),
(5, 5, '2024/5/1', 1),
(6, 6, '2024/5/20', 1);

INSERT INTO BillDetail (idBill, idProductDetail, quantity, status) VALUES 
(1, 1, 2, 1),
(1, 2, 1, 1),
(1, 3, 3, 1),
(2, 4, 2, 1),
(2, 5, 1, 1),
(3, 5, 1, 1),
(4, 5, 1, 1),
(4, 1, 1, 1),
(4, 6, 1, 1),
(5, 2, 1, 1),
(5, 3, 1, 1),
(6, 5, 1, 1),
(6, 6, 3, 1);
