## Introduction

SpringCloud를 활용한 MSA 구현 샘플 코드

## 개발환경
- Kotlin
- Springboot 3.0.0
- SpringCloud 2022.0.1 (Springboot 3.x 버전과 호환을 위해서는 최소 2022.0.0 이상 버전을 사용)
- Hexagonal Architecture
    - Reference - https://github.com/thombergs/buckpal

## 서비스 구성

### Gradle
- Parent - Child 방식을 활용하여 공통으로 사용하는 Library의 경우 Root의 build.gradle.kt에 추가하고, 각 MS에서만 별도로 사용하는 Dependency만 별도 추가

### Gateway
- 외부 Client의 요청의 경우 반드시 Gateway를 통해 진입
- Routing Rule 중에서 url prefix 기준으로 포워딩해야하는 MS를 찾아서 해당 Micro Service로 요청을 포워딩

### Eureka
- MSA를 구성하는 모든 인스턴스의 상태 관리 및 Load Balancer 역할을 담당 (모듈별로 두 개 이상의 인스턴스를 운영하는 경우 트래픽 분배 혹은 무중단 배포를 위해서는 Load Balancer가 필요하나, Eureka를 구성하면 Load Balancer 없이도 위 역할을 수행할 수 있다.)

### Micro Service
- 해당 예제에서는 간단히 Product, Order, User 3개의 모듈로 구성
- MSA 구현에 집중하기 위해 별도 DB 연결없이 구현
- 각 Micro Service 간 통신의 경우 Feign Client를 이용하여 구현

### Common
- 모듈별로 별도 프로젝트로 구분되어 있어, 공통으로 사용하는 Class의 경우 중복으로 선언해야 하는 상황이 발생할 수 있음.
- 이러한 중복을 피하기 위해서 두 개 이상의 모듈에서 선언하는 Class의 경우 이 Common 모듈에 사용하고, Gradle을 이용하여 Common 모듈에서 필요한 Class를 가져올 수 있도록 개발 예정

## 실행 방법 (IntelliJ 기준)
각 모듈별 Port 정보 (각 모듈 프로젝트의 application.yml 정의)

- Gateway - 8080
- Eureka - 8761
- User - 8081
- Product - 8082
- Order - 8083

각 모듈별 {ModuleName}Application 파일을 실행
- 순서는 Eureka → Gateway → Micro Service 로 진행

API 호출 (예시)

```java
// http://{gateway's domain}/{module_name}/{path} 형태로 구성

// 단일 상품 조회 - 1번 Product 조회
GET http://localhost:8080/products/1

// 주문 생성
POST http://localhost:8080/orders
```

## Production 배포를 위해서 추가로 필요한 사항들

### 인증
- 일반적으로 Gateway에서 인증 절차를 거친 후 인증된 요청에 한 해 각 모듈로 요청을 포워딩

### 배포
- 배포 시 대상 모듈 + Common 형태로 배포가 될 수 있게 Docker Image를 생성하는 Script 작성 필요

### 모니터링
- Spring Application의 경우 Prometheus + Grafana 조합을 많이 사용하고 있음. Prometheus dependency를 추가하여 Prometheus가 데이터를 수집할 수 있도록 Endpoint 제공 (일반적으로 Dependency를 추가하면 https://{domain}/actuator/prometheus Endpoint로 메트릭 정보 제공)

### 로깅
- ELK 환경 구성하여 로그 수집 및 대쉬보드 구성