## 다리 건너기 게임 - 클래스
***
Application   
BridgeGame   
BridgeGameRun

BridgeMaker   
BridgeRandomNumberGenerator   

InputErrorCheck   
InputTry   
InputView   

OutputView   

***

## 다리 건너기 게임 - 클래스 별 메소드

***

### BridgeGame 클래스
1. 사용자가 칸을 이동할 때 사용하는 메소드
- 메소드 명 : move()
- 다리와 사용자의 경로를 입력받는다.
- 가장 최근 입력된 경로와
- 그 경로와 같은 인덱스의 다리가 같으면 움직일 수 있다. 
2. 사용자가 게임을 다시 시작할 때 사용하는 메소드
- 메소드 명 : retry()
- 재시작 커맨드가 재시작/종료 중 어떤 것과 같은지 비교한다.
- 재시작이라면 재시작의 의미로 GAME_RETRY(true)를 반환
- 종료라면 종료의 의미로 GAME_QUIT(false)를 반환한다.
3. 게임의 성공 실패를 판단하는 메소드
- 메소드 명 : judgeSuccessFailure()
- 다리와 사용자의 경로를 전달받는다.
- 다리와 경로의 크기가 같고
- 모든 요소가 일치한다면 게임 성공,
- SUCCESS("성공")을 반환한다.


### BridgeGameRun 클래스
1. 다리 게임을 실행하는 메소드
- 메소드 명 : runBridgeGame()
2. 게임을 위해 다리를 세팅하는 메소드
- 메소드 명 : setBridge()
3. 게임 한 라운드를 실행하는 메소드
- 메소드 명 : oneRound()


### BridgeMaker 클래스
1. 다리를 생성하는 메소드
- 메소드 명 : makeBridge()
2. 숫자에 맞추어 위쪽, 아래쪽 다리를 생성하는 메소드
- 메소드 명 : generateUpDown()


### BridgeRandomNumberGenerator 클래스
1. 랜덤한 숫자를 생성하는 메소드
- 메소드 명 : generate()


### InputErrorCheck 클래스
1. 다리 크기 입력의 오류를 체크하는 메소드
- 메소드 명 : readBridgeSizeErrorCheck()
2. 사용자 움직임 입력의 오류를 체크하는 메소드
- 메소드 명 : readMovingErrorCheck()
3. 재시작/종료 커맨드 입력의 오류를 체크하는 메소드
- 메소드 명 : readGameCommandErrorCheck()


### InputTry 클래스
1. 다리 크기의 올바른 입력을 시도하는 메소드
- 메소드 명 : readBridgeSizeTry()
2. 사용자 움직임의 올바른 입력을 시도하는 메소드
- 메소드 명 : readMovingTry()
3. 재시작/종료 커맨드의 올바른 입력을 시도하는 메소드
- 메소드 명 : readGameCommandTry()


### InputView 클래스
1. 다리 길이를 입력받는 메소드
- 메소드 명 : readBridgeSize()
2. 사용자 움직임을 입력받는 메소드
- 메소드 명 : readMoving()
3. 재시작/종료 커맨드를 입력받는 메소드
- 메소드 명 : readGameCommand()

### OutputView 클래스
1. 현재까지 이동한 다리의 상태 출력 메소드
- 메소드 명 : printMap()
2. 게임 최종 결과를 출력하는 메소드
- 메소드 명 : printResult()
3. 위쪽 혹은 아래쪽 다리를 출력하는 메소드
- 메소드 명 : printBridge()