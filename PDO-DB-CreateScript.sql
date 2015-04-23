create table pdodb.users (
  UserID         varchar(15) not null primary key,
  UserPW         varchar(15) not null,
  EMail			 varchar(25) null
);

create table pdodb.roles (
  UserID         varchar(15) not null,
  role         varchar(15) not null,
  primary key (UserID, role)
);

 CREATE TABLE `pdodb`.`contact` (
  `prename` VARCHAR(32) NOT NULL,
  `lastname` VARCHAR(32) NOT NULL,
  `mail` VARCHAR(32) NOT NULL,
  `telephone` VARCHAR(32) NOT NULL,
  `mobilephone` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`prename`, `lastname`)); 
  
  CREATE TABLE `pdodb`.`usersettings` (
  `UserID` VARCHAR(32) NOT NULL,
  `DisplayType` VARCHAR(32) NULL,
  `PictureQuality` VARCHAR(32) NULL,
  PRIMARY KEY (`UserID`));

CREATE TABLE `pdodb`.`features` (
  `UserID` VARCHAR(32) NOT NULL,
  `Name` VARCHAR(32) NOT NULL,
  `Url` TEXT NULL,
  `IsEnabled` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`UserID`, `Name`));

CREATE TABLE `pdodb`.`notes` (
  `NoteID` BIGINT(32) NOT NULL,
  `UserID` VARCHAR(32) NOT NULL,
  `TEXT` VARCHAR(256) NULL,
  PRIMARY KEY (`NoteID`));  
  