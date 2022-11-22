## 🎮 게임 흐름

### 게임 시작

- 시작 메시지 출력

### 게임 중

- 다리 길이 `x`를 입력 받음, `y는 2로 항상 고정`
- **A** 이동할 칸을 입력 받음 `U: 위`, `D: 아래`
- 맵 출력

> - 🌉 `건널 수 있는 칸`을 갔다면 **A**로 이동
>- 🏁 `완주` 및 `건널 수 없는 칸`을 갔다면 `게임 종료`

### 게임 종료

- **성공:** 완주
    - 게임 결과 출력 (최종 게임 결과, 성공 여부, 시도 횟수)


- **실패:** 건널 수 없는 칸에 있음
    - 다시 시도 여부 묻기
  > - R(retry): `플레이어 위치`, `맵 초기화` 후 **A**로 이동, `시도 횟수 + 1`
  > - Q(quit): 게임 결과 출력 (최종 게임 결과, 성공 여부, 시도 횟수)

---

## 🚀 클래스 정리

### ✨ BridgeGame

**다리 건너기 게임을 관리하는 클래스**

_메서드 이름 변경 불가 ❌_

```java
public class BridgeGame {

    public void move() {
    }

    public void retry() {
    }
}
```

- 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- `BridgeGame`의 패키지는 변경할 수 있다.
- `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

---

### ✨ BridgeMaker

**다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.**

_필드(인스턴스 변수) 변경 불가 ❌_

_메서드 시그니처, 반환 타입 변경 불가 ❌_

```java
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    // ...

    public List<String> makeBridge(int size) {
        return null;
    }
}
```

- 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

---

### ✨ BridgeNumberGenerator

_코드 변경 불가 ❌_

### ⚙️ BridgeRandomNumberGenerator

_코드 변경 불가 ❌_

---

### ✨ InputView

**사용자로부터 입력을 받는 역할을 한다.**

- 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- `InputView`의 패키지는 변경할 수 있다.
- `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

---

### ✨ OutputView

**사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.**

_메서드 이름 변경 불가 ❌_

```java
public class OutputView {

    public void printMap() {
    }

    public void printResult() {
    }
}
```

- 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- `OutputView`의 패키지는 변경할 수 있다.
- `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 값 출력을 위해 필요한 메서드를 추가할 수 있다.

---

## 💡 랜덤 값 생성

> - Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
> - `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.

## ⚠️ 추가된 주의사항

- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
    - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
    - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
    - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
    - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

## 🚀 클래스 별 Todo

### ✨ BridgeGameRunner

- [x] 브릿지 게임 전체 프로세스 실행 기능

- [x] 라운드가 끝날 때까지 move를 반복하는 기능

- [x] 재시작/종료 기능

### ✨ BridgeGame

- [x] move 기능

- [x] 재시작 기능

- [x] 플레이어 생존 확인 기능

- [x] 플레이어 승리 확인 기능

- [x] 결과값 문자열로 반환하는 기능

- [x] 브릿지 맵 초기화 기능

### ✨ InputView

- [x] 브릿지 맵 사이즈 입력 기능

- [x] 움직임 커맨드 입력 기능

- [x] 재시도/종료 커맨드 입력 기능

### ✨ OutputView

- [x] 시작 메시지 출력 기능

- [x] 브릿지 맵 출력 기능

- [x] 결과 출력 기능

### ✨ BridgeMaker

- [x] 인자로 들어온 크기만큼 랜덤 값을 이용해 U와 D로 이루어진 List 반환 기능 구현

### ✨ ErrorMessageGenerator

- [x] Error 메시지 생성 기능 구현