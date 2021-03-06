--2.1 SELECT
SELECT * FROM EMPLOYEE; --SELECT ALL RECORDS FROM THE EMPLOYEE TABLE.

SELECT* FROM EMPLOYEE WHERE LASTNAME = 'King'; --SELECT ALL RECORDS FROM EMPLOYEE TABLE WHERE LAST NAME IS KING.

SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL; --SELECT ALL RECORDS FROM EMPLOYEE TABLE WHERE FIRST NAME IS ANDREW AND REPORTSTO IS NULL.

--2.2 ORDER BY
SELECT * FROM ALBUM
ORDER BY TITLE DESC; --SELECT ALL ALBUMS IN ALBUM TABLE AND SORT RESULT SET IN DESCENDING ORDER BY TITLE.

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC; --SELECT FIRST NAME FROM CUSTOMER AND SORT RESULT SET IN ASCENDING ORDER BY CITY

--2.3 INSERT INTO
INSERT INTO GENRE(GENREID, NAME) VALUES(26, 'ROCK'); --INSERT TWO NEW RECORDS INTO GENRE TABLE.
INSERT INTO GENRE(GENREID, NAME) VALUES(27, 'HEAVY METAL');

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(9, 'JUNG', 'YUNHA', 'Boss', 5 , TO_DATE('1994-05-07','yyyy-mm-dd'),TO_DATE('2012-04-09','yyyy-mm-dd'),'420 BLAZE IT STREET', 'TAMPA', 'FLORIDA', 'UNITED STATES', '30605', '404-595-3095', '493-304-4344','JUNGYUNHA1994@LIVE.COM'); --INSERT TWO NEW RECORDS INTO EMPLOYEE

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(10, 'Whelberg', 'Joe', 'MiddleMan', 9 , TO_DATE('1992-02-06','yyyy-mm-dd'),TO_DATE('2010-05-02','yyyy-mm-dd'),'420 Tampa Street', 'TAMPA', 'FLORIDA', 'UNITED STATES', '30605', '404-235-3043', '693-334-4364','Welbergmail@LIVE.COM');

INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(60,'YunHa', 'Jung', 'Asian Store inc' ,'4120 blaze it', 'TAMPA', 'FLORIDA', 'UNITED STATES', '30503', '349-403-4034', '343-435-3443','JUNGYUNHA1994@LIVE.COM', '5'); --INSERT TWO NEW RECORDS INTO CUSTOMER TABLE.

INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(61,'Phil', 'Jong', 'Asian Store Crop' ,'4120 sink it and drop it', 'TAMPA', 'FLORIDA', 'UNITED STATES', '30503', '365-453-4034', '332-434-3543','JUNGYUNHA94@LIVE.COM', '7');

--2.4 UPDATE
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' --UPDATE AARON MITCHELL IN CUSTOMER TABLE TO ROBERT WALTER.
WHERE CUSTOMERID = 32;

UPDATE ARTIST
SET NAME = 'CCR' -- UPDATE NAME OF ARTIST IN THE ARTIST TABLE ""CREEDENCE CLEARWATER REVIVAL" TO "CCR"
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%'; --SELECT ALL INVOICES WITH A BILLING ADDRESS LIKE "T%"

--2.6 BETWEEN
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50; --SELECT ALL INVOICES THAT HAVE A TOTAL BETWEEN 15 AND 50.

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04'; --SELECT ALL EMPLOYEES HIRED BETWEEN 1ST OF JUNE 2003 AND 1ST OF MARCH 2004.

--2.7 DELETE
DELETE FROM INVOICELINE
WHERE CUSTOMERID = 32;
DELETE FROM INVOICE --DELETE A RECORD IN CUSTOMER TABLE WHERE THE NAME IS ROBERT WALTER(THERE MAY BE CONSTRAINTS THAT REPLY ON THIS, FIND OUT HOW TO RESOLVE THEM).
WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1 SYSTEM DEFINED FUNCTIONS
ALTER SESSION SET TIME_ZONE = '-04:00';
ALTER SESSION  SET NLS_DATE_FORMAT = 'MM-DD-YYYY HH12:MI:SS';
SELECT SESSIONTIMEZONE, CURRENT_TIMESTAMP FROM DUAL;

--3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
SELECT AVG(TOTAL) FROM INVOICE;
SELECT MAX(TOTAL) FROM INVOICE;

--3.3 USER DEFINED SCALAR FUNCTIONS
CREATE OR REPLACE FUNCTION GET_AVG_UNIT
RETURN NUMBER AS AVERAGE_PRICE NUMBER(10,2);
BEGIN
    DECLARE DIVISOR NUMBER := 0;
    BEGIN
        SELECT SUM(UNITPRICE) INTO AVERAGE_PRICE FROM INVOICELINE;
        SELECT COUNT(DISTINCT INVOICELINEID) INTO DIVISOR FROM INVOICELINE;
        RETURN AVERAGE_PRICE/DIVISOR;
    END;
END;
/

--3.4 USER DEFINED TABLE VALUED FUNCTIONS
SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-JAN-1969');

--4.1 BASIC STORED PROCEDURE
CREATE OR REPLACE PROCEDURE GET_NAMES
(CURSOR_ OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN CURSOR_ FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
--4.2 STORED PROCEDURE INPUT PARAMETERS
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE
(EMP_ID IN NUMBER, INPUT_VAL IN VARCHAR2, COL_VAL IN VARCHAR2)
AS
BEGIN
    UPDATE EMPLOYEE SET COL_VAL = INPUT_VAL
    WHERE EMPLOYEEID = EMP_ID;
    COMMIT;
END;

--5.0 TRANSACTIONS

?


--6.1 TRIGGERS
CREATE OR REPLACE TRIGGER EMP_ADD_TRIG
AFTER
INSERT ON EMPLOYEE
BEGIN
COMMIT;
END;
/
CREATE OR REPLACE TRIGGER ALBUM_TRIG
AFTER INSERT ON ALBUM
BEGIN
    INSERT INTO EMPLOYEE (EMPLOYEEID, REPORTSTO, LASTNAME, FIRSTNAME) 
    VALUES(10, 5, 'BOB', 'JOE');
END;
/
CREATE OR REPLACE TRIGGER CUSTOMER_TRIG
AFTER DELETE ON CUSTOMER
BEGIN
    DELETE FROM EMPLOYEE WHERE LASTNAME = 'SCAPEGOAT';
END;
--7.1 INNER JOINS
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID; --INNER JOIN

--7.2 OUTER JOIN
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER LEFT JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT JOIN
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS JOIN

??

--7.5 SELF

SELECT e1.LASTNAME "Employee", e2.LASTNAME "Manager"
FROM EMPLOYEE e1 JOIN EMPLOYEE e2
ON  (e1.REPORTSTO = e2.EMPLOYEEID);