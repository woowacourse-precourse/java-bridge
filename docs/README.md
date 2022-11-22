### 기능 목록
#### 1. BridgeGame 클래스
- 사용자로부터 U, D을 입력받아 칸 하나를 움직이는 함수: move
- 사용자로부터 게임을 재시작할지 정보를 입력받아 게임을 재시작할지 말지 결정하는 함수: retry

#### 2. BridgeMaker 클래스
##### Bridge를 생성하는 클래스로 BridgeGame 클래스와 OutputView 클래스의 생성자의 인자로 들어간다.
- 입력받은 다리 사이즈에 따라 랜덤하게 Bridge를 생성하는 함수: makeBridge

#### 3. BridgeRandomNumberGenerator 클래스
##### BridgeNumberGenerator 인터페이스의 구현 클래스
- 랜덤하게 0과 1을 생성하는 함수: generate


#### 4. InputView 클래스
##### 사용자로부터 입력을 받는 클래스로 예외에 대해 재귀적으로 함수를 작성
- 사용자로부터 다리의 길이를 입력받는 함수: readBridgeSize
- 사용자로부터 이동할 칸을 입력받는 함수: readMoving
- 사용자로부터 게임 재시작 여부를 입력받는 함수: readGameCommand
- 사용자로부터 입력받은 값이 올바른지 판단하는 함수(사용자 입력은 모두 String으로 전달): validate
```java
class InputView {
    private void validate(String input, ValidationType validationRange) {
        // input이 validationRange에 포함되지 않으면 IllegalArgumentException 발생
    }
}
```

#### 4-1 ValidationType enum 클래스
##### 사용자의 입력을 검증하기 위한 enum 클래스로 각 입력 범위를 인스턴스로로 가짐
- 유효한 범위를 리턴하는 함수: getValidationRange
- 각 인스턴스별로 에러메세지를 리턴하는 함수: getErrorMessage
- 유효성을 판단하는 함수: validate

#### 5. OutputView
- 이동한 칸 수와 이동 성공 여부를 전달받아 다리의 상태를 출력하는 함수: printMap
- 게임 성공 여부와 시도 횟수를 전달받아 게임의 최종 결과를 출력하는 함수: printResult
- 게임 시작 문구를 출력하는 함수: printStartMessage
- 다리 길이 입력 문구를 출력하는 함수: printInputSizeMessage
- 칸 이동 시 입력 문구를 출력하는 함수: printInputMoveMessage
- 재시작 여부의 입력 문구를 출력하는 함수: printRestartMessage
- 출력 조건에 맞게 한 줄의 다리를 출력하는 함수: makeMessageForPrintMap
- 한 칸의 상태가 O, X, 공백인지 정해서 리턴하는 함수: makeMark

#### 6. GameStart 클래스
##### InputView, BridgeGame, OutputView를 포함해 게임을 진행하는 클래스
- 게임을 진행하는 run 함수: run
- 한 라운드의 게임을 진헁하는 함수:play 
- 게임 시작 시 출력과, 사용자로부터 입력을 받는 함수: start
- 재시작 여부를 체크하는 함수: checkRestart
- 다리의 크기를 사용자에게 입력받아 다리를 생성하는 함수: inputBridge
- 움직일 칸을 사용자에게 입력받아 한 칸을 움직이는 함수: inputMove
- 재시작 여부를 사용자에게 입력받아 리턴하는 함수: inputRestart