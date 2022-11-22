# 🍀 다리건너기

# Model

---

### BridgeGame (게임 관리)

- 인스턴스 변수
    - 다리
    - 사용자
    - 총 시도 횟수
    - 성공 여부

- [x] 사용자가 칸을 이동할 수 있는지
- [x] 사용자 칸 이동 및 다리 끝까지 완주했는지
- [x] 위의 결과를 "O", "X"로 변환
- [x] 사용자의 게임 시도 횟수를 증가
- [x] 게임 다시 시도
- [x] 사용자 반환
- [x] 시도 횟수 반환

### BridgeMaker (다리 생성)

- [x] 다리 길이를 입력 받아 다리를 생성

### User (다리 건너는 사람)

- 인스턴스 변수
    - 윗다리
    - 아랫다리
    - 라운드 (사용자가 "U", "D"를 입력한 횟수)
- [x] 윗다리 경로 반환
- [x] 아랫다리 경로 반환
- [x] 이동한 칸 추가
- [x] 라운드 수 올리기
- [x] 라운드 수 반환

### UpDownTable enum

- 열거형 상수
    - UP
    - DOWN
- 인스턴스 변수
    - 움직임 (String)
    - 움직임 (int)
- [x] 움직임 (int)를 넣으면 움직임(String)으로 반환

### RetryQuitTable

- 열거형 상수
    - RETRY
    - QUIT
- 인스턴스 변수
    - 재시작 (String);
    - 재시작 (boolean);
- [x] 재시작 (String)을 넣으면 재시작(boolean)으로 반환

<br>

# View

---

## UI

---

### InputView

- [x] 다리 길이를 입력
- [x] 이동할 칸 입력 (U, D)
- [x] 게임 재시작 / 종료 여부를 입력

### OutputView

- [x] "다리 건너기 게임을 시작합니다." 출력
- [x] "다리의 길이를 입력해주세요." 출력
- [x] "이동할 칸을 선택해주세요. (위: U, 아래: D)" 출력
- [x] 다리 건너기 결과 출력
- [x] "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" 출력
- [x] 게임 결과 출력
- [x] 에러 발생 시 에러메세지 출력

### InputConstants

- [x] 입력 제한 상수

### OutputConstants

- [x] System.out 시, 출력되는 String 상수

## Validator

---

### InputValidator

- [x] 숫자 아닐 시, 에러 발생
- [x] 다리길이 범위 (3 ~ 20)가 아닐 시, 에러 발생
- [x] U, D가 아닐 시, 에러 발생
- [x] R, Q가 아닐 시, 에러 발생

### ErrorConstants

- [x] 에러 발생 시, 출력되는 String

# Controller

---

### Controller

- [x] 초기 세팅
- [x] 한 Round (이동할 칸 입력, 결과 출력, 틀리면 재시작)
- [x] game (Round 실행)
- [x] 게임 실행
