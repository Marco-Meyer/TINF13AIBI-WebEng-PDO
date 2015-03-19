CREATE TABLE `pdodb`.`users` (
  `UserID` VARCHAR(32) NOT NULL,
  `UserPW` VARCHAR(32) NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `UserID_UNIQUE` (`UserID` ASC));

  CREATE TABLE `pdodb`.`usersettings` (
  `UserID` VARCHAR(32) NOT NULL,
  `DisplayType` VARCHAR(32) NULL,
  `PictureQuality` VARCHAR(32) NULL,
  PRIMARY KEY (`UserID`));

  ALTER TABLE `pdodb`.`users` 
ADD COLUMN `E-Mail` VARCHAR(45) NULL AFTER `UserPW`;

CREATE TABLE `pdodb`.`features` (
  `UserID` VARCHAR(32) NOT NULL,
  `Name` VARCHAR(32) NOT NULL,
  `Url` TEXT NULL,
  `IsEnabled` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`UserID`, `Name`));

  
  