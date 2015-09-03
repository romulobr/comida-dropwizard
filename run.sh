#!/bin/bash
java -Xdebug -agentlib:jdwp=transport=dt_socket,address=9999,server=y,suspend=n -jar ./target/comida-1.0-SNAPSHOT.jar server configuration.yml

