Comida 2
===================


Hey! this is a rewrite of the my *popular* comida app. 

---------

Environment Requirements
-------------

All you need is java 8 and maven 3 to build the application.


How to run the tests
----------------------
good old **mvn test** will run all the tests, database integration tests will be run against an in memory database.


How to run the application
-------------

1. build the application with **mvn package**
2. run the application with **./run.sh**

Troubleshoot
-------------

if you are having issues with the database, just run **./dropdb.sh**
if you need to run the migrations by hand, you can run **./migratedb.sh**

TODO: use vagrant to simplify environment set-up.
[![Build Status](https://travis-ci.org/romulobr/comida-dropwizard.png)](https://travis-ci.org/romulobr/comida-dropwizard)
