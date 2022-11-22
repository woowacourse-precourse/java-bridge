
## BridgeGameStarter.java 클래스

### void BridgeGamePlay()
* 게임 제어 
* 게임 진행에 따른 올바른 클래스 호출

/


## InputView.java 클래스

### int readBridgeSize()
* OutputView.whatSizeBridge() 사용
* 다리의 길이 입력받기(userInputBridgeLength)
* userInputBridgeLength 가 범위에서 벗어나면 OutputView.printError(1) 사용

### String readMoving()
* OutputView.inputWhereToGo() 사용
* userInput 에 유저가 움직이는 경로 입력받음
* userInput 이 "U" 또는 "D" 가 아니면 OutputView.printError(2) 사용

### String readGameCommand()
* OutputView.inputReGameOrNot() 사용
* reGameOrNotAnswer 에 게임 재시작에 대한 유저의 답변 입력받음
* BridgeGame.retry(reGameOrNotAnswer) 사용

/


## OutputView.java 클래스

### void printGameHasStarted()
* "다리 건너기 게임을 시작합니다." 출력

### void whatSizeBridge()
* "다리의 길이를 입력해주세요." 출력

### void printError(int whichError)
* ErrorReason(whichError) 출력 후 IllegalArgumentException() 던지기

### String ErrorReason(int whichError)
* if(whichError == 1) return "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
* if(whichError == 2) return "[ERROR] 이동할 칸은 U 또는 D를 입력해야 합니다."

### void inputWhereToGo()
* "이동할 칸을 선택해주세요. (위: U, 아래 : D)" 출력

### void inputReGameOrNot()
* "게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)" 출력

### void printResult()
* "최종 게임 결과" 출력
* 게임 결과 map 출력
* "게임 성공 여부: " 출력, 성공 여부 출력 
* "총 시도한 횟수: " 출력, 시도 횟수 출력
* System.exit(0) 사용해 게임 종료

### void printMap()
* 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력

### void printResult(String CompleteOrNot, List\<String> bridgeInfo)
* 결과에 대한 표 출력

/


## BridgeMaker.java 클래스

### List\<String> makeBridge(int size)
* bridgeInfo List 에 whichBridge() return 값 입력
* 완성된 List return

### String whichBridge()
* 다리 칸을 생성하기 위한 random 한 number 추출
* if (number == 0) return "U";
* 나머지 return "D";

### BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator)
* 랜덤 number 생성

/


## BridgeCheck.java 클래스

### isRightBridge(List\<String> bridgeInfo, int i)
* 유저가 움직인 값을 InputView.readMoving() 을 통해 입력 받음
* 올바른 경로가 아닐 시 InputView.readGameCommand() 사용

/


## BridgeGame.java 클래스

### void move(List\<String> bridgeInfo, int bridgeLength)
* 입력된 경로가 올바른 경로인지 체크하는 BridgeCheck.isRightBridge() 사용

### String retry(String reGameOrNotAnswer) 
* reGameOrNotAnswer 가 "Q" 와 같다면 return "Q"
* reGameOrNotAnswer 가 "R" 과 같다면 return "R"

/

## BridgeGameStarter.java 클래스
* 게임 총괄, 정보 관리

