CREATE TABLE MOVIE (
    year NUMBER(4),
    title VARCHAR(100),
    studios	VARCHAR(100),
    producers VARCHAR(200),
    winner VARCHAR(3)
    ) as
SELECT * from CSVREAD('classpath:db/migration/movielist.csv',null,'fieldSeparator=;');


--########SQL solution with the DB could be manipulated to have single producers for movie. -----------------

--SELECT award1.PRODUCERS as producer,
--        MIN(award2.YEAR - award1.YEAR) as period,
--        award1.YEAR as previousWin,
--        MIN(award2.YEAR) as followingWin
--FROM MOVIE award1
--    left join MOVIE award2
--        on award2.YEAR > award1.YEAR
--        and award2.PRODUCERS = award1.PRODUCERS
--where award1.winner = 'yes'
--    AND award2.winner = 'yes'
--GROUP BY award1.PRODUCERS, award1.YEAR

