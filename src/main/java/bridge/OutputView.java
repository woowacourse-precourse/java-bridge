package bridge;

import bridge.UserInput.BridgeSelection;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printMap(List<String> bridge, List<String> result) {
        System.out.println(upBridge(bridge, result));
        System.out.println(downBridge(bridge, result));
        System.out.println();
    }

    private static String upBridge(List<String> bridge, List<String> result) {
        return getBridgeFrame(bridge, result, BridgeSelection.Up.get());
    }

    private static String downBridge(List<String> bridge, List<String> result) {
        return getBridgeFrame(bridge, result, BridgeSelection.Down.get());
    }

    private static String getBridgeFrame(List<String> bridge, List<String> result, String floor) {
        StringBuilder frame = new StringBuilder("[ ");
        for (int i = 0; i < result.size(); i++) {
            frame.append(getOX(bridge.get(i), result.get(i), floor));
            frame.append(" | ");
        }
        return frame.replace(frame.length() - 2, frame.length() - 1, "]").toString();
    }

    private static String getOX(String bridgeMark, String resultMark, String floor) {
        if (bridgeMark.equals(floor) && resultMark.equals("O")) {
            return "O";
        }
        if (!bridgeMark.equals(floor) && resultMark.equals("X")) {
            return "X";
        }
        return " ";
    }
}