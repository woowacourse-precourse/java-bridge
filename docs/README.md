🥸기능 구현 목록

- [x] 다리를 생성하기 위해, 다리 길이 input값을 받는다. (Input)-> Generator


- 자동으로, 건널 수 있는 다리를 생성한다. Input-> (Generator) -> Judge
  - [x] 자동으로 생성하는 방식은 0,1로 무작위 값을 통해 생성한다. (0은 아래칸, 1은 위칸)
  - [x] 그것을 U,D로 치환시킨다. (0는 D, 1은 U) -> enum을 사용하면 될듯...?

------------ 위는 최초 1회 시행 -------------

- [x] 사용자에게 위로 건널지 아래로 건널지 input값을 받는다. U또는 D값을 받는다. (Input) ->Judge
- [x] 사용자에게 다시할 것인지, 그만할 것인지 input값을 받는다. R과 Q값을 받는다.
  

- 받은 U,D 값을 비교해서 실패인지 성공인지 확인한다.Input,Generator-> (Judge) 
  - 성공 
    - [x] 기본 출력 구현 (Judge) ->Printer
    - [x] 위, 아래 input 값을 받는다. (Judge) ->Input
  - 실패
    - [x] 기본 출력 구현 후, 다시할 것인지 출력을 구현한다. (Judge) ->Printer
    - [x] 다시하기 input 값을 받는다.(Judge) ->Input

- 그에 따른 출력값을 구현한다.
  - [x] 다리 몇개 만들지 출력
   
  - [x] 기본 출력 구현 : 기본 출력이란 [O|O|X] 요런 것 .Judge-> (Printer) 

  - [x] 위, 아래 어디갈지 출력
  - [x] 다시할지 아닐지 출력 구현
    - 다시하면, 위 아래 어디갈지
    - [x] 다시안하면, 몇개 성공 실패했는지

- [] 예외사항 처리를 한다.
  - 예외사항 1 : InputView - 숫자 입력 받을 때 ( 3 이상 20 이하의 숫자가 아닌 경우, 숫자가 아닌 경우 )
  - 예외사항 2 : InputView - U, D 외에 다른 문자를 입력받게 됐을 때 ( U, D 중 하나의 문자가 아닌 경우, --> 더 친절하게? )
  - 예외사항 3 : InputView - R, Q 외에 다른 문자를 입력받게 됐을 때 ( R, Q 중 하나의 문자가 아닌 경우, --> 더 친절하게? )



- [x] 추가된 요구 사항이 뜻하는 것이 무엇인지 파악
  - InputView 클래스 : 내가 생각한 Input 클래스랑 똑같다.
  - OutputView 클래스 : 내가 생각한 printer 클래스와 똑같다. (하지만, 기본적으로 출력하는 메세지는 포함하지 않는데 이유가 있을까?)
  - BridgeGame 클래스 : 내가 생각한 Judge 클래스와 똑같은 듯?
  - BridgeMaker 클래스 : 내가 생각한 Generator 클래스와 똑같은 듯?
  - BridgeRandomNumberGenerator 클래스 : Generator 클래스에서 조금 더 세분화된 생성 클래스


👻고찰

- Application class의 역할은 무엇일까?
  - 실행시키기 위해 존재하는 class인 것 같다.
  - 그렇다면, 현재 상황 2022-11-22-오전 10시 18분 깃 상황에서의 judge method와 retry를 할지 안할지 결정하는 method를 application 클래스에 놓는게 아닌거 같다.
  - 새로운 클래스를 생성해주자.





😖기능 요구 사항


위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
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
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.



## 🎯 프로그래밍 요구 사항

- [] JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- [] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- [] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - [] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - [] 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [] 3항 연산자를 쓰지 않는다.
- [] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [] else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- [] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.


### 추가된 요구 사항

- [] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - [] 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- [] 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- [] 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
    - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
    - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
    - [] `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
    - [] `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

### InputView 클래스
- [] 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- [] `InputView`의 패키지는 변경할 수 있다.
- [] `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- [] 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

### OutputView 클래스
- [] 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- [] `OutputView`의 패키지는 변경할 수 있다.
- [] `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [] 값 출력을 위해 필요한 메서드를 추가할 수 있다.

### BridgeGame 클래스
- [] 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- [] `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- [] `BridgeGame`의 패키지는 변경할 수 있다.
- [] `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [] 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

### BridgeMaker 클래스
- [] 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- [] `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- [] `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

### BridgeRandomNumberGenerator 클래스

- [] Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- [] `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.


```java
int number = bridgeNumberGenerator.generate();
``` 

### 라이브러리

- [] [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.




## ✏️ 과제 진행 요구 사항

- [] 미션은 [java-bridge](https://github.com/woowacourse-precourse/java-bridge) 저장소를 Fork & Clone해 시작한다.
- [] **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [] **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- [] 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
