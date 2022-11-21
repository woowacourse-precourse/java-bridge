## domain
1. BridgeMaker
- makeBridge(int size)
  - return : List\<string> 윗칸이면 U 아랫칸이면 D
  - 내부 로직 : 무작위로 생성한 0과 1에 따라 다리를 만든다.
  - 예외 처리 : 입력값이 3이상 20이하가 아닐 경우 IllegalArgumentException 발생
2. BridgeNumberGenerator, BridgeRandomNumberGenerator
- 변경 X
- generate()
  - return : 0 or 1
3. Position
- String position : "U" or "D"
4. PositionTable
- List<Position> positionTable: Poistion의 List를 가진 일급콜렉션. Bridge와 UserPosition에 사용된다.
5. Bridge
- PositionTable bridgeTable
- of(List<String>) : bridgeMaker로부터 생성된 List<String>을 PositionTable로 mapping
- play(PositionTable userTable)
  - return
    - WIN : useTable과 bridgeTable의 길이가 같고 마지막 요소가 같을 때
    - KEEP : userTable의 마지막 요소가 같은 위치에서 bridgeTable의 요소와 대응함
    - LOSE : userTable의 마지막 요소가 같은 위치에서 bridgeTable의 요소와 다르다.
6. Result
- KEEP : 사용자가 입력한 값이 정답이고 게임이 진행중일 때
- LOSE : 사용자가 입력한 값이 정답이 아닐 때
- WIN : 사용자가 입력한 값이 정답이고 게임이 끝났을 때
7. BridgeGame
- tryNumber : 시도 횟수
- bridge, userPosition
- start(Bridge bridge, userPosition)
  - 정적 팩터리 메서드
  - 게임을 시작하는 메서드
- move(Position position)
  - 사용자가 칸을 이동할 때 사용하는 메서드
- retry()
  - 사용자가 게임을 다시 시작할 때 사용하는 메서드
## Viewer
1. InputView
- readBridgeSize()
- readMoving()
- readGameCommand()
2. OutputView
- printMap(PositionTable userPosition)
  - draw(userTable, position -> position.isUp())
  - draw(userTable, position -> position.isDown())
- printResult(PositionTable userPosition, Result result)
  - result가 WIN이라면 그대로 printMap()과 같이 출력한다.
  - result가 LOSE라면 replace를 사용해서 마지막 " O "를 " X "로 바꿔준다.
- draw(PositionTable userTable, Predicate<Position p)
  - userTable을 바탕으로 Up 혹은 Down map을 그린다.
  - Up 칸의 bridge를 그릴지, Down 칸의 bridge를 그릴지 p를 통해 판단한다.
- replace(List<String> map)
  - 마지막이 "   "라면 그대로
  - 마지막이 " O "라면 " X "로 변경한다.
3. InputMessage
4. OutputMessage

## Controller