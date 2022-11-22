package bridge;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.Enums.OutputEnum.*;
import static bridge.Enums.StringValue.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String MIDDLE_BRIDGE = " | ";

    public static void printMap(final Bridge bridge,final boolean a) {
        printMapUp(bridge, a);
        printMapDown(bridge, a);
    }

    private static void printMapUp(final Bridge bridge, final boolean isFail) {
        List<String> upBridge = bridge.getBridge().subList(0, bridge.getPos())
                .stream()
                .map(Validate::isUp)
                .collect(Collectors.toList());
        if(!isFail){
            checkUp(bridge, upBridge, UP.getValue());
        }
        System.out.println(START_BRIDGE + String.join(MIDDLE_BRIDGE, upBridge) + END_BRIDGE);
    }

    private static void printMapDown(final Bridge bridge, final boolean isFail) {
        List<String> downBridge = bridge.getBridge().subList(0, bridge.getPos())
                .stream()
                .map(Validate::isDown)
                .collect(Collectors.toList());
        if(!isFail) {
            checkUp(bridge, downBridge, DOWN.getValue());
        }
        System.out.println(START_BRIDGE + String.join(MIDDLE_BRIDGE, downBridge) + END_BRIDGE);
    }
    private static int checkUp(final Bridge bridge, List<String> outputBridge, final String word) {
        if(bridge.getBridgeValue(bridge.getPos()).equals(word)) {
            outputBridge.add(" ");
            return 0;
        }
        outputBridge.add("X");
        return 1;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(final Bridge bridge, final int retCnt, final String res) {
        OUTPUT_RESULT.getMessage();
        printMap(bridge, bridge.checkResult());
        System.out.println();
        IS_SUCCESS.getMessage(res);
        TRY_COUNT.getMessage(Integer.toString(retCnt));
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
