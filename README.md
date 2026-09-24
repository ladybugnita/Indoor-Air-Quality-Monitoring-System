# Indoor Air Quality Monitoring System

An IoT-based full-stack system that monitors indoor air quality in real time. An **ESP32** microcontroller with an **MQ-135 gas sensor** collects air-quality readings, a **Spring Boot** backend stores them in **MySQL**, and a **React** dashboard displays live data.

> Third-year BCA project, Nepal College of Information Technology (Pokhara University). This project was later extended into our final-year project, the [Smart Air Quality Intelligence and Forecasting System](https://github.com/ladybugnita/Smart_Air_Quality_Monitoring_and_Forecasting_System).

---

## Overview

People spend most of their time indoors, in homes, classrooms, and offices, yet indoor air can contain harmful gases that go unnoticed because there is no easy way to see them. Traditional monitoring equipment is expensive and hard to access. This project uses a low-cost ESP32 and MQ-135 sensor to measure indoor air quality continuously and shows the readings on a web dashboard, so anyone can check the air around them in real time.

---

## Key Features

- Collects air-quality data from an MQ-135 gas sensor connected to an ESP32
- Sends sensor readings to the Spring Boot backend over Wi-Fi
- Stores readings in a MySQL database
- Displays real-time air-quality readings on a React web dashboard

---

## Tech Stack

| Category | Technology |
|---|---|
| Hardware | ESP32, MQ-135 gas sensor |
| Backend | Java, Spring Boot, REST APIs |
| Frontend | React |
| Database | MySQL |

---

##  How It Works

```
MQ-135 Sensor → ESP32 → (Wi-Fi) → Spring Boot API → MySQL
                                        │
                                        ▼
                               React Dashboard (live readings)
```

---

## Project Structure


```
├── esp32/       Arduino code for the ESP32 and MQ-135 sensor
├── Backend/     Spring Boot REST API and MySQL integration
├── Frontend/    React dashboard for live readings
└── FigmaDesigns/ contains the design for UI
```

---

## Installation & Setup


1. **Hardware:** Connect the MQ-135 sensor to the ESP32, add your Wi-Fi details and backend URL to the ESP32 code, and upload it using the Arduino IDE.
2. **Backend:** Create a MySQL database, update `application.properties` with your credentials, and run:
   ```bash
   cd Backend
   mvn spring-boot:run
   ```
3. **Frontend:** In the frontend folder, run:
   ```bash
   cd Frontend
   npm install
   npm start
   ```

---

## Future Improvements

- Add alerts when air quality reaches unhealthy levels
- Add more sensors, such as temperature, humidity, and particulate matter (PM2.5)
- Show historical trends and charts of past readings

Many of these ideas, including forecasting, were later built into the [Smart Air Quality Intelligence and Forecasting System](https://github.com/ladybugnita/Smart_Air_Quality_Monitoring_and_Forecasting_System).

---

## Contributing

Suggestions and improvements are welcome. Feel free to fork the repository, create a feature branch, and open a pull request.

---

## Author

**Nita Dangol**

[GitHub](https://github.com/ladybugnita) · [LinkedIn](https://linkedin.com/in/nitadangol) · [Portfolio](https://nitadangol.com.np)
