Flight Booking System - A Microservices Project
This project is a flight booking management system built using a microservices architecture with Spring Boot. It demonstrates how different services can work together to handle complex business logic, such as validating data in one service before creating a record in another.

Architecture
The system is composed of two primary microservices:

Database-API: This service acts as the core data layer and is the single source of truth for all flight, booking, and passenger data. It exposes a set of CRUD endpoints for managing the database entities. It also provides a crucial validation endpoint.

Passenger-API: This is a user-facing service responsible for handling business logic like creating bookings. It communicates with the Database-API to validate information (e.g., checking if a flight number is valid) before processing a request.

Passenger-API
This service handles booking logic and calls the Database-API.

Configure Port:
Open the Passenger-Api/src/main/resources/application.properties file.
This service is configured to run on port 8085 to avoid conflicts.

Properties

server.port=8085
API URL Configuration:
Ensure the URL in Passenger-Api/src/main/java/FlightManagmentSystem/Passenger_Api/service/BookingService.java points to the correct address of the Database-API.

Java

private final String DATABASE_API_URL = "http://localhost:8080/api/v1/db/flight";

