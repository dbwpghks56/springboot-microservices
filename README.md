# Todo_server

### Caution
공통 Response를 만들어 Swagger 에 나와있는 response와 실제 response가 다를 수 있습니다.  
공통 Response를 만든 이유는 API 를 사용하는 곳에서 response가 일관성있게 나오기 때문에 사용하기 쉽고  
규칙이 적용되어있기 때문에 재사용성과 향후수정 및 에러 처리에도 좋기때문이라고 생각합니다.
<hr>

### Technologies used:

• Java 17   
• Spring Boot 3.1.4    
• Swagger 3.0        
• JWT   
• QueryDsl  
• Spring Security (Security)    
• JPA   
• mySQL    
• Spring Cloud    
  - Eureka server, client
  - API Gateway
  - config server
  - LoadBalancer
  - cloud bus
       
• Micrometer, zipkin ( microservice log trace)    
• RabbitMQ

## Installation

```bash
$ git clone https://github.com/dbwpghks56/springboot-microservices.git
```

## Running the app
실행해야되는 서버가 굉장히 많아서 Docker Compose로 한 번에 실행 및 관리하기 위해 수정 중입니다. <br>
local 실행의 경우 service-registry 우선 실행 뒤 나머지 순차적으로 실행해주시면 됩니다. <br>
<br>
실행전 실행할 yml 을 설정해서 실행해주어야 합니다.  
Intellij의 경우 [예시](https://velog.io/@dbwpghks56/Spring-Boot-%EC%9A%B4%EC%98%81%ED%99%98%EA%B2%BD%EB%B3%84-yml-%EC%84%A4%EC%A0%95) 를 보고 설정해주세요.   
접근한 뒤 main 을 실행해주시면 됩니다. <br>
clean gradle 및 build gradle 이 필요한 경우도 있습니다. <br>

## ERD
간단한 마이크로 서비스 프로젝트이기 때문에 각 서버는 데이터베이스가 전부 다릅니다.    

# Projects Structure

 본 프로젝트는 `Package by feature` 형태이며, **Microservice 아키텍처**로 구성되어 있습니다.

 하기에서 설명하는 프로젝트 구조는 간략한 설명입니다.

## /service-registry

Default Package: net.javaguides.serviceregistry

- Spring cloud 의 Eureka server 를 맡고 있습니다. API gateway, LoadBalancer 등 Eureka server 와 연동되어 있는 서버를 이용해 이루어집니다.

## /config-server
Default Package: net.javaguides.configserver
- Eureka server 에 client로 등록되어있습니다.
- 각 Microservice server 들의 .yml config 들을 서버로 모아서 microservice server 를 재시작하지 않고 actuator restart 등을 호출하는 것으로 변경된 config 파일을 적용할 수 있습니다.    
해당 config 파일들은
```
https://github.com/dbwpghks56/config-server-repo.git
```
에 보관되어 있으며 rabbitMQ 를 이용해 server 재시작하지 않고 적용할 수 있습니다. (cloud bus 이용)

## /api-gateway

Default Package: net.javaguides.apigateway
- Eureka server 에 client로 등록되어있습니다.
- 해당 서버에 등록되어 있는 엔드 포인트로 api 를 요청할 시 Eureka 를 통해 LoadBalancer 및 api를 적절한 server 에 요청합니다.

## / *-service

Default Package: net.javaguides.*service
- Eureka server 에 client로 등록되어있습니다.
- service 가 붙은 폴더는 해당 기능에 대한 service 로직 및 contoller 가 존재하는 폴더입니다.
- 각자 Eureka 서버에 client 로 등록되어있으며, 각기 다른 DB 와 연동되어 있습니다.

## Swagger
microservice server 마다 port 번호가 다르니 확인 후 진입해주세요.
```
swagger (Api 명세) 접근 주소입니다.
http://localhost:8090/api/v1/swagger-ui/index.html
or
http://127.0.0.1:8090/api/v1/swagger-ui/index.html

```
접속하면 Api 명세를 볼 수 있습니다.

### JWT
JWT 를 이용해서 클라이언트단에서 token을 이용해 직접 정보를 관리하도록 설정했습니다.     
accessToken의 경우 4일, refreshToken의 경우 일주일을 만료기간으로 설정했습니다.    
refreshToken의 경우 cookie에 Httponly로 저장하여 보안을 높였습니다.

해당 프로젝트의 경우 Jwt의 발급은 user-service 에서 이루어지고 Jwt 및 사용자 인증/인가는 APi gateway filter 를 이용해 user를 판단합니다.    
API gateway filter는 작업 예정입니다.

### Spring Security (Security)
Security 설정을 추가해 인가된 사용자만 특정 URL에 접근할 수 있도록 제한했습니다.   
Anonymous 가 접근할 수 있어야 하는 API는 permitAll()을 선언했습니다.  
또한 ROLE_USER, ROLE_ADMIN 등 권한에 대한 인가가 필요하지만 요구사항에 없기에 삭제했습니다.

### JPA & QueryDSL (ORM)
객체 중심 domain 설계 및 반복적인 CRUD 작업을 대체해 비즈니스 로직에 집중했습니다.  
• JPA : 반복적인 CRUD 작업을 대체해 간단히 DB에서 데이터를 조회합니다.   
• QueryDSL : JPA로 해결할 수 없는 SQL은 QueryDSL로 작성합니다.

### Spring Cloud

Microservice 를 편하게 개발 및 사용하기 위해 Spring cloud 를 이용했습니다. 사용해보니 굉장히 강력하고 개발자에게 편하다고 생각됩니다.    
Spring cloud를 이용하면서 개발 및 공부를 해보면서 MSA 의 단점도 보였지만, 결국 장점이 더 거대하고 단점을 가릴만큼 매력적이라고 생각합니다.    
    
### Micrometer, zipkin

MSA 의 단점 중 하나인 로그추적을 도와주는 라이브러리입니다.    
zipkin 서버를 따로 켜야하지만 docker를 이용한다면 어려운 일은 아니었습니다.

### RabbitMQ

Spring cloud config server, cloud bus 에서 config 파일의 변경을 server 재시작이 아닌 actuator로 실시간 적용하기 위해 사용하였습니다.    
해당 기능은 .yml 등 설정파일이 변경되어도 server 를 재시작할 필요가 없었기 때문에 편리하다고 느껴졌습니다




