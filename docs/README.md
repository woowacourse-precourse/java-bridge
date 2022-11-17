## 🚀 기능 요구 사항

### 기능 순서도

위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력받고 생성한다.
    - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
    - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
    - 재시작해도 처음에 만든 다리로 재사용한다.
    - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

#### 실행 결과 예시
```
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요
3 -> 

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]   
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
R 

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   ]
[   | O ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   |   ]
[   | O | O ]

최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

### 클래스 분리

- 길이 입력
- 정답 리스트 생성
- 이동칸
  - 일치 했을 때 -> checkBridge
    - 도달하지 못했을 때
      - 다시 이동 메소드 move
    - 끝까지 도달했을 때 checkEnd
      - 게임 성공 여부 메시지 - printResult
      - 게임 시도 횟수 메시지 - printTryCount
  - 일치 안했을 때
    - 종료
    - 재시작 - retry(BridgeGame)
      - BridgeMap 초기화
      - 이동메시지, move

### OutMessage enum
1. START_MESSAGE
   - [ ] 다리 건너기 게임을 시작합니다.
2. INPUT_BRIDGE_MESSAGE
   - [ ] 다리의 길이를 입력해주세요.
3. INPUT_MOVE_MESSAGE
   - [ ] 이동할 칸을 선택해주세요. (위: U, 아래: D)
4. INPUT_RETRY_MESSAGE
   - [ ] 게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
5. PRINT_BRIDGE_STATE<br>
   [ O |   |   ]<br>
   [   | O | O ]
6. RESULT_MESSAGE
   - [ ] 게임 성공 여부: 성공
7. TRY_COUNT_MESSAGE
   - [ ] 총 시도한 횟수: 2

### OutputView
1. printMap
2. printResult

### INPUT class
1. readBridgeSize
2. readMoving
3. readGameCommand()

### BridgeMap


### BridgeIngredient enum

`[ `
`| `
`O `
`X `
`]`
<br>
다리를 만들기 위한 재료

### BridgeGame
1. move
2. retry
3. 

### ChageType class


## 📄 설계 구조

- cotroller
  - Controller
- model
  - value
    - OutMessage enum
  - entity
    - Play
- util
  - BridgeMaker
  - BridgeNumberGenerator.java
  - BridgeRandomNumberGenerator.java
  - Validator
- service
  - BridgeGame.java
- view
  - InputView
  - OutputView
<hr>

- controller
  - output
  - service
    - input
    - entity
    
대략적으로 이런 계층 구조를 가지고 있다. ex)util은 종속되지 않아서 계층구조에 표시 안함
