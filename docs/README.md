## ✨ 기능 목록

--- 

## BridgeMaker
  - 다리 생성 기능
    - `makeBridge` : 다리의 길이를 입력받아 "U", "D"로 구성된 문자 배열을 반환함

---

## BridgeMessageMaker
  - 다리 상태 출력용 메시지 생성 기능<br><br>
    - `makeBridgeMessage` : 사용자가 입력한 이동칸, 현재까지 이동한 다리칸을 입력받아 다리 상태 메시지를 생성<br><br>
    - `handlePreviousBridge` : 현재까지 지나온 다리 상태를 보여주는 메시지 생성<br><br>
    - `handleNewBridge` : 사용자 입력으로 새로 생성되는 다리 상태 메시지 생성<br><br>
    - `checkMoving` : 사용자가 입력한 이동칸의 정답 유무를 판단<br><br>

---

## BridgeGame
  - 이동, 재시작, 정답 유무 확인 등 실행 기능의 동작 상세 정의<br><br>
    - `makeBridgeMessage` : `bridgeMessageMaker`를 사용해 다리 상태 메시지를 생성하여 인스턴스 변수에 저장<br><br>
    - `checkSuccessOrFail` : 사용자 입력의 정답 유무를 입력받아 저장<br><br>
    - `move` : 사용자 이동칸 입력에 따른 재시작 유무 처리<br><br>
    - `isCorrectMoving` : 사용자가 입력한 이동칸이 정답일 경우 필요한 게임 정보 갱신<br><br>
    - `retry` : 재시작 혹은 게임 종료에 따른 진행 처리<br><br>
    - `checkMoving` : 사용자가 입력한 이동칸이 정답 유무 확인<br><br>
    - `getBridgeMessage` : 다리 상태 메시지 반환<br><br>

___

## 서비스 : GameManager
  - 게임 진행 관리<br><br>
    - `gameStart` : 게임 실행<br><br>
    - `initGameSource` : 게임 실행에 필요한 데이터 초기화<br><br>
    - `moveStart` : 사용자 이동 입력으로 인한 데이터 갱신 및 다리 상태 출력<br><br>
    - `checkProgress` : 계속 진행 / 재시작 / 게임 종료 선택<br><br>
    - `gameEnd` : 최종 결과 출력 후 게임 종료<br><br>

---

## 유틸 : InputView

  - 사용자 입력 기능
    - `readBridgeSize` : 다리 길이 입력
      - `checkBridgeSize` : 다리 길이 입력 예외 : 3미만 20초과의 입력<br><br>
    - `readMoving` : 이동할 칸 입력
      - `checkMoving` : 이동할 칸 입력 예외 : U 또는 D 외의 입력<br><br>
    - `readGameCommand` : 재시도 여부 입력
      - `checkGameCommand` : 재시도 여부 입력 예외 : R 또는 Q 외의 입력<br><br>

---

## 유틸 : OutputView
  - 게임 진행 상황, 결과 출력 기능
    - `printMap : 현재 다리 상태 출력<br><br>
    - `printResult` : 최종 결과 출력<br><br>
    
---

## 도메인 : BridgeMessage
  - 다리 상태 메시지 생성 도메인
    - `BridgeMessage` : 다리 상태 메시지 초기화<br><br>
    - `add` : 다리 상태 추가<br><br>
    - `get` : 다리 상태를 하나의 문자열로 반환<br><br>
    
---

## 도메인 : GameInfo
- 게임 진행에 필요한 정보 도메인
    - `successOrFail` : 사용자 이동칸 입력의 정답 유무<br><br>
    - `gameRound` : 게임 진행 상태 (진행 / 재시작 / 게임 종료)<br><br>
    - `currentPosition` : 현재 서 있는 다리칸 위치<br><br>
    - `trialCount` : 시도 횟수<br><br>
    
