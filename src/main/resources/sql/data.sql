
INSERT INTO PUBLIC.USER(USER_ID, USERNAME, PASSWORD) VALUES
('1', 'admin',
'$2a$10$EvtSzzGF1zjlYGdLFnFBO.N/R5qbi3yxksRBy99otIPxEtoFOgxAu'), -- admin
('2', 'anotheradmin',
'$2a$10$VBzKSLlzyjZgiYCWBMInWeIsLbuUMPkPLg3eCVNlHYlBqFvYtF0Cu'); -- anotheradmin

INSERT INTO PUBLIC.CITY(CITY_ID, NAME, CREATION_DATE, USER_ID) VALUES
('1', 'Gdansk', '2019-05-13', '1'),
('2', 'Poznan', '2019-07-20', '2'),
('3', 'Warsaw', '2018-04-13', '1'),
('4', 'Wroclaw', '2017-03-02', '1'),
('5', 'Lublin', '2017-04-10', '2'),
('6', 'Zakopane', '2017-04-10', '1'),
('7', 'Bydgoszcz', '2017-04-10', '2'),
('8', 'Olsztyn', '2017-04-10', '1'),
('9', 'Cracow', '2017-04-10', '2'),
('10', 'Mragowo', '2017-04-10', '2'),
('11', 'Kostrzyn', '2017-04-10', '1'),
('12', 'Malbork', '2017-04-10', '1'),
('13', 'Tczew', '2017-04-10', '2'),
('14', 'Lomza', '2017-04-10', '1'),
('15', 'Szczecin', '2017-04-10', '2'),
('16', 'Gdynia', '2017-04-10', '2'),
('17', 'Radom', '2017-04-10', '1'),
('18', 'Sopot', '2017-04-10', '1'),
('19', 'Opole', '2017-04-10', '2'),
('20', 'Plock', '2017-04-10', '1'),
('21', 'Sandomierz', '2017-04-10', '2'),
('22', 'Tychy', '2017-04-10', '1'),
('23', 'Grudziadz', '2017-04-10', '2'),
('24', 'Przemysl', '2017-04-10', '2');

INSERT INTO PUBLIC.TRAINCONNECTION(ID, DEPARTURECITY, ARRIVALCITY, TRANSPORTDATE) VALUES
('1', '1', '2', '2017-04-10 18:23'),
('2', '3', '4', '2017-04-10 19:10'),
('3',  '5', '6', '2017-04-10 20:13'),
('4', '7', '8', '2017-04-10 15:20'),
('5', '9', '10', '2017-04-10 07:15'),
('6', '11', '12', '2017-04-10 04:30'),
('7', '13', '14', '2017-04-10 20:53'),
('8', '15', '16', '2017-04-10 14:12'),
('9', '17', '18', '2017-04-10 18:22'),
('10', '19', '20', '2017-04-10 19:31'),
('11', '21', '22', '2017-04-10 23:40'),
('12', '23', '24', '2017-04-10 18:17'),
('13', '1', '4', '2017-04-10 21:29');
