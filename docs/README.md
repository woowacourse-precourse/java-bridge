# 구현 기능 목록

## InputView 클래스

### 요구

- 제공된 `InputView` 클래스를 활용해 구현해야 한다.
- `InputView`의 패키지는 변경할 수 있다.
- `InputView`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
- 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

### 구현 목록

- [x]  다리 길이를 입력받는 기능 구현 - `InputView#readBridgeSize()`
- [x]  사용자가 이동할 칸을 입력받는 기능 구현 - `InputView#readMoving()`
- [x]  사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는 기능 구현 - `InputView#readGameCommand()`

## ****OutputView 클래스****

### 요구

- 제공된 `OutputView` 클래스를 활용해 구현해야 한다.
- `OutputView`의 패키지는 변경할 수 있다.
- `OutputView`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 값 출력을 위해 필요한 메서드를 추가할 수 있다.

### 구현 목록

- [ ]  현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력하는 기능 구현 - `OutputView#printMap()`
- [ ]  게임의 최종 결과를 정해진 형식에 맞춰 출력하는 기능 구현 - `OutputView#printResult()`

## ****BridgeGame 클래스****

### 요구

- 제공된 `BridgeGame` 클래스를 활용해 구현해야 한다.
- `BridgeGame`에 필드(인스턴스 변수)를 추가할 수 있다.
- `BridgeGame`의 패키지는 변경할 수 있다.
- `BridgeGame`의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
- 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.

### 구현 목록

- [ ]  사용자가 칸을 이동할 때 사용하는 메서드 구현 - `BridgeGame#move()`
- [ ]  사용자가 게임을 다시 시도할 때 사용하는 메서드 구현 - `BridgeGame#retry()`

## ****BridgeMaker 클래스****

### 요구

- 제공된 `BridgeMaker` 클래스를 활용해 구현해야 한다.
- `BridgeMaker`의 필드(인스턴스 변수)를 변경할 수 없다.
- `BridgeMaker`의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

### 구현 목록

- [ ]  입력 받은 길이에 해당되는 다리 모양을 생성해주는 기능 구현 - `BridgeMaker#makeBridge()`
- [ ]  생성된 다리 모양 검증 테스트 - `makeBridgeTest()`

## ****BridgeRandomNumberGenerator 클래스****

### 요구

- Random 값 추출은 제공된 `bridge.BridgeRandomNumberGenerator`의 `generate()`를 활용한다.
- `BridgeRandomNumberGenerator`, `BridgeNumberGenerator` 클래스의 코드는 변경할 수 없다.

### 구현 목록

- [ ]  `generate()` 메소드 테스트 코드 작성 / 0 또는 1 값이 나오는지 확인 - `generateTest()`

## 추가 요구 사항

### **라이브러리**

- `[camp.nextstep.edu.missionutils](https://github.com/woowacourse-projects/mission-utils)`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
