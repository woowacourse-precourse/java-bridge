
## 🚀 기능 목록

### view
- 다리 건너기 게임 시작 출력 - OutputView#printStart()
- 다리의 길이를 숫자로 입력받는다(3~20)(에러 발생시키기) - 다시 입력받음 - InputView#readBridgeSize()
- 플레이어는 이동할 칸을 선택한다(U or D)(에러 발생시키기) - 다시 입력받음 - InputView#readMoving()
- 플레이어 이동 현황 o/x (다리 출력) - OutputView#printMap()
- 다리를 건너다가 실패 했다면 재시작 or 종료(R or Q)(에러 발생시키기) - 다시 입력받음 - InputView#readGameCommand()
- 최종 게임 결과 출력 - OutputView#printResult()
- 게임 성공 여부: 출력 - OutputView#printSuccessFailure()
- 총 시도한 횟수: 출력 - OutputView#printTryNumber()

### domain
- 다리를 생성할 수 있다
  - 생성 시 무작위로  0, 1 중 무작위로 건널 수 있는지 없는지 생성 BridgeRandomNumberGenerator#generate()
- 플레이어 이동 - Bridge#move()
  - 현재 까지 이동한 다리 모양을 생성 BridgeMaker#makeBridge()
- 총 시도한 횟수를 계산한다. BridgeGame#increasTry()

### controlloer
- 게임을 시작한다 - BridgeGame#start()
- 게임 재시작한다 - BridgeGame#retry()
- 게임을 종료한다 - BridgeGame#end()