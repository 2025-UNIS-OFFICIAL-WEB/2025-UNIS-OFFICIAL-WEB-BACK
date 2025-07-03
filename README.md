# 🔗 UNIS OFFICIAL WEBSITE (Backend)

📮 배포 주소: 
> UNIS 공식 웹사이트 백엔드 저장소입니다.

## 📁 프로젝트 구조

```
📦unis-backend
 ┣ 📂src
 ┣ 📂config
 ┣ 📂controller
 ┣ 📂service
 ┣ 📂domain
 ┣ 📂repository
 ┣ 📂dto
 ┗ 📜UnisWebServerBackApplication.java
```

## 🚀 기술 스택

- Java 17 / Spring Boot 3.x
- JPA / MySQL
- Gradle
- Docker / GitHub Actions
- AWS EC2 (배포용)

## 🔄 자동 배포 (GitHub Actions)

- `main` 브랜치 푸시 시 EC2 서버에 자동 배포
- `.github/workflows/deploy.yml` 참고

## 🧪 API 명세

> Swagger 문서화 예정

## 🧑‍💻 기여자

| 이름 | 역할 |
|------|------|
| 김겨레 | 코드 리뷰 및 메인에 머지 |
| 이시은 | 추가 필요 |
| 손하늘 | 추가 필요 |

## ✅ Git 협업 규칙

### 1. 브랜치 전략

| 브랜치 이름 | 용도 | 배포 여부 |
|------------|------|-----------|
| `main`     | 운영용 (production) | ✅ 자동 배포 |
| `feat/*`   | 기능 개발용         | ❌ |
| `fix/*`    | 버그 수정용         | ❌ |
| `hotfix/*` | 운영 긴급 패치용    | ✅ `main`으로 직접 PR |

> 예시: `feat/admin-login`, `fix/project-list`, `hotfix/link-error`

### 2. 커밋 컨벤션

형식:  
```
<타입>: <간결한 설명>
```

허용 타입:
- `feat`: 새로운 기능 추가
- `fix`: 버그 수정
- `refactor`: 코드 리팩토링
- `style`: 코드 포맷팅, 세미콜론 누락 등 비기능 변경
- `docs`: 문서 수정
- `test`: 테스트 코드 추가 또는 수정
- `chore`: 기타 변경사항 (빌드 설정, 패키지 업데이트 등)

예시:
```
feat: 어드민 로그인 기능 구현
fix: 프로젝트 리스트 출력 오류 수정
docs: README 브랜치 전략 추가
```

### 3. 협업 규칙

- 모든 작업은 `feat/*`, `fix/*` 등의 **기능/이슈 단위 브랜치**에서 진행합니다.
- 작업 완료 후 `main`으로 **Pull Request**를 생성합니다.
- PR에는 작업 내용 간략히 작성 + reviewer 지정
- 커밋은 가능한 **의미 있는 단위로 분리**해서 작성합니다.
- 머지 권한자는 코드 리뷰 후 직접 머지합니다.

### 4. 기타

- 코드 스타일은 프로젝트 내 formatter 또는 기존 코드 스타일을 따릅니다.
- 외부 API 키나 비밀 설정 정보는 `.env` 또는 환경변수로 관리하고, 절대 커밋하지 않습니다.
- 배포는 `main` 브랜치에 머지될 때 자동으로 수행됩니다 (Docker + GitHub Actions).
