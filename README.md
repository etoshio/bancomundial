**Introdução**

A aplicação deve permitir que o usuário digite o código do país para em seguida solicitar os índices históricos. Ou seja, quando o usuário entrar no sistema, irá visualizar um formulário, após o preenchimento e submissão desse, será apresentada uma tabela com o resultado obtido da API do Banco Mundial.

**Requisitos**

* Java sdk 11
* Spring boot
* Docker
* IntelliJ
* Maven 

**Execução**

Abrir o projeto no IntelliJ e rodar os comandos abaixo:

* mvn clean install
* docker build -t my-app .
* docker run -p 0.0.0.0:8080:8080 my-app

**Swaagger**
* http://localhost:8080/swagger-ui.html

**CURL**
* curl -X GET "http://localhost:8080/v1/worldbank/BRA" -H "accept: application/json"
