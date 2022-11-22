package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> topMap = new ArrayList<>();
    private List<String> downMap = new ArrayList<>();
    public static BridgeGame instance;

    private BridgeGame() {
    }

    public static BridgeGame getInstance() {
        if (instance == null) {
            instance = new BridgeGame();
        }
        return instance;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public boolean isClear(String bridgeSize) {
        int num = Integer.parseInt(bridgeSize);
        return getTopMap().size() == num && getTopMap().get(num - 1).equals(Map.CROSS_OK.getSymbol()) ||
                getDownMap().size() == num && getDownMap().get(num - 1).equals(Map.CROSS_OK.getSymbol());
    }

    public boolean isPlayerDead() {
        return getTopMap().contains(Map.CROSS_NO.getSymbol()) || getDownMap().contains(Map.CROSS_NO.getSymbol());
    }
    public void move(String userInput, List<String> bridge, int cnt) {
        if (isU(userInput)) {
            moveUp(userInput, bridge, cnt);
        }

        if (isD(userInput)) {
            moveDown(userInput, bridge, cnt);
        }
    }

    public List<String> getTopMap() {
        return topMap;
    }

    public List<String> getDownMap() {
        return downMap;
    }

    private void moveDown(String userInput, List<String> bridge, int cnt) {
        if (isAbleCross(bridge, cnt, userInput)) {
            ableMoveDown();
        }
        if(!isAbleCross(bridge,cnt,userInput)) {
            unAbleMoveDown();
        }
    }

    private void unAbleMoveDown() {
        topMap.add(Map.BLANK.getSymbol());
        downMap.add(Map.CROSS_NO.getSymbol());
    }

    private void ableMoveDown() {
        topMap.add(Map.BLANK.getSymbol());
        downMap.add(Map.CROSS_OK.getSymbol());
    }

    private void moveUp(String userInput, List<String> bridge, int cnt) {
        if (isAbleCross(bridge, cnt, userInput)) {
            ableMoveUp();
        }
        if (!isAbleCross(bridge, cnt, userInput)) {
            unAbleMoveUp();
        }
    }

    private void unAbleMoveUp() {
        topMap.add(Map.CROSS_NO.getSymbol());
        downMap.add(Map.BLANK.getSymbol());
    }

    private void ableMoveUp() {
        topMap.add(Map.CROSS_OK.getSymbol());
        downMap.add(Map.BLANK.getSymbol());
    }

    private boolean isAbleCross(List<String> bridge, int cnt, String userInput) {
        return bridge.get(cnt).equals(userInput);
    }

    private boolean isD(String userInput) {
        return userInput.equals("D");
    }

    private boolean isU(String userInput) {
        return userInput.equals("U");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    public void initMap() {
        topMap = new ArrayList<>();
        downMap = new ArrayList<>();
    }
}
