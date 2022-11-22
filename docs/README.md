# 우아한 테크코스 4주차 - 다리 건너기
***
## 기능 목록📝
***
1. **다리의 길이를 입력받는다** [X]
    - InputView - readBridgeSize() 구현 [X]
    - 숫자가 아닌 문자를 입력받은 경우 예외 발생 [X]
    - 입력받은 숫자 N이 (3 <= N <= 20) 범위를 벗어나는 경우 예외 발생 [X]


2. **다리를 생성한다** [X]
    - BridgeMaker - makeBridge() 구현 [X]


3. **이동할 칸을 입력받는다** [X]
    - InputView - readMoving() 구현 [X]
    - U, D외의 문자를 입력받았을 경우 예외 발생 [X]

4. **이동할 칸이 건널 수 있는 칸인지 체크한다** [X]
    - Bridge - movingResult() 구현 [X]

5. **해당 칸으로 플레이어를 이동시킨다** [X]
    - BridgeGame - move() 구현 [X]
    - BridgeResult - selectUpperBridge(), selectLowerBridge() 구현(어떤 다리를 건너려 했는지) [X]
  

6. **현재까지 이동한 다리의 상태를 출력한다** [X]
    - OutputView - printMap() 구현 [X]
    - BridgeResult - toString() 구현(다리 출력 형식에 맞게 출력) [X]
  

7. **건널 수 없는 칸을 건너려했을 때, 재시작 혹은 종료할 지 입력받는다** [X]
    - InputView - readGameCommand() 구현 [X]
    - R, Q외의 문자를 입력받았을 경우 예외 발생 [X]


8. **재시작을 입력받았을 경우에 게임을 재시작한다** [X]
    - BridgeGame - retry() 구현 [X]
    - 처음에 생성한 다리를 재사용 [X]
    - BridgeResult - clear() 구현 [X]
    - BridgeResult - getLastResult() 구현 [X]


9. **다리를 모두 건너거나 게임을 종료했을 경우 최종결과를 출력한다** [X]
    - OutputView - printResult() 구현 [X]


10. **구현한 기능들을 통합한다** [X]
