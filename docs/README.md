## 기능 재정의
- 게임을 시작한다.
- 사용자가 3~20 사이의 다리의 길이를 입력한다.(잘못된 값일 경우 예외 처리) / InputView
- 입력된 만큼의 길이의 다리를 위 or 아래 칸으로 생성한다. / BridgeMaker
  - 0과 1로 이루어진 랜덤 수 생성을 통해 위 or 아래 중 건널 수 있는 칸이 무작위로 정해진다. / BridgeNumberGenerator
- 사용자가 위/ 아래를 선택자를 입력한다. / InputView
- 0부터 1칸씩 칸을 이동한다. / BridgeGame
  - 건널 수 있는 칸이면 O, 없는 칸일 경우 X를 표현한다. / Expression
  - X칸으로 이동했을 경우 사용자에게 재시작 or 종료 여부를 입력받는다. (잘못된 값일 경우 예외 처리) / BridgeGame, InputView
  - 게임을 재시작할 경우 다리를 재사용한다. / BridgeRepository
- O칸으로 이동했을 경우 다음 라운드를 진행한다. / BridgeGame, InputView
- 마지막까지 O칸을 선택하면 게임 종료 / BridgeGame, InputView
- 게임 종료시 성공 여부와 시도 횟수를 출력한다. / OutputView

- 

## 의존 관계 다이어그램

![image](https://velog.velcdn.com/images/urtimeislimited/post/99eadb5a-8ab1-4da5-9954-c8ee3d8e281d/image.png)

1. UI 계층은 공통 처리자(FrontController)를 통해 도메인 계층을 의존한다.
2. 도메인 계층은 레포지토리 인터페이스를 통해 영속성 계층과의 결합도가 높아지는 것을 방지한다.
3. 영속성 계층은 도메인에서의 처리 상태를 별도로 보관한다.
---

## UI 계층

### InputView : 사용자로부터 입력을 받는 역할

- readBridgeSize : 다리 길이 입력 책임
- readMoving : 사용자가 입력할 칸 책임
- readGameCommand: 재시작 or 종료 입력 책임

### OutputView : 게임 진행 상황 / 결과 출력

- printMap :  현재까지 이동한 다리의 상태 출력
- printResult : 게임 최종 결과 출력 (성공 여부)

### [] 예외 발생 :

- 사용자 잘못된 값 입력할 경우 IllegalArgumentException 발생 // [ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.
- "[ERROR]"로 시작하는 에러 메시지를 출력
- 그 부분부터 입력을 다시 받는다.

---

## 도메인 계층

### [] FrontController

- BridgeGame과 BridgeMaker 보유

### [] BridgeGame

- [test pass] move : 칸 이동
- [test pass] retry : 게임 재시도

### [] GameRepository

- [] 게임 시도 회수의 변경 상태를 관리

### [] BridgeRepository

- [] 다리의 변경 상태를 관리

### [test fail] BridgeNumberGenerator

- 인터페이스 : 번호 생성

### BridgeRandomNumberGenerator

- BridgeNumberGenerator 구현체
- 0과1중 랜덤값 생성

### [test fail] BridgeMaker

- BridgeNumberGenerator에 의존
- makeBridge : 입력 수의 길이로 다리 생성
- 재사용 : 게임 재시작시 사용된다
- 위칸이면 U, 아래칸이면 D 표현

---

## 영속성 계층

### [] GameRepositoryImpl

- [] GameRepository 구현

### [] BridgeRepositoryImpl

- [] GameRepository 구현

---
