#!/bin/bash
mkdir dockerfiles/glassfish/autodeploy
cp -r target/eshop dockerfiles/glassfish/autodeploy/eshop
docker-compose up