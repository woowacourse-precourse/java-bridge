## 🔖 기능 목록

### 🖥 UI
*** 
#### 📥 입력
- [X] 다리 길이 입력 - InputView#readBridgeSize()
  - [X] 입력 값 예외처리(수로 변환될 수 있는 값인지 검증)
  - [X] 다리 길이 유효성 검증 및 예외처리 - InputView#validateBrideSize()
- [X] 이동할 칸 입력 (위: U, 아래: D) - InputView#readMoving()
  - [X] 입력 값 예외처리(U 또는 D를 입력 했는지 검증) - InputView#validateBridgeMoving()
- [X] 게임 재시도 여부 입력 (재시도: R, 종료: Q) - InputView#readGameCommand()
  - [X] 입력 값 예외처리(R 또는 Q를 입력 했는지 검증) - InputView#validateGameCommnd()
***
#### 📤 출력
- [X] 게임 시작 안내 메시지 출력 - OutputView#printGameStartNotification()
- [X] 다리 길이 입력 안내 메시지 출력 - OutputView#printInputBridgeLengthNotification()
- [X] 이동할 칸 선택 입력 안내 메시지 출력 - OutputView#printInputArrow()
- [X] 게임 재시도 여부 입력 안내 메시지 출력 - OutputView#printInputRetryOrNot()
- [X] 현재 다리 상태 출력 - OutputView#printMap()
- [X] 최종 게임 결과 출력 (다리 상태) - OutputView#printResult()
- [X] 게임 성공 여부 출력 (성공 또는 실패) - OutputView#printGameResult()
- [X] 총 시도 횟수 출력 - OutputView#printTotalGameAttempts()
***

### ⚙️ Domain

- [X] 게임 시작 - BridgeGameManager#start()
- [X] 게임 시작 안내 메시지 출력
- [X] BridgeGame 생성 - BridgeGameManager#makeBridgeGame()
  - [X] 다리 길이 입력 안내 메시지 출력
  - [X] 다리 길이 입력 처리 - BridgeGameManager#readBridgeSize() 
  - [X] 다리 생성
- [X] 게임 주요 흐름 제어 - BridgeGameManager#mainProgress()
    - [X] 다리 길이 초기화 - BridgeGameManager#initBridgeLength()
    - [X] 다리 길이만큼 아래 작업 반복
      - [X] 다리 건너기 및 현재 다리 출력 - BridgeGameManager#moveProgress()
        - [X] 건널 다리 방향 입력 안내 메시지 출력
        - [X] 방향 키 입력 처리 - BridgeGameManager#readMoving() 
        - [X] 다리 건너기
        - [X] 현재 다리 상태 출력
      - [X] 다리를 건널 수 없는 경우이면서 게임 종료를 원하는 경우 게임 종료 처리 - BridgeGameManager#isRetry()
        - [X] 게임 재시도 또는 종료 명령어 입력 처리 - BridgeGameManager#readGameCommand()  
        - [X] 다리를 건널 수 없는 경우이면서 게임 재시도를 원하는 경우 재시도 처리
- [X] 게임 결과 출력 - BridgeGameManager#printGameResult()
    - [X] 최종 게임 결과 출력 (다리 상태)
    - [X] 게임 성공 여부 출력
    - [X] 총 시도 횟수 출력
***
- [X] 다리 생성 - BridgeMaker#makeBridge()
  - [X] 0 또는 1 중 무작위 값 생성 - BridgeMaker#BridgeNumberGenerator#generate()
  - [X] 무작위 값(0 또는 1)에 대해 각각 아래 칸(D), 위 칸(U)으로 변환 - BridgeMaker#convertBridgeRandomNumberToUpDownMark()
  - [X] 생성된 다리에 각 다리 지점 별로 이동할 수 있는 방향 값 배치 - BridgeMaker#addBridgeArrow()
***
- [X] 다리 건너기 - BridgeGame#move()
  - [X] 몇 라운드인지 계산
  - [X] 사용자가 입력한 다리 방향에 대해 다리를 건널 수 있는지 여부 확인 - BridgeGame#isCrossable()
    - [X] 게임 성공 여부 값 없데이트 - BridgeGame#updateGameResult()
  - [X] 다리에 표시할 상태 값 생성 - BridgeGame#makeBridgeStatus()
  - [X] 다리 표시 작업 요청 - BridgeGame#BridgeState#mark()
- [X] 게임 재시도 - BridgeGame#retry()
  - [X] 게임 라운드 초기화
  - [X] 게임 총 도전 횟수 카운트
  - [X] 다리 상태 초기화 요청 - BridgeGame#BridgeState#initBridgeState()
- [X] 다리 길이 값 반환 - BridgeGame#getBridgeLength()
- [X] 게임 성공 여부 값 반환 - BridgeGame#isWon()
- [X] 게임 총 도전 횟수 값 반환 - BridgeGame#getTotalGameAttempts()
***
- [X] 다리 상태 표시 - BridgeState#mark()
  - [X] 현재 위, 아래 다리 모두 비어있는지 확인 - BridgeState#isEmpty()
  - [X] 위 칸 또는 아래 칸 중 선택한 방향에 대해 건널 수 있는지 여부 표시, 위 칸 또는 아래 칸 중 선택하지 않는 방향에 대해 공백 표시
    - [X] 위, 아래 다리가 모두 비어있는 경우, 다리 건널 수 있는지 여부 값과 공백 표시 + 위, 아래 다리가 비어있지 않은 경우, "|" 값을 추가한 뒤 다리 건널 수 있는지 여부 값과 공백 표시
- [X] 다리 상태 값 반환
  - [X] 위 다리 상태 반환 - BridgeState#getUpBridgeState()
  - [X] 아래 다리 상태 반환 - BridgeState#getDownBridgeStaet()
- [X] 다리 상태 초기화 - BridgeState#initBridgeState()
***

### 📝 Domain Test

- [X] 다리 길이 유효 숫자 범위 내 길이 지정 시, 해당 길이의 다리 생성 - BridgeMakerTest#makeBridgePerSize()
***
- [X] 첫 라운드 다리 건너고 나서 위 다리 상태 값 확인 - BridgeGameTest#confirmFirstRoundUpBridgeState()
- [X] 첫 라운드 다리 건너고 나서 아래 다리 상태 값 확인 - BridgeGameTest#confirmFirstRoundDownBridgeState()
- [X] 두번째 라운드까지 다리 건너고 나서 위 다래 상태 값 확인 - BridgeGameTest#confirmSecondRoundUpBridgeState()
- [X] 두번째 라운드까지 다리 건너고 나서 아래 다리 상태 값 확인 - BridgeGameTest#confirmSecondRoundDownBridgeState()
- [X] 게임 재시작 시 총 게임 도전 횟수 카운트 값 확인 - BridgeGameTest#confimTotalGameAttemptsWhenRetry()
- [X] 게임 재시작 시 위, 아래 다리 상태 초기화 상태 확인 - BridgeGameTest#confirmInitBridgeStateWhenRetry()
***
- [X] 방향 키 + 다리 건널 수 있는지 여부 값을 통해 BridgeStatus 상수 참조 - BridgeStatusTest#referBridgeStatus()
  - [X] UP_O: 위 방향 선택 + 건널 수 있음
  - [X] UP_X: 위 방향 선택 + 건널 수 없음
  - [X] DOWN_O: 아래 방향 선택 + 건널 수 있음
  - [X] DOWN_X: 아래 방향 선택 + 건널 수 없음
- [X] 방향 키 + 다리 건널 수 있는지 여부 값으로 BridgeStatus 상수 참조 불가능 시 예외처리 - validateReferabilityBridgeStatus()