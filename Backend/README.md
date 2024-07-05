# Course-Manager Backend

This is the backend for the Course-Manager application. It is a REST API built using Java Spring Boot and utilizes a Neo4j database.

## Overview

- **Technology Stack:** Java Spring Boot, Neo4j
- **Purpose:** Provides RESTful endpoints for managing courses and users.
- **Port:** The API is available on port `8080`.

## Getting Started

### Prerequisites

- Java (JDK 17)
- Docker

### Running the Application

To run the backend application using Docker, follow these steps:

1. Ensure Docker is installed and running on your system.

2. Navigate to the `Backend` directory of the project.

3. Build the Docker image using the Dockerfile:

   ```sh
   docker build -t course-manager-backend .
   ```
   
4. Run the Docker container:

   ```sh
   docker run -d -p 8080:8080 --name course-manager-backend --env-file src/main/resources/.env course-manager-backend
   ```

### Environment Configuration

Ensure you have the necessary environment variables configured in the `.env` file located in `src/main/resources/`:

```plaintext
AURA_URI=neo4j+s://<your-database-uri>
AURA_USER=<your-database-user>
AURA_PASSWORD=<your-database-password>
ALLOWED_ORIGINS=http://localhost:3000
```

## API Documentation

The API provides endpoints for managing courses and users. Below is a brief overview of the available endpoints:

### User Endpoints

- **GET /api/v1/auth/me**: Returns the username of the currently logged-in user.

  **Example Response:**
  ```json
  {
    "username": "john_doe"
  }
  ```

  - **POST /api/v1/auth/register**: Registers a new user
 
  **Request Body:**
  ```json
  {
    "name": "John Doe",
    "username": "john_doe",
    "password": "password123"
  }
  ```

  **Example Response:**
  ```json
  {
    "name": "John Doe",
    "username": "john_doe",
    "roles": ["ROLE_USER"]
  }
  ```

  ### Course Endpoints

- **GET /api/v1/courses/**: Retrieves a list of all courses

  **Example Response:**
  ```json
  [
    {
      "identifier": "course1",
      "title": "Course 1",
      "teacher": "Teacher A",
      "lessons": ["Lesson 1", "Lesson 2"],
      "enrolled": true
    },
    {
      "identifier": "course2",
      "title": "Course 2",
      "teacher": "Teacher B",
      "lessons": ["Lesson 1", "Lesson 2"],
      "enrolled": false
    }
  ]
  ```


  - **GET /api/v1/courses/{identifier}**: Retrieves details of a specific course by its identifier.
 
  **Example Response**
  ```json
  {
    "identifier": "course1",
    "title": "Course 1",
    "teacher": "Teacher A",
    "lessons": ["Lesson 1", "Lesson 2"]
  }
  ```

  ### Enrollment Endpoints

- **GET /api/v1/enrollments/**: Retrieves a list of all courses the logged-in user is enrolled in.

  **Example Response:**
  ```json
  [
    {
      "identifier": "course1",
      "title": "Course 1",
      "teacher": "Teacher A",
      "lessons": ["Lesson 1", "Lesson 2"],
      "enrolled": true
    }
  ]
  ```

  - **POST /api/v1/enrollments/**: Enrolls the logged-in user in a course.
 
  **Request Body:**
  ```json
  {
  "courseIdentifier": "course1"
  }
  ```

  **Example Response:**
  ```json
  {
    "name": "John Doe",
    "username": "john_doe",
    "course": {
      "identifier": "course1",
      "title": "Course 1",
      "teacher": "Teacher A"
    }
  }
  ```
  
## Architecture

The backend is organized into several packages, each responsible for a specific aspect of the application:

### Packages

- **config**: Contains configuration classes like `SecurityConfig`.

  **Example Class:**
  - `SecurityConfig`: Configures security settings, including CORS, session management, and authentication.

- **controllers**: Contains the REST controllers that handle HTTP requests.

  **Example Classes:**
  - `CourseController`: Handles requests related to courses.
  - `CourseEnrollmentController`: Handles requests related to course enrollments.
  - `UserController`: Handles requests related to user authentication and registration.

- **models**: Contains the entity classes representing the domain models.

  **Example Classes:**
  - `Course`: Represents a course entity.
  - `User`: Represents a user entity.

- **objects**: Contains Data Transfer Objects (DTOs) used for transferring data between layers.

  **Example Classes:**
  - `CourseDTO`: Data Transfer Object for course details.
  - `UserDTO`: Data Transfer Object for user details.

- **queryresults**: Contains classes representing query results from the database, such as `CourseEnrollmentQueryResult`.

  **Example Class:**
  - `CourseEnrollmentQueryResult`: Represents the result of a course enrollment query.

- **repositories**: Contains the repository interfaces for data access.

  **Example Interface:**
  - `CourseRepository`: Interface for accessing course data.

- **requests**: Contains classes representing HTTP request payloads.

  **Example Classes:**
  - `CreateUserRequest`: Represents the payload for creating a new user.
  - `CourseEnrollmentRequest`: Represents the payload for enrolling in a course.

- **services**: Contains the service classes that contain business logic and interact with the repositories.

  **Example Classes:**
  - `CourseService`: Contains business logic related to courses.
  - `CourseEnrollmentService`: Contains business logic related to course enrollments.
  - `UserService`: Contains business logic related to users.

This architecture ensures a clear separation of concerns, making the application easier to maintain and extend.
