create database IF NOT EXISTS hospital_management_system;
use hospital_management_system;

create table IF NOT EXISTS login(ID varchar(20), PW varchar(20));
select * from login;

insert into login value("ad8902","12345678");

create table patient_info(ID varchar(20), Number varchar(10),Name varchar(100), Gender varchar(20), Problem_Facing varchar(20), Room_number varchar(20), Time varchar(100), Deposite varchar(20));
select * from patient_info;

create table Room(room_no varchar(20), Availability varchar(20), Price varchar(20), Room_Type varchar(100));
select * from room;

insert into Room values("100","Available","500","G Bed 1");
insert into Room values("101","Available","500","G Bed 2");
insert into Room values("102","Available","500","G Bed 3");
insert into Room values("103","Available","500","G Bed 4");
insert into Room values("200","Available","1500","Private Room");
insert into Room values("201","Available","1500","Private Room");
insert into Room values("202","Available","1500","Private Room");
insert into Room values("203","Available","1500","Private Room");
insert into Room values("300","Available","3500","ICU Bed 1");
insert into Room values("301","Available","3500","ICU Bed 2");
insert into Room values("302","Available","3500","ICU Bed 3");
insert into Room values("303","Available","3500","ICU Bed 4");
insert into Room values("304","Available","3500","ICU Bed 5");
insert into Room values("305","Available","3500","ICU Bed 6");

drop table department;
create table department(Department varchar(100), Phone_no varchar(20));
select * from department;

insert into department values("Surgical department", "123456789");
insert into department values("Nursing department", "123456789");
insert into department values("Operation theater complex (OT)", "123456789");
insert into department values("Paramedical department", "123456789");
INSERT INTO department values("Surgical department", "123456789");
INSERT INTO department values("Nursing department", "12456789");
INSERT INTO department values("Emergency department", "125456789");
INSERT INTO department values("Cardiology department", "12656789");
INSERT INTO department values("Pediatrics department", "12756789");
INSERT INTO department values("Orthopedics department", "12856789");
INSERT INTO department values("Pharmacy department", "13056789");

create table emp_info(Name varchar(20), Age varchar(20), Phone_Number varchar(20), salary varchar(20), Gmail varchar(20), Aadhar_Number varchar(20));
select * from emp_info;

insert into emp_info values("Mr.Sharma","30","12357789","500000","sh849@gmail.com","123456789");
insert into emp_info values("Mr.Mishra","28","19743789","320000","mi934@gmail.com","976543234");
insert into emp_info values("Mrs.Pandey","29","19763457","390000","sp754@gmail.com","987653459");
insert into emp_info values("Mr.Sen","48","16787659","750000","as567@gmail.com","976543234");
insert into emp_info values("Mrs.Mishra","51","19789389","720000","mk689@gmail.com","976543234");
insert into emp_info values("Mrs.Das","43","19794329","550000","sd689@gmail.com","976543234");

create table Ambulance(Name varchar(20), Gender varchar(20), Car_name varchar(20), Available varchar(20), Location varchar(20));
insert into Ambulance values("ash","Female","ZEN","Available","area 16");
select * from Ambulance;