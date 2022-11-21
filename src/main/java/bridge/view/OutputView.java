package bridge.view;

import bridge.domain.User;
import bridge.domain.utils.BridgeCommand;
import bridge.domain.utils.BridgeState;
import bridge.domain.utils.GameState;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String START_GAME = "다리 건너기 게임을 시작합니다.\n";
    public static final String FINAL_GAME_OUTPUT = "최종 게임 결과";
    public static final String FINAL_GAME_IS_SUCCESS = "게임 성공 여부: %s\n";
    public static final String FINAL_GAME_TRY_COUNT = "총 시도한 횟수: %d\n";
    private static final String SUCCESS_CROSSING = " O ";
    private static final String FAILED_CROSSING = " X ";
    private static final String NOTING_CROSSING = "   ";
    private static final String SUCCESS = "성공";
    private static final String FAILED = "실패";
    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_MIDTERM = "|";
    private static final String BRIDGE_END = "]";

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(User user) {
        List<String> upBridge = exchangeBridge(BridgeCommand.UP.getCommand(), user);
        List<String> downBridge = exchangeBridge(BridgeCommand.DOWN.getCommand(), user);
        printOneLineMap(upBridge);
        printOneLineMap(downBridge);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println(FINAL_GAME_OUTPUT);
        printMap(user);
        System.out.printf(FINAL_GAME_IS_SUCCESS,checkIsSuccess(user));
        System.out.printf(FINAL_GAME_TRY_COUNT,user.getRetryCount());
    }

    private List<String> exchangeBridge(String position, User user) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < user.crossingBridgeNumber(); i++) {
            result.add(checkCrossing(user.getUserCrossing(i), position));
        }
        return result;
    }

    private String checkCrossing(BridgeState bridgeState, String position) {
        if (bridgeState.getPosition().equals(position) && bridgeState.isAlive())
            return SUCCESS_CROSSING;
        if (bridgeState.getPosition().equals(position) && !bridgeState.isAlive())
            return FAILED_CROSSING;
        return NOTING_CROSSING;
    }

    private void printOneLineMap(List<String> bridge) {
        System.out.print(BRIDGE_START);
        for (int i = 0; i < bridge.size(); i++) {
            System.out.print(bridge.get(i));
            if (i != bridge.size() - 1)
                System.out.print(BRIDGE_MIDTERM);
        }
        System.out.println(BRIDGE_END);
    }

    private String checkIsSuccess(User user) {
        if (user.isGameSuccess() == GameState.FAILED)
            return FAILED;
        return SUCCESS;
    }

}
