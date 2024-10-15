# Spring CRUD Application

## Overview

This is a Spring Boot CRUD (Create, Read, Update, Delete) application that manages user data. It utilizes Spring Data JPA to interact with a MySQL database.

## Features

- Add new users
- Retrieve all users
- Retrieve a user by ID
- Update user details
- Delete a user

## Technologies Used

- Java 21
- Spring Boot 3.3.4
- Spring Data JPA
- MySQL
- Maven

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 21
- MySQL
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/amanullahmd/spring-crud.git
   cd spring-crud

API Endpoints

    POST /user/add: Add a new user
    GET /user: Get a list of all users
    GET /user/get?id={id}: Get user details by ID
    PUT /user/update?id={id}: Update user details by ID
    DELETE /user/delete/{id}: Delete user by ID
