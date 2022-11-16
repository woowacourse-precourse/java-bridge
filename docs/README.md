미션 - 다리 건너기
-------

# ✔ ️기능 목록

## 도메인 기능 목록

+ 다리를 생성한다. - BridgeMaker #makeBridge
    + 3이상 20사이의 숫자인지 확인한다 - BridgeMaker #validateSize()
    + U와 D중 무작위 값을 선택한다. - BridgeRandomNumberGenerator #generate()
    + 다리 길이만큼 U와 D의 무작위 값의 배열을 만든다. - BridgeMaker #makeBridgeWithRandomSteps
+ 다리 건너기 게임을 시작한다. BridgeGame #start()
+ 각 시도마다 다리 끝에 도달할때까지 플레이어가 이동한다. - BridgeGame #try()
    + 플레이어가 이동하고자 하는 방향으로 이동이 가능한지 확인한다. - BridgeGame #canMove
    + 이동이 불가능하면 실패한다.
    + 이동이 가능하면 이동한다. -BridgeGame #move
    + 실패하지 않았다면 위 과정을 반복한다.
    + 이번 시도 결과(각 라운드별 움직인 방향, 성공여부)를 저장한다. - BridgeGame #setTryResult()
+ 사용자에게 입력받은 재시작/종료 여부에 따라 다시 실행한다 - BridgeGame #retry()

## 입출력 기능 목록

### 입력

+ 자동으로 생성할 다리 길이를 입력받는다. - InputView #readBridgeSize
+ 라운드마다 플레이어가 이동할 칸을 입력받는다. - InputView #readMoving
+ 게임 재시작/종료 여부를 입력 받는다. - InputView #readGameCommand

### 출력

+ 게임 시작 문구를 출력한다.
+ 라운드 결과를 출력한다. -OutputView #printMap
+ 최종 게임 결과를 출력한다. (각 라운드 결과, 게임 성공 여부, 총 시도한 횟수) - OutputView #printFinalResult
    + 각 라운드 결과 - OutputView #printMap
    + 게임 성공 여부 - OutputView #printResult
+ 에러 문구를 출력한다.

# 프로젝트 구조

- bridge
    - domain
        - 다리의 생성과 관련된
            - Bridge
            - BridgeSize
            - BridgeMaker
            - BridgeNumberGenerator, BridgeRandomNumberGenerator
            - BridgeStep - Enum클래스
        - 게임과 관련된
            - BridgeGames
            - BridgeGame - caculator의 역할
            - BridgeGameResult - 각 시도, 여러 라운드(move)로 이루어짐.
            - BridgeGameResults - 여러 시도로 이루어짐
    - view
        - inputView
        - outputView