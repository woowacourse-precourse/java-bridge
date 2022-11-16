## 🔍 기능 목록

### 🚀 Application class

### 🚀 BridgeGame class

### 🚀 BridgeMaker class

### 🚀 InputView class

- public int readBridgeSize()
  - 다리의 길이를 입력받는 메소드


- private void validateInputIsExit(String)
  - 입력값이 존재하는지(입력을 '\n' 등을 통해 넘기지 않았는지) 검사하는 메소드
  - 입력값이 존재하지 않는다면 IllegalStateException 발생


- private void validateInputSizeIsInteger(String)
  - 다리의 길이로 입력된 값이 숫자인지 검사하는 메소드
  - 입력값이 숫자가 아니라면 IllegalArgumentException 발생


- private void validateInputSizeIsInRange(String)
  - 다리의 길이로 입력된 수가 3~20 사이의 수인지 검사하는 메소드
  - 입력된 수가 3~20 사이의 수가 아니라면 IllegalArgumentException 발생


- public String readMoving()
  - 사용자가 이동할 칸을 입력받는 메소드


- private void validateInputMovingCharacter(String)
  - 이동할 칸으로 입력된 값이 'U' or 'D' 인지 검사하는 메소드
  - 입력값이 'U' or 'R'이 아니라면 IllegalArgumentException 발생


- public String readGameCommand()
  - 사용자가 게임의 재시작/종료에 대한 결정을 입력받는 메소드


- private void validateInputGameCommandCharcter(String)
  - 게임 재시작/종료 여부를 결정하는 입력값이 'R' or 'Q' 인지 검사하는 메소드
  - 입력값이 'R' or 'Q'가 아니라면 IllegalArgumentException 발생

### 🚀 OutputView class

- public void printGameStart()
  - 게임 시작 문구를 출력하는 메소드


- public void printBridgeSizeInputBox()
  - 다리의 길이 입력을 알리는 문구를 출력하는 메소드


- public void printMovingInputBox()
  - 이동할 칸 입력을 알리는 문구를 출력하는 메소드


- public void printGameCommand()
  - 게임 재시작/종료 여부에 대한 입력을 알리는 문구를 출력하는 메소드

