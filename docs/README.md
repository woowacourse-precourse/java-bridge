## 기능 목록

### 입력 - ClassName : InputView
- [x] 다리의 길이를 입력받는다. - `#readBridgeSize()`
  - 예외사항
    - 숫자가 아닌경우
    - 숫자가 3~20 내의 범위 외의 숫자인 경우
    
- [x] 사용자가 이동할 칸을 입력받는다. - `#readMoving()`
  - 예외사항
    - U/D 외의 문자가 입력된 경우

- [x] 사용자의 게임 재시도 입력을 받는다. - `#readGameCommand()`
  - 예외사항
    - R/Q 외의 문자가 입력된 경우

---

### 출력 - ClassName : OutputView
- [x] 현재까지 이동한 다리의 상태를 출력 - `#printMap()`
- [x] 최종 결과 출력 - `#printResult()`
    - [x] 게임 성공 여부 출력 -`#printIsSuccess()`
    - [x] 총 시도 횟수 출력 - `#printTotalTry()`

- [x] 사용자의 게임 재시도 입력을 받는다. - `#readGameCommand()`
    - 예외사항
        - R/Q 외의 문자가 입력된 경우
      
---
        
### 다리 만들기 - ClassName : BridgeMaker
- [x] 입력받은 길이만큼의 다리 생성 - `#makeBridge()`
  - [x] 위 칸 (1) 인 경우 U, 아래 칸 (0) 인 경우 D 로 변환 - `#convertNumberToBridge()`

---

### 브릿지 게임 진행 - ClassName : BridgeGame
- [x] 이동하기 - `#move()`
- [x] 게임을 재시도하는 경우 - `#retry()`
- [x] 재시도 횟수 반환 - `#getAttempts()`

---

### 다리 정보를 저장하는 일급 컬랙션 - ClassName : Bridge
- [x] 이동할 수 있는지 없는지 확인 - `#isMovableBlock()`
- 예외사항
  - U/D 이외의 문자가 포함된 경우
- [x] 현재까지 이동한 다리 정보 조회 - `#getCrossedBridge`

---

### 예외처리
- 잘못된 값을 입력하는 경우 `IllegalArgumentException` 을 발생
  - 예외가 발생하는 명확한 유형을 처리하여 `IllegalArgumentException` 을 발생시킨다.
