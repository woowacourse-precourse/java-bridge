# 프로코스 4주차 미션 - 다리 건너기

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 👨🏻‍💻 기능 요구 사항
### 목표 기능 : 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
- 위아래 두칸으로 이루어진 다리를 건너야 한다.
    - 다리는 왼쪽에서 오른쪽으로 건너야 한다. (**사용자 입력 예외 발생 경우 x**)
    - 위아래 둘 중 하나의 칸만 건널 수 있다. (**사용자 입력 예외 발생 가능**)

- 다리의 길이를 숫자로 입력받고 생성한다.
    - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다. (**BridgeRandomNumberGenerator 사용**)
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다. (**BridgeMaker 사용**)
    - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다. (**BridgeMaker 사용**)

- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다. (**사용자 입력 예외 발생 가능**)
    - 이동한 칸을 건널 수 있다면 O로 표현한다. 건널 수 없다면 X로 표현한다. (**OutputView 사용**)

- 다리를 끝까지 건너면 게임이 졸료된다.
    - 게임 종료 문구 출력하고 게임을 종료. (**OutputView 출력**)

- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다. (**사용자 입력 예외 발생 가능**)
    - 재시작해도 처음에 만든 다리로 재사용한다.
    - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.

- 사용자가 잘못된 값을 입력할 경 `IllegalArgumentException`를 발생시키고 `"[ERROR]"`로 시작하는 에러 메세지를 출력한 후 그 부분부터 **입력을 다시 받는다**.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 **명확한 유형**을 처리한다.

### ⌨️ 입력 요구사항 (InputView 사용)
- 자동으로 생성할 다리 길이를 입력 받는다. 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아닌 경우에는 예외 처리한다.
    - `IllegalArgumentException`

- 라운드마나다 플레이어가 이동할 칸을 입력 받는다. U(위 칸), D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아닌 경우에는 예외 처리한다.
    - `IllegalArgumentException`

- 게임 재시작/종료 여부를 입력 받는다. R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
    - `IllegalArgumentException`

### 🖨 출력 요구사항 (OutputView 사용)
- 게임 시작 문구
    - '다리 건너기 게임을 시작합니다.'

- 게임 종료 문구
  ```
    최종 게임 결과
    [ O |   |   ]
    [   | O | O ]

    게임 성공 여부: 성공
    총 시도한 횟수: 2
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



## 👨🏻‍💻 기능 구현 세부사항 (Domain 별)
### Application
 - 다리 게임 시작하는 함수 : `start()`
   - 처음 시작 횟수 count
   - BridgeGame 객체 선언 및 초기화
   - 게임 진행
 - 다리 게임 선언 및 초기화 하는 함수 : `gameInitProcess()`
   - 게임 시작 메세지 출력
   - 사용자로부터 다리 길이 입력
   - BridgeGame 선언 및 초기화 : game.initBridge(bridgeSize)
 - 다리 게임 실제 수행 로직 : `gameProcess()`
   - 사용자로부터 이동 (U or D) 입력
   - 사용자 입력 프로그래밍 요구사항 확인 : `checkGameStatus()`
   - 게임 예외 발생 및 종료시까지 재귀로 호출 : 애매하게 짠 코드....
 - 사용자로부터 이동 입력을 받고 로직 수행 : `checkGameStatus()`
   - 중간에 일치하지 않는 경우에 대한 처리 : `리팩토링 대상`
   - 다리 길이만큼 진행됐을 경우에 대한 처리 : `리팩토링 대상'`
- 다리 게임 오답 발생 시 사용자에게 stop or go 로직 : `gameCommandProcess()`
  - 사용자 입력에 따라 resetProcess() 또는 quitProcess()
- 사용자가 종료를 선택한 경우 : `quitProcess()`
  - 결과 출력하고 종료
- 사용자가 재시도를 선택한 경우 : `resetProcess()`
  - `BridgeGame.retry()` 호출
  - 처음 과정부터 재시작
- 사용자 재입력 요구사항, 예외 발생 시 재입력 요청
  - `checkMovementExceptionAndRun` : 사용자 이동 예외 입력시 재요청
  - `checkExitCodeExceptionAndRun` : 사용자 종료 및 재시도 예외 입력시 재요청
### BridgeGame
- Class field value: `int trialCount`
  - 사용자가 정답까지 시도한 횟수
- Class field value: `List<String> bridge`
  - 랜덤으로 생성된 다리 게임 정답
- Class field value: `List<String> userInput`
  - 사용자가 게임을 진행하면서 입력한 이동들
- 사용자가 게임을 진행하면서 입력한 이동에 대한 처리 로직 : `move()`
  - 사용자가 입력한 이동을 userInput에 추가
  - 정답과 입력한 이동 비교하여 true/false 반환
- 사용자가 게임을 다시 시도할 때의 처리 로직 : `retry()`
  - 시도 횟수 trialCount 1회 증가
  - 기존에 입력해 놓은 사용자 이동 입력 초기화
- 게임을 시작할 때 다리 초기화하는 메소드 : `initBridge()`
  - BridgeRandomNumberGenerator 및 BridgeMaker 사용하여 다리 생성
  - BridgeGame.bridge에 저장
- 외부에서 클래스 변수 사용하기 위한 getter 메소드
  - `getBridge()`
  - `getUserInput()`
  - `getTrialCount()`

### BridgeMaker
- 게임에서 사용할 다리 생성 로직
  ```java
  public List<String> makeBridge(int size){
    return generatedBridge;
  }
  ```
- bridgeNumberGenerator.generate() 통해 생성되는 숫자 문자로 전환
  ```java
  private String convertGeneratedRandomNumberIntoBridgeValue(Integer generatedRandomNumber) {
        if (generatedRandomNumber.equals(0)) {
            return "D";
        }

        return "U";
    }
  ```

### InputView
- 사용자 다리 길이 입력 : `readBridgeSize()`
  - 사용자로부터 다리 길이를 입력받고 검증 진행
  - 검증 내용: 공백 여부, 숫자 여부, 범위 여부
- 사용자 이동 입력 : `readMoving()`
  - 사용자로부터 이동 입력받고 검증 진행
  - 검증 내용: 공백 여부, U 또는 D 만을 입력했는지 여부
- 사용자 종료 및 재시도 입력 : `readGameCommand()`
  - 사용자로부터 종료 및 재시도 입력받고 검증 진행
  - 검증 내용: R 또는 Q만을 입력했는지 여부

### OutputView
- 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력 : `printMap()`
  - 결과 출력은 topBridge와 bottomBridge 두 개의 StringBuilder로 구분하여 출력
- `printMap()`의 하위 메소드
  - `initTopBridge` : '[' 추가 메소드
  - `initBottomBridge` : '[' 추가 메소드
  - `closeTopBridge` : ']' 추가 메소드
  - `closeBottomBridge` : ']' 추가 메소드
  - `printTopBridgeStatus` : 사용자 입력에 맞게 그 결과 StringBuilder에 append
  - `printBottomBridgeStatus` : 사용자 입력에 맞게 그 결과 StringBuilder에 append
  - `getTopStringByStatus` : 사용자 입력과 실제 다리 비교해서 그 결과 String 반환
  - `getBottomStringByStatus` : 사용자 입력과 실제 다리 비교해서 그 결과 String 반환
- 게임의 최종 결과를 정해진 형식에 맞춰 출력 : `printResult`
  - 결과 출력은 printMap 사용 및 경우에 따른 printMessage
  - `printSuccessMessage` : 성공했을 때의 결과 및 도전 횟수 출력
  - `printFailureMessage` : 실패했을 때의 결과 및 도전 횟수 출력
- `printGameStartMessage` : 다리 건너기 게임을 시작합니다 문구 출력

### UserInputException
- `IllegalArgumentException` 상속받는 Exception
- `ErrorResponse`를 인자로 받는 생성자 오버로딩
- ```java
  public BridgeException(ErrorResponse errorResponse) {
        super(errorResponse.getErrorMessage());
    }
  ```
  
### GameException
- `IllegalStateException` 상속받는 Exception
- 비정상 코드 반복 및 종료에 대한 예외 처리
- `ErrorResponse`를 인자로 받는 생성자 오버로딩
- ```java
  public GameException(ErrorResponse errorResponse) {
        super(errorResponse.getErrorMessage());
    }
  ```


### ErrorResponse
- BridgeGame에서 발생하는 예외에 대한 Enum Class
  - `INPUT_BRIDE_SIZE_RANGE_ERROR` : 사용자 입력 다리 길이 범위 에러
  - `INPUT_BRIDGE_SIZE_NOT_NUMBER_ERROR` : 사용자 입력 다리 길이 문자 예외 에러
  - `INPUT_BRIDGE_SIZE_NULL_ERROR` : 사용자 입력 다리 길이 공백 예외 처리 
  - `INPUT_MOVEMENT_ERROR` : 사용자 입력 이동 예외 처리 
  - `INPUT_MOVEMENT_NULL_ERROR` : 사용자 입력 이동 공백 예외 처리 
  - `INPUT_EXITCODE_ERROR` : 사용자 입력 종료 및 재시도 예외 처리 


### ValidationUtil 
- 사용자 입력 및 비즈니스 모델 검증 Class
  - `validateBridgeSizeInput` : 사용자 입력 다리 길이 범위 확인
  - `validateBridgeSizeDigitInput` : 사용자 입력 다리 길이 숫자 확인
  - `validateBridgeSizeNullInput` : 사용자 입력 다리 길이 공백 확인
  - `validateUserMovement` : 사용자 입력 이동 예외 확인
  - `validateUserMovementIfNull` : 사용자 입력 이동 공백 예외 확인
  - `validateExitCode` : 사용자 입력 종료 및 재시도 예외 확인



## 👨🏻‍💻 추가된 프로그래밍 요구사항
- 함수의 길이가 10라인을 넘어가지 않도록 구현한다.
- 메소드의 파라미터의 개수는 최대 3개까지만 허용한다.
- `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
  - 각 클래스의 제약사항은 해당 세부 설명을 참고한다.
  - 이외 필요한 클래스와 메소드는 **자유롭게 구현** 가능하다.
  - `InputView` 클래스에서만 Console.readLine() 사용 가능하다.
  - `BridgeGame` 클래스에서 `InputView`, `OutputView`를 사용하지 않는다.

## 👨🏻‍💻 Trouble Shooting
