# 미션 - 다리 건너기

## 기능 목록
- [x] 다리를 관리하는 클래스 - Bridge
  - 현재 위치가 어디인지 인스턴스 변수로 저장
  - [x] 다리에서 위치를 이동했을 때 메소드 구현 - Bridge#move
  - [x] 다리의 상태를 출력할 수 있는 메소드 구현 - Bridge#toString
    - [x] 클래스 분리 - BridgeOutputView
- [x] 다리를 건너는 게임을 총괄적으로 관리하는 클래스 - BridgeGame
  - [x] 사용자가 칸을 이동할 때 사용하는 메서드, 칸을 이동하고 게임 상태를 반환받는다. - BridgeGame#move
  - [x] 사용자가 게임을 다시 시도할 때 사용하는 메서드 - BridgeGame#retry
    - [x] RetryState 열거형으로 상태 표현
  - [x] 게임을 처음 시작하고 사용자의 입력에 따라 다리 상태 변화, 출력, 재시도 여부를 진행하는 메소드 구현 - BridgeGame#proceed
- [x] 입력으로 다리의 길이를 받고 그에 따른 랜덤한 다리를 생성해야 한다. - BridgeMaker
  - [x] 다리의 길이를 매개변수로 받고 다리 모양이 위 칸이면 U, 아래 칸이면 D인 List를 반환한다 - BridgeMaker#makeBridge
- [x] 다리 모양을 랜덤으로 생성할 때 필요한 0과 1 중 랜덤으로 선택하는 인터페이스 필요 - BridgeNumberGenerator
  - [x] 구현체로 BridgeRandomNumberGenerator 선택 - BridgeRandomNumberGenerator
  - [x] BridgeMaker의 생성자에서 구현체를 넣어줄 수 있다.
- [x] 사용자로부터 입력받는 역할을 하는 클래스 필요 - InputView
  - [x] 다리의 길이를 입력받는다. - InputView#readBridgeSize
  - [x] 사용자가 이동할 칸을 입력받는다. - InputView#readMoving
  - [x] 게임을 다시 할지 말지 여부를 입력받는다 - InputView#readGameCommand
- [x] 사용자에게 게임 진행 상황과 결과를 알려주는 클래스 필요 - OutputView
  - [x] 다리의 상태를 출력한다. - OutputView#printMap
  - [x] 게임의 최종 결과를 출력한다. - OutputView#printResult

## 입출력 요구사항
### 입력
- [x] 다리 길이를 입력받을 때 3 이상 20 이하의 숫자를 입력받음. 올바른 값이 아니면 예외 처리
- [x] 라운드마다 플레이어가 이동할 칸을 입력받는다. 이 때 U와 D 문자 중 하나여야 하며 이 이외의 값이라면 예외 처리
- [x] 게임 재시작/종료 여부를 입력받는다. R과 Q 문자 중 하나여야 하며 이 이외의 값이라면 예외 처리
### 출력