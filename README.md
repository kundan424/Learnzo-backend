# Student Management System - Backend API

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234EA94B.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

This repository contains the backend REST API for the Student Management System. Built with Java and the Spring Boot framework, this secure, stateless API provides all the necessary business logic and data persistence for managing student records. This project was built as a full-stack assignment for Learnzo Academy.

---

## 🚀 Features

* **Secure REST API:** Endpoints are protected using Spring Security, requiring admin authentication for access. 
* **Role-Based Access Control:** Access to the API is restricted to users with the `ADMIN` role.
* **Full CRUD Functionality:** Provides endpoints to Create, Read, Update, and Delete student records. 
* **Data Persistence:** Integrates with MongoDB using Spring Data to store and retrieve data. 
* **Configuration Management:** Application settings (like database URI and CORS origins) are externalized and managed via environment variables for easy deployment. 
* **Global Exception Handling:** Provides consistent and meaningful error responses for issues like validation errors or resources not found.
* **Dockerized:** Includes a `Dockerfile` for easy, containerized deployment on platforms like Render.

## 🛠️ Tech Stack

* **Language:** Java 17
* **Framework:** Spring Boot 3
* **Security:** Spring Security 6
* **Database:** MongoDB (with Spring Data MongoDB)
* **Build Tool:** Apache Maven
* **Deployment:** Docker

---

## 📖 API Endpoints

All endpoints are prefixed with `/api` and are protected, requiring Basic Authentication with admin credentials.

| Method   | Endpoint                | Description                                                       |
| :------- | :---------------------- |:------------------------------------------------------------------|
| `POST`   | `/students`             | Add a new student.                                                |
| `GET`    | `/students`             | Get a list of all students.                            |
| `PUT`    | `/students/{id}`        | Update a student's course by their ID.                   |
| `DELETE` | `/students/{id}`        | Delete a student by their ID.                           |

---

## 🔧 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

* Java Development Kit (JDK) 17 or higher.
* Apache Maven.
* A running MongoDB instance (either local or a free cluster from [MongoDB Atlas](https://www.mongodb.com/cloud/atlas/register)).

### Installation & Setup

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/kundan424/Learnzo-backend.git
    ```
2.  **Navigate into the project directory:**
    ```sh
    cd student-management-backend
    ```
3.  **Configure Environment Variables:**
    This project requires environment variables to connect to the database. The easiest way to set them for local development is in your IDE's run configuration.

    * `MONGO_URI`: Your full MongoDB connection string (e.g., `mongodb://localhost:27017` or `mongodb+srv://...`).
    * `MONGO_DATABASE`: The name of your database (e.g., `studentDB`).
    * `CORS_ALLOWED_ORIGINS`: The URL of your local frontend (e.g., `http://localhost:5173`).

4.  **Run the application using the Maven wrapper:**
    ```sh
    ./mvnw spring-boot:run
    ```
    The API will be available at `http://localhost:8080`.

---

## 🔗 Frontend Repository

This backend is designed to work with the corresponding frontend. You can find the repository for the frontend here:

➡️ **[Student Management System - Frontend](https://github.com/kundan424/Learnzo-frontend.git)**

---

## 📜 License

Distributed under the MIT License.