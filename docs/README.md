## 🪜 다리 건너기 (박정윤)

### < 기능 구현 목록 >

### 메인 MVP (게임 프로세스)

- [x] <출력> 게임 시작 문구
    - `포맷` 다리 건너기 게임을 시작합니다.
- [x] <입력> 다리 길이
    - `포맷` 다리의 길이를 입력해주세요.
    - `포맷` 3
    - [x] `예외 처리`
        - [x] 숫자가 아닌 경우
        - [x] 3 이상 20 이하의 범위를 벗어나는 경우
        - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [x] <입력> **라운드마다 플레이어가 이동할 칸**
    - `포맷` 이동할 칸을 선택해주세요. (위: U, 아래: D)
    - `포맷` U
    - [x] `예외 처리`
        - [x] U(위 칸)와 D(아래 칸)가 아닌 문자가 들어온 경우
        - 잘못된 값인 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [x] <출력> **사용자가 이동할 때마다 다리 건너기 결과**
    - `포맷` `[ O | X ]`
    - `포맷` `[   |   ]`
    - 현재까지 건넌 다리를 모두 출력
- [x] <입력> 게임 재시작/종료 여부
    - `포맷` 게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
    - `포맷` R
    - [x] `예외 처리`
        - [x] R(재시작)과 Q(종료) 아닌 값이 들어온 경우
        - 잘못된 값인 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [x] <출력> 게임 종료 문구
    - `포맷` 최종 게임 결과
    - `포맷` `[ O | |   ]`
    - `포맷` `[   | O | O ]`
    - `포맷` 게임 성공 여부: 성공
    - `포맷` 총 시도한 횟수: 2

### 다리 생성 (Domain)

- [x] 다리 생성
    - 무작위 값이 0이면 아래칸이 건널 수 있음(D). 1이면 위 칸이 건널 수 있음(U).
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D
    - ex) [U, D, U]

### 게임 로직

- [x] 게임 진행
    - `입력` 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D
    - `출력` 이동한 칸을 건널 수 있다면 O로 표시, 건널 수 없다면 X로 표시
- [x] 다리를 끝까지 건너면 게임이 종료
- [x] 다리를 건너다 실패하면 게임을 재시작하거나 종료
    - 재시작해도 처음에 만든 다리로 재사용
    - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수

<br>

### < 프로그램 요구사항 체크리스트 >

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현. 2까지만 허용.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게.
- [x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인.
- [x] else 예약어를 쓰지 않는다.
- [x] 도메인 로직에 단위 테스트를 구현. UI(System.out, System.in, Scanner) 로직은 제외.
- [x] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현.
- [x] 메서드의 파라미터 개수는 최대 3개까지만 허용

<br>

### < 폴더 구조 >

```
├─main
│  └─java
│      └─bridge
│          │  Application.java
│          │  BridgeGame.java
│          │  BridgeMaker.java
│          │  BridgeNumberGenerator.java
│          │  BridgeRandomNumberGenerator.java
│          │
│          ├─controller
│          │      BridgeGameController.java
│          │
│          ├─domain
│          │      GameResult.java
│          │
│          ├─validator
│          │      BlockValidator.java
│          │      NumberValidator.java
│          │
│          └─view
│                  InputView.java
│                  OutputView.java
└─test
    └─java
        └─bridge
            │  ApplicationTest.java
            │  BridgeGameTest.java
            │  BridgeMakerTest.java
            │
            └─view
                    InputViewTest.java
```

<br> 

---

> 지금부터는 프로그램을 구현하면서 고민하고 도전한 것들에 대해 소개해드리겠습니다.

📎 [자세한 회고 포스팅](https://hello-judy-world.tistory.com/183)

### 🚀 새롭게 도전한 것들 (혹은 구현하면서 고려한 점)

1️⃣ **예외 처리 및 재입력**

지난 미션에서는 예외 발생 시 메세지를 출력하고 프로그램을 종료했는데 이번 미션에서는 프로그램을 종료시키는 것이 아니라
재입력을 받았다. 이때 처음에 InputView에서 예외 처리를 하고 재입력 받도록 하니 책임 범위가 불명확하고 어색한 코드가 되었다.

그래서 다음과 같이 책임을 분리했다.

1. <u>InputView</u>: 입력에 대한 입력과 validation의 책임만
2. <u>Controller</u>: String으로 입력 받아온 데이터를 전처리. 필요한 데이터 형태로 처리.

그리고 재입력 로직은 두 가지 방법으로 구현을 고민했다.

1. while문 사용
    - while문을 활용해서 예외 발생 시 예외 발생 하지 않을 때 까지 반복하는 코드를 작성했다.
    - while문으로 코드를 반복하며 try문에서 예외가 발생하지 않았을 때 break하여 반복을 탈출하도록 구현했다.
2. 재귀로 구현
    - 현재 코드에서 depth를 줄이기 위해서 고민을 했다. 이때 입력을 받는 메서드가 있으면 catch문에서 해당 메서드를 재귀적으로 반복하면 된다는 아이디어가 떠올랐다.
    - 그래서 아래와 같이 개선된 코드를 작성할 수 있었다.

```
private int initSize() {
   String bridgeSize = "";
   try {
        bridgeSize = InputView.readBridgeSize();
   } catch (IllegalArgumentException e) {
        OutputView.printErrorMessage(e);
        return initSize();
   }
   return Integer.parseInt(bridgeSize);
}
```

2️⃣ **Console로 input을 받는 메서드 테스트 코드 작성하기**

view에서 input을 받으면서 validation을 하고 있기 때문에 여러 경우의 잘못된 입력값을 잘 처리해주고 있는지 테스트가 필요하다.
이 부분의 테스트 코드를 작성함으로써 올바르게 예외처리가 되고 있는지 확인했다.

❗작성 방법

1. 테스트용 mock InputStream을 만든다.
2. 이때 생성한 InputStream을 System.in에 넣어준다.

<br>

### 🧐 구현하면서 고민했던 것들

1️⃣ **enum 타입은 언제 사용하는 것이 맞을까**

> 연관성이 있는 상수는 static final 대신 enum을 활용한다. <br>
> -*우아한 테크코스 3주차 피드백 중*

다음은 게임의 성공, 실패 결과를 출력하는 메서드이다.

```
public static void printResult(boolean gameResult){
    String result="실패";
    if(gameResult)result="성공";
    System.out.printf(GAME_RESULT_MESSAGE+"%n",result);
}
```

이때, 비슷한 성격의 값이 하드 코딩되어 있다. 공통 피드백을 반영하여 static final로 상수 대신 enum으로 변경할지 고민했다.

❓이때 고민되었던 것은 연관성 있는 상수를 묶는다는게 성공이라는 상수에 (1, 5000, false) 와 같이 여러가지 연관된 값이 있을 때 만들어주는 것인지 
카테고리 자체가 연관성이 있을 때 enum으로 빼는 건지 고민이 되었다.

그래서 enum의 장점을 다시 살펴봤다.

👉 [우아한 형제들 기술 블로그, Java Enum 활용기](https://techblog.woowahan.com/2527/)

읽으면서 생각했다. 현재 성공, 실패를 true, false로 메서드에서 입력을 받고 그것을 문자로 치환해준다.

그렇다면 성공 실패라는 것이 여러 형태로 구현될 수 있다는 것이다. 나중에 다른 클래스에서 1, 0으로 판단할 수도 있다.

그래! 결정했어! enum으로 분리하자.

그리고 나중에 추가 타입이 필요한 경우에도 Enum 상수와 get메소드만 추가하면 되도록 구현했다.