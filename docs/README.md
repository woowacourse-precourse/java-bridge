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
