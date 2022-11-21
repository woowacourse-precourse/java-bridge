
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
- [ ] 사용자의 답을 추가한다. #addChoice
- [ ] 사용자의 특정 인덱스번째 답을 반환한다. #getChoiceIndex
- [ ] 사용자의 선택 수를 반환한다. #getChoiceIndex
- [ ] 사용자의 마지막 선택을 반환한다. #getLastChoice

### ClearStatus: 최종 결과 출력시 성공, 실패를 반환하기 위한 논리 기반의 열거형 클래스
- [ ] 성공 참거짓 유무에 따른 열거형 자료의 집합을 반환한다. #getMessageByClear
- [ ] 성공 참거짓 유무의 문자열을 반환한다. #getMessage

### InputView : 입력 관련 출력
- [ ] 다리의 길이를 입력받는다. #readBridgeSize
- [ ] 사용자가 이동할 칸을 입력받는다. #readMoveCommand
- [ ] 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. #readGameCommand

### OutputView : 결과 관련 출력
- [ ] 다리 건너기 게임을 시작한다는 메시지를 출력한다. #printGameStart
- [ ] 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다. #printMap
- [ ] 에러 메시지를 출력한다. #printErrorMessage
- [ ] 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. #printResult

### BridgeGameController : 다리 건너기 게임의 흐름을 관리
- [ ]  #gameStart
- [ ]  #getMakeBridgeSize
- [ ]  #validateInputSetting
- [ ]  #gameSetting
- [ ]  #gamePlay
- [ ]  #moveAndResult
- [ ]  #getMoveCommand
- [ ]  #isDisallowInputMoveCommand
- [ ]  #getReadGameCommand
- [ ]  #isDisallowInputGameCommand
- [ ]  #getFinalResult

### BridgeGame : 다리 건너기 게임을 관리
- [ ] 총 시도횟수를 초기화 한다. #initTryCount
- [ ] 다리를 초기화 한다. #initBridge
- [ ] 사용자 위치를 초기화 한다. #initPlayer
- [ ] 사용자가 칸을 이동한다. #move
- [ ] 사용자의 칸 이동 현황을 초기화 한다. #initBridgeMap
- [ ] 사용자 위치 현황을 만든다. #makeBridgeMap
- [ ] 사용자 위치현황 중 윗줄을 만든다. #makeUpperBridgeOfPart
- [ ] 사용자 위치현황 중 아랫줄을 만든다. #makeLowerBridgeOfPart
- [ ] 위치에 따른 사용자의 칸 정보를 가져온다. #getChoiceByPosition
- [ ] 사용자의 위치를 가져온다. #getBridgeByPosition
- [ ] 사용자의 위치현황을 모두 가져온다. #getBridgeMap
- [ ] 사용자가 게임을 다시 시도한다. #retry
- [ ] 다리의 길이를 가져온다. #getBridgeLength
- [ ] 사용자의 위치 정보의 갯수를 가져온다. #getNumberOfChoice
- [ ] 사용자가 다시 움직일수 있는지 판별한다. #moveAgain
- [ ] 사용자의 최근 위치가 동일 위치의 다리와 같은지 확인한다. #isSameRecentChoiceAndBridge
- [ ] 사용자의 현재 이동 정보가 다리 길이와 같은지 확인한다. #isAcrossLast
- [ ] 사용자가 모두 건넜는지 확인한다. #isClearGame
- [ ] 사용자가 모두 건넌것을 체크한다. #crossAllBridge
- [ ] 다리 길이를 검증한다. #validateBridgeSize
- [ ] 변환이 되는지 검증한다. #validateConvert
- [ ] 다리 길이의 범위를 검증한다. #validateBridgeSizeRange
- [ ] 이동 가능한 입력이 아니면 예외를 발생시킨다. #validateInputMoveCommand
- [ ] 이동 가능한 입력인지 확인한다. #isMoveCommand
- [ ] 종료, 재시작 입력이 아니면 예외를 발생시킨다. #validateInputGameCommand
- [ ] 종료 입력인지 확인한다. #isEndCommand
- [ ] 재시작 입력인지 확인한다. #isRestartCommand
- [ ] 재시작 상황인지 확인한다. #isRestartGame
- [ ] 총 시도 횟수를 늘린다. #addTryCount
- [ ] 총 시도 횟수를 반환한다. #getTryCount
- [ ] 사용자가 다리를 모두 건넜는지 확인한다. #isCrossAllBridge

### ValidateMessage : 검증 메시지

### BridgeUtil : 다리 관련 상수

### GameCommand : 게임 조작 관련 상수

### View : 출력 관련 상수
