# Bridge - 다리 건너기

## Feature

#### 입력

- 생성할 다리 길이를 입력받고 다리를 생성한다.
  - `BridgeGame`클래스의 생성자를 통해 구현한다.
  - `OutputView.printStartGame()`를 호출하여 게임 시작 메시지를 출력한다.
  - `InputView.readBridgeSize()`를 호출하여 다리 길이를 입력받는다.
  - `BridgeMaker.makeBridge()`를 호출하여 다리를 생성한다.
- 라운드마다 플레이어가 이동할 칸을 입력받는다.
- 게임 재시작/종료 여부를 입력받는다.

#### 출력

- 게임 시작 문구
- 게임 종료 문구
- 현재까지 이동한 다리의 상태
- 예외 상황 시 에러 문구

## Class
- BridgeGame
- BridgeMaker
- BridgeRandomNumberGenerator
- InputView
- OutputView

## Exception Handling