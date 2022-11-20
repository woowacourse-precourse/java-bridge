## 🔖 기능 목록 

### 🖥 UI
*** 
#### 📥 입력  
- [ ] 다리 길이 입력 
    - [ ] 입력 값 예외처리(수로 변환될 수 있는 값인지 검증)  
- [ ] 이동할 칸 입력 (위: U, 아래: D)
    - [ ] 입력 값 예외처리(길이 1의 문자를 입력했는지 검증)
- [ ] 게임 재시도 여부 입력 (재시도: R, 종료: Q)
***
#### 📤 출력
- [ ] 게임 시작 안내 메시지 출력
- [ ] 현재 다리 상태 출력
- [ ] 최종 게임 결과 출력
- [ ] 게임 성공 여부 출력 (성공 또는 실패)
- [ ] 총 시도 횟수 출력
***

### ⚙️ Domain

- [X] 다리 생성 - BridgeMaker#makeBridge()
    - [X] 다리 길이 유효성 검증 및 예외처리 - BridgeMaker#validateBrideSize()
    - [X] 0 또는 1 중 무작위 값 생성 - BridgeMaker#BridgeNumberGenerator#generate()
    - [X] 무작위 값(0 또는 1)에 대해 각각 아래 칸(D), 위 칸(U)으로 변환 - BridgeMaker#convertBridgeRandomNumberToUpDownMark()
    - [X] 생성된 다리에 각 다리 지점 별로 이동할 수 있는 방향 값 배치 - BridgeMaker#addBridgeArrow()
***
- [X] 다리 건너기 - BridgeGame#move()
    - [X] 다리 방향 입력 값 검증 및 예외처리 - BridgeGame#validateBridgeArrow()
    - [X] 몇 라운드인지 계산
    - [X] 사용자가 입력한 다리 방향에 대해 다리를 건널 수 있는지 여부 확인 - BridgeGame#isCrossable()
    - [X] 다리에 표시할 상태 값 생성 - BridgeGame#makeBridgeStatus()
    - [X] 다리 표시 작업 요청 - BridgeGame#BridgeState#mark()
- [ ] 게임 재시도 - BridgeGame#retry()
    - [X] 게임 라운드 초기화 
    - [X] 게임 총 도전 횟수 카운트
    - [ ] 다리 상태 초기화 요청 - BridgeGame#BridgeState#initBridgeState()
- [ ] 게임 성공 여부 값 반환 - BridgeGame#isWon()
- [ ] 게임 총 도전 횟수 값 반환 - BridgeGame#getTotalGameAttemps()
***
- [ ] 다리 상태 표시 - BridgeState#mark()
    - [ ] 현재 위, 아래 다리 모두 비어있는지 확인 - BridgeState#isEmpty()
    - [ ] 위 칸 또는 아래 칸 중 선택한 방향에 대해 건널 수 있는지 여부 표시 
    - [ ] 위 칸 또는 아래 칸 중 선택하지 않는 방향에 대해 공백 표시   
- [ ] 다리 상태 값 반환 - BridgeState#getBridgeState()
- [ ] 다리 상태 초기화 - BridgeState#initBridgeState()
***

### 📝 Domain Test

- [X] 다리 생성 시, 다리 길이 유효 숫자 범위를 벗어난 경우 예외 발생 - BridgeMakerTest#validateBridgeSize()
- [X] 다리 길이 유효 숫자 범위 내 길이 지정 시, 해당 길이의 다리 생성 - BridgeMakerTest#makeBridgePerSize()