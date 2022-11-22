# 프리코스 4주차 : 다리 건너기

## 기능 구현 목록

### 1. 게임 시작 및 다리 길이 입력 받기

- 게임 시작 메시지 출력 (**OutputView**)
- 다리 길이 입력 받기 (**InputView**)
  - [예외처리] 입력이 숫자가 아닌 경우 (**InputValidation**)
  - [예외처리] 입력된 숫자가 3~20 범위 밖인 경우 (**InputValidation**)
- 게임 시작 및 다리 길이 입력 연결 (**BridgeMaker**)

### 2. 다리 길이에 맞춰 다리 생성

- 다리 길이에 맞춰 다리 생성 (**BridgeMaker**)

### 3. 다리 이동 및 이동 결과 출력

- 다리 이동 입력 메세지 출력 (**OutputView**)
- 이동 방향 입력 받기 (**InputView**)
  - [예외처리] U, D가 아닌 값이 입력된 경우 (**InputValidation**)
- 이동 방향에 따라 다리 이동 (**BridgeMover**)
- 이동 결과 출력 (**OutputView**)
- 출력, 입력받기, 결과 출력 연결 (**BridgeMover**)
- 게임 종료시까지 반복 설정 (**BridgeGame**)

### 4. 실패했을 경우 재시작 여부 메시지

- 실패했을 경우 재시작 여부 입력 메시지 출력 (**BridgeCommand**)
- 재시작 여부 메시지 입력 받기 (**InputView**)
  - [예외처리] R, Q가 아닌 값이 입력된 경우 (**InputValidation**)
- 재시작 여부에 따라 게임 종료 및 재시작 (**BridgeGame**)

### 5. 게임 종료 메시지

- 최종 다리 결과 메시지 출력 (**OutputView**)
- 게임 성공 여부 출력 (**OutputView**)
- 총 시도 횟수 출력 (**OutputView**)