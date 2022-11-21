# 기능 목록
## 기능 요구 사항
위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
- 위아래 두 칸으로 이루어진 다리를 건너야 한다. 
  - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
  - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력받고 생성한다.
  - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
  - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
  - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
  - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
  - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
  - 재시작해도 처음에 만든 다리로 재사용한다.
  - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 기능 목록
- [x] bridge getter&setter - Bridge
- [x] outputBridge getter&setter - Bridge
- [x] tryCount getter&setter - Bridge
- [x] isGame getter&setter - Bridge

- [x] 다리 이동에 성공했는지 검사 - BridgeGame#move
- [x] 다리 이동이 성공했는지에 따라 출력할 객체에 값을 저장 - BridgeGame#moveBridge
  - [x] 다리 건너기에 성공했을 때 U 또는 D에 따라 outputBridge에 저장하는 값 변경 - BridgeGame#succeeMoveBridge
    - [x] 0번째 객체에는 " O ", 1번째 객체에는 "   "을 저장 - BridgeGame#successBridgeUp
    - [x] 0번째 객체에는 "   ", 1번째 객체에는 " O "을 저장 - BridgeGame#successBridgeDown
  - [x] 다리 건너기에 실패했을 때 U 또는 D에 따라 outputBridge에 저장하는 값 변경 - BridgeGame#filaMoveBridge
    - [x] 0번째 객체에는 "   ", 1번째 객체에는 " X "을 저장 - BridgeGame#failBridgeUp
    - [x] 0번째 객체에는 " X ", 1번째 객체에는 "   "을 저장 - BridgeGame#successBridgeDown
- [x] 매개 값이 R이면 시도 횟수를 증가하고 true를 반환하고 이 외에는 false를 반환 - BridgeGame#retry

- [x] "다리 건너기 게임을 시작합니다."를 출력
- [x] "다리의 길이를 입력해 주세요."를 출력
- [x] 다리의 길이를 입력 - InputView#readBridgeSize
  - [x] 입력한 다리의 길이가 조건에 맞는지 검사(예외 사항 참고) - InputView#isBridgeSizeNumber
  - [x] String to int - InputView#toInts
- [x] 입력받은 길이 만큼 2줄의 다리 생성 - BridgeMaker#makeBridgeList
  - [x] 입력받은 다리 길이만큼 다리 생성 - BridgeMaker#makeBridge
- [x] "이동할 칸을 선택해주세요. (위: U, 아레: D)"를 출력
- [x] 이동할 칸을 입력받기 - InputView#readMoving
  - [x] 입력한 값이 U 또는 D 인지 검사 - InputView#isReadMoving
- [x] 1 또는 0을 랜덤으로 생성 - bridgeRandomNumber(클래스 변경)
- [x] 시도한 횟수를 반환 - getTryCount
- [x] BridgeRandomNumberGenerator 클래스를 이용하여 랜덤 값 추출(입력 받을 때마다 랜덤 값 생성)
- [x] 이동한 칸에 따라 결과를 반영하여 결과를 출력
- [x] "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"를 출력
- [x] 게임 재시도 여부를 입력(예외 사항 참고)
- [x] 최종 게임 결과를 출력(게임 결과, 게임 성공 여부, 총 시도한 횟수) - OutputView#printResult
  - [x] 최종 게임 결과에 따라 성공 또는 실패로 출력 - OutputView#printIsGameSuccess
  - [x] 총 시도한 횟수를 출력 - OutputView#printTryCount

- [x] "[ERROR] 3 이상 20 이하의 숫자를 입력해주세요."를 출력 - ErrorMessage#inputBridgeNumber
- [x] "[ERROR] 위 칸은 'U', 아래 칸은 'D'를 입력해주세요."를 출력 - ErrorMessage#inputMoveBridgeError

## 예외 사항
- [x] 다리의 길이 입력이 숫자가 아닌 경우
- [x] 다리의 길이 입력이 3이상 20이하가 아닌 경우
- [x] 플레이어가 이동할 칸의 입력이 U 또는 D가 아닌 경우
- [x] 게임 재시작 여부 입력이 R 또는 Q가 아닌 경우