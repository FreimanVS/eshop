#!/bin/bash
docker rm -f eshopmaster_db_1 eshopmaster_web_1
docker rmi  eshopmaster_db eshopmaster_web
docker network rm eshopmaster_default