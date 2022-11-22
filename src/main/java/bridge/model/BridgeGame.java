package bridge.model;

import bridge.model.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int tryNumber = 0;
    private int tryGame;
    private List<String> selectedFoothold = new ArrayList<>();
    private List<String> upperRoad = new ArrayList<>();
    private List<String> lowerRoad = new ArrayList<>();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.tryGame = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInput) {
        if (userInput.equals(Command.UP.getValue())) {
            selectedFoothold.add(Command.UP.getValue());
        }
        if (userInput.equals(Command.DOWN.getValue())) {
            selectedFoothold.add(Command.DOWN.getValue());
        }
        tryNumber++;
        makeRoad();
    }

    public boolean isRightFoothold() {
        int index = tryNumber - 1;
        if (selectedFoothold.get(index) == bridge.get(index)) {
            return true;
        }
        return false;
    }

    private void makeRoad() {
        String result = Command.FAILURE.getValue();
        if (isRightFoothold()) {
            result = Command.SUCCESS.getValue();
        }
        makeUpperRoad(result);
        makeLowerRoad(result);
    }

    private void makeUpperRoad(String result) {
        if (selectedFoothold.get(selectedFoothold.size() - 1) == Command.UP.getValue()) {
            upperRoad.add(result);
            return;
        }
        upperRoad.add(" ");
    }

    private void makeLowerRoad(String result) {
        if (selectedFoothold.get(selectedFoothold.size() - 1) == Command.DOWN.getValue()) {
            lowerRoad.add(result);
            return;
        }
        lowerRoad.add(" ");
    }

    public boolean isGameEnd() {
        if (tryNumber == 0)
            return false;
        if (isRightFoothold() && tryNumber == bridge.size()) {
            return true;
        }
        return false;
    }

    public String getGameResult() {
        if (isGameEnd()) {
            return "성공";
        }
        return "실패";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        selectedFoothold.clear();
        upperRoad.clear();
        lowerRoad.clear();
        tryNumber = 0;
        tryGame++;
    }

    public List<String> getUpperRoad() {
        return upperRoad;
    }

    public List<String> getLowerRoad() {
        return lowerRoad;
    }

    public int getTryGame() {
        return tryGame;
    }
}
