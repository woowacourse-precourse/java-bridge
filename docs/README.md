# 미션 - 다리 건너기

## 기능 목록

### 입력

- 다리의 길이를 입력하는 기능
  - 입력 값이 숫자인지 검증하는 기능
  - 입력 값이 `3 ~ 20` 사이의 숫자인지 검증하는 기능
- 이동할 칸을 입력하는 기능
  - 입력 값이 한 글자의 대문자인지 검증하는 기능
  - 입력 값이 `U` 또는 `D`인지 검증하는 기능
- 게임 재시작 유무를 입력하는 기능
  - 입력 값이 한 글자의 대문자인지 검증하는 기능
  - 입력 값이 `R` 또는 `Q`인지 검증하는 기능

### 출력

- 게임 시작 안내 문구를 출력하는 기능
- 다리 길이 입력 안내 문구를 출력하는 기능
- 이동할 칸 입력 안내 문구를 출력하는 기능
- 플레이어가 지금까지 이동한 경로를 출력하는 기능
- 게임 재시작 입력 안내 문구를 출력하는 기능
- 최종 게임 결과를 출력하는 기능
  - 플레이어의 마지막 이동 경로를 출력하는 기능
  - 플레이어 게임 성공 유무를 출력하는 기능
  - 플레이어가 게임을 시도한 횟수를 출력하는 기능
- 예외 발생 시 예외를 출력하는 기능

### 로직

- 입력한 다리 길이를 가지는 다리를 생성하는 기능
- 플레이어가 다리를 이동하는 기능
  - 플레이어가 입력한 대로 다리의 칸을 입력할 수 있는지 확인하는 기능
  - 플레이어가 다리를 모두 건넜는지 확인하는 기능
- 게임을 재시작하는 기능
  - 플레이어의 이동 경로를 초기화하는 기능
  - 플레이어의 게임 시도 횟수를 `1` 증가시키는 기능
- 예외 발생 시 예외가 발생한 단계를 다시 진행하는 기능

### 애플리케이션 진행 순서

0. 애플리케이션 시작
1. 게임 시작 안내 문구를 출력
2. 다리 길이 입력 안내 문구를 출력
3. 다리 길이 입력
4. 입력한 길이를 가지는 다리 생성
5. 이동할 칸 입력 안내 문구를 출력
6. 이동할 칸 입력
7. 플레이어가 입력한 다리의 칸으로 이동할 수 있는지 확인
   1. 플레이어가 지금까지 이동한 경로 출력
      1. 이동이 가능한 경우
         1. 다리의 끝까지 이동한 경우 `10.`으로 이동
         2. 다리의 끝까지 이동하지 않은 경우 `5.`로 이동
      2. 이동이 불가능할 시
         1. `8.`으로 이동
8. 게임 재시작 입력 안내 문구를 출력
9. 게임 재시작 유무 입력
   1. 게임을 재시작할 시
      1. 플레이어의 이동 경로 초기화
      2. 플레이어의 시도 횟수 1 증가
      3. `5.`로 이동
   2. 게임을 종료할 시
      1. `10.`으로 이동
10. 게임 결과 출력
    1. 플레이어가 마지막까지 이동한 경로 출력
    2. 플레이어의 게임 결과 출력
    3. 플레이어가 시도한 게임 횟수 출력
11. 애플리케이션 종료

## 예외 처리

- 플레이어의 잘못된 입력으로 인해 발생하는 `IllegalArgumentException` 예외의 경우 애플리케이션 정상 동작
- 플레이어의 잘못된 입력으로 발생한 예외가 아닌 애플리케이션 구성 요소에 의해 예외가 발생할 경우 애플리케이션 종료
  - `GameRunner` 에서의 예외 처리
    - `Custom Exception`이 아닌 애플리케이션 내부 예외를 처리
    - `IndexOutOfBoundsException` : 플레이어가 이동한 경로와 관련된 로직을 처리할 때 발생할 수 있는 예외
    - `NullPointerException` : `GameController`에서 `GameStatus`에 필요한 로직을 찾을 때 발생할 수 있는 예외
  - `GameController`에서의 예외 처리
    - `Custom Exception`이 발생하는 애플리케이션 내부 예외를 처리
    - `WrongGeneratorException` : 다리 생성 전략(`BridgeNumberGenerator`)이 게임 규칙과 맞지 않을 때 발생하는 예외
    - `NotFoundViewException` : `GameController`에서 존재하지 않는 `View`를 호출했을 때 발생하는 예외
    - `WrongBridgeTileException` : 플레이어 이동 경로 로그 출력 시 옳지 않은 `BridgeTile`을 지정했을 때 발생하는 예외

## 패키지 구조

### src/main/java

```
└── src
    └── main
        └── java
            └── bridge
                ├── Application.java
                ├── BridgeMaker.java
                ├── BridgeNumberGenerator.java
                ├── BridgeRandomNumberGenerator.java
                ├── GameRunner.java
                ├── controller
                │   └── GameController.java
                ├── domain
                │   ├── game
                │   │   ├── Bridge.java
                │   │   ├── BridgeGame.java
                │   │   ├── GameCommand.java
                │   │   └── BridgeTile.java
                │   └── player
                │       ├── Player.java
                │       ├── PlayerState.java                
                │       └── MovingPathHistory.java
                ├── dto
                │   ├── controller
                │   │   ├── ExitDto.java
                │   │   ├── MoveDto.java
                │   │   └── RetryDto.java
                │   ├── input
                │   │   ├── ReadBridgeSizeDto.java
                │   │   ├── ReadGameCommandDto.java
                │   │   └── ReadMovingDto.java
                │   └── output
                │       ├── PrintExceptionDto.java
                │       ├── PrintGameInfoDto.java
                │       ├── PrintMapDto.java
                │       └── PrintResultDto.java
                ├── exception
                │   ├── domain
                │   │   ├── WrongBridgeTileException.java
                │   │   └── WrongGeneratorException.java
                │   └── view
                │       └── NotFoundViewException.java
                ├── utils
                │   ├── common
                │   │   ├── BridgeConst.java
                │   │   └── CommandConst.java
                │   ├── game
                │   │   └── GameStatus.java
                │   └── message
                │       └── ExceptionMessageUtils.java
                └── view
                    ├── GuideView.java
                    ├── IOViewResolver.java
                    ├── InputView.java
                    └── OutputView.java

```

- `BridgeMaker` : 주입된 `BridgeRandomNumberGenerator`를 통해 `command`로 표현한 다리를 생성하는 클래스
- `BridgeNumberGenerator` : 다리 생성 전략에서 사용할 메소드를 정의한 인터페이스
- `BridgeRandomNumberGenerator` : `0, 1`을 랜덤하게 반환하는 `BridgeNumberGenerator` 구현체
- `GameRunner` : 다리 건너기 게임을 진행하는 유틸리티 클래스
- `controller`
  - `GameController` : `GameStatus`에 따라 `inputView`를 호출해 데이터를 입력받거나 `OutputView`를 호출해 로그를 출력하며 게임을 진행하는 클래스
- `domain`
  - `game`
    - `Bridge` : 생성된 다리를 `BridgeTile`로 관리하는 클래스
    - `BridgeGame` : 다리 건너기 게임 로직을 수행하고 그 결과를 `DTO`로 반환하는 클래스
    - `GameCommand` : 게임 재시작 유무를 선택할 수 있는 커맨드(`R, Q`)를 관리하는 `enum`
    - `BridgeTile` : 다리의 각 칸(`U, D`)를 관리하는 `enum`
  - `player`
    - `Player` : 플레이어의 정보를 괸리하고 플레이어 관련 기능을 제공하는 클래스
    - `PlayerState` : 플레이어의 현재 위치, 게임 시도 횟수 정보를 관리하는 클래스
    - `MovingPathHistory` : 플레이어의 이동 경로를 관리하는 클래스
- `dto`
  - `controller`
    - `ExitDto` : 게임 종료 시 게임 결과를 `GameController`에게 전달하는 `DTO`
    - `MoveDto` : 플레이어 이동 시 이동 결과에 따른 `GameStatus`와 이동 경로를 `GameController`에게 전달하는 `DTO`
    - `RetryDto` : 재시도 유무에 따른 `GameStatus`를 `GameController`에게 전달하는 `DTO`
  - `input`
    - `ReadBridgeSizeDto` : 플레이어가 입력한 다리 크기를 `GameController`에게 전달하는 `DTO`
    - `ReadGameCommandDto` : 플레이어가 입력한 재시도 유무 `command`를 `GameController`에게 전달하는 `DTO`
    - `ReadMovingDto` : 플레이어가 입력한 다리 이동 `command`를 `GameController`에게 전달하는 `DTO`
  - `output`
    - `PrintExceptionDto` : 플레이어 입력 관련 예외 발생 시 예외 메세지를 `OutputView`에게 전달하는 `DTO`
    - `PrintGameInfoDto` : 플레이어의 게임 시도 횟수, 게임 성공 유무에 대한 정보를 `OutputView`에게 전달하는 `DTO`
    - `PrintMapDto` : 플레이어 이동 경로에 대한 정보를 `OutputView`에게 전달하는 `DTO`
    - `PrintResultDto` : 플레이어의 게임 결과에 대한 정보를 `OutputView`에게 전달하는 `DTO`
- `exception`
  - `domain`
    - `WrongBridgeTileException` : 올바르지 않은 `BridgeTile`을 사용했을 때 발생하는 예외
    - `WrongGeneratorException` : 올바르지 않은 다리 생성 전략을 사용했을 때 발생하는 예외
  - `view`
    - `NotFoundViewException` : 존재하지 않는 `View`를 요청했을 때 발생하는 예외
- `utils`
  - `common`
    - `BridgeConst` : 다리 건너기 게임과 관련된 공통 부분을 상수로 정의한 클래스
    - `CommandConst` : 플레이어 입력과 관련된 공통 부분을 상수로 정의한 클래스
  - `game`
    - `GameStatus` : 다리 건너기 게임의 실행 상태를 관리하는 `enum`
  - `message`
    - `ExceptionMessageUtils` : 예외 메세지를 관리하는 `enum`
- `view`
  - `GuideView` : 플레이어에게 안내 문구 기능을 제공하는 `View`
  - `InputView` : 플레이어의 입력이 필요한 경우 입력 안내 문구와 플레이어의 입력을 받아 `GameController`에게 `DTO` 형식으로 전달하는 `View`
  - `IOViewResolver` : `InputView, OutputView`를 관리하는 클래스
  - `OutputView` : `GameController`로부터 `DTO`를 전달받아 플레이어에게 게임 진행 상황을 출력하는 `View`

### src/test/java

```
    └── test
        └── java
            └── bridge
                ├── ApplicationTest.java
                ├── BridgeMakerTest.java
                ├── BridgeRandomNumberGeneratorTest.java
                ├── domain
                │     ├── game
                │     │     ├── BridgeGameTest.java
                │     │     ├── BridgeTest.java
                │     │     ├── BridgeTileTest.java
                │     │     └── GameCommandTest.java
                │     └── player
                │         ├── MovingPathHistoryTest.java
                │         ├── PlayerStateTest.java
                │         ├── PlayerTest.java
                │         └── arguments
                │             └── PlayerTestArguments.java
                ├── dto
                │     ├── controller
                │     │     └── MoveDtoTest.java
                │     └── output
                │         ├── PrintGameInfoDtoTest.java
                │         ├── PrintMapDtoTest.java
                │         └── PrintResultDtoTest.java
                ├── helper
                │     ├── common
                │     │     ├── CommonBridgeField.java
                │     │     └── CommonStubBridgeGeneratorField.java
                │     └── stub
                │         ├── StubBridgeNumberGenerator.java
                │         └── StubPlayerState.java
                └── utils
                    ├── game
                    │     └── GameStatusTest.java
                    └── message
                        └── ExceptionMessageUtilsTest.java
```

- `bridge`
  - `domain`
    - `player`
      - `arguments`
        - `PlayerTestArguments` : `Player` 테스트에서 필요한 `MethodArgument static 메소드`가 정의된 클래스
  - `helper`
    - `common`
      - `CommonBridgeField` : `Bridge`가 필요한 테스트에서 공통으로 사용하는 `Default Bridge Field`가 정의된 추상 클래스
      - `CommonStubBridgeGeneratorField` : `StubBridgeGenerator`가 필요한 테스트에서 공통으로 사용하는 `Default StubBridgeGenerator`가 정의된 추상 클래스
    - `stub`
      - `StubBridgeNumberGenerator` : 생성 시 주어진 `List`의 순서대로 `generate`의 결과 값을 반환하는 테스트 전용 클래스
      - `StubPlayerState` : 생성 시 주어진 `position`으로 메소드를 실행하는 테스트 전용 클래스
