
## 기능 구현 목록

### BridgeRandomNumberGenerator : 다리를 만들기 위한 이진수를 반환한다.
- [x] 지정된 범위 내의 숫자를 반환한다. #generate

### BridgeMaker : 다리를 일급 컬렉션으로 만들수 있게 도와준다.
- [x] 지정된 숫자만큼 다리를 만든다. #makeBridge
- [x] 다리의 일부를 만든다. #makePartOfBridge

### Bridge : 초기 지정하는 다리 사이즈로 생성되고, 사용자 선택을 채점하기 위한 정답으로 여겨지는 클래스
- [x] 다리 길이를 반환한다. #getBridgeLength
- [x] 다리의 특정 인덱스번째 정답을 반환한다. #getBridgeByIndex

### Player: 사용자의 이동 선택
- [x] 사용자의 답을 추가한다. #addChoice
- [x] 사용자의 특정 인덱스번째 답을 반환한다. #getChoiceIndex
- [x] 사용자의 선택 수를 반환한다. #getNumberOfChoice
- [x] 사용자의 마지막 선택을 반환한다. #getLastChoice

### ClearStatus: 최종 결과 출력시 성공, 실패를 반환하기 위한 논리 기반의 열거형 클래스
- [x] 성공 참거짓 유무에 따른 열거형 자료의 집합을 반환한다. #getMessageByClear
- [x] 성공 참거짓 유무의 문자열을 반환한다. #getMessage

### InputView : 입력 관련 출력
- [x] 다리의 길이를 입력받는다. #readBridgeSize()
- [x] 사용자가 이동할 칸을 입력받는다. #readMoveCommand()
- [x] 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. #readGameCommand()

### OutputView : 결과 관련 출력
- [x] 다리 건너기 게임을 시작한다는 메시지를 출력한다. #printGameStart()
- [ ] 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다. #printMap()
- [x] 에러 메시지를 출력한다. #printErrorMessage()
- [ ] 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. #printResult()
- [x] 공백 라인을 출력한다. #printDivisionLine()

### BridgeGameController : 다리 건너기 게임의 흐름을 관리
- [ ] 게임을 시작한다. #gameStart()
- [ ] 다리 길이를 반환한다. #getMakeBridgeSize()
- [ ] 설정 값을 검증한다. #validateInputSetting()
- [ ] 게임에 대한 설정을 한다. #gameSetting()
- [ ] 게임을 진행한다. #gamePlay()
- [ ] 이동와 그 결과를 출력한다. #moveAndResult()
- [ ] 이동 입력을 반환한다. #getMoveCommand()
- [ ] 허가되지 않은 이동 입력인지 체크한다. #isDisallowInputMoveCommand()
- [ ] 게임 입력을 반환한다. #getReadGameCommand()
- [ ] 허가되지 않은 게임 입력인지 체크한다. #isDisallowInputGameCommand()
- [ ] 최종 결과를 반환한다. #getFinalResult()

### BridgeGame : 다리 건너기 게임을 관리
- [x] 총 시도횟수를 초기화 한다. #initTryCount()
- [x] 다리를 초기화 한다. #initBridge()
- [x] 사용자 위치를 초기화 한다. #initPlayer()
- [ ] 사용자가 칸을 이동한다. #move()
- [x] 사용자의 칸 이동 현황을 초기화 한다. #initBridgeMap()
- [x] 사용자 위치 현황을 만든다. #makeBridgeMap()
- [x] 사용자 위치현황 중 윗줄을 만든다. #makeUpperBridgeOfPart()
- [x] 사용자 위치현황 중 아랫줄을 만든다. #makeLowerBridgeOfPart()
- [x] 위치에 따른 사용자의 칸 정보를 가져온다. #getChoiceByPosition()
- [x] 다리의 해당 위치 정보를 가져온다 #getBridgeByPosition()
- [ ] 사용자의 위치현황을 모두 가져온다. #getBridgeMap()
- [x] 사용자가 게임을 다시 시도한다. #retry()
- [x] 다리의 길이를 가져온다. #getBridgeLength()
- [x] 사용자의 위치 정보의 갯수를 가져온다. #getNumberOfChoice()
- [x] 사용자가 다시 움직일수 있는지 판별한다. #moveAgain()
- [x] 사용자의 최근 위치가 동일 위치의 다리와 같은지 확인한다. #isSameRecentChoiceAndBridge()
- [x] 사용자의 현재 이동 정보가 다리 길이와 같은지 확인한다. #isAcrossLast()
- [x] 사용자가 모두 건넜는지 확인한다. #isClearGame()
- [x] 사용자가 모두 건넌것을 체크한다. #crossAllBridge()
- [x] 다리 길이를 검증한다. #validateBridgeSize()
- [x] 변환이 되는지 검증한다. #validateConvert()
- [x] 다리 길이의 범위를 검증한다. #validateBridgeSizeRange()
- [x] 이동 가능한 입력이 아니면 예외를 발생시킨다. #validateInputMoveCommand()
- [x] 이동 가능한 입력인지 확인한다. #isMoveCommand()
- [x] 종료, 재시작 입력이 아니면 예외를 발생시킨다. #validateInputGameCommand()
- [x] 종료 입력인지 확인한다. #isEndCommand()
- [x] 재시작 입력인지 확인한다. #isRestartCommand()
- [x] 재시작 상황인지 확인한다. #isRestartGame()
- [x] 총 시도 횟수를 늘린다. #addTryCount()
- [x] 총 시도 횟수를 반환한다. #getTryCount()
- [x] 사용자가 다리를 모두 건넜는지 확인한다. #isCrossAllBridge()

### InputMessage : 입력 요청 메시지

### OutputMessage : 결과 메시지

### ValidateMessage : 검증 메시지

### BridgeUtil : 다리 관련 상수

### GameCommand : 게임 조작 관련 상수

### View : 출력 관련 상수
