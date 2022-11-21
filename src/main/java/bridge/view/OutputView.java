package bridge.view;

import bridge.domain.Choice;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "D";
    private static final String START = "[";
    private static final String NOT_PASS = "   |";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Choice> inputs) {
        printBridge(inputs, UP_BRIDGE);
        printBridge(inputs, DOWN_BRIDGE);
        System.out.println();
    }

    public void printBridge(List<Choice> inputs, String upDown){
        String result = START;

        for (Choice input: inputs){
            String tmp = NOT_PASS;
            if (input.getInput().equals(upDown)){
                tmp = " " + input.getIsRight() + " |";
            }
            result+=tmp;
        }
        System.out.println(result.subSequence(0, result.length()-1)+"]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Choice> inputs, boolean yesNo, int count) {
        String changed = SUCCESS;

        if (!yesNo) changed = FAIL;

        System.out.println("최종 게임 결과");
        printMap(inputs);

        System.out.println("게임 성공 여부: " + changed);
        System.out.println("총 시도한 횟수: " + count);
    }
}
