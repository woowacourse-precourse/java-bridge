package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String UP_MOVING_CHARACTER = "U";
    private static final String DOWN_MOVING_CHARACTER = "D";
    private static final String BLANK = " ";
    private static final String MAP_O_CHARACTER = "O";
    private static final String MAP_X_CHARACTER = "X";
    private static final String RETRY_COMMAND_CHARACTER = "R";

    private int bridgeSize;
    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;

    public BridgeGame(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public List<String> makeBridge() {
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public int countGame(int gameCount) {
        gameCount += 1;
        return gameCount;
    }

    public static void makeMap(String moving, String str, List<List<String>> bridgeMap) {
        if (moving.equals(UP_MOVING_CHARACTER)) {
            bridgeMap.add(List.of(BLANK, str));
        } else if (moving.equals(DOWN_MOVING_CHARACTER)) {
            bridgeMap.add(List.of(str, BLANK));
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moving, String bridgeBlock, List<List<String>> bridgeMap) {
        if (moving.equals(bridgeBlock)) {
            makeMap(moving, MAP_O_CHARACTER, bridgeMap);
            return true;
        }
        makeMap(moving, MAP_X_CHARACTER, bridgeMap);
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameCommand) {
        return gameCommand.equals(RETRY_COMMAND_CHARACTER);
    }
}
