# Electronic Components Inventory API

A RESTful API built with **Java** and **Spring Boot**, entirely structured around **Clean Architecture** principles. 

This project was developed to manage an inventory of electronic components (such as ESP32-C3 microcontrollers, MPU-6050 sensors, and OLED displays) for hardware and IoT projects. 

## Technologies Used
* **Java 17+**
* **Spring Boot 3.x** (Web)
* **Lombok** (Boilerplate reduction)
* **Maven** (Dependency Management)

## Architecture Overview

The project heavily emphasizes the separation of concerns by isolating the core business rules from external frameworks and delivery mechanisms.

```text
src/main/java/com/inventario/componentes/
├── core/                           # Inner Circle (Business Rules)
│   ├── entities/                   # Pure Java Domain Models (EletronicComponent)
│   └── usecases/                   # Application Business Rules (CRUD operations)
│       ├── dtos/                   # Data Transfer Objects (Request/Response)
│       └── interfaces/             # Contracts/Ports (ComponentRepository)
│
├── communication/                  # Outer Circle (Interface Adapters)
│   ├── controllers/                # Spring REST Controllers (Entry points)
│   └── repositories/               # Data Persistence Implementation (In-Memory)
│
└── ComponentesApplication.java     # Entry Point / Composition Root
```

### Key Concepts Applied:
* **Dependency Inversion:** The Core domain does not know about the Web or the Database. Controllers and Repositories depend on the Core, not the other way around.
* **DTO Pattern:** Entities are strictly protected. Data enters and leaves the API exclusively through Data Transfer Objects.
* **Fail-Fast & Exception Handling:** Using `Optional` and throwing runtime exceptions immediately when resources are not found.

## API Endpoints

The API runs on `http://localhost:8080/componentes`.

### 1. Create a Component
* **Method:** `POST`
* **Path:** `/`
* **Body:**
```json
{
  "modelo": "ESP32-C3",
  "categoria": "Microcontrolador",
  "quantidade": 5
}
```
* **Response (200 OK):** Returns the created DTO with an auto-generated UUID.

### 2. List all Components
* **Method:** `GET`
* **Path:** `/`
* **Response (200 OK):**
```json
[
  {
    "id": "822d2ca7-e3f7-44b2-9471-ac82cbb08d74",
    "modelo": "ESP32-C3",
    "categoria": "Microcontrolador",
    "quantidade": 5
  }
]
```

### 3. Update a Component
* **Method:** `PUT`
* **Path:** `/{id}`
* **Body:**
```json
{
  "modelo": "ESP32-C3",
  "categoria": "Microcontrolador",
  "quantidade": 15
}
```

### 4. Delete a Component
* **Method:** `DELETE`
* **Path:** `/{id}`
* **Response (200 OK):** Empty body.

## How to Run

1. Clone the repository.
2. Open the project in your favorite IDE (IntelliJ IDEA, Eclipse, VS Code).
3. Run the `ComponentesApplication.java` file.
4. Use Insomnia, Postman, or cURL to test the endpoints on port `8080`.

*(Note: The current persistence layer uses an In-Memory ArrayList. Data will be reset when the server restarts).*

---
**Author:** Nicolas Cleik