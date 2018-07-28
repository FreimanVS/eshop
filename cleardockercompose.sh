#!/bin/bash
docker rm -f eshopmaster_db_1 eshopmaster_web_1 eshopmaster_prom_1 eshopmaster_grafana_1
docker rmi  eshopmaster_db eshopmaster_web eshopmaster_prom eshopmaster_grafana
docker network rm eshopmaster_default