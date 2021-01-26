DROP TABLE CLIENTE;
DROP TABLE CONTATO;
DROP SEQUENCE S_ID_CONTATO;

CREATE TABLE CLIENTE 
(
NOME VARCHAR2(200) NOT NULL,
CPF VARCHAR2(11) NOT NULL,
SEXO VARCHAR2(50) NOT NULL,
IDADE NUMBER NOT NULL,
INTERESSES VARCHAR2(500),
CONSTRAINT CLIENTE_PK PRIMARY KEY (CPF ) ENABLE 
);

CREATE TABLE CONTATO 
(
  ID NUMBER NOT NULL,
  EMAIL VARCHAR2(200),
  TELEFONE VARCHAR2(20),
  CPF_CLIENTE VARCHAR2(11) NOT NULL,
  CONSTRAINT CONTATO_PK PRIMARY KEY  ( ID )  ENABLE,
  CONSTRAINT CONTATO_CLIENTE_FK FOREIGN KEY (CPF_CLIENTE )REFERENCES CLIENTE(CPF)ENABLE
);

CREATE SEQUENCE S_CONTATO INCREMENT BY 1 START WITH 1 MAXVALUE 9999999 MINVALUE 1;