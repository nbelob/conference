INSERT INTO account (username, password) VALUES ('bnl', 'pppppp');
INSERT INTO account (username, password) VALUES ('user', 'passuser');
INSERT INTO account (username, password) VALUES ('mp', 'passmp');

INSERT INTO message (username, text, time) VALUES ('bnl', 'Сообщение1',
            DATEADD(HOUR, -1, DATEADD(MINUTE, -30, DATEADD(SECOND, -34, SYSDATE))));
--INSERT INTO message (username, text, time) VALUES ('bnl', 'Сообщение2',
--            DATEADD(HOUR, -5, DATEADD(MINUTE, -27, DATEADD(SECOND, -12, SYSDATE))));
--INSERT INTO message (username, text, time) VALUES ('bnl', 'Сообщение3',
--            DATEADD(HOUR, -5, DATEADD(MINUTE, -27, DATEADD(SECOND, -14, SYSDATE))));
