#!/bin/bash
mkdir dockerfiles/glassfish/autodeploy
mv target/eshop dockerfiles/glassfish/autodeploy/eshop
docker-compose up