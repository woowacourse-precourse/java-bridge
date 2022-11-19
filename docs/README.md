
## 🚀 기능 목록

- 전체 애플리케이션 실행 [ x ] #BridgeGameManager#run()

### view
- 다리 건너기 게임 시작 출력 - [ x ] OutputView#printStart()
- 다리의 길이를 숫자로 입력받는다(3~20)(에러 발생시키기) - 다시 입력받음 - [ x ] InputView#readBridgeSize()
- 플레이어는 이동할 칸을 선택한다(U or D)(에러 발생시키기) - 다시 입력받음 - [ x ] InputView#readMoving()
- 플레이어 이동 현황 o/x (다리 출력) - [ x ] OutputView#printMap()
- 다리를 건너다가 실패 했다면 재시작 or 종료(R or Q)(에러 발생시키기) - 다시 입력받음 - [ x ] InputView#readGameCommand()
- 최종 게임 결과 출력 - [ x ] OutputView#printResult()
- 게임 성공 여부: 출력 - [ x ] OutputView#printSuccessFailure()
- 총 시도한 횟수: 출력 - [ x ] OutputView#printTryNumber()

### domain
- 다리를 생성할 수 있다 - [ x ] BridgeMaker#makeBridge()
  - 생성 시 무작위로  0, 1 중 무작위로 건널 수 있는지 없는지 생성 [ x ] BridgeRandomNumberGenerator#generate()
- 플레이어 이동(현재 이동상태 리스트에 U, D 삽입) - [ x ] BridgeGame#move()
- 총 시도한 횟수 반환한다. [ x ] BridgeGame#getTryNumber()

### controlloer
- 게임을 시작한다 - [ x ] BridgeGame#start()
- 게임 재시작한다 - [ x ] BridgeGame#retry()
- 게임을 종료한다 - [ x ] BridgeGame#end()