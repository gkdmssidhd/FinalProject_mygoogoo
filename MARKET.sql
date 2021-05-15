CREATE TABLE `market` (
  `SERVICE_NO` int NOT NULL AUTO_INCREMENT,
  `TYPE` int NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `CONTENT` varchar(255) NOT NULL,
  `IMAGE` varchar(20) NOT NULL,
  `REG_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LOCATION` varchar(20) NOT NULL,
  `JM_STATE` int NOT NULL,
  `PRICE` int NOT NULL,
  `ID` int NOT NULL,
  `CATEGORY` varchar(20) NOT NULL,
  `RV_STATE` varchar(20) NOT NULL,
  `CH_STATE` int NOT NULL,
  `SV_STATE` int NOT NULL,
  PRIMARY KEY (`SERVICE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT 
		  INTO MARKET
			   (
			   	TYPE
			  , TITLE
			  , CONTENT
			  , IMAGE
			  , REG_DATE
			  , UPDATE_DATE
			  , LOCATION
			  , JM_STATE
			  , PRICE
			  , ID
			  , CATEGORY
			  , RV_STATE
			  , CH_STATE
			  , SV_STATE
			 )
		VALUES (
			    1
			  , '1'
			  , '1'
			  , '1'
			  , now()
			  , now()
			  , '1'
			  , '1'
			  , 0
			  , '1'
			  , '1'
			  , '1'
			  , '1'
			  , '1'
			 )
