## 🚀 기능 구현 목록

- [X] 다리의 길이를 숫자로 입력
  - [X] 길이 입력시 필요한 출력 부분 작성
  - [X] (예외) 주어진 범위가 아닌 입력
  - [X] (예외) 숫자가 아닌 입력
    - [X] 길이 관리 부분에 대한 예외 출력은 하나로 일치 
- [X] 다리의 길이만큼 bridge(이동가능한 칸에 대한 여부) 생성 
  - [X] Generator를 활용하여 생성 0인경우 D, 1인경우 U
  - [X] BridgeMaker를 통하여서 생성 List<String>의 형태로 반환
- [ ] 플레이어가 이동할 칸 입력 시 처리 할 부분
  - [X] (예외) U,D의 입력이 아닌 경우
  - [ ] 이동할 칸 선택 후 이동할 수 있는지 여부 check
    - [ ] 건널 수 있으면 O표시, 못건너면 X 로 출력시켜놓기.
      - [ ] 출력형식에 맞게 출력 위쪽"[ ]"아래쪽 함께"[ ]
- [ ] 다리 길이만큼 다 건너면 게임 종료 기능 구현
- [ ] 진행하다 실패한 경우 발견하면 재시작 아니면 종료
  - [ ] 재시작시 해당 지도를 다시 활용하면서 다시 처음부터 진행 
  - [ ] 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수 표시.

- [ ] 예외 발생 시 IllegalArgumentException 발생시키고 해당 입력부분 다시 실행
---

### 구현 시 참고 사항

- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
    - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
    - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
    - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
    - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

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
