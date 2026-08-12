# ivLyrics Android 포크 유지보수 지침

마지막 갱신: 2026-08-12

## 작업 전 필수 확인

이 파일은 이 포크의 기준 Knowledge 문서다. 코드를 수정하거나 원본 저장소의
변경 사항을 병합하기 전에 항상 최신 내용을 먼저 읽는다.

## 이 포크에서 반드시 보존할 사항

- GitHub 저장소: `munsy0227/ivLyrics-Android`
- Android 패키지 ID: `kr.ivlis.ivlyricsandroid`
- 앱 기본 글꼴: Noto Serif KR의 `Regular`, `SemiBold`, `Bold`
- 업데이트 저장소 설정: `AppReleaseConfig.java`
- 정식 APK 빌드: `.github/workflows/android-release.yml`
- 업데이트 검증: APK 크기, SHA-256, 패키지 ID, 증가한 `versionCode`, 동일 서명
  인증서를 모두 검사한다. 이 검증을 약화하거나 제거하지 않는다.

원본 `ivLis-Studio/ivLyrics-Android`를 병합할 때 위 항목에 충돌이 생기면 이
포크의 값을 유지한다. 새 원본 기능을 반영하되 업데이트 URL을 원본 저장소로
되돌리거나 Noto Serif KR 파일을 Pretendard로 덮어쓰지 않는다.

## 충돌 없는 인앱 업데이트 규칙

1. `applicationId`를 변경하지 않는다.
2. 모든 정식 APK를 같은 영구 릴리스 키로 서명한다.
3. 매 릴리스마다 `app/build.gradle`의 `versionCode`를 이전 값보다 반드시
   증가시킨다.
4. `versionName`도 새 버전으로 변경한다.
5. Git 태그는 정확히 `v{versionName}` 형식으로 만든다. 예를 들어
   `versionName "1.2.4"`의 태그는 `v1.2.4`다.
6. 디버그 APK는 개발 검증 전용이다. 폰 업데이트 배포나 최초 설치에 사용하지
   않는다.
7. 정식 APK와 함께 생성되는 `*-version.json`을 GitHub Release에서 삭제하지
   않는다. 앱이 이 파일의 버전 및 SHA-256으로 APK를 검증한다.

Android는 서명이 다른 APK로 기존 앱을 덮어쓸 수 없다. 과거 디버그 APK 또는
다른 키로 서명한 APK가 설치된 폰은 최초 한 번 앱을 삭제한 후 이 포크의 정식
서명 APK를 설치해야 한다. 그 이후에는 설정 화면의 업데이트 기능으로 데이터와
설정을 유지하면서 설치할 수 있다.

## GitHub Actions 서명 Secrets

다음 Repository Secret 네 개는 항상 유지한다.

- `ANDROID_KEYSTORE_BASE64`
- `ANDROID_KEYSTORE_PASSWORD`
- `ANDROID_KEY_ALIAS`
- `ANDROID_KEY_PASSWORD`

서명 키와 비밀번호는 Git에 커밋하지 않는다. 로컬 백업 기본 위치는
`/home/munsy0227/다운로드/ivlyrics-release-signing/`이다. 이 백업을 잃으면 기존
설치본을 같은 앱으로 업데이트할 수 없으므로 별도의 안전한 저장소에도 복제한다.
키를 의도 없이 새로 만들거나 Secrets를 다른 키로 교체하지 않는다.

## 정식 릴리스 절차

1. 변경 사항을 구현하고 `main`에 푸시한다.
2. `Android Validation` Actions의 lint와 debug build가 통과하는지 확인한다.
3. `versionCode`와 `versionName`이 새 값인지 다시 확인한다.
4. `v{versionName}` 태그를 현재 릴리스 커밋에 만들고 푸시한다.
5. `Android Release APKs` Actions가 성공했는지 확인한다.
6. GitHub Release에 서명된 `*-release.apk`와 `*-version.json`이 모두 있는지
   확인한다.
7. 이전 정식 버전이 설치된 폰에서 앱 내 업데이트 검사를 실행해 실제 설치를
   확인한다.

릴리스 Actions는 태그와 `versionName`이 다르면 실패하도록 설계돼 있다. Discord
Webhook과 AI 릴리스 노트 Secrets는 선택 사항이며 없어도 정식 릴리스가 성공해야
한다.

## 변경 후 검증

- 최소 검증: `./gradlew :app:lintDebug :app:assembleDebug`
- 릴리스 전: GitHub의 `Android Validation` 성공 확인
- 정식 배포: GitHub의 `Android Release APKs` 성공 확인
- 업데이트 관련 수정 시 `UpdateChecker`, `UpdatePackageVerifier`,
  `AppReleaseConfig`, `MainActivity`의 다운로드 및 설치 흐름을 함께 점검한다.
