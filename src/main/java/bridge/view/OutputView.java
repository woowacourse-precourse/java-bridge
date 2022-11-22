package bridge.view;

import bridge.constant.command.Command;
import bridge.constant.message.GameMessage;
import bridge.service.BridgeGameService;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStart() {
        System.out.println(GameMessage.GAME_START.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge, List<String> selections) {
        System.out.println(up(bridge, selections, Command.UP.getCommand()));
        System.out.println(down(bridge, selections, Command.DOWN.getCommand()));
    }

    private static String up(List<String> bridge, List<String> selections, String position) {
        return getString(bridge, selections, position);
    }

    private static String down(List<String> bridge, List<String> selections, String position) {
        return getString(bridge, selections, position);
    }

    private static String getString(List<String> bridge, List<String> selections, String position) {
        StringBuilder sb = new StringBuilder("[ ");

        for (int i = 0; i < selections.size(); i++) {
            sb.append(getMarkCommand(bridge.get(i), selections.get(i), position)).append(" | ");
        }

        return sb.replace(sb.length() - 2, sb.length() - 1, "]").toString();
    }

    private static String getMarkCommand(String bridgeMark, String selectionMark, String stair) {
        if (bridgeMark.equals(stair) && selectionMark.equals(Command.POSSIBLE.getCommand())) {
            return Command.POSSIBLE.getCommand();
        }
        if (!bridgeMark.equals(stair) && selectionMark.equals(Command.IMPOSSIBLE.getCommand())) {
            return Command.IMPOSSIBLE.getCommand();
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGameService bridgeGameService) {
        System.out.println(GameMessage.GAME_RESULT_FIRST.getMessage());
        printMap(bridgeGameService.getBridge(), bridgeGameService.getSelections());
        System.out.println();
        System.out.println(GameMessage.GAME_RESULT_SECOND.getMessage() + bridgeGameService.gameStatus());
        System.out.println(GameMessage.GAME_RESULT_THIRD.getMessage() + bridgeGameService.getTryCnt());
    }

}
