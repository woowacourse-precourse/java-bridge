---
docs: controller 기능 구현 목록
## Controller 기능 구현
- game()
  - 게임 시작
- create()
  - 랜덤값으로 만들어진 bridge를 create 하였다.
- Go()
  - 사용자가 종료를 하지않고, 계속 시도할수 있도록 while 문을 만들었고
  - 마지막엔 최종 결과를 출력하게하였다.
- checkCorrect()
  - 입력한 값이 맞다면 correctCase()를, 아니면 wrongCase()를 호출한다
- editBuilder()
  - 입력한 값이 bridge 의 값과 같다면(즉, 맞았다면)
  - Builder의 마지막 값을 |로 바꾼다.
- correctCase()
  - 입력한 값이 bridge와 일치하면 correctPrintMap()을 호출하고, 빌더들을 출력한다.
  - bridgeGame의 position을 1 증가시키고 editBuilder()를 호출하여 Builder들을 잇는다.
- wrongCase()
  - 입력한 값이 bridge와 일치하지 않는다면, wrongPrintMap()을 호출하고, 빌더들을 출력한다.
  - 재시작 종료 여부를 출력하고, 입력을 받아, RetryOrQuit()을 호출한다.
- RetryOrQuit()
  - GoRetry()를 사용하여, True. 즉, 다시 시작한다면 BridgeGame의 위치를 0으로 초기화, Builder 초기화, 전체 게임횟수 +1 한다.
  - 아니면 종료한다
- GoRetry()
  - 입력받는 값이, R과 같다면 True를 출력시킨다.
- printResult()
  - 게임이 종료되거나, 다 맞췄을 경우 최종 결과를 출력한다
- correctPrintMap()
  - 입력받는 값이 사용자와 같다면(U), up에는 O를, down에는 공백을 넣는다.
  - 입력받는 값이 사용자와 같다면(D), up에는 공백을, down에는 O를 넣는다
- wrongPrintMap()
  - 입력받는 값이 사용자와 다르다면(U), up에는 X를, down에는 공백을 넣는다.
  - 입력받는 값이 사용자와 다르다면(D), up에는 공백을, down에는 X를 넣는다.

- printBuilder()
  - outputView의 printMap()을 사용하여 Builder들을 출력

- initBuilder()
  - upBuilder, downBuilder를 초기화
  - Builder들에 [ 를 추가

---
docs : domain 기능 구현
## BridgeGame 기능 구현
- retry()
  - 인스턴스 position을 set
- getPosition()
  - 인스턴스 position을 반환
- move()
  - 인스턴스 position을 1 증가
- getBridge()
  - 인스턴스 bridge를 반환
- comparePositionLength()
  - 인스턴스 bridge의 길이와 position이 같은지 반환
- correct()
  - 입력받는 값과 인스턴스 bridge의 position번째 값이 같은지 반환

## User 기능 구현
- addPlayingCount()
  - 인스턴스 playingCount를 1 증가시켜 set
- getPlayingCount()
  - 인스턴스 playingCount를 반환
- setQuit()
  - 인스턴스 quit을 set
- getQuit()
  - 인스턴스 quit 을 반환

---
docs : Exception 기능 구현
## Exception 기능 구현
- checkNumberRangeException()
  - number가 3~20이 아니면 예외를 터트림
- checkCorretUpOrDownException()
  - string이 U, D가 아닐경우 예외를 터트림
- checkRestartOrDoneException()
  - string이 R, Q 가 아닐경우 예외를 터트림

---
docs : util 기능 구현
## BridgeMaker 기능 구현

- makeBridge()
  - GeneratorToBridge()를 사용하여 랜덤값을 받음
  - 위에서 받은 값을 List<String>에 넣고 반환
-GeneratorToBridge()
  - 값이 1이면 "U" 반환
  - 값이 0이면 "D" 반환

---
docs : view 기능 구현
## InputView 기능 구현

- readBridgeSize()
  - 다리의 길이를 입력받는 기능
  - 3부터 20까지 들어오는지 유효성 검사
  - 검사가 실패날 경우, ERROR_MESSAGE를 띄우고 이 메소드를 재귀

- readMoving()
  - 위로 갈지 아래로 갈지 입력받는 기능
  - U 아니면 D가 들어오는지 유효성 검사
  - 실패할 경우, ERROR_MESSAGE를 띄우고 재귀

- readGame()
  - 게임을 재시작할지 종료할지 입력받는 기능
  - R 아니면 Q가 들어오는지 유효성 검사
  - 실패할 경우, ERROR_MESSAGE를 띄우고 재귀

## OutputView 기능 구현
- printStartBridgeGame() 
  - 게임시작 문구 출력
- printBridgeLengthQuestion()
  - 길이 입력 문구 출력
- printMoveUpOrDown()
  - U로 갈지 D로 갈지 문구 출력
- printRestartOrQuit()
  - 다시 시도할지 여부 문구 출력
- printMap()
  - upstringBuilder, downStringBuilder 출력
- printResult()
  - 결과 문구 출력과 printMap() 호출
- printSuccessOrFailure()
  - 성공 여부 문구 출력
- printPlayerTryCount()
  - 시도 횟수 출력