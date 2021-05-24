CREATE TABLE MOVIE (
    year NUMBER(4),
    title VARCHAR(100),
    studios	VARCHAR(100),
    producers VARCHAR(200),
    winner VARCHAR(3)
    ) as
SELECT * from CSVREAD('classpath:db/migration/movielistForTestIntegration.csv',null,'fieldSeparator=;');
