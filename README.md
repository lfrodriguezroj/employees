# Employees Api

This project is a Spring Boot application that demonstrates the implementation of a web application using the Java-based Spring framework. The application is packaged as a WAR (Web Application Archive) file and can be deployed to a compatible servlet container.

## Prerequisites

Before running the Employees Api, ensure that you have the following installed on your system:

- Java Development Kit (JDK) version 17 or higher
- Maven build tool
- A compatible servlet container (e.g., Apache Tomcat)

## Getting Started

To run the Employees Api on your local machine, follow the steps below:

1. Clone the project repository:
```
git clone https://github.com/lfrodriguezroj/employees.git
```
2. Navigate to the project directory:
```
cd employees
```
3. Build the project using Maven:
```
mvn clean package
```
This command compiles the source code, runs the tests, and packages the application into a WAR file.

4. Deploy the WAR file to your servlet container:

- For Apache Tomcat: Copy the generated `employees-0.0.1-SNAPSHOT.war` file from the `target` directory and paste it into the `webapps` directory of your Tomcat installation.

5. Start your servlet container.

6. Access the application:

Once the servlet container is up and running, you can access the application by opening a web browser and navigating to `http://localhost:8080/employees-0.0.1-SNAPSHOT`.

# Endpoints

### GET /api/v1/employees
``` json
[
    {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": "",
        "employee_anual_salary": 3849600
    },
    {
        "id": 2,
        "employee_name": "Garrett Winters",
        "employee_salary": 170750,
        "employee_age": 63,
        "profile_image": "",
        "employee_anual_salary": 2049000
    },
    {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": "",
        "employee_anual_salary": 1032000
    }
]
```

### GET /api/v1/employees/1
``` json
{
	"id": 1,
	"employee_name": "Tiger Nixon",
	"employee_salary": 320800,
	"employee_age": 61,
	"profile_image": "",
	"employee_anual_salary": 3849600
}
```
