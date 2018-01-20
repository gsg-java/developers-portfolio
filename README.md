# CoduckFolio (가칭)

- 개발자 포트폴리오 사이트 프로젝트

## Spec

- Java 8
- Spring Boot 1.5.9

---

## GIT FLOW

- master : 배포 버전만!
- develop : 개발 브런치
- feature/{git_issue} : 이슈 단위 개발 브런치

### 규칙

- feature 브런치는 반드시 최신 develop 상태를 반영한다.
    - merge 전 확인 필수
    - rebase 활용
- feature 브런치명은 git issue 를 따른다.
    - ex) feature/cf1 (cf는 project 이름 약자)
- commit message 맨 앞에 [#{git_issue_no}]를 항상 붙인다.
    - ex) [#1] ---- bug fix.

---

## 주요 기능

### 1. 회원

- Oauth2 기반
- Github 만 연동

### 2. 포트폴리오 작성/수정

- 회원 기반
- 포트폴리오 작성을 위한 Form 제공

#### 포트폴리오 상세

- 개인정보 일부(이름, email)
- github 주소
- 기술스택
- 구직 여부(github 연동)
- 프로젝트
- github 기반 정보

### 3. 개인 포트폴리오 페이지

ex) coduckfolio.com/kingbbode

- 데이터
    - 회원이 입력한 데이터
    - Github 데이터 (github api)
- 화면
    - 데이터를 기반으로 보기 쉬운 화면을 구성.
    
### 4. 메인

- 회원 데이터 종합
- Github 데이터 종합