## 필요 기능
- 입력
  - [ ] 다리 길이 - InputView#readBridgeSize()
  - [ ] 이동할 칸 - InputView#readMoving()
  - [ ] 재시작 여부 - InputView#readGameCommand()

- 출력
  - [ ] 게임시작 문구 - OutputView#printGameStart()
  - [ ] 다리 갈이 입력 안내문구 - OutputView#printBridgeSizeGuide()
  - [ ] 이동할 칸 입력 안내문구 - OutputView#printMovingGuide()
  - [ ] 재시작 안내문구 - OutputView#printGameCommandGuide()
  - [ ] 이동시마다 다리 건너기 결과 - OutputView#printMap()
  - [ ] 게임 최종 결과 - OutputView#printResult()
  
- [ ] 게임을 시작한다. - GameSimulator#simulateGame()
  - [ ] 게임을 세팅한다. - GameSimulator#initializeGame()
    - [ ] 다리를 생성한다. - BridgeMaker#makeBridge()
      - [ ] 한 칸마다 위, 아래 랜덤으로 정한다. - BridgeNumberGenerator#generate()
  - [ ] 게임이 끝날때까지 게임을 진행한다. - GameSimulator#startGame()
    - [ ] 다리를 건넜는지 체크한다. - BridgeGame#checkCrossingBridge()
    - [ ] 다리의 다음 구역으로 이동한다. - BridgeGame#move()
  - [ ] 게임오버가 되었다. - BridgeGame#gameover()
    - [ ] 게임을 재시작한다. - BridgeGame#retry()
  - [ ] 게임을 종료한다. - GameSimulator#quitGame()
    
## 에러상황
- [ ] 다리 길이 유효 여부 체크 - InputView#validateBridgeSize()
  - [ ] 숫자가 아님 - InputView#isDecimal()
  - [ ] 3부터 20이 아님 - InputView#isInRange()
- [ ] 이동할 칸 유효 여부 체크 - InputView#validateMoving()
  - [ ] "U"나 "D"가 아님 - InputView#isUpOrDown()
- [ ] 재시작 여부 유효 여부 체크 - InputView#validateGameCommand()
  - [ ] "R"나 "Q"가 아님 - InputView#isRetryOrQuit()