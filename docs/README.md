
### 기능 구현 순서

- 컴퓨터의 다리 개수를 입력받는다.
- 다리 개수를 입력 받으면, 컴퓨터의 BridgeRandomNumberGenerator 이용해 Size에 맞게 0과 1의 수를 생성한다.
- 수가 1이면 "U"를 넣어주고, 수가 0이면 "D"을 List<String> ComputerBridge에 넣어준다.
- 그 다음, 사용자의 입력 "U", "D"에 따라서 컴퓨터의 인덱스에 해당하는 요소값과 사용자가 입력한 값이 같은지 비교해준다.
- 비교해서 같다면, "O"를 넣어주고 그렇지 않다면 "X"를 넣어준다.
- 게임을 완수했으면, 해당하는 다리 상태와 함께 종료 메세지를 출력해준다. 
- 게임에 졌으면, 다시 시작할지 안할지에 대한 메세지문 출력과 함께 사용자에게 입력 "R"(재시작), "Q"(종료)를 받는다.
- "R"을 입력 받았으면, 맞췄던 다리 상태에서 시작하고 "Q"를 입력받으면, 여태까지 맞춘 다리 상태를 출력하고 게임을 종료한다.

---


### 패키지 별 기능 구현 목록

#### controller 

- BridgeGameController : view를 호출하여 입력값을 받고, service를 호출하여 게임과 관련된 모든 로직 수행

#### domain

- Bridge : Bridge에 관련된 생성자, getter, setter 구현
- Game : Game에서 승패 유무와 게임 진행 유무에 따른 boolean 변수를 생성, Controller에서 이를 참조하여 사용할수 있도록 설계 


#### exception 
- BridgeException : 사용자가 입력한 값에 대한 예외처리 메서드 구현, View에서 입력 받을 때, 예외처리 기능 수행하도록 설계

#### service

- BridgeGame : 사용자에 대한 입력값과, 컴퓨터의 랜덤하게 생성한 값을 비교하는 로직 출력을 위한 연산과정 로직 구현

#### util

- BridgeMaker : 컴퓨터의 List<String>에 랜덤한 수(0, 1)를 생성하 0, 1에 맞는 "U", "D"을 넣어주는 메서드 구현
- BridgeNumberGenerator : 컴퓨터의 랜덤한 수를 생성할 수 있게 해주고 함수 중복을 방지하기 위한 인터페이스 
- BridgeRandomNumberGenerator : 컴퓨터의 랜덤한 수(0, 1)를 생성해주는 generate() 메서드 구현

#### view
- InputView : 입력에 대한 메세지를 화면에 나타낼 수 있도록 구현
- OutputView : 출력에 대한 메세지를 화면에 나타낼 수 있도록 구현

---

## domain

### Bridge

-  Bridge() : 생성자 역할
-  getBridge() : getter 역할
-  setBridge() : setter 역할

### Game 

- 게임의 승패, 게임이 종료된지에 대한 유무를 판단해주는 메서드가 담겨있다.
- Game() : 게임의 승패와 게임이 종료된지에 대한 유무를 false로 지정해주는 생성자
- isGameDone() : 게임의 종료유무를 반환해주는 메서드
- isWinDone() : 게임의 승패를 반환해주는 메서드
- setGameDone() : 게임의 종료유무를 set 해주는 메서드
- setWinDone() : 게임의 승패유무를 set 해주는 메서드
- GameDone() : 게임의 종료유무를 true로 set 해주는 메서드
- WinDone() : 게임의 승패유무를 true로 set 해주는 메서드

## controller



### BridgeGameController

- run() : service의 게임과 관련한 모든 logic를 수행해주는 메서드

## exception

### BridgeException

- checkBridgeLength() : 다리의 길이가 범위 내에 있는지 check 해주는 메서드
- checkBridgeLengthExceptions() : 입력받은 다리 길이에 대한 전체적인 예외처리 메서드
- checkBridgeInputGameOptionExceptions() : 게임 옵션에 대한 전체적인 예외처리 메서드
- checkBridgeLengthAboutOnlyNumber() : 다리의 길이가 오직 숫자로만 구성되어 있는지 check 해주는 메서드
- checkBridgeMoveInputAlphabet() : 다리 이동이 "U", "D" 으로만 구성되어 있는지 check 해주는 메서드
- checkBridgeMoveInputAlphabetExceptions() : 다리 이동 입력에 대한 전체적인 예외처리 메서드
- checkBridgeGameOptionInputAlphabet() : 게임에 실패하였을 때, 다시 시작 "R", 종료 "Q" 두 가지 요소로만 구성되어 있는지 check 해주는 메서드
- checkBridgeInputAlphabetOnlyEnglish() : 다리 이동 옵션과, 게임 옵션이 오직 영어로만 구성되어 있는지 check 해주는 메서드
## service

### BridgeGame

-  move() :  
-  retry() : 

## util

### BridgeMaker

- makeBridge() : 다리 개수를 매개변수로 받아, 랜덤 넘버가 0,1 인지 확인하여 0이면 DOWN, 1이면 UP를 add 해주는 메서드

### BridgeNumberGenerator
- generate() : generate() 함수를 값으로 취급하고, 함수를 재사용하기 위한 인터페이스 
### BridgeRandomNumberGenerator
- generate() : 컴퓨터가 0과 1사이의 수를 랜덤하게 뽑아주는 함수 


## view

### InputView

- readBridgeSize() : 다리의 길이를 입력받는 메서드
- readMoving() : 이동할 칸을 입력받는 메서드(up, down)
- readGameCommand() : 게임을 재시작할지, 종료할지 입력받는 메서드
### OutputView
- printMap() : 현재 다리 상태를 출력해주는 메서드 
- printAskReadMovingMessage() : "이동할 칸을 선택해주세요. (위 : U, 아래 : D)" 메세지를 출력해주는 메서드
- printStartBridgeGameMessage() : "다리 건너기 게임을 시작합니다. " 메세지를 출력하는 메서드
- printAskReadBridgeLengthMessage() : "다리의 길이를 입력해 주세요." 메세지를 출력해주는 메서드 
- printAskReadGameMessage() : "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" 메세지를 출력해주는 메서드
- printResult() : 게임을 종료하거나 게임을 완수하지 못했을때 결과를 출력해주는 메서드
