## 구현할 기능 목록

### controller / [gameController] (절차별 목록)

- [x] 인스턴스 변수만 사용 (view 객체 service 객체)
    - [x] `InputController`
    - [x] `OutputView`
    - [x] `BridgeGame`
- [x] 게임 시작 문구 출력 `outputView.printStartMessage()`
- [x] 다리 길이 입력 `InputController.getBridgeSize()`
- [x] 다리 만들기 `bridgeGame.makeBridge`
- `gameController`의 `playGame()`
  - [x] 시도 횟수 +1 및 게임 결과 초기화 `bridgeGame.setUpRound()`
  - [x] for 문 (다리 리스트) `gameController.playRound()`
    - [x] 이동할 칸 입력 `InputController.getStairs()`
    - [x] 이동 `BridgeGame.move()`
    - [x] 이동 결과 출력 `outputView.printMap`
    - [x] 이동 결과 확인 `bridgeGame.isRightStairs()`
    - [x] 일치하지 않을 시, `break`
  - [x] 실패로 끝난 경우
    - [x] 게임 결과 실패로 변경 `bridgeGame.changeResultToFail()`
    - [x] 게임 재시작/종료 여부를 입력 `inputController.getExitOption()`
  - [x] 성공으로 끝난 경우
    - [x] 게임 종료
- [x] 게임 종료시
  - [x] 게임 결과 출력 `outputView.printResult`

### controller / [InputController]
- [x] `InputView`와 `validation` 연결
- [x] `getBridgeSize()`
    - [x] `BridgeSize`와 `InputView.readBridgeSize()` 연결
    - [x] 사용자가 잘못된 값을 입력할 경우 `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [x] `getStairs()`
    - [x] `Stairs`와 `InputView.readMoving()` 연결
    - [x] 사용자가 잘못된 값을 입력할 경우`[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [x] `getExitOption()`
    - [x] `ExitOption`와 `InputView.readGameCommand()` 연결
    - [x] 사용자가 잘못된 값을 입력할 경우`[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### service / [BridgeGame]

- [x] `BridgeGame`의 메서드 이름은 변경할 수 없다.
- [x] `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
    - [x] `Bridges`
    - [x] `Map`
    - [x] `GameResult`
- [x] 클래스 내에서 `InputView`와 `OutputView`를 사용하지 않는다.

### validation / [BridgeSize]

- [x] 3 이상 20 이하의 숫자인지 유효성 검사
- [x]  올바른 값이 아니면 `IllegalArgumentException` 발생

### validation / [Stairs]

- [x] U와 D 중 하나의 문자인지 유효성 검사
- [x] 올바른 값이 아니면 `IllegalArgumentException` 발생

### validation / [ExitOption]

- [x] R과 Q 중 하나의 문자인지 유효성 검사
- [x] 올바른 값이 아니면 `IllegalArgumentException` 발생

### domain / [Bridges]

- [x] `makeBridge`로 만든 List 저장
- [x] 저장된 리스트가 없는 데 getter 메서드 사용 시 `IllegalStateException` 발생
- [x] 저장된 리스트가 있는 데 makeBridge 메서드 사용 시 `IllegalStateException` 발생

### domain / [FootPrint]

- [x] 고른 칸의 숫자와 정답여부를 입력하면 `makeFootPrints`로 해당 선택의 결과 List 리턴
    - [x] 정답 여부를 판별하여 `footPrint` 선택
        - [x] 이동할 수 있는 칸을 선택한 경우 ` O |` 표시
        - [x] 이동할 수 없는 칸을 선택한 경우 ` X |` 표시
    - [x] 길이가 2인 문자열 리스트 생성 및 고른 index 칸에 결과값 입력
        - [x] 선택한 칸은 공백 한 칸 `footPrint` 표시
        - [x] 선택하지 않은 칸은 공백 한 칸 `   |` 표시

### domain / [Map]

- [x] `FootPrint.makeFootPrints` 결과 List 입력 시, upstairs / downstairs StringBuilder 저장
    - [x] 현재까지 건넌 다리를 모두 저장
    - [x] getter 메서드로 결과 요청 시, 가장 마지막 `|` 삭제 후 출력

### domain / [GameResult]

- [x] 인스턴스 변수
    - [x] `numberOfAttempts` integer 값
    - [x] `rightChoice` boolean 값
    - [x] `result` String 값
- [x] 게임 결과 입력 및 출력


### constant / [Error]

- [x] 에러 메시지 Enum으로 저장
- [x] 에러 문구는 `[ERROR]`로 시작

### view / [InputView]

- [x] 자동으로 생성할 다리 길이를 입력 받는다.
    - [x] `다리의 길이를 입력해주세요.` 문구 출력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 이용해 입력

- [x] 라운드마다 플레이어가 이동할 칸을 입력 받는다.
    - [x] `이동할 칸을 선택해주세요. (위: U, 아래: D)` 문구 출력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 이용해 입력

- [x] 게임 재시작/종료 여부를 입력 받는다.
    - [x] `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)` 문구 출력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메서드를 이용해 입력

### view / [OutputView]

- [x] `OutputView`의 메서드는 이름을 변경할 수 없다.
- [x] 게임 시작 문구 출력
    - [x] `다리 건너기 게임을 시작합니다.` 문구 출력
- [x] 사용자가 이동할 때마다 다리 건너기 결과 출력
    - [x] 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
- [x] 성공 혹은 `Q` 선택한 경우, 게임 종료 문구 출력
    - [x] `최종 게임 결과` 문구 출력
    - [x] 현재까지 건넌 다리를 모두 출력
    - [x] 게임 성공 여부 출력
        - [x] 성공 시, `게임 성공 여부: 성공` 문구 출력
        - [x] 실패 시, `게임 성공 여부: 실패` 문구 출력
    - [x] 시도 횟수 출력
        - [x] `총 시도한 횟수: 2` 문구 출력
        - [x] 현재까지 시도한 횟수 출력

### [BridgeMaker]

- [x] `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- [x] `makeBridge` 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

### [BridgeRandomNumberGenerator] & [BridgeNumberGenerator]

- [x] 클래스의 코드는 변경할 수 없다.
- [x] Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
