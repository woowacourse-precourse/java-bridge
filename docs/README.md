1. project_name : java-bridge

2. 공통 피드백 및 요구사항
    - 기능 목록 작성
    - 하드 코딩 금지(static final)
    - 한 함수에 한 가지 기능만 담당
    - 테스트를 작성 및 이유에 대해 본인의 경험을 토대로 정리
        + 큰 단위 테스트
        + 작은 단위 테스트
    - 들여쓰기 2개 이하로 한다.
    - if 사용시 else 빼고 바로 return 사용 / case when 불가 / 3항 연산자 금지
    - 도메인 로직에 단위 테스트를 구현해야 한다.(UI 로직 제외)
        + 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - camp.nextstep.edu.missionutils의 Randoms 및 Console를 사용하라
        + 램덤 추출 : pickUniqueNumbersInRange()
        + 사용자 입력 : readLine()
    - **발생할 수 있는 예외 상황에 대해 고민하라**
    - **비즈니스 로직과 UI 로직을 한 클래스가 담당하지 않도록 한다.**
    - **객체의 상태를 보기 위한 로그 메시지 성격이 강하다면 toString()을 통해 구현**
    - **final 사용을 통한 값 변경 제한**
    - **private를 통한 객체 접근 제한**
    - **필드(인스턴스 변수)의 수를 줄이기 위해 노력한다**
    - **getter를 사용하는 대신 객체에 메시지를 보내자**
    - **private 함수를 테스트 하고 싶다면 클래스(객체) 분리 고려**
    - **테스트 코드도 코드이므로 리팩터링을 통해 개선해나가야 한다.**

3. 기능 요구 사항(오징어 게임 : 다리 건너기)
   - 위아래 두 칸으로 이루어진 다리를 건넌다.
     + 다리는 왼쪽 -> 오른쪽 으로 건넌다
     + 위아래 둥 중 하나의 칸만 건넌다.
   - 다리의 길이를 숫자로 입력받고 생성한다.
     + 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다.
     + 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값을 나타낸다.
     + 무작위 값이 0인 경우 아래칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
   - 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
     + 이동할 때 위칸은 대문자 U, 아래칸은 대문자 D을 입력
     + 아동한 칸을 건널 수 있다면 O 표시, 건널 수 없다면 X로 표시.
   - 다리 건너시 성공 => 게임 종료
   - 다리 건너기 실패 => 재시작 혹은 게임 종료
     + 재시작시 처음 만든 다리 재사용
     + 게임 결과의 총 시도 횟수 : 첫 시도를 포함해 게임 종료시까지 시도한 횟수
   - 잘 못된 값을 입력할 경우 : IllegalArgumentException 및 에러문구 [EERROR] ~ 발생
     + IllegalArgumentException, IllegalStateException

4. 입력 조건
    - 다리 길이 받기 : 3 이상 20이하 / 예외 처리 필수
    - 이동할 칸 선택 : U(위 칸) D(아래 칸) / 예외 처리 필수 => ENUM 가능성도?
    - 게임 재시작 및 종료 선택 : R(재시작) Q(종료) / 예외 처리 필수 => ENUM 가능성도?

5. 추가 조건
    *함수 길이 10이하
    *함수 파라미터 최대 3개
    - InputView : 사용자 입력 받기 기능 전담 / 메서드 인자, 이름, 반환 타입은 변경 가능 / 입력 받기 위한 메서드 추가가능
    - OutputView : 출력 기능 전담 / 인자 및 반환 타입 추가 및 변경 가능 / 출력 위한 메서드 추가 가능
    - BridgeGame : 게임 진행 / 메서드 추가 가능 / 인스턴스 변수 추가 가능 / InputView 및 OutputView 접근 불가
    - BridgeMaker : 인스턴스 변수 변경 불가 / 인자, 이름, 반환 타입 변경 불가
    - BridgeRandomNumberGenerator : 램덤 값 추출 / BridgeRandomNumberGenerator, BridgeNumberGenerator 변경 불가

6. 구동 순서
    - println "다리 건너기 게임을 시작합니다.\n"
    -
    - InputView.readBridgeSize() println "다리의 길이를 입력해주세요."
    - InputView.readBridgeSize() readLine() "3"
    - InputView.readBridgeSize() println "3\n"
    - BridgeMaker.BridgeMaker().makeBridge
    -
    - InputView.readMoving() println "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    - InputView.readMoving() readLine() "U"
    - InputView.readMoving() println "U"
    - BridgeGame.move()
    - BridgeRandomNumberGenerator.generate()
    - OutputView.printMap() println "[ O ]\n[   ]\n" // 현재 다리 상태 출력
    - BridgeGame.check()
    - 
    - InputView.readMoving() println "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    - InputView.readMoving() readLine() "U"
    - InputView.readMoving() println "U"
    - BridgeGame.move()
    - BridgeRandomNumberGenerator.generate()
    - OutputView.printMap() println "[ O | X ]\n[   |   ]\n" // 현재 다리 상태 출력
    - BridgeGame.check()
    - 
    - InputView.readGameCommand() println "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    - InputView.readGameCommand() readLine() "R"
    - InputView.readGameCommand() println "R"
    - BridgeGame.retry()
    - InputView.readMoving() println "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    - InputView.readMoving() readLine() "U"
    - InputView.readMoving() println "U"
    - BridgeGame.move()
    - BridgeRandomNumberGenerator.generate()
    - OutputView.printMap() println "[ O ]\n[   ]\n" // 현재 다리 상태 출력
    - BridgeGame.check()
    -
    - InputView.readGameCommand() println "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    - InputView.readGameCommand() readLine() "D"
    - InputView.readGameCommand() println "D"
    - BridgeGame.move()
    - BridgeRandomNumberGenerator.generate()
    - OutputView.printMap() println "[ O |   ]\n[   | O ]\n" // 현재 다리 상태 출력
    - BridgeGame.check()
    -
    - InputView.readGameCommand() println "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    - InputView.readGameCommand() readLine() "D"
    - InputView.readGameCommand() println "D"
    - BridgeGame.move()
    - BridgeRandomNumberGenerator.generate()
    - OutputView.printMap() "[ O |   |   ]\n[   | O | O ]\n" // 현재 다리 상태 출력
    - BridgeGame.check()
    -
    - OutputView.printResult() println "게임 성공 여부: : + "성공"
    - OutputView.printResult() println "총 시도한 횟수: " + 2

7. 상세
    1) 기능 목록
        a) Application.java
            - 
        b) InputView.java
            - readBridgeSize() : 다리 길이 입력 / 3 ~ 20 / int
            - readMoving() : U D / string
            - readGameCommand() : R Q / string
        c) OutputView.java
            - printMap() : 다리 현 상황 출력
            - printResult() : 게임 결과 출력
        d) BridgeGame.java
            - move() : 움직임 반영
            - retry() : 재시작 여부 확인
            - check() : 도착했는지 확인
        e) BridgeMaker.java
            - BridgeMaker
            - makeBridge : 다리 제작 / List<String> 
        f) BridgeRandomNumberGenerator // 변경 불가
            - generate() : 0 혹은 1의 램덤수 발생
                + int number = bridgeNumberGenerator.generate();
        g) BridgeNumberGenerator // 변경 불가
            + interface
    2)구현 불필요
        - 