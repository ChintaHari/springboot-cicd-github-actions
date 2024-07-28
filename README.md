# Spring Boot CI/CD with GitHub Actions and Docker

## Project Overview

This project is a Spring Boot application that demonstrates the use of GitHub Actions for continuous integration and continuous deployment (CI/CD). It includes a basic REST controller that returns a greeting message. The project automates the building, testing, and deployment processes using Maven and Docker.

## GitHub Actions Workflow

The CI/CD process is managed using a GitHub Actions workflow defined in the `.github/workflows/maven.yml` file. The workflow triggers on push or pull requests to the `main` branch. It performs the following steps:

1. **Checkout Code**: Fetches the code from the GitHub repository.
2. **Set up JDK 17**: Sets up Java Development Kit (JDK) 17 using Temurin distribution and caches Maven dependencies.
3. **Build with Maven**: Executes the `mvn clean install` command to build the application and run tests.
4. **Build & Push Docker Image**: Builds a Docker image from the `Dockerfile` and pushes it to Docker Hub using the `mr-smithers-excellent/docker-build-push` action.

### Setting Up GitHub Actions

To set up GitHub Actions for this project, follow these steps:
1. Navigate to your GitHub repository.
2. Click on the "Actions" tab.
3. Click on "New workflow".
4. Set up a workflow yourself or choose a pre-configured Java with Maven workflow.
5. Commit the `.github/workflows/maven.yml` file into your repository under the `.github/workflows` directory.

## Dockerfile Explanation

The `Dockerfile` is configured to perform the following:
- **Base Image**: Uses `openjdk:17` as the base image.
- **Expose Port**: Exposes port 8080 for the application.
- **Add JAR**: Adds the built JAR file from the target directory to the Docker image.
- **Entry Point**: Configures Docker to run the application using `java -jar`.

## Running Locally With Docker

Perfrom the below steps when all the above mentioned steps are done. Because we are trying to pull the latest image after making the GitHub actions push our image to the docker hub.

To run the application locally using Docker, follow these steps after ensuring Docker is installed on your machine:
1. Pull the Docker image:
   
   ```sh
   docker pull hkharikrishna62/springboot-github-actions-image
   ```
2. Run the Docker container:
   
   ``` sh
   docker run -p 8080:8080 hkharikrishna62/springboot-github-actions-image
   ```
3. Access the application at `http://localhost:8080/api/message` to see the greeting message.

## Maven Configuration

The pom.xml file configures Maven for building the Spring Boot application. It specifies dependencies, the Java version, and plugins necessary for building a Spring Boot application. The spring-boot-maven-plugin is configured to handle the packaging of the application into an executable JAR file with the appropriate dependencies.
