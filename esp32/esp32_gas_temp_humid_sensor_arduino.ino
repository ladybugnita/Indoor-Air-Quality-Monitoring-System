#include <WiFi.h>
#include <HTTPClient.h>
#include <LiquidCrystal.h>
#include <DHT.h>

// WiFi credentials
const char* ssid = "your_wifi_name";
const char* password = "your_wifi_password";

// Backend URL
const char* serverUrl = "http://192.168.137.207:8080/iaq/data"; 

int mq135Pin = 34; // Analog pin for gas sensor

#define DHTPIN 13        // DHT11 data pin connected to GPIO13
#define DHTTYPE DHT11    
DHT dht(DHTPIN, DHTTYPE);

// LCD RS, E, D4, D5, D6, D7
LiquidCrystal lcd(21, 22, 19, 18, 5, 4);

void setup() {
  Serial.begin(115200);
  dht.begin();

  lcd.setCursor(0, 0);
  lcd.print("Connecting WiFi");

  WiFi.begin(ssid, password);
  int retries = 0;
  while (WiFi.status() != WL_CONNECTED && retries < 20) {
    delay(500);
    Serial.print(".");
    retries++;
  }

  lcd.clear();
  if (WiFi.status() == WL_CONNECTED) {
    lcd.setCursor(0, 0);
    lcd.print("WiFi Connected");
    lcd.setCursor(0, 1);
    lcd.print(WiFi.localIP());
  } else {
    lcd.setCursor(0, 0);
    lcd.print("WiFi Failed");
  }

  delay(2000);
  lcd.clear();
}

void loop() {
  float ppm = analogRead(mq135Pin);
  float temperature = dht.readTemperature();
  float humidity = dht.readHumidity();

  if (isnan(temperature) || isnan(humidity)) {
    Serial.println("Failed to read DHT sensor!");
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("DHT Error");
    delay(5000);
    return;
  }

  String timestamp = "2025-07-13T14:00:00"; 

  String jsonPayload = "{\"ppm\":" + String(ppm, 2) + 
                       ",\"temperature\":" + String(temperature, 1) + 
                       ",\"humidity\":" + String(humidity, 1) + 
                       ",\"timestamp\"😕"" + timestamp + "\"}";

  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;
    http.begin(serverUrl);
    http.addHeader("Content-Type", "application/json");

    int httpResponseCode = http.POST(jsonPayload);

    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("PPM:" + String(ppm, 0) + " T:" + String(temperature, 0));
    lcd.setCursor(0, 1);
    lcd.print("H:" + String(humidity, 0) + "%");

    if (httpResponseCode > 0) {
      Serial.println("Response: " + http.getString());
    } else {
      Serial.println("POST Error: " + String(httpResponseCode));
    }

    http.end();
  } else {
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("WiFi Lost");
  }

  delay(10000); 
}

