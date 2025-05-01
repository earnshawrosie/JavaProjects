# payaraboot
payara luggage weight application with spring boot

THE APPLICATION RUNS ON PORT 8060  
This can be changed in application.properties

Available REST endpoints: 

GET /api/baggage/calculatefee?weights=9&weights=15&weights=30
GET  /api/baggage/baggageclasses
GET  /api/passenger/passengers

The Test Web Application is accessed at

http://localhost:8060/tickets/

and provides 5 Test tickets for processing

To run the application :
mvn clean install spring-boot:run

