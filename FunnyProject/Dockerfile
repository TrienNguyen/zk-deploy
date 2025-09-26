# Stage 1: Build WAR với Maven
FROM maven:3.9.6-eclipse-temurin-11 AS build
WORKDIR /app

# Copy toàn bộ source code vào container
COPY . .

# Build ra file WAR (bỏ qua test cho nhanh)
RUN mvn -DskipTests clean package

# Stage 2: Run WAR bằng Tomcat
FROM tomcat:9.0-jdk11-temurin
WORKDIR /usr/local/tomcat

# Xoá webapp mặc định
RUN rm -rf webapps/*

# Copy WAR build từ stage 1 thành ROOT.war
COPY --from=build /app/target/*.war webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
