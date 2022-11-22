🌉미션 - 다리 건너기
-------  

# 목차

1. 🔖 미션 개요
2. 🛎 용어 소개
3. ✔️ 기능목록
4. 💾 프로젝트 구조
5. ✍️ 배운점

# 🔖 미션 개요

이 프로젝트는 2022년 우아한 테크코스-프리코스의 4주차 미션인 '다리 건너기'를 수행한 것으로, 넷플릭스 시리즈 <오징어 게임>의  '징검다리 건너기' 게임처럼 위, 아래 중 한 곳만 지날 수 있는 다리를 한
칸씩 전진하며 끝까지 건너는 게임을 구현한 것이다. 이 미션의 학습 목표는 1) 클래스(객체)를 분리하고 2) 리팩터링하는 법을 익히는 것이다.

# 🛎️ 용어 소개

+ 이 문서와, 프로젝트 소스 코드 이해를 돕고자 프로젝트에서 사용한 용어를 소개한다.
+ 한 **게임**은 **한 개의 다리를 사용**한다. 게임은 다리를 다 건너거나, 사용자가 종료하기를 원하면 종료된다.
+ 다리를 다 건너기 위해 여러번 **시도**할 수 있다. 즉, 다리 중간에 잘못된 칸을 선택하여 실패하면, 새로운 시도를 할 수 있다.
+ 각 시도는 여러 개의 **라운드**로 이루어진다. 다리는 여러 개의 칸으로 나누어져 있으며, 각 칸은 위, 아래로 나누어져 있다. 위, 아래 둘 중 한 칸만 건널 수 있다. 각 라운드 마다 위, 아래 둘 중 한
  칸을 선택한다. 성공할 수도 실패할 수도 있다.
+ **게임(game)**은 여러 개의 **시도(trial)**로 이루어져 있으며, 매 시도마다 여러 번의 **라운드(round)**를 실행한다.
+ 게임의 결과도 같은 관계성을 가진다.
    + 하나의 BridgeGame은 하나의 BridgeGameResult를 가진다.
    + BridgeGameResult는 각 시도에 대한 결과를 담은 BridgeGameTrial의 리스트를 멤버 변수로 가진다.
    + BridgeGameTrial은 각 라운드별 결과의 집합인 BridgeGameRoundResult 리스트를 멤버 변수로 가진다.

# ✔️ 기능 목록

- 기능 목록은 크게 다리 건너기 게임의 핵심 로직을 담당하는 **도메인 기능 목록**과, 콘솔에서의  **입출력 기능 목록**으로 나누어서 작성하였다.
- 들여쓰기의 의미: 함수의 부분 기능을 담당하지만 따로 분리해서 구현되는 기능은 한 단계 들여쓰기 하여 작성하였다. 들여쓰기된 기능은 상위 기능에 의해 호출된다.

## 도메인 기능 목록

+ 다리를 생성한다.   
  (1) 입력 받은 숫자가 3이상 20사이의 숫자인지 확인한다.  
  (2) 1과 0 중 무작위 값을 다리 길이만큼 생성한다.  
  (3) (2)의 각 값을 U와 D로 변환한다.
+ 다리 건너기 게임을 한다.  
  (1) 새로운 시도를 시작한다.  
  (2) 새로운 라운드를 실행한다.  
  (3) 칸을 건너는데 실패하거나, 다리를 다 건널때까지 라운드를 반복한다.  
  (4) 만약 칸을 건너는데 실패했다면, 사용자에게 재시작/종료 여부를 물어본다.  
  (5) 만약 다리를 다 건넜다면 게임을 종료한다.
+ 다리 건너기 게임의 라운드를 실행한다.  
  (1) 사용자에게 입력받은 문자열이 U나 D인지 확인한다. 아니라면, 오류 메세지를 출력하고 새로운 문자열을 입력 받는다.  
  (2) 입력 받은 문자열과 다리를 비교하여 해당 칸을 지날 수 있는지 판단한다.  
  (3) 결과를 저장후, 반환한다.
+ 사용자에게 입력받은 재시작/종료 여부에 따라 다시 실행한다.  
  (1) 사용자에게 입력받은 문자열이 R이나 Q가 아니라면 에러 메세지를 출력하고 새로운 문자열을 입력받는다.  
  (2) 문자열이 R이라면, 새로운 시도를 시작한다.  
  (3) Q라면, 종료한다.

## 입출력 기능 목록

### 입력

+ 자동으로 생성할 다리 길이를 입력받는다.
    + 다리 길이 입력 메세지를 출력한다.
    + 숫자가 아니거나, 정수가 아니라면 IllegalArgumentException을 발생시킨다.
+ 라운드마다 플레이어가 이동할 칸을 입력받는다.
    + 이동할 칸 선택 메세지를 출력한다.
    + 문자열이 비어있다면 IllegalArgumentException을 발생시킨다.
+ 게임 재시작/종료 여부를 입력 받는다.
    + 재시작/종료 여부 선택 메시지를 출력한다.
    + 문자열이 비어있다면 IllegalArgumentException을 발생시킨다.

### 출력

+ 게임 시작 문구를 출력한다.
+ 라운드 결과를 출력한다.
+ 최종 게임 결과를 출력한다.
+ 에러 문구를 출력한다.

# 💾 프로젝트 구조

- **bridge**패키지는 크게  **domain**와  **view**으로 나뉜다.
    - domain 패키지는 다리 건너기 게임의 핵심 로직과 관련된 모든 클래스를 포함한다.
    - view 패키지는 화면 입출력과 관련된 클래스를 포함한다.
- 핵심 로직과 UI로직의 분리를 통해, 핵심 로직와 UI로직의 결합도를 낮추고, 향후 변경사항으로 서로에게 미치는 영향을 최소화하였다.
- ```BridgeGameController```가 UI로직과 도메인 로직을 호출하고 데이터를 전달하는 '조정자'의 역할을 한다.
- ```BridgeMaker```, ```BridgeNumberGenerator```, ```BridgeRandomNumberGenerator``` 는 다리를 생성하는 기능과 관련하여 미리 제공된 클래스로,
  요구사항에 의해 클래스 수정이 불가능하므로, 패키지도 제공된 위치(/src/main/java/)에서 변경하지 않는다.
- domain 패키지의 각 클래스는 1:1로 매칭되는 테스트 클래스를 가진다.
    - 각 테스트 클래스는 매칭되는 클래스의 단위 테스트를 담당한다.
    - 다만,다음과 같은 경우에는 테스트할 필요가 없어 테스트 클래스가 존재하지 않는다.
        1) Enum 클래스
        2) 상수만 가지는 클래스
        3) 데이터를 제공하는 기능을 제외한 특별한 기능이 없는 경우
- view 패키지의 클래스는 테스트 클래스가 존재하지 않는다. 요구사항에 의해 UI 로직은 테스트 대상이 아니다.
- 프로젝트 구조와 각 파일이 담당하는 역할을 기술하였다.

```bash
└── src
    ├── main
    │   └── java
    │       └── bridge
    │           ├── Application.java
    │           ├── BridgeMaker.java			: 다리를 구성할 문자열 리스트를 생성하는 클래스.
    │           ├── BridgeNumberGenerator.java		: 다리를 생성하는 방법 인터페이스 클래스.
    │           ├── BridgeRandomNumberGenerator.java: 랜덤한 숫자로 다리를 구성하는 BridgeNumberGenerator의 구현 클래스.
    │           ├── domain
    │           │   ├── Bridge.java			: 다리에 대한 정보를 관리.
    │           │   ├── BridgeFactory.java		: 다리를 생성하는 클래스.
    │           │   ├── BridgeGame.java			: 게임에 대한 정보(다리, 게임 결과)를 관리.									
    │           │   ├── BridgeGameController.java	: view 패키지와 domain 패키지 사이의 협력을 담당.
    │           │   ├── BridgeGameResult.java 		: 게임의 전체 결과를 저장하는 클래스.
    │           │   ├── BridgeGameRoundResult.java  : 각 라운드의 결과를 저장하는 클래스.
    │           │   ├── BridgeGameTrialResult.java 	: 각 시도의 결과를 저장하는 클래스.
    │           │   ├── BridgeMove.java 	    : 플레이어의 움직임 Up, Down을 나타내는 Enum 클래스.
    │           │   └── GameCommand.java		: 게임 재시작/종료를 나타내는 Enum 클래스.
    │           └── view
    │               ├── InputView.java	 		: 화면 입력을 담당.
    │               └── OutputView.java 		: 화면 출력을 담당.
    └── test
        └── java
            └── bridge
                ├── ApplicationTest.java
                ├── BridgeMakerTest.java
                └── domain
                    ├── BridgeFactoryTest.java
                    ├── BridgeGameControllerTest.java
                    ├── BridgeGameTest.java
                    └── BridgeMoveTest.java
```

# ✍️ 배운점

### 필드의 수를 줄이기 위해 노력한다

+ 계산해서 구할 수 있는 값이면 따로 필드로 저장하지 말고 계산한 값을 반환하자. 각 시도에서 다리를 끝까지 건넜는지, 혹은 총 라운드 수는각 라운드별 결과와, 다리의 길이만 알고 있으면 계산할 수 있으므로 계산한
  값을 반환하는 메소드를 제공하자.
+ 필드에 저장해둔다면
+ 장점: 조회 속도가 빨라진다
+ 단점: 메모리가 낭비되고 멤버 변수가 많아지면 클래스가 복잡해진다. 값이 제때 업데이트 되지 않는 구현 실수를 저지를 가능성이 있다.
+ 매번 계산해서 값을 반환한다면
    + 장점: 값을 매번 업데이트해줄 필요가 없다. 클래스가 간단해진다.
    + 단점: 매번 계산해야 하면 성능이 나빠질 수도 있다.
+ 나의 결론은 대부분의 연산은 컴퓨터 연산 처리 속도가 빠르기 때문에 컴퓨터에 맡겨도 성능이 크게 저하되지 않는다. 사용되는 곳이 많고, 수정이 많이 일어나지 않는다면, 매번 계산하기 보다 인스턴스 변수로 저장한
  후 제공할 수 있다.

### 예외는 Exception으로 뭉뚱그리지 말고, 명확한 유형을 처리한다.

+ ``` `Exception`이 아닌  `IllegalArgumentException`,  `IllegalStateException`  등과 같은 명확한 유형을 처리한다.```
+ 왜 이런 요구사항이 있을까? 예외가 발생한 이유에 따라 1) 예외를 복구할 것인지, 2) 예외처리를 회피할 것인지 3) 예외를 전환할 것인지 결정하기 위해서이다. 즉, 에러의 발생원인에 따라 다른 처리를 해주기
  위해서이다.
+ 사용자가 정수를 입력해야 할때 3.3을 입력해서 NumberFormatException이 발생한 경우에는 IllegalArgumentException으로 예외를 전환하고, 호출한 클래스에서
  IllegalArgumentException 예외를 복구시킨다.
+ Scanner가 Closed되어서 IllegalStateException이 발생한 경우에는 예외처리를 회피하고 프로그램이 종료되도록 한다.
+ 모든 에러를 IllegalArgumentException과 같이 처리한다면, 예외는 계속 복구되고 같은 예외가 계속 발생하여서 프로그램 실패가 발생한다.
+ 내가 예외를 처리한 방법:
    + 사용자 입력값이 잘못된 경우 예외가 발생하였다면 기존의 예외를 IllegalArgumentException으로 전환하고, 예외가 발생하지 않았다면 IllegalArgumentException을 의도적으로
      발생시킨다. 호출한 곳에서 IllegalArgumentException을 catch try를 활용해 예외를 복구하고 새로운 값을 입력받는다.
    + 이외 발생하는 NullPointerException, IllegalArgumentException, IndexOutofRangeException, No Such Element Exception 등은
      예외처리를 회피하고 상위 클래스로 던져서 Application.main()에서 발생한 예외에 대한 오류 메세지를 출력한후 프로그램을 종료한다.
+ 에러를 구분하니 테스트를 더 정밀하게 할 수 있었다. 각 테스트 경우마다 발생하는 기대되는 예외 종류를 명확하게 지정해 프로그램이 예상되로 동작한다는 것을 확인할 수 있었다.

### 전략 패턴을 사용하면 테스트가 쉽고, 전략을 바꾸기 쉽다.

+ BridgeNumberGeneration 인터페이스를 활용하여 BridgeMaker의 숫자 생성 전략을 쉽게 교체할 수 있다.
+ 프로그램 코드에서는 RandomNumberGeneration 전략을 사용하여 난수를 생성하여 반환하도록 한다.
+ 테스트 코드에서는 TestNumberGeneration 전략을 사용하여 지정한 숫자리스트를 차례대로 반환하도록 한다. 테스트 코드에 난수가 포함되어 있다면 결과값을 예상할 수 없어 테스트하기 어렵기 때문이다.

### 난수를 생성하는 로직이 포함되어있을때 전략을 수정하거나, MockedStatic을 사용해 반환 값을 고정할 수 있다.

+ 전략 패턴을 사용해 숫자 생성 로직을 난수 생성해서 지정한 리스트의 원소 차례로 반환하도록 함.

```
    @Test
    void 다리_생성_테스트_예제() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }
        @Test
    void 다리_생성_테스트_예제() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }
```

+ MockedStatic을 이용해 특정 static함수가 호출될때 지정한 값을 차례로 반환한다. 마치 static 함수가 반환하는 것처럼 꾸며낸다.

```
private static <T> void assertRandomTest(  
  final Verification verification,  
  final Executable executable,  
  final T value,  
  final T... values  
) {  
  assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {  
  try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {  
  mock.when(verification).thenReturn(value, Arrays.stream(values).toArray());  
  executable.execute();  
 } });}
```

+ 두 방법 다 가능하다. 단, main 소스 코드가 전략 패턴으로 설계되어있어야 한다.

### 열거 타입의 static 함수를 활용하자.

+ Enum 클래스를 사용해왔으면서도 Enum.valueOf()라는 함수가 어떻게 이름과 일치하는 Enum 객체를 반환하는 건지 알지 못했다. 그래서 이름이 아닌 특정 필드의 값으로 해당하는 Enum객체를 가져오고
  싶은데 어떻게 가져올 수 있을지 구현하기 어려웠다. Enum 클래스의 동작방식을 이해하기 위해 '이것이 자바다' 책의 Enum 장을 읽었다.
+ Enum 장을 읽다보니 JVM 메모리의 동작 방식도 이해해야할 필요성을 느껴서 인터넷에 찾아보았다. 인터넷에서 찾은 자료와, 책과, JavaDoc을 참고하여 Enum에 대해서 깊이 이해할 수 있었다.
+ Enum은 언제 사용하는가?
    +
        1) 연관된 상수들을 한번에 관리하기 위해서
    +
        2) 데이터의 개수가 한정되어 있을때 객체를 재사용하기 위해서
+ 열거 타입은 몇 개의 열거 상수(enumeration constant) 중에서 하나의 상수를 저장하는 데이터 타입이다. 열거 상수 요소의 개수만큼 HeapArea에 객체가 생성되고 열거 타입 변수는 이 객체들을
  참조해서 사용한다.
  ```JAVA
  Week week1 = Week.SATURDAY; 
  Week week2 = Week.SATUREDAY; 
  System.out.println(week1 == week2); //True
  ```
+ valueOf(String name): 열거 요소들 중 일치하는 이름을 갖는 열거 타입을 반환한다.
  ```
  static <T extends Enum <T>> T valueOf(Class enumType, String name)
  ```
+ valueOf()를 참고해서 열거 요소들 중 일치하는 moveCode를 가지는 열거 타입을 반환하는 static 함수를 구현하였다.
  ```java
  public static BridgeMove getBridgeMoveByMoveCode(int moveCode) {  
    for (BridgeMove move : BridgeMove.values()) {  
    if (move.moveCode == (moveCode)) {  
    return move;  
  } 
   }  
   throw new IllegalArgumentException("0 또는 1를 입력해주세요.");  
  }
  ```
+ JVM 메모리
    + Class Area:  JVM이 시작할때 생성되고 모든 스레드가 공유하는 여역. 코드에서 사용되는 클래스들을 클래스 로더로 읽고 저장한다.
    + Heap Area: 힙 area 동적으로 할당되는(런타임에 크기가 결정) 메모리 영역. 객체와 배열이 생성되는 영역이다. 힙영역에 생성된 객체와 배열(참조 타입 변수)은 JVM 스택 영역의 변수나 다른
      객체의 필드에서 참조한다. 참조하는 변수나 필드가 없다면 의미 없는 개체가 되기 때문에 Garbage Collector가 자동으로 객체를 제거한다.
    + Stack Area: : 각 스레드마다 하나씩 존재한다. 각 스레드마다 하나씩 존재한다.

### 함수를 만들때 내가 사용하고자 하는 맥락을 벗어나서 예외 처리를 하자.

+ 함수를 만들때 내가 사용하고자 하는 맥락을 고려하여 인자에 들어올 값들을 한정해서 생각하게 되는데, 내가 사용하고자 하는 맥락이 아닌 곳에서도 사용될 경우 매번 유효한 값이 들어오지 않을 수 있다는 것을 고려하고
  예외처리를 하자.
+ 생각지도 못한 예외를 방지하기 위해서는
    + collections의 값을 읽는 경우 Index Out of Range오류도 항상 체크.
  ```java
  public BridgeGameRoundResult getRoundResult(int round) {  
        if (round < 1 || round > trialResult.size()) {  
            throw new IndexOutOfBoundsException("유효하지 않은 round 입니다.");  
       }  
           return trialResult.get(round);  
  }
  ```
    + 생성자에서 유효성 검증을 하는 클래스를 만들고 매개변수에서 객체를 사용하면 룰에 맞는 값이 들어오도록 보장할 수 있음. 이 경우, Null Check도 따로 필요함.

### 함수명은 더 명확하게 짓자

+ 다리를 다 건넜는지에 대한 boolean값을 반환하는 함수의 경우, didSucceded 보다는 didCrossTheBidge같이 행위를 구체적으로 표현하는 함수명이 낫다.

### @BeforeAll, @BeforeEach를 적절히 사용하자

+ 만약 테스트 중에 데이터 조작이 없다면 @BeforeAll을 사용해 모든 테스트 전 한번만 수행한다.
+ 만약 데이터 변경이 일어난다면 각 테스트 독립성을 유지하기 @BeforeEach를 사용해 매 테스트 전에 실행.
+ @BeforeEach가 더 많은 연산이 수행되어야 하지만 Human Error를 방지한다는 점에서 더 나을수도 있음. HumanError라고 하면, 데이터 조작이 일어나는 테스트 케이스를 구현해 다른
  테스트케이스가 실패하도록 하는 경우.

### 도메인 로직과 UI 로직을 분리하자

+ 도메인 로직과 UI로직의 분리를 통해, 핵심 로직와 UI로직의 결합도를 낮추고, 향후 변경사항으로 서로에게 미치는 영향을 최소화할 수 있다.
+ ```BridgeGame클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.``` 요구사항이 있는 이유: BridgeGame은 도메인 로직, InputView, OuputView는
  UI로직이다. 도메인 로직에서 직접 UI로직을 호출해서 사용한다면 결합도가 높아지고, 도메인 로직의 수정이 View에 영향을 끼칠 수 있다.
+ controller의 역할: 도메인 로직과 UI 로직을 연결한다. UI에서 입력값을 받아 도메인 로직에 메세지를 보내 데이터를 조작한다. 도메인 로직에서 받은 값을 view에게 전달하여 화면에 출력하도록 한다.
  ex) BridgeGameController.class
+ controller는 데이터를 가지지 않는다. 데이를 가지는 객체(도메인, 모델)을 조작한다.
+ 예외처리도 분리하자. 빈 문자열이나 숫자로 파싱이 안되는 값이 들어오는 것을 체크하는 것은 UI로직이, 그 이외에 도메인 로직에 관련된 값 유효성 검증은 도메인 로직이 실행해야 한다.

### 기타
+ Why list.contains(null) throwing null pointer exception?.
    + List.of()는 Immutable한 객체인대 원소를 수정하려고 해서 오류 발생.
    + Array.asList()는 배열을 collections 형태로 바꾸어 주어지만, 크기 변경 불가능. ArrayList와 다르다.
    + org.assertj.core.util패키지의 List.newArrayList() 사용. 
+ 터미널에서 엔터를 쳤을때 scanner에는 null이 아닌 ""이 들어감. 빈 문자열.
+ 빈 줄을 추가하고 싶다면 System.out.println();. System.out.println(System.lineSeperator)는 두줄이 입력됨.