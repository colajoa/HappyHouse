-- 지역 정보 코드
CREATE TABLE `dongcode` (
  `dongCode` varchar(10) NOT NULL,
  `sidoName` varchar(30) DEFAULT NULL,
  `gugunName` varchar(30) DEFAULT NULL,
  `dongName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`dongCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 아파트 매매 거래
CREATE TABLE `housedeal` (
  `no` bigint NOT NULL,
  `dealAmount` varchar(20) DEFAULT NULL,
  `dealYear` int DEFAULT NULL,
  `dealMonth` int DEFAULT NULL,
  `dealDay` int DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `floor` varchar(4) DEFAULT NULL,
  `cancelDealType` varchar(1) DEFAULT NULL,
  `aptCode` bigint DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `housedeal_aptCode_houseinfo_aptCode_fk_idx` (`aptCode`),
  CONSTRAINT `housedeal_aptCode_houseinfo_aptCode_fk` FOREIGN KEY (`aptCode`) REFERENCES `houseinfo` (`aptCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 아파트 정보
CREATE TABLE `houseinfo` (
  `aptCode` bigint NOT NULL,
  `buildYear` int DEFAULT NULL,
  `roadName` varchar(40) DEFAULT NULL,
  `roadNameBonbun` varchar(5) DEFAULT NULL,
  `roadNameBubun` varchar(5) DEFAULT NULL,
  `roadNameSeq` varchar(2) DEFAULT NULL,
  `roadNameBasementCode` varchar(1) DEFAULT NULL,
  `roadNameCode` varchar(7) DEFAULT NULL,
  `dong` varchar(40) DEFAULT NULL,
  `bonbun` varchar(4) DEFAULT NULL,
  `bubun` varchar(4) DEFAULT NULL,
  `sigunguCode` varchar(5) DEFAULT NULL,
  `eubmyundongCode` varchar(5) DEFAULT NULL,
  `dongCode` varchar(10) DEFAULT NULL,
  `landCode` varchar(1) DEFAULT NULL,
  `apartmentName` varchar(40) DEFAULT NULL,
  `jibun` varchar(10) DEFAULT NULL,
  `lng` varchar(30) DEFAULT NULL,
  `lat` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`aptCode`),
  UNIQUE KEY `UNIQUE` (`buildYear`,`apartmentName`,`jibun`,`sigunguCode`,`eubmyundongCode`) /*!80000 INVISIBLE */,
  KEY `houseinfo_dongCode_dongcode_dongCode_fk_idx` (`dongCode`) /*!80000 INVISIBLE */,
  CONSTRAINT `houseinfo_dongCode_dongcode_dongCode_fk` FOREIGN KEY (`dongCode`) REFERENCES `dongcode` (`dongCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 관심지역 정보
CREATE TABLE `area` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `userId` varchar(45) NOT NULL,
  `dongcode` varchar(45) NOT NULL,
  PRIMARY KEY (`idx`),
  KEY `userId` (`userId`),
  KEY `fk_dongCode_idx` (`dongcode`),
  CONSTRAINT `fk_dongCode` FOREIGN KEY (`dongcode`) REFERENCES `dongcode` (`dongCode`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 공지사항
CREATE TABLE `board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `author` varchar(20) NOT NULL,
  `content` varchar(511) NOT NULL,
  `created_at` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- QNA
CREATE TABLE `qna` (
  `id` int NOT NULL,
  `title` varchar(45) NOT NULL,
  `content` varchar(511) NOT NULL,
  `writer` varchar(45) NOT NULL,
  `created_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 유저 정보
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

