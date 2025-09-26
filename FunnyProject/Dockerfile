FROM tomcat:9.0-jdk11-temurin

WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

COPY ROOT.war webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]