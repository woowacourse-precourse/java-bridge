## 📌 다리 건너기 게임 프로젝트(java-bridge)

---

### 💡 프로젝트 개요

다리 건너기 게임 프로젝트는 ```다리 건너는 시뮬레이션을 프로그램으로 구현```한다.
<details>
<summary>다리 건너기 게임 규칙</summary>

#### 다리 건너기 게임은 ```아래와 같은 규칙```으로 진행된다.
```
위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
  - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
  - 위아래 둘 중 하나의 칸만 건널 수 있다.

- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
  - 플레이어는 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D로 입력한다.
  - 이동한 칸을 건널 수 있다면 O로 표시된다. 건널 수 없다면 X로 표시된다.

- 다리를 끝까지 건너면 게임이 종료된다.

- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
  - 재시작해도 처음에 만든 다리를 재사용한다.
  - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
```
</details>

<details>

<summary>다리 건너기 게임 실행 결과 예시</summary>

#### 실행 결과 예시

```
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
R
이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   ]
[   | O ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   |   ]
[   | O | O ]

최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

```
다리 건너기 게임을 시작합니다.

다리의 길이를 입력해주세요.
3

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
U
[ O | X ]
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)
Q
최종 게임 결과
[ O | X ]
[   |   ]

게임 성공 여부: 실패
총 시도한 횟수: 1
```

</details>

---
### 🚩 프로젝트 목표
1. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 제작
2. 기능별로 클래스를 구성
3. 비즈니스 로직, UI 로직 분리
4. 프로그래밍 요구사항을 만족한다.
   <details>
    <summary>프로그래밍 요구사항</summary>

    ## 🎯 프로그래밍 요구 사항

   - JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
     - 프로그램 실행의 시작점은 `Application`의 `main()`이다.
     - `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
     - [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
     - 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
     - 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
     - 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
     - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
         - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
         - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
     - 3항 연산자를 쓰지 않는다.
     - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
     - JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
     - else 예약어를 쓰지 않는다.
         - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
         - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
     - 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
         - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

   ### 추가된 요구 사항

   - 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
       - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
     - 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
     - 아래 있는 `InputView`, `OutputView`, `BridgeGame`, `BridgeMaker`, `BridgeRandomNumberGenerator` 클래스의 요구사항을 참고하여 구현한다.
         - 각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
         - 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현할 수 있다.
         - `InputView` 클래스에서만 `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 메서드를 이용해 사용자의 입력을 받을 수 있다.
         - `BridgeGame` 클래스에서 `InputView`, `OutputView` 를 사용하지 않는다.

         </details>
5. 클래스별 제한사항을 지키며 프로그래밍한다.
   <details>
      <summary> 클래스별 제한사항</summary>

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

</details>


---
### 🔅 기능 구현 목록

### ❗ 예외 상황
<details>
<summary>1️⃣  다리 길이 입력 예외</summary>
<div markdown="1">

- [X] 숫자가 아닌 문자인지 확인한다.
- [X] 3에서 20 사이의 숫자인지 확인한다.
- [X] 여러 문자를 입력했는지 확인한다.

</div>
</details>

<details>
<summary>2️⃣ 다리 생성 예외 </summary>
<div markdown="1">

- [ ] 생성된 다리의 길이가 플레이어가 입력한 다리 길이와 같은지 확인한다.
- [X] 정의된 관계를 이용하여 숫자로 생성된 다리 상태가 0 또는 1인지 확인한다.

</div>
</details>

<details>
<summary>3️⃣ 이동 방향 입력 예외 </summary>
<div markdown="1">

- [X] U 또는 D가 아닌 문자를 입력했는지 확인한다.
- [X] 한 개 이상의 문자를 입력했는지 확인한다.

</div>
</details>

<details>
<summary>4️⃣ 게임 상태 입력 예외 </summary>
<div markdown="1">

- [X] R 또는 Q가 아닌 문자를 입력했는지 확인한다.
- [X] 한 개 이상의 문자를 입력했는지 확인한다.

</div>
</details>

---
### ⭐ 도메인 로직

<details>
<summary> 1️⃣ 다리 횡단 기능  </summary>
<div markdown="1">

- [X] 다리를 생성한다.
    - [X] 0과 1로 이루어진 다리를 D와 U로 변환환다.
      - [X] 서로 연관된 숫자인 다리 방향와 문자인 다리 방향을 정의한다.
      - [X] 연관 관계를 이용하여 변환한다.

  - [X] 위치에 맞는 다리 구성 상태를 찾는다.

  - [X] 플레이어가 선택한 이동 방향으로 이동한다면 다리 횡단이 가능한지 확인한다.
</div>
</details>

<details>
<summary> 2️⃣ 다리 횡단 결과 관련 기능</summary>
<div markdown="1">

- [X] 다리를 횡단 상태를 정의한다.
  - [X] 다리 횡단 상태에 따라 객체를 반환한다.
  - [X] 다리 횡단 상태에 따라 기호를 반환한다.

- [X] 다리 횡단 상태 출력 형태에 사용할 특수 문자들을 정의한다.
</div>
</details>


<details>
<summary> 3️⃣ 게임 기록 작성 기능</summary>
<div markdown="1">

- [X] 현재 다리 횡단 위치에 따른 포맷에 대해 정의한다. 
  - [X] 현재 다리 횡단 위치에 따라 정의된 포맷 객체를 반환한다.
  - [X] 현재 다리 횡단 위치에 따라 정의된 포맷을 반환한다.
  
- [X] 현재 다리 횡단 상태를 만든다.

- [X] 다리 횡단 횟수에 따른 포맷을 정의한다.
  - [X] 현재 횟수를 검사하여 ' | '의 추가 여부를 판별한다.
  - [X] 횟수를 비교하여 출력 포맷에  ' | '를 추가하거나 그대로 사용한다.
</div>
</details>

<details>
<summary> 4️⃣ 게임 기록 저장 기능</summary>
<div markdown="1">

- [X] 디리 횡단 상태를 저장한다.
  - [X] 다리 건넌 횟수가 1회가 넘는지 확인한다.
  - [X] 현재 다리 횡단 상태를 횟수에 따라 알맞은 형태로 변환한다.
  - [X] 현재 다리 횡단 상태를 이전 횡단 상태에 추가한다.

- [X] 다리 횡단 상태 출력 형태를 만든다.
  - [X] 저장 시작 시 '[ '를 추가한다.
  - [X] 현재까지의 다리 횡단 상태를 추가한다.
  - [X] 다리 횡단 상태를 출력할 때 ' ]'를 추가한다.
  - [X] 띄어쓰기를 추가한다.

- [X] 다리 횡단 상태를 반환한다.
</div>
</details>

---
### 🎨 UI 로직

<details>
<summary>1️⃣ 게임 입력</summary>
<div markdown="1">
 
- [X] 다리 길이를 입력받는다.
  - [X] 적절한 다리 길이 입력이 아닌 경우 제대로 입력할 때까지 입력을 요구한다.
- [X] 이동할 칸을 입력받는다.
  - [X] 적절한 방향 입력이 아닌 경우 제대로 입력할 때까지 입력을 요구한다.
- [X] 게임 진행 여부를 입력받는다.
  - [X] 적절한 입력이 아닌 경우 제대로 입력할 때까지 입력을 요구한다.
</div>
</details>

<details>
<summary>2️⃣ 게임 출력</summary>
<div markdown="1">

- [X] 플레이어가 횡단한 현재 다리 상태를 출력한다.
- [X] 게임 시도 횟수를 출력한다.
- [X] 최종 게임 결과를 출력한다.
- [X] 게임 성공 여부를 출력한다.
- [X] 게임 시작 문구를 출력한다.
- [X] 다리 길이 입력 문구를 출력한다.
- [X] 게임 재시작 및 종료 입력 문구를 출력한다.
- [X] 이동할 칸 선택 문구를 출력한다.
- [X] 예외 상황 메세지를 출력한다.
</div>
</details>


---

### 🔗 컨트롤러 로직


<details>

<summary>1️⃣ 게임 관리</summary>

<div markdown="1">

- [X] 다리 생성 프로세스
- [X] 다리 횡단 프로세스
- [X] 재시작 또는 종료 프로세스
  - [X] 재시작 여부를 게임 커맨드로 정의
    - [X] 게임 커맨드에 따른 재시작 여부 반환 기능
- [X] 최종 결과 출력 프로세스
- [X] 게임 실행 프로세스
</div>

</details>

<details>
<summary>2️⃣ 입력 관리</summary>

<div markdown="1">

- [X] 다리 길이를 알맞게 입력할 때까지 계속 입력을 요구한다.
- [X] 이동 방향을 알맞게 입력할 때까지 계속 입력을 요구한다.
- [X] 게임 커맨드를 알맞게 입력할 때까지 계속 입력을 요구한다.

</div>

</details>

---

<br>