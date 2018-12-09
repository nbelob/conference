INSERT INTO account (username, password) VALUES ('jsmith', 'password');
INSERT INTO account (username, password) VALUES ('jdoe', 'password');
INSERT INTO account (username, password) VALUES ('rroe', 'password');

INSERT INTO message (username, text, time) VALUES ('jsmith', 'Some people care too much. I think it''s called love.',
            DATEADD(HOUR, -1, DATEADD(MINUTE, -30, DATEADD(SECOND, -34, SYSDATE))));
INSERT INTO message (username, text, time) VALUES ('jsmith', 'You can''t stay in your corner of the Forest waiting for others to come to you. You have to go to them sometimes.',
            DATEADD(HOUR, -5, DATEADD(MINUTE, -27, DATEADD(SECOND, -12, SYSDATE))));
INSERT INTO message (username, text, time) VALUES ('jsmith', 'It is more fun to talk with someone who doesn''t use long, difficult words but rather short, easy words like "What about lunch?"',
            DATEADD(HOUR, -5, DATEADD(MINUTE, -27, DATEADD(SECOND, -14, SYSDATE))));
