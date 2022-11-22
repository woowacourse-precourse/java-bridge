# 미션 - 다리 건너기

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 11인지 확인한다. 또는 Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 11로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,   
  Windows 사용자의 경우  `gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구 사항

위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - 다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - 위아래 둘 중 하나의 칸만 건널 수 있다.
- 다리의 길이를 숫자로 입력받고 생성한다.
    - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
    - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다.
    - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
    - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
    - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.
    - 재시작해도 처음에 만든 다리로 재사용한다.
    - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 자동으로 생성할 다리 길이를 입력 받는다. 3 이상 20 이하의 숫자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
3
```

- 라운드마다 플레이어가 이동할 칸을 입력 받는다. U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
U
```

- 게임 재시작/종료 여부를 입력 받는다. R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있으며 올바른 값이 아니면 예외 처리한다.

```
R
```

#### 출력

- 게임 시작 문구

```
다리 건너기 게임을 시작합니다.
```

- 게임 종료 문구

```
최종 게임 결과
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공
총 시도한 횟수: 2
```

- 사용자가 이동할 때마다 다리 건너기 결과의 출력 형식은 실행 결과 예시를 참고한다.
    - 이동할 수 있는 칸을 선택한 경우 O 표시
    - 이동할 수 없는 칸을 선택한 경우 X 표시
    - 선택하지 않은 칸은 공백 한 칸으로 표시
    - 다리의 시작은 `[`, 다리의 끝은 `]`으로 표시
    - 다리 칸의 구분은 ` | `(앞뒤 공백 포함) 문자열로 구분
    - 현재까지 건넌 다리를 모두 출력
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```
[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
```

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

---

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
int number=bridgeNumberGenerator.generate();
``` 

### 라이브러리

- [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Console` API를 사용하여
  구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-bridge](https://github.com/woowacourse-precourse/java-bridge) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

---

## ⭐️ 구현할 기능 목록

### 다리 건너기 게임의 흐름과 입출력

1. 게임 시작 문구 출력
    * 출력: `다리 건너기 게임을 시작합니다.`


2. 다리 길이 입력받기
    * 출력: `다리의 길이를 입력해주세요.\n`
    * 사용자 입력: 3 이상 20 이하의 숫자


2. 다리 생성
    1. 입력받은 다리 길이만큼 0과 1 중에서 무작위 값을 생성
    2. List에 생성된 무작위 값에 따라 U 또는 D 값 insert
        * 0이라면 D (아래 칸 건너기 가능)
        * 1이라면 U (위 칸 건너기 가능)


3. 사용자에게서 이동할 칸을 입력받기
    * 출력: `이동할 칸을 선택해주세요. (위: U, 아래: D)\n`
    * 사용자 입력: `U` 또는 `D`


4. 다리 상에서 사용자를 3번에서 입력한 칸으로 이동


5. 현재까지 건넌 다리 출력
    * 출력 형식
        * 다리의 시작은 `[`, 다리의 끝은 `]`
        * 다리 칸의 구분은 ` | `
        * 현재까지 건넌 다리를 모두 출력

        1. 이동할 수 있는 칸을 선택한 경우 `O`
        2. 이동할 수 없는 칸을 선택한 경우 `X`
        3. 선택하지 않은 칸은 공백 한 칸

    * 출력 예시
      ```
      [ O | X ]
      [   |   ]
      ```


6. 성공 여부 확인
    * 성공 조건: 다리 끝까지 이동할 수 있는 칸을 선택한 경우 → 8번


7. 실패 여부 확인
    * 실패 조건: 이동할 수 없는 칸을 선택한 경우 → 9번


8. 성공했을 경우
    1. 게임 종료 문구 출력 (10번, 게임 성공 여부 : 성공)
    2. 프로그램 종료


9. 실패했을 경우
    1. 재시작 여부 입력받기
        * 출력: `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n`
        * 사용자 입력: `R`(재시작) 또는 `Q`(종료)
    2. R를 입력한 경우 → 3번 (다리 건너기 게임 처음부터 다시 시작)
    3. Q를 입력한 경우
        1. 게임 종료 문구 출력 (10번, 게임 성공 여부 : 실패)
        2. 프로그램 종료


10. 게임 종료 문구 출력
    1. 현재까지 건넌 다리 출력 (5번 메소드 호출)
    2. 게임 성공 여부 출력
    3. 총 시도한 횟수 출력

    * 출력 예시
      ```
      최종 게임 결과
      [ O | X ]
      [   |   ]
    
      게임 성공 여부: 실패
      총 시도한 횟수: 1
      ```

---

### 패키지와 클래스 구조

* package: `bridge` - root
    * class: **Application**
        * method: main
            1. GameManager 생성
            2. 게임 초기화 (GameManager.startBridgeGame()) 호출)
            3. 게임 실행 (GameManager.playBridgeGame() 호출)
    *

    * class: **BridgeMaker** - 다리를 생성해주는 역할
        * method: makeBridge - 입력받은 길이에 해당하는 다리 생성
    *

    * class: **BridgeRandomNumberGenerator** - 다리 생성을 위한 난수를 생성해주는 역할
        * method: generate - 난수 생성 (0 또는 1)
    * interface: **BridgeNumberGenerator**
    *

    * package: `game`
        * class: **GameManager** - 게임 진행자, 사용자와 게임을 이어주는 매개체
            * fields
                * User 객체
                * BridgeGame 객체
            * methods
                * startBridgeGame - 게임 초기화
                    1. setBridgeSize - 사용자가 입력한 다리의 길이 값 반환
                    2. makeBridge - 다리 생성
                * playBridgeGame - 게임 진행
                    1. moveUser - 사용자 칸 이동
                        * setUserMoveDirection - 사용자가 입력한 이동할 칸 값 반환
                    2. printBridge_userMove - 현재까지 건넌 다리 출력 (OutputView.printMap() 호출)
                    3. isEndOfTheGame - 게임 종료 여부 확인
                        * isGameSucceed - 게임 성공 여부 확인
                        * isGameFailed - 게임 실패 여부 확인
                        * isQuitOfTheGame - 사용자가 게임 종료를 입력하였는지 여부 확인
                            * setGameCommand - 사용자가 입력한 gameCommand 반환
                    4. retryGame - 게임 재시작을 위한 상태값 변경
                    5. printGameResult - 게임 종료 문구 출력
        *
        * class: **BridgeGame** - 다리 건너기 게임을 관리
            * fields
                * bridge_answer - 정답 다리
                * bridge_userMove - 사용자가 다리 상에서 이동한 위치를 저장 (List)
                * enum BridgeShape - 다리 모양의 숫자 값(0, 1), 문자 값("U", "D") 저장
            * methods
                * getter
                    * getBridge_answer - 정답 다리 List 반환
                    * getBridge_userMove - 사용자의 다리 상 이동 위치 List 반환
                * setter
                    * setBridgeAnswer - 정답 다리 값 저장
                * move - 사용자의 다리 칸 이동
                * checkIfGameIsSucceed - 게임 성공 여부 확인
                * checkIfGameIsFailed - 게임 실패 여부 확인
                * retry - 게임을 다시 시도하기 위해 bridge_userMove 초기화
    *

    * package: `user`
        * class: **User** - 사용자의 상태를 관리
            * fields
                * userGameStatus - 게임 진행 상태 (enum GameStatus의 값을 저장)
                * numberOfMoves - 게임 중 이동한 횟수
                * numberOfGameTrials - 게임 총 시도 횟수
                * enum GameStatus - 게임 진행 상태값(PLAYING - 0, SUCCEED - 1, FAILED - 2) 저장
                * enum GameCommand - gameCommands 값(RETRY - R, QUIT - Q) 저장
            * methods
                * getter
                    * getUserGameStatus
                    * getNumberOfMoves
                    * getNumberOfGameTrials
                * setter
                    * setUserGameStatus_succeed - 게임 진행 상태를 성공으로 변경
                    * setUserGameStatus_failed - 게임 진행 상태를 실패로 변경
                * increaseNumberOfMoves - 게임 중 이동한 횟수 1회 증가
                * increaseNumberOfGameTrials - 게임 총 시도 횟수 1회 증가
                * resetNumberOfMoves - 게임 중 이동한 횟수 초기화
    *

    * package: `view` - console I/O
        * class: **InputView** - 사용자로부터 입력을 받는 역할, 입력 예외처리
            * methods
                * readBridgeSize - 다리의 길이 입력받기
                    * checkBridgeSize_regex - 정규식에 부합하는지 확인 (숫자 입력)
                    * checkBridgeSize_value - 입력값 범위 확인 (3 ~ 20)
                * readMoving - 사용자가 이동할 칸 입력받기
                    * checkUserMoveDirection_regex - 정규식에 부합하는지 확인 (D 또는 U 입력)
                * readGameCommand - 게임을 다시 시도할지 종료할지 여부 입력받기
                    * checkUserGameCommand_regex - 정규식에 부합하는지 확인 (R 또는 Q 입력)
        *
        * class: **OutputView** - 사용자에게 게임 진행 상황과 결과를 출력하는 역할
            * methods
                1. 평문
                    * printGameStartMessage
                2. 질문
                    * askBridgeSize
                    * askUserMoveDirection
                    * askGameCommand
                3. 에러 메세지
                    * printErrorMessage_bridgeSize
                    * printErrorMessage_userMoveDirection
                    * printErrorMessage_gameCommand

                * printMap - 현재까지 이동한 다리의 상태 출력
                    * setUserFootprint - 사용자의 이동 발자취 반환
                        * footprint_userMovedToAble - 사용자가 이동할 수 있는 칸을 선택한 경우의 발자취 반환
                        * footprint_userMovedToDisable - 사용자가 이동할 수 있는 칸을 선택한 경우의 발자취 반환
                    * setBridgeBoundary - 현재 보는 칸이 다리의 마지막 칸일 경우 끝(])을 명시 / 아닐 경우 구분선(|)을 명시
                * printResult - 게임의 최종 결과 출력
                    * setGameStatusMessage - 게임 성공 또는 실패 여부에 따른 String 반환

---

### 테스트 코드

1. BridgeGameTest
    * move - 사용자의 다리 칸 이동위치 저장 확인
        1. 아래 칸 (D)
        2. 위 칸 (U)
    * checkIfGameIsSucceed - 게임 성공 여부를 제대로 확인하는가?
        1. 게임 성공 확인
        2. 게임 미성공 확인
    * checkIfGameIsFailed - 게임 실패 여부를 제대로 확인하는가?
        1. 게임 실패 확인
        2. 게임 미실패 확인
    * retry - 게임 재시작 시 초기화 확인

2. BridgeMakerTest
    * makeBridge - 다리 생성 확인


3. UserTest
    * increaseNumberOfMoves - 이동 횟수 증가 확인
    * increaseNumberOfGameTrials - 게임 총 시도 횟수 증가 확인
    * resetNumberOfMoves - 이동 횟수 초기화 확인


4. InputViewTest
    * readBridgeSize - 다리의 길이 입력
        1. 정상 입력 (3 ~ 20 숫자)
        2. 예외처리 확인
    * readMoving - 사용자가 이동할 칸 입력
        1. 정상 입력 (U 또는 D)
        2. 예외처리 확인
    * readGameCommand - 사용자의 게임 재시작 또는 종료 여부 입력
        1. 정상 입력 (R 또는 Q)
        2. 예외처리 확인


5. OutputViewTest
    * printMap - 현재까지 이동한 다리의 상태 출력 확인
        1. 이동할 수 있는 칸을 선택한 경우 (O 출력)
        2. 이동할 수 없는 칸을 선택한 경우 (X 출력)
    * printResult - 현재까지 이동한 다리의 상태 출력 확인
        1. 게임 성공 여부: 성공
        2. 게임 성공 여부: 실패

---