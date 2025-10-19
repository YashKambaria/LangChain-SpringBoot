# LangChain + Spring Boot (LangChain4j)

A simple Spring Boot project to learn and implement **LangChain in Java** using [langchain4j](https://github.com/langchain4j/langchain4j).

##  Features
- Simple REST API using Spring Boot
- Clean text response (no raw object)
- Easy to extend (memory, tools, RAG)

## 🛠 Tech Stack
- Java 17+
- Spring Boot 3.x
- LangChain4j

## ⚙️ Setup
```bash
git clone git@github.com:YashKambaria/LangChain-SpringBoot.git
cd langchain-spring-boot
mvn clean install
mvn spring-boot:run
```

## Configuration (application.yml)

```
openai:
  api-key: "sk-or-xxxxxxxxxxxxxxxxxxx"
  base-url: "https://xxx"
  model: "modelName"
```
