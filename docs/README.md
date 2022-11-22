## 🚩 기능 목록
- [X] 플레이어로부터 다리의 길이를 입력받는다.
  - [ ] 3부터 20 사이의 숫자가 아닌 경우 예외처리
- [ ] 플레이어로부터 이동할 칸을 입력받는다.
  - [ ] 위를 나타내는 U와 아래를 나타내는 D가 아닌 경우 예외처리
- [ ] 플레이어로부터 게임을 다시 시도할지 여부를 입력받는다.
  - [ ] 재시도를 나타내는 R과 종료를 나타내는 Q가 아닌 경우 예외처리
- [X] 다리의 길이를 이용하여 다리를 만든다.
- [ ] 이동할 칸을 입력하여 다리를 이동한다.
  - [ ] 정답이라면 계속해서 이동한다.
  - [ ] 오답이라면 이동을 멈춘다.
- [ ] 이동후에 플레이어의 현재 위치와 정답 여부를 고려하여 다리의 모양을 시각적으로 출력한다.
- [ ] 최종 게임 결과를 출력한다.
  - [ ] 최종적으로 이동한 다리의 정보
  - [ ] 게임 성공 여부
  - [ ] 총 시도한 횟수

## 🎯 프로그래밍 요구 사항
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [ ] else 예약어를 쓰지 않는다.
- [ ] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [ ] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- [ ] 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- [ ] 아래 있는 InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현한다
  
  - #### InputView 클래스
  - [ ] 제공된 InputView 클래스를 활용해 구현해야 한다.
  - [ ] InputView의 패키지는 변경할 수 있다.
  - [ ] InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
  - [ ] 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
  - [ ] InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
  
  - #### OutputView 클래스
  - [ ] 제공된 OutputView 클래스를 활용해 구현해야 한다.
  - [ ] OutputView의 패키지는 변경할 수 있다.
  - [ ] OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
  - [ ] 값 출력을 위해 필요한 메서드를 추가할 수 있다.
  
  - #### BridgeGame 클래스
  - [ ] 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
  - [ ] BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
  - [ ] BridgeGame의 패키지는 변경할 수 있다.
  - [ ] BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
  - [ ] 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
  - [ ] BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
  
  - #### BridgeMaker 클래스
  - [ ] 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
  - [ ] BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없다.
  - [ ] BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
  
  - #### BridgeRandomNumberGenerator 클래스
  - [ ] Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator의 generate()를 활용한다.
  - [ ] BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경할 수 없다.
