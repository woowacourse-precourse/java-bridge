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
  - ValidateType : 플레이어 입력에 대한 유효성 검사를 구분짓기 위해 사용하는 Enum Class이다. SIZE, MOVE, COMMAND를 값으로 가질 수 있다.


### 2. 플레이어에게 출력 하기
### 목표
1) 현재까지 다리를 건넌 상황을 출력한다.
2) 게임이 종료되면 해당 게임의 결과를 출력한다.


### 구현 내용
< Class - OutputView >
- Attribute 
  - List<String> bridge : 게임에서 사용되는 다리이다. <br>
  - StringBuilder top : 현재 게임에서 다리의 위쪽을 나타낸다. 'O' 이면 갈 수 있는 길이고, 'X' 이면 갈 수 없는 길이다. <br>
  - StringBuilder bottom : 현재 게임에서 다리의 아래쪽을 나타낸다. 'O' 이면 갈 수 있는 길이고, 'X' 이면 갈 수 없는 길이다. <br>


- Method
  - OutputView(List<String> bridge) : 생성자이다. bridge를 매개 인자로 받아서 멤버 변수에 초기화하고, 멤버 변수 top, bottom에 StringBuilder를 할당한다. <br>
  - boolean printMap(int currentLocation, String move) : 현재까지 이동한 다리의 상태를 위, 아래로 나누어 출력한다. 이 때, 주어진 양식에 맞게 출력하기 위한 메서드를 추가로 호출한다. 또, 다리를 성공적으로 이동했는 지에 대한 여부를 boolean 형으로 반환한다. <br>
  - void printResult(boolean flag, int count) : 게임의 최종적인 결과(다리 건너기에 성공했는 지와 총 시도한 횟수, 이동한 경로)를 출력한다. <br>
  - boolean compareTop(int location) : 플레이어가 윗쪽 길을 선택했을 때, 그 길이 올바른 길인 지를 비교하고 그 결과를 top에 저장하는 메서드이다. <br>
  - boolean compareBottom(int location) : 플레이어가 아랫쪽 길을 선택했을 때, 그 길이 올바른 길인 지를 비교하고 그 결과를 bottom에 저장하는 메서드이다. <br>
  - void clear() : 게임이 재시작되는 경우에, 이전 게임에서 사용하던 top과 bottom의 이동 내역이 남아있으므로 이를 초기화하는 메서드이다. <br>
  - String formattingBridge(StringBuilder bridgeSide) : top과 bottom을 양식에 맞춰 출력하기 위해 매개 인자로 받은 StringBuilder에 중괄호와 공백, 바(|)를 넣고 String으로 반환하는 메서드이다. <br> 


### 3. (다리 생성을 위한) 난수 생성
### 목표
1) 다리 생성을 위한 0 혹은 1의 난수를 생성한다.


### 구현 내용
< Interface - BridgeNumberGenerator >
- Method
  - int generate() : 구현되지 않은 메서드이며, 임의의 난수 값 하나를 생성할 것으로 기대하고 정의한 메서드이다. 


< Concrete Class - BridgeRandomNumberGenerator >
- Attribute
  - final int RANDOM_LOWER_INCLUSIVE : 상수 값으로 0을 갖는다. <br>
  - final int RANDOM_UPPER_INCLUSIVE : 상수 값으로 1을 갖는다. <br>


- Method
  - int generate() : 멤버 변수 둘 사이의 값 중에 임의의 값 하나를 생성하여 반환한다. 


### 4. 다리 생성
### 목표
1) 플레이어가 입력한 크기에 따라, 게임에서 사용할 다리를 생성한다.


### 구현 내용
< Class - BridgeMaker >
- Attribute
  - BridgeNumberGenerator bridgeNumberGenerator : BridgeNumberGenerator를 상속받아 구현한 클래스의 인스턴스를 갖는다. 


- Method
  - BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) : BridgeNumberGenerator를 상속받아 구현한 클래스의 인스턴스를 멤버 변수로 저장한다. <br>
  - List<String> makeBridge(int size) : 매개 인자로 받은 size만큼 난수 생성을 반복하여 String형 List를 생성하여 반환한다. <br>
  - String allocateBlock : 멤버 변수 bridgeNumberGenerator의 generate 메서드를 통해 난수를 하나 생성하고, 그 값이 0이면 'U', 1이면 'D'를 생성하여 반환한다. <br>

  
### 5. 게임 진행
### 목표
1) 게임 진행을 위한 Bridge를 생성한다.
2) 플레이어 입력에 따라, 다리 내의 이동을 진행한다.
3) 이동할 때마다, 현재 다리의 이동 상황을 출력한다.
4) 게임을 재시작해야 하는 경우에 플레이어에게 재시작 여부를 입력 받는다.
5) 게임이 종료되면 최종적인 결과를 플레이어에게 출력한다.

### 구현 내용
< Class - BridgeGame >
- Attribute
  - InputView inputView : 플레이어에게 입력을 받기 위한 인스턴스를 멤버 변수로 갖는다. <br>
  - OutputView outputView : 플레이어에게 출력을 하기 위한 인스턴스를 멤버 변수로 갖는다. <br>
  - BridgeMaker bridgeMaker : 게임을 진행하기 위한 Bridge를 생성한다. <br>
  - List<String> bridge : 게임을 진행하기 위한 Bridge를 멤버 변수로 갖는다. <br>


- Method
  - BridgeGame() : 생성자이다. bridgeMaker를 할당하고, 다리 생성 이후에 outputView를 할당한다. <br>
  - void initBridge() : 플레이어에게 다리 길이를 입력 받아서 bridgeMaker를 통해 다리를 생성한다. <br>
  - boolean move(int currentLocation) : 현재 다리의 몇 번째 칸에 있는 지를 매개 인자로 받고, 플레이어에게 이동 방향을 입력 받아 현재 이동 상황을 출력한다. <br>
  - boolean retry() : 게임을 다시 시도할 지에 대해 입력 받아서, 그 결과를 true, false로 반환한다. <br>
  - void printResult() : 게임이 종료되면 outputView의 printResult를 호출한다. <br>
  - int getBridgeSize() : 다리의 크기만큼 게임을 진행하기 위해, 다리의 크기를 반환한다. <br>
  - void clear() : 게임이 재시작되면 outputView의 멤버 변수를 초기화하기 위해 outputView의 clear 메서드를 호출한다. <br>


## [ 테스트 코드 ]
- ApplicationTest : 프로그램의 전체적인 실행이 정상적인 지를 테스트한다.
- BridgeMakerTest : 다리 생성이 정상적인 지를 테스트한다.
- InputViewTest : 플레이어가 잘못된 입력을 하는 경우에 예외가 제대로 발생하는 지에 대해 테스트한다.
- OutputViewTest : 플레이어 입력에 따라 다리를 이동하는 것과 게임의 최종 결과를 정상적으로 출력하는 지에 대해 테스트한다.
- TestNumberGenerator : BridgeNumberGenerator를 상속받아 구현한 클래스이다. 미리 정해진 값을 난수로 반환하는 기능이 존재한다.