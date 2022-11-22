# 프로젝트 개요 
> 사용자에게 다리의 길이를 입력받고 랜덤으로 생기는 다리를 양자택일 형식으로 맞추는 게임

# 기능구현 목록
-View(입력,출력), 컨트롤러, 서비스, 모델, 예외 5가지로 구분하여 설계

## View 패키지
#### 입력 (InputView 클래스) 
:입력 기능들 집합
- 다리 길이 입력 및 올바른 입력 검증 기능 = readBridgeSize()
- 이동할 칸 선택 및 올바른 입력 검증 기능 = readMoving()
- 게임 다시 시도할지 여부 입력 및 올바른 입력 검증 기능 = readGameCommand()
####  출력 (OutputView 클래스) 
:출력 기능들 집합
- 시작 안내 메시지 출력 기능 = startGuide()
- 다리길이 입력하라는 메시지 출력 기능 = startGuide()
- 이동할 칸 고르라는 안내 출력 기능 = moveGuide()
- 최종 게임 결과 출력 기능 = printResult()
- 게임 성공 여부 출력 기능 = printResult()
- 총 시도횟수 출력 기능 = printResult()
- 다시 시작 안내 메시지 출력 기능 = restartGuide()
#### 출력할 맵을 반환(ReturnPrintMap 클래스) 
:다리 출력에 필요한 맵을 만들어 반환하는 기능들 집합
- 출력할 맵을 구성해서 최종적으로 반환하는 기능 = returnContentsMap()
- 게임진행하며 성공했던 라인에 대해 맵 안에 값을 입력하는 기능 = lineChoice()
- 마지막으로 선택한 칸에 대해 맵에 값을 입력하는 기능 = addLastMap()
- 마지막 선택한 칸에 대해 위에 줄에서 성공인지 실패인지 구분해서 입력해주는 기능 = chooseUpLine()
- 마지막 선택한 칸에 대해 아래 줄에서 성공인지 실패인지 구분해서 입력해주는 기능 = chooseDownLine()

## controller 패키지 
#### BridgeGameController 클래스 
:게임 전체적인 흐름을 조작하는 기능들 집합
- 게임의 전체적인 시작 포인트  = execute()
- 게임에서 선택이 반복되는 종합 기능 = loopGameUnit()
- 선택된 칸이 실패 했을 때 재시작을 묻는 기능  = isUnitFail()
- 재시작 될 때 기존 다리를 초기화 시키고 시도 횟수를 증가시키는 기능 = restart()
- 성공이나 포기로 인해 실패할 경우, 결과를 출력하고 반복을 멈추는 기능 = isLoopFinish()

## model 패키지 
:게임에 필요한 데이터들을 생성해주는 클래스(기능)들 집합
#### BridgeMaker 클래스
- 숫자 다리를 문자 다리로 만들어 초기 다리 데이터를 생성해주는 기능 = makeBridge()
- 숫자 다리를 생성해주는 기능 = numberBridge()
#### UserBridgeCorrector 클래스
- user의 다리를 생성해주는 기능 = addBridge()
#### BridgeComparator 클래스
- 유저의 다리와 컴퓨터 다리의 일치 여부를 생성해주는 기능 = isSame()
#### GameRestarter 클래스 
- 게임을 다시 시작하는지 여부를 생성해주는 기능 = isRestart()
#### GameJudge 클래스
- 게임이 끝나면서 최종 결과를 생성해주는 기능 = isOver()


## service 패키지  
#### BridgeGame 클래스
:게임에 필요한 기본 조작(기능)들 집합
- 유저가 움직이는 기능 = move()
- 게임을 다시 시작하는 기능 = retry()
- 초기 다리를 생성하는 기능 = make()
- 시작 안내 메시지 출력 기능  = startSetUp()
- 한 칸 성공여부를 판단해주는 기능 = isUnitSuccess()
- 게임 전체 성공여부를 알려주는 기능 = isGameSuccess()

## exception 패키지

#### DesignatedTypeException 클래스
:지정 유형을 검사해 예외를 발생하는 기능
- 모두 숫자가 인지 확인하는 기능 = allNumberCheck()  
- 단위별로 숫자인지 확인하는 기능 unitNumberCheck()
- U나 D가 입력되었는지 확인하는 기능 = UDCheck()
- R나 Q가 입력되었는지 확인하는 기능 = RQCheck()

#### SizeOverException 클래스
:길이에 대해서 예외를 발생하는 기능
- 다리길이가 3에서 20 사이의 정수가 아닐 때 예외를 발생시키는 기능 = bridgeSizeCheck()
- 한 단어 이상 입력 되었을 때 예외를 발생시키는 기능 = oneWordCheck()
