# 다리 건너기 게임

## 기능 목록

- [ ] 게임 시작 메시지를 출력한다. (view.OutputView.printStartMessage)
- [ ] 게임의 한 단계를 시작한다. (controller.Controller.gameStageStart)
  - [ ] 다리 길이를 입력받기 위한 메시지를 출력한다. (view.OutputView.printMessageForBridgeSize)
  - [ ] 다리 길이를 입력 받는다. (view.InputView.readBridgeSize)
    - [ ] 잘못된 값이 입력된 경우, 에러 메시지를 출력하고 다시 입력 받는다. (domain.Getter.getBridgeSize) 
  - [ ] 입력 받은 길이에 맞게 다리를 생성한다. (BridgeMaker.makeBridge)
  - [ ] 플레이어가 이동할 칸을 알기 위해 메시지를 출력한다. (view.OutputView.printMessageForMoving)
  - [ ] 플레이어가 이동할 칸을 입력 받는다. (view.InputView.readMoving)
    - [ ] 잘못된 값이 입력된 경우, 에러 메시지를 출력하고 다시 입력 받는다. (domain.Getter.getMoving)
  - [ ] 한 칸을 이동시킨다. (domain.BridgeGame.move) 
  - [ ] 이동시킨 후, 해당 라운드의 결과를 출력한다. (view.OutputView.printMap)
  - [ ] 이동한 칸을 건널 수 있는지 없는지 확인한다 (domain.Judgement.checkResult)
  - [ ] 확인한 결과에 따라 재시작 여부를 결정한다 (domain.BridgeGame.retry)
    - [ ] 이동한 칸을 건널 수 있는 경우, 게임을 계속 진행한다. (controller.Controller.movingStart)
    - [ ] 이동한 칸을 건널 수 없는 경우, 게임의 재시작 여부를 입력받기 위한 메시지를 출력한다. (view.OutputView.printMessageForTermination)
    - [ ] 게임 재시작/종료 여부를 입력 받는다. (view.InputView.readGameCommand)
      - [ ] 잘못된 값이 입력된 경우, 에러 메시지를 출력하고 다시 입력 받는다. (domain.Getter.getGameCommand) 
  - [ ] 게임을 재시작한 경우, 게임을 다시 진행한다. (controller.Controller.gameStageStart)
- [ ] 게임이 종료되면 최종 게임 결과를 출력한다. (view.OutputView.printResult)
  - [ ] 게임의 성공 여부를 확인한다. (view.OutputView.checkFinalResult)



## 예외 처리 상황

- [다리 길이] 입력 값이 숫자가 아닌 경우 (error.Validator.validateIsDigit)
- [다리 길이] 입력 값이 3이상 20이하가 아닌 경우 (error.Validator.validateRangeOfLength)
- [이동할 칸] 입력 값이 U 또는 D가 아닌 경우 (error.Validator.validateMoving)
- [재시작 여부] 입력 값이 R 또는 Q가 아닌 경우 (error.Validator.validateGameCommand)



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



## 커밋 메시지 컨벤션

- feat: 기능 추가
- fix: 버그 수정
- docs: 문서 작업
- style: 코드 포맷팅
- refactor: 리팩토링
- test: 테스트 코드 작성
- chore: 주석 또는 환경설정