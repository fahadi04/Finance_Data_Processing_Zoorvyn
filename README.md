# Finance Data Processing and Access Control Backend

# Project Overview

This project is a backend system developed using Java Spring Boot for managing financial records with role-based access control. It simulates the backend of a finance dashboard where different users interact with financial data based on their assigned roles.

The system demonstrates backend architecture, REST API design, data modeling, business logic implementation, validation, and security practices suitable for academic evaluation and backend development interviews.


# Key Features

User Management (Create, Update, Delete, View)
Role-Based Access Control (Admin, Analyst, Viewer)
Financial Records CRUD Operations
Dashboard Summary Analytics
Secure API endpoints using Spring Security
Input validation and error handling
Database persistence using MySQL or H2
Clean layered architecture (Controller → Service → Repository)

# Technology Stack

 Java 17
 Spring Boot 3
 Spring Data JPA
 Spring Security
 Maven
 MySQL / H2 Database
 Lombok
 REST API
 Postman (API Testing)


# Project Structure

finance-dashboard-backend

src/main/java/com/example/finance

├── FinanceApplication.java
├── config
│     └── SecurityConfig.java
├── controller
│     ├── UserController.java
│     ├── RecordController.java
│     └── DashboardController.java
├── entity
│     ├── User.java
│     ├── FinancialRecord.java
│     └── Role.java
├── repository
│     ├── UserRepository.java
│     └── FinancialRecordRepository.java
├── service
│     ├── UserService.java
│     ├── RecordService.java
│     └── DashboardService.java
└── exception
      └── GlobalExceptionHandler.java

# Roles and Permissions

| Role    | Permissions                       |
| ------- | --------------------------------- |
| Viewer  | View dashboard data only          |
| Analyst | View and manage financial records |
| Admin   | Full access to users and records  |

# API Endpoints

## User APIs

| Method | Endpoint    | Description   |
| ------ | ----------- | ------------- |
| POST   | /users      | Create user   |
| GET    | /users      | Get all users |
| PUT    | /users/{id} | Update user   |
| DELETE | /users/{id} | Delete user   |

## Financial Record APIs

| Method | Endpoint      | Description     |
| ------ | ------------- | --------------- |
| POST   | /records      | Create record   |
| GET    | /records      | Get all records |
| PUT    | /records/{id} | Update record   |
| DELETE | /records/{id} | Delete record   |

## Dashboard APIs

| Method | Endpoint           | Description           |
| ------ | ------------------ | --------------------- |
| GET    | /dashboard/summary | Get financial summary |

# Sample Request Body

## Create User

{
  "name": "Admin User",
  "email": "admin@example.com",
  "password": "admin123",
  "role": "ADMIN",
  "active": true
}

## Create Financial Record

{
  "amount": 5000,
  "type": "income",
  "category": "Salary",
  "date": "2026-04-06",
  "notes": "Monthly salary"
}

# Database Configuration

## MySQL Configuration (application.properties)

spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8080

# Database Tables

## User Table

| Column   | Type    |
| -------- | ------- |
| id       | Long    |
| name     | String  |
| email    | String  |
| password | String  |
| role     | Enum    |
| active   | Boolean |

## FinancialRecord Table

| Column   | Type      |
| -------- | --------- |
| id       | Long      |
| amount   | Double    |
| type     | String    |
| category | String    |
| date     | LocalDate |
| notes    | String    |

# How to Run the Project

## Step 1: Install Requirements

Install the following software:

 Java JDK 17
 Maven
 MySQL (optional)
 Postman
 IDE (IntelliJ / VS Code / Eclipse)

## Step 2: Clone Project

git clone https://github.com/your-username/finance-dashboard.git

## Step 3: Open Project

Open the project in:

 IntelliJ IDEA
  or
 VS Code

## Step 4: Build Project

mvn clean install

## Step 5: Run Application

mvn spring-boot:run

Application will start at:

http://localhost:8080

# Testing APIs Using Postman

## Base URL

http://localhost:8080

## Authentication

Type:

Basic Auth

Example Credentials:

Username: admin
Password: admin123


# Error Handling

The application handles errors such as:

 Invalid input data
 Resource not found
 Unauthorized access
 Validation failures

Example Error Response:

{
  "timestamp": "2026-04-06",
  "status": 404,
  "message": "User not found"
}


# Validation Implemented

 Required fields validation
 Email uniqueness
 Role validation
 Input data checks

# Security Implementation

Security is implemented using:

 Spring Security
 Role-based authorization
 Protected API endpoints
 HTTP Basic Authentication


# Assumptions Made

 Users are authenticated using basic authentication
 Roles are predefined as ADMIN, ANALYST, VIEWER
 Financial records include income and expense types
 Database schema is auto-generated using JPA

