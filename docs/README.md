# 기능 구현 목록
- Error Enum
  - 예외 발생시 예외 메세지를 Enum 으로 처리한다.
- GameMessage Enum
  - 게임 진행에 관련한 상수들을 Enum 으로 처리한다.
- BridgeGame
  - 다리 건너기 게임을 시작하는 메세지 출력 - printGameStartMessage()
  - 다리 길이를 입력하라는 메세지 출력 - printRequestBridgeSizeMessage()
  - 이동할 칸을 선택하라는 메세지 출력 - printRequestMovingMessage()
  - 게임을 다시 시도할지 여부를 입력하라는 메세지 출력 - printRequestRetryMessage()
  - bridgeSize 를 입력받아 BridgeMaker 를 활용하여 bridge 를 만들어 리턴하는 메서드 - makeBridge()
  - 유저의 이동하고자 하는 방향을 입력받아 결과 맵 String 을 리턴하는 메서드 -move()
  - BridgeGame 필드 변수인 StringBuilder 타입의 sb1 을 리턴하는 메서드 -getSb1()
  - BridgeGame 필드 변수인 StringBuilder 타입의 sb2 을 리턴하는 메서드 -getSb2()
  - 게임 시작시(level == 0) BridgeGame 필드변수인 sb1, sb2 에 “[” 를 append 해주는 메서드  - isStart()
  - Bridge 의 값이 U 일때 유저가 입력한 값의 동일성 여부를 확인하여 sb1 과 sb2 에 값을 추가하는 메서드 -isUp()
  -  Bridge 의 값이 D 일때 유저가 입력한 값의 동일성 여부를 확인하여 sb1 과 sb2 에 값을 추가하는 메서드 -isDown()
  -  bridge 의 크기와 level 이 같을때 (최종 스테이지 일때) sb1, sb2 에 “]” 를 추가해주는 메서드 -isLast()
  -  bridge 의 값과 유저의 입력값을 비교하여 O 또는 X 를 리턴해주는 메서드 -compareBridgeAndMoving()
  -  유저가 정답을 맞추지 못하여 다시 시도할 경우 그 전의 맵을 출력하는 메서드 -printBeforeMap()
  -  유저가 정답을 맞추었을 경우 현재까지의 맵을, 모든 정답을 맞추었을경우 전체 맵을 출력하는 메서드 -makeCurrentResultMap()
  -  Bridge 게임의 필드변수 level 을 리턴하는 메서드 -getLevel()
  -  Bridge 게임의 필드변수 tryCount 를 리턴하는 메서드 -getTryCount()
  -  다음 스테이지로 넘어갈 경우 level 을 ++ 해주는 메서드 -nextLevel()
  -  게임을 다시 시도할 경우 BridgeGame 의 필드 변수 tryCount 를 ++ , level 을 다시 전 스테이지로 — 해주는 메서드 -goToBackStage()
- BridgeMaker
  - U 또는 D 의 랜덤값을 리턴해주는 메서드 -direction()
  - 유저에게 입력받은 다리 길이만큼의 생성된 랜덤값들로 이루어진 List<String> bridge 를 리턴해준다. - makeBridge(int size)
- BridgeRandomNumberGenerator
  - 0 또는 1의 랜덤값을 반환해준다. - generate()
- InputView
  - 다리 길이를 입력받는다. - readBridgeSize()
  - 이동할 칸을 입력받는다. - readMoving()
  - 게임을 다시 시도할지 여부를 입력받는다. - readGameCommand()
- OutputView
  - 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다 - printMap()
  - 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. printResult()
- Validator
  - 자동으로 생성할 다리 길이를 입력받을때 입력값이 숫자인지 확인한다. -validIsNum()
  - 자동으로 생성할 다리 길이를 입력받을때 3이상 20 이하의 숫자인지 확인한다. - validRange()
  - 라운드마다 플레이어가 이동할 칸을 입력 받을때 올바른 값인지 확인한다. - validMovingInput()
  - 게임 재시작/종료 여부를 입력받을때 올바른 값인지 확인한다. - validGameCommandInput()
- BridgeGameController
  - 게임시작 메서드들을 실행시킨다. - gameStart()
  - 유저에게 값을 입력받아 Bridge 를 생성하여 리턴한다. - makeBridge()
  - 유저에게 이동할 다리의 값을 입력받아 이동하고 결과를 출력하며 재시작 여부를 입력받아 처리한다. - playGame()
  - 유저가 입력한 재시작 여부에 따라 boolean 값을 리턴한다. - wantFinish()
  - 최종 게임 결과와 도전 횟수를 출력한다. - printResult()


#🚀 기능 요구 사항
## 위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
  - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
  - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력받고 생성한다. 
  - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
  - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
  - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
  - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
  - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
  - 재시작해도 처음에 만든 다리로 재사용한다.
  - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


# 입출력 요구 사항

## 입력

- 자동으로 생성할 다리 길이를 입력 받는다. 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
- 라운드마다 플레이어가 이동할 칸을 입력 받는다. U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.
- 게임 재시작/종료 여부를 입력 받는다. R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.


## 출력
- 게임 시작 문구
- 게임 종료 문구
- 사용자가 이동할 때마다 다리 건너기 결과의 출력 형식은 실행 결과 예시를 참고한다.
  - 이동할 수 있는 칸을 선택한 경우 O 표시
  - 이동할 수 없는 칸을 선택한 경우 X 표시
  - 선택하지 않은 칸은 공백 한 칸으로 표시
  - 다리의 시작은 [, 다리의 끝은 ]으로 표시
  - 다리 칸의 구분은 |(앞뒤 공백 포함) 문자열로 구분
  - 현재까지 건넌 다리를 모두 출력
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

# 프로그래밍 요구 사항
- JDK 11 버전에서 실행 가능해야 한다. JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

# 추가된 요구 사항

- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 아래 있는 InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현한다.
  - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
  - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
  - InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
  - BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

# InputView 클래스
- 제공된 InputView 클래스를 활용해 구현해야 한다.
- InputView의 패키지는 변경할 수 있다.
- InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

# OutputView 클래스
- 제공된 OutputView 클래스를 활용해 구현해야 한다.
- OutputView의 패키지는 변경할 수 있다.
- OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 값 출력을 위해 필요한 메서드를 추가할 수 있다.

# BridgeGame 클래스
- 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
- BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
- BridgeGame의 패키지는 변경할 수 있다.
- BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

# BridgeMaker 클래스
- 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
- BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
- BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

# BridgeRandomNumberGenerator 클래스
- Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator의 generate()를 활용한다.
- BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경할 수 없다.

# 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
