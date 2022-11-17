## domain
1. BridgeMaker
- makeBridge()
  - return : List\<string> 윗칸이면 U 아랫칸이면 D
  - 내부 로직 : 무작위로 생성한 0과 1에 따라 다리를 만든다.
2. BridgeNumberGenerator, BridgeRandomNumberGenerator
- 변경 X
- generate()
  - return : 0 or 1
3. Bridge
- play(Bridge bridge)
  - return : Result 클래스 KEEP or LOSE or WIN
  - 내부 로직 : 입력된 bridge가 자신의 bridge에 포함되면 KEEP 포함되지 않으면 END 반환
4. Result
- KEEP : 사용자가 입력한 값이 정답이고 게임이 진행중일 때
- LOSE : 사용자가 입력한 값이 정답이 아닐 때
- WIN : 사용자가 입력한 값이 정답이고 게임이 끝났을 때
## Controller
1. BridgeGame
- move()
  - 사용자가 칸을 이동할 때 사용하는 메서드
- retry()
  - 사용자가 게임을 다시 시작할 때 사용하는 메서드
## Viewer
1. InputView
2. OutputView