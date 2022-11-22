# 유의 사항
- JDK 11 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- else 예약어를 쓰지 않는다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
- `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.
### InputView 클래스
- 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- `InputView`의 패키지는 변경할 수 있다.
- `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
### OutputView 클래스
- 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- `OutputView`의 패키지는 변경할 수 있다.
- `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 값 출력을 위해 필요한 메서드를 추가할 수 있다.
### BridgeGame 클래스
- 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- `BridgeGame`의 패키지는 변경할 수 있다.
- `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
### BridgeMaker 클래스
- 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
### BridgeRandomNumberGenerator 클래스
- Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.



# 기능 목록
## 도메인 로직
- [x] 게임을 시작한다. - BridgeGameManager#play
  - [x] 다리를 생성한다. - BridgeMaker#makeBridge
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - [x] U와 D로 이루어진 다리로 변환한다. - BridgeConverter#convert
  - [x] 다리를 건넌다. - BridgeGameManager#crossBridge
    - [x] 플레이어가 움직인다. - BridgeGame#move
    - [x] 플레이어가 재시도한다. - BridgeGame#retry
    - [x] 플레이어가 물에 빠져있는지 안다. - BridgeGame#isFailed
## UI 로직
### 입력
- [x] 다리의 길이를 입력받는다. - InputView#readBridgeSize
  - 예외) 숫자가 아닌 문자가 입력된 경우
  - 예외) 3 이상 20 이하의 숫자를 입력하지 않은 경우
- [x] 사용자가 이동할 칸을 입력한다. - InputView#readMoving
  - 예외) 문자 하나를 입력하지 않은 경우 
  - 예외) U와 D 외의 문자를 입력한 경우
- [x] 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. - InputView#readGameCommand
  - 예외) 문자 하나를 입력하지 않은 경우
  - 예외) R과 Q 외의 문자를 입력한 경우
### 출력
- [x] 게임 시작 문구를 출력한다. - OutputView#printStartMessage
- [x] 현재까지 이동한 경로를 출력한다. - OutputView#printRoute
- [x] 게임의 최종 결과를 출력한다. - OutputView#printResult
  - [x] 지금까지 이동한 경로를 출력한다.
  - [x] 게임 성공 여부를 출력한다.
  - [x] 총 시도한 횟수를 출력한다.
- [x] 에러 문구를 출력한다. - OutputView#printErrorMessage