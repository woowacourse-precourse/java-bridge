package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String PRINT_MAP = "[%s%s]\n";
    private static final String TOP = "U";
    private static final String BOTTOM = "D";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String SPACE = "   ";
    private static final String BAR = "|";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String FINAL_RESULT = "\n최종 게임 결과";
    private static final String SUCCESS_FAIL = "\n게임 성공 여부: %s\n";
    private static final String TRY = "총 시도한 횟수: %d\n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeData bridgeData, boolean pass) {
        System.out.printf(PRINT_MAP, topSideMap(bridgeData), topSideResult(bridgeData, pass));
        System.out.printf(PRINT_MAP, bottomSideMap(bridgeData), bottomSideResult(bridgeData, pass));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeData bridgeData, boolean gameStatus, int gameCount) {
        String result = FAIL;
        if (gameStatus) {
            result = SUCCESS;
        }
        System.out.println(FINAL_RESULT);
        printMap(bridgeData, gameStatus);
        System.out.printf(SUCCESS_FAIL, result);
        System.out.printf(TRY, gameCount);
    }

    private static String topSideMap(BridgeData bridgeData) {
        StringBuilder topSideMap = new StringBuilder();
        for (int i = 0; i < bridgeData.getCurrentPosition() - 1; i++) {
            topSideMap.append(topSideCheck(bridgeData, i));
        }
        return topSideMap.toString();
    }

    private static String topSideCheck(BridgeData bridgeData, int index) {
        if (bridgeData.getBridge().get(index).equals(TOP)) {
            return CORRECT + BAR;
        }
        return SPACE + BAR;
    }

    private static String topSideResult(BridgeData bridgeData, boolean pass) {
        if (pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition() - 1).equals(TOP)) {
            return CORRECT;
        }
        if (!pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition() - 1).equals(BOTTOM)) {
            return WRONG;
        }
        return SPACE;
    }

    private static String bottomSideMap(BridgeData bridgeData) {
        StringBuilder bottomSideMap = new StringBuilder();
        for (int i = 0; i < bridgeData.getCurrentPosition() - 1; i++) {
            bottomSideMap.append(bottomSideCheck(bridgeData, i));
        }
        return bottomSideMap.toString();
    }

    private static String bottomSideCheck(BridgeData bridgeData, int index) {
        if (bridgeData.getBridge().get(index).equals(BOTTOM)) {
            return CORRECT + BAR;
        }
        return SPACE + BAR;
    }

    private static String bottomSideResult(BridgeData bridgeData, boolean pass) {
        if (pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition() - 1).equals(BOTTOM)) {
            return CORRECT;
        }
        if (!pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition() - 1).equals(TOP)) {
            return WRONG;
        }
        return SPACE;
    }
}
