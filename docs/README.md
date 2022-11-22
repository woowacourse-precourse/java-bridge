# 기능 목록

---
## 입출력
### 입력 InputView
- [x] 다리 길이 입력 받기 InputView#readBridgeSize()
- [x] 이동할 칸 입력 받기 InputView#readMoving()
- [x] 다시 시도 여부 입력 받기 InputView#readRetry()

### 입력 유효성 검사 InputValidator
- [x] 다리 크기 유효성 검사 InputValidator#validateBridgeSize(int size)
- [x] U 또는 D 입력 유효성 검사 InputValidator#validateMove(String move)
- [x] R 또는 Q 입력 유효성 검사 InputValidator#validateRetry(String retryQuit)
        
### 출력 OutputView
- [x] 게임 시작 메시지 InputView#printStart()
- [x] 다리 그리기 OutputView#printMap(char[][] map, int index)
- [x] 종료 메시지 출력 OutputView#printEndMessage()
- [x] 결과 출력 OutputView#printResult(boolean isSuccess, int numberOfTrials)
        
---
## 게임 컴포넌트
### 다리 Bridge
- [x] 움직일 수 있는 칸인지 평가하기 Bridge#isPossibleMove(int index, String upDown)
  - 예외. index가 0미만 또는 다리 크기 이상인 경우
  - 예외. upDonw이 "D" 또는 "U"가 아닌 경우
- [x] 생성된 List로 Bride객체 생성하기 Bridge#Bridge(List<String> bridge)
  - 예외. U와 D로만 이뤄진 리스트가 아닌 경우 예외 발생
        
### 다리 생성기 BrideMaker
- [x] 다리 생성 하기 BridgeMaker#GenerateBridge(int size)
    - 제공된 BridgeNumberGenerator를 통해 Bridge 객체 리턴
    - 예외. 0 또는 1 이외의 값이 생성될 경우 예외 발생

### 게임 진행 BrideGame
- [x] 게임 시작하기 BrideGame#BridegeGame(Bridge bridge)
  - 생성한 Bridge를 입력 받아 endIndex(마지막 칸)을 기록
  - 현재 칸과 현재 시도 횟수 세팅
  - 현재까지 움직인 지도(char 2차원 배열) 초기 세팅 
  - 예외. Bridge가 null일 경우
- [x] 다음 칸 움직일 수 있는 칸인지 평가하기 BridgeGame#isCorrectMove(String move)
- [x] 움직이기 BrideGame#moveForward()
  - 현재까지 움직인 칸 index++
  - 마지막 칸까지 도달했다면, 1 리턴
  - 마지막 칸까지 도달하지 않았다면, 0리턴
  - 예외. 마지막 칸을 넘어서 움직인 경우
- [x] 현재까지의 맵 array 기록하기 BridgeGame#recordCurrentMove(String userMove, boolean isPossibleMove)
- [X] 다시 시도 BridgeGame#retry()
  - 진행 상황 리셋
  - 시도 횟수 증가
  - 기록 지도 초기화
  - 예외. 이미 게임이 성공해서 종료된 상황인데 다시 시도하는 경우 예외 발생
- [x] 성공 여부 얻기 BridgeGame#isSuccess() 
---
## 게임 운영
### 게임 운영자 GameManager
- [x] 게임 진행 순서 운영 GameManager#start()
  - [x] 초기 세팅(의존성 설정) GameManager#GameManger()
  - [x] 다리 생성(사용자에 입력받아 다리 생성) GameManager#setBridge()
  - [x] 게임 진행(사용자에게 입력받아 guess 게임 진행) GameManger#moveTry()
  - [x] 재시작을 위한 초기화 GameManger#reset() 
  - [x] 게임 종료 GameMager#endGame()
---     
## 추가 기능
- [ ] AOP 프록시를 이용하여 예외 발생시 다시 입력 받도록 구현
- [x] 예외 메시지를 출력하는 기능 ExceptionPrinter#printException(ExceptionMessage message)