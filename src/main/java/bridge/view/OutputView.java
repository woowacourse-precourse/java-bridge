package bridge.view;

import bridge.model.Player;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String BRIDGE_STAGE_START = "[ ";
    private final static String BRIDGE_STAGE_DELIMITER = " | ";
    private final static String BRIDGE_STAGE_END = " ]\n";
    private final static String BRIDGE_RESULT = "최종 게임 결과\n";
    private final static String BRIDGE_RESULT_SUCCESS_MESSAGE = "게임 성공 여부: 성공\n";
    private final static String BRIDGE_RESULT_FAILURE_MESSAGE = "게임 성공 여부: 실패\n";
    private final static String BRIDGE_RESULT_TRIALS_NUMBER_MESSAGE = "총 시도한 횟수: %d\n";
    private static final String PRINT_ERROR_MESSAGE = "[ERROR] %s\n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        StringBuilder sb = new StringBuilder();
        String bridgeUpSpace = getBridgeUpSpace(player.getMovingSpaces(), player.isPossible());
        String bridgeDownSpace = getBridgeDownSpace(player.getMovingSpaces(), player.isPossible());
        sb.append(bridgeUpSpace);
        sb.append(bridgeDownSpace);
        System.out.println(sb);
    }

    private String getBridgeUpSpace(List<String> movingSpaces, boolean isPossible) {
        StringBuilder sb = new StringBuilder();
        sb.append(BRIDGE_STAGE_START);
        for(int idx = 0; idx < movingSpaces.size()-1; idx++) {
            String space = movingSpaces.get(idx);
            sb.append(checkUpSpace(space));
            sb.append(BRIDGE_STAGE_DELIMITER);
        }
        sb.append(getIsPossibleUp(isPossible, movingSpaces.get(movingSpaces.size()-1)));
        sb.append(BRIDGE_STAGE_END);
        return sb.toString();
    }

    private String getIsPossibleUp(boolean isPossible, String space) {
        if(isPossible) {
            return checkUpSpace(space);
        }
        return checkUpSpaceWhenIsNotPossible(space);
    }

    private String getBridgeDownSpace(List<String> bridge, boolean isPossible) {

        StringBuilder sb = new StringBuilder();
        sb.append(BRIDGE_STAGE_START);
        for(int idx = 0; idx < bridge.size()-1; idx++) {
            String space = bridge.get(idx);
            sb.append(checkDownSpace(space));
            sb.append(BRIDGE_STAGE_DELIMITER);
        }
        sb.append(getIsPossibleDown(isPossible, bridge.get(bridge.size()-1)));
        sb.append(BRIDGE_STAGE_END);
        return sb.toString();
    }

    private String getIsPossibleDown(boolean isPossible, String space) {
        if(isPossible) {
            checkDownSpace(space);
        }
        return checkDownSpaceWhenIsNotPossible(space);
    }

    private String checkUpSpace(String space) {
        if(space.equals("U")) {
            return "O";
        }
        return " ";
    }

    private String checkUpSpaceWhenIsNotPossible(String space) {
        if(space.equals("U")) {
            return "X";
        }
        return " ";
    }

    private String checkDownSpace(String space) {
        if(space.equals("D")) {
            return "O";
        }
        return " ";
    }

    private String checkDownSpaceWhenIsNotPossible(String space) {
        if(space.equals("D")) {
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player) {
        StringBuilder sb = new StringBuilder();
        sb.append(BRIDGE_RESULT);

        String bridgeUpSpace = getBridgeUpSpace(player.getMovingSpaces(), player.isPossible());
        String bridgeDownSpace = getBridgeDownSpace(player.getMovingSpaces(), player.isPossible());
        sb.append(bridgeUpSpace);
        sb.append(bridgeDownSpace);

        sb.append(getIsSuccessMessage(player.isPossible()));
        sb.append(String.format(BRIDGE_RESULT_TRIALS_NUMBER_MESSAGE, player.getAttempt()));
        System.out.print(sb);
    }

    private String getIsSuccessMessage(boolean isSuccess) {
        if(isSuccess) {
            return BRIDGE_RESULT_SUCCESS_MESSAGE;
        }
        return BRIDGE_RESULT_FAILURE_MESSAGE;
    }

    public static void printError(RuntimeException exception) {
        System.out.printf(PRINT_ERROR_MESSAGE, exception.getMessage());
    }
}
