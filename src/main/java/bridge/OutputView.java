package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String SPACE = " ";
    private final static String CORRECT = "O";
    private final static String WRONG = "X";

    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if(outputView == null) {
            outputView = new OutputView();
        }

        return outputView;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge, List<String> userLog) {
        System.out.println("[ " + printLine(bridge, userLog, Command.UP) + " ]");
        System.out.println("[ " + printLine(bridge, userLog, Command.DOWN) + " ]");
    }

    private String printLine(Bridge bridge, List<String> userLog, Command direction) {
        List<String> line = new ArrayList<>();

        for(int block = 0; block < userLog.size(); block++) {
            line.add(compare(bridge.getBridge().get(block), userLog.get(block), direction));
        }

        return String.join(" | ", line);
    }

    private String compare(String bridgeMovement, String userMovement, Command direction) {
        if (! userMovement.equals(direction.getValue())) {
            return SPACE;
        }

        if (userMovement.equals(bridgeMovement)) {
            return CORRECT;
        }

        return WRONG;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge bridge, BridgeGame bridgeGame, int retryCount) {
        System.out.println("최종 게임 결과");
        printMap(bridge, bridgeGame.getUserLog());
        System.out.println();
        printSuccessful(bridge.getBridge(), bridgeGame.getUserLog());
        System.out.println("총 시도한 횟수: " + retryCount);
    }

    private void printSuccessful(List<String> bridge, List<String> userLog) {
        if(bridge.equals(userLog)) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }

        System.out.println("게임 성공 여부: 실패");
    }
}
