# 기능 목록

- [x] 다리 생성

  - [x] 다리 길이 입력 받기 - `readBridgeSize()`
  - [x] 다리 만들기 - `makeBridge()`
  
- [x] 플레이어 생성 - `makePlayer()`

  

- [ ] 게임 진행

  - [x] 다리 건너기 게임 생성 - `makeBridgeGame()`

  - [ ] 게임이 끝날 때까지 반복

    - [x] 이동할 칸 입력 받기 - `readMoving()`

    - [x] 움직이기 - `move()`

    - [x] 게임 진행 상황 출력 - `printMap()`

    - [ ] 실패 시, 재시도 여부 입력 받기
      - [x] 재시도 - `retry`

- [x] 게임 결과 출력 - `printResult()`



### 예외 처리

- 공통

  - [x] [ERROR]로 시작하는 에러 메시지 출력

  - [x] 다시 입력 받기

    

- [x] 다리 길이
  - [x] 다리 길이는 숫자여야 한다. - `validateNumber`
  - [x] 다리 길이는 3부터 20 사이의 자연수여야 한다. - `validateRange`
- [x] 플레이어의 커맨드
  - [x] 이동하기
    - [x] 이동은 U, D로 가능하다. - `validate`
  - [x] 재시작
    - [x] 재시작은 R, 종료는 Q로 가능하다.





# 구조

<img width="705" alt="image" src="https://user-images.githubusercontent.com/79066049/203065841-0a016b4a-e5aa-44be-8dec-40175487fdfc.png">



### Bridge

위(U), 아래(D)로 이루어진 다리

### Player

다리 건너기 게임을 플레이하는 Player.

- Move(bridge, command)
  - bridge에서, command에 따라 이동한다.
- retry()
  -  재시도한다.

### BridgeGame

다리 건너기 게임을 관리한다. Bridge와 Player를 인스턴스 변수로 갖는다.



### InputView, Validator

사용자 입력을 받는다.

- readBridgeSize() - BridgeSizeValidator
- readMoving() - MovingValidator
- readGameCommand() - GameCommandValidator

### OutputView

게임 진행 상황과 결과를 출력한다.

- printMap
- printResult



### BridgeService

BridgeGame을 실제로 service한다.

InputView, OutputView, BridgeGame을 엮어 조립한다.