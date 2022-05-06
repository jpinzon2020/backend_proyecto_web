INSERT INTO user (
	id,
	active, 
	password, 
	roles, 
	user_name, 
	email
) VALUES (
	1,
	1,
       '$2a$10$eZCGsc8EZRcQ.SbI7PshLelOta9jx6WUnkC4GLjpnEL/Pxu2Csm/W',
       'ROLE_USER',
       'user1',
       'jopinzon19@poligran.edu.co'
);

INSERT INTO user (
	id, 
	active, 
	password, 
	roles, 
	user_name, 
	email
) VALUES (
	2,
	1, 
	'$2a$10$eZCGsc8EZRcQ.SbI7PshLelOta9jx6WUnkC4GLjpnEL/Pxu2Csm/W',
	'ROLE_ADMIN,ROLE_USER',
	'user2',
	'jpinzon95@hotmail.com'
);
