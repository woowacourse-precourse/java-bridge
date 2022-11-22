# 미션 - 다리건너기
위아래 둘 중 하나의 칸만 건널 수 있는 다리를 왼쪽에서 오른쪽 끝까지 건너가는 게임

---

## 🚀 기능 요구 사항
- 다리의 길이를 숫자로 입력받고 건너갈 수 있는 칸은 0과 1 중 무작위 값을 이용하여 생성
  - U(출력), 1(생성): 위 칸을 건널 수 있음
  - D(출력), 0(생성): 아래 칸을 컨널 수 있음
- 다리가 생성되면 플레이어가 이동할 칸을 U(위 칸)와 D(아래 칸) 중 하나를 입력
  - 이동한 칸을 건널 수 있다면 O, 건널 수 없다면 X로 표시
- 다리를 끝까지 건너면 게임이 종료
- 다리를 건너다 실패하면 처음에 만든 다리를 재사용하여 게임을 재시작하거나 종료 가능
- 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지 출력 후 그 부분부터 재입력 받음
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형 처리

---

## ✅ 구현 기능 목록
### 입력
- [x] **다리의 길이** (`readBridgeSize`)
  - [x] _[예외] 숫자가 아닌 값을 입력한 경우_
  - [x] _[예외] 3 미만 20 초과의 숫자를 입력한 경우_
- [x] **라운드마다 건널 칸** (위/아래, U/D) (`readMoving`)
  - [x] _[예외] U, D가 아닌 값을 입력한 경우_
- [x] **재시작 여부** (`readGameCommand`)
  - [x] _[예외] R, Q가 아닌 값을 입력한 경우_

### 출력
- [x] **사용자 입력 컨트롤 메세지**
- [x] **라운드 결과** (`printMap`)
- [x] **게임 최종 결과** (`printResult`)
  - [x] 게임 성공 여부 (`printSuccess`)
  - [x] 게임 시도 횟수 (`printTryCount`)
- [x] **에러 메시지** (`printErrorMessage`)

### 로직
- [x] **게임 시작/재시작/종료** (`BridgeGameController`)
- [x] **다리의 길이만큼 0과 1을 이용하여 무작위 값 생성** (`BridgeMaker`)
- [x] 사용자가 입력한 **칸 이동** (`BridgeGam-move`)
  - [x] 사용자 칸 이동 상태 기록 (`BridgeStatus`)
- [x] 사용자가 입력한 **재시도 여부 판단 및 재시도** (`BridgeGame`)
  - [x] 재시도 여부 판단 (`BridgeGame-determineRetry`)
  - [x] 재시도 (시도 횟수 카운트) (`BridgeGame-retry`)
- [x] **에러 핸들링 후 재입력** (`BridgeGameController`)