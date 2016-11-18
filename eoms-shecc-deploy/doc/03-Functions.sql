-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE DEFINER=`root`@`localhost` FUNCTION `getParentList`(queryId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
	DECLARE sParentList varchar(1000);
	DECLARE sParentTemp varchar(1000);
	DECLARE sParentNameList varchar(1000);
	DECLARE sParentNameTemp varchar(1000);

	SET sParentTemp =cast(queryId as CHAR);
	set sParentNameTemp='';
	WHILE sParentTemp is not null DO
		IF (sParentList is not null) THEN
			SET sParentList = concat(sParentTemp,sParentList);
			SET sParentNameList = concat(sParentNameTemp,sParentNameList);
		ELSE
			SET sParentList = concat(sParentTemp);
			SET sParentNameList = concat(sParentNameTemp);
		END IF;
		SELECT group_concat(up_id), group_concat(name)
			INTO sParentTemp,sParentNameTemp 
			FROM info_location
			where FIND_IN_SET(id, sParentTemp) > 0;
	END WHILE;
	select name into sParentNameTemp from info_location where id=sParentTemp;
	SET sParentNameList = concat(sParentNameTemp,sParentNameList);
      RETURN sParentNameList;
END