## Domain
1. Position
- 예외처리 : U 와 D이외의 값을 가지면 IllegalStateException
2. PositionTable
- Poistion의 List를 가진 일급콜렉션. 
- Bridge와 UserPosition에 사용된다.
3. Bridge
- PositionTable인 bridgeTable
- play
  - 유저가 한칸 움직였을 때, 게임을 진행할지 패배처리할지 승리처리할지 결과를 낸다.
  - 다른 PositionTable인 UserTable을 입력받는다.
  - WIN : useTable과 bridgeTable의 길이가 같고 마지막 요소가 같을 때
  - KEEP : userTable의 마지막 요소가 같은 위치에서 bridgeTable의 요소와 대응함
  - LOSE : userTable의 마지막 요소가 같은 위치에서 bridgeTable의 요소와 다르다.
4.GameResult
- KEEP : 사용자가 입력한 값이 정답이고 게임이 진행중일 때
- LOSE : 사용자가 입력한 값이 정답이 아닐 때
- WIN : 사용자가 입력한 값이 정답이고 게임이 끝났을 때
5.TryNumber
- 게임 총 시도회수
- 논리적으로 초기화 시작을 0으로 밖에 할 수 없고 멤버 변경을 increase()함수로만 진행하므로 예외처리 하지 않는다.

## Controller
1.BridgeGame
- 게임을 진행하는 메서드가 담겨있다.
- move : 유저가 게임을 승리하거나, 패배할 때까지 움직이게 한다.
- startGame : move를 이용해서 게임을 진행하고 retry 여부를 결정한다.
- determineRetry : 입력값을 바탕으로 retry할지 결정
- retry : userTable을 clear하고 다시 startGame을 사용한다.
2. BridgeGameManage
- Viewr에서 받은 사용자 입력값을 BridgeGame으로 전달하는 역할을 한다.
- readGameCommand : 재시도 여부를 입력받는다.
- readMovingCommand : 유저의 moving command를 입력받는다.
- showResult : BridgeGame으로 받은 userTable로 OutputView를 호출한다.
- moveUser : 유저를 한 번 이동시킨다.
## Viewer
1. InputView
- readBridgeSize
  - 예외처리 : 숫자가 아닌 값을 받을시 IllegalArgumentException 발생
- readMoving
  - 예외처리 : U D가 아닐시 IllegalArgumentException 발생 
- readGameCommand
  - 예외처리 : R Q가 아닐시 IllegalArgumentException 발생
2. OutputView
- printMap : 한번 이동할 때마다 중간 결과를 그린다.
- printResult : 게임이 끝난후 최종 결과를 그린다. 
3. ErrorMessage : 에러메세지 상수
4. MoveCommand, GameCommand

## 기본
BridgeMaker
- makeBridge
  - return : 윗칸이면 U 아랫칸이면 D 인 List
  - 내부 로직 : 무작위로 생성한 0과 1에 따라 다리를 만든다.
  - 예외 처리 : 입력값이 3이상 20이하가 아닐 경우 IllegalStausException 발생
    BridgeNumberGenerator, BridgeRandomNumberGenerator
- 변경 X
- generate()
- return : 0 or 1