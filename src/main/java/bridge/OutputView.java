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
        SbMap sbMap = new SbMap();
        makeMapMessage(bridge, sbMap);
        sbMap.print();
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

    private void makeMapMessage(Bridge bridge, SbMap sbMap) {
        sbMap.append("[");
        addState(bridge, sbMap);
        sbMap.deleteCharAt(sbMap.getUpSb().length() - 1);
        sbMap.append("]");
    }

    private void addState(Bridge bridge, SbMap sbMap) {
        for (int i = 0; i < bridge.getResults().size(); i++) {
            noteState(bridge, sbMap, i);
        }
    }

    private void noteState(Bridge bridge, SbMap sbMap, int i) {
        String bridgeAnswer = bridge.getBridge().get(i);
        if (bridgeAnswer.equals(UP)) {
            whenUpSide(bridge.getResults().get(i), sbMap);
        }
        if (bridgeAnswer.equals(DOWN)) {
            whenDownSide(bridge.getResults().get(i), sbMap);
        }
        sbMap.append("|");
    }


    private void whenUpSide(boolean bridgeResult, SbMap sbMap) {
        if (bridgeResult) {
            sbMap.getUpSb().append(CORRECT_STATE);
            sbMap.getDownSb().append(NONE_STATE);
            return;
        }
        sbMap.getUpSb().append(NONE_STATE);
        sbMap.getDownSb().append(WRONG_STATE);
    }

    private void whenDownSide(boolean bridgeResult, SbMap sbMap) {
        if (bridgeResult) {
            sbMap.getDownSb().append(CORRECT_STATE);
            sbMap.getUpSb().append(NONE_STATE);
            return;
        }
        sbMap.getDownSb().append(NONE_STATE);
        sbMap.getUpSb().append(WRONG_STATE);
    }
}
