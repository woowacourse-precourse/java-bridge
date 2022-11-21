## 객체 생성 / 소멸 주기
![image](https://www.notion.so/795b281f263d491faa3b7fb4007e2ea8#290f3f6e34474ac1a7e07f40ae2f23e8)
1. []OutputView에서 게임 시작 안내 문구를 출력한다.
2. []InputView에서 사용자에게 다리 길이를 입력 받는다.
3. []입력자를 통해 FrontController에서 BridgeMaker를 생성한다.
4. []생성된 BridgeMaker의 값을 BridgeGame에 전달하여 게임 진행을 연산한다.
5. []BridgeGame은 GameRepository를 통해 GameEntity의 변경되는 GameEntity의 상태를 관리한다.
6. []GameEntity의 현재 상태를 FrontController에게 전달한다.
7. []FrontController는 결과 메시지를 OutputView 기능을 사용해 Application에 전달한다.


## 기능 재정의
- 게임 안내문구를 출력한다. / OutputView
- 사용자가 3~20 사이의 다리의 길이를 입력한다.(잘못된 값일 경우 예외 처리) / InputView, Exception
- 입력된 만큼의 길이의 다리를 위 or 아래 칸으로 생성한다. / BridgeMaker
  - 0과 1로 이루어진 랜덤 수 생성을 통해 위 or 아래 중 건널 수 있는 칸이 무작위로 정해진다. / BridgeNumberGenerator
- 이동할 칸 안내 문구를 출력한다. / OutputView
- 사용자가 위/ 아래 선택자를 입력한다. / InputView, Exception
- 이동 상태가 O 또는 X로 변환되어 출력된다. / GameEntity, FrontController
- O일 경우 입력자를 반복 한다. / InputView, Exception
- X일 경우 게임 '재시작 | 종료' 여부 출력 / OutputView, GameEntity
  - R인 경우 입력자 반복
  - Q인 경우 게임 상태 출력
    - 게임 결과, 게임 성공 여부, 게임 시도 횟수

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
