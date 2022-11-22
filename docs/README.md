
## 🚀 기능 목록

- [x] 전체 애플리케이션 실행 - #BridgeGameManager#run()

### view
- [x] 다리 건너기 게임 시작 출력 - OutputView#printStart()
- [x] 다리의 길이를 숫자로 입력받는다(3~20)(에러 발생시키기) - 다시 입력받음 - InputView#readBridgeSize()
- [x] 플레이어는 이동할 칸을 선택한다(U or D)(에러 발생시키기) - 다시 입력받음 - InputView#readMoving()
- [x] 플레이어 이동 현황 o/x (다리 출력) - OutputView#printMap()
- [x] 다리를 건너다가 실패 했다면 재시작 or 종료(R or Q)(에러 발생시키기) - 다시 입력받음 - InputView#readGameCommand()
- [x] 최종 게임 결과 출력 - OutputView#printResult()
- [x] 게임 성공 여부: 출력 - OutputView#printSuccessFailure()
- [x] 총 시도한 횟수: 출력 - OutputView#printTryNumber()

### domain
- [x] 다리를 생성할 수 있다 - BridgeMaker#makeBridge()
  - [x] 생성 시 무작위로  0, 1 중 무작위로 건널 수 있는지 없는지 생성 BridgeRandomNumberGenerator#generate()
- [x] 플레이어 이동(현재 이동상태 리스트에 U, D 삽입) - BridgeGame#move()
- [x] 총 시도한 횟수 반환한다 - BridgeGame#getTryNumber()

### controlloer
- [x] 게임을 시작한다 - BridgeGame#start()
- [x] 게임 재시작한다 - BridgeGame#retry()
- [x] 게임을 종료한다 - BridgeGame#end()외


### 예외사항
다리 사이즈 입력받기
- 다리 사이즈에 숫자입력이 아닐 경우
- 숫자 범위가 3~20이 아닐 경우

이동할 칸 입력받기
- "U", "D"가 아닐 경우

게임 재시작 입력받기
- "Q', "R"가 아닐 경우