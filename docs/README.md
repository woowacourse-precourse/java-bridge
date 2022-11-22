## 🚀 기능 설명

### InputView 클래스
- enum) Input
  - 입력 유형(다리 길이 / 이동할 칸 / 재시도 여부)에 따른 입력 메시지, 오류 메시지, 입력 조건을 담았다.
  - inputMessageByInputType: 입력 유형에 따른 입력 메시지를 출력하는 메서드.
  - errorMessageByInputType: 입력 유형에 따른 오류 메시지를 출력하는 메서드.
  - isRightInput: 해당 입력 유형에서 입력 조건을 만족하는지를 확인하는 메서드로, Optional로 반환한다.

- method) validateAndReturnInput
  - 입력 조건을 따지고 입력 조건을 만족하면 입력값을 반환하는 메서드.
  - isRightInput을 통해 입력 조건을 확인하고 만족하지 못한다면 오류 메시지와 함께 다시 입력을 받는다.

- method) readBridgeSize
  - 다리 길이를 입력받는 메서드. (3~20 사이의 숫자를 입력하지 않으면 오류와 함께 재입력을 요구한다.)
  
- method) readMoving
  - 이동한 칸을 입력받는 메서드. (U, D를 입력하지 않으면 오류와 함께 재입력을 요구한다.)

- method) readGameCommand
  - 재시도 여부를 입력받는 메서드. (R, Q를 입력하지 않으면 오류와 함께 재입력을 요구한다.)


### OutputView 클래스
- enum) PrintLastElement
  - 사용자가 마지막으로 입력한 칸을 지도로 출력하기 위한 것으로, 사용자가 마지막에 입력한 칸인지, 이동할 수 있는 칸을 선택했는지 여부를 담았다.
  - getMap: 사용자가 마지막에 입력한 칸인지, 이동할 수 있는 칸인지에 따라 다른 지도를 출력하는 메서드.

- method) printUpMap
  - 위 칸의 지도를 출력하는 메서드.

- method) printDownMap
  - 아래 칸의 지도를 출력하는 메서드.

- method) printMap
  - 사용자가 마지막으로 입력한 칸까지를 지도로 출력하는 메서드.

- method) printResult
  - 사용자가 다리를 건넜거나 게임을 종료했을 때, 게임 성공여부와 시도 횟수를 출력하는 메서드.


### BridgeGame 클래스
- method) move
  - 사용자가 입력한 칸이 이동할 수 있는 칸인지를 판단하여 boolean을 반환하는 메서드. 
  - false를 반환 시 BridgeGameController에서 게임을 멈추고 재시도 여부를 묻도록 함으로써 이동을 구현했다.

- method) retry
  - 사용자가 다리를 건넜는지 여부와 시도 횟수를 기록한 배열을 반환하는 메서드.
  - 다리를 건넜는지 여부를 의미하는 배열 요소가 1일 때 다리를 건넌 것으로 하였으며, 
    이때 BridgeGameController에서 재시도 여부를 묻지 않음으로써 재시도를 구현했다.

### BridgeMaker 클래스
- method) makeBridge
  - 다리 길이를 입력받았을 때 다리를 구현하는 기능으로, U와 D로만 구성되어 있는 List를 반환하는 메서드.

### BridgeGameController 클래스
- method) playBridgeGame
  - bridgeGame을 한 번 실행하는 메서드.
  - BridgeGame.move()로부터 false를 반환받았을 때 게임을 멈춘다.

- method) controlBridgeGame
  - bridgeGame 전체를 Control하는 메서드로, 게임 실행, 재시도 여부, 게임 결과를 모두 실행한다.
  - BridgeGame.retry()로부터 다리를 건넜는지 여부와 시도 횟수를 받는다.