package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 해당 클래스에서 InputView, OutputView를 사용하지 않는다.
 * 필드(인스턴스 변수)를 추가할 수 있다.
 * 메서드의 이름은 변경할 수 없고, 인자와 반환타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위한 메서드를 추가할 수 있다.
 */
public class BridgeGame {
    private int tryCount = 1;
    private List<Boolean> movingResults;
    private List<String> bridge;

    BridgeGame(List<String> bridge) {
        movingResults = new ArrayList<>();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        int nexStep = movingResults.size();
        if (moving.equals(bridge.get(nexStep))) {
            movingResults.add(true);
            return;
        }
        movingResults.add(false);
    }

    public boolean getLastMovingResult() {
        int index = movingResults.size() - 1;
        return movingResults.get(index);
    }

    public void retry() {
        tryCount++;
        movingResults = new ArrayList<>();
    }

    public boolean isSucceed() {
        if (movingResults.size() != bridge.size()) {
            return false;
        }
        for (boolean movingResult : movingResults) {
            if (!movingResult) {
                return false;
            }
        }
        return true;
    }

    public String getGameResult() {
        if (isSucceed()) {
            return "성공";
        }
        return "실패";
    }

    public Map<String, List<String>> getMap() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> upMap = new ArrayList<>();
        List<String> downMap = new ArrayList<>();

        for (int i = 0; i < movingResults.size(); i++) {
            boolean movingResult = movingResults.get(i);
            String curBridge = bridge.get(i);
            if (movingResult) {
                if (curBridge.equals(BridgeEnum.U.name())) {
                    upMap.add("O");
                    downMap.add(" ");
                }
                if (curBridge.equals(BridgeEnum.D.name())) {
                    upMap.add(" ");
                    downMap.add("O");
                }
                continue;
            }
            if (curBridge.equals(BridgeEnum.U.name())) {
                upMap.add(" ");
                downMap.add("X");
            }
            if (curBridge.equals(BridgeEnum.D.name())) {
                upMap.add("X");
                downMap.add(" ");
            }
        }
        map.put("upMap", upMap);
        map.put("downMap", downMap);
        return map;
    }

    public int getTryCount() {
        return tryCount;
    }
}
