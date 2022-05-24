# Riot Games API

## Project Description 
- An API that provides character data from 2 provider APIs being consumed by 1 consumer API.
- LOLChampionProviderRestAPI
	- A RESTful API that provides character data from the game League of Legends.
- ValoAgentProviderSoapAPI 
	- A SOAP API that provides character data from the game Valorant.
- GameConsumerRestAPI
	- A RESTful API that is consuming LOLChampionProviderRestAPI and ValoAgentProviderSoapAPI.

## Technologies Used
- Java - Version 1.8
- Spring Boot - Version 2.6.7
- Spring Web - Version 2.6.7
- Spring Data JPA - Version 2.6.4
- PostgreSQL - Version 42.3.4
- SL4J - Version 1.7.36
- Spring Tool Suite - Version 4.14.0.RELEASE
- Postman - Version 9.19.0
- DBeaver - Version 22.0.3.202204170718

## Features
Some features of the project.
- Can make an http request to the Rest Provider Service to get the list of League of Legends Champions and their descriptions from the Game consumer API.
- Can make an http request to the Soap Provider Serivce to get the list of Valorant Agents and their descriptions from the Game consumer API.
- Can make an http request to to the consumer API to update, delete or create League of Legends Champions or Valorant Agents from the Game consumer API.
   
To-do list
   
- Improve unit testing.
- Design better API design for the consumer API.
- Improve logging to log relevant actions.

## Getting Started   
    
1. clone the project in a new folder of your choice.    
` git clone https://github.com/Ben-Ortiz/Riot-Games-API.git `     
    
2. 

## What I learned
- Spring Data JPA: How to create models and use Spring to make database tables in Postgres
- Rest API: How to create a Rest API using the Spring Framework.
- Soap API: How to create a Soap API using the Spring Framework.
- Postman: How to make requests to a Rest API and Soap API.

## What I can improve on
- Testing: Spring Test could be used more
- Logging: Spring AOP could have been more descriptive.