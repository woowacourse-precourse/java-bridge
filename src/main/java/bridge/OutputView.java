package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final InputView inputView = new InputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private final String NOT_CHOSEN = "   ";
    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    public static String ox;
    private int stepCount = 0;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void validateMap(String input, List<String> bridge, int stepCount) {
        try {
            createMap(input, bridge, stepCount);
        } catch (IllegalArgumentException exception) {
            System.out.println(ExceptionMessage.NOT_MOVE_INVALID.getExceptionMessage());
            validateMap(input, bridge, stepCount);
        }

    }

    public void createMap(String input, List<String> bridge, int stepCount) {
        inputView.movingValidate(input);
        ox = bridgeGame.move(input, bridge, stepCount);
        if (input.equals("U")) {
            upBridge.add(ox);
            downBridge.add(NOT_CHOSEN);
        }
        if (input.equals("D")) {
            upBridge.add(NOT_CHOSEN);
            downBridge.add(ox);
        }
        printMap(stepCount);
    }

    public void printMap(int stepCount) {
        String upBridgePrint = String.join("|", upBridge);
        String downBridgePrint = String.join("|", downBridge);
        System.out.println("[" + upBridgePrint + "]");
        System.out.println("[" + downBridgePrint + "]");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int stepCount, int tryCount, String gameResult) {
        System.out.println("최종 게임 결과");
        printMap(stepCount);
        System.out.println();
        System.out.println("게임 성공 여부 : " + gameResult);
        System.out.println("총 시도한 횟수 : " + tryCount);
    }

    public void clearBridge() {
        upBridge.clear();
        downBridge.clear();
    }
}
