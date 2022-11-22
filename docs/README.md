# Joo Seong Jin (NotableDeveloper)
# Woowacourse - Precourse Week 4 (Web Backend)

## [ 목표 기능 사항 ]
### 1. 플레이어로부터 입력 받기
### 목표
1) 플레이어로부터 생성해야 하는 다리의 크기를 입력 받는다.
2) 플레이어로부터 움직이려는 방향을 입력 받는다.
3) 게임이 종료되면 사용자로부터 게임의 재시작 여부를 입력 받는다.

### 발생할 수 있는 예외 사항
1) 다리의 크기를 입력받을 때, 숫자가 아닌 경우
2) 다리의 크기를 입력받을 때, 3부터 20 사이의 숫자가 아닌 경우
3) 이동 방향 혹은 재시작 여부를 입력받을 때, 단일 문자가 아닌 경우
4) 이동 방향을 입력받을 때, 'U', 'D' 이외의 값이 입력된 경우
5) 재시작 여부를 입력받을 때, 'R', 'Q' 이외의 값이 입력된 경우


### 구현 내용
< Class - InputView >
- Attribute : No attribute 


- Method
  - int readBridgeSize() : 다리의 길이를 입력 받고, 유효성 검증 이후에 int형으로 반환한다. <br>
  - String readMoving() : 이동할 방향을 입력 받고, 유효성 검증 이후에 String형으로 반환한다. <br>
  - String readGameCommand() : 게임 재시작 여부를 입력 받고, 유효성 검증 이후에 String으로 반환한다. <br>
  - void validate(String s, ValidateType type) : 입력 문자열에 대해 매개 인자 type에 따른 유효성 검사를 한다. <br>
  - void checkSize(String s) : validate 메서드의 매개 인자 type이 ValidateType.SIZE 이면 호출된다. 다리의 크기에 대한 입력이 유효한 지를 검사한다. (예외 사항 1번, 2번을 검사한다.) <br>
  - void checkMove() : validate 메서드의 매개 인자 type이 ValidateType.MOVE 이면 호출된다. 이동 방향에 대한 입력이 유효한 지를 검사한다. (예외 사항 3번, 4번을 검사한다.) <br> 
  - void checkCommand() : validate 메서드의 매개 인자 type이 ValidateType.COMMAND 이면 호출된다. 게임 재시작 여부에 대한 입력이 유효한 지를 검사한다. (예외 사항 3번, 5번을 검사한다.) <br>


- Enum
  - ValidateType : 사용자 입력에 대한 유효성 검사를 구분지어 하기 위해 사용하는 Enum Class이다. SIZE, MOVE, COMMAND를 값으로 가질 수 있다.


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