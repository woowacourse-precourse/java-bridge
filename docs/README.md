## ⭐️ 기능 목록
- [x] 게임 시작 문구 출력 기능 - BridgeGame

- [x] 다리의 길이를 입력받는 기능 (3 이상 20이하의 숫자) - InputView
  - [x] 다리 길이 입력받기 - InputView#readBridgeSize
  - [x] 예외처리 (숫자가 아닐 때 / 범위 벗어났을 때) - InputView#validateBridgeSize
- [x] 입력받은 길이에 해당하는 다리를 생성하는 기능 - BridgeMaker
  - [x] 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타내기 - BridgeMaker#makeBridge
  - [x] 건널 수 있는 칸은 0(아래 칸)과 1(위 칸)중 무작위 값 이용해서 정하기 - BridgeRandomNumberGenerator#generate


- [x] 이동할 칸을 입력받는 기능 - InputView
  - [x] 이동할 칸 입력받기 - InputView#readMoving
  - [x] 예외처리 (U 또는 D중 하나가 아닐 때) - InputView#validateMoving
- [x] 이동하는 기능 - BridgeGame#move
  - [x] 이동 가능 여부 판별 - BridgeGame#canMove
  - [x] 이동 결과를 출력하는 기능 - OutputView#printMap

  - [x] 다리를 끝까지 건너면 게임이 종료된다
  - [x] 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다 - BridgeGame#retry
    - [x] 재시도 여부 입력받기 - InputView#readGameCommand
    - [ ] 예외처리 (R 또는 Q중 하나가 아닐 때) - InputView#validateGameCommand
  
- [x] 게임 종료 문구 출력 기능 - OutputView#printResult
  - [x] 최종 게임 결과 출력 
  - [x] 게임 성공 여부 출력 
  - [x] 총 시도한 횟수 출력  


⚠️예외처리 : 잘못된 값 입력한 경우⚠️
  - IllegalArgumentException 발생 시키기
  - "[ERROR]"로 시작하는 에러 메시지를 출력
  - 그 부분부터 입력을 다시 받는다.
  - +) 예외처리용 클래스 따로 만들까? 아니면 그냥 해당 클래스 안에서 알아서 처리?

## 🔗 제시된 클래스
- InputView : 사용자로부터 입력을 받는 역할
  - readBridgeSize : 다리의 길이를 입력받는다
  - readMoving : 사용자가 이동할 칸을 입력받는다
  - readGameCommand : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다

- OutputView : 사용자에게 게임 진행 상황과 결과를 출력하는 역할
  - printMap : 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
  - printResult : 게임의 최종 결과를 정해진 형식에 맞춰 출력한다

- BridgeGame : 다리 건너기 게임을 관리
  - move : 사용자가 칸을 이동할 때 사용
  - retry : 사용자가 게임을 다시 시도할 때 사용

- BridgeMaker : 다리의 길이를 입력 받아서 다리를 생성해주는 역할
  - makeBridge : 입력받은 길이에 해당하는 다리표현(ex. UDDUDD)

- BridgeRandomNumberGenerator : 
  - generate : 랜덤숫자(0,1) 반이



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
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.