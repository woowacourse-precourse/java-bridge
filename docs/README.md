# 우아한 테크코스 프리코스 4주차 - 다리건너기 게임
## 🏃 프로젝트 설명
- 우아한 테크코스 프리코스 4주차 미션인 `다리건너기 게임`에 대한 프로젝트이다.  
- 위 아래 칸으로 이루어진 다리를 건너는 게임이며, `오징어 게임`에서 나온 다리건너기 게임과 같다고 보면 된다.
- 다리의 길이는 사용자 입력에 의해 정해지며, 끝까지 건너게 될 경우 게임이 종료된다.
- 다리를 건너다 실패해도 재시작이 가능하며, 원한다면 게임을 끝낼 수도 있다.
- 게임이 종료될 경우 성공/실패 여부와 함께 시도한 횟수가 출력된다.

## 🚀 기능 목록
### 1. 게임 생성하기
#### 1) 시작안내문구 출력하기
- [ ✅ ] 게임을 시작하면 게임 시작 안내문구를 출력한다 → OutputView.printGameStart

#### 2) 다리 생성하기  
- [ ✅ ] 다리 길이 입력요청문구를 출력한다 → OutputView.printBridgeSizeInputRequest
- [ ✅ ] 다리 길이를 입력받는다 → InputView.readBridgeSize 
- [ ✅ ] 다리를 생성한다 → BridgeGameController.generateBridge
    - [ ✅ ] 번호를 랜덤하게 생성한다 → BridgeRandomNumberGenerator.generate
    - [ ✅ ] 생성된 번호가 1이면 "U", 0이면 "D"를 더한다 → BridgeMaker.addMovableSpace
    - [ ✅ ] 이 과정에서 `IllegalArgument`오류가 나면 다시 입력요청문구 출력단계로 돌아간다
    - [ ✅ ] 이 과정에서 `IllegalStatement`오류가 나면 종료한다

### 2. 게임 진행하기 → BridgeGameController.crossBridgeUntilFinish
#### 1) 다리 건너기 → BridgeGameController.crossBridge
- [ ✅ ] 이동할 칸 입력요청문구를 출력한다 → OutputView.printMovingInputRequest
- [ ✅ ] 이동할 칸을 입력받는다 → InputView.readMoving
- [ ✅ ] 그 칸으로 이동한다 → Player.move
    - [ ✅ ] 이동한 칸에 발판이 있는지 확인한다 → Bridge.isBroken
    - [ ✅ ] 없으면 떨어진다.. → Player.fallOff   
    - [ ✅ ] 이 과정에서 `IllegalArgument`오류가 나면 다시 입력요청문구 출력단계로 돌아간다
- [ ✅ ] 이동한 칸을 기록한다 → GameRecord.recordMove
- [ ✅ ] 이동한 지점까지의 다리상태를 출력한다 → OutputView.printMap
- [ ✅ ] 실패했는지 파악한다 → BridgeGame.isFailed

#### 2) 재시작 또는 종료하기  
- [ ✅ ] 실패한 경우, 재시작/종료여부 입력요청문구를 출력한다 → OutputView.printGameCommandInputRequest
- [ ✅ ] 재시작/종료여부를 입력받는다 → Input.readGameCommand 
- [ ✅ ] 입력받은 값이 "Q"면 종료한다 → BridgeGame.finish
- [ ✅ ] 입력받은 값이 "R"이면 처음부터 재시작한다 → BridgeGame.retry
    - [ ✅ ] 플레이어를 부활시킨다 → Player.reVive
    - [ ✅ ] 게임시도횟수를 1 늘린다
    - [ ✅ ] 이전 판에 기록했던 이동칸 기록들을 삭제한다
- [ ✅ ] 이 과정들에서 `IllegalArgument`오류가 나면 다시 입력요청문구 출력단계로 돌아간다

### 3. 게임결과 출력하기
- [ ✅ ] 최종 결과 다리상태를 출력한다
- [ ✅ ] 게임 성공/실패여부문구를 출력한다 
- [ ✅ ] 시도횟수를 출력한다


## 🚨 예외처리 기능목록
- [  ] 아래 목록에 있는 예외가 발생할 시  `[ERROR]`로 시작하는 메시지를 출력한다
- [  ] 공백이나 띄어쓰기만 입력된 경우, 음수가 입력된 경우도 고려해야 함
### 1. 다리 길이 입력 예외처리
- [ ✅ ] 입력이 정수가 아니면 예외처리한다

### 2. 다리 생성 예외처리
- [ ✅ ] 길이가 3 ~ 20 사이가 아니면 예외처리한다
- [ ✅ ] 생성한 번호가 0이나 1이 아니면 예외처리한다
- [ ✅ ] 생성된 다리가 U나 D로만 구성되지 않았다면 예외처리한다

### 3. 다리이동 예외처리
- [ ✅ ] 떨어진 상태 즉 죽은 상태에서 이동하려 하면 `IllegalState`오류를 낸다

### 4. 이동할 칸 예외처리
- [ ✅ ] 이동할 칸이 U나 D가 아니면 예외처리한다

### 5. 재시작/종료여부 예외처리
- [ ✅ ] 커맨드가 R이나 Q가 아니면 예외처리한다