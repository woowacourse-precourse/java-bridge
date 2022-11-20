# 우아한 테크코스 프리코스 4주차 - 다리 건너기 게임
## 프로젝트 설명
플레이어는 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너간다.  
실패할 경우 동일한 다리를 이용하여 게임을 재시작 할 수 있다.

## 기능 목록
### 1. 게임 시작하기
- [x] 게임 시작 문구 출력하기 (ViewMessage # printGameStartMessage)
### 2. 다리 만들기
#### 1) 다리 길이 입력 받기
- [x] 다리 길이 입력 요청 문구를 출력한다. (ViewMessage # printBridgeSizeInputRequest)
- [x] 다리 길이를 입력 받는다. (InputView # readBridgeSize)
- [x] 입력 받은 다리 길이에 대한 유효성 검사를 한다. (InputView # validateBridgeLength)
#### 2) 다리 만들기
- [x] 입력된 다리 길이만큼 다리를 만든다. (BridgeMaker # makeBridge)
  - [x] 0이 나오면 아래칸, 1이 나오면 위 칸이 건널 수 있는 칸이 된다. (BridgeMaker # makeOneBlock)
### 3. 게임 진행하기
#### 1) 유저 위치 초기화
- [x] 유저의 위치를 초기화 한다. (User # resetStartPoint)
#### 2) 이동할 칸 입력 받기
- [x] 이동할 칸 입력 요청 문구를 출력한다. (ViewMessage # printMovingInputRequest)
- [x] 이동할 칸을 입력 받는다. ('U' or 'D') (InputView # readMoving)
- [x] 입력 받은 명령어에 대한 유효성 검사를 한다. (InputView # validateMoving)
#### 3) 유저 이동하기
- [x] 입력 받은 명령어에 맞춰 유저를 이동한다. (BridgeGame # move)
- [x] 이동한만큼 다리를 출력한다. (OutputView # printMap)
- [x] 이동한 곳이 'X'인 경우 재시작 여부 입력 요청 문구를 출력한다. (ViewMessage # printGameCommandInputRequest)
    - [x] 재시작 여부를 입력 받는다. (InputView # readGameCommand)
    - [x] 입력받은 재시작 여부에 대한 유효성 검사를 한다. (InputView # validateGameCommand)
    - [x] 'R'을 입력 받으면 시도 횟수 +1을 하고, '2.게임 진행하기' 로 돌아간다. (BridgeGame # retry)
    - [x] 'Q'를 입력 받으면 게임을 종료한다. (BridgeGame # quitGame)
        - [x] 최종 게임 결과를 출력한다 (OutputView # printResult)
        - [x] 게임 성공 여부 실패를 출력한다. (OutputView # printResult)
        - [x] 시도 횟수를 출력한다. (OutputView # printResult)
- [x] 유저가 끝까지 이동하면 게임을 종료한다. (BridgeGame # quitGame)
    - [x] 최종 게임 결과를 출력한다 (OutputView # printResult)
    - [x] 게임 성공 여부 성공을 출력한다. (OutputView # printResult)
    - [x] 시도 횟수를 출력한다. (OutputView # printResult)
## 예외 처리
- [x] 아래에 해당하는 예외가 발생할 시 IllegalArgumentException를 일으키고 [ERROR]로 시작하는 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
### 1. 다리 길이 입력 예외 처리
- [x] 입력이 3 이상 20 이하의 숫자가 아니면 예외 처리한다. (InputView # isLengthOutOfRange)
- [x] 입력이 숫자가 아니면 예외 처리한다. (InputView # isNotNumber)
### 2. 라운드마다 플레이어가 이동할 칸 입력 예외 처리
- [x] 'U' 와 'D' 가 아닌 문자일 경우 예외 처리한다. (InputView # isNotUD)
### 3. 게임 재시작/종료 여부 입력 예외 처리
- [x] 'R' 와 'Q' 가 아닌 문자일 경우 예외 처리한다. (InputView # isNotRQ)