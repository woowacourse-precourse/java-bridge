# 구현할 기능 목록
```
[폴더 구조]
- Application.java
- constant
    - ErrorMessage.java (에러 메세지 상수)
    - PrintMessage.java (출력문 상수)
    - Updown.java (UP과 DOWN을 의미하는 상수 String U와 D를 저장하는 enum 클래스
- validation
    - Validation.java (사용자의 입력에 대한 유효성 검사)
- view
    - InputView.java (다리 길이, 이동할 칸, 다시시도or종료 여부 입력받음)
    - OutputView.java (현재까지 이동한 다리 상태, 게임 최종 결과 보여줌)
- 미정
    - Bridge.java (생성된 다리)
    - BridgeGame.java 
    - BridgeMaker.java (입력받은 길이만큼의 다리를 생성)
    - BridgeNumberGenerator.java (인터페이스)
    - BridgeRandomNumberGenerator.java (인터페이스 구현)
```
---

- [X] 다리 길이 입력받기
- [ ] 다리 건너기 게임 진행
  - [ ] 이동할 칸 선택
  - [ ] 현재 상태 출력
  - [ ] 잘못된 선택을 했을 경우 재시도할건지 물어보기
- [ ] 게임 종료 문구 출력

---
## BridgeMaker
* [x] 입력받은 길이만큼의 다리를 생성 (U 또는 D로 이루어진 String List)
    * [x] 랜덤으로 뽑은 정수 1 또는 0을 U 또는 D로 바꿔서 리스트에 저장
    * [x] 1과 U, 0과 D는 enum 활용

## Bridge
* 생성된 다리가 저장된 클래스 ("U","D"로 이루어진 String 클래스)

## Map
* 현재까지 이동한 다리의 상태가 저장된 클래스 ("O", "X"로 이루어진 String List)

## Player
* 사용자의 입력에 따라 다리 이동 및 Map 인스턴스에 저장된 다리 상태 업데이트

## BridgeGame
* 사용자가 칸을 이동할 때 사용하는 메서드 존재
* 게임을 다시 시도할 때 사용하는 메서드 존재

## Game
* 동일한 Bridge에 대한 게임 한 세트
  1. Player 인스턴스 생성해서 Map 업데이트
  2. isFinish 메소드 이용해서 Map에 x가 있거나 Bridge 끝까지 다 갔는지 확인
     1. isFinish가 false면 1~2 반복
     2. isFinish가 true면 Run 인스턴스로 돌아감

## Run
* 인스턴스 변수: 총 시도한 횟수
* 인스턴스 변수: 생성한 Bridge
* 게임을 진행시킴
  1. Bridge 생성
  2. 게임 종료한다고 할때까지 Game 클래스 (동일한 Bridge에 대한 게임 한 세트)생성

---

## Validation
* 다리의 길이는 3 이상 20 이하의 숫자만 입력 가능 (BRIDGE_SIZE_ERROR)
* 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력 가능 (MOVING_ERROR)
* 게임 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자만 입력 가능 (GAME_COMMAND_ERROR)

---

## InputView
* [x] 다리의 길이를 입력받는다.
* [x] 사용자가 이동할 칸을 입력받는다.
* [x] 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.

## OutputView
* 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
* 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.