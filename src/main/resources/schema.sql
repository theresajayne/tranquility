USE TRANQUILITY;

CREATE TABLE UNIVERSE (
    UNIVERSE_ID INT PRIMARY KEY AUTO_INCREMENT,
    UNIVERSE_NAME VARCHAR(100)
);

CREATE TABLE REGION(
  REGION_ID INT PRIMARY KEY AUTO_INCREMENT ,
  REGION_NAME VARCHAR (100),
  UNIVERSE_ID INT
);

CREATE TABLE CONSTELLATION (
  CONSTELLATION_ID INT PRIMARY KEY AUTO_INCREMENT ,
  CONSTELLATION_NAME VARCHAR(100),
  REGION_ID INT
);

CREATE TABLE SYSTEM (
  SYSTEM_ID INT PRIMARY KEY AUTO_INCREMENT ,
  SYSTEM_NAME VARCHAR(100),
  CONSTELLATION_ID INT
);



