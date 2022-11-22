package bridge;

import bridge.Constant.BridgeSelection;
import bridge.Constant.OutputValue;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printMap(List<String> bridge, List<String> result) {
        System.out.println(upBridge(bridge, result));
        System.out.println(downBridge(bridge, result));
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
        if (bridgeMark.equals(floor) && resultMark.equals(OutputValue.rightBlock.get())) {
            return OutputValue.rightBlock.get();
        }
        if (!bridgeMark.equals(floor) && resultMark.equals(OutputValue.wrongBlock.get())) {
            return OutputValue.wrongBlock.get();
        }
        return " ";
    }

    public static void printResult(GameHelper gameHelper, int trialCount) {
        System.out.println("최종 게임 결과");
        printMap(gameHelper.getBridge(), gameHelper.getResultBridge());
        System.out.println();
        System.out.println("게임 성공 여부: " + isSuccess(gameHelper));
        System.out.println("총 시도한 횟수: " + trialCount);
    }

    public static String isSuccess(GameHelper gameHelper) {
        if (!gameHelper.reachEnd()) return "실패";
        return "성공";
    }
}