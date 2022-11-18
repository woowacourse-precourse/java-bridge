## 의존 관계 다이어그램

![image](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/371d9afa-08eb-44f8-a18c-68c224fef078/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221117%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221117T064758Z&X-Amz-Expires=86400&X-Amz-Signature=5c706a240e9c7c48efdc597c9cec8dad6f7f89972e6b20a061f2439b2e34b75b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject)

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

### [] BidgeRepository

- [] 다리의 변경 상태를 관리

### [] BridgeNumberGenerator

- 인터페이스 : 번호 생성

### BridgeRandomNumberGenerator

- BridgeNumberGenerator 구현체
- 0과1중 랜덤값 생성

### [] BridgeMaker

- BridgeNumberGenerator에 의존
- makeBridge : 입력 수의 길이로 다리 생성
- 재사용 : 게임 재시작시 사용된다
- 위칸이면 U, 아래칸이면 D 표현

---

## 영속성 계층

### [] GameEntity

- [] GameRepository 구현

### [] BridgeEntity

- [] GameRepository 구현

---

## 🚀 기능 요구 사항

위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.

- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
    - [] 다리는 왼쪽에서 오른쪽으로 건너야 한다.
    - [] 위아래 둘 중 하나의 칸만 건널 수 있다.
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
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌`IllegalArgumentException`,`IllegalStateException`등과 같은 명확한 유형을 처리한다.