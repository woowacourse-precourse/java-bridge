# java-bridge

## 프로젝트 소개
위 아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임
다리의 길이를 입력받으면, 위 아래 칸 중 건널 수 있는 칸을 무작위로 정하여 생성한다.
플레이어가 이동할 칸을 선택하여 생성된 다리를 끝까지 건너면 성공한다.

## 개발 환경
JDK 11

## 기능 목록
- [x] 다리 생성
  - [x] 생성할 다리 길이를 입력 받음
  - [x] 다리의 길이 만큼 무작위로 0,1을 이용하여 생성
  - [x] 생성된 무작위 값을 U,D로 변환
    - 0인 경우: 아래칸 D, 1인 경우: 위칸 U

- [x] 플레이어 이동
  - [x] 이동할 칸을 입력 받음
  - [x] 이동할 수 있는지 확인
    - [x] 있으면 O 출력
    - [x] 없으면 X 출력
      - [x] 게임 재시작
  - [x] 2번 이상 이동 시 다리 연속해서 출력
  - [x] 다리 건넜으면 게임 종료

- [x] 게임 종료
  - [x] "최종 게임 결과" 출력
  - [x] 최종 다리 모양 출력
  - [x] 게임 성공 여부 출력
  - [x] 총 시도 횟수 출력

- [x] 게임 재시작
  - [x] 게임 재시작 여부 질문
      - [x] Q 입력 시 게임 종료
      - [x] R 입력 시 게임 재시작
        - [x] 플레이어 이동 실행

- [x] 게임 시작
  - [x] "다리 건너기 게임을 시작합니다."
  - [x] 다리 생성
  - [x] 플레이어 이동

- [x] 예외처리
  - [x] 다리길이가 3이상 20이하가 아닌 경우
  - [x] 이동할 칸 입력시 U나 D가 아닐 경우
  - [x] 게임 재시작 여부 입력 시 R나 Q가 아닐 경우
  - [x] 입력 값이 두 글자 이상일 경우

## 고려사항
- [x] 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현
- [x] 메서드의 파라미터 개수는 최대 3개까지만 허용
- [x] InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있음
- [x] BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않음
- [x] InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현
  - [x] InputView
  - [x] OutputView
    - [x] OutputView의 메서드의 이름은 변경할 수 없음
  - [x] BridgeGame
    - [x] BridgeGame의 메서드의 이름은 변경할 수 없음
  - [x] BridgeMaker
    - [x] BridgeMaker의 필드(인스턴스 변수)를 변경할 수 없음
    - [x] BridgeMaker의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 없음
  - [x] BridgeRandomNumberGenerator
    - [x] BridgeRandomNumberGenerator, BridgeNumberGenerator 클래스의 코드는 변경할 수 없음
- [x] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
- [x] JDK 11 버전에서 실행 가능
- [x] 프로그램 실행의 시작점은 Application의 main()
- [x] build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않음
- [] Java 코드 컨벤션 가이드를 준수
- [x] 프로그램 종료 시 System.exit()를 호출하지 않음
- [x] 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않음
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현
- [x] 3항 연산자를 쓰지 않음
- [x] Unit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
- [x] else 예약어를 쓰지 않음
  - [x] switch/case 허용하지 않음
- [x] 도메인 로직에 단위 테스트를 구현
  - [x] UI는 제외
- [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받음