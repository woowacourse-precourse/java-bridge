# 구현할 기능 목록
```
[폴더 구조]
- Application.java
- run.java (게임 진행)
- BridgeGame.java (게임 진행에 필요한 기능)
- BridgeMaker.java (입력받은 길이만큼의 다리를 생성)
- BridgeNumberGenerator.java (인터페이스)
- BridgeRandomNumberGenerator.java (인터페이스 구현)

- constant
    - ErrorMessage.java (에러 메세지 상수)
    - GameCommand.java (RETRY와 QUIT을 의미하는 상수 String R과 Q를 저장하는 enum 클래스)
    - Moving.java (UP과 DOWN을 의미하는 상수 String U와 D를 저장하는 enum 클래스)
    - PrintMessage.java (출력문 상수)
    - SuccessFail.java (SUCCESS와 FAIL을 의미하는 상수 String "성공"과 "실패"를 저장하는 enum 클래스)
- validation
    - Validation.java (사용자의 입력에 대한 유효성 검사)
- view
    - InputView.java (다리 길이, 이동할 칸, 다시시도or종료 여부 입력받음)
    - OutputView.java (현재까지 이동한 다리 상태, 게임 최종 결과 보여줌)    
```

---

- [x] 다리 길이 입력받기
- [x] 다리 건너기 게임 진행
  - [x] 이동할 칸 선택
  - [x] 현재 상태 출력
  - [x] 잘못된 선택을 했을 경우(실패) 재시도vs종료 물어보고
    - [x] 재시도를 선택했다면 동일한 다리로 다시 게임 진행
    - [x] 종료를 선택했다면 게임 최종 결과 출력
  - [x] 성공했다면 게임 최종 결과 출력
- [x] 게임 종료 시 게임 최종 결과 출력

---
## BridgeMaker
* [x] 입력받은 길이만큼의 다리를 생성 (U 또는 D로 이루어진 String List)
    * [x] 랜덤으로 뽑은 정수 1 또는 0을 U 또는 D로 바꿔서 리스트에 저장
    * [x] 1과 U, 0과 D는 enum 활용

## BridgeGame
* [x] 인스턴스 변수
  * [x] bridge (생성된 다리)
  * [x] player (사용자가 선택한 이동 (U, D) 저장)
  * [x] upBridge (위쪽 다리의 현재 상태 (O, , X))
  * [x] downBridge (아래쪽 다리의 현재 상태 (O, , X))
* [x] 사용자가 칸을 이동할 때 사용하는 메서드 존재
* [x] 게임을 다시 시도할 때 사용하는 메서드 존재
* [x] 성공인지 실패인지 판단 (isSuccess() 메서드)
* [x] 다리 끝까지 갔는지 판단 (isFinish() 메서드)
* [x] 올바른 다리를 선택했는지 판단 (isAlive() 메서드)

## Run
* [x] 인스턴스 변수: 총 시도한 횟수
* [x] 게임을 진행시킴
* [x] 게임 진행에 필요한 값을 입력받을 때 InputView 클래스 이용하고, 잘못된 값 입력으로 인해 Validation에서 던진 예외를 잡아서 처리하고 다시 입력할 수 있도록 함
  1. [x] 1.Bridge 생성
  2. [x] 2.게임 종료한다고 할때까지 playOneSet (동일한 Bridge에 대한 게임 한 세트) 진행
     1. [x] 이동할 칸 입력받아서 이동
     2. [x] 성공이면 게임 종료
     3. [x] 실패면 재시작할건지 종료할건지 물어보고 대답에 맞게 진행

---

## Validation
* [x] 다리의 길이는 3 이상 20 이하의 숫자만 입력 가능 (BRIDGE_SIZE_ERROR)
* [x] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력 가능 (MOVING_ERROR)
* [x] 게임 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자만 입력 가능 (GAME_COMMAND_ERROR)

---

## InputView
* [x] 다리의 길이를 입력받는다.
  * [x] 유효성 검사해서 잘못된 값이면 예외 던지기
* [x] 사용자가 이동할 칸을 입력받는다.
  * [x] 유효성 검사해서 잘못된 값이면 예외 던지기
* [x] 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
  * [x] 유효성 검사해서 잘못된 값이면 예외 던지기

## OutputView
* [x] 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
* [x] 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
  * [x] 이동한 다리 상태(BridgeGame 클래스의 upBridge와 downBridge)를 정해진 형식에 맞춰 출력
  * [x] 게임 성공 여부 출력
  * [x] 총 시도한 횟수 출력