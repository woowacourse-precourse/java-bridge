package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private int onGoingCount;
    private int retryCount;
    private final HashMap<String, List<String>> result;

    BridgeGame(List<String> bridge) {
        this.bridge = new Bridge(bridge);

        result = new HashMap<>();
        List<String> uResult = new ArrayList<>();
        result.put("U", uResult);
        List<String> dResult = new ArrayList<>();
        result.put("D", dResult);
        retryCount = 1;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus move(String bridgeWord) {
        if (recordResult(bridgeWord, bridge.canCross(onGoingCount,bridgeWord))) {
            onGoingCount++;
            return checkGameStatus();
        }
        return GameStatus.GAME_OVER;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public GameStatus retry(String ruleWord) {
        if (ruleWord.equals("R")) {
            onGoingCount = 0;
            result.get("U").clear();
            result.get("D").clear();
            retryCount++;
            return GameStatus.GAME_ONGOING;
        }
        return GameStatus.GAME_GIVEUP;

    }

    public HashMap<String, List<String>> getResult() {
        return result;
    }

    private GameStatus checkGameStatus() {
        if (bridge.getBridgeSize() == onGoingCount) {
            return GameStatus.GAME_CLEAR;
        }
        return GameStatus.GAME_ONGOING;
    }

    public int getTryCount() {
        return retryCount;
    }

    private boolean recordResult(String bridgeWord, boolean isCross){
        String crossPlate = "D";
        String otherPlate = "U";
        String isSuccess = " X ";

        if (bridgeWord.equals("U")) {
            crossPlate = "U";
            otherPlate = "D";
        }
        if (isCross) {
            isSuccess = " O ";
        }
        result.get(crossPlate).add(isSuccess);
        result.get(otherPlate).add("   ");

        return  isCross;
    }

}

class Bridge {
    private final List<String> bridge;

    Bridge(List<String> bridge) {
        for (String plate : bridge) {
            if(!plate.equals("D") && !plate.equals("U")) {
                throw new IllegalArgumentException("[ERROR] bridge 생성 실패");
            }
        }
        this.bridge = bridge;
    }
    public boolean canCross(int plateIndex, String plateLocation){
        return bridge.get(plateIndex).equals(plateLocation);
    }

    public int getBridgeSize() {
        return bridge.size();
    }
}

enum GameStatus {
    GAME_OVER,
    GAME_ONGOING,
    GAME_GIVEUP,
    GAME_CLEAR
}