# ivLyrics Android 포크 유지보수 지침

마지막 갱신: 2026-08-14

## 작업 전 필수 확인

이 파일은 이 포크의 기준 Knowledge 문서다. 코드를 수정하거나 원본 저장소의
변경 사항을 병합하기 전에 항상 최신 내용을 먼저 읽는다.

## 이 포크에서 반드시 보존할 사항

- GitHub 저장소: `munsy0227/ivLyrics-Android`
- Android 패키지 ID: `kr.ivlis.ivlyricsandroid`
- 앱 기본 글꼴: `NotoSerifCJK-VF.ttf.ttc`의 Noto Serif CJK KR 서체
  (`TTC index 1`, 가변 축 200–900, 기본 굵기 400/600/700)
- 업데이트 저장소 설정: `AppReleaseConfig.java`
- 정식 APK 빌드: `.github/workflows/android-release.yml`
- 업데이트 검증: APK 크기, SHA-256, 패키지 ID, 증가한 `versionCode`, 동일 서명
  인증서를 모두 검사한다. 이 검증을 약화하거나 제거하지 않는다.
- 정식 서명 인증서 SHA-256:
  `C7:13:45:8C:60:2E:39:9F:D5:9A:23:D9:F4:EB:87:DA:32:7C:14:8B:8E:2E:92:97:B6:F7:9F:F1:57:B6:41:35`

원본 `ivLis-Studio/ivLyrics-Android`를 병합할 때 위 항목에 충돌이 생기면 이
포크의 값을 유지한다. 새 원본 기능을 반영하되 업데이트 URL을 원본 저장소로
되돌리거나 Noto Serif CJK 가변 TTC를 다른 폰트로 덮어쓰지 않는다.

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

## 포크 버전 명명 규칙

- `v1.3.2`까지의 기존 릴리스 이름은 변경하지 않는다.
- 다음 릴리스부터 `versionName`은 원본 업스트림 버전 뒤에 포크 릴리스 번호를
  붙인 `{원본버전}.{포크번호}` 형식을 사용한다.
- 같은 원본 버전을 기준으로 포크 릴리스를 추가할 때는 포크 번호를 1씩
  증가시킨다. 예: 원본 `1.3.1` 기준 `1.3.1.1`, `1.3.1.2`.
- 새 원본 버전을 병합하면 포크 번호를 다시 `1`부터 시작한다. 예: 원본
  `1.3.2`를 병합한 첫 포크 릴리스는 `1.3.2.1`이다.
- `versionCode`는 버전 이름과 별개로 이전 정식 릴리스보다 반드시 증가시킨다.
- Git 태그는 기존 규칙대로 정확히 `v{versionName}` 형식을 사용한다.

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
한다. 이전 태그가 없는 첫 릴리스는 Git 기록에서 직전 `versionName`의 커밋을
찾아 비교 기준으로 사용한다. 릴리스 노트는 GitHub 본문 제한보다 작은 120,000자로
제한한다. Actions의 `apksigner` 검증과 위 인증서 SHA-256 일치 검사를 통과하지
못한 APK는 게시하지 않는다. Release 생성 전에 태그가 이미 존재해야 하며,
workflow는 기존 태그를 그대로 사용하고 `target_commitish`를 별도로 보내지 않는다.
이는 Actions의 제한된 토큰으로도 태그 대상을 바꾸지 않고 Release를 게시하기 위한
규칙이다.

## 변경 후 검증

- 최소 검증: `./gradlew :app:lintDebug :app:assembleDebug`
- 릴리스 전: GitHub의 `Android Validation` 성공 확인
- 정식 배포: GitHub의 `Android Release APKs` 성공 확인
- 업데이트 관련 수정 시 `UpdateChecker`, `UpdatePackageVerifier`,
  `AppReleaseConfig`, `MainActivity`의 다운로드 및 설치 흐름을 함께 점검한다.
