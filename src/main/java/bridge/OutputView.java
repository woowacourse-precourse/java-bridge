package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String BRIDGE_START = "[";
    public static final String BRIDGE_END = "]";
    public static final int STARTING_POINT = 0;
    public static final String BRIDGE_SEPARATOR = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingHistory movingHistory) {
        printMapOfSide(movingHistory.getUpSide());
        printMapOfSide(movingHistory.getDownSide());
    }

    private void printMapOfSide(List<String> sideHistory) {
        StringBuilder sideMap = new StringBuilder();
        sideMap.append(BRIDGE_START);

        for (int position = STARTING_POINT; position < sideHistory.size(); position++) {
            if (position > STARTING_POINT) {
                sideMap.append(BRIDGE_SEPARATOR);
            }
            sideMap.append(sideHistory.get(position));
        }
        sideMap.append(BRIDGE_END);

        System.out.println(sideMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MovingHistory movingHistory, BridgeGame bridgeGame, MovingResult movingResult) {
        System.out.println(GuidanceMessage.GAME_OUTRO);
        printMap(movingHistory);
        printGameResult(bridgeGame, movingResult);
    }

    private void printGameResult(BridgeGame bridgeGame, MovingResult movingResult) {
        System.out.print(GuidanceMessage.INFORM_IS_SUCCESS);
        System.out.println(bridgeGame.getGameResult(movingResult));
    }

    public void printError(IllegalArgumentException error) {
        System.out.print(ErrorMessage.PREFIX);
        System.out.println(error.getMessage());
    }
}
