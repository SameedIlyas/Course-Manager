# Course Manager

A Course Manager Web app made with Java, React and Neo4j. The main purpose of this app was to experiment with a Neo4j database in context with a backend and frontend of an application.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Environment Configuration](#environment-configuration)
- [Docker Configuration](#docker-configuration)
- [Database Setup](#database-setup)

## Introduction

The Course Manager Web app is designed to help users manage and interact with course-related data using a Neo4j database. This application demonstrates the integration of a Java Spring Boot backend with a React frontend.

The primary purpose was to build a web app using Neo4j. This course manager allows the user to register and log in as a student, access different courses, and see their enrolled courses. The full functionality is demonstrated in the "Neo4j for Beginners" YouTube video by FreeCodeCamp.org.

## Features

- User registration and login as a student
- Access and enroll in different courses
- View enrolled courses

## Technologies Used

### Backend

- Java Spring Boot
- Neo4j

### Frontend

- React
- Node.js

## Setup and Installation

### Prerequisites

- Docker
- Node.js
- Java (JDK 17)

### Steps

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/SameedIlyas/Course-Manager.git
   cd Course-Manager
   ```
2. **Configure Environment Variables:**
   Copy the .env.example file to .env and fill in the necessary values.
   ```sh
   cp Backend/src/main/resources/.env.example Backend/src/main/resources/.env
   ```
3. **Build and Run with Docker:**
   ```sh
   docker-compose up --build
   ```

## Usage

Once the application is running, you can access the frontend at `http://localhost:3000` and the backend API at `http://localhost:8080`.

### User Interactions

- **Student:** Can register, log in, access different courses, and view enrolled courses.

## Environment Configuration

The following environment variables need to be configured in the `.env` file:

```plaintext
AURA_URI=neo4j+s://<your-database-uri>
AURA_USER=<your-database-user>
AURA_PASSWORD=<your-database-password>
ALLOWED_ORIGINS=http://localhost:3000
```
To set up the environment variables, follow these steps:

1. Copy the '**.env.example**' file to '**.env**':
```sh
docker-compose up --build
```
2. Open the '**.env**' file and fill in the necessary values:
```plaintext
AURA_URI=neo4j+s://<your-database-uri>
AURA_USER=<your-database-user>
AURA_PASSWORD=<your-database-password>
ALLOWED_ORIGINS=http://localhost:3000
```

## Docker Configuration

The application is containerized using Docker. The Docker setup includes configurations for both the backend and frontend services.

### Backend

- Runs on port 8080

### Frontend

- Runs on port 3000

### Steps to Build and Run

1. Ensure Docker is installed and running on your system.
2. Navigate to the project directory.
3. Build and run the Docker containers:

   ```sh
   docker-compose up --build
   ```
   Ensure these ports are available on your system to avoid conflicts.

## Database Setup

The application uses a Neo4j Aura database. Follow these steps to set up the database:

### Step 1: Create a Neo4j Aura Account

1. Go to [Neo4j Aura](https://neo4j.com/cloud/aura).
2. Create an account and set up an empty database.

### Step 2: Configure Connection Details

1. Note down the connection details provided by Neo4j Aura:
   - **AURA_URI:** The URI of your Neo4j database.
   - **AURA_USER:** The username for your Neo4j database.
   - **AURA_PASSWORD:** The password for your Neo4j database.

2. Open the `.env` file located in `Backend/src/main/resources/`.

3. Fill in the connection details:

   ```plaintext
   AURA_URI=neo4j+s://<your-database-uri>
   AURA_USER=<your-database-user>
   AURA_PASSWORD=<your-database-password>
   ALLOWED_ORIGINS=http://localhost:3000
   ```

### Step 3: Initialize the Database

1. Open the Neo4j browser console connected to your Aura instance.
   
2. Use the initializer.cypher file provided in the repository to build a base database.

   
   
