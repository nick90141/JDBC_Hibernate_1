-- TASK_3-4--------------------------------------------------------------------------------------------------------------------------------------

CREATE DATABASE MyJoinsDB;

USE MyJoinsDB;

CREATE TABLE Employees (
employeeID int PRIMARY KEY,
name varchar (20) NOT NULL, 
telephone varchar (20) NOT NULL
);

INSERT INTO Employees (employeeID, name, telephone)
VALUES
('1', 'Anton', '0505555555'),
('2', 'Igor', '0506666666'),
('3', 'Viktor', '0507777777');

SELECT * FROM Employees;


CREATE TABLE Work_information (
employeeID int PRIMARY KEY,
salary varchar (20) NOT NULL, 
position varchar (20) NOT NULL,

FOREIGN KEY (employeeID) REFERENCES Employees(employeeID)
);

INSERT INTO Work_information (employeeID, salary, position)
VALUES
('1','50000', 'головний директор'),
('2','25000', 'менеджер'),
('3', '15000', 'робітник');

SELECT * FROM Work_information;

CREATE TABLE Personal_information (
employeeID int PRIMARY KEY,

martial_status varchar (20) NOT NULL, 
birthday varchar (20) NOT NULL, 
location varchar (20) NOT NULL,

FOREIGN KEY (employeeID) REFERENCES Employees(employeeID)

);

INSERT INTO Personal_information (employeeID, martial_status, birthday, location)
VALUES
('1', 'одружений', '1980-03-22', 'Kiev'),
('2', 'неодружений', '1992-01-18', 'Odessa'),
('3', 'неодружений', '2000-06-28', 'Lviv');

SELECT * FROM Personal_information;


SELECT * FROM Employees;
SELECT * FROM Work_information;
SELECT * FROM Personal_information;