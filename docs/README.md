# 다리 건너기

## 개요

1. 다리 길이를 입력 받아 다리를 생성한다.
2. 이동할 칸을 입력받고 다리를 건넌다.
3. 건너는 것이 성공한 경우 계속 2번을 반복한다
4. 건더는 것이 실패한 경우 게임을 다시 시도할지 여부를 입력 받는다.
5. 다시 시도하는 경우 기존의 다리에서 다시 2번을 시작한다
6. 게임을 끝내는 경우 최종 게임 결과와 시도한 횟수를 출력하고 종료한다.
7. 다리를 끝까지 건너는데 성공한 경우 최종 게임 결과와 시도한 횟수를 출력하고 종료한다.



## 기능 목록

- [x] 다리 길이에 대한 입력 validation (Validation Class)
- [X] 다리 길이에 대한 입력 Integer 변환 (InputView Class)
- [X] 다리 만들기 (BridgeMaker Class)
- [X] 이동할 칸에 대한 입력 validation (Validation Class)
- [X] 이동할 칸에 대한 입력 (InputView Class)
- [X] 다리 이동 (BridgeGame Class)
- [X] 다리 상태 변경 (BridgeGame Class)
- [X] 다리 이동 상태 출력 (OutputView Class)
- [X] 게임 다시 시도 여부 입력 Validation(Validation Class)
- [X] 게임 다시 시도 여부 입력  (InputView Class)
- [X] 게임 다시 시도 (BridgeGame Class)
- [X] 최종 게임 결과 출력 (OutputView Class)
- [X] 에러 출력 후 다시 입력 요청 (InputView Class)


## 요구사항 및 제한 사항
- [X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [X] 3항 연산자를 쓰지 않는다.
- [X] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [X] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- [X] else 예약어를 쓰지 않는다.
- [X] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다
- [X] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다
- [X] 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
- [X] 아래 있는 InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현한다.