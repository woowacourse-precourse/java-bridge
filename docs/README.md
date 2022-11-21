# 📚 기능목록

# ⌨️ 사용자 입력을 받는다. - `InputView`

- 다리길이 입력 #readBridgeSize
    - ⚠️ 숫자가 아니면 예외
    - ⚠️ 3 ~ 20 사이의 숫자가 아니면 예외
- 이동 방향 입력 #readMoving
    - ⚠️ U, D 값이 아니면 예외
- 게임 재시작 여부 입력 #readGameCommand
    - ⚠️ R, Q 값이 아니면 예외

## 🖥️ 게임 진행 상황과 결과를 출력한다. - `OutputView`

- 게임 시작 메시지 출력 #printInit
- 게임 진행상황을 출력 #printMap
- 게임 종료 후 결과 출력 #printResult

---

## 🎮 게임 진행과정을 관리한다. - `GameController`

- 게임시작 #play

---

## 🏃 다리 건너기 게임을 진행한다. - `BridgeGame`

- 사용자가 칸을 이동 #move
    - 게임 성공 여부를 확인 #isWin
- 게임 재시작 #retry
- 진행 상태를 확인 #getStatus
- 진행 횟수를 확인 #getTryCount
- 진행 과정을 확인 #getResultMap

### 📝 진행 과정을 기록한다. - `BridgeLogger`

- 진행과정을 기록 - #log
- 진행 과정을 반환 - #toString
- 초기화 - #clear

## 🛠️ 다리를 생성해준다. - `BridgeMaker`

- 다리를 생성한다. #makeBridge
    - ⚠️ 3 ~ 20 사이의 숫자가 아니면 예외

---

## 🙋‍♂️ 사용자 - `User`

- 상태 초기화 #init
- 입력된 방향으로 이동 #move
    - ⚠️ U, D 값이 아니면 예외
- 걸음수(이동한 칸)를 확인 #getStep
- 생존여부를 확인 #isLive

## 🌉 다리 - `Bridge`

- `List<Floor>`의 일급컬렉션
- 주어진 index와 방향이 안전한지 확인 #isSafe
- 다리의 크기 #size

### 바닥 - `Floor`

- 주어진 값과 일치하는지 확인 #isSafe
    - ⚠️ U, D 값이 아니면 예외

---

## Enum

### 💬 Message

- 게임 진행간 출력되는 안내메시지 #GameMessage
- 에러메시지 #ErrorMessage

### ✅ Status

- 게임의 진행상황 #GameStatus
- 다리의 상태값 #BridgeStatus

### ⌨️ Command

- 게임 진행간 이동 Command #MoveCommand
- 게임 재시작, 종료 Command #GameCommand