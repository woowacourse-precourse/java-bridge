package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

//패키지 변경 가능
//메서드 이름 변경 불가, 인자와 반환타입은 변경 가능
//값 출력을 위해 필요한 메서드 추가 가능

public class OutputView {

    public static final String UP = "U";
    public static final String DOWN = "D";

    static final String CORRECT_STATE = " O ";
    static final String NONE_STATE = "   ";
    static final String WRONG_STATE = " X ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
        StringBuilder upSb = new StringBuilder();
        StringBuilder downSb = new StringBuilder();
        makeMapMessage(bridge, upSb, downSb);
        System.out.println(upSb);
        System.out.println(downSb);
    }

    private void makeMapMessage(Bridge bridge, StringBuilder upSb, StringBuilder downSb) {
        upSb.append("[");
        downSb.append("[");
        checkSide(bridge, upSb, UP);
        checkSide(bridge, downSb, DOWN);
        upSb.deleteCharAt(upSb.length() - 1);
        upSb.append("]");
        downSb.deleteCharAt(upSb.length() - 1);
        downSb.append("]");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void printResult(Bridge bridge) {
        System.out.println("최종 게임 결과");
        printMap(bridge);
    }

    // 새로만든 map출력
    private void checkSide(Bridge bridge, StringBuilder sb, String Side) {
        for (int i = 0; i < bridge.getBridge().size(); i++) {
            if (bridge.getBridge().get(i).equals(Side)) {
                appendCorrectOrWrong(bridge, sb, i);
            } else {
                sb.append(NONE_STATE);
            }
            sb.append("|");
        }
    }

    private static void appendCorrectOrWrong(Bridge bridge, StringBuilder sb, int idx) {
        if (bridge.getResults().get(idx)) {
            sb.append(CORRECT_STATE);
        } else {
            sb.append(WRONG_STATE);
        }
    }

//    private void printResult(Bridge bridge, StringBuilder upSb, StringBuilder downSb) {
//        for (int i = 0; i < bridge.getResults().size(); i++) {
//            String direction = bridge.getBridge().get(i);
//            boolean result = bridge.getResults().get(i);
//            if (direction.equals(UP)) {
//                downSb.append(NONE_STATE);
//                upSb.append(checkFalse(result));
//            }
//            if (direction.equals(DOWN)) {
//                upSb.append(NONE_STATE);
//                downSb.append(checkFalse(result));
//            }
//            upSb.append("|");
//            downSb.append("|");
//        }
//    }
//
//    private String checkFalse(boolean result) {
//        if (result) {
//            return CORRECT_STATE;
//        }
//        return WRONG_STATE;
//    }

}
