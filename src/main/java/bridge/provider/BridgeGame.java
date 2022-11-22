package bridge.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final List<String> direction = new ArrayList<>();

    private int tryCount = 1;


    public BridgeGame(final String size) {
        bridge = new Bridge(size);
    }

    public void move(final String InputDirection) { //플레이어의 입력 문자
        checkValidMoving(InputDirection);
        direction.add(InputDirection);
    }

    public List<String> getDirection() {
        return direction;
    }

    public int getBridgePosition() {
        return bridge.getSize();
    }

    private int getBridgeEndPosition() {
        return bridge.getSize() - 1;
    }

    private boolean isEqualsEndPosition() {
        return isEqualsTo(direction.size() - 1);
    }

    public boolean isEqualsTo(int index) {
        return direction.get(index).equals(bridge.getBridge(index));
    }


    public boolean isStillMoving() {
        if (direction.isEmpty()) {
            return true;
        }
        return isEqualsEndPosition() && bridge.getSize() != direction.size();
    }

    public boolean isGameWinning() {
        return isEqualsEndPosition() && bridge.getSize() == direction.size();
    }

    public String finalResult() {
        if (isGameWinning()) {
            return "성공";
        }
        return "실패";
    }

    private void checkValidMoving(final String InputDirection) {
        if (InputDirection != "U" || InputDirection != "D") {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void retry(final String InputCommand) {
        checkValidCommand(InputCommand);
        if (InputCommand.equals("재시도")) {
            direction.clear();
        }
    }

    private void checkValidCommand(final String InputCommand) {
        if (InputCommand != "R" || InputCommand != "Q") {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public void addTryCount() {
        tryCount += 1;
    }
}
