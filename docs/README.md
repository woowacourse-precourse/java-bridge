- Domain layer : 도메인 규칙을 갖고 있으며 비지니스를 해결하기 위해 필요한 것들이 있는 계층
- Application layer : 도메인 협력이 이루어지는 계층
- Presentation layer : 사용자에게 정보를 보여주고 사용자의 명령을 해석하는 책임을 갖는 계층
- Infrastructure layer : 애플리케이션 동작 구동을 보장하는 계층

<!> `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.
    위 요구사항이 있어 BridgeNumberGenerator 와 이를 implement한 BridgeRandomNumberGenerator
    의 package 위치 변경은 하지 않았습니다.
