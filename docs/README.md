### 1차 설계 구조
![img.png](img.png)

# 구현 기능 목록

## View
- [X] Enum 으로 메시지 상수 구현
- [X] OutputView 에 게임 시작 메시지 출력 메서드 구현
- [X] InputView 에 다리 길이 입력 메서드 구현
- [X] InputView 에 이동할 칸 선택 메서드 구현
- [X] OutputView 에 printMap 구현
- [X] OutputView 에 printResult 구현

## Model
- [X] Player 모델 구현
  - [X] position 필드를 가짐
  - [X] 도착 여부를 확인할 수 있는 `boolean checkEnd(int endPosition)` 메서드를 가짐

## Controller
- [X] U와 D로 이루어진 다리 List 를 리턴하는 메서드 구현
- [X] 게임 프로세스 메서드 구현
  - [X] ~~입력 받은 문자와 일치 할 경우~~ 움직이는 `move` 메서드를 호출
  - [X] 입력 받은 문자와 일치하지 않는 경우 재시작 여부 확인하는 메서드 구현
    - [X] 재시작할 경우 `retry` 메서드 호출
  - [X] 반복문으로 플레이어가 목적지에 도착하지 않은 경우 계속 반복
  - [X] 플레이어가 목적지에 도착한 경우 `printResult` 호출

# 예외 처리
## 입력값 처리
- [X] 빈값을 입력한 경우 예외 처리
- [X] 요구되지 않는 값 입력시 예외 처리

# 테스트 코드
## 입력값 테스트
- [X] 정상적인 값 입력시 예외 처리 없지 진행 확인
- [X] 예외 케이스 입력시 예외 처리 확인
  - [X] 빈칸 입력 시
  - [X] 숫자 입력 요구인데 문자 입력 시
    ~~- [ ] 음수나 0 입력 시~~
  - [X] 문자 입력 요구인데 숫자 입력 시
    - [X] 요구 문자가 아닌 다른 문자 입력 시
  - [X] 한 값이 아닌 여러 값 입력 시
## 비즈니스 모델 테스트
- [X] 정상 테스트 확인
- [X] 다리를 못건너는 경우 종료 확인
~~- [ ] 게임 완료 시 재시작 묻는지 확인~~
~~- [ ] 게임 종료 메시지 출력 확인~~
## 단위 테스트
- [X] 다리 정상 생성 확인
- [X] move 시 정상적으로 올라가는지 확인

# 최종 클래스 구조

![img_1.png](img_1.png)

* domain
  * BridgeController
    * BridgeGame 을 조작하는 클래스
    * io 을 관리한다
  * BridgeGame
    * 게임을 조작하는 클래스
  * BridgeGameCheck
    * 게임 상태를 확인하는 클래스
  * BridgeMap
    * 다리 문자열을 관리하는 클래스
* enums
  * BridgeFrame
    * 다리 출력시 필요한 문자들의 대한 enum
  * Constant
    * private static final 변수에 대한 enum
  * Message
    * 출력되어야 하는 문자열을 관리하는 enum
  * UpDown
    * 위, 아래에 관한 값들을 관리하는 enum
* io
  * InputNumValidator
    * 숫자 입력값 검증에 대한 클래스
  * InputStringValidator
    * 문자 입력값 검증에 대한 클래스
  * InputView
    * 입력을 담당하는 클래스
  * OutputView
    * 출력을 담당하는 클래스