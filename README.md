# 🔗 UNIS OFFICIAL WEBSITE (Backend)

![CI/CD](https://github.com/2025-UNIS-OFFICIAL-WEB/2025-UNIS-OFFICIAL-WEB-BACK/actions/workflows/deploy.yml/badge.svg)

📮 **배포 주소:**  
👉 {추가 예정}

> UNIS 공식 웹사이트의 백엔드 저장소입니다.  
> Java 21 / Spring Boot 기반이며, 자동 배포 및 `.env` 환경변수 주입 방식을 사용합니다.


## 📦 프로젝트 구조

```
📦unis-backend (루트)
 ┣ 📂common         # 공통 유틸 / 상수 / 예외 등
 ┣ 📂api-server     # 메인 API 서버 (포트 8080)
 ┣ 📂admin-server   # 관리자 서버 (포트 8081)
 ┗ 📜settings.gradle
```

> **멀티모듈 구조**로 구성되어 있으며, 공통 코드(`common`)을 각 서버(`api-server`, `admin-server`)에서 의존합니다.


## 🚀 기술 스택

- Java 21 / Spring Boot 3.x
- Gradle 멀티모듈
- JPA / MySQL
- Docker / GitHub Actions
- AWS EC2


## 🔄 자동 배포 (CI/CD)

- `main` 브랜치에 push하면 GitHub Actions가 실행됩니다.
- `.github/workflows/deploy.yml` 워크플로우를 통해 EC2로 자동 배포됩니다.

### 배포 프로세스

1. `./gradlew build -x test` (테스트 생략 빌드)
2. Docker 이미지 빌드 → ECR 푸시
3. EC2 서버에 SSH 접속
4. 기존 컨테이너 종료 후 새 컨테이너 실행


## 🧪 API 명세

- Swagger UI 주소: `http://<EC2 주소 또는 도메인>:8080/swagger-ui.html`

### Swagger 문서 작성 규칙 예시

```java
@Operation(summary = "프로젝트 목록 조회")
@GetMapping("/projects")
public ApiResponse<List<ProjectResponse>> getProjects() {
    ...
}
```

- `@Tag`, `@Operation`, `@Parameter` 등 명확하게 작성 필수


## ✅ DTO 및 컨트롤러 작성 규칙

### 유효성 검증 예시

```java
public class CreateProjectRequest {
    @NotNull @Size(min = 1, max = 100)
    private String title;
}

@PostMapping("/projects")
public ApiResponse<Void> create(@Valid @RequestBody CreateProjectRequest request) {
    ...
}
```

### 네이밍 규칙

| 역할        | 네이밍 예시              |
|-------------|---------------------------|
| Controller  | `ProjectController`       |
| Service     | `ProjectService`          |
| 요청 DTO    | `CreateProjectRequest`    |
| 응답 DTO    | `ProjectResponse`         |


## 🧑‍💻 기여자

| 이름   | 역할                    |
|--------|-------------------------|
| 김겨레 | 코드 리뷰 및 메인 머지 |
| 이시은 | 추가 필요              |
| 손하늘 | 추가 필요              |


## ✅ Git 협업 규칙

### 1. 브랜치 전략

| 브랜치 이름 | 용도               | 배포 여부 |
|-------------|--------------------|------------|
| `main`      | 운영용 (production) | ✅ 자동 배포 |
| `feat/*`    | 기능 개발          | ❌         |
| `fix/*`     | 버그 수정          | ❌         |
| `hotfix/*`  | 운영 긴급 패치     | ✅         |

예시: `feat/admin-login`, `fix/project-list`, `hotfix/link-error`

### 2. 커밋 컨벤션

형식: `<타입>: <간결한 설명>`

허용 타입:
- `feat`: 새로운 기능 추가
- `fix`: 버그 수정
- `refactor`: 리팩토링
- `style`: 포맷팅 등 비기능 변경
- `docs`: 문서 수정
- `test`: 테스트 코드
- `chore`: 기타 설정, 빌드 등

예시:

```
feat: 어드민 로그인 기능 구현
fix: 프로젝트 리스트 출력 오류 수정
docs: README 브랜치 전략 추가
```

### 3. PR 라벨 설명

| 라벨 이름          | 설명                               |
|-------------------|------------------------------------|
| 🚀 `feat`          | 새로운 기능 추가                     |
| 🐞 `fix`           | 버그 수정                            |
| 🧹 `refactor`      | 코드 리팩토링 (기능 변화 없음)         |
| 📝 `docs`          | 문서 수정                            |
| 🚨 `urgent`        | 긴급 배포 / Hotfix 관련               |
| 👀 `review-needed` | 리뷰 요청 상태 (수동으로 붙임)         |
| 🎨 `design-check`  | 디자이너 확인 필요 (UI/UX 변경 포함)    |

> 자동 라벨은 브랜치 이름 패턴 (예: `feat/xxx`, `fix/xxx`) 에 따라 자동 적용됩니다.

### 4. 협업 규칙

- 모든 작업은 `feat/*`, `fix/*` 등 브랜치에서 수행
- 완료 후 `main`으로 Pull Request 생성
- PR에는 작업 내용 요약 및 Reviewer 지정
- 의미 있는 단위로 커밋 작성
- 머지는 코드 리뷰 후 권한자가 수행
