# Bridge - 다리 건너기

## Feature

#### 입력

- 생성할 다리 길이를 입력받고 다리를 생성한다.
  - `GameController.makeBridgeGame()`을 통해 구현한다.
  - `inputView.readBridgeSize()`를 호출하여 다리 길이를 입력받는다.
  - `BridgeMaker.makeBridge()`를 호출하여 다리를 생성한다.
- 라운드마다 플레이어가 이동할 칸을 입력받는다.
  - `GameController.playBridgeGame()`메서드를 통해 게임을 진행한다.
  - `GameController.playRound()`메서드를 통해 라운드를 진행한다.
  - `inputView.readMoving()`를 호출하여 플레이어가 이동할 칸을 입력받는다.
- 라운드마다 다음 라운드를 진행할지 확인한다.
  - ``
- 게임 재시작/종료 여부를 입력받는다.

#### 출력
- 게임 시작 문구
- 게임 종료 문구
- 현재까지 이동한 다리의 상태
  - `BridgeMap.makeMap()`를 호출하여 다리의 상태를 담은 메시지를 만든다.
  - `OutputView.printMap()`을 호출하여 다리의 상태를 출력한다.
- 예외 상황 시 에러 문구

## Class
- GameController
- BridgeGame
  - 생성자
    - 다리를 생성한다.
- BridgeMaker
- BridgeRandomNumberGenerator
- InputView
- OutputView
- ExceptionHandler
  - 예외처리를 위한 클래스
  

## Exception Handling
- `checkBridgeSize()`
  - 입력된 다리 길이가 적법한지 확인한다.
- `convert2Integer()`
  - 입력된 문자열이 정수로 변환될 수 있는지 확인한다.
  - 변환된 정수를 반환한다.
- `checkBridgeSizeRange()`
  - 입력된 정수의 범위가 적법한지 확인한다.