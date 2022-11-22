## 🚀 기능 리스트
- [x] 다리의 길이를 입력받는다 - InputView#readBridgeSize()
  - [x] 입력받은 길이 문자를 숫자로 변경 - InputView#convertInt()
  - [x] 입력받은 문자가 숫자로 변경되는지 판별 - InputView#isDigit()
  - [x] 숫자로 변경된 다리 길이가 정해진 범위에 들어가야한다 - InputView#validateBridgeSize()
- [x] 새로운 다리를 생성한다 - BridgeMaker#makeBridge()
  - [x] 0이나 1을 랜덤하게 생성한다 - BridgeNumberGenerator#generate()
  - [x] 0을 U로 1을 D로 변환한다 - BridgeMake#convertLetter()
- [x] 이동할 다리를 선택한다 - InputView#readMoving() 
  - [x] 이동할 칸의 입력이 유효한지 확인한다 - InputView#validateMoveLocation()
- [x] 입력받은 다리로 이동한다 - BridgeGame#Move()
  - [x] 입력받은 문자로 이동할 곳의 인덱스를 알아낸다 - BridgeGame#convertToIndex()
  - [x] 이동할 수 있는 곳이면 "O", 그렇지 않다면 "X"를 반환한다 - BridgeGame#calculateAnswer()
  - [x] 게임 내역을 저장한다 - GameResult#add()
- [x] 게임 실패 여부를 판단한다 - BridgeGame#isGameFail()
  - [x] 현재 인덱스가 다리의 길이를 넘지않아 유효한지 확인한다 - GameResult#isUnavailable()
- [x] GameResult 클래스에 저장된 게임 결과를 반환한다 - BridgeGame#getResult()
  - [x] 현재 까지 게임 결과를 반환한다 GameResult#getResult()
- [x] 다리에 끝에 도달한다 - BridgeGame#isEnd()
- [x] 현재까지 이동한 다리의 상태를 출력한다 - OutputView#printMap()
  - [x] 결과를 출력형태에 맞게 변경한다 - OutputView#convertForm()
  - [x] 결과 요소가 마지막이 아니라면 구분자를 추가한다 - OutputView#convertElement()
  - [x] 시작과 끝에 상징 기호를 삽입한다 - OutputView#insertStartEndSymbol()
- [x] 게임 결과를 출력한다 - OutputView#printResult()
- [x] 재시작 유무를 입력받는다 - InputView#readGameCommand()
  - [x] 입력받은 명령 문자가 유효한지 확인한다 - InputView#validateGameCommand()
- [x] 게임을 재시작한다 - BridgeGame#retry()
  - [x] 현재까지 저장된 내역을 초기화한다 - GameResult#clear()
- [x] 시도 횟수를 반환한다 - BridgeGame#getTryCount()


## 🚀 기능 요구 사항
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

#### 입력
- 자동으로 생성할 다리 길이를 입력 받는다. 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
```
3
```
- 라운드마다 플레이어가 이동할 칸을 입력 받는다. U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
```
U
```
- 게임 재시작/종료 여부를 입력 받는다. R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
```
R
```

```
- 사용자가 이동할 때마다 다리 건너기 결과의 출력 형식은 실행 결과 예시를 참고한다.
  - 이동할 수 있는 칸을 선택한 경우 O 표시
  - 이동할 수 없는 칸을 선택한 경우 X 표시
  - 선택하지 않은 칸은 공백 한 칸으로 표시
  - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
  - 다리 칸의 구분은 ` | `(앞뒤 공백 포함) 문자열로 구분
  - 현재까지 건넌 다리를 모두 출력
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```
[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
```

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

### 추가된 요구 사항

- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
  - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
  - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
  - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
  - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.