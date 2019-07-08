-- 1653006
-- Huynh  Thanh Binh

CREATE DATABASE LabFinal_1653006

GO 

USE LabFinal_1653006


CREATE TABLE Users 
(
    ID INT IDENTITY PRIMARY KEY,
    FullName varchar(255) not null,
    IdentityCard varchar(32) not null unique,
);

CREATE TABLE Accounts 
(   
    ID INT IDENTITY PRIMARY KEY,
    UserID int not null references Users (ID),
    Currency char(3) not null,
    Amount int not null default 0 check (Amount >= 0), -- c1

	UNIQUE (UserID, Currency),
);

CREATE TABLE Transactions
(
	ID INT IDENTITY PRIMARY KEY,
	FromAccountID INT REFERENCES Accounts (ID),
	ToAccountID INT REFERENCES Accounts (ID),
	Currency CHAR(3) NOT NULL,
	Amount INT NOT NULL default 0 check (Amount >= 0), -- c2
)

INSERT INTO Users(FullName, IdentityCard) VALUES 
('Mario Loz'   , '132787787'),
('Mike Kaya'   , '543542398'),
('Katsu Kono'  , '583439443'),
('Chinh Nguyen', '342875209');


INSERT INTO Accounts(UserID, Currency, Amount) VALUES 
(1, 'USD', 900000),
(2, 'SGD', 40000000),
(3, 'JPY', 500000000),
(4, 'VND', 180000000),
(4, 'USD', 100000),
(4, 'SGD', 20000),
(1, 'VND', 0);

INSERT INTO Transactions(FromAccountID, ToAccountID, Currency, Amount) VALUES 
(null, 1, 'USD', 1000000),
(null, 2, 'SGD', 40030000),
(null, 3, 'JPY', 400000000),
(null, 4, 'VND', 200000000),
(1, 5, 'USD', 100000),
(2, 6, 'SGD', 20000),
(4, null, 'VND', 10000000),
(4, null, 'VND', 10000000);

-- c3
GO
CREATE TRIGGER chk_UserAcc 
ON Accounts
for insert , update 
as
if UPDATE( Currency )
begin 
	if  exists (
		select *
		from  Accounts as a
		Group by  a.UserID
		having  COUNT(a.Currency)>= 10)
		raiserror ('A user cannot have more than 10 accounts among all currencies',500001,1)
end;

-- c4
GO
alter table Transactions 
add constraint tranfer_check check (FromAccountID != ToAccountID);

-- c5
go
create trigger chk_crrncyTrans 
on Transactions
for insert, update 
as 
if UPDATE(Currency)
begin
if exists (
	select *
	from Transactions as ts , Accounts as c1 , Accounts as c2
	where ts.FromAccountID = c1.ID AND ts.ToAccountID = c2.ID
		AND (c2.Currency != ts.Currency OR c1.Currency != ts.Currency ))
	raiserror ('An account cannot transfer money to another account which is different currency,
transaction currency must be the same as account’s currency',500002,1)
end;

--Q1

SELECT SUM(Amount)
FROM Transactions
WHERE FromAccountID = 4 or ToAccountID = 4
GROUP BY FromAccountID, ToAccountID

-- Q2
SELECT acc.ID, u.FullName
FROM Accounts AS acc, Users AS u
WHERE NOT EXISTS (
	SELECT *
	FROM Transactions tr
	WHERE tr.FromAccountID = u.ID OR tr.ToAccountID = u.ID
)

SELECT * FROM Accounts;
SELECT * FROM Users;
SELECT * FROM Transactions;

DROP TABLE Transactions
DROP TABLE Accounts
DROP TABLE Users

GO

ALTER DATABASE LabFinal_1653006 SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
USE master;
DROP DATABASE LabFinal_1653006;