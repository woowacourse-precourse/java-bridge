# 기능 목록

---
## 다리 생성 BrideMaker

- [ ] 다리 길이 입력 받기 InputView#readBridgeSize()
  - 유효성 검사에 실패하면 다시 입력 받기
  - [ ] 입력 받은 값 유효성 검사 InputView#validateBridgeSize(int size)
- [ ] 다리 생성 하기 BridgeMaker#makeBridge(int size)
    - 3이상 20이하의 정수가 아니면 예외
    - 제공된 BridgeNumberGenerator를 통해 List 생성
    - List를 가지고 Bridge 객체 생성하여 리턴

---
## 게임 운영 GameManager
- [ ] 이동할 칸 입력 받기 InputView#readMoving()
  - [ ] U 또는 D가 아니면 예외처리하기 InputView#validateReadMoving()
  - 예외 발생하면 다시 입력 받기
- [ ] 다리 그리기 OutputView#printMap(List<String> bridge, int index, boolean isSuccess)
        
- [ ] 다시 시도 여부 입력 받기 InputView#readRetry()
- [ ] 종료 메시지 출력 OutputView#printEndMessage()
- [ ] 결과 출력 OutputView#printResult()
- 
### 게임 진행 BrideGame
- [ ] 움직일 수 있는 칸인지 평가하기 Bridge#isPossibleMove(String upDown)
- [ ] 움직이기 BrideGame#move()
  - 현재 칸 index 증가
- [ ] 다시 시도 BridgeGame#retry()
  - 진행 상황 리셋
  - 시도 횟수 증가
- [ ] 성공 여부 얻기 BridgeGame#getSuccess()
- [ ] 시도 횟수 얻기 BridgeGame#getNumberOfTries()
- 
### 추가 기능
- [ ] AOP 프록시를 이용하여 예외 발생시 다시 입력 받도록 구현