package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없다.
 */
public class OutputView {
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String ENTER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String ENTER_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String FINAL_RESULT = "최종 게임 결과";
    public static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    public static final String TOTAL_TRIAL = "\n총 시도한 횟수: ";

    public void printStart(){
        System.out.println(START_GAME);
    }

    public void printEnterBridgeSize(){
        System.out.println(BRIDGE_SIZE);
    }
    public void printEnterMove() {
        System.out.println(ENTER_MOVE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(FINAL_RESULT);
        // printMap();
        // ENTER
        System.out.printf(SUCCESS_OR_NOT + "%b");
        System.out.println(TOTAL_TRIAL + "%d");
    }

    public void printRestart(){
        System.out.println(ENTER_RESTART);
    }
}
