# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

MySql DDL Scripts
------------------------
CREATE TABLE `parent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(100) DEFAULT NULL,
  `receiver` varchar(100) DEFAULT NULL,
  `total_amount` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);
  
CREATE TABLE `child` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `paid_amount` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `child_FK` (`parent_id`),
  CONSTRAINT `child_FK` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`id`)
);

Rest Apis
-----------------------------
Parent api provided with pagination. DEFAULT size set to 2
http://localhost:8081/parent

{
  "data": [
    {
      "id": 1,
      "sender": "ABC",
      "receiver": "XYZ",
      "totalAmount": 200,
      "amountPaid": 100
    },
    {
      "id": 2,
      "sender": "XYZ",
      "receiver": "MNP",
      "totalAmount": 100,
      "amountPaid": 100
    }
  ],
  "totalItems": 7,
  "pages": 4,
  "currentPage": 0,
  "isFirst": true,
  "isLast": false
}

totalItems : Indicates the available entries in the system
pages : Indicates the total number od pages
currentPage : Indicates the current page requested
isFirst : Indicates that user is in first page of pagination
isLast : Indicates that user is in last page of pagination

http://localhost:8081/parent?page=3

{
 "data": [
  {
   "id": 7,
   "sender": "ABC",
   "receiver": "PQRS",
   "totalAmount": 200,
   "amountPaid": 0
  }
 ],
 "totalItems": 7,
 "pages": 4,
 "currentPage": 3,
 "isFirst": false,
 "isLast": true
}

Chils api does not have pagination 

http://localhost:8081/parent/1 (Requesting the child details for parent id '1')

[
 {
  "id": 1,
  "parent": {
   "id": 1,
   "sender": "ABC",
   "receiver": "XYZ",
   "totalAmount": 200,
   "amountPaid": 100
  },
  "paidAmount": 10
 },
 {
  "id": 2,
  "parent": {
   "id": 1,
   "sender": "ABC",
   "receiver": "XYZ",
   "totalAmount": 200,
   "amountPaid": 100
  },
  "paidAmount": 50
 },
 {
  "id": 3,
  "parent": {
   "id": 1,
   "sender": "ABC",
   "receiver": "XYZ",
   "totalAmount": 200,
   "amountPaid": 100
  },
  "paidAmount": 40
 }
]




