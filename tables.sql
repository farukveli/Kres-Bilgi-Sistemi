CREATE TABLE kid (
	kidId int PRIMARY KEY,
	firstName varchar(20),
	lastName varchar(20),
	birthDate date,
	breakfast boolean,
	lunch boolean,
	gender varchar(10),
	regType varchar(20),
	classroom varchar(20) REFERENCES classroom
);


CREATE TABLE guardian(
	kidId int,
	firstName varchar(20),
	lastName varchar(20),
	address varchar(60),
	phone varchar(20),
	depType varchar(20),
	FOREIGN KEY (kidId) REFERENCES kid ON DELETE CASCADE,
	CONSTRAINT pk_guardian PRIMARY KEY(kidId,firstName,lastName)
);


CREATE TABLE teacher(
	teachId int PRIMARY KEY,
	firstName varchar(20),
	lastName varchar(20),
	address varchar(60),
	phone varchar(20)
);

CREATE TABLE classroom (
	className varchar(20) PRIMARY KEY,
	quota int,
	numOfStudent int,
	teacherId int,
	FOREIGN KEY (teacherId) REFERENCES teacher ON DELETE CASCADE,
	CONSTRAINT quota_check CHECK (quota >5)
);

CREATE TABLE payment(
	kidId int PRIMARY KEY,
	payDate date,
	installment int,
	installmentNo int,
	amount int,
	FOREIGN KEY (kidId) REFERENCES kid ON DELETE CASCADE 
);

CREATE TABLE nonAttendances (
    kidId INTEGER,
    date DATE,
	PRIMARY KEY (kidId, date),
	FOREIGN KEY (kidId) REFERENCES kid ON DELETE CASCADE
);



CREATE VIEW PAYMENTSTATEMENT AS 
SELECT * FROM kid, payment WHERE kid.kidId = payment.kidId



CREATE SEQUENCE student_id_seq INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE teacher_id_seq INCREMENT BY 1 START WITH 1;
