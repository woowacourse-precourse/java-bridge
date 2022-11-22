package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int numberOfTry = 0;
    private List<String> bridge;
    private List<String> playerCommand = new ArrayList<>();
    private String status = "진행중";

    BridgeGame(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        playerCommand.add(command);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            playerCommand.clear();
            status = "진행중";
        }
    }

    public String calculateStatus() {
        if (bridge.get(playerCommand.size() - 1).equals(playerCommand.get(playerCommand.size() - 1))) {
            if (bridge.size() == playerCommand.size()) {
                return "성공";
            }
            return "진행중";
        }
        return "실패";
    }

    public boolean keepGoing() {
        if (status.equals("진행중")) {
            return true;
        }
        return false;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getPlayerCommand() {
        return playerCommand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
