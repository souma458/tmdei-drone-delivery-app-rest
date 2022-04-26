connect-mysql:
	@docker exec -it mysqldb bash

connect-mongodb:
	@docker exec -it mongodb mongo

start: teardown
	@docker-compose up --build --detach

teardown:
	@docker-compose down
	@-docker rmi \
	 