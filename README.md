# Study

## 소개
회원가입 후 스터디를 개설하거나 신청할 수 있는 시스템입니다.

## 기술 스택
- Spring Boot
- Spring Security (세션 기반)
- MyBatis
- MySQL
- Thymeleaf (HTML)
- Maven

## 기능
1. 회원 기능
    - 회원가입
    - 로그인/로그아웃
    - 마이페이지 (내 스터디, 신청 스터디)
2. 스터디 게시판
    - 스터디 개설
    - 스터디 목록 (검색, 페이징)
    - 스터디 상세
3. 스터디 신청
    - 로그인한 사용자만 신청
    - 중복 신청 방지
    - 정원 초과 시 신청 불가

## 실행 방법
1. MySQL에 `studydb` 데이터베이스 생성 후 `database.sql` 실행
2. `src/main/resources/application.properties`에 DB 정보를 수정
3. 빌드 및 실행
   ```bash
   mvn clean package
   mvn spring-boot:run
