# 미션 - 다리 건너기


## 🗒️ 기능 목록
- [X] 게임 시작 메시지를 출력한다.
- [X] 다리 길이를 입력 받는다.
- [X] 입력 받은 다리 길이로 다리를 생성한다.
    - [X] 0과 1 중 무작위 값을 뽑는다.
    - [X] 0인 경우 아래 칸(D), 1인 경우 위 칸(U)이 된다.
    - [X] 다리 길이 만큼 반복하여 뽑아 다리를 완성한다.
- [X] 플레이어가 다리 위를 이동한다.
    - [X] U, D 중 하나의 값으로 입력 받는다. (U, D 외의 값은 모두 예외)
    - [X] 건널 수 있으면 O, 건널 수 없다면 X로 표시한다.
- [X] 다리를 끝까지 건너면 성공이며, 게임이 종료된다.
- [X] 다리를 건너다 실패하는 경우 재시작 또는 종료를 선택한다.
    - [X] 재시작 하는 경우, 원래 다리를 재사용하며, 입력했던 움직임 커맨드들은 초기화된다. 


## ✅ 요구 사항 체크리스트
- [X] Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
- [X] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다. (한 가지의 일만 잘하도록)
- [X] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다. 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - [X] move() 테스트 
  - [X] retry() 테스트
  - [X] calculateStatus() 테스트
  - [X] keepGoing() 테스트
- [X] 아래 있는 InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현한다.
  각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고한다.
  - [X] InputView
  - [X] OutputView
  - [X] BridgeGame
  - [X] BridgeMaker
  - [X] BridgeRandomNumberGenerator
- [X] InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.
- [X] BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

