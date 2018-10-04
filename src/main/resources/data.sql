INSERT INTO account (username, password) VALUES ('jsmith', 'password');
INSERT INTO account (username, password) VALUES ('jdoe', 'password');
INSERT INTO account (username, password) VALUES ('rroe', 'password');

INSERT INTO message (username, text, time) VALUES ('jsmith', 'Сообщение1',
            DATEADD(HOUR, -1, DATEADD(MINUTE, -30, DATEADD(SECOND, -34, SYSDATE))));
INSERT INTO message (username, text, time) VALUES ('jsmith', 'Сообщение2',
            DATEADD(HOUR, -5, DATEADD(MINUTE, -27, DATEADD(SECOND, -12, SYSDATE))));
INSERT INTO message (username, text, time) VALUES ('jsmith', 'Очень очень очень очень длинное сообщение3',
            DATEADD(HOUR, -5, DATEADD(MINUTE, -27, DATEADD(SECOND, -14, SYSDATE))));
