## 필요 기능
- 입력
  - [x] 다리 길이 - InputView#readBridgeSize()
  - [x] 이동할 칸 - InputView#readMoving()
  - [x] 재시작 여부 - InputView#readGameCommand()

- 출력
  - [x] 게임시작 문구 - OutputView#printGameStart()
  - [x] 다리 갈이 입력 안내문구 - OutputView#printBridgeSizeGuide()
  - [x] 이동할 칸 입력 안내문구 - OutputView#printMovingGuide()
  - [x] 재시작 안내문구 - OutputView#printGameCommandGuide()
  - [x] 이동시마다 다리 건너기 결과 - OutputView#printMap()
    - [x] 맵 한층마다의 해당하는 결과 값 - OutputView#printFloor()
    - [x] 맵 한칸마다의 해당하는 결과 값 - OutputView#printCell()
  - [x] 게임 최종 결과 - OutputView#printResult()
  
- [ ] 게임을 시작한다. - GameSimulator#simulateGame()
  - [ ] 게임을 세팅한다. - GameSimulator#initializeGame()
    - [x] 다리를 생성한다. - BridgeMaker#makeBridge()
      - [x] 한 칸마다 위, 아래 랜덤으로 정한다. - BridgeNumberGenerator#generate()
  - [ ] 게임이 끝날때까지 게임을 진행한다. - GameSimulator#startGame()
    - [x] 다리를 건넜는지 체크한다. - BridgeGame#checkCrossingBridge()
    - [x] 다리의 다음 구역으로 이동한다. - BridgeGame#move()
  - [ ] 게임오버가 되었다. - GameSimulator#gameover()
    - [x] 게임을 재시도한다. - BridgeGame#retry()
  - [ ] 게임을 종료한다. - GameSimulator#quitGame()
    
## 에러상황
- [x] 다리 길이 유효 여부 체크 - InputView#validateBridgeSize()
  - [x] 숫자가 아님 - InputView#isDecimal()
  - [x] 3부터 20이 아님 - InputView#isInRange()
- [x] 이동할 칸 유효 여부 체크 - InputView#validateMoving()
  - [x] "U"나 "D"가 아님 - InputView#isUpOrDown()
- [x] 재시작 여부 유효 여부 체크 - InputView#validateGameCommand()
  - [x] "R"나 "Q"가 아님 - InputView#isRetryOrQuit()