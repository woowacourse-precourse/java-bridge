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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge) {
        System.out.println("최종 게임 결과");
        printMap(bridge);
    }

    private void makeMapMessage(Bridge bridge, StringBuilder upSb, StringBuilder downSb) {
        upSb.append("[");
        downSb.append("[");
        temp(bridge, upSb, downSb);
        upSb.deleteCharAt(upSb.length() - 1);
        upSb.append("]");
        downSb.deleteCharAt(downSb.length() - 1);
        downSb.append("]");
    }

    private void temp(Bridge bridge, StringBuilder upSb, StringBuilder downSb) {
        for (int i = 0; i < bridge.getResults().size(); i++) {
            String bridgeAnswer = bridge.getBridge().get(i);
            if (bridgeAnswer.equals(UP)) {
                whenUpSide(bridge.getResults().get(i), upSb, downSb);
            }
            if (bridgeAnswer.equals(DOWN)) {
                whenDownSide(bridge.getResults().get(i), upSb, downSb);
            }
            upSb.append("|");
            downSb.append("|");
        }
    }


    private void whenUpSide(boolean bridgeResult, StringBuilder upSb, StringBuilder downSb) {
        if (bridgeResult) {
            upSb.append(CORRECT_STATE);
            downSb.append(NONE_STATE);
            return;
        }
        upSb.append(NONE_STATE);
        downSb.append(WRONG_STATE);
    }

    private void whenDownSide(boolean bridgeResult, StringBuilder upSb, StringBuilder downSb) {
        if (bridgeResult) {
            downSb.append(CORRECT_STATE);
            upSb.append(NONE_STATE);
            return;
        }
        downSb.append(NONE_STATE);
        upSb.append(WRONG_STATE);
    }
}
