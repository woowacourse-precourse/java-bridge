# 미션 - 다리 건너기

## 🚀 기능 요구 사항
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


##  기능 설계
# 

- **Bridge**
  - 멤버 변수
    - spaces - 다리의 칸(U,D)을 담고 있는 List
    - BridgeMaker
  - 기능
    - 생성자
    - decideSpaces ✅
      - BridgeMaker로 각 칸의 상태 결정
    - isSuccess() ✅
      - 성공 여부 체크하는 기능
    - isFinish() ✅
      - 플레이어가 다리의 끝에 도착했는지 확인하는 기능
    - checkBridgeSpace() ✅
      - 현재 다리 칸의 상태를 리턴한다. - “U”인지 “D”인지

- **Player**
  - 멤버 변수
    - attempt
      - 플레이어가 시도한 횟수
    - currentSpace
      - 현재 플레이어가 있는 칸
    - winOrLose;
      - 승패를 판정하는 칸
  - 메소드
    - 생성자
      - 시도 횟수, 기록 모두 초기화
    - getCurrentSpace ✅
    - increaseAttempt ✅
      - 시도한 횟수 늘리는 기능
    - moveBackSpace() ✅
      - 진행할 수 없는 칸을 밟았을때, current space를 뒷 칸으로 이동하는 기능
    - moveFrontSpace() ✅
      - currentSpace를 한 칸 앞으로 이동시킴
    - lose() ✅
      - 플레이어가 지게 함
    - win() ✅
      - 플레이어가 이기게 함
    - isPlayerWin() ✅
      - 플레이어 승패 여부 확인
    - getAttempt() ✅
      - 시도 횟수 리턴

- BridgeMaker
  - bridgeNumberGenerator - 브릿지의 각 칸을 무작위로 뽑는 Generator
  - 기능
    - makeBridge ✅
      - 다리의 각 칸마다 건널 수 있는 칸을 선정(BridgeRandomNumberGenerator사용)

- BridgeRandomNumberGenerator
  - generate
    - 0, 1 중에 랜덤으로 하나를 고르는 기능

- BridgeGame (Controller)
  - 멤버 변수
    - BridgeMaker
    - InputView
    - OutputView
  - 기능
    - isSuccess() ✅
      - 다리의 칸을 제대로 밟았는지 확인하는 기능

    - move() ✅
      - 사용자가 칸을 이동할 때 사용하는 기능
      - 이동할 칸의 Up,Down 입력받음 - inputView : readGameCommand()
      - 이동할 때 마다 플레이어 현재 칸 수 증가

    - retry() ✅
      - 사용자가 다시 게임을 시도할 때 사용하는 기능
        - 플레이어 뒷 칸으로 이동
        - 시도 횟수 증가

    - isFinish() ✅
      - 마지막 칸인지 체크
        - 아니면 return false
      - 마지막 칸이라면 결과 출력
        - return true

    - win() ✅ 
    - lose() ✅
      - 각 플레이어가 이기고, 졌을 때 바꿔주는 기능

- InputView
  - readBridgeSize() ✅
    - 다리 길이를 입력받음
  - readMoving() ✅
    - 사용자가 이동할 칸 입력받음
  - readGameCommand() ✅
    - retry 여부 입력받음

- OutputView
  - printMap() ✅
    - 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
    - 만약 실패로 전달되었으면, 이전 칸까지는 O를 출력하고, 현재 칸은 X의 위치를 출력한다.
    - 만약 성공으로 전달되었다면, 현재까지 칸의 O를 출력한다.
  - printResult() ✅
    - 만약 실패로 전달되었으면, 이전 칸까지를 그대로 출력하고, 현재 칸은 X의 위치를 출력한다.
    - 만약 성공으로 전달되었다면, 모든 칸의 O의 위치를 출력한다.
    - 이후 성공/실패 여부 출력
    - 총 시도 횟수 출력

- Application (Controller)
  - win() ✅
    - 플레이어가 이겼을 때 이겼다고 설정하고, 결과 출력
  - loseAndRetryCheck() ✅
    - 플레이어가 졌다고 세팅하고, 재시도 할 것인지 확인하는 기능
  - move() ✅
    - 플레이어가 이동하는 기능
  - setGame() ✅
    - 게임의 초기 세팅하는 기능