# Indoor Air Quality Monitoring System

An IoT-based full-stack system that monitors indoor air quality in real time. An **ESP32** microcontroller with **MQ-135** (gases and smoke) and **DHT11** (temperature and humidity) sensors collects live readings, a **Spring Boot** backend stores them in **MySQL**, and a **React** dashboard shows color-coded air quality levels with personalized health recommendations.

> Third-year (minor) BCA project, Nepal College of Information Technology (Pokhara University), 2025. This project was later extended into our final-year project, the [Smart Air Quality Intelligence and Forecasting System](https://github.com/ladybugnita/Smart_Air_Quality_Monitoring_and_Forecasting_System).

---

## Overview

People spend most of their time indoors, in homes, classrooms, and offices, yet indoor air can contain harmful gases such as CO₂, ammonia, benzene, and smoke that go unnoticed. Children, older adults, and people with respiratory conditions are affected most, and professional monitoring equipment is expensive. This project uses low-cost sensors and an ESP32 to monitor indoor air continuously, then turns the readings into simple, color-coded information and practical health advice based on WHO air quality thresholds.

---

## Key Features

- **Real-time monitoring** of harmful gases and smoke (MQ-135) and temperature and humidity (DHT11)
- **Live readings on an LCD** attached to the device, as well as on the web dashboard
- **Color-coded dashboard with trend charts** that make air quality easy to understand
- **Personalized health recommendations** based on WHO air quality thresholds
- **Historical data storage** in MySQL to track pollution patterns over time
- **User feedback** submission

---

## Tech Stack

| Category | Technology |
|---|---|
| Hardware | ESP32, MQ-135 gas sensor, DHT11 sensor, LCD display |
| Backend | Java, Spring Boot, REST APIs |
| Frontend | React |
| Database | MySQL |
| Design | Figma |
| Tools | Arduino IDE, IntelliJ IDEA, VS Code, Draw.io |

---

## How It Works

```
MQ-135 + DHT11 Sensors → ESP32 → (Wi-Fi) → Spring Boot API → MySQL
          │                                       │
          ▼                                       ▼
     LCD Display                  React Dashboard (live readings,
                                  charts, health recommendations)
```

---

## Project Structure

```
├── esp32/          Arduino code for the ESP32, sensors, and LCD
├── Backend/        Spring Boot REST API and MySQL integration
├── Frontend/       React dashboard for live readings
└── FigmaDesigns/   UI designs created in Figma
```

---

## Installation & Setup

1. **Hardware:** Connect the MQ-135, DHT11, and LCD to the ESP32. Add your Wi-Fi details and backend URL to the ESP32 code, then upload it using the Arduino IDE.
2. **Backend:** Create a MySQL database, update `application.properties` with your credentials, and run:
   ```bash
   cd Backend
   mvn spring-boot:run
   ```
3. **Frontend:** In a new terminal, run:
   ```bash
   cd Frontend
   npm install
   npm start
   ```

---

## Team

This project was built by a team of four students under the supervision of **Er. Simanta Kasaju**.

| Member | Role |
|---|---|
| Aatish Chaudhary | Documentation, UI/UX Design |
| Biplov Gautam | Backend Development, Testing |
| Jenish Bhattarai | Frontend Development, Testing |
| Nita Dangol | Database Design, IoT Management |

### My Contributions (Nita Dangol)

- Designed the **MySQL database** for storing sensor readings, historical data, user feedback, and sensor status
- Managed the **IoT hardware**: setting up the ESP32 with the MQ-135 and DHT11 sensors and the LCD display, and sending live readings to the backend
- Participated in the literature review, team meetings, and project documentation with the team

> **About this repository:** The team developed this project without Git. After it was completed, I created this repository to keep the final code in one place, so the commit history does not reflect each member's individual work. 

---

## Future Improvements

- Add more sensors, such as PM2.5 and PM10, for particulate matter
- Use machine learning for predictive analysis

Several of these ideas, including AQI forecasting with machine learning, were later built into the [Smart Air Quality Intelligence and Forecasting System](https://github.com/ladybugnita/Smart_Air_Quality_Monitoring_and_Forecasting_System).

---

## Contributing

Suggestions and improvements are welcome. Feel free to fork the repository, create a feature branch, and open a pull request.

---

## Maintained by

**Nita Dangol**

[GitHub](https://github.com/ladybugnita) · [LinkedIn](https://linkedin.com/in/nitadangol) · [Portfolio](https://nitadangol.com.np)
