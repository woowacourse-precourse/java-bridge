## 🔍 기능 목록

### 🚀 Application class

- public static void prepareExceptionBeforeBridgeGame()
  - 게임 시작 전, 게임 중에 발생할 수 있는 Exception을 처리하는 메소드


- public static void startBridgeGame()
  - 다리 게임을 시작하는 메소드


- public static void playBridgeGame()
  - 다리 게임이 진행되는 메소드


- public static void setBridgeGame()
  - 게임 시작 전 다리의 특성을 설정하는 메소드


- public static boolean replayBridgeGame()
  - 게임의 재시작/종료가 이루어지는 메소드


- public static void setError(Error)
  - 에러 메세지를 설정하는 메소드
  
### 🚀 BridgeGame class

- public void move(List<String>, List<String>, String)
  - 다음 칸으로 이동하는 메소드


- public void failure(List<String>, List<String>, String)
  - 게임 실패 시에 이동하는 메소드


- private String bridgeTopExist(String)
  - 들어온 인수가 "U"라면 "O", "D"라면 " " 반환


- private String bridgeBottomExist(String)
  - 들어온 인수가 "D"라면 "O", "U"라면 " " 반환


- private String failureInTop(String)
  - 들어온 인수가 "U"라면 "X", "D"라면 " " 반환


- private String failureInBottom(String)
  - 들어온 인수가 "D"라면 "X", "U"라면 " " 반환


- public boolean rightMove(String, String)
  - 이동하려는 칸으로 실제 이동할 수 있는지 확인하는 메소드
  - 이동할 수 있으면 true, 이동할 수 없으면 false 반환


- public boolean retry(String)
  - 재시작/종료 여부를 통해 게임의 진행을 관리하는 메소드
  - 재시작의 경우 true, 종료의 경우 false 반환

### 🚀 BridgeMaker class

- public BridgeMaker(BridgeRandomNumberGenerator)
  - 다음에 올 다리의 위치(위, 아래)를 결정하는 생성자


- public List<String> makeBridge(int)
  - 건널 수 있는 칸의 위치를 반환하는 메소드


- private String whereIsBridge()
  - 다리의 위치가 어디인지 결정하는 메소드


### 🚀 InputView class

- public int readBridgeSize()
  - 다리의 길이를 입력받는 메소드


- private int changeInputStringToInteger(String)
  - 다리의 길이로 입력된 문자열을 Integer 자료형으로 변환하여 반환하는 메소드


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


- private void validateInputGameCommandCharacter(String)
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


- public void printMap(List<String>, List<String>)
  - 현재의 다리 상태를 출력하는 메소드


- public void printResult(List<String>, List<String>)
  - 최종 게임 결과를 출력하는 메소드


- public void printSFAndNumber(boolean, int)
  - 게임의 성공 여부와 시도 횟수를 출력하는 메소드


- private String printSuccessOrFail(boolean)
  - 게임의 성공 여부를 출력하는 메소드


- private void printBridgeTop(List<String>)
  - 다리의 윗부분을 출력하는 메소드


- private void printBridgeBottom(List<String>)
  - 다리의 아랫부분을 출력하는 메소드

### 🚀 Error enum

- NONE("[ERROR] IllegalStateException 발생! 값을 입력해야 합니다."),
  INTEGER("[ERROR] IllegalArgumentException 발생! 숫자로만 입력해야 합니다."),
  RANGE("[ERROR] IllegalArgumentException 발생! 다리의 길이는 3~20 사이여야 합니다."),
  CHARACTER("[ERROR] IllegalArgumentException 발생! 올바른 문자를 입력해야 합니다.")