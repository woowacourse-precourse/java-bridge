- 기능 구현 목룍
    - 다리 길이를 입력받는 InputView.readBridgeSize 구현
    - 이동할 칸 (위 또는 아래)을 입력받는 InputView.readMoving 구현
    - 이동이 불가능한 칸으로 이동시, 게임 종료/ 재시작을 입력받는 InputView.readGameCommand 구현
    - 한칸을 이동할때마다, 움직인 칸까지의 다리 상태를 출력해주는 OutputView.printMap 구현.
    - 다리를 다 건너거나/ 이동 실패시 Q를 입력받은 경우, 게임 결과를 출력해주는 OutputView.printResult 구현.
    - 입력받은 U/D를 토대로, 다리의 이동을 진행시키는 BridgeGame.move 구현.
    - 입력받은 R를 토대로, 다리게임을 재시작 시키는 BridgeGame.retry 구현.
    - InputView.readBridgeSize를 토대로, 다리를 생성하는 BridgeMaker.makeBridge 구현.
    - 각 메서드들에 대해, 유효성 검증을 통한 예외처리가 필요한 경우들을 위해 Validation, Exception 클래스 구현.



- 테스트 구현
    - 다리길이의 입력에 맞게끔 List가 길이가 생성되었는지
    - 다리의 각 요소마다, 0또는 1이 잘 생성되었는지
    - 이동할 칸이 U/D가 아닌경우, 예외를 발생시키는지
    - 이동할 칸에 갈수 있는 칸을 입력하지 않았을시, 게임종료/재시작을 입력받는 출력문이 나오는지
    - Q/R를 입력하지 않았을 때, 예외가 발생하는지
    - Q를 입력했을 때, 게임 종료에 따른 결과를 출력해 주는지
    - R를 입력했을 때, 게임 재시작에 따른 다리게임을 다시 시작해주는지
    - R를 입력했을 때, 다리게임의 다리는 이전 다리와 동일한것을 쓰는지
