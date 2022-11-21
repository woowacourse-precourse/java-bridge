## 🚀 기능 구현 목록

### 0. Controller
- [X] 처음 세팅을 위한 Controller에서 다리에 대한 정보(다리 길이, 이동 가능한 다리 자리 여부)를 처리
- [X] GameController 로 연결
- [X] GameController 에서 게임진행에 따른 로직들 연결 후 수행

### 1. UI
  - 📌 InputView
    - [X] 다리의 길이 입력
      - [X] (예외) 입력이 3에서 20사이의 숫자가 아닌 경우
    - [X] 움직임 입력
      - [X] (예외) 움직임이 U,Q가 아닌 값이 입력된 경우
    - [X] 움직임이 못가는 칸으로 갔을 경우 재시도, 종료 입력 
  - 📌 OutputView
    - [X] 다리 길이 입력 전 초기 출력 부분
    - [X] 게임 시작 전 출력
    - [X] 움직임 부분 Map을 표현하기 위하여 MapPrinting과 연계한 출력! (핵심)
    - [X] 재시도 하는 경우 안내를 위한 출력부
    - [X] 게임이 종료될 때 최종적으로 출력해야하는 형식에 맞는 출력 기능 추가
### 2. Domain
  - 📌 BridgeGame
    - [X] 움직임을 담당하는 move()
    - [X] 움직일 수 있는 칸인지 아닌지에 대한 것을 전처리하는 작업
      - 📌 MapPrinting 
        - [X] "[" , "]" 사이에 필요한 O,X,| 을 잘 조합하여 넣어준 후 합치는 작업!
        - [X] 이후 완성된 현황판에 대한 다리를 출력부분으로 넘기는 작업
        - [X] 도중에 X가 생기게 되면 출력 후 재시작 로직으로 넘어가기!
    - [ ] 재시작을 담당하고 시작하는 retry() -> 어떻게 더 분류할 지 고민
      - [X] 재시작을 하는 것인지 아니면 게임을 종료해야하는지 판별
      - 📌 JudgeDestination
        - [X] 입력에 따른 재시작 혹은 종료에 대한 판결
      - [X] 재시작 시 현재 사용하던 이동 가능한 다리에 대한 정보를 재사용하여 다시 진행
      - [X] 종료시 성공적인 종료인지 실패하고 종료하는 것인지에 대하여 따로 분류 후 출력 프로세스 진행
             
### 3. Util
- 📌 Validate
    - [X] 입력 부분에 대한 모든 검증을 처리해야함. 
    - [X] 예외 처리 시 "[ERROR]" 포함 메시지로 출력, IllegalArgumentException오류로 발생

- [ ] 아래의 요구사항에 맞게 리팩토링! - 미완료
- [ ] 도메인 로직 단위 테스트 구현 
---

### 구현 시 참고 사항

- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다. ✔
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다. 
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다. ✔
- 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
    - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다. 
    - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다. ✔
    - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다. ✔
    - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다. ✔

### InputView 클래스
- 제공된 `InputView` 클래스를 활용해 구현해야 한다. ✔
- `InputView`의 패키지는 변경할 수 있다. ✔
- `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다. ✔
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다. ✔
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
- 제공된 `OutputView` 클래스를 활용해 구현해야 한다. ✔
- `OutputView`의 패키지는 변경할 수 있다. ✔
- `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다. ✔
- 값 출력을 위해 필요한 메서드를 추가할 수 있다. ✔
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
- `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다. ✔
- `BridgeGame`의 패키지는 변경할 수 있다. ✔
- `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다. ✔
- 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다. ✔

```java
public class BridgeGame {

    public void move() {
    }

    public void retry() {
    }
}
```

### BridgeMaker 클래스
- 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다. ✔
- `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다. ✔
- `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다. ✔
```java
public class BridgeMaker {

    public List<String> makeBridge(int size) {
        return null;
    }
}
```

### BridgeRandomNumberGenerator 클래스

- Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다. ✔
- `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다. ✔

