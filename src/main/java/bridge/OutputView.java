package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String OPEN_PRINT_MAP = "[%s";
    private static final String CLOSE_PRINT_MAP = "%s]\n";
    private static final String TOP = "U";
    private static final String BOTTOM = "D";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String SPACE = "   ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeData bridgeData, String input) {
        System.out.printf(OPEN_PRINT_MAP, topSideMap(bridgeData));
        if (input.equals(TOP)){
            System.out.printf(CLOSE_PRINT_MAP, CORRECT);
        }
        if (!input.equals(TOP)){
            System.out.printf(CLOSE_PRINT_MAP, SPACE);
        }
        System.out.printf(OPEN_PRINT_MAP, bottomSideMap(bridgeData));
        if (input.equals(BOTTOM)){
            System.out.printf(CLOSE_PRINT_MAP, CORRECT);
        }
        if (!input.equals(BOTTOM)){
            System.out.printf(CLOSE_PRINT_MAP, SPACE);
        }
    }

    public static void printMap_Wrong(BridgeData bridgeData, String input) {
        System.out.printf(OPEN_PRINT_MAP, topSideMap(bridgeData));
        if (input.equals(TOP)){
            System.out.printf(CLOSE_PRINT_MAP, SPACE);
        }
        if (!input.equals(TOP)){
            System.out.printf(CLOSE_PRINT_MAP, WRONG);
        }
        System.out.printf(OPEN_PRINT_MAP, bottomSideMap(bridgeData));
        if (input.equals(BOTTOM)){
            System.out.printf(CLOSE_PRINT_MAP, SPACE);
        }
        if (!input.equals(BOTTOM)){
            System.out.printf(CLOSE_PRINT_MAP, WRONG);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private static String topSideMap(BridgeData bridgeData){
        StringBuilder topSideMap = new StringBuilder();
        for (int i = 0; i < bridgeData.getCurrentPosition(); i++){
            if (bridgeData.getBridge().get(i).equals(TOP)){
                topSideMap.append(" O |");
            }
            if (bridgeData.getBridge().get(i).equals(BOTTOM)){
                topSideMap.append("   |");
            }
        }
        return topSideMap.toString();
    }

    private static String bottomSideMap(BridgeData bridgeData){
        StringBuilder topSideMap = new StringBuilder();
        for (int i = 0; i < bridgeData.getCurrentPosition(); i++){
            if (bridgeData.getBridge().get(i).equals(TOP)){
                topSideMap.append("   |");
            }
            if (bridgeData.getBridge().get(i).equals(BOTTOM)){
                topSideMap.append(" O |");
            }
        }
        return topSideMap.toString();
    }
}
