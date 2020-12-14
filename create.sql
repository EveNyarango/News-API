CREATE DATABASE departments;
\c departments
CREATE TABLE departments(
id SERIAL PRIMARY KEY,
departmentname VARCHAR,
departmentdescription VARCHAR,
noofemployees INT
);
CREATE TABLE users(
id SERIAL PRIMARY KEY,
username VARCHAR,
userposition VARCHAR,
userrole VARCHAR,
departmentId INT
);
CREATE TABLE news(
id SERIAL PRIMARY KEY,
title VARCHAR,
news VARCHAR,
author VARCHAR,
departmentId INT
);

