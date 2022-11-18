- Domain layer : 도메인 규칙을 갖고 있으며 비지니스를 해결하기 위해 필요한 것들이 있는 계층
- Application layer : 도메인 협력이 이루어지는 계층
- Presentation layer : 사용자에게 정보를 보여주고 사용자의 명령을 해석하는 책임을 갖는 계층
- Infrastructure layer : 애플리케이션 동작 구동을 보장하는 계층


- Domain layer
    - InputView : 사용자 입력 객체
        - readBridgeSize  : 다리의 길이를 입력받는다.
            - bridgeSizeValidation : 숫자가 아닌 입력 검증
            - bridgeNumberValidation : 범위 값 검증
        - readMoving      : 사용자가 이동할 칸을 입력받는다.
            - movingValidation : U/D가 아닌 문자 검증
        - readGameCommand : 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
            - gameCommandValidation : R/Q가 아닌 문자 검증

    - BridgeMaker : 게임 다리 만드는 객체
        - makeBridge : 사이즈를 입력받아 0, 1 난수를 통해 다리 생성
            - isZeroAppendCapitalD : 난수 0 발생 시 "D"를 다리에 붙이는 메서드
            - isOneAppendCapitalU : 난수 1 발생 시 "U"를 다리에 붙이는 메서드

    - OutputView : 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
        - printMap : 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력 메서드
        - printResult : 게임의 최종 결과를 정해진 형식에 맞춰 출력 메서드

    - BridgeGame : 다리 건너기 게임을 관리하는 클래스
        - move : 사용자가 칸을 이동할 때 사용하는 메서드
        - retry : 사용자가 게임을 다시 시도할 때 사용하는 메서드
        - currentUserInput : 게임 진행 시 사용자의 Input 들을 담고 출력하는 메서드
        - currentGameTime : 게임 횟수를 출력하는 메서드
        - looseGame : 게임 성공 여부 실패 출력 메서드
        - winningGame : 게임 성공 여부 성공 출력 메서드

    - ProcessHelper<I> : InputView와 협력하며 테스트 하기 어려운 InputView 대신
      레벨을 낮춰 기능을 분리. Domain layer에선 명세만 정의하고 실제 구현은 Infrastructure layer에서 구현
      ! random, ui 작업이 필요한 InputView에선 테스트하기 어렵지만 기능을 떼어낸 ProcessHelper에선 쉽다.

    - MatchResult : 게임 결과를 담고 결과를 산출하는 객체. upperSide와 downSide로 다리 위 아래를 표현하고
      생성 시 해당 필드들을 생성합니다. 필드는 String이 아닌 StringBuffer로 선언해 사용했습니다.
      이유는 결과를 출력하기 위해선 문자열을 유연하게 핸들링 할 수 있어야 하기 때문입니다.
      - reset : upperSide와 downSide data reset
      - printUpAndDownSides : upperSide와 downSide 출력 메서드
        - printUpperSide : upperSide 출력 메서드
        - printDownSide : downSide 출력 메서드
        - matchProcess : 사용자의 입력 결과들과 매칭 결과를 갖고 출력을 입력하는 메서드
          - appendPrefix : 문자열 맨 앞 "[" 붙이는 메서드
          - appendMiddleAreaOfMatchers : 중간 부분 Matching 결과를 붙이는 메서드
            - matchIsCapitalD : 입력 문자가 "D" 일 경우 붙이는 메서드
            - matchIsCapitalU : 입력 문자가 "U" 일 경우 붙이는 메서드
            - appendSeparator : 결과 값 사이에 존재하는 "|"를 붙이는 메서드
            - matchIsTrueAndLastInputIsCapitalU : 마지막 문자가 hit이고 위치가 "U"일 경우
            - matchIsTrueAndLastInputIsCapitalD : 마지막 문자가 hit이고 위치가 "D"일 경우
            - matchIsFalseAndLastInputIsCapitalU : 마지막 문자가 Not hit이고 위치가 "U"일 경우
            - matchIsFalseAndLastInputIsCapitalD : 마지막 문자가 Not hit이고 위치가 "D"일 경우
            - appendPostfix : 맨 끝 문자열 붙이는 메서드
            
- Infrastructure layer
    - ProcessHelperImpl
- Application layer
    - BridgeGameProcess : Application 에서 호출해 게임을 총괄하는 역할을 담당하는 클래스
        - run() : static으로 설정해 new 연산자 없이 호출해 사용 가능
- Common
    - message : Bridge Game Process를 위한 메세지를 모아둔 Package
        - ConsoleOut : 상수로 메세지를 선언, 모든 Layer에서 사용할 수 있습니다.
        - ExceptionMessage : 상수로 예외처리 메세지 선언, 모든 Layer에서 사용할 수 있습니다.

<!> `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.
위 요구사항이 있어 BridgeNumberGenerator 와 이를 implement한 BridgeRandomNumberGenerator
의 package 위치 변경은 하지 않았습니다.
