# Worst Producers API
RESTful API for reading and analysing the Golden Raspberry Awards based on the producers.

## Installation

Download the project form the repository.

Use Maven (https://maven.apache.org/download.cgi) to install WorstProducersAPI.

```bash
mvn install 
```

## Usage

start server runing the generated jar file:

```bash
java -jar worstMovies-1.0.0.jar
```
The server will start at localhost:8080

To access the analysis, use the following endpoint (either using a browser or postman):

```bash
http://localhost:8080/awardsInterval
```

###Changing the data

The H2 database is populated using a csv file located on:
\src\main\resources\db\migration\movielist.csv

To use a diferent data, simply replace the csv with the desired data. Keeping the same column structure and file name.

###Integration testing

Running mvn install will automatically run the tests, 

but it is also possible to run AwardsControllerIntegrationTest manually.