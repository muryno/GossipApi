INSERT INTO schema_news.author(
	id, firstname, lastname, bio)
	VALUES (?, ?, ?, ?);

INSERT INTO schema_news.role(
    	id, rolename, description)
    	VALUES (?, ?, ?);

INSERT INTO schema_news.users_role(
	role_id, users_id)
	VALUES (?, ?);
INSERT INTO schema_news.article(
	id, title, content, publish, author_id)
	VALUES (?, ?, ?, ?, ?);

INSERT INTO schema_news.users(
	id, email, usertype, password, author_id)
	VALUES (?, ?, ?, ?, ?);