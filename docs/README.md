# 🔍 기능 목록 정의 🔍

## 1. BridgeGame

    ※ 요구 사항 ※
    1. 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
    2. BridgeGame 에 필드(인스턴스 변수)를 추가할 수 있다.
    3. BridgeGame의 패키지는 변경할 수 있다.
    4. BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
    5. 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
    6. InputView, OutputView 를 사용하지 않는다.

- 위로 갈지 밑으로 갈지 확인 하고 비교

## 2. BridgeGameManager
- Input, Output 출력 및 연결 관리

## 3. BridgeMaker

    ※ 요구 사항 ※
    1. 제공된 BridgeMaker 클래스를 활용해 구현해야 한다.
    2. BridgeMaker 의 필드(인스턴스 변수)를 변경할 수 없다.
    3. BridgeMaker 의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없다.

- 다리 길이 입력 받아서 다리를 생성
- 리스트로 반환
## 4. BridgeNumberGenerator (Interface)
- 인테페이스 제공 

## 5. BridgeRandomNumberGenerator

    ※ 요구 사항 ※
    1. Random 값 추출은 제공된 bridge.BridgeRandomNumberGenerator 의 generate() 를 활용한다.
    2. BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경할 수 없다.

- 0 부터 1 랜덤 숫자 
## 7. Exception
- 예외 한꺼번에 처리

## 8. InputView
    ※ 요구 사항 ※
    1. 제공된 InputView 클래스를 활용해 구현해야 한다.
    2. InputView 의 패키지는 변경할 수 있다.
    3. InputView 의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
    4. 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.

- 다리의 길이 입력
- 사용자가 이통할 칸 입력
- 게임을 다시 시도할 지 종료 할지 입력
## 9. OutputView

    ※ 요구 사항 ※
    1. 제공된 OutputView 클래스를 활용해 구현해야 한다.
    2. OutputView 의 패키지는 변경할 수 있다.
    3. OutputView 의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
    4. 값 출력을 위해 필요한 메서드를 추가할 수 있다.


- ‘다리 건너기 게임 시작’ 메시지 출력
- 현재까지 이동한 상태 출력
- 최종 결과 출력, 성공 여부, 총 시도 횟수 출력