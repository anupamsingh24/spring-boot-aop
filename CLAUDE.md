# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**springaop** is a Spring Boot 4.1.0 project demonstrating Aspect-Oriented Programming (AOP) patterns. It showcases custom AOP aspects that intercept method calls for logging and performance monitoring.

## Key Architecture

The project uses Spring AOP with `@EnableAspectJAutoProxy` enabled in the main application class. Two main aspects are implemented:

1. **LoggingAspect** (`src/main/java/com/anupamsingh/springaop/aop/LoggingAspect.java`)
   - Intercepts all controller methods
   - Logs before and after method execution using SLF4J
   - Uses `@Pointcut` to target `com.anupamsingh.springaop.controller.*.*(..)` method signature

2. **TaskExecutionAspect** (`src/main/java/com/anupamsingh/springaop/aop/TaskExecutionAspect.java`)
   - Intercepts methods annotated with `@TaskExecution` custom annotation
   - Measures and logs execution time using `@Around` advice
   - Uses `ProceedingJoinPoint` to wrap method execution

The `@TaskExecution` annotation (`src/main/java/com/anupamsingh/springaop/annotation/TaskExecution.java`) is a marker annotation for runtime retention that targets methods only.

## Build & Development

**Maven is the build tool.** Use the Maven wrapper (`./mvnw`) for consistency:

- **Build**: `./mvnw clean install`
- **Run application**: `./mvnw spring-boot:run`
- **Run tests**: `./mvnw test`
- **Run specific test**: `./mvnw test -Dtest=SpringaopApplicationTests`
- **Compile only**: `./mvnw clean compile`
- **View dependencies**: `./mvnw dependency:tree`

Java version: 25 (configured in `pom.xml`)

## Dependencies

- **Spring Boot Starter WebMVC** — Web framework
- **Spring Boot Starter AOP** (v3.4.0) — AOP support
- **Lombok** — Reduces boilerplate; used in LoggingAspect with `@Slf4j`
- **Spring Boot Starter WebMVC Test** — Testing (scope: test)

## Key Files

- `src/main/java/com/anupamsingh/springaop/controller/PaymentController.java` — REST endpoint example
- `src/main/java/com/anupamsingh/springaop/dto/Payment.java` — Data transfer object
- `src/main/resources/application.properties` — Spring Boot configuration
- `pom.xml` — Maven configuration with Lombok annotation processor setup

## Git Workflow

- Main branch: `main`
- Recent commits focus on adding task execution aspect and CI/CD setup (maven.yml)
- Currently has a modified file: `src/main/java/com/anupamsingh/springaop/aop/TaskExecutionAspect.java`