InputView
- readBridgeSize()
- readMoving()
- readGameCommand()
- 올바른 값일 때까지 반복해서 입력받아야함. -> 모든 입력받는 메소드에 while문을 반복적으로 사용하기 싫음
- functional interface 도입해서 반복하는 틀을 만들고 메소드(람다식)을 넣자.

ValidateInput
-> 입력값의 올바름을 확인
- 다리 길이 입력값이 숫자인가?, 3이상 20이하인가?
- 움직임 입력값이 U 또는 D 인가?
- 게임명령 입력이 R(재시작) 또는 Q(종료)인가?


OutputView
- printMap() 현재까지 진행한 맵상황 출력
- printResult() 최종 결과 출력


Player
- 방향을 가지며 플레이어의 입력에 따라 방향을 갱신

Game
-> 모든 클래스를 조합하여 실질적 게임을 구성
- 사용자의 입력으로 다리를 만드는 기능
- 움직임을 입력받아 처리

BridgeGame
- move()  플레이어의 방향값 변경 후 현재 몇번째 걸음인지 갱신
- retry() 플레이어의 걸음 수를 0으로 맞춰 처음부터 하는 효과


BridgeMaker
- makeBridge(int size) 사이즈에 맞는 다리를 만들어주는 메소드


BridgeRandomNumberGenerator
