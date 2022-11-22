package bridge;

public class Application {

    public static void main(String[] args) {

        // 1.게임 생성
        BridgeGame game = new BridgeGame();
        game.createGame();

        // 2.다리 길이 입력
        InputView gameInputView = new InputView();
        int gameBridgeLength = gameInputView.readBridgeSize();




    }
}

// 기능 요구 사항
// 1. docs/README.md에 작성

// 프로그래밍 요구 사항
// 1.JDK 11 버전에서 실행
// 2.프로그램 실행의 시작점은 Application의 main()
// 3.build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용 금지
// 4.Java 코드 컨벤션 가이드를 준수하며 프로그래밍 수행
// 5.프로그램 종료 시 System.exit()를 호출 금지
// 6.프로그램 구현이 완료되면 ApplicationTest의 모든 테스트 성공 확인
// 7.프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 금지
// 8.indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현 (2까지만 허용)
//    예를 들어 while문 안에 if문이 있으면 들여쓰기는 2
//    힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리
// 9.3항 연산자 사용 금지
// 10.함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 구현
// 11.JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
// 12.else 예약어 사용 금지
//    힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 됨
//    else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case 사용 금지
// 11.도메인 로직에 단위 테스트를 구현 (단, UI(System.out, System.in, Scanner) 로직은 제외)
// 12.핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리

// 추가된 요구 사항
// 1.함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현
// 2.함수(또는 메서드)가 한 가지 일만 잘하도록 구현
// 3.메서드의 파라미터 개수는 최대 3개까지만 허용
// 4.아래 있는 InputView, OutputView, BridgeGame, BridgeMaker, BridgeRandomNumberGenerator 클래스의 요구사항을 참고하여 구현
// 5.각 클래스의 제약 사항은 아래 클래스별 세부 설명을 참고, 이외 필요한 클래스(또는 객체)와 메서드는 자유롭게 구현 가능
// 6.InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력 받기 가능
// 7.BridgeGame 클래스에서 InputView, OutputView 를 사용 금지

// 라이브러리
// 1.[camp.nextstep.edu.missionutils] 미션에서 제공하는 Console API를 사용하여 구현
// 2.사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

// 과제 진행 요구 사항
// 1.미션은 java-bridge 저장소를 Fork & Clone해 시작
// 2.기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가
// 3.Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가
// 4.커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성
// 5.과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고