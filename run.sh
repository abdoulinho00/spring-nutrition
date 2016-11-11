#!/bin/bash

mvn clean package
cp target/medidoc.war  provisionning/files/medidoc.war

cd provisionning
vagrant up --provision

sensible-browser http://medidoc.vm/patient/add


