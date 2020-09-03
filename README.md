# Timetable of classes  

## About the project
With it, you can set the schedule from the admin side and view it from the user (student) side. The app is focused on universities.
## Built With
* MySQL - Open-Source Relational Database Management System  

* Client - Frontend/UI
* Thymeleaf - Modern server-side Java template engine for both web and standalone environments.
* Server - Backend
* JDK - Java™ Platform, Standard Edition Development Kit
* Hibernate - is an object-relational mapping tool for the Java
* Spring Boot - Framework to ease the bootstrapping and development of new Spring Applications
* Maven - Dependency Management
* Git - Free and Open-Source distributed version control system  

## Let's get started
Instructions on how to obtain a copy of this software and run it on a local computer for development and testing purposes.  

# What you need to install the software
**JDK 6 and up, Maven 3.0+, MySQL Workbench 8.0 CE **
# Installation  

* Download the zip or clone the Git repository.  

* Unzip the zip file (if you downloaded one)  

* Open Command Prompt and Change directory (cd) to folder containing pom.xml  

* Open application.properties file and change url, password and username For your database  

* Exsicute sql scrypt 'scheduledbnew' which is in the \database  

* Open console in project folder  

* write commands in console  
```bash
mvn compile    
mvn spring-boot:run
```
 
* The app will start running at http://localhost:8080/login  

If everything works correctly, then under the form with the login there should be a login and password to log in as an admin/user  

# Packages
* src/main/java/com/project/controllers/ - controllers;  

* src/main/java/com/project/model/ -model(entities)  

* src/main/java/com/project/repository/ -repositories  

* src/main/java/com/project/security/ -spring security  

* src/main/java/com/project/service/ -services  

* src/main/java/com/project/service/impl -service implementation  

* src/main/java/com/project/Applications.java -main class  

* src/main/resources/templates/ -html pages for frontend  

* src/main/resources/application.properties application properties file  

* /pom.xml - contains all the project dependencies  

* /database/ -contains sql database script  

# About database
![](https://github.com/bylbyl9tor/schedule/blob/master/DatabaseERDiagramm.png)
![](https://github.com/bylbyl9tor/schedule/blob/master/DatabaseLogiSkreen.png)
