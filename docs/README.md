# 다리 건너기

#### 다리 건너기 게임이란

처음 입력한 값 만큼의 다리가 생성된다.

다리는 위, 아래 두가지의 길이 있는데 그중 하나의 길로만 갈 수 있다.

플레이어는 다리를 끝까지 건너면 게임이 종료된다.

만약 실패하면 게임을 재시작하거나 종료할 수 있다.

재시작시 처음에 만든 다리로 재시작된다.

종료시 최종 게임 결과, 게임 성공 여부, 총 시도한 횟수를 출력하고 종료되는 게임이다.

# 

# MVC 별 기능 목록

## Model

### Domain

#### BridgeGame

다리가 생성과 함께 플레이어가 이동할 칸을 선택한다.

- [x] 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.

- [x] 다리를 끝까지 건너면 게임이 종료된다.

다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다. (재시도: R, 종료: Q)

- [x] 재시작시 처음에 만든 다리로 재사용한다.

#### BridgeMaker

- [x] 다리는 사이즈 값 만큼 랜덤으로 생성된다. 0, 1로 이루어진 다리(리스트)
- [x] U, D 로 이루어진 다리 반환

#### BridgeRandomNumber

- [x] 다리를 랜덤으로 만들어주는 객체

### VO (Value Object)

#### BridgeMap

- [x] isMove : plyer가 이동하면 이동 가능한지 확인한다.
- [x] getSize : 다리의 길이의 값을 출력한다.

#### BridgeSize

- [x] validSize
  - [X] 3~20
  - [X] 예외시 예외 메시지 출력

#### BridgeStatus

- [X] 0, 1 로 이루어진 다리를 U, D 으로 변환한다.

#### GameCommand

- [X] R, Q 만 입력가능
- [X] 예외시 예외 메시지 출력
- [X] toString : return value
- [X] equals : 스트링값 입력시 비교

#### Moving

- [X] U, D 만 입력가능
- [X] 예외시 예외 메시지 출력
- [X] toString : return value
- [X] equals : 스트링값 입력시 비교

#### playerMap

- [X] move : 이동되는 경로를 O, X로 그린다.



## View

#### InputHandler

 - [x] stringToInt
	- [x] "[ERROR] 다리의 개수의 범위는 3부터 20까지 입니다.


#### InputView

 - [x] readBridgeSize : "다리의 길이를 입력해주세요."
 - [x] readMoving : "이동할 칸을 선택해주세요. (위: U, 아래: D)"
 - [x] readGameCommand : "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"

#### OutputView

 - [x] printStartBridgeGame : "다리 건너기 게임을 시작합니다."

 - [x] printMap : 현재까지 건넌 다리를 모두 출력

	```
	[ O |   |   ]
	[   | O | O ]
	```

 - [x] printResult

	```
	최종 게임 결과
	[ O | X ]
	[   |   ]
	
	게임 성공 여부: 실패
	총 시도한 횟수: 1
	```

	

### Controller

#### BridgeGameController

- [x] inputBridgeSize
  - [x] 잘못 입력시 오류 메시지 출력 후 재입력
- [x] makeBridge
- [x] playBridgeGame  : 게임 시작
  - [x] inputMoving
    - [x] 잘못 입력시 오류 메시지 출력 후 재입력
  - [x] movePlayer
  - [x] inputGameCommand
  	- [x] 잘못 입력시 오류 메시지 출력 후 재입력

# 

# 요구 사항

- [x]  함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다
- [x]  메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- [x] 아래 있는 클래스의 요구사항을 참고하여 구현한다.
	- [x]  `InputView`
	- [x]  `OutputView`
	- [x]  `BridgeGame`
	- [x]  `BridgeMaker`
	- [x]  `BridgeRandomNumberGenerator` 
- [x] InputView`클래스에서만`camp.nextstep.edu.missionutils.Console`의`readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
- [x] BridgeGame`클래스에서`InputView`,`OutputView` 를 사용하지 않는다.
- [x] 실행 결과 예시 줄 바꿈, 빈 줄
- [x] 객체는 객체스럽게 사용한다
- [x] 정적 팩토리 메서드
- [x] 테스트 코드 리팩터링
- [x] 스트림을 고려
- [x] 4주차에 3주차 피드백 적용
- [x] 2주차 피드백 적용
