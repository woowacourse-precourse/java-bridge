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
    - `포맷` `[ O |   |   ]`
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
│          ├─validator
│          │      BlockValidator.java
│          │      NumberValidator.java
│          │
│          └─view
│                  InputView.java
│                  OutputView.java
│
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

> 지금부터는 프로그램을 구현하면서 고민하고 도전한 것들에 대해 소개해드리겠습니다.

📎 [자세한 회고 포스팅](https://hello-judy-world.tistory.com/183)

### 🚀 새롭게 도전한 것들 (혹은 구현하면서 고려한 점)
