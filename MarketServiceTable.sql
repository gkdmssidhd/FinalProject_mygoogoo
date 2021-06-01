SELECT * FROM mygugu.market;

CREATE TABLE `market` (
  `SERVICE_NO` int NOT NULL AUTO_INCREMENT COMMENT '서비스 등록 글 번호',
  `TYPE` int NOT NULL COMMENT '삽니다/팝니다',
  `TITLE` varchar(100) NOT NULL COMMENT '서비스 제목',
  `CONTENT` varchar(255) NOT NULL COMMENT '제공하려는 서비스 내용, 제공받고 싶은 서비스 내용',
  `IMAGE` varchar(50) DEFAULT NULL COMMENT '사진(서비스 등록과 관련된)',
  `REG_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '처음 올린 날짜',
  `UPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정된 날짜',
  `LOCATION` varchar(100) DEFAULT NULL COMMENT '서비스 제공자의 장소',
  `JM_STATE` int DEFAULT NULL COMMENT '올린 게시글에 대해 다른사람들이 얼마나 찜을 해놓았는지 얼마나 인기서비스인지 보여주기 위함.',
  `PRICE` int NOT NULL COMMENT '등록한 서비스 가격',
  `ID` int DEFAULT NULL COMMENT '작성자 아이디\\\\nid는 여기서는 기본값 필요없음(작성자는 한명이 여러글을 올려야되니까)\\\\n',
  `CATEGORY` varchar(200) NOT NULL COMMENT '카테고리(작성한 글과 관련된 카테고리)',
  `CATEGORYS` varchar(200) NOT NULL COMMENT '카테고리 배열로 담기',
  `RV_STATE` varchar(50) DEFAULT NULL COMMENT '예약상태(구구중, 예약중, 예약완료, 판매완료)',
  `CH_STATE` int DEFAULT NULL COMMENT '채팅상태(1:1)채팅',
  `SV_STATE` int DEFAULT NULL COMMENT '작성자의 서비스상태',
  PRIMARY KEY (`SERVICE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
CREATE TABLE `market` (
  `SERVICE_NO` int NOT NULL AUTO_INCREMENT COMMENT '서비스 등록 글 번호',
  `TYPE` int NOT NULL COMMENT '삽니다/팝니다',
  `TITLE` varchar(100) NOT NULL COMMENT '서비스 제목',
  `CONTENT` varchar(255) NOT NULL COMMENT '제공하려는 서비스 내용, 제공받고 싶은 서비스 내용',
  `IMAGE` varchar(50) DEFAULT NULL COMMENT '사진(서비스 등록과 관련된)',
  `REG_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '처음 올린 날짜',
  `UPDATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정된 날짜',
  `LOCATION` varchar(100) DEFAULT NULL COMMENT '서비스 제공자의 장소',
  `JM_STATE` int DEFAULT NULL COMMENT '올린 게시글에 대해 다른사람들이 얼마나 찜을 해놓았는지 얼마나 인기서비스인지 보여주기 위함.',
  `PRICE` int NOT NULL COMMENT '등록한 서비스 가격',
  `ID` int DEFAULT NULL COMMENT '작성자 아이디\\\\\\\\\\\\\\\\nid는 여기서는 기본값 필요없음(작성자는 한명이 여러글을 올려야되니까)\\\\\\\\\\\\\\\\n',
  `CATEGORY` varchar(200) NOT NULL COMMENT '카테고리(작성한 글과 관련된 카테고리)',
  `RV_STATE` varchar(50) DEFAULT NULL COMMENT '예약상태(구구중, 예약중, 예약완료, 판매완료)',
  `CH_STATE` int DEFAULT NULL COMMENT '채팅상태(1:1)채팅',
  `SV_STATE` int DEFAULT NULL COMMENT '작성자의 서비스상noticeboard태',
  PRIMARY KEY (`SERVICE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE noticeReply(
reply_id int not null primary key auto_increment,
board_id int not null,
writer_id int not null,
content varchar(500) not null,
regdate timestamp default current_timestamp 
);
CREATE TABLE noticeBoard (
board_id int not null primary key auto_increment,
title varchar(100) not null,
content varchar(2000) not null,
writer varchar(50) not null,
regdate timestamp default current_timestamp
);  

truncate MARKET;

insert into member(email,password,name,nickname,phone_number,gender,age,location,authority,join_date)
values(123,123,123,'하은쓰',123,'남성',20,'종로구',1,current_timestamp());


CREATE TABLE `mygugu`.`member` (
  `id` INT NOT NULL auto_increment,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `nickname` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(100) NOT NULL,
  `gender` VARCHAR(10) NOT NULL, 
  `age` INT NOT NULL,
  `location` VARCHAR(100) NOT NULL,
  `photo` VARCHAR(100) NULL,
  `authority` INT NOT NULL, 
  `join_date` TIMESTAMP default current_timestamp,
  `role` VARCHAR(255),
  PRIMARY KEY (`id`));
