# 구현 계획

### 구현해야 하는 기능

1. 생성할 다리 길이를 입력 받는 기능
2. 3 이상 20이하의 숫자가 아닌 경우 예외처리하는 기능
3. 라운드마다 U(위 칸), D(아래 칸) 중 하나의 문자를 입력받는 기능과 올바른 값이 아닌경우 예외처리하는 기능
4. 게임 재시작/종료 여부를 입력받는 기능. R(재시작)과 Q(종료) 중 하나가 아닌 경우 예외처리하는 기능

### 구현할 클래스

1. 문구들을 저장해 둘 클래스 ex) 다리 건너기 게임을 시작합니다. , 최종 게임 결과, 다리 출력 등
2. 게임을 구현 할 클래스
    1. 이동 할 수 있는 칸 일시, O 표시
    2. 이동 할 수 없는 칸 일시, X 표시
    3. 선택하지 않은 칸은 공백으로 표시
    4. 다리의 시작은 [다리의 끝은] 으로 표시
    5. 다리 칸의 구분은 | (앞 뒤 공백 포함) 문자열로 구분
    6. 현재까지 건넌 다리를 모두 출력
3. 예외 처리 클래스

### 클래스 구현 계획

1. InputView - 사용자 값을 입력받는 클래스
    1. 게임 시작 후 생성할 다리의 크기를 입력받는 함수 (readBridgeSize())
    2. 이동할 칸, U,D를 입력받을 함수 (readMoving())
    3. 게임 재시작 여부를 입력받을 함수 R,Q (readGameCommand())
2. OutputView - 출력을 담당하는 클래스
    1. 다리를 출력하는 함수 (printMap())
    2. 게임의 결과를 출력하는 함수 (printResult())
3. BridgeGame - 게임 진행을 담당하는 클래스
    1. readMoving에서 값을 받아 이동하는 기능 구현
    2. readGameCommand에서 값을 받아 게임을 재시작 또는 종료하는 기능 구현
4. Bridge Maker - 다리 생성 클래스
    1. readBrigeSize에서 입력 받은 값 만큼 다리를 생성하는 기능 구현
5. BridgeRandomNumberGenerator - 다리 칸을 생성하기 위한 랜덤 값
    1. 지나 갈 수 있는 다리를 랜덤으로 결정하는 함수 - 이미 구현되어 있는 클래스 사용

### 기능 구현

### 1. InputVIew
- readBridgeSize() - 메시지 출력 후, Console.readLine()을 이용하여 값을 읽어들인다.
- rangeErr() - 크기가 숫자 3< size < 20을 벗어날 경우 예외 처리한다
- readMoving() - console을 이용하여 값을 읽어들인다.
- throwException() 메소드를 이용하여 예외처리를 해준다.
- readGameCommand() - 재시작을 할 때 R 또는 Q를 읽어 들이는 메소드.
  R 또는 Q 이외의 값 입력 시 예외처리를 위해 commandError 메소드를 사용
- throwException() - 입력 값의 길이가 1을 초과할 때 예외처리,
  엔터(공백)이 입력 되었을 때 예외처리, 제외되어야하는 문자들을 모아둔
  리스트와 비교하여 입력 값이 해당 리스트 안에 포함될 시 예외처리
  하는 기능을 구현한 메소드
- commandError() - 입력 값의 길이가 1을 초과할 때 예외처리, 엔터(공백)이
  입력 되었을 때 예외처리, 제외되어야하는 문자들을 모아둔 리스트와
  비교하여 입력 값이 해당 리스트 안에 포함될 시 예외처리 하는 기능을
  구현한 메소드 - throwException과 출력하는 메시지가 다름
 
### 2. BridgeNumberGenerator
- 사전에 준비 된 메소드랜덤으로 0또는 1을 생성하는 기능


### 3. BridgeMaker
- judgeBridge() - enum을 사용하여 BridgeNumberGenerator를 통해 생성된 0과 1에 U,D 이름을 매핑해준다.
- makeBridge() - 새로운 리스트를 생성 후 BridgeNumberGenerator를 이용해
  0과 1을 랜덤으로 생성. 위에서 생성한 enum을 활용하여 0과 1에 해당하는
  U, D를 리스트에 넣은 뒤 반환한다. 사용자가 입력한 값과 비교할 때 사용

### 4. BridgeGame
-  move() - 사용자가 입력한 U, D에 맞춰 O X를 출력하는 함수.
   makeBridge에서 생성된 리스트와 입력된 값을 비교 후, 동일하다면
   upBridge 리스트에 O를 추가. 값이 다를 경우 X를 추가.
   upBridge의 초기 형태는 [], OutputView.printMap()에 의해
   "|"가 하나씩 추가되어 [ | ], [ | | ] ... 의 형태가 되기 때문에
   리스트의 홀 수 번째의 위치에 O or X를 추가하기 위해 2*i-1로 설정했다
- downMove() - upBridge와 기능은 동일. downBridge에 적용하기 위해 이용
- retry() - 게임을 다시 시작할 때 count 수를 증가시키고 반환한다

### 5. OutputView
- printMap() - InpuView.readMoving()을 이용해 U or D를 읽어들인 후,
  bridgeGame.move()를 이용해 O or X를 추가한다. 이를 출력한 후,
  "|"를 리스트에 추가한다. X가 추가되자마자 종료하기 위해 조건문을 활용해 break 해준다.
  최종 결과에 "|"가 한번 더 추가되는 것을 막기 위해 조건문을 활용해 break 해준다
- printResult() - 게임이 종료되기 직전 최종 결과를 print해주는 메소드.
  종료되기 직전 upBridge, downBridge를 불러와 출력해준다
- printSuccess() - 성공 여부를 출력하는 메소드.
  X가 포함되어 있다면 실패 메시지를, X가 포함되어 있지 않다면 성공 메시지를 출력 후, 총 시도 횟수를 출력한다
- printFail() - 게임 실패 시, 재시도 메시지를 출력 후, 재시도 여부에 대한
  입력 값을 받는다. 입력 값을 반환하여, 재시도 여부를 결정한다.
- restart() - 재시작 하기 위해, upBridge와 downBridge를 초기화 하는
  역할을 수행한다.

### 6. Message
- 게임에 필요한 메시지들을 모아둔 클래스

























