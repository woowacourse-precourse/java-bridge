# 다리 건너기 게임

## 기능 목록

- [x] 다리 생성 기능 -BridgeMaker#makeBridge()
  - [x] 다리 U, D 변환 기능 -BridgeMaker#bridgeUpDown()
  - [x] 다리의 길이 입력 기능 -InputView#readBridgeSize()
    - [x] 다리의 길이 숫자가 아닌 경우 예외 처리 기능 -UserException#parseInt()
    - [x] 다리의 길이 범위를 벗어나는 경우 예외 처리 기능 -UserException#numberRange()
- [x] 다리를 랜덤 생성 하는 기능 -BridgeRandomNumberGenerator#generate()
- [x] 사다리 이동 기능 -BridgeGame#move()
  - [x] 위칸 이동 기능 -BridgeGame#moveUp()
  - [x] 아래칸 이동 기능 -BridgeGame#moveDown()
  - [x] O, X 판별 기능 -BridgeGame#moveMatch()
    - [x] 이동할 칸 입력 기능 -InputView#readMoving()
    - [x] 이동할 칸 입력 예외 처리 기능 -UserException#movingException()
- [x] 진행중인 다리 건너기 출력 기능 -OutputView#printMap()
  - [x] 진행중인 위 다리 가져오는 기능 -BridgeGame#getUp()
  - [x] 진행중인 아래 다리 가져오는 기능 -BridgeGame#getUp()
- [x] 현재 진행중인 다리 인덱스 가져오는 기능 -bridgeGame#getCurrentCount()
- [x] 게임 재시도 기능 -BridgeGame#retry()
  - [x] 게임 재시도 입력 기능 -InputView#readGameCommand()
  - [x] 게임 재시도 입력 예외 처리 기능 -UserException#reGameException()
- [x] 최종 결과 출력 기능 -OutputView#printResult()
  - [x] 재시도 횟수 출력 기능
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
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.