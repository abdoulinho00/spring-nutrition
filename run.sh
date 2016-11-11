#!/bin/bash

mvn clean package
cp target/medidoc.war  provisionning/files/medidoc.war

cd provisionning
vagrant up --provision

sensible-browser http://192.168.5.5:8080/medidoc/patient/add 


