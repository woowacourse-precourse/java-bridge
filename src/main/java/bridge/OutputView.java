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
        String result = "실패";
        if (gameStatus){
            result = "성공";
        }
        System.out.println("최종 게임 결과");
        printMap(bridgeData, gameStatus);
        System.out.printf("\n게임 성공 여부: %s\n", result);
        System.out.printf("총 시도한 횟수: %d\n", gameCount);
    }

    private static String topSideMap(BridgeData bridgeData){
        StringBuilder topSideMap = new StringBuilder();
        for (int i = 0; i < bridgeData.getCurrentPosition()-1; i++){
            if (bridgeData.getBridge().get(i).equals(TOP)){
                topSideMap.append(CORRECT+BAR);
            }
            if (bridgeData.getBridge().get(i).equals(BOTTOM)){
                topSideMap.append(SPACE+BAR);
            }
        }
        return topSideMap.toString();
    }
    private static String topSideResult(BridgeData bridgeData, boolean pass){
        if (pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition()-1).equals(TOP)){
            return CORRECT;
        }
        if (!pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition()-1).equals(BOTTOM)){
            return WRONG;
        }
        return SPACE;
    }

    private static String bottomSideMap(BridgeData bridgeData){
        StringBuilder topSideMap = new StringBuilder();
        for (int i = 0; i < bridgeData.getCurrentPosition()-1; i++){
            if (bridgeData.getBridge().get(i).equals(TOP)){
                topSideMap.append(SPACE+BAR);
            }
            if (bridgeData.getBridge().get(i).equals(BOTTOM)){
                topSideMap.append(CORRECT+BAR);
            }
        }
        return topSideMap.toString();
    }

    private static String bottomSideResult(BridgeData bridgeData, boolean pass){
        if (pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition()-1).equals(BOTTOM)){
            return CORRECT;
        }
        if (!pass && bridgeData.getBridge().get(bridgeData.getCurrentPosition()-1).equals(TOP)){
            return WRONG;
        }
        return SPACE;
    }
}
