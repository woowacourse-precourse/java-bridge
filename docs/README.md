# 다리 건너기

#### 다리 건너기 게임이란

처음 입력한 값 만큼의 다리가 생성된다.

다리는 위, 아래 두가지의 길이 있는데 그중 하나의 길로만 갈 수 있다.

플레이어는 다리를 끝까지 건너면 게임이 종료된다.

만약 실패하면 게임을 재시작하거나 종료할 수 있다.

- 재시작시 처음에 만든 다리로 재시작된다.

종료시 최종 게임 결과, 게임 성공 여부, 총 시도한 횟수를 출력하고 종료되는 게임이다.



## Model

### Domain

BridgeGame

BridgeMaker

BridgeRandomNumber

### VO

BridgeMap

BridgeSize

GameCommand

Moving

playerMap

## View

InputHandler

	- [x] stringToInt

InputView

 - [x] readBridgeSize
 - [ ] readMoving
 - [ ] readGameCommand

OutputView

	- [ ] printMap
	- [ ] printResult

### Controller

BridgeGameController

- [x] inputBridgeSize
- [x] makeBridge
- [ ] startGame
- [ ] inputMoving
- [ ] printMap
- [ ] inputGameCommand
	- [ ] printResult



## 기능 목록

- [x] InputView.readBridgeSize() : 건널 다리의 개수를 입력한다. 범위는 3개 ~ 20개
	- [x] 다른 값 입력시  `IllegalArgumentException` 발생 후 메시지 출력 후 그 부분부터 입력을 다시 받는다.
	- [x] "[ERROR] 다리의 개수는 숫자만 가능합니다.
	- [x] "[ERROR] 다리의 개수의 범위는 3부터 20까지 입니다.



- [x] BridgeMaker.makeBridge(size) 다리는 사이즈 값 만큼 랜덤으로 생성된다. 0, 1로 이루어진 다리(리스트)
	- [x] bridgeNumberGenerator.generate(); 사용
	- [x] 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.



- [x] InputView.readBridgeSize() : 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
	- [x] 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
		- [x] 플레이어는 U, D 만 입력할 수 있다.
			- [x] 다른 값 입력시  `IllegalArgumentException` 발생 후 메시지 출력 후 그 부분부터 입력을 다시 받는다.
			- [x] "[ERROR]이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D 만 가능합니다." : 다른 값, 소문자 입력



- [x] BridgeGame.move() 이동한다.
	- [ ] OutputView.printMap()
		- [ ] 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
			- [ ] 이동할 수 있는 칸을 선택한 경우 O 표시
			- [ ] 이동할 수 없는 칸을 선택한 경우 X 표시
			- [ ] 선택하지 않은 칸은 공백 한 칸으로 표시
			- [ ] 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
			- [ ] 다리 칸의 구분은 ` | `(앞뒤 공백 포함) 문자열로 구분
			- [ ] 현재까지 건넌 다리를 모두 출력



- [x] 다리를 끝까지 건너면 게임이 종료된다.
- [x] BridgeGame.retry() : 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다. (재시도: R, 종료: Q)
	- [x] 다른 값 입력시  `IllegalArgumentException` 발생 후 메시지 출력 후 그 부분부터 입력을 다시 받는다.
		- [x] "[ERROR] 재시도 여부 값은 대문자 R, 대문자 Q 만 가능합니다." : 다른 값, 소문자 입력
	- [x] 재시작시 처음에 만든 다리로 재사용한다.



- [x] 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.

	- [ ] OutputView.printResult()

	- [ ] ```
		최종 게임 결과
		[ O | X ]
		[   |   ]
		
		게임 성공 여부: 실패
		총 시도한 횟수: 1
		```

		



