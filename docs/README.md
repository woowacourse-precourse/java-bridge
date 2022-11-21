# 다리 건너기

## 📄 기능 목록
### 💡실행 목록
- [x] 게임 시작 문구를 출력한다. -OutputView#printGuideMessage()
- [x] 다리의 길이를 입력 받는 문구를 출력한다. -OutputView#printGuideMessage()
- [x] 다리의 길이를 입력 받는다. -InputView#readBridgeLength()
  - [x] 다리의 길이는 3부터 20 사이만 입력 받을 수 있다.
- [x] 다리의 길이만큼 다리를 랜덤 값으로 생성한다. -BridgeMaker#makeBridge()
  - [x] 0이면 아래 칸, 1이면 위의 칸이 유효한 칸이다.
  - [x] 위 칸을 건널 수 있는 경우는 U, 아래 칸을 건널 수 있는 경우는 D 이다.
- [x] 이동할 칸을 입력 받는 문구를 출력한다. -OutputView#printInputMoveMessage()
- [x] 이동할 칸을 입력 받는다. -InputView#readMoving()
  - [x] U 또는 D 만 입력 받을 수 있다.
- [x] 이동할 칸이 유효한 칸인지 확인한다. -Bridge#isValid()
  - [x] 유효하면 O, 유효하지 않으면 X 이다.
- [x] 현재까지 건넌 다리를 출력한다. -Output#printMap()


- [ ] 이동한 칸이 유효한 칸이라면? 
  -  [ ] 다시 이동할 칸을 선택받는다.


- [ ] 이동한 칸이 유효하지 않은 칸이라면? 
  - [x] 게임 재시작 문구를 출력한다. -OutputView#printGuideMessage()
  - [x] 게임 재시작 여부를 입력 받는다. -InputView#readGameCommand()
    - [ ] 재시작 한다면, 이동할 칸을 입력 받는다.
    - [ ] 종료 한다면, 게임 종료 문구를 출력한다.


- [ ] 이동한 칸이 마지막 칸이라면?
  - [x] 게임 종료 문구를 출력한다. -OutputView#printResult()
    - [x] 최종 게임 결과 문구를 출력한다. -OutputView#printGuideMessage()
    - [x] 최종 게임 결과(현재까지 건넌 다리)를 출력한다.
    - [x] 게임 성공 여부를 출력한다. -OutputView#printSuccessOrFailure()
    - [x] 총 시도한 횟수를 출력한다. -OutputView#printTotalTry()

### ❗️예외 목록
#### controller
- [ ] 

#### view _( InputException )_
- [x] 다리 길이를 입력 받을 때 예외처리 -inputBridgeLengthException()
  - [x] 입력값이 null인 경우 예외처리한다. -inputNullException()
  - [x] 입력값이 숫자가 아닐 경우 예외처리한다. -inputNoNumberException()
  - [x] 입력값이 3 이상 20 이하의 숫자가 아닐 경우 예외처리한다. -inputNoRangeException()


- [x] 플레이어가 이동할 칸을 입력 받을 때 예외처리 -inputMoveException()
  - [x] 입력값이 null인 경우 예외처리한다. -inputNullException()
  - [x] 입력값이 한 글자가 아닌 경우 예외처리한다. -inputNoOneCharException()
  - [x] 입력값이 U나 D이 아닐 경우 예외처리한다. -inputInvalidCharException()


- [x] 게임 재시작 여부를 입력 받을 때 예외처리 -inputRestartException()
  - [x] 입력값이 null인 경우 예외처리한다. -inputNullException()
  - [x] 입력값이 한 글자가 아닌 경우 예외처리한다. -inputNoOneCharException()
  - [x] 입력값이 R이나 Q가 아닐 경우 예외처리한다. -inputInvalidCharException()