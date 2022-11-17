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
3. Bridge
- List<String> bridge
- of(List<String>)
- play(ExpectedBridge expectedBridge)
  - expectedBridge를 바탕으로 게임을 이어갈지 끝낼지를 판단
  - return : Result 클래스 KEEP or LOSE or WIN
4. ExpectedBridge
- 실제 Bridge가 아닌 사용자가 예상한 Bridge
- List<String> expectation
- newInstance()
  - 실제와 다르게 0에서 시작해서 하나씩 추가하기 때문
- expect(String position)
  - expectation에 예상값을 추가
  - return : void
- countTry()
  - return : expectation의 길이를 반환
5. Result
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