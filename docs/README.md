기능 구현 목록

Application
- 사다리게임을 시작하는 클래스

BridgeGame
- 게임을 실행하고 입력과 출력, 핵심 로직을 구현하는 기능

BridgeMaker
- bridgeNumberGenerator로 부터 생성된 값을 bridgeWithNumber에 저장하고, bridgeWithAlphabet에 영어로 다시 저장하는 기능

InputException
- 에러메세지를 enum으로 저장하고 message로 출력하는 기능

InputView
- 사용자로부터 입력을 받는 기능 및 잘못된 입력값일때 에러를 발생

OutputView
- 사용자에게 보여지는 출력을 하는 기능

View
- 출력메세지를 enum으로 저장하고 message로 출력하는 기능