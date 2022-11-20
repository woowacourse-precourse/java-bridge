package bridge.view;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(String bridgeMapFormat) {
        System.out.printf(bridgeMapFormat);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(String bridgeMapFormat, String successOrNot, int numberOfAttempts) {
        System.out.println("최종 게임 결과");
        printMap(bridgeMapFormat);
        System.out.println("게임 성공 여부: " + successOrNot);
        System.out.printf("총 시도한 횟수: %d\n", numberOfAttempts);

    }

    public static void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    static void printBridgeLengthRequest() {
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }

    static void printMovingRequest() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    static void printRestartRequest() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
