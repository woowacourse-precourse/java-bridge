# 미션 - 다리건너기
## 기능 흐름도
- [ ] 그려서 추가
---
## 기능 요구 사항
- [x] 다리의 길이를 숫자로 입력받고 자동으로 생성
  - 3이상 20이하의 숫자를 입력, 올바른 값이 아니면 예외처리
- [x] 라운드마다 플레이어가 이동할 칸을 입력받아 선택
  - U,D 둘 중 하나를 선택, 올바른 값이 아니면 예외처리
- [x] 게임 재시작/종료 여부를 입력
  - R,Q 둘 중 하나를 선택, 올바른 값이 아니라면 예외처리
- [x] 게임 시작 문구를 출력
  - ```다리 건너기 게임을 시작합니다.```
- [ ] 게임 진행 및 종료 문구를 출력
  - 출력 형식은 실행 결과 예시를 참고하여 출력
    - 이동할 수 있는 칸을 선택한 경우 O 표시
    - 이동할 수 없는 칸을 선택한 경우 X 표시
    - 선택하지 않은 칸은 공백 한 칸으로 표시
    - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
    - 다리 칸의 구분은 ` | `(앞뒤 공백 포함) 문자열로 구분
    - 현재까지 건넌 다리를 모두 출력
- [x] 예외상황시, "[ERROR]"로 시작하는 에러 문구를 출력

---

## 프로그래밍 요구사항
- [x] JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [ ] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [ ] else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- [ ] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

- [ ] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- [ ] 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- [x] 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
    - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
    - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
    - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
    - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

---

## 클래스 요구사항

### InputView 클래스
- [ ] 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- [ ] `InputView`의 패키지는 변경할 수 있다.
- [ ] `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- [ ] 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
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
### OutputView 클래스
- [ ] 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- [ ] `OutputView`의 패키지는 변경할 수 있다.
- [ ] `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [ ] 값 출력을 위해 필요한 메서드를 추가할 수 있다.
```java
public class OutputView {

    public void printMap() {
    }

    public void printResult() {
    }
}
```

### BridgeGame 클래스
- [ ] 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- [ ] `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- [ ] `BridgeGame`의 패키지는 변경할 수 있다.
- [ ] `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- [ ] 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

```java
public class BridgeGame {

    public void move() {
    }

    public void retry() {
    }
}
```

### BridgeMaker 클래스
- [x] 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- [x] `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- [x] `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
```java
public class BridgeMaker {

    public List<String> makeBridge(int size) {
        return null;
    }
}
```

### BridgeRandomNumberGenerator 클래스

- [x] Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- [x] `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.



