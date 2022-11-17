### 구현 기능 목록

- [x] 다리 건너기 게임을 시작한다. BridgeGame#run()
- [x] 의뢰인이 다리 건설을 요청한다. Client#requestBridgeConstruction()
- [x] 의뢰인의 요청을 받는다. ViewMaker#receiveReceiveClientRequest()
  - [x] 다리 길이를 입력한다. InputView#readBridgeSize()
  - [ ] 입력한 다리 길이 값이 유효한지 검증한다. Input#validateReadBridgeSize()
- [ ] 다리를 만든다. BridgeMaker#makeBridge()
- [ ] 이동할 칸을 입력한다. InputView#readMoving()
  - [ ] 입력한 이동할 칸의 값이 유효한지 검증한다. Input#validateReadMoving()
