# 기능 목록

## Domain
### Bridge
1. 생성자 : Bridgemaker.makeBridge를 입력해 생성한다.
2. isPlayerRightBridge : 플레이어를 입력받아 플레이어의 길이까지 다리가 같으면 참을 반환
3. getBridge : 다리를 반환해준다. 

### Player
1. 생성자 : 전역변수 List<String>을 생성한다. 
2. addNewBridgeInput : 입력 문자열을 리스트에 저장한다. 
3. getBridge : 문자열 리스트를 반환한다.
4. isGameFinished : Bridge를 입력받아 리스트가 서로 같으면 참을 반환
5. clearBridge : 리스트를 초기화시켜준다. 

## enum
### BridgeType
UPPER(1, 'U'), LOWER(0 , 'D')로 저장하며 getCommand 메서드를 통해 U, D를 반환한다.
getValue 를 통해 1, 0을 반환한다.

### GameCommand
START('R'), QUIT('Q')로 저장되며 getCommand 메서드를 통해 R, Q를 반환한다. 

### BridgeViewComponent
RIGHT_BRIDGE(" O"), BLANK_BRIDGE("  "), WRONG_BRIDGE(" X"), BRIDGE_CONNECTOR(" |"), BRACKET_STARTED("["), BRACKET_FINISHER(" ]"), LINE_DIVIDER("\n")를 가진다.
getSymbol을 통해 문자열을 출력받아 BridgeViewConstructor에서 출력문을 생성할 때 사용한다. 

## util
### BridgeMaker
1. makeBridge : 입력된 size 만큼 'U' 또는 'D' 로 이루어진 문자열 리스트를 반환한다.
   1. constructBridgeAtPoint
   2. chooseSideOfBridge : bridgeNumberGenerator.generate 를 통해 0, 1중에 랜덤값을 반환한다.
   3. changeValueToCommand : 정수를 BridgeType의 command로 반환한다.

### BridgeViewConstructor
1. constructBridge : 플레이어 리스트와 bridge리스트를 입력받아 결과 문자열을 반환한다. 
   1. appendRightAnswer :
      1. isU : U면 참을 반환한다. 
      2. appendWithO : 입력된 다리에 위쪽 다리에 O를 추가한다. 
      3. appendWithBlank : 입력된 다리에 공백을 추가한다. 
   2. appendWrongAnswer : 
      1. isU : 
      2. appendWithBlank
      3. appendWithX : 입력된 다리쪽에 X를 추가한다. 
   3. makeBracket : 위, 아래쪽 다리의 결과에 괄호를 추가한다.
      1. deleteLastDivider : 마지막 |를 제거한다. 
   4. constructBeforeLast : 플레이어 리스트 길이 -1까지 다리들을 추가한다. 
   5. constructLast :
      1. getLastIndex : 리스트의 마지막 값을 반환한다. 
      2. isSameLast : 마지막이 같으면 참을 반환한다. 

## View
### InputView
1. readBridgeSize : 입력을 요청받아 입력이 맞는 입력일 때 까지 반복시킨다.
   1. readInput : 입력 문자열을 출력하여 입력을 요청하고 콘솔의 입력문자열을 반환한다.
   2. validate : BridgeLengthException 에서 validate 을 한 후 정수형으로 반환한다.
2. readMoving : 입력을 요청받아 입력이 맞는 입력일 때 까지 반복시킨다.
   1. readInput : 입력 문자열을 출력하여 입력을 요청하고 콘솔의 입력문자열을 반환한다.
   2. validate : BridgeChoiceException.validate을 실행해 문자열을 반환한다.
3. readGameCommand : 입력을 요청받아 입력이 맞는 입력일 때 까지 반복시킨다.
   1. readInput : 입력 문자열을 출력하여 입력을 요청하고 콘솔의 입력문자열을 반환한다.
   2. validate : GameCommandException.validate를 실행해 문자열을 반환한다.

### OutputView
1. printMap : 입력 문자열 두개를 줄바꿈 처리해서 출력시킨다.
2. printResult : trialCount와  isGameFinished 입력받아
   1. printGameStatus : '게임 성공 여부: '와 makeResultStatement를 출력한다.
      1. makeResultStatement : 입력변수가 참이면 '실패', 아니면 '성공'을 반환한다.
   2. printTrialCounts : '총 시도한 횟수: ' 에 trialCount를 연결해 출력한다.

## 예외처리
### Exceptions
1. executeException : IllegalArgumentException 을 발생시킨다.

### BridgeLengthException (extends Exception)
1. validate : 문자열에서 값을 확인한 후 정수형으로 파싱해 반환한다.
   1. isNotNumber : 입력 문자열이 숫자로 이루어지지 않았을 때 참을 반환한다.
   2. isOutOfRange : 3보다 작고 20보다 클 경우 참을 반환한다.
   3. notBridgeLengthException : '[ERROR] 다리의 길이는 3이상 20이하의 수로 입력해야 합니다'를 출력하고 executeException 을 실행한다.

### BridgeChoiceException (extends Exception)
1. validate
   1. isNotUp : 입력 문자열이 'U'와 다르면 참을 반환
   2. isNotDown : 입력 문자열이 'D'와 다르면 참을 반환
   3. notBridgeException : '[ERROR] 다리는 위의 다리를 고를 때 'U', 아래 다리를 고를 때 'D' 로 입력해야 합니다. '를 출력하고 executeException 을 실행한다.

### GameCommandException (extends Exception)
1. validate
   1. isNotRestart : 입력 문자열이 'R'와 다르면 참을 반환
   2. isNotQuit : 입력 문자열이 'Q'와 다르면 참을 반환
   3. notGivenOpinionException : '[ERROR] 개임을 재시작할 때 'R', 개임을 끝낼 때 'Q' 로 입력해야 합니다.'를 출력하고 executeException 을 실행한다.
   4. getStatusByCommand을 통해 문자열을 받아 해당하는 GameStatus를 반환한다.

## Controller
### BridgeGameController
1. 생성자 : InputView.readBridgeSize를 입력받아 Bridge를 생성하고 Player을 생성해준다. 전역변수 trialCount를 1로 초기화해준다. 
2. moveAStep : Input.readMoving을 입력받아 Player.addNewBridgeInput해준다. Bridge.makeResultBridge를 반환해 OutputView.printMap해준다. 
3. resetGame : player.clearBridge 해주고 trialCount++해준다.
4. concludeGame : OutputView.printResult에 trialCount와 Player.isGameFinished를 입력받아 출력해준다. 
5. isPaused : Bridge.isPlayerRightInput의 역을 반환한다.
6. isSuccess : Player.isGameFinished를 출력해준다. 
7. readFinalCommand : InputView.readGameCommand를 받아 반환한다. 

## Application
### BridgeGame
1. 생성자 : BridgeGameController를 생성해준다. 
2. move : bridgeGameController.isPaused일 때 까지 bridgeGameController.chooseAStep와 makeAResultMap를 해준다. 
3. retry : resetGame을 실행해준다. 
4. stop : concludeGame을 실행해준다. 
5. isRunning : 컨트롤러의 isFinished의 역을 반환한다.