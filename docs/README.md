## ✔ 구현할 기능 목록

- 과제에서 요구한 클래스들을 제한사항에 맞추어 구현한다
  - InputView
  - OutputView
  - BridgeGame
  - BridgeMaker
  - 의존성 주입 형태로 구현한다(ClassContext)
- 주어진 테스트를 통과하기위한 BridgeSequenceNumberGenerator를 구현한다
  - 랜덤이 아닌, sequence를 받아 그 순서대로 위, 아래를 결정한다
  - BridgeNumberGenerator를 implements하여 다형성을 확보한다
- GameLauncher클래스를 구현한다
  - 명세에 적힌 클래스들을 이용하여, GameLauncher클래스에서 게임 시나리오를 작성한다
  - 예외가 날 경우, 에러메세지를 출력하고 반복하여 입력받을 수 있게 한다

  