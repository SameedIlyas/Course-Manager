# Course Manager Frontend

This is the frontend for the Course-Manager application. It is a web application built using React and provides an interface for users to interact with the course management system.

![Homepage](https://github.com/SameedIlyas/Course-Manager/assets/127698326/825fc1ac-37d4-4408-a960-32780bbd3b63)

## Overview

- **Technology Stack:** React, Node.js, Bootstrap
- **Purpose:** Provides a user interface for managing and enrolling in courses.
- **Port:** The frontend is available on port `3000`.

## Getting Started

### Prerequisites

- Node.js
- Docker (optional, for containerized setup)

### Running the Application

You can run the frontend application using Docker or directly with Node.js.

#### Using Docker

1. Ensure Docker is installed and running on your system.

2. Navigate to the `Frontend` directory of the project.

3. Build the Docker image using the Dockerfile:

   ```sh
   docker build -t course-manager-frontend .
   ```

4. Run the docker containerL:

   ```sh
   docker run -d -p 3000:3000 --name course-manager-frontend course-manager-frontend
   ```

#### Using Node.js

1. Ensure Node.js is installed on your system.

2. Navigate to the Frontend directory of the project.

3. Install the dependencies:

```sh
npm install
```

4. Start the application:

```sh
npm start
```

## Project Structure

The frontend project is organized as follows:

- **public/**: Contains static assets and the HTML file.
  - **index.html**: The main HTML file.
  - **favicon.ico**: The favicon for the application.

- **src/**: Contains the React components, styles, and other source files.
  - **api/**: Contains API configuration files.
    - **axiosConfig.js**: Configures Axios for making HTTP requests to the backend.
  - **components/**: Contains React components.
    - **course/**: Components related to course management.
    - **enrolledCourses/**: Components related to enrolled courses.
    - **header/**: Header components.
    - **home/**: Home page components.
    - **login/**: Login components.
    - **register/**: Registration components.
    - **spinner/**: Loading spinner components.
    - **video/**: Video components.
    - **Layout.js**: Layout component for the application.
    - **RequiredAuth.js**: Component for handling required authentication.
  - **context/**: Contains context providers.
  - **hooks/**: Contains custom React hooks.
  - **images/**: Contains image assets.
  - **App.js**: The main App component.
  - **App.css**: Styles for the App component.
  - **index.js**: The entry point of the React application.
  - **index.css**: Global styles for the application.
  - **logo.svg**: The logo of the application.

This structure helps maintain a clear separation of concerns, making the application easier to manage and extend.

## API Integration

The frontend communicates with the backend API to manage courses and user enrollments. Below are some key points on how the API integration is handled:

### Axios Configuration

Axios is configured to handle HTTP requests to the backend API. The base URL and default headers are set up to facilitate communication with the backend.

### Authentication

User authentication is handled using Basic Authentication. The login functionality captures the username and password, encodes them, and sends them as part of the authorization header in the request.

### API Endpoints

The frontend interacts with various API endpoints provided by the backend to perform operations such as user login, fetching course details, and managing enrollments. These endpoints are called using Axios with the appropriate request configurations.

### Example API Calls

- **Login:** Authenticates the user and retrieves user details.
- **Fetch User Data:** Retrieves the currently logged-in user's information.
- **Fetch Courses:** Retrieves a list of all available courses.
- **Fetch Enrolled Courses:** Retrieves a list of courses the user is enrolled in.

![Register](https://github.com/SameedIlyas/Course-Manager/assets/127698326/463d79ba-95e9-4f62-acda-983d3c4d936d)

By following this structure, the frontend can effectively communicate with the backend API to provide a seamless user experience.
