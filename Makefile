connect-mysql:
	@docker exec -it mysqldb bash

connect-mongodb:
	@docker exec -it mongodb mongo

start: teardown
	@docker-compose up --build --detach

teardown:
	@docker-compose down
	@-docker rmi \
	tmdei-drone-delivery-app-rest_scheduler \
	tmdei-drone-delivery-app-rest_user-management \
	tmdei-drone-delivery-app-rest_drone-management \
	tmdei-drone-delivery-app-rest_third-party-transportation \
	tmdei-drone-delivery-app-rest_delivery-management \
	tmdei-drone-delivery-app-rest_package-management \
	tmdei-drone-delivery-app-rest_mysqldb \
	tmdei-drone-delivery-app-rest_mongodb

start-some: teardown
	@docker-compose up mysqldb mongodb scheduler user-management delivery-management package-management drone-management