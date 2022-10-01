**Introdução**

A aplicação deve permitir que o usuário digite o código do país para em seguida solicitar os índices históricos. Ou seja, quando o usuário entrar no sistema, irá visualizar um formulário, após o preenchimento e submissão desse, será apresentada uma tabela com o resultado obtido da API do Banco Mundial.

**Requisitos**

* Java sdk 11
* Spring boot
* Docker
* IntelliJ
* Maven 

**Critério de aceite**
Taxa de cobertura de código em 100% em classes
Taxa de cobertura de código em 86% nos métodos
Taxa de cobertura de código em 84% nas linhas

**Execução**

Abrir o projeto no IntelliJ e rodar os comandos abaixo:

* docker build -t bancomundial .
* docker run -p 0.0.0.0:8080:8080 -d bancomundial

**Swaagger**
* http://localhost:8080/swagger-ui.html

**CURL**
* curl -X GET "http://localhost:8080/v1/worldbank/BRA" -H "accept: application/json"
