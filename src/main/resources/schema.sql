DROP TABLE OAUTH_CLIENT_DETAILS CASCADE CONSTRAINT;
DROP TABLE OAUTH_CLIENT_TOKEN CASCADE CONSTRAINT;
DROP TABLE OAUTH_ACCESS_TOKEN CASCADE CONSTRAINT;
DROP TABLE OAUTH_REFRESH_TOKEN CASCADE CONSTRAINT;
DROP TABLE OAUTH_CODE CASCADE CONSTRAINT;
DROP TABLE OAUTH_APPROVALS CASCADE CONSTRAINT;
DROP TABLE CLIENT_DETAILS CASCADE CONSTRAINT;

CREATE TABLE OAUTH_CLIENT_DETAILS (
       CLIENT_ID VARCHAR2(255) PRIMARY KEY,
       RESOURCE_IDS VARCHAR2(255),
       CLIENT_SECRET VARCHAR2(255),
       SCOPE VARCHAR2(255),
       AUTHORIZED_GRANT_TYPES VARCHAR2(255),
       WEB_SERVER_REDIRECT_URI VARCHAR2(255),
       AUTHORITIES VARCHAR2(255),
       ACCESS_TOKEN_VALIDITY NUMBER(10,0),
       REFRESH_TOKEN_VALIDITY NUMBER(10,0),
       ADDITIONAL_INFORMATION VARCHAR2(2000),
       AUTOAPPROVE VARCHAR2(255)
);
 
CREATE TABLE OAUTH_CLIENT_TOKEN (
       AUTHENTICATION_ID VARCHAR2(255) PRIMARY KEY,
       TOKEN_ID VARCHAR2(255),
       TOKEN BLOB, 
       USER_NAME VARCHAR2(255),
       CLIENT_ID VARCHAR2(255)
);
 
CREATE TABLE OAUTH_ACCESS_TOKEN (
       AUTHENTICATION_ID VARCHAR2(255) PRIMARY KEY,
       TOKEN_ID VARCHAR2(255),
       TOKEN BLOB, 
       USER_NAME VARCHAR2(255),
       CLIENT_ID VARCHAR2(255),
       AUTHENTICATION BLOB,
       REFRESH_TOKEN VARCHAR2(255)
);
 
CREATE TABLE OAUTH_REFRESH_TOKEN (
       TOKEN_ID VARCHAR2(255),
       TOKEN BLOB,
       AUTHENTICATION BLOB
);
 
CREATE TABLE OAUTH_CODE (
       CODE VARCHAR2(255), 
       AUTHENTICATION BLOB
);
 
CREATE TABLE OAUTH_APPROVALS (
       USERID VARCHAR2(255),
       CLIENTID VARCHAR2(255),
       SCOPE VARCHAR2(255),
       STATUS VARCHAR2(10),
       EXPIRESAT DATE,
       LASTMODIFIEDAT DATE
);
 
CREATE TABLE CLIENT_DETAILS (
       APPID VARCHAR2(255) PRIMARY KEY,
       RESOURCEIDS VARCHAR2(255),
       APPSECRET VARCHAR2(255),
       SCOPE VARCHAR2(255),
       GRANTTYPES VARCHAR2(255),
       REDIRECTURL VARCHAR2(255),
       AUTHORITIES VARCHAR2(255),
       ACCESS_TOKEN_VALIDITY NUMBER(10,0),
       REFRESH_TOKEN_VALIDITY NUMBER(10,0),
       ADDITIONALINFORMATION VARCHAR2(2000),
       AUTOAPPROVESCOPES VARCHAR2(255)
);
