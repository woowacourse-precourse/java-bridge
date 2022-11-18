## 기능 구현
- InputView:
  [X] 자동으로 생성할 다리 길이를 입력받는다: int readBridgeSize()
    [X] 숫자인 경우만 가능하다: isNumber()
    [X] 다리길이 x는 3 <= x <= 20 식을 만족한다: isOutOfSize() 
  [X] 이동할 칸을 입력받는다: String readMoving()
    [X] U or D 만 입력이 가능하다: isMovingCommend()
  [X] 게임 시도 여부를 입력받는다: readGameCommand()
    [X] R or Q 만 입력이 가능하다: isGameCommand()
- BridgeMaker
  [ ] 다리 길이에 따른 정답지 생성: makeBridge(int size)
    [ ] 랜덤 함수를 활용하여 답지를 생성한다.(0 == D, 1 == U): checking()