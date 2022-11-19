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
- play(PositionTable userPositionTable)
  - return
    - WIN : usePositionTable과 positionTable의 길이가 같고 마지막 요소가 같을 때
    - KEEP : userPositionTable의 마지막 요소가 같은 위치에서 positionTable의 요소와 대응함
    - LOSE : userPositionTable의 마지막 요소가 같은 위치에서 positionTable의 요소와 다르다.
4. Bridge
- PositionTable bridgePositionTable
- of(List<String>) : bridgeMaker로부터 생성된 List<String>을 PositionTable로 mapping
- play(PositionTable userPositionTable)
  - User의 위치를 기록한 userPositionTable을 입력한다.
  - bridgePositionTable에서 play(userPositionTable)을 실행한다.
5. Result
- KEEP : 사용자가 입력한 값이 정답이고 게임이 진행중일 때
- LOSE : 사용자가 입력한 값이 정답이 아닐 때
- WIN : 사용자가 입력한 값이 정답이고 게임이 끝났을 때
## Controller
1. BridgeGame
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
- printMap(UserPosition userPosition)
- printResult(UserPosition userPosition)