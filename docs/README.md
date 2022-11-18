# 우아한 테크코스 프리코스 4주차 - 다리건너기 게임
## 🏃 프로젝트 설명
- 우아한 테크코스 프리코스 4주차 미션인 `다리건너기 게임`에 대한 프로젝트이다.  
- 위 아래 칸으로 이루어진 다리를 건너는 게임이며, `오징어 게임`에서 나온 다리건너기 게임과 같다고 보면 된다.
- 다리의 길이는 사용자 입력에 의해 정해지며, 끝까지 건너게 될 경우 게임이 종료된다.
- 다리를 건너다 실패해도 재시작이 가능하며, 원한다면 게임을 끝낼 수도 있다.
- 게임이 종료될 경우 성공/실패 여부와 함께 시도한 횟수가 출력된다.

## 🚀 기능 목록
- [ ✅ ] 게임을 시작하면 게임 시작 안내문구를 출력한다 → OutputView.printGameStart

### 1. 다리 생성하기  
- [ ✅ ] 다리 길이 입력요청문구를 출력한다 → OutputView.printBridgeSizeInputRequest
- [  ] 다리 길이를 입력받는다 → InputView.readBridgeSize
- [  ] 입력받은 다리 길이에 대한 유효성을 검사한다 
- [  ] 다리를 생성한다 → BridgeMaker.makeBridge
    - [  ] 각 다리가 U 또는 D로만 이루어졌는지 확인 후 생성하도록 한다 → Bridge.validateBridge

### 2. 다리 건너기
- [  ] 이동할 칸 입력요청문구를 출력한다 → OutputView.printMovingInputRequest
- [  ] 이동할 칸을 입력받는다 → InputView.readMoving
- [  ] 입력받은 이동할 칸에 대한 유효성을 검사한다 → Bridge.validateMoving
- [  ] 이동한 칸에 대한 성공여부를 확인한다 Bridge.confirmMoving
- [  ] 이동한 지점까지의 다리상태를 출력한다 → OutputView.printMap

### 3. 재시작 또는 종료하기  
- [  ] 실패한 경우, 재시작/종료여부 입력요청문구를 출력한다 → OutputView.printGameCommandInputRequest
- [  ] 재시작/종료여부를 입력받는다 → Input.readGameCommand
- [  ] 입력받은 재시작/종료여부에 대한 유효성을 검사한다 → BridgeGame.validateGameCommand 
- [  ] 입력받은 값이 "Q"면 종료한다 → BridgeGame.finish
- [  ] 입력받은 값이 "R"이면 처음부터 재시작한다 → BridgeGame.retry

### 4. 게임결과 출력하기
- [  ] 게임 성공/실패여부문구를 출력한다 
- [  ] 시도횟수를 출력한다


## 🚨 예외처리 기능목록
- [  ] 아래 목록에 있는 예외가 발생할 시 `IllegalArgumentException`를 일으키고 `[ERROR]`로 시작하는 메시지를 출력한다
- [  ] 공백이나 띄어쓰기만 입력된 경우, 음수가 입력된 경우도 고려해야 함
### 1. 다리 길이 입력 예외처리
- [  ] 입력이 숫자로만 구성된 게 아니면 예외처리한다
- [  ] 3 ~ 20 사이의 숫자가 아니면 예외처리한다

### 2. 이동할 칸 입력 예외처리
- [  ] 입력이 U나 D가 아니면 예외처리한다

### 3. 재시작/종료여부 입력 예외처리
- [  ] 입력이 R이나 Q가 아니면 예외처리한다