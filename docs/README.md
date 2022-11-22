## 기능 목록 
![image](https://www.notion.so/795b281f263d491faa3b7fb4007e2ea8#290f3f6e34474ac1a7e07f40ae2f23e8)
1. [test pass] FrontController는 다리 길이를 입력 받는다.
2. [test pass] FrontController는 생성된 다리를 BridgeEntity에 할당한다. / BridgeMaker, BridgeEntity [o]
3. [test fail] FrontController는 BridgeEntity 내용을 통해 BridgeGame을 진행한다.
4. [test fail] FrontController는 사용자 이동을 입력 받는다.
5. [test fail] FrontController는 BridgeGame의 변경 내용을 BridgeEntity로 저장한다.
6. [test fail] FrontController는 성공 / 실패가 나올 때까지 이동을 입력받는다.
   1. 사용자가 실패 시 재시도 / 종료를 입력받는다.
7. [test fail] FrontController는 변환된 문자열을 return한다.
8. [test fail] Application은 FrontController를 호출해서 실행한다.


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
