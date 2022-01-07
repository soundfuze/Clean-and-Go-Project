CREATE TABLE IF NOT EXISTS Cleaning_Supplies_has_Service (
    Cleaning_Supplies_Name VARCHAR(45) NOT NULL,
    Service_S_IDnum INT NOT NULL,
    PRIMARY KEY (Cleaning_Supplies_Name , Service_S_IDnum)
);

CREATE TABLE IF NOT EXISTS Cleaning_Supplies (
    CS_name VARCHAR(45) NOT NULL PRIMARY KEY,
    des_of_Usage VARCHAR(45),
    Current_inventory VARCHAR(45),
    Safety_stock_level VARCHAR(45),
    Purchased_pur_transIDnum INT NOT NULL,
    Purchased_Supplier_Sup_IDnum INT NOT NULL,
    Cleaning_supplies_type VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Supplier (
    Sup_IDnum INT PRIMARY KEY,
    Sup_name VARCHAR(45),
    Sup_addr VARCHAR(45),
    Sup_phoneNum VARCHAR(45)
);

CREATE TABLE IF NOT EXISTS Purchased (
    pur_transIDnum INT NOT NULL PRIMARY KEY,
    pur_Date VARCHAR(45),
    pur_quanPurchased VARCHAR(45),
    pur_amountDue VARCHAR(45),
    pur_dueDate DATE,
    pur_Description VARCHAR(45),
    pur_deliveryDate DATE,
    Supplier_Sup_IDnum INT NOT NULL,
    Finance_shopID INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Rent (
    rent_IDnum INT NOT NULL PRIMARY KEY,
    rent_Date DATE,
    rent_Price INT,
    Finance_shopID INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Finance (
    shopID INT NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Equ_Maintenance_schedule (
    Equpment_Equ_IDnum INT NOT NULL PRIMARY KEY,
    Equ_sDate DATE,
    maintenancePrice INT,
    Finance_shopID INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Equipment (
    Equ_IDnum INT NOT NULL PRIMARY KEY,
    Equ_brandName VARCHAR(45),
    Equ_type VARCHAR(45),
    Equ_maintenanceSchedule VARCHAR(45),
    MonthsUntilReplace INT,
    Purchased_pur_transIDnum INT NOT NULL,
    Purchased_Supplier_Sup_IDnum INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Emp_schedule (
    Employee_Emp_IDnum INT NOT NULL,
    scheduleDate DATE NOT NULL,
    PRIMARY KEY (Employee_Emp_IDnum , scheduleDate)
);

CREATE TABLE IF NOT EXISTS Employee (
    Emp_IDnum INT NOT NULL PRIMARY KEY,
    Emp_name VARCHAR(45),
    Emp_addr VARCHAR(45),
    Emp_gender VARCHAR(45),
    Emp_DofEmployment DATE,
    Emp_position VARCHAR(45),
    Emp_availDay VARCHAR(45),
    Emp_salary INT,
    Finance_shopID INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Customer (
    C_IDnum INT NOT NULL PRIMARY KEY,
    C_name VARCHAR(45),
    C_addr VARCHAR(45),
    C_email VARCHAR(45),
    C_phoneNum VARCHAR(45),
    C_cardInfo VARCHAR(45),
    C_currentBalance INT,
    C_enter DATE,
    Finance_shopID INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Service (
    S_IDnum INT NOT NULL PRIMARY KEY,
    S_name VARCHAR(45),
    S_description VARCHAR(45),
    S_rateCharged INT,
    S_duration TIME,
    CS_date DATE,
    CS_amountCharged INT,
    CS_description VARCHAR(45),
    CS_satisfaction VARCHAR(45),
    Customer_C_IDnum INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Equipment_Activity_Use (
    Equipment_Equ_IDnum INT NOT NULL,
    Service_S_IDnum INT NOT NULL,
    startTime DATETIME,
    endTime DATETIME,
    PRIMARY KEY (Equipment_Equ_IDnum , Service_S_IDnum)
);


alter table Cleaning_Supplies_has_Service add foreign key (Cleaning_Supplies_Name) references Cleaning_Supplies (CS_name)
on delete cascade on update cascade;
alter table Cleaning_Supplies_has_Service add foreign key (Service_S_IDnum) references Service (S_IDnum)
on delete cascade on update cascade;

alter table Cleaning_Supplies add foreign key (Purchased_pur_transIDnum) references Purchased (pur_transIDnum)
on delete cascade on update cascade;
alter table Cleaning_Supplies add foreign key (Purchased_Supplier_Sup_IDnum) references Supplier (Sup_IDnum)
on delete cascade on update cascade;

alter table Purchased add foreign key (Supplier_Sup_IDnum) references Supplier (Sup_IDnum)
on delete cascade on update cascade;
alter table Purchased add foreign key (Finance_shopID) references Finance (shopID)
on delete cascade on update cascade;

alter table Rent add foreign key (Finance_shopID) references Finance (shopID)
on delete cascade on update cascade;

alter table Equ_Maintenance_schedule add foreign key (Finance_shopID) references Finance (shopID)
on delete cascade on update cascade;

alter table Equipment add foreign key (Purchased_pur_transIDnum) references Purchased (pur_transIDnum)
on delete cascade on update cascade;
alter table Equipment add foreign key (Purchased_Supplier_Sup_IDnum) references Supplier (Sup_IDnum)
on delete cascade on update cascade;

alter table Emp_schedule add foreign key (Employee_Emp_IDnum) references Employee (Emp_IDnum)
on delete cascade on update cascade;

alter table Employee add foreign key (Finance_shopID) references Finance (shopID)
on delete cascade on update cascade;

alter table Customer add foreign key (Finance_shopID) references Finance (shopID)
on delete cascade on update cascade;

alter table Service add foreign key (Customer_C_IDnum) references Customer (C_IDnum)
on delete cascade on update cascade;

alter table Equipment_Activity_Use add foreign key (Equipment_Equ_IDnum) references Equipment (Equ_IDnum)
on delete cascade on update cascade;
alter table Equipment_Activity_Use add foreign key (Service_S_IDnum) references Service (S_IDnum)
on delete cascade on update cascade;

INSERT into Finance VALUES ('1');

INSERT into Rent VALUES ('1', '2015-01-01', '4000', '1');
INSERT into Rent VALUES ('2', '2016-01-01', '4500', '1');
INSERT into Rent VALUES ('3', '2017-01-01', '5000', '1');
INSERT into Rent VALUES ('4', '2018-01-01', '5500', '1');
INSERT into Rent VALUES ('5', '2019-01-01', '6000', '1');
INSERT into Rent VALUES ('6', '2020-01-01', '6500', '1');
INSERT into Rent VALUES ('7', '2021-01-01', '7000', '1');

INSERT into Employee VALUES ('1', 'Jason Noh', '123 Happy Rd, Bellevue WA 98007', 'Male', '2020-01-01', 'Cashier', 'MWTh', '10000', '1');
INSERT into Employee VALUES ('2', 'Yong Kim', '123 Sad Rd, Bellevue WA 98007', 'Male', '2020-02-01', 'Cashier', 'MTW', '20000', '1');
INSERT into Employee VALUES ('3', 'Matthew Granger', '123 Angry Rd, Bellevue WA 98007', 'Male', '2020-03-01', 'Washer', 'MTWThFS', '50000', '1');
INSERT into Employee VALUES ('4', 'Qingfeng Wu', '123 Disappear Rd, Bellevue WA 98007', 'Female', '2020-04-01', 'Washer', 'MTWThFSaS', '50000', '1');
INSERT into Employee VALUES ('5', 'Ryder Hsu', '123 Taipei Rd, Bellevue WA 98007', 'Male', '2020-05-01', 'Washer', 'MWF', '30000', '1');
INSERT into Employee VALUES ('6', 'Andrew Lin', '123 Beijing Rd, Bellevue WA 98007', 'Male', '2020-06-01', 'Washer', 'TWF', '30000', '1');
INSERT into Employee VALUES ('7', 'Tae An', '123 Lynnwood Rd, Bellevue WA 98007', 'Male', '2020-07-01', 'Washer', 'MTWTh', '40000', '1');

INSERT into Emp_schedule VALUES ('1', '2021-11-29');
INSERT into Emp_schedule VALUES ('1', '2021-12-01');
INSERT into Emp_schedule VALUES ('1', '2021-12-02');
INSERT into Emp_schedule VALUES ('2', '2021-11-29');
INSERT into Emp_schedule VALUES ('2', '2021-11-30');
INSERT into Emp_schedule VALUES ('3', '2021-11-30');
INSERT into Emp_schedule VALUES ('3', '2021-12-01');
INSERT into Emp_schedule VALUES ('3', '2021-12-04');
INSERT into Emp_schedule VALUES ('7', '2021-11-29');
INSERT into Emp_schedule VALUES ('7', '2021-11-30');
INSERT into Emp_schedule VALUES ('7', '2021-12-01');
INSERT into Emp_schedule VALUES ('7', '2021-12-02');


INSERT INTO Supplier VALUES ('1', 'Costco', '278 Main Ave N, Las Vegas, Nevada', '425-309-1938');
INSERT INTO Supplier VALUES ('2', 'Mr. Clean', '10302 10TH AVE CT SO, Tacoma, WA 98444', '253-684-2938');
INSERT INTO Supplier VALUES ('3', 'Clorox', '1672 Spider Ave, Renton, WA, 98069', '800-238-3393');
INSERT INTO Supplier VALUES ('4', 'Viper', '319 South St, Renton, WA 83910', '322-229-5323');
INSERT INTO Supplier VALUES ('5', 'EagleClean', '929 East St, Bellingham, WA, 98073', '333-444-5531');
INSERT INTO Supplier VALUES ('6', 'Windex Corp.', '7302 Clean St, Busan, South Korea', '314-293-1931');
INSERT INTO Supplier VALUES ('7', 'Happy Clean', '672 72nd Ave, Hilo, HI, 80038', '337-448-4893');

INSERT INTO Purchased VALUES ('11', '2018-01-01', '20', '187.50', '2018-02-01', 'Monthly cleaning expenses', '2018-01-15', '1', '1');
INSERT INTO Purchased VALUES ('22', '2018-04-01', '30', '144.0', '2018-06-01', 'Monthly cleaning expenses', '2018-04-15', '2', '1');
INSERT INTO Purchased VALUES ('33', '2018-01-01', '2', '122.50', '2018-02-01', 'New washing machine', '2018-01-15', '3', '1');
INSERT INTO Purchased VALUES ('44', '2018-01-01', '40', '200.50', '2018-02-01', 'New hangers', '2018-01-15', '4', '1');
INSERT INTO Purchased VALUES ('55', '2018-01-01', '80', '1231.0', '2018-02-01', 'Monthly cleaning expenses', '2018-01-15', '5', '1');
INSERT INTO Purchased VALUES ('66', '2018-01-01', '24', '1837.50', '2018-02-01', 'Monthly cleaning expenses', '2018-01-15', '6', '1');
INSERT INTO Purchased VALUES ('77', '2018-02-01', '55', '127.50', '2018-03-01', 'Monthly cleaning expenses', '2018-02-15', '7', '1');

INSERT into Equipment VALUES ('1', 'Model A', 'Wash machine', '2021-11-23' , '20', '11', '1');
INSERT into Equipment VALUES ('2', 'Model B', 'Wash machine', '2021-11-23' , '20', '22', '2');
INSERT into Equipment VALUES ('3', 'Model C', 'Wash machine', '2021-11-23' , '20', '33', '3');
INSERT into Equipment VALUES ('4', 'Model D', 'Dryer', '2021-11-23' , '20', '44', '4');
INSERT into Equipment VALUES ('5', 'Model E', 'Dryer', '2021-11-23' , '20', '55', '5');
INSERT into Equipment VALUES ('6', 'Model F', 'Sewing machine', '2021-11-23' , '20', '66', '6');
INSERT into Equipment VALUES ('7', 'Model G', 'Sewing machine', '2021-11-23' , '20', '77', '7');

INSERT INTO Equ_Maintenance_schedule VALUES ('1', '2018-05-28', '400.00', '1');
INSERT INTO Equ_Maintenance_schedule VALUES ('2', '2018-06-28', '600.00', '1');
INSERT INTO Equ_Maintenance_schedule VALUES ('3', '2018-07-28', '400.00', '1');
INSERT INTO Equ_Maintenance_schedule VALUES ('4', '2018-08-28', '600.00', '1');
INSERT INTO Equ_Maintenance_schedule VALUES ('5', '2018-09-28', '400.00', '1');
INSERT INTO Equ_Maintenance_schedule VALUES ('6', '2018-10-28', '400.00', '1');
INSERT INTO Equ_Maintenance_schedule VALUES ('7', '2018-11-28', '400.00', '1');

INSERT INTO Customer VALUES ('1', 'James Bond', '123 Angry Rd, Bellevue, WA, 98007', 'soccerstar82@gmail.com', '252-123-4829', 'Visa', '100', '2021-12-04', '1');
INSERT INTO Customer VALUES ('2', 'Robert Hero', '123 Sad Rd, Bellevue, WA, 98007', 'kimmy82@gmail.com', '219-123-4829', 'MasterCard', '200', '2021-10-04', '1');
INSERT INTO Customer VALUES ('3', 'John Han', '123 Participation Rd, Bellevue, WA, 98007', 'happydance@gmail.com', '222-123-4829', 'PayPal', '300', '2021-07-04', '1');
INSERT INTO Customer VALUES ('4', 'Mary Garden', '123 Very Happy Rd, Bellevue, WA, 98007', 'beastmaster@gmail.com', '253-123-4829', 'MasterCard', '400', '2020-12-04', '1');
INSERT INTO Customer VALUES ('5', 'Jenny Shin', '123 Upset Pl, Bellevue, WA, 98007', 'soccerstar83@gmail.com', '228-123-4829', 'Visa', '500', '2020-10-04', '1');
INSERT INTO Customer VALUES ('6', 'Paulina Ann', '123 Glad St, Bellevue, WA, 98007', 'soccerstar84@gmail.com', '239-123-4829', 'PayPal', '600', '2020-07-04', '1');
INSERT INTO Customer VALUES ('7', 'Melody Hurber', '345 Sleepy St, Bellevue, WA, 98007', 'soccerstar85@gmail.com', '244-123-4829', 'Visa', '700', '2020-05-04', '1');

INSERT into Service VALUES ('1', 'Washing', 'clothes', '2.00', '1:00', '2021-11-23', '2', 'Washing clothes for 2 per hour', '5 star', '1');
INSERT into Service VALUES ('2', 'Drying', 'clothes', '2.00', '1:00', '2021-11-23', '2', 'Drying clothes for 2 per hour', '5 star', '2');
INSERT into Service VALUES ('3', 'Deep Cleaning', 'clothes', '3.00', '2:00', '2021-11-23', '2', 'Deep Cleaning clothes for 2 per hour', '5 star', '3');
INSERT into Service VALUES ('4', 'Repairing', 'clothes', '5.00', '3:00', '2020-12-23', '2', 'Reparing clothes for 2 per hour', '5 star', '4');
INSERT into Service VALUES ('5', 'Dying', 'clothes', '7.00', '5:00', '2020-11-23', '2', 'Dying clothes for 2 per hour', '5 star', '5');
INSERT into Service VALUES ('6', 'Bleaching', 'clothes', '7.00', '5:00', '2021-05-23', '2', 'Bleaching clothes for 2 per hour', '5 star', '6');
INSERT into Service VALUES ('7', 'Detailing', 'clothes', '10.00', '7:00', '2021-05-23', '2', 'Detailing clothes for 2 per hour', '5 star', '7');
INSERT into Service VALUES ('8', 'Detailing', 'clothes', '10.00', '7:00', '2021-05-23', '2', 'Detailing clothes for 2 per hour', '5 star', '7');

INSERT into Equipment_Activity_Use VALUES('1', '1', '2021-11-23', '2021-11-23');
INSERT into Equipment_Activity_Use VALUES('2', '2', '2021-11-23', '2021-11-23');
INSERT into Equipment_Activity_Use VALUES('3', '3', '2021-11-23', '2021-11-23');
INSERT into Equipment_Activity_Use VALUES('4', '4', '2021-11-23', '2021-11-23');
INSERT into Equipment_Activity_Use VALUES('5', '5', '2021-11-23', '2021-11-23');
INSERT into Equipment_Activity_Use VALUES('6', '6', '2021-11-23', '2021-11-23');
INSERT into Equipment_Activity_Use VALUES('7', '7', '2021-11-23', '2021-11-23');

INSERT into Cleaning_Supplies VALUES ('Bleach', 'Keep at room temperature', '12', '50', '11', '1', 'Liquid');
INSERT into Cleaning_Supplies VALUES ('Detergent', 'Keep at room temperature', '27', '50', '22', '2', 'Liquid');
INSERT into Cleaning_Supplies VALUES ('Brightener', 'Keep at room temperature', '66', '50', '33', '3', 'Liquid');
INSERT into Cleaning_Supplies VALUES ('Conditioner', 'Keep at room temperature', '75', '50', '44', '4', 'Liquid');
INSERT into Cleaning_Supplies VALUES ('OderDefenser', 'Keep at room temperature', '37', '50', '55', '5', 'Solid');
INSERT into Cleaning_Supplies VALUES ('DryerSheet', 'Keep at room temperature', '19', '50', '66', '6', 'Sheet');
INSERT into Cleaning_Supplies VALUES ('Oil', 'Keep at room temperature', '47', '50', '77', '7', 'Liquid');

INSERT into Cleaning_Supplies_has_Service VALUES ('Bleach', '1');
INSERT into Cleaning_Supplies_has_Service VALUES ('Detergent', '2');
INSERT into Cleaning_Supplies_has_Service VALUES ('Brightener', '3');
INSERT into Cleaning_Supplies_has_Service VALUES ('Conditioner', '4');
INSERT into Cleaning_Supplies_has_Service VALUES ('OderDefenser', '5');
INSERT into Cleaning_Supplies_has_Service VALUES ('DryerSheet', '6');
INSERT into Cleaning_Supplies_has_Service VALUES ('Oil', '7');

-- alter table Equipment_Activity_Use drop foreign key Equipment_Activity_Use_ibfk_2;
-- alter table Equipment_Activity_Use drop foreign key Equipment_Activity_Use_ibfk_1;
-- alter table Service drop foreign key Service_ibfk_1;
-- alter table Customer drop foreign key Customer_ibfk_1;
-- alter table Employee drop foreign key Employee_ibfk_1;
-- alter table Emp_schedule drop foreign key Emp_schedule_ibfk_1;
-- alter table Equipment drop foreign key Equipment_ibfk_2;
-- alter table Equipment drop foreign key Equipment_ibfk_1;
-- alter table Equ_Maintenance_schedule drop foreign key Equ_Maintenance_schedule_ibfk_1;
-- alter table Rent drop foreign key Rent_ibfk_1;
-- alter table Purchased drop foreign key Purchased_ibfk_2;
-- alter table Purchased drop foreign key Purchased_ibfk_1;
-- alter table Cleaning_Supplies drop foreign key Cleaning_Supplies_ibfk_2;
-- alter table Cleaning_Supplies drop foreign key Cleaning_Supplies_ibfk_1;
-- alter table Cleaning_Supplies_has_Service drop foreign key Cleaning_Supplies_has_Service_ibfk_2;
-- alter table Cleaning_Supplies_has_Service drop foreign key Cleaning_Supplies_has_Service_ibfk_1;

-- drop table Supplier;
-- drop table Finance;
-- drop table Cleaning_Supplies_has_Service;
-- drop table Service;
-- drop table Rent;
-- drop table Purchased;
-- drop table Equ_Maintenance_schedule;
-- drop table Equipment_Activity_Use;
-- drop table Equipment;
-- drop table Emp_schedule;
-- drop table Employee;
-- drop table Customer;
-- drop table Cleaning_Supplies;