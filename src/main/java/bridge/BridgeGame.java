package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void run() {
        List<String> bridge = createBridge();
        runGameSystem(bridge, 1);
    }

    public void runGameSystem(List<String> bridge, int countOfTry) {
        GameClear gameClear = new GameClear(move(bridge, "O"));
        if (gameClear.get())
            return;
        if (willRetry())
            retry(bridge, countOfTry);
    }

    private List<String> createBridge() {
        int bridgeSize = new BridgeSize().get();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private boolean move(List<String> bridge, String result) {
        Map<String, String> gameResult = initializeGameResult(new HashMap<>());
        for (int space = 0; space < bridge.size() && canMove(result); space++) {
            result = compareMoving(bridge.get(space));
            updateBridgeOverTime(gameResult, bridge.get(space), result);
        }
        return isWin(gameResult, result);
    }

    private Map<String, String> updateBridgeOverTime(Map<String, String> gameResult, String direction, String result) {
        addGameResult(gameResult, direction, result);
        createPrintMap(gameResult);
        return gameResult;
    }

    private boolean canMove(String result) {
        if (result.equals("X"))
            return false;
        return true;
    }

    private String compareMoving(String eachBridgeSpace) {
        String moving = new Moving().get();
        if (eachBridgeSpace.equals(moving))
            return "O";
        return "X";
    }

    private Map<String, String> initializeGameResult(Map<String, String> gameResult) {
        gameResult.put("U", "");
        gameResult.put("D", "");
        return gameResult;
    }

    private Map<String, String> addGameResult(Map<String, String> gameResult, String direction, String result) {
        if (isUp(direction, result)) {
            gameResult.put("U", gameResult.get("U") + result);
            gameResult.put("D", gameResult.get("D") + " ");
            return gameResult;
        }
        gameResult.put("U", gameResult.get("U") + " ");
        gameResult.put("D", gameResult.get("D") + result);
        return gameResult;
    }

    private boolean isUp(String direction, String result) {
        if (direction.equals("U") && result.equals("O"))
            return true;
        if (direction.equals("D") && result.equals("X"))
            return true;
        return false;
    }

    private void createPrintMap(Map<String, String> gameResult) {
        MoveResult moveResult = new MoveResult(gameResult);
        moveResult.printMap();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry(List<String> bridge, int countOfTry) {
        runGameSystem(bridge, countOfTry + 1);
    }

    private boolean isWin(Map<String, String> gameResult, String result) {
        if (result.equals("O"))
            return true;
        return false;
    }

    private boolean willRetry() {
        String command = new GameCommand().get();
        if (command.equals("R"))
            return true;
        return false;
    }
}