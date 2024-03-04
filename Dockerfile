FROM maven:3.8.4-openjdk-17 AS builder

RUN mkdir /app

WORKDIR /app

COPY . .

RUN mvn clean package

FROM maven:3.8.4-openjdk-17

WORKDIR /app

# Копирование файлов исходного кода
COPY . .

# Команда для запуска приложения
CMD ["mvn", "spring-boot:run"]