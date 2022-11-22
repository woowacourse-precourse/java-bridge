## 4주차 기능 요구사항 정리

**💡 구현 기능 🚫 예외 사항 ✏️ 입력 사항 🖨️ 출력 사항**

<br>

### ****📌**** 미션 주제

**⬆️ 위 ⬇️ 아래 둘 중에 하나의 칸만 건널 수 있는 다리를 끝까지 건너는 게임**

- 다리는 왼쪽에서 ➡️ 오른쪽으로 건넌다.
- ⬆️ 위 ⬇️ 아래 둘 중에 하나의 칸만 건넌다.

<br>

---

### ****📌**** 기능 요구사항 정리

💡 게임 시작 : `BridgeGameService - startBrideGamee`

- 🖨️ [출력 1] `다리 건너기 게임을 시작합니다.` : `OutputView - printStartGame`

- 🖨️ [출력 2] `다리의 길이를 입력해주세요.` : `OutputView - printEnterBridgeSize`

<br>

💡 게임 동작 `BridgeGameService - playBridgeGame`


- ✏️ [입력 1] 자동으로 생성할 다리 길이를 숫자로 입력받고 다리를 생성한다. : `InputView - readBridgeSize`


- 다리를 생성할 때 위의 칸과 아래 칸중에 건널 수 있는 칸은 무작위 값 (0또는 1)을 이용해서 정한다.
  - 🚫 무작위 값이 0과 1이 아니면 예외 : `BridgeRandomNumber - checkInvalidRandomNumber`
      - (test) : “123”, “#24”, 2
- 💡 다리 생성 클래스를 통해, 생성한 다리를 얻어오는 기능 : `BridgeMaker - makeBridge`
    - 💡 0, 1 → U, D 으로 바꾸는 기능 : `BridgeMaker - convertRandomToDirection`
- 🚫 다리 길이가 숫자가 아닌 값이면 예외 : `BridgeSize - isNotNumeric`
    - (test) : “abc”, “#24”
- 🚫 3이상 20이하의 숫자 입력 → 아니면 예외 : `BridgeSize - checkInvalidRange`
    - (test) : -323, 0, 21c
- 다리가 생성되면 이동할 칸을 선택한다.


---


#### 💡 다리 건너기 `BridgeGameService - moveCrossBridge`

- 🖨️ [출력 3] `이동할 칸을 선택해주세요. (위: U, 아래: D)` : `OutputView - printSelectMoveDirection`

- ✏️ [입력 2] 라운드마다 플레이어가 이동할 칸을 입력 받는다. : `InputView - readMoving`

<br>

- 이동할 때 ⬆️ 위의 칸은 U, ⬇️ 아래칸은 D : `Direction`
    - 💡무작위 번호로 Direction 찾기 : `Direction - findDirectionByNumber`
  
    
- 💡다리 건너기 : `BridgeGame - move`
    - 💡다리 건넌 횟수 증가시키기 `BridgeGame - addMovingCount`


- 💡이동한 칸을 건널 수 있는지 확인하는 기능 : `BridgeGame - checkCanMoving`
- 💡이동한 칸을 O또는 X 으로 표시하는 기능 : `BridgeGame - setMovingResult`
- 💡 마지막 이동한 칸의 결과(O또는 X)를 저장 : `BridgeGame - setLastMoving`


- 💡 이동한 칸들을 리스트에 저장하는 기능 : `Bridge - setMovingBridge`
- 💡 마지막 다리 결과들을 저장하는 리스트 : `Bridge - setLastBridge`


- 🚫 문자 길이가 1이 아니면 예외 : `Moving - isNotOneCharacterg`
    - (test) : “abc”, “”
- 🚫 U와 D가 아닌 값이 들어오면 예외 : `Moving - checkInvalidMoving`
    - (test) : ‘u’, 1, “UD”

**<다리 건너기 결과 출력 형식>**

- 🖨️ 다리 결과 출력하기 : `OutputView - printMap`
    - `initStringBuilder, setPrintMap, finishStringBuilder`

  (1) 이동한 칸을 건널 수 있으면 O로 표시, 안되면 X으로 표시

  (2) 선택하지 않은 칸은 공백 한칸으로 표시

  (3) 다리의 시작은 `[`, 다리의 끝은 `]` 으로 표시

  (4) 칸의 구분은 `|` (앞뒤 공백 포함) 문자열로 구분

  (5) 현재까지 건넌 다리 모두 출력

- 다리를 끝까지 건너면 게임 종료
---

#### 💡 게임 재시작 조건 체크 : `BridgeGameService - checkRestartCondition`

#### 💡 게임 재시작여부 : `BridgeGameService - selectGameRestart`

- 🖨️ [출력 4] `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)` : `OutputView - printEnterGameCommand`

- ✏️ [입력 3] 다리를 건너다 실패하면 게임 재시작/종료 여부 입력 받기 : `InputView - readGameCommand`


- 🚫 재시작(R)과 종료(Q)가 아닌 값이 들어오면 예외 : `GameCommand - checkInvalidGameCommand`
    - (test) : “RQ”, ‘r’, 1
- (1) 재시작 → 다리 재사용하기 : `BridgeGame - retry`
    - 💡 다음 게임에 사용할 다리를 초기화하는 기능 : `Bridge - initBridge`
        - (test) : 이전게임다리.equals(재시작게임다리)
    - 💡 다리 건넌 횟수 초기화 : `BridgeGame - initMovingCount`
    - 💡 총 게임 시도 횟수 증가 : `BridgeGame - addGameCount`


- (2) 종료


---
- 🖨️ [출력 5] `최종 게임 결과 출력하기` : `OutputView - printResult`


- 최종 게임 결과 : `printGameFinalBridgeResult`
- 게임 성공 여부 : `printGameSuccessOrFailure`
- 총 시도한 횟수 출력 : `printGameTotalTryCount`

```java
최종 게임 결과
[ O | X ]
[   |   ]

게임 성공 여부: 실패
총 시도한 횟수: 1 
```

- 총 시도한 횟수 : 첫 시도를 포함해서 게임을 종료할 때까지(1차~N차) 시도한 횟수
- 게임을 성공 했을 경우 : 최종 게임 결과(성공한 결과), 게임 성공 여부(성공)
- 게임을 실패 했을 경우 : 최종 게임 결과(마지막 게임결과), 게임 성공 여부(실패)

    →  게임 성공 시 자동 종료되어 `성공한 결과 = 마지막 결과`이므로 최종 게임 결과는 마지막 게임 결과를 출력


---
🖨 [출력 6] `에러 상황 시 에러 문구 출력`

- 잘못된 값 입력 시 IllegalArgumentException 발생 후 `[ERROR]` 로 시작하는 에러 메시지 출력
    - 💡 `[ERROR]`로 시작하는 에러 메시지 출력
        - `BridgeError - getErrorMessage, ErrorException`
    - ✏️ 프로그램을 종료하지 않고, 그 부분부터 입력을 다시 받는다.
        - `InputView - checkInputObject, checkInputMethod, repearForVaild`

<br>

- `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
    - `IllegalArgumentException`
        - 인수로 부적절한 값이 들어 올때 예외를 나타내기 위해 발생한다.
        - ex. 문자열 입력에 정수를 넣은 경우, 최대 길이에 맞지 않는 입력인 경우
    - `IllegalStateException`
        - 일을 수행하는 데에 적절하지 않은 경우 예외를 나타낸다.
        - ex. 결과값이 없는 경우


- 실행 결과 예시

```java
[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
```

---

### ****📌**** 요구 사항 클래스 정리

#### InputView

- 사용자로부터 입력을 받는 역할을 하는 클래스
- 메소드의 시그니처(인자, 이름)와 반환 타입은 변경 가능하다.
- 필요 메소드 추가가 가능하다.<br>
(1) int readBridgeSize() : 다리의 길이를 입력 받는다.<br>
(2) String readMoving() : 사용자가 이동할 칸을 입력 받는다.<br>
(3) String readGameCommand() : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.

#### OutputView

- 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
- 출력을 위해 필요한 메소드의 인자는 자유롭게 추가하거나 변경 가능하다.
- 필요 메소드 추가가 가능하다.<br>
(1) void printMap() : 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.<br>
(2) void printResult() : 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.

#### BridgeGame

- 다리 건너기 게임을 관리하는 클래스
- 필드 추가 가능
- 메소드 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능하다.
- 필요 메소드 추가가 가능하다.<br>
(1) void move() : 사용자가 칸을 이동할 때 사용하는 메소드<br>
(2) void retry() : 사용자가 게임을 다시 시도할 때 사용하는 메소드

#### BridgeMaker

- 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 하는 클래스
- 필드를 변경할 수 없다.
- 메소드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.<br>
(1) List<String> makeBridge(int size) : 입력 길이에 해당하는 다리 모양. 위(”U”), 아래(”D)로 표현

#### BridgeRandomNumberGenerator & BridgeNumberGenerator

- 무작위 값(0또는 1)을 생성해주는 역할을 하는 클래스
- 코드 변경 불가능  = 패키지 변경 불가능
- 무작위 값 생성 예시
```java
int number = bridgeNumberGenerator.generate();
```