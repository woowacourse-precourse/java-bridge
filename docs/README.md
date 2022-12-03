## 기능 목록

### 다리 생성

- [x] 사용자에게 생성할 다리 길이를 입력 받는다. `InputView#readBridgeSize()`
- [x] 입력값이 숫자인지 확인하고, 숫자가 아니면 예외 처리한다. `BridgeMaker#validateBridgeSizeType()`
- [x] 예외 처리 후에, 그 부분부터 입력을 다시 받는다. `InputView#readBridgeSize()`
- [x] 3 이상 20 이하의 숫자가 아니면 예외 처리한다. `BridgeMaker#validateBridgeSizeRange()`
- [x] 다리 길이 만큼 0과 1 중 무작위 값을 생성한다. `BridgeNumberGenerator#generate()`
- [x] 무작위 값이 0인 경우 "D", 1인 경우 "D"로 이루어진 **다리**를 `리스트 형태`로 반환한다. `BridgeMaker#makeBridge()`

### 다리 게임

- [x] 다리를 불러오고, 시도한 회수를 1로 초기화한다. `BridgeGame`
- [x] 사용자에게 `이동 방향`을 입력받는다. `InputView#readMoving()`
- [x] "U", "D" 중의 입력값이 아닌 경우 예외 처리한다. `Position`
- [x] 예외 문구 출력 후 다시 이동 방향부터 입력받는다. `InputView#readMoving()`
- [x] 이동 방향 입력값과 다리의 값을 비교해 두 값이 같으면`SURVIVE` O, 다르면 X`DIE`를 다이어그램에 추가한다. `Diagram#updateDiagrams`
- [x] 위 반환값으로 모든 이동 후에 진행 상황 다이어그램을 출력한다. `GameController#moveOnce => OutputView#printMap 호출`
- [x] 비교한 결과가 같은 경우, 이동 방향 입력값을 받아 다음 다리의 값을 비교한다. `GameController#moving`
- [x] 비교한 결과가 같으며 다리의 모든 값을 비교한 경우 성공 처리`SUCCESS`하고 게임을 종료한다. `GameController#handleSuccess`
- [x] 비교한 결과가 다른 경우, 게임을 실패 처리`FAIL`한다. `GameController#handleFail`

### 재시작 or 종료

- [x] 게임에 실패한 경우 사용자에게 "R", "Q" 중의 입력값을 받는다. `InputView#readGameCommand`
- [x] "R", "Q" 중의 입력값이 아닌 경우 예외 처리한다. `RetryAndQuit`
- [x] 예외 문구 출력 후 다시 재시작 여부부터 입력받는다. `InputView#readGameCommand`
- [x] 입력받은 재시작 값으로 재시작 여부를 결정한다. `GameController#handleRetryAfterFail`
- [x] "R"을 입력해 재시작한 경우, 시도한 회수에 1을 더한다. `BridgeGame#retry`
- [x] "R"을 입력해 재시작한 경우, 다리와 다이어그램을 처음부터 다시 불러온다. `BridgeGame#retry`
- [x] "Q"를 입력한 경우 게임을 종료한다.`GameController#printResult`
- [x] 게임을 종료한 경우, 최종 게임 결과 다이어그램, 게임 성공 여부, 총 시도 회수를 출력한다. `OutputView#printResult`

- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시
  받는다.`OutputView#printErrorMessage`
- [x] 재시작해도 처음에 만든 다리로 재사용한다.

## MVC 패턴 적용 시 유의사항

- [x] Model 내부에 Controller와 View에 관련된 코드가 있으면 안 된다.
- [x] View는 내부에 Model의 코드만 있을 수 있고, Controller의 코드가 있으면 안 된다.
- [x] View가 Model로부터 데이터를 받을 때는, 사용자마다 다르게 보여줘야 하는 데이터에 대해서만 받아야 한다.
- [x] Controller 내부에는 Model과 View의 코드가 있어도 된다.
- [x] View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다.

## ✅ 게임 플로우차트

```mermaid
graph TD
A(Create Bridge) --> B(Attempt)
B --> C{Move}
C --> |survive|D{Last Bridge?}
D --> |YES|G[SUCCESS]
D --> |NO|C
C --> |die|E{Retry?}
E --> |QUIT|F[FAIL]
E --> |RETRY|B
G --> I(Print Result)
F --> I
```

## 📄 MVC 모델을 적용한 기능 설명

> 아래 규칙을 지키며 **MVC 패턴**을 적용하려 노력했습니다.
>- Model 내부에 Controller와 View에 관련된 코드가 있으면 안 된다. ✅
>- View는 내부에 Model의 코드만 있을 수 있고, Controller의 코드가 있으면 안 된다. ✅
>- View가 Model로부터 데이터를 받을 때는, 사용자마다 다르게 보여줘야 하는 데이터에 대해서만 받아야 한다. ✅
>- Controller 내부에는 Model과 View의 코드가 있어도 된다. ✅
>- View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야 한다. ✅
>
> 또한 개인적으로 프로그램 내에서 **각 클래스의 역할을 단 한 문장으로 요약**하는 연습을 했습니다.
> 각 문장은 아래에서 Model 내에 볼드 체로 작성했습니다.

---

### 1. Model ✅

#### `Bridge`

- **다리를 리스트 형태로 관리한다.**
- `index`와 사용자가 선택한 `position`을 받아, 사용자의 생존 여부를 `boolean` 형태로 반환한다. `isSamePosition`
- 다리의 길이를 반환한다. `size`

#### `BridgeGame`

- **전체 게임을 관리한다.**
- 다리 한 칸 이동 시에 생존 여부에 따라 다이어그램을 업데이트하고 결과를 반환한다. `move`
- 사용자가 `DIE` 후에 재시작을 선택한 경우 다이어그램을 초기화하고 시도 회수를 +1 하여 재시작을 설정한다. `retry`
- 게임의 중요 변수를 설정하고 반환한다. `getAttempts` `getSuccessOrFail` `getDiagram` `setSuccess`
- 다리의 길이를 반환한다. `getBridgeSize`

### `Result`

- **게임의 중요한 변수인 시도 회수`attempts`, 최종 성공 여부`successAndFail`, 다이어그램`diagram`을 관리한다.**

#### `Position`

- **다리의 `UP`과 `DOWN`의 포지션을 관리한다.**
- `BridgeMaker` 객체에서 0과 1의 숫자로부터 다리를 생성할 때, 숫자를 입력하면 해당하는 축약어`abbreviation`를 반환한다. `getAbbreviation`
- 사용자의 이동 방향 입력값이 해당 포지션의 축약어`abbreviation`와 동일한지 비교한다. `isSame`
- 다이어그램을 업데이트할 때, 다이어그램의 포지션이 사용자가 선택한 포지션과 동일한지 비교한다. `isRightPlace`

#### `SurviveAndDie`

- **다리 한 칸 이동의 결과를 `SURVIVE`와 `DIE`로 나누어 관리한다.**
- 생존 여부를 비교하여 반환한다. `isDie`
- 다이어그램을 업데이트할 때, 추가할 내용을 반환한다. `getDisplay`

#### `SuccessAndFail`

- **게임 전체의 성공`SUCCESS`과 실패`FAIL`를 관리한다.**
- 결과 출력 시 보여줄 부분을 반환한다. `getKoreanDisplay`

#### `RetryAndQuit`

- **사용자의 한 칸 이동 중 `DIE`한 경우 입력받는 `GameCommand`를 관리한다.**

#### `Diagram`

- **매 이동 시와 최종 결과 출력 시에 함께 출력되는 `Map`을 관리한다.**
- 매 이동 시에 다이어그램을 업데이트한다. `updateDiagrams`
- 다이어그램을 출력 형식에 맞게 다듬는다. `formatDiagram`
- 다이어그램을 리스트에 넣어 함께 반환한다. `getFormattedDiagrams`

### 2. View ✅

#### `InputView`

- 다리 길이를 입력받는다. `readBridgeSize`
- 사용자가 이동할 칸을 입력받는다. `readMoving`
- 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. `readGameCommand`

#### `OutputView`

- 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다. `printMap`
- 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. `printResult`
- 에러 메세지를 출력한다. `printErrorMessage`
- 상황에 맞는 문구를 출력한다. `printStartGame` `printBridgeSizeInput` `printMoveInput` `printGameCommandInput`

### 3. Controller ✅

#### `GameController`

- 다리를 생성한다. `createBridge`
- 한 칸의 이동을 통해 생존 여부를 결정한다. `moveToDecideSurviveOrDie`
- 다리에서 최종적으로 성공`SUCCESS`하거나, 생존하지 못할 때`DIE`까지 반복한다. `moveUntilSuccessOrFail`
- 최종 성공`SUCCESS`을 처리한다. `handleSuccess`
- 생존하지 못한 경우`DIE`에 처리한다. `handleDie`
- 생존 실패`DIE` 후 재도전`RESTART` 선택 시 처리한다. `handleRetryAfterDie`
- 최종 성공 또는 실패 시 결과를 출력한다. `printResult`

---

## 클래스별 추가 요구사항

- `InputView` 클래스
    - 메서드의 이름, 파라미터 변경 O
    - 메서드 추가 O
- `OutputView` 클래스
    - 메서드 이름 변경 X
    - 파라미터, 반환 타입 변경 O
    - 메서드 추가 O
- `BridgeGame` 클래스
    - 필드(인스턴스 변수) 추가 O
    - 메서드 이름 변경 X
    - 파라미터, 반환 타입 변경 O
    - 메서드 추가, 변경 O
- `BridgeMaker` 클래스
    - 필드(인스턴스 변수) 변경 X
    - 메서드 이름, 파라미터, 반환 타입 변경 X
- `BridgeRandomNumberGenerator`, `BridgeNumberGenerator`
    - 코드 변경 X

## 3주차 피어리뷰 피드백 사항

- [x] 메소드 이름을 지을 때 사용자의 관점과 프로그램의 관점을 섞어서 작성하지 않는다.
- [x] `static` 메소드는 `Util` 패키지를 제외하고는 지양한다.
- [ ] `List` 안에 객체를 넣는 연습을 한다.
- [x] `Enum`은 연관된 상수의 집합이므로 변수를 포함시키지 않는다.
- [x] 인스턴스, 클래스 변수를 최대한 줄이도록 노력한다.
- [x] `static` 변수는 꼭 필요한 경우(상수)를 제외하고는 지양한다.
- [x] getter를 두기보다는 데이터를 보내서 클래스 안에서 해결하도록 한다.
- [x] 예외를 모두 `IllegalArgumentException`로 두지 않고 상황에 따라 `NumberFormatException` 등을 적절하게 사용한다.
- [x] stream을 이용해 반복문을 개선한다.
- [x] int를 사용할 때 int 범위를 초과하는 숫자가 들어오면 어떻게 되는지도 고려한다.

## 3주차 공통 피드백 사항

- [x] 메소드는 10라인 이상 넘어가지 않도록 한다.
- [x] 발생할 수 있는 예외 상황에 대해 충분히 고민한다.
- [x] 비즈니스 로직과 UI 로직을 분리한다.
- [ ] 현재 객체의 상태를 보기 위한 로그 메세지의 성격이 강하다면 `toString()` 메소드를 통해 구현한다.
- [x] View에서 사용할 데이터라면 getter 메소드를 통해 데이터를 전달한다.
- [x] 연관성이 있는 상수는 static final 대신 Enum을 활용한다.
- [ ] final 키워드를 사용해 값의 변경을 막는다.
- [x] 인스턴스 변수의 접근 제어자는 private으로 구현한다.
- [ ] 클래스에서 데이터를 꺼내서 처리하지 말고, 메세지를 던지도록 바꿔 데이터를 가지는 객체가 일하도록 한다.
- [x] 테스트를 위한 코드는 구현 코드에서 분리한다.
- [x] Random같은 요소를 가진 코드는 테스트하기 어려우므로, 단위 테스트가 가능하도록 리팩토링한다.
- [x] private 함수를 테스트하고 싶다면 클래스 분리를 고려한다.
    - 가독성을 위해 분리된 private 함수는 public 함수를 통해 충분히 검증 가능하다.
    - 가독상 이상의 역할을 하는 private 함수는 테스트하기 쉽도록 해당 역할을 하는 다른 객체를 만드는 것이 좋다.
- [ ] Collection 인터페이스를 사용하는 경우 외부에서 getter메서드로 얻은 값을 통해 상태값을 변경할 수 있으므로 Collections.unmodifiableList({list이름})을 사용한다.

## 프로그래밍 요구 사항

- [x] indent depth를 3이 넘지 않도록 구현한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [x] else 예약어를 쓰지 않는다.
- [x] 도메인 로직에 단위 테스트를 구현해야 한다.
- [x] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- [x] `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.