 Restaurant Management System with Custom Authentication and Authorization

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Architecture](#architecture)
5. [Installation](#installation)
6. [Usage](#usage)
7. [Authentication and Authorization](#authentication-and-authorization)
8. [API Documentation](#api-documentation)
9. [UI (Optional)](#ui-optional)
10. [Contributing](#contributing)
11. [License](#license)
12. [Contact](#contact)

## Introduction

This project is a restaurant management system that includes a custom authentication and authorization system. It supports multiple authentication methods (OAuth, JWT, LDAP) and implements role-based access control (RBAC). The system is designed using Java and Spring frameworks, following best practices and design patterns.

## Features

- User registration and login
- Multiple authentication methods (OAuth, JWT, LDAP)
- Role-based access control (RBAC)
- Restaurant management (CRUD operations on restaurants)
- Secure APIs with proper access control

## Technologies Used

-
- Spring Boot
- Spring Security
- OAuth2
- JWT
- LDAP
- Hibernate / JPA
-  H2
- Maven
-
- Thymeleaf (for UI, optional)

## Architecture

The project follows a layered architecture with separation of concerns, ensuring modularity and ease of maintenance.

1. **Controller Layer**: Handles HTTP requests and responses.
2. **Service Layer**: Contains business logic.
3. **Repository Layer**: Manages data persistence.
4. **Security Layer**: Manages authentication and authorization.
