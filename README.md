# 4주차

## 제약 사항

- indent depth가 3이 넘지 않도록 구현한다
- 3항 연산자를 쓰지 않는다
- 메서드가 한 가지 일만 하도록 최대한 작게 만든다
- 단위 테스트를 진행한다.
- else, switch를 쓰지 않는다
- 메서드 길이가 10라인을 넘어가지 않게 한다
- 메서드의 파라미터 개수는 최대 3개까지 허용한다.
- 각 클래스의 제약사향을 참고하여 구현한다
    - InputView
        - InputView에서만 readLine을 사용할 수 있다.
        - 메서드와 인자와 반환 타입 변경 가능
        - 필요 메서드 추가 가능
    - OutputView
        - 메서드 이름 변경 불가
        - 인자와 반환 타입 추가 혹은 변경 가능
        - 필요 메서드 추가 가능
    - BridgeGame
        - InputView, OutputView를 사용할 수 없다.
        - 필드를 추가할 수 있다.
        - 메서드 이름은 변경 불가
        - 인자와 반환타입 추가 혹은 변경 가능
        - 필요 메서드 추가 가능
    - BridgeMaker
        - 필드를 변경할 수 없다.
        - 메서드와 인자와 반환타입 모두 변경할 수 없다.
    - BridgeRandomNumberGenerator
        - Random 값은 generate를 사용한다
        - 해당 클래스 코드와 BridgeNumberGenerator 클래스 코드는 변경할 수 없다.

## 피드백

- 비즈니스 로직과 UI 로직을 분리한다.
- 상수 처리
- 연관성 있는 상수는 static final 대신 enum을 활용한다
- final 키워드를 통해 값의 변경을 막는다.
- 인스턴스 변수의 접근 제어자는 private으로 한다.
- **객체는 객체스럽게 사용한다. 객체가 일하도록 만든다. getter setter만 있으면 안됨**
- 필드의 수를 줄이기 위해 노력한다

## 이번 주의 목표

- 클래스(객체)를 분리하는 연습
- 리팩토링

## 기능 목록

- 다리 길이 입력
- 입력받은 다리 길이에 따라 무작위로 다리 생성
- 플레이어가 이동할 칸 입력
- 플레이어 이동
- 게임 실패
- 게임 재시작
- 게임 종료

## 예외 목록

- 다리 길이로 3 미만 혹은 20 초과를 입력
- 숫자를 입력해야 하는데 그 외의 것을 입력
- 다리 길이로 0을 입력
- 이동할 칸 입력 시 U/D 외 다른 것을 입력
- 개임 재시작 종료 여부 입력 시 R/Q외 다른 것을 입력
- 문자를 입력해야 하는데 그 외의 것을 입력