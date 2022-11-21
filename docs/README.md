## 기능 요구 사항
- [ ] 다리 생성
  - [ ] 3 이상 20 이하의 길이
- [ ] 다리 건너기
  - [ ] 위 아래 둘 중 하나의 칸만 건널 수 있음
  - [ ] 왼쪽에서 오른쪽으로 건널 수 있음
  - [ ] 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸을 건널 수 있음
  - [ ] 위 칸은 U, 아래 칸은 D을 입력해 건넘
- [ ] 게임 종료
  - [ ] 다리를 끝까지 건넜을 때
  - [ ] Q를 입력하여 게임 종료했을 때
  - [ ] 최종 게임 결과 출력
  - [ ] 총 시도한 횟수 출력
  - [ ] 게임 성공 여부(성공, 실패) 출력
- [ ] 다리를 건너다 실패할 때 게임 재시작 또는 종료
  - [ ] 재시작할 때, 이전에 사용된 다리를 재사용함
- [ ] 예외 처리
  - [ ] "[ERROR]"로 시작하는 에러 메시지를 출력 후 **그 부분부터 입력을 다시 받는다.**
    - [ ] 다리 길이가 3 이상 20 이하의 길이가 아닌 경우
      - [ ] int 값을 넘어버린 경우
      - [ ] 소수점
      - [ ] 음수
      - [ ] 0
      - [ ] 2
      - [ ] 19
    - [ ] 다리를 건널 때, 다른 값을 입력한 경우
      - [ ] U, R 외의 문자
      - [ ] 하나의 문자가 아닌 경우
      - [ ] 소문자 u, r
      - [ ] 숫자
      - [ ] 한글
      - [ ] UU, RR
    - [ ] 게임 종료 / 재시도 입력값이 잘못돼었을 경우
      - [ ] R, Q 외의 문자
      - [ ] 하나의 문자가 아닌 경우
      - [ ] 소문자 r, q
      - [ ] 숫자
      - [ ] 한글
      - [ ] RR, QQ
## 프로그래밍 요구 사항
- [ ] 3항 연산자 사용 금지
- [ ] else, switch 사용 금지
- [ ] indent depth를 3이 넘지 않도록 구현
- [ ] 도메인 로직 단위 테스트 구현
- [ ] 메소드 길이 10라인을 넘어가지 않도록 구현
- [ ] 파라미터 개수는 최대 3개까지만 허용
- [ ] InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현
  - [ ] InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
  - [ ] BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
## 클래스 참고 사항
### InputView 클래스
- 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- `InputView`의 패키지는 변경할 수 있다.
- `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
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
- 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- `OutputView`의 패키지는 변경할 수 있다.
- `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 값 출력을 위해 필요한 메서드를 추가할 수 있다.
```java
public class OutputView {

    public void printMap() {
    }

    public void printResult() {
    }
}
```

### BridgeGame 클래스
- 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- `BridgeGame`의 패키지는 변경할 수 있다.
- `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

```java
public class BridgeGame {

    public void move() {
    }

    public void retry() {
    }
}
```

### BridgeMaker 클래스
- 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.
```java
public class BridgeMaker {

    public List<String> makeBridge(int size) {
        return null;
    }
}
```

### BridgeRandomNumberGenerator 클래스

- Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.

#### 사용 예시

- 다리 칸을 생성하기 위한 Random 값은 아래와 같이 추출한다.

```java
int number = bridgeNumberGenerator.generate();
``` 

### 라이브러리

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Console` API를 사용하여 구현해야 한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---