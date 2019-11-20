INSERT INTO USER_TBL (name) VALUES ('강호동');
INSERT INTO USER_TBL (name) VALUES ('유재석');
INSERT INTO USER_TBL (name) VALUES ('김태희');

INSERT INTO CLOTHES_TBL (user_id, name, image_path, status) VALUES (1, '빨강 패딩', null, 'NOT_USING');
INSERT INTO CLOTHES_TBL (user_id, name, image_path, status) VALUES (1, '검정 코트', null, 'NOT_USING');
INSERT INTO CLOTHES_TBL (user_id, name, image_path, status) VALUES (1, '흰 반팔', null, 'NOT_USING');
INSERT INTO CLOTHES_TBL (user_id, name, image_path, status) VALUES (2, '흰 긴팔', null, 'NOT_USING');
INSERT INTO CLOTHES_TBL (user_id, name, image_path, status) VALUES (2, '청 반바지', null, 'NOT_USING');

INSERT INTO TAG_TBL (clothes_id, category) VALUES (1,'겨울용');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (1,'패딩');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (1,'아우터');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (2,'겨울용');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (2,'아우터');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (2,'선물');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (3,'여름용');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (3,'데이트용');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (4,'데이트용');
INSERT INTO TAG_TBL (clothes_id, category) VALUES (5,'데이트용');