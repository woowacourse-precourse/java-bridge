### 다리 만들기 게임

- 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

- [x]  위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - [x]  다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - [x]  위아래 둘 중 하나의 칸만 건널 수 있다.
- [x]  다리의 길이를 숫자로 입력받고 생성한다.
    - [x]  다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
    - [x]  위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - [x]  무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- [x]  다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - [x]  이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
    - [x]  이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- [x]  다리를 끝까지 건너면 게임이 종료된다.
- [x]  다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
    - [x]  재시작해도 처음에 만든 다리로 재사용한다.
    - [x]  게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- [x]  사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [x]  Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 입력

- [x]  자동으로 생성할 다리 길이(3 이상 20 이하의 숫자)를 입력 받는다.
    - [x]  올바른 값이 아니면 IllegalArgumentException을 던진다.
- [x]  라운드마다 플레이어가 이동할 U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력 받는다.
    - [x]  올바른 값이 아니면 IllegalArgumentException을 던진다.
- [x]  게임이 종료되면 재시작/종료 여부 R(재시작)과 Q(종료) 중 하나의 문자를 입력 받는다.
    - [x]  올바른 값이 아니면 IllegalArgumentException을 던진다.

### 출력

- [x]  게임을 시작하면 `다리 건너기 게임을 시작합니다.`를 출력한다.
- [x]  다리 길이를 입력받기 전 `다리의 길이를 입력해주세요.`를 출력한다.
- [x]  이동할 칸을 선택하기 전 `이동할 칸을 선택해주세요. (위: U, 아래: D)`를 출력한다.
- [x]  게임을 다시할 지 선택하기 전 `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)`를 출력한다.
- [x]  사용자가 이동할 때마다 다리 건너기 결과를 출력한다.
    - [x]  이동할 수 있는 칸을 선택한 경우 `O`를 표시한다.
    - [x]  이동할 수 없는 칸을 선택한 경우 `X`를 표시한다.
    - [x]  선택하지 않은 칸은 공백 한 칸으로 표시한다.
    - [x]  다리의 시작은 `[`, 다리의 끝은 `]`으로 표시한다.
    - [x]  다리 칸의 구분은 앞뒤 공백이 존재하는 `|` 문자열로 구분한다.
    - [x]  현재까지 건넌 다리를 모두 출력한다.
- [x]  다리 건너기 게임이 종료된다면 다리 건너기 결과와 게임 성공 여부를 출력한다
    - [x]  다리 건너기 결과는 `최종 게임 결과`를 출력한 뒤에 화면에 출력한다.
    - [x]  결과 출력 이후 게임 성공 여부를 출력한다.
        - [x]  성공한 경우 `게임 성공 여부: 성공`을 출력한다.
        - [x]  실패한 경우 `게임 성공 여부: 실패`를 출력한다.
    - [x]  성공 여부 출력 후 `총 시도한 횟수: X` 를 출력한다.
- [x]  예외 상황이 존재하는 경우 `[ERROR]` 로 시작하는 예외 문구를 출력한다.

### Domain

- [x]  MoveResult 성공, 실패 표현하는 Enum
    - [x]  getInitialLetter -> initialLetter를 반환
    - [x]  isFail -> 실패인지 확인
- [x]  Round 각 라운드를 표현하는 클래스
    - [x]  nextRound -> round 값을 1 증가시킨다.
    - [x]  reset -> round 값을 1로 초기화
    - [x]  naturalOrder -> Round를 오름차순으로 반환
    - [x]  naturalOrderWithSize -> size까지의 Round를 오름차순으로 반환
- [x]  Direction 위 아래 방향을 표현하는 Enum
    - [x]  toInitialLetter -> 0과 1사이의 값을 받아 D와 U중 하나를 반환
    - [x]  toEnum -> D와 U를 입력받아 Enum 인스턴스를 반환
    - [x]  isNotSameDirection -> 다른 방향인지 확인
- [x]  AnswerBridge 다리를 표현하는 클래스
    - [x]  check -> 라운드와 방향을 입력받아 MoveResult를 반환
    - [x]  isLastRound -> 마지막 라운드인지 확인
- [x]  Player 사용자 클래스
    - [x]  move -> 다리 건너기
    - [x]  reset -> 해당 게임을 리셋
    - [x]  getGameResult -> 게임 결과 확인
    - [x]  getGamePlayCount -> 게임 실행 횟수를 반환
    - [x]  checkGamePassed -> 다리 건너기 성공 유무 반환
- [x]  BridgeGame 다리 건너기 게임을 관리하는 클래스
    - [x]  move -> 움직이는 방향에 대한 결과 확인
    - [x]  retry -> 게임 진행할지 결정
    - [x]  isPlayable -> 게임 진행 여부를 확인
- [x]  BridgeMaker 다리를 생성하는 클래스
    - [x]  makeBridge -> 다리의 길이를 입력받아 U와 D로 표현된 다리를 반환
- [x]  BridgeGameStatus 게임 진행 여부 Enum
- [x]  GamePlayCount 시도 횟수를 표현하는 클래스
- [x]  BridgeGameResult 게임 결과를 표현하는 클래스
    - [x]  addResult -> 라운드와 게임 결과를 입력받아 추가
    - [x]  getResult -> 1라운드 부터의 게임 결과를 반환
    - [x]  retry -> 게임 결과를 초기화
    - [x]  checkPassed -> 게임 결과에 실패가 없는지 확인
- [x]  Victory 다리건너기 게임 최종 결과를 표현하는 enum
    - [x]  getEnum -> 실패 갯수를 입력받아 이늄을 반환
    - [x]  getResult -> Enum에 따라 성공 또는 실패 문자열을 반환
    - [x]  isVictory -> 승리여부 반환

### Other

- [x]  BridgeGameController 요청 처리
- [x]  BridgeGameService 비즈니스 로직 처리
- [x]  InputView 입력 처리
    - [x]  readBridgeSize -> 다리 길이 입력
    - [x]  readMoving -> 사용자의 이동 방향 입력
- [x]  OutputView 출력 처리
    - [x]  printGameStart -> 게임 시작 메시지를 출력
    - [x]  printMap -> 다리 출력
    - [x]  printError -> 에러를 출력
- [x]  InputValidator 입력 검증
    - [x]  validateBridgeSize -> 다리 길이 검증
    - [x]  validateMoving -> 이동 방향 검증
- [x]  GameMoveDto 움직임 결과
- [x]  GameResultDto 최종 결과
