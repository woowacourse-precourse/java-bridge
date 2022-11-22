# 📈 소감, 고민 사항, 알게 된 사실

[소감, 고민 사항, 알게 된 사실](https://github.com/suheonjoo/Study-Document/tree/master/%EC%9A%B0%ED%85%8C%EC%BD%94/%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4%20%EB%AF%B8%EC%85%984)

# 📈 기능 목록

## ✅ 다리 생성 기능

- [X] : 입력받은 다리 길이에 따라 다리를 생성하는 기능
    - 0 또는 1 로 값을 생성한다
    - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.

## ✅ 다리 정보 저장하는 기능

- [X] : 다리 정보를 저장하는 기능
- [X] : 건널수 있는 다리인지 확인하는 기능

## ✅ 사용자가 건너는 다리 정보 저장 기능

- 사용자가 건너는 다리 정보 저장 기능
    - [X] : 사용자가의 upperBridge 건너는 정보 저장 기능
    - [X] : 사용자가의 lowerBridge 건너는 정보 저장 기능
    - [x] : 현재 사용자의 위치 정보 저장 기능
- [X] : 재시작 할 경우, 사용자의 다리 정보를 삭제하는 기능
- [X] : 총 다리 사이즈를 저장하는 기능

## ✅ 다리 길이 입력 기능

- [X] : "다리의 길이를 입력해주세요."  출력하며, 다리 길이를 입력 받는다

## ✅ 사용자가 이동할 칸을 선택 기능

- [X] : "이동할 칸을 선택해주세요. (위: U, 아래: D)" 출력하며, 이동할 칸을 선택한다

## ✅ 사용자에게 재시작/ 종료 여부를 묻는 기능

- [X] : "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" 출력하며, 입력을 받는다

## ✅ 게임 결과를 출력하는 기능

- 게일 결과를 출력한다
    - [X] : "게임 성공 여부: " 출력
    - [X] : "총 시도한 횟수: " 출력
    - [X] : "최종 게임 결과" 출력

## ✅ 사용자가 이동한 다리 모양을 출력하는 기능 (최종 결과 기능과 동등)

- 현재까지 건넌 다리 모양 출력
    - [X] : 이동할 수 있는 칸을 선택한 경우 O 표시
    - [X] : 이동할 수 없는 칸을 선택한 경우 X 표시
    - [X] : 선택하지 않은 칸은 공백 한 칸으로 표시
    - [X] : 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
    - [X] : 다리 칸의 구분은 ` | `(앞뒤 공백 포함) 문자열로 구분

## ✅ 게임 시작 기능

- [X] : "다리 건너기 게임을 시작합니다."  출력

## ✅ 예외처리

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- 입력 기능
    1. 다리 길이
        - [X] : 숫자여야 한다
        - [X] : 3이상 20 이하의 숫자 입력 받을 수 있다
    2. 이동간 선택 기능
        - [X] : 오직U 또는 D 만 입력만 받는다
    3. 재시작/ 종료 여부 기능
        - [X] : 오직 R 또는 Q 만 입력만 받는다
- 다리 생성하는 기능
    - [X] : 0 또는 1이 아니면 안된다

# 로직 흐름

1. 다리 건너기 게임 시작
2. 다리 길이 입력
3. 입력한 다리 길이로 다리 생성
4. 사용자가 다리를 끝까지 도착하거나, 잘못된 길을 갈 때까지 루프문들 돈다
    - 사용자한테 어느쪽으로 다리를 건널 것인지 묻는다
    - 입력 받은 값으로 다리를 건넌다
    - 이때 다리를 잘못 걸어도 사용자가 다리를 건넌 곳을 표시(출력)한다
        1. 만약 사용자가 다리를 잘못 건너는 경우 "실패" 반환
        2. 만약 사용자가 다리를 끝까지 돈 경우 "성공"을 반환

5-1. 사용자가 다리를 끝까지 도착한 경우

- 게임 성공 여부와, 총 시도한 횟수를 출력,
- 그리고 최종 게임 결과를 출력

5-2. 사용자가 실패할 경우

- 게임을 재시작/종료 할것인지 묻는다
    1. 만약 게임을 재시작 할 경우, 4번으로 다시 시작한다
    2. 만약 게임을 종료할 경우, 게임 성공 여부와, 총 시도한 횟수를 출력를 출력한다, 그리고 최종 게임 결과를 출력

-----------------

# 요구사항

## ✅ 3주차 공통 피드백

- [X] : 함수(메서드) 라인에 대한 기준
- [X] : 발생할 수 있는 예외 상황에 대해 고민한다
- [X]  : 비즈니스 로직과 UI 로직을 분리한다
- [X]  : 연관성이 있는 상수는 static final 대신 enum을 활용한다
- [X]  : final 키워드를 사용해 값의 변경을 막는다
- [X]  : 객체의 상태 접근을 제한한다
- [X]  : 객체는 객체스럽게 사용한다
- [X]  : 필드(인스턴스 변수)의 수를 줄이기 위해 노력한다
- [X]  : 성공하는 케이스 뿐만 아니라 예외에 대한 케이스도 테스트한다
- [X]  : 테스트 코드도 코드다
- [X]  : 테스트를 위한 코드는 구현 코드에서 분리되어야 한다
- [X]  : 단위 테스트하기 어려운 코드를 단위 테스트하기
- [X]  : private 함수를 테스트 하고 싶다면 클래스(객체) 분리를 고려한다

## 주어진 요구사항 클래스 기능

### BridgeGame 클래스

- 움직이는 로직 기능
- 재시도 로직 기능

### BridgeMaker 클래스

- 다리를 만드는 기능

### InputView 클래스

- 사이즈 정보를 받는 기능
- 사용자가 위, 아래 중 어디로 움직일지 입력을 받는 기능
- 게임을 재시작 또는 종료할 것인지 입력을 받는 기능

### OutputView 클래스

- 다리 모양을 출력하는 기능
- 최종 사용자가 건던 다리 모양을 출력하는 기능

# ✅ 요구사항 명세서 상세 내역

- [X] : [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- [X] : 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [X] : 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [X] : 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [X] : indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [X] : 3항 연산자를 쓰지 않는다.
- [X] : 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [X] : JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [X] : else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- [x] : 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

### ✅ 추가된 요구 사항

- [x] : 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- [x] : 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
    - [x] : 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
    - [x] : 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
    - [x] : `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
    - [x] : `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

### ✅ InputView 클래스

- [x] : 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- [x] : `InputView`의 패키지는 변경할 수 있다.
- [x] : `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- [x] : 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

```java
public class InputView {

	public int readBridgeSize() {
		return 0;
	}

	public String readMoving() {
		return null;
	}

	public String readGameCommand() {
		return null;
	}
}
```

### ✅ OutputView 클래스

- [x] : 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- [x] : `OutputView`의 패키지는 변경할 수 있다.
- [x] : `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [x] : 값 출력을 위해 필요한 메서드를 추가할 수 있다.

```java
public class OutputView {

	public void printMap() {
	}

	public void printResult() {
	}
}
```

### ✅ BridgeGame 클래스

- [x] : 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- [x] : `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- [x] : `BridgeGame`의 패키지는 변경할 수 있다.
- [x] : `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [x] : 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

```java
public class BridgeGame {

	public void move() {
	}

	public void retry() {
	}
}
```

### ✅ BridgeMaker 클래스

- [x] : 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- [x] : `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- [x] : `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

```java
public class BridgeMaker {

	public List<String> makeBridge(int size) {
		return null;
	}
}
```

### ✅ BridgeRandomNumberGenerator 클래스

- [x] : Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- [x] : `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.

#### 사용 예시

- 다리 칸을 생성하기 위한 Random 값은 아래와 같이 추출한다.

```java
int number=bridgeNumberGenerator.generate();
``` 

### 라이브러리

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Console` API를 사용하여
  구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


