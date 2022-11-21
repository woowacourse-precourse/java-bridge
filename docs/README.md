# Joo Seong Jin (NotableDeveloper)
# Woowacourse - Precourse Week 4 (Web Backend)

## [ 목표 기능 사항 ]
### 1. 플레이어로부터 입력 받기
### 목표
1) 플레이어로부터 생성해야 하는 다리의 크기를 입력 받는다.
2) 플레이어로부터 움직이려는 방향을 입력 받는다.
3) 게임이 종료되면 사용자로부터 게임의 재시작 여부를 입력 받는다.


### 구현 내용
< Class - InputView >
- Attribute : No attribute <br>

- Method
  - int readBridgeSize() : <br>
  - String readMoving() : <br>
  - String readGameCommand() : <br>
  - void validate() : <br>
  - void checkSize() : <br>
  - void checkMove() : <br>
  - void checkCommand() : <br>

- Enum
  - ValidateType :


### 2. 플레이어에게 출력 하기
### 목표
1) 현재까지 다리를 건넌 상황을 출력한다.
2) 게임이 종료되면 해당 게임의 결과를 출력한다.


### 구현 내용
< Class - OutputView >
- Attribute 
  - List<String> bridge : <br>
  - StringBuilder top : <br>
  - StringBuilder bottom : <br>

- Method
  - OutputView() : <br>
  - boolean printMap() : <br>
  - void printResult() : <br>
  - boolean compareTop() : <br>
  - boolean compareBottom() : <br>
  - void clear() : <br>
  - String formattingBridge() : 


### 3. 이동, 재도전 처리
### 목표
1) 플레이어에 입력에 따라, 다리 내에서의 이동을 진행한다.
2) 플레이어의 입력에 따라, 게임을 재시작할 지 혹은 종료할 지를 결정한다.


### 구현 내용
< Class - BridgeGame >
- Attribute
  - InputView inputView : <br>
  - OutputView outputView : <br>
  - BridgeMaker bridgeMaker : <br>
  - List<String> bridge : <br>

- Method
  - BridgeGame() : <br>
  - initBridge() : <br>
  - boolean move() : <br>
  - boolean retry() : <br>
  - void printResult() : <br>
  - int getBridgeSize() : <br>
  - void clear() : <br>


### 4. 다리 생성
### 목표
1) 플레이어가 입력한 크기에 따라, 게임에서 사용할 다리를 생성한다.


### 구현 내용
< Class - BridgeMaker >
- Attribute
  - BridgeNumberGenerator bridgeNumberGenerator : <br>

- Method
  - BridgeMaker() :
  - List<String> makeBridge() : <br>
  - String allocateBlock : <br>


### 5. (다리 생성을 위한) 난수 생성
### 목표
1) 다리 생성을 위한 0 혹은 1의 난수를 생성한다.


### 구현 내용
< Interface - BridgeNumberGenerator >
- Method
  - int generate() : <br>

< Concrete Class - BridgeRandomNumberGenerator >
- Attribute 
  - final int RANDOM_LOWER_INCLUSIVE : <br> 
  - final int RANDOM_UPPER_INCLUSIVE : <br>

- Method
  - int generate() : <br>

## [ 테스트 코드 ]