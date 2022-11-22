## 기능 구현 사항

- [x] 다리 생성 
  - [x] 3 이상 20 이하의 수를 입력받는다.
    - InputView에서 입력을 받고 bridgeMaker로 전달
  
  - [x] 0(아래, D), 1(위, U) 무작위 생성한다.
    - BridgeMaker에서 BridgeNumberGenerator를 이용하여 makeBridge 메서드 구현


- [x] 일급 컬렉션 생성
  - [x] Bridge 일급 컬렉션
  - [x] BridgeGame에 GameLog를 멤버변수로 선언하여 일급 컬렉션화


- [x] 다리 건너기
  - [x] U 또는 D를 입력하여 다리를 건넌다.
    - InputView에서 readMoving 메서드를 구현
    - BridgeGame의 move 메서드를 구현
  - [x] 매 이동마다 이동 결과를 출력한다. 건널 수 있으면 O, 없으면 X로 표시한다.
    - OutputView에서 printMap 메서드를 구현


- [x] 이동에 따른 조치
  - [x] 실패하는 경우 게임 재시도 여부를 묻고 이에 따른 진행을 한다.
    - InputView의 readGameCommand 메서드를 구현
    - [x] 재시작
      - 이전 단계로 되돌아가서 다시 진행한다.
        - BridgeGame의 retry 메서드를 구현
    - [x] 종료
      - 최종 게임 결과를 출력한다.
      - OutputView의 printResult 메서드 구현
  - [x] 끝까지 이동하는 경우 결과창을 출력하며 종료한다.
    - OutputView의 printResult 메서드 구현

  
- [x] 잘못된 입력이 있는 경우에 해당 입력을 다시 받기


