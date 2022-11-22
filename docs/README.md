# 👣 [다리 건너기] DOCS
- [기능 요구 사항](#-기능-요구-사항)
- [예외 처리](#-예외-처리)
- [프로그램 요구 사항](#-프로그래밍-요구-사항)
- [최종 시스템](#-최종-시스템)


## 🚀 기능 요구 사항
### User
- 다리의 길이를 입력
  - 숫자 타입 확인
  - 3 - 20 범위 확인
- 이동할 위치 입력
  - 'U' || 'D' 이외의 문자 예외 처리
- 실패했을 경우 게임 종료 여부 입력
  - 'R' || 'Q' 이외의 문자 예외 처리

### System
- 입력받은 다리 길이만큼 랜덤 값 생성
  - 값은 'U' || 'D' 로 구성
- 입력받은 이동 위치에 따라 이동 여부 판단
  - 'U' -> 1
  - 'D' -> 0
  - __Enum 타입으로 'U', 'D' 정의__
- 입력받은 이동 위치가 이동 불가 위치인 경우 게임 종료 여부 출력
- 최종 결과 출력
  - 건너지 않은 다리가 존재할 경우 최종 상태값은 `실패`
  - 모든 다리를 건넜을 경우 최종 상태값은 `성공`
  - 총 시도 횟수 -> 게임 재시도 횟수 + 1(최초 실행)

## 🚨 예외 처리
> 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.<br>
> `[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.`

### Enum 요소
- ERROR_BRIDGE_LENGTH(`[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.`)
- ERROR_MOVING(`[ERROR] 이동 가능한 방향은 위쪽('U'), 아래쪽('D') 입니다.`)
- ERROR_RETRY(`[ERROR] 게임 종료 여부를 위한 입력값이 잘못되었습니다.`)

## 🎯 프로그래밍 요구 사항
> - indent depth 3 미만
> - 3항 연산자 사용 불가
> - else 예약어 사용 불가
> - 함수 길이 10라인 이하
> - 메서드의 파라미터 개수 3개 이하
> - `BridgeGame` 클래스에서 `InputView`, `OutputView` 사용 금지

## ✏️ 최종 시스템
### Application `Main`
- __main__
- __crossTheBridge__: 종료 트리거가 발생할 때까지 다리 건너기 게임을 실행

### BridgeGame `Class`
- __move__: 입력받은 방향에 따라 다리 건너기 현황을 update
- __retry__: 입력한 종료 트리거에 따라 게임의 종료 여부 판단
- __startGame__: 입력받은 다리 길이만큼 임의의 다리를 생성
- __checkArrive__: 사용자가 다리의 마지막에 도달했는지 확인
- __increaseBridgeIndex__: 사용자가 move할 때마다 사용자가 위치하고 있는 다리의 인덱스 update
- __resetBridgeIndex__: 게임 재시작을 할 경우 사용자가 위치하고 있는 다리의 인덱스 초기화
- __getGameData__: 게임 데이터 반환

### BridgeMaker `Class`
- __makeBridge__: 입력받은 다리 크기만큼 'U'과 'D'로 이루어진 List를 반환

### BridgeNumberGenerator `Interface`
- `@FunctionalInterface`

### Direction `Enum`
- `U(1)`, `D(0)`
- __nameOf__: 입력받은 value에 따라 Enum name을 반환
- __getDirectionValue__: Enum value 반환

### Error `Enum`
- `ERROR_BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.")`
- `ERROR_MOVING("[ERROR] 이동 가능한 방향은 위쪽('U'), 아래쪽('D') 입니다.")`
- `ERROR_RETRY("[ERROR] 게임 종료 여부를 위한 입력값이 잘못되었습니다.")`
- __getErrorMessage__: Enum value 반환

### GameData `Class`
- `LinkedList topStatus`: 다리의 위쪽 부분 현황
- `LinkedList bottomStatus`: 다리의 아래쪽 부분 현황
- `List bridge`: 생성한 다리
- `int totalTry`: 총 시도 횟수
- __getTopStatus__: 다리의 위쪽 부분 현황 반환
- __getBottomStatus__: 다리의 아래쪽 부분 현황 반환
- __setBridge__: 게임에 사용할 다리 설정
- **getBridge**: 게임에 사용되는 다리 반환
- **getTotalTry**: 총 시도 횟수 반환
- **clearStatus**: 다리의 현황 초기화
- **updateStatus**: 사용자가 움직인 위치에 따라 다리의 현황 update
- **increaseTotalTry**: 총 시도 횟수 증가

### InputView `Class`
- **readBridgeSize**: 다리의 길이를 입력 받음
- **validateBridgeSizeRange**: 입력한 숫자가 3과 20 사이의 숫자가 아닐 경우 `IllegalStateException` 반환
- **readMoving**: 이동할 위치 입력 받음
- **validateMovingDirection**: 'U'와 'D'가 아닌 다른 문자일 경우 `IllegalStateException`을 반환
- **readGameCommand**: 게임 종료 여부를 입력 받음
- **validateGameCommand**: 'R'과 'Q'가 아닌 다른 문자일 경우 `IllegalStateException`을 반환

### OutputView `Class`
- **printMap**: 현재 다리 건너기 진행 현황을 출력
- **printResult**: 최종 게임 결과를 출력

***

### ApplicationTest `Main`

### BridgeGameTest
> {"U", "D"}인 bridge를 `@BeforeAll`로 생성 후 테스팅
- **moveBridge**: 입력받은 이동 방향에 따라 'O', 'X'를 반환하는 기능을 테스트
- **retryGame**: 입력받은 종료 여부에 따라 true, false를 반환하는 기능을 테스트

### BridgeMakerTest
> 길이 10을 갖는 랜덤 다리 `@BeforeAll`로 생성하고 테스트를 진행
- **createRandomBridge**: 생성된 다리가 설정한 길이에 부합하는지 테스트
- **checkRandomBridgeElement**: 다리가 'U'와 'D'로만 이루어져있는지 테스트

### GameDataTest
- **refreshGameStatus**: 게임을 재시작할 경우 게임 데이터 중 사용자의 현황이 알맞게 초기화 되는지 테스트
- **checkRetryCount**: 게임을 재시작할 경우 총 시도 횟수가 증가되는지 테스트
- **updateGameStatus**: 이동 결과에 따라 사용자의 현황이 알맞게 업데이트 되는지 테스트

### InputViewTest
- **wrongBridgeSize**: 다리 길이가 숫자 타입이 아니거나 3-20 사이의 숫자가 아닌 경우 오류가 발생하는지 테스트
- **correctBridgeSize**: 다리 길이가 3-20 사이의 숫자인 경우 알맞게 동작하는지 테스트
- **wrongDirection**: 이동 방향이 'U' 혹은 'D'가 아닌 경우 오류가 발생하는지 테스트
- **correctDirection**: 이동 방향이 'U' 혹은 'D'인 경우 알맞게 동작하는지 테스트
- **wrongGameCommand**: 게임 종료 여부가 'R' 혹은 'Q'가 아닌 경우 오류가 발생하는지 테스트
- **correctGameCommand**: 게임 종료 여부가 'R' 혹은 'Q'인 경우 알맞게 동작하는지 테스트

### OutputViewTest
> 사용자의 현황과 output 스트림을 `@BeforeAll`로 설정하고 테스트를 진행
- **printCurrentGameStatus**: 임의로 설정한 사용자의 현황에 맞는 값을 출력하는지 테스트