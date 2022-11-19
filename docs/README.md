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
- int distance : 시작점으로부터 거리
- int verticalStatus : Up or Down
4. Bridge
- List<Position> bridge
- of(List<String>)
- play(Position userNextPosition)
  - UserStatus
  - return
    - bridge가 nextPosition을 포함하고 마지막 값일 때 : WIN
    - bridge가 nextPosition을 포함하고 마지막 값이 아닐 때 : KEEP
    - bridge가 nextPosition을 포함하지 않을 때 : LOSE
4. UserPosition
- 유저의 위치
- List<String> position
- newInstance()
  - 0에서 시작해서 하나씩 추가하기 때문
- move(String command)
  - command의 값을 position에 추가
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